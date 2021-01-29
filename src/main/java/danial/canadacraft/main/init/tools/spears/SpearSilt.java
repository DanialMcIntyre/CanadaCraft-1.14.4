package danial.canadacraft.main.init.tools.spears;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SpearSilt extends SwordItem {

	public SpearSilt(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
	
	public boolean hitEntity(ItemStack item, LivingEntity target, LivingEntity attacker) {
		
		target.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 100, 5, true, true));		
		
		return super.hitEntity(item, target, attacker);
		
	}

}
