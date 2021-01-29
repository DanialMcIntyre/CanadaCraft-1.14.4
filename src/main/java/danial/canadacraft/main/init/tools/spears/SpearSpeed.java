package danial.canadacraft.main.init.tools.spears;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class SpearSpeed extends SwordItem {

	public SpearSpeed(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
	
	public boolean hitEntity(ItemStack item, LivingEntity target, LivingEntity attacker) {
		
		attacker.addPotionEffect(new EffectInstance(Effect.get(1), 50, 1, true, true));		
		
		return super.hitEntity(item, target, attacker);
		
	}

}