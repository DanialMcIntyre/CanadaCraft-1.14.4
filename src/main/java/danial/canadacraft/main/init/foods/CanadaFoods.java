package danial.canadacraft.main.init.foods;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class CanadaFoods {
	
	public static final Food beaver_tail;
	public static final Food cooked_beaver_tail;
	
	public static final Food moose_meat;
	public static final Food cooked_moose_meat;
	
	public static final Food grizzly_bear_meat;
	public static final Food cooked_grizzly_bear_meat;
	
	public static final Food plain_timbit;
	public static final Food choco_timbit;
	public static final Food jelly_timbit;
	public static final Food maple_timbit;
	
	public static final Food maple_syrup;
	public static final Food maple_sap;
	
	public static final Food corn;
	public static final Food pop_corn;
	
	public static final Food pancakes;
	public static final Food pancakes_syrup;
	
	public static final Food huckle_berries;
	public static final Food thimble_berries;
	public static final Food salmon_berries;
	public static final Food berry_salad;
	
	public static final Food poutine;
	
	static {

		beaver_tail = (new Food.Builder().hunger(3).saturation(0.6F).meat().build());
		cooked_beaver_tail = (new Food.Builder().hunger(8).saturation(1.7F).meat().build());
		moose_meat = (new Food.Builder().hunger(3).saturation(0.7F).meat().build());
		cooked_moose_meat = (new Food.Builder().hunger(10).saturation(2.0F).meat().build());
		grizzly_bear_meat = (new Food.Builder().hunger(3).saturation(0.6F).meat().build());
		cooked_grizzly_bear_meat = (new Food.Builder().hunger(8).saturation(1.7F).meat().build());
		
		plain_timbit = (new Food.Builder().hunger(2).saturation(0.2F).fastToEat().build());
		choco_timbit = (new Food.Builder().hunger(3).saturation(0.3F).fastToEat().build());
		jelly_timbit = (new Food.Builder().hunger(3).saturation(0.3F).fastToEat().build());
		maple_timbit = (new Food.Builder().hunger(3).saturation(0.3F).fastToEat().build());
		
		maple_sap = (new Food.Builder().hunger(2).saturation(0.2F).build());
		maple_syrup = (new Food.Builder().hunger(5).saturation(0.5F).build());

		corn = (new Food.Builder().hunger(3).saturation(0.3f).build());
		pop_corn = (new Food.Builder().hunger(6).saturation(0.6f).build());
		
		pancakes = (new Food.Builder().hunger(5).saturation(1f).build());
		pancakes_syrup = (new Food.Builder().hunger(7).saturation(2f).build());
		
		huckle_berries = (new Food.Builder().hunger(3).saturation(0.2F).build());
		thimble_berries = (new Food.Builder().hunger(3).saturation(0.2F).build());
		salmon_berries = (new Food.Builder().hunger(3).saturation(0.2F).build());
		berry_salad = (new Food.Builder().hunger(6).saturation(2.0F).fastToEat().setAlwaysEdible().effect(new EffectInstance(Effects.REGENERATION, 200, 1), 1.0F).build());
	
		poutine = (new Food.Builder().hunger(8).saturation(1.5F).fastToEat()).build();
		
	}

}