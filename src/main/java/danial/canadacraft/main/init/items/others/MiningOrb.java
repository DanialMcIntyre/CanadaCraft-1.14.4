package danial.canadacraft.main.init.items.others;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MiningOrb extends Item {

	public MiningOrb(Properties properties) {
		
		super(properties);
		
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		if (!playerIn.abilities.isCreativeMode) {
			
			itemstack.shrink(1);
		
		}
		
		((LivingEntity) playerIn).addPotionEffect(new EffectInstance(Effects.HASTE, 2400, 1, true, true));
		((LivingEntity) playerIn).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 2400, 2, true, true));

		return super.onItemRightClick(worldIn, playerIn, handIn);

	}

}
