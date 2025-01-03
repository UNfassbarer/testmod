package unfassbarer.testmod.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import unfassbarer.testmod.block.TestModBlocks;
import unfassbarer.testmod.recipe.MoonAltarRecipe;
import unfassbarer.testmod.screen.MoonAltarScreenHandler;

import java.util.Optional;

public class MoonAltarEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 8000;

    public MoonAltarEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MOON_ALTAR_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> MoonAltarEntity.this.progress;
                    case 1 -> MoonAltarEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> MoonAltarEntity.this.progress = value;
                    case 1 -> MoonAltarEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    public ItemStack getRenderStack() {
        if(this.getStack(OUTPUT_SLOT).isEmpty()) {
            return this.getStack(INPUT_SLOT);
        } else {
            return this.getStack(OUTPUT_SLOT);
        }
    }

    @Override
    public void markDirty() {
        world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        super.markDirty();
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Moon Altar");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("gem_polishing_station.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("gem_polishing_station.progress");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MoonAltarScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            spawnNightParticles(world, pos);
            return;
        }

        long timeOfDay = world.getTimeOfDay() % 24000;

        // Bedingungen prüfen
        boolean isNight = timeOfDay >= 13000 && timeOfDay <= 23000;
        boolean validStructure = isValidStructure(world, pos);
        boolean hasInputItem = !this.getStack(INPUT_SLOT).isEmpty();

        // Fortschritt zurücksetzen, wenn Bedingungen nicht erfüllt sind
        if (!isNight || !validStructure || !hasInputItem) {
            resetProgress();
            markDirty(world, pos, state);
            return;
        }

        // Fortschritt nur nachts und bei gültigen Bedingungen
        if (this.hasRecipe()) {
            progress++;

            if (hasCraftingFinished()) {
                craftItem();
                resetProgress(); // Fortschritt zurücksetzen, wenn Crafting abgeschlossen
            }
            markDirty(world, pos, state);
        } else {
            resetProgress();
        }
    }

    private void spawnNightParticles(World world, BlockPos pos) {
        // Bedingungen: Welt ist Client-seitig, es ist Nacht, und Struktur ist gültig
        long timeOfDay = world.getTimeOfDay() % 24000; // Aktuelle Zeit im Tageszyklus
        boolean isNight = timeOfDay >= 13000 && timeOfDay <= 23000; // Nachtprüfung

        if (!world.isClient() || !isNight || !isValidStructure(world, pos)) {
            return; // Keine Partikel ohne gültige Bedingungen
        }

        for (int i = 0; i < 5; i++) { // Anzahl der Partikel pro Tick
            double offsetX = (world.random.nextDouble() - 0.5) * 2.0; // Bereich um den Altar (-1 bis 1)
            double offsetY = world.random.nextDouble() * 0.5 + 0.5;   // Über dem Altar (0.5 bis 1.0)
            double offsetZ = (world.random.nextDouble() - 0.5) * 2.0;

            world.addParticle(
                    net.minecraft.particle.ParticleTypes.ENCHANT,
                    pos.getX() + 0.5 + offsetX,
                    pos.getY() + offsetY,
                    pos.getZ() + 0.5 + offsetZ,
                    0,0,0
            );
        }
    }
    private boolean isValidStructure(World world, BlockPos pos) {
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                BlockPos checkPos = pos.add(x, -1, z); // 1 Block unterhalb des Altars
                if (!world.getBlockState(checkPos).isOf(TestModBlocks.Ardenim_Block)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<RecipeEntry<MoonAltarRecipe>> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT, 1);

        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private boolean hasRecipe() {
        if (!isValidStructure(this.world, this.pos)) {
            return false; // Strukturprüfung fehlgeschlagen
        }

        Optional<RecipeEntry<MoonAltarRecipe>> recipe = getCurrentRecipe();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null))
                && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }


    private Optional<RecipeEntry<MoonAltarRecipe>> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for(int i = 0; i < this.size(); i++) {
            inv.setStack(i, this.getStack(i));
        }

        return getWorld().getRecipeManager().getFirstMatch(MoonAltarRecipe.Type.INSTANCE, inv, getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}