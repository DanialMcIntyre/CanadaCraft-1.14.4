package danial.canadacraft.main;

import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTab extends ItemGroup {

	public CreativeTab() {

		super("canada");

	}

	@Override
	public ItemStack createIcon() {

		return new ItemStack(CanadaItems.maple_leaf);

	}

}
