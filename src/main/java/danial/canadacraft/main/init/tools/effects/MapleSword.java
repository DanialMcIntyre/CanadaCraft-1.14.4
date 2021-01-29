package danial.canadacraft.main.init.tools.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class MapleSword extends SwordItem {

	public MapleSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
	
	public boolean hitEntity(ItemStack item, LivingEntity target, LivingEntity attacker) {
		
		attacker.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 1, 0, true, true));
		attacker.addPotionEffect(new EffectInstance(Effect.get(23), 1, 1, true, true));
		
		return super.hitEntity(item, target, attacker);
		
	}

}
