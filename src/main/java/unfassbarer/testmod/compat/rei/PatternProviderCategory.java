package unfassbarer.testmod.compat.rei;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import unfassbarer.testmod.Testmod;
import unfassbarer.testmod.block.TestModBlocks;

import java.util.LinkedList;
import java.util.List;

public class PatternProviderCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE =
            new Identifier(Testmod.MOD_ID, "textures/gui/pattern_provider_gui.png");
    public static final CategoryIdentifier<PatternProviderDisplay> PATTERN_PROVIDING =
            CategoryIdentifier.of(Testmod.MOD_ID, "pattern_providing");
    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return PATTERN_PROVIDING;
    }
    @Override
    public Text getTitle() {
        return Text.literal("Pattern Provider");
    }
    @Override
    public Renderer getIcon() {
        return EntryStacks.of(TestModBlocks.PatternProvider.asItem().getDefaultStack());
    }
    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        final Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        List<Widget> widgets = new LinkedList<>();
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 82)));
        // Setting up the input slots
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 8, startPoint.y + 8))
                .entries(display.getInputEntries().get(1)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 8))
                .entries(display.getInputEntries().get(0)));
        // Setting up the output slot
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 59))
                .markOutput().entries(display.getOutputEntries().get(0)));
        return widgets;
    }
    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
