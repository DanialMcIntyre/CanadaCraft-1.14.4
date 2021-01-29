package danial.canadacraft.main.init.items.fuels;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TallBlockItem;

public class CanadaTallBlockFuels extends TallBlockItem {

	public CanadaTallBlockFuels(Block blockIn, Properties builder) {
		
		super(blockIn, builder);
		
	}

	@Override
	public int getBurnTime(ItemStack itemstack) {
		
		return 400;
		
	}

}
