package danial.canadacraft.main.init.armor;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterials implements IArmorMaterial {
	
	moose("moose", 30, new int[] {1,3,4,1}, 30, CanadaItems.moose_fur, "item.armor.equip_leather", 0.0f),
	enhanced_moose("enhanced_moose", 94, new int[] {2,5,6,3}, 30, CanadaItems.gypsum, "item.armor.equip_leather", 2.0f),
	beaver("beaver", 43, new int[] {1,0,0,0}, 30, CanadaItems.beaver_fur, "item.armor.equip_leather", 0.0f),
	canada("canada", 133, new int[] {4, 7, 9, 5}, 15, CanadaItems.canada_gem, "item.armor.equip_diamond", 4.0f),
	bear("bear", 94, new int[] {1, 4, 5, 1}, 20, CanadaItems.grizzly_bear_claw, "item.armor.equip_leather", 1.0f),
	maple("maple", 144, new int[] {4,4,4,4}, 10, CanadaItems.maple_gem, "item.armor.equip_diamond", 2.0f),
	berry("berry", 144, new int[] {3,3,3,3}, 10, CanadaItems.berry_gem, "item.armor.equip_diamond", 2.0f),
	silt("silt_stone", 144, new int[] {6,6,6,6}, 10, CanadaItems.silt_stone_gem, "item.armor.equip_diamond", 2.0f),
	maple_leaf("maple_leaf", 144, new int[] {10,10,10,10}, 10, null, "item.armor.equip_diamond", 2.0f);

	private static final int[] max_damage_array = new int[] {13, 15, 14, 12};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	private ArmorMaterials(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) {
		
		this.name = name;
		this.equipSound = equipSound;
		this.damageReductionAmounts = damageReductionAmounts;
		this.enchantability = enchantability;
		this.durability = durability;
		this.toughness = toughness;
		this.repairItem = repairItem;
		
	}
	
	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) {
		
		return this.damageReductionAmounts[slot.getIndex()];
		
	}


	@Override
	public int getDurability(EquipmentSlotType slot) {
		
		return max_damage_array[slot.getIndex()] * this.durability;
		
	}
	
	@Override
	public int getEnchantability() {
		
		return this.enchantability;
		
	}

	@Override
	public SoundEvent getSoundEvent() {
		
		return new SoundEvent(new ResourceLocation(equipSound));
		
	}

	@Override
	public Ingredient getRepairMaterial() {
		
		return Ingredient.fromItems(this.repairItem);
		
	}

	@Override
	public String getName() {

		return Main.MODID + ":" + this.name;
		
	}

	@Override
	public float getToughness() {
	
		return this.toughness;
		
	}	

}
