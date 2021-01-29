package danial.canadacraft.main.init.foods;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class BowlFoods extends Item {

	public BowlFoods(Properties properties) {

		super(properties);

	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {

		super.onItemUseFinish(stack, worldIn, entityLiving);
		return new ItemStack(Items.BOWL);

	}

}