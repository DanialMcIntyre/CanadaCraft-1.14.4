package danial.canadacraft.main.init.tools.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class GypsumBlade extends SwordItem {

	public GypsumBlade(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
	
	public boolean hitEntity(ItemStack item, LivingEntity target, LivingEntity attacker) {
		
		target.addPotionEffect(new EffectInstance(Effect.get(2), 40, 1, true, true));		
		
		return super.hitEntity(item, target, attacker);
		
	}

}
