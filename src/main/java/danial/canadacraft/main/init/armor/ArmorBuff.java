package danial.canadacraft.main.init.armor;

import danial.canadacraft.main.init.blocks.CanadaBlocks;
import danial.canadacraft.main.init.enchantments.BolsterEnchantment;
import danial.canadacraft.main.init.enchantments.BolsterEnchantment.BolsterEquipped;
import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ArmorBuff extends ArmorItem {
	
	public ArmorBuff(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		
		super(materialIn, slot, builder);
		
	}

	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		
		if(!world.isRemote) {
			
			BolsterEquipped power = new BolsterEnchantment.BolsterEquipped();
			int increase = power.getpower();

			//Moose
			boolean isMooseChestplateOn = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(CanadaItems.moose_chestplate);
			boolean isMooseLeggingsOn = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(CanadaItems.moose_leggings);
			boolean isMooseHelmetOn = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(CanadaItems.moose_helmet);
			boolean isMooseBootsOn = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(CanadaItems.moose_boots);
			
			//Enhanced Moose
			boolean isEnhancedChestplateOn = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(CanadaItems.enhanced_moose_chestplate);
			boolean isEnhancedLeggingsOn = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(CanadaItems.enhanced_moose_leggings);
			boolean isEnhancedHelmetOn = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(CanadaItems.enhanced_moose_helmet);
			boolean isEnhancedBootsOn = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(CanadaItems.enhanced_moose_boots);

			//Beaver
			boolean isArmyHatOn = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(CanadaItems.army_hat);
			boolean isClericalHatOn = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(CanadaItems.clerical_hat);
			boolean isContinentalHatOn = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(CanadaItems.continental_hat);
			boolean isNavyHatOn = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(CanadaItems.navy_hat);
			boolean isRegentHatOn = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(CanadaItems.regent_hat);

			//Bear Claw
			boolean isBearChestplateOn = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(CanadaItems.bear_chestplate);
			boolean isBearLeggingsOn = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(CanadaItems.bear_leggings);
			boolean isBearHelmetOn = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(CanadaItems.bear_helmet);
			boolean isBearBootsOn = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(CanadaItems.bear_boots);

			//Maple Helmet
			boolean isMapleHelmetOn = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem().equals(CanadaItems.maple_helmet);
		
			boolean isMapleLeafChestplateOn = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem().equals(CanadaItems.maple_leaf_chestplate);
			
			//Siltstone Pants
			boolean isSiltstoneLeggingsOn = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem().equals(CanadaItems.silt_stone_leggings);
				
			//Berry Boots
			boolean isBerryBootsOn = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(CanadaItems.berry_boots);
			
			boolean isPick = player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem().equals(Items.WOODEN_PICKAXE)
					|| player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem().equals(Items.STONE_PICKAXE)
					|| player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem().equals(Items.GOLDEN_PICKAXE)
					|| player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem().equals(Items.IRON_PICKAXE)
					|| player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem().equals(Items.DIAMOND_PICKAXE)
					|| player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem().equals(CanadaItems.antler_pickaxe)
					|| player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem().equals(CanadaItems.canada_pickaxe)
					|| player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).getItem().equals(CanadaItems.silt_stone_pickaxe);

			if(isMooseChestplateOn == true && isMooseLeggingsOn == true && isMooseHelmetOn == true && isMooseBootsOn == true) {
				
				player.addPotionEffect(new EffectInstance(Effect.get(5), 100, 0, true, true));
				
			}
			
			if(isEnhancedChestplateOn && isEnhancedLeggingsOn && isEnhancedHelmetOn && isEnhancedBootsOn) {
				
				player.addPotionEffect(new EffectInstance(Effect.get(5), 100, 1, true, true));
				
			}
			
			if(isArmyHatOn) {
				
				player.addPotionEffect(new EffectInstance(Effect.get(5), 100, 0 + increase, true, true));

			}
			
			if(isClericalHatOn) {
				
				player.addPotionEffect(new EffectInstance(Effect.get(32), 100, 0 + increase, true, true));
				player.addPotionEffect(new EffectInstance(Effect.get(18), 100, 0 + increase, true, true));

			}
			
			if(isContinentalHatOn) {
				
				player.addPotionEffect(new EffectInstance(Effect.get(1), 100, 0 + increase, true, true));

			}
			
			if(isNavyHatOn) {
				
				player.addPotionEffect(new EffectInstance(Effect.get(13), 100, 0 + increase, true, true));
				player.addPotionEffect(new EffectInstance(Effect.get(30), 100, 0 + increase, true, true));

			}
			
			if(isRegentHatOn) {
				
				player.addPotionEffect(new EffectInstance(Effect.get(3), 100, 0 + increase, true, true));

			}
			
			if(isBearHelmetOn && isBearChestplateOn && isBearLeggingsOn && isBearBootsOn) {
				
				player.addPotionEffect(new EffectInstance(Effect.get(1), 100, 0, true, true));
				player.addPotionEffect(new EffectInstance(Effect.get(3), 100, 0, true, true));
				
			}
			
			if(isMapleHelmetOn) {
				
				player.addPotionEffect(new EffectInstance(Effects.SATURATION, 100, 0, true, true));
				
			}
			
			if(isBerryBootsOn) {
				
				int i = MathHelper.floor(player.posX);
				int j = MathHelper.floor(player.posY);
				int k = MathHelper.floor(player.posZ);

				BlockState blockstate = CanadaBlocks.berry_mush.getDefaultState();

				for (int l = 0; l < 4; ++l) {
					
					i = MathHelper.floor(player.posX + (double) ((float) (l % 2 * 2 - 1) * 0.25F));
					j = MathHelper.floor(player.posY);
					k = MathHelper.floor(player.posZ + (double) ((float) (l / 2 % 2 * 2 - 1) * 0.25F));
					BlockPos blockpos = new BlockPos(i, j, k);
					
					if (player.world.isAirBlock(blockpos) && blockstate.isValidPosition(player.world, blockpos)) {
						
						player.world.setBlockState(blockpos, blockstate);
						
					}
					
				}
				
			}
			
			if(isSiltstoneLeggingsOn) {
				
				if (isPick) {
					
					player.addPotionEffect(new EffectInstance(Effects.HASTE, 1, 2, true, true));
					
				}
				
			}
			
			if(isMapleHelmetOn && isMapleLeafChestplateOn && isSiltstoneLeggingsOn && isBerryBootsOn) {
				
				player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 1, 0, true, true));
				
			}
			
		}
		
	}
	
}
