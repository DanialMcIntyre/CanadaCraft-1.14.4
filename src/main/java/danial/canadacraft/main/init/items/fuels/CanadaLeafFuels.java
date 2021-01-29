package danial.canadacraft.main.init.items.fuels;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class CanadaLeafFuels extends BlockItem {
	
	public CanadaLeafFuels(Block blockIn, Properties builder) {
		
		super(blockIn, builder);
		
	}

	@Override
	public int getBurnTime(ItemStack itemstack) {
		
		return 150;
		
	}

}
