package danial.canadacraft.main.init.tools;

import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterials implements IItemTier {

	antler(5.0f, 6.0f, 700, 1, 30, CanadaItems.moose_antlers),
	gypsum(5.0f, 8.0f, 2550, 2, 10, CanadaItems.gypsum),
	canada(7.0f, 9.0f, 3387, 3, 25, CanadaItems.canada_gem),
	bear(5.0f, 5.0f, 842, 1, 5, CanadaItems.grizzly_bear_claw),
	snow(0.0f, 0.0f, 100, 0, 0, CanadaItems.moose_antlers),
	maple(8.0f, 9.0f, 1867, 2, 10, CanadaItems.maple_gem),
	berry(8.0f, 8.0f, 1867, 2, 10, CanadaItems.berry_gem),
	silt(8.0f, 8.0f, 1867, 2, 23, CanadaItems.silt_stone_gem);
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	
	private ToolMaterials(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
		
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
		
	}


	@Override
	public int getMaxUses() {
		
		return this.durability;
	
	}


	@Override
	public float getEfficiency() {

		return this.efficiency;
		
	}


	@Override
	public float getAttackDamage() {
		
		return this.attackDamage;
		
	}


	@Override
	public int getHarvestLevel() {
		
		return this.harvestLevel;
		
	}


	@Override
	public int getEnchantability() {
		
		return this.enchantability;
		
	}


	@Override
	public Ingredient getRepairMaterial() {
		
		return Ingredient.fromItems(this.repairMaterial);
		
	}
	
}
