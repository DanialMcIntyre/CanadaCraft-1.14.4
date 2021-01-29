package danial.canadacraft.main.init.enchantments;

import danial.canadacraft.main.Main;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class SiltstonePowerEnchantment extends Enchantment {

	protected SiltstonePowerEnchantment(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
		
		super(rarityIn, EnchantmentType.DIGGER, slots);
		
	}

	@Override
	public int getMaxLevel() {

		return 3;

	}

	@Override
	public int getMinLevel() {

		return 1;

	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {

		return true;

	}
	
	public boolean canApplyTogether(Enchantment ench) {

		return super.canApplyTogether(ench) && ench != Enchantments.AQUA_AFFINITY
				&& ench != Enchantments.BANE_OF_ARTHROPODS && ench != Enchantments.BINDING_CURSE
				&& ench != Enchantments.BLAST_PROTECTION && ench != Enchantments.CHANNELING
				&& ench != Enchantments.DEPTH_STRIDER && ench != Enchantments.EFFICIENCY
				&& ench != Enchantments.FEATHER_FALLING && ench != Enchantments.FIRE_ASPECT
				&& ench != Enchantments.FIRE_PROTECTION && ench != Enchantments.FLAME && ench != Enchantments.FORTUNE
				&& ench != Enchantments.FROST_WALKER && ench != Enchantments.IMPALING && ench != Enchantments.INFINITY
				&& ench != Enchantments.LOOTING && ench != Enchantments.KNOCKBACK && ench != Enchantments.LOYALTY
				&& ench != Enchantments.LURE && ench != Enchantments.MENDING && ench != Enchantments.MULTISHOT
				&& ench != Enchantments.PIERCING && ench != Enchantments.POWER
				&& ench != Enchantments.PROJECTILE_PROTECTION && ench != Enchantments.PROTECTION
				&& ench != Enchantments.PUNCH && ench != Enchantments.PUNCH && ench != Enchantments.QUICK_CHARGE
				&& ench != Enchantments.RESPIRATION && ench != Enchantments.RIPTIDE && ench != Enchantments.SHARPNESS
				&& ench != Enchantments.SILK_TOUCH && ench != Enchantments.SMITE && ench != Enchantments.SWEEPING
				&& ench != Enchantments.THORNS && ench != Enchantments.UNBREAKING
				&& ench != Enchantments.VANISHING_CURSE;

	}

	@Mod.EventBusSubscriber(modid = Main.MODID, bus = Bus.FORGE)
	public static class SiltstonePowerEquipped {

		private static int power;

		@SubscribeEvent
		public static void givePower(PlayerTickEvent event) {

			PlayerEntity playerIn = event.player;

			if (playerIn.hasItemInSlot(EquipmentSlotType.MAINHAND)) {

				if (EnchantmentHelper.getEnchantmentLevel(CanadaEnchantments.SILTSTONEPOWER.get(), playerIn.getItemStackFromSlot(EquipmentSlotType.MAINHAND)) == 1) {

					power = 1;

				} else if (EnchantmentHelper.getEnchantmentLevel(CanadaEnchantments.SILTSTONEPOWER.get(), playerIn.getItemStackFromSlot(EquipmentSlotType.MAINHAND)) == 2) {

					power = 2;

				} else if (EnchantmentHelper.getEnchantmentLevel(CanadaEnchantments.SILTSTONEPOWER.get(), playerIn.getItemStackFromSlot(EquipmentSlotType.MAINHAND)) == 3) {

					power = 3;

				} else {

					power = 0;

				}
				
			}
			
		}

		public int getpower() {

			return SiltstonePowerEquipped.power;

		}
		
	}
	
}