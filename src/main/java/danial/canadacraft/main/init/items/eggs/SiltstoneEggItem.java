package danial.canadacraft.main.init.items.eggs;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class SiltstoneEggItem extends BlockItem {

	public SiltstoneEggItem(Block blockIn, Properties builder) {
		
		super(blockIn, builder);
		
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
	
		tooltip.add(new StringTextComponent("\u00A77" + "What is this used for?" + "\u00A77"));
		
	}

}
