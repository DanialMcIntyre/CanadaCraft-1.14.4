package danial.canadacraft.main.init.items;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.init.armor.ArmorBuff;
import danial.canadacraft.main.init.armor.ArmorMaterials;
import danial.canadacraft.main.init.armor.armormodel.ArmyHat;
import danial.canadacraft.main.init.armor.armormodel.ClericalHat;
import danial.canadacraft.main.init.armor.armormodel.ContinentalHat;
import danial.canadacraft.main.init.armor.armormodel.NavyHat;
import danial.canadacraft.main.init.armor.armormodel.RegentHat;
import danial.canadacraft.main.init.blocks.CanadaBlocks;
import danial.canadacraft.main.init.entities.CanadaEntities;
import danial.canadacraft.main.init.fluids.CanadaFluids;
import danial.canadacraft.main.init.foods.BottleFoods;
import danial.canadacraft.main.init.foods.BowlFoods;
import danial.canadacraft.main.init.foods.CanadaFoods;
import danial.canadacraft.main.init.items.eggs.BerryEggItem;
import danial.canadacraft.main.init.items.eggs.MapleEggItem;
import danial.canadacraft.main.init.items.eggs.SiltstoneEggItem;
import danial.canadacraft.main.init.items.fuels.CanadaBlockFuels;
import danial.canadacraft.main.init.items.fuels.CanadaLeafFuels;
import danial.canadacraft.main.init.items.fuels.CanadaTallBlockFuels;
import danial.canadacraft.main.init.items.music.CanadaMusicDisc;
import danial.canadacraft.main.init.items.others.MiningOrb;
import danial.canadacraft.main.init.sounds.SoundsHandler;
import danial.canadacraft.main.init.tools.ToolMaterials;
import danial.canadacraft.main.init.tools.effects.BerryHoe;
import danial.canadacraft.main.init.tools.effects.GypsumBlade;
import danial.canadacraft.main.init.tools.effects.MapleSword;
import danial.canadacraft.main.init.tools.effects.SiltstonePick;
import danial.canadacraft.main.init.tools.spears.SpearBleed;
import danial.canadacraft.main.init.tools.spears.SpearCanada;
import danial.canadacraft.main.init.tools.spears.SpearMaple;
import danial.canadacraft.main.init.tools.spears.SpearSilt;
import danial.canadacraft.main.init.tools.spears.SpearSlow;
import danial.canadacraft.main.init.tools.spears.SpearSpeed;
import danial.canadacraft.main.init.tools.staffs.SnowStaff;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.WallOrFloorItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ItemRegistry {
		
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			
			event.getRegistry().registerAll(
		
					//Foods
					CanadaItems.beaver_tail = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.beaver_tail)).setRegistryName(Main.location("beaver_tail")),
					CanadaItems.cooked_beaver_tail = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.cooked_beaver_tail)).setRegistryName(Main.location("cooked_beaver_tail")),
					CanadaItems.moose_meat = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.moose_meat)).setRegistryName(Main.location("moose_meat")),
					CanadaItems.cooked_moose_meat = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.cooked_moose_meat)).setRegistryName(Main.location("cooked_moose_meat")),
					CanadaItems.grizzly_bear_meat = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.grizzly_bear_meat)).setRegistryName(Main.location("grizzly_bear_meat")),
					CanadaItems.cooked_grizzly_bear_meat = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.cooked_grizzly_bear_meat)).setRegistryName(Main.location("cooked_grizzly_bear_meat")),
					
					CanadaItems.plain_timbit = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.plain_timbit)).setRegistryName(Main.location("plain_timbit")),
					CanadaItems.choco_timbit = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.choco_timbit)).setRegistryName(Main.location("choco_timbit")),
					CanadaItems.jelly_timbit = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.jelly_timbit)).setRegistryName(Main.location("jelly_timbit")),
					CanadaItems.maple_timbit = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.maple_timbit)).setRegistryName(Main.location("maple_timbit")),

					CanadaItems.corn_seeds = new BlockNamedItem(CanadaBlocks.corn_crop, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("corn_seeds")),
					CanadaItems.corn = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.corn)).setRegistryName(Main.location("corn")),
					CanadaItems.corn_grass = new BlockNamedItem(CanadaBlocks.corn_grass, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("corn_grass")),
					CanadaItems.pop_corn = new BowlFoods(new Item.Properties().group(Main.CANADA).food(CanadaFoods.pop_corn).maxStackSize(16)).setRegistryName(Main.location("pop_corn")),
					
					CanadaItems.maple_syrup = new BottleFoods(new Item.Properties().group(Main.CANADA).food(CanadaFoods.maple_syrup).maxStackSize(1)).setRegistryName(Main.location("maple_syrup")),
					CanadaItems.maple_sap = new BottleFoods(new Item.Properties().group(Main.CANADA).food(CanadaFoods.maple_sap).maxStackSize(1)).setRegistryName(Main.location("maple_sap")),
					
					CanadaItems.pancakes = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.pancakes)).setRegistryName(Main.location("pancakes")),
					CanadaItems.pancakes_syrup = new Item(new Item.Properties().group(Main.CANADA).food(CanadaFoods.pancakes_syrup)).setRegistryName(Main.location("pancakes_syrup")),
					
					CanadaItems.huckle_berries = new BlockNamedItem(CanadaBlocks.huckle_berries, new Item.Properties().group(Main.CANADA).food(CanadaFoods.huckle_berries)).setRegistryName(Main.location("huckle_berries")),
					CanadaItems.thimble_berries = new BlockNamedItem(CanadaBlocks.thimble_berries, new Item.Properties().group(Main.CANADA).food(CanadaFoods.thimble_berries)).setRegistryName(Main.location("thimble_berries")),
					CanadaItems.salmon_berries = new BlockNamedItem(CanadaBlocks.salmon_berries, new Item.Properties().group(Main.CANADA).food(CanadaFoods.salmon_berries)).setRegistryName(Main.location("salmon_berries")),
					CanadaItems.berry_salad = new BowlFoods(new Item.Properties().group(Main.CANADA).food(CanadaFoods.berry_salad).maxStackSize(16)).setRegistryName(Main.location("berry_salad")),
					
					CanadaItems.poutine = new BowlFoods(new Item.Properties().group(Main.CANADA).food(CanadaFoods.poutine).maxStackSize(16)).setRegistryName(Main.location("poutine")),
					
					CanadaItems.maple_cake = new BlockNamedItem(CanadaBlocks.maple_cake, new Item.Properties().group(Main.CANADA).maxStackSize(1)).setRegistryName(Main.location("maple_cake")),
					CanadaItems.berry_cake = new BlockNamedItem(CanadaBlocks.berry_cake, new Item.Properties().group(Main.CANADA).maxStackSize(1)).setRegistryName(Main.location("berry_cake")),
												
					//Items
					CanadaItems.canada_portal_dust = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_portal_dust")),
					CanadaItems.gypsum = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("gypsum")),
					CanadaItems.maple_leaf = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_leaf")),
					CanadaItems.canada_gem = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_gem")),
					CanadaItems.maple_gem = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_gem")),
					CanadaItems.berry_gem = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("berry_gem")),
					CanadaItems.silt_stone_gem = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_gem")),
					CanadaItems.canada_key = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_key")),
					CanadaItems.berry_ball = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("berry_ball")),
					CanadaItems.mining_orb = new MiningOrb(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("mining_orb")),
					CanadaItems.moose_antlers = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("moose_antlers")),
					CanadaItems.moose_fur = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("moose_fur")),
					CanadaItems.beaver_fur = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("beaver_fur")),
					CanadaItems.grizzly_bear_claw = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("grizzly_bear_claw")),	
					CanadaItems.trillium = new BlockItem(CanadaBlocks.trillium, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trillium")),
					CanadaItems.loonie = new Item(new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("loonie")),
					CanadaItems.canada_disc = new CanadaMusicDisc(1, SoundsHandler.CANADA_ANTHEM, new Item.Properties().group(Main.CANADA).maxStackSize(1)).setRegistryName(Main.location("canada_disc")),
					
					//Blocks
					
					//Fluids	
					CanadaItems.maple_bucket = new BucketItem(() -> CanadaFluids.maple, new Item.Properties().maxStackSize(1).group(Main.CANADA)).setRegistryName(Main.location("maple_bucket")),	
					CanadaItems.berry_bucket = new BucketItem(() -> CanadaFluids.berry, new Item.Properties().maxStackSize(1).group(Main.CANADA)).setRegistryName(Main.location("berry_bucket")),
					CanadaItems.oil_bucket = new BucketItem(() -> CanadaFluids.oil, new Item.Properties().maxStackSize(1).group(Main.CANADA)).setRegistryName(Main.location("oil_bucket")),	
							
					CanadaItems.berry_mush = new BlockItem(CanadaBlocks.berry_mush, new Item.Properties().group(Main.CANADA)).setRegistryName("berry_mush"),
					
					//Siltstone
					CanadaItems.silt_stone = new BlockItem(CanadaBlocks.silt_stone, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone")),
					CanadaItems.silt_stone_stairs = new BlockItem(CanadaBlocks.silt_stone_stairs, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_stairs")),
					CanadaItems.silt_stone_slab = new BlockItem(CanadaBlocks.silt_stone_slab, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_slab")),
					CanadaItems.silt_stone_pressure_plate = new BlockItem(CanadaBlocks.silt_stone_pressure_plate, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_pressure_plate")),
					CanadaItems.silt_stone_button = new BlockItem(CanadaBlocks.silt_stone_button, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_button")),
					CanadaItems.silt_stone_wall = new BlockItem(CanadaBlocks.silt_stone_wall, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_wall")),
					CanadaItems.silt_stone_bricks = new BlockItem(CanadaBlocks.silt_stone_bricks, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_bricks")),
					CanadaItems.silt_stone_bricks_stairs = new BlockItem(CanadaBlocks.silt_stone_bricks_stairs, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_bricks_stairs")),
					CanadaItems.silt_stone_bricks_slab = new BlockItem(CanadaBlocks.silt_stone_bricks_slab, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_bricks_slab")),
					CanadaItems.silt_stone_bricks_wall = new BlockItem(CanadaBlocks.silt_stone_bricks_wall, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_bricks_wall")),
					CanadaItems.chiseled_silt_stone_bricks = new BlockItem(CanadaBlocks.chiseled_silt_stone_bricks, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("chiseled_silt_stone_bricks")),
					
					CanadaItems.silt_stone_torch = new WallOrFloorItem(CanadaBlocks.silt_stone_torch, CanadaBlocks.silt_stone_torch_wall, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_torch")),

					//Maple
					CanadaItems.maple_cobblestone = new BlockItem(CanadaBlocks.maple_cobblestone, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_cobblestone")),
					CanadaItems.maple_stone_bricks = new BlockItem(CanadaBlocks.maple_stone_bricks, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_stone_bricks")),
					CanadaItems.maple_stone_bricks_stairs = new BlockItem(CanadaBlocks.maple_stone_bricks_stairs, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_stone_bricks_stairs")),
					CanadaItems.maple_stone_bricks_slab = new BlockItem(CanadaBlocks.maple_stone_bricks_slab, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_stone_bricks_slab")),
					CanadaItems.maple_stone_bricks_wall = new BlockItem(CanadaBlocks.maple_stone_bricks_wall, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_stone_bricks_wall")),
							
					//Maple Wood
					CanadaItems.maple_wood_log = new CanadaBlockFuels(CanadaBlocks.maple_wood_log, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_wood_log")),
					CanadaItems.maple_wood_log_empty = new CanadaBlockFuels(CanadaBlocks.maple_wood_log_empty, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_wood_log_empty")),
					CanadaItems.maple_wood_planks = new CanadaBlockFuels(CanadaBlocks.maple_wood_planks, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_wood_planks")),
					CanadaItems.maple_wood_leaves = new CanadaLeafFuels(CanadaBlocks.maple_leaves, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_leaves")),
					CanadaItems.maple_wood_sapling = new CanadaLeafFuels(CanadaBlocks.maple_sapling, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_sapling")),
					CanadaItems.maple_wood_slab = new CanadaBlockFuels(CanadaBlocks.maple_wood_slab, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_wood_slab")),
					CanadaItems.maple_wood_stairs = new CanadaBlockFuels(CanadaBlocks.maple_wood_stairs, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_wood_stairs")),
					CanadaItems.maple_wood_fence = new CanadaBlockFuels(CanadaBlocks.maple_wood_fence, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_wood_fence")),
					CanadaItems.maple_wood_fence_gate = new CanadaBlockFuels(CanadaBlocks.maple_wood_fence_gate, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_wood_fence_gate")),
					CanadaItems.maple_wood_button = new CanadaBlockFuels(CanadaBlocks.maple_wood_button, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_wood_button")),
					CanadaItems.maple_wood_pressure_plate = new CanadaBlockFuels(CanadaBlocks.maple_wood_pressure_plate, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_wood_pressure_plate")),
					CanadaItems.maple_wood_door = new CanadaTallBlockFuels(CanadaBlocks.maple_wood_door, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_wood_door")),
					CanadaItems.maple_wood_trap_door = new CanadaBlockFuels(CanadaBlocks.maple_wood_trap_door, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_wood_trap_door")),
					
					//Red Wood
					CanadaItems.red_wood_log = new CanadaBlockFuels(CanadaBlocks.red_wood_log, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_log")),
					CanadaItems.red_wood_planks = new CanadaBlockFuels(CanadaBlocks.red_wood_planks, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_planks")),
					CanadaItems.red_wood_leaves = new CanadaLeafFuels(CanadaBlocks.red_wood_leaves, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_leaves")),
					CanadaItems.red_wood_sapling = new CanadaLeafFuels(CanadaBlocks.red_wood_sapling, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_sapling")),
					CanadaItems.red_wood_slab = new CanadaBlockFuels(CanadaBlocks.red_wood_slab, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_slab")),
					CanadaItems.red_wood_stairs = new CanadaBlockFuels(CanadaBlocks.red_wood_stairs, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_stairs")),
					CanadaItems.red_wood_fence = new CanadaBlockFuels(CanadaBlocks.red_wood_fence, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_fence")),
					CanadaItems.red_wood_fence_gate = new CanadaBlockFuels(CanadaBlocks.red_wood_fence_gate, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_fence_gate")),
					CanadaItems.red_wood_button = new CanadaBlockFuels(CanadaBlocks.red_wood_button, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_button")),
					CanadaItems.red_wood_pressure_plate = new CanadaBlockFuels(CanadaBlocks.red_wood_pressure_plate, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_pressure_plate")),
					CanadaItems.red_wood_door = new CanadaTallBlockFuels(CanadaBlocks.red_wood_door, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_door")),
					CanadaItems.red_wood_trap_door = new CanadaBlockFuels(CanadaBlocks.red_wood_trap_door, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("red_wood_trap_door")),
	
					//Trembling Aspen
					CanadaItems.trembling_aspen_wood_log = new CanadaBlockFuels(CanadaBlocks.trembling_aspen_wood_log, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_wood_log")),
					CanadaItems.trembling_aspen_wood_planks = new CanadaBlockFuels(CanadaBlocks.trembling_aspen_wood_planks, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_wood_planks")),
					CanadaItems.trembling_aspen_leaves = new CanadaLeafFuels(CanadaBlocks.trembling_aspen_leaves, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_leaves")),
					CanadaItems.trembling_aspen_sapling = new CanadaLeafFuels(CanadaBlocks.trembling_aspen_sapling, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_sapling")),
					CanadaItems.trembling_aspen_wood_slab = new CanadaBlockFuels(CanadaBlocks.trembling_aspen_wood_slab, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_wood_slab")),
					CanadaItems.trembling_aspen_wood_stairs = new CanadaBlockFuels(CanadaBlocks.trembling_aspen_wood_stairs, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_wood_stairs")),
					CanadaItems.trembling_aspen_wood_fence = new CanadaBlockFuels(CanadaBlocks.trembling_aspen_wood_fence, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_wood_fence")),
					CanadaItems.trembling_aspen_wood_fence_gate = new CanadaBlockFuels(CanadaBlocks.trembling_aspen_wood_fence_gate, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_wood_fence_gate")),
					CanadaItems.trembling_aspen_wood_button = new CanadaBlockFuels(CanadaBlocks.trembling_aspen_wood_button, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_wood_button")),
					CanadaItems.trembling_aspen_wood_pressure_plate = new CanadaBlockFuels(CanadaBlocks.trembling_aspen_wood_pressure_plate, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_wood_pressure_plate")),
					CanadaItems.trembling_aspen_wood_door = new CanadaTallBlockFuels(CanadaBlocks.trembling_aspen_wood_door, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_wood_door")),
					CanadaItems.trembling_aspen_wood_trap_door = new CanadaBlockFuels(CanadaBlocks.trembling_aspen_wood_trap_door, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("trembling_aspen_wood_trap_door")),

					//Random
					CanadaItems.canada_ore = new BlockItem(CanadaBlocks.canada_ore, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_ore")),
					CanadaItems.gypsum_ore = new BlockItem(CanadaBlocks.gypsum_ore, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("gypsum_ore")),
					CanadaItems.oil_ore = new BlockItem(CanadaBlocks.oil_ore, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("oil_ore")),
					CanadaItems.gypsum_block = new BlockItem(CanadaBlocks.gypsum_block, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("gypsum_block")),
					CanadaItems.canada_block = new BlockItem(CanadaBlocks.canada_block, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_block")),
					CanadaItems.meat_block = new BlockItem(CanadaBlocks.meat_block, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("meat_block")),					
					CanadaItems.maple_boss_block = new BlockItem(CanadaBlocks.maple_boss_block, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_boss_block")),
					CanadaItems.berry_boss_block = new BlockItem(CanadaBlocks.berry_boss_block, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("berry_boss_block")),
					CanadaItems.silt_stone_boss_block = new BlockItem(CanadaBlocks.silt_stone_boss_block, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_boss_block")),
					CanadaItems.canada_boss_block = new BlockItem(CanadaBlocks.canada_boss_block, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_boss_block")),
					CanadaItems.maple_block = new BlockItem(CanadaBlocks.maple_block, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_block")),
					CanadaItems.berry_block = new BlockItem(CanadaBlocks.berry_block, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("berry_block")),
					CanadaItems.silt_stone_block = new BlockItem(CanadaBlocks.silt_stone_block, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_block")),
					CanadaItems.maple_boss_egg = new MapleEggItem(CanadaBlocks.maple_boss_egg, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_boss_egg")),
					CanadaItems.berry_boss_egg = new BerryEggItem(CanadaBlocks.berry_boss_egg, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("berry_boss_egg")),
					CanadaItems.silt_stone_boss_egg = new SiltstoneEggItem(CanadaBlocks.silt_stone_boss_egg, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_boss_egg")),
					CanadaItems.portal_block = new BlockItem(CanadaBlocks.portal_block, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("portal_block")),
					
					//Carpets
					CanadaItems.beaver_carpet1 = new BlockItem(CanadaBlocks.beaver_carpet1, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("beaver_carpet1")),	
					CanadaItems.beaver_carpet2 = new BlockItem(CanadaBlocks.beaver_carpet2, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("beaver_carpet2")),
					CanadaItems.beaver_carpet3 = new BlockItem(CanadaBlocks.beaver_carpet3, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("beaver_carpet3")),
					CanadaItems.beaver_carpet4 = new BlockItem(CanadaBlocks.beaver_carpet4, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("beaver_carpet4")),	
					
					//Tools
					CanadaItems.antler_sword = new SwordItem(ToolMaterials.antler, 0, -1.75f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("antler_sword")),
					CanadaItems.antler_pickaxe = new PickaxeItem(ToolMaterials.antler, -2, -2.3f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("antler_pickaxe")),
					CanadaItems.antler_axe = new AxeItem(ToolMaterials.antler, 3.0f, -2.9f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("antler_axe")),
					CanadaItems.antler_hoe = new HoeItem(ToolMaterials.antler, 6f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("antler_hoe")),
					CanadaItems.antler_shovel = new ShovelItem(ToolMaterials.antler, -1.5f, -2.0f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("antler_shovel")),
					
					CanadaItems.canada_sword = new SwordItem(ToolMaterials.canada, 0, -1.9f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_sword")),
					CanadaItems.canada_pickaxe = new PickaxeItem(ToolMaterials.canada, -2, -2.5f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_pickaxe")),
					CanadaItems.canada_axe = new AxeItem(ToolMaterials.canada, 3.0f, -2.8f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_axe")),
					CanadaItems.canada_hoe = new HoeItem(ToolMaterials.canada, 6f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_hoe")),
					CanadaItems.canada_shovel = new ShovelItem(ToolMaterials.canada, -1.5f, -2.5f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_shovel")),
							
					CanadaItems.gypsum_blade = new GypsumBlade(ToolMaterials.gypsum, 0, -1.5f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("gypsum_blade")),
					
					CanadaItems.maple_sword = new MapleSword(ToolMaterials.maple, 0, -2.0f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_sword")),
					CanadaItems.berry_hoe = new BerryHoe(ToolMaterials.berry, 0, -2.0f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("berry_hoe")),
					CanadaItems.silt_stone_pickaxe = new SiltstonePick(ToolMaterials.silt, 0, -2.5f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_pickaxe")),
																			
					CanadaItems.grizzly_bear_claw_spear = new SwordItem(ToolMaterials.bear, 0, -3.5f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("grizzly_bear_claw_spear")),
					CanadaItems.grizzly_bear_claw_spear_bleed = new SpearBleed(ToolMaterials.bear, 0, -3.5f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("grizzly_bear_claw_spear_bleed")),
					CanadaItems.grizzly_bear_claw_spear_canada = new SpearCanada(ToolMaterials.bear, 0, -3.5f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("grizzly_bear_claw_spear_canada")),
					CanadaItems.grizzly_bear_claw_spear_maple = new SpearMaple(ToolMaterials.bear, 0, -3.5f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("grizzly_bear_claw_spear_maple")),
					CanadaItems.grizzly_bear_claw_spear_speed = new SpearSpeed(ToolMaterials.bear, 0, -3.5f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("grizzly_bear_claw_spear_speed")),
					CanadaItems.grizzly_bear_claw_spear_slow = new SpearSlow(ToolMaterials.bear, 0 , -3.5f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("grizzly_bear_claw_spear_slow")),
					CanadaItems.grizzly_bear_claw_spear_silt = new SpearSilt(ToolMaterials.bear, 0 , -3.5f, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("grizzly_bear_claw_spear_silt")),
							
					CanadaItems.snowball_staff = new SnowStaff(ToolMaterials.snow, 0, 0, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("snowball_staff")),
					
					//Armor
					CanadaItems.moose_helmet = new ArmorBuff(ArmorMaterials.moose, EquipmentSlotType.HEAD, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("moose_helmet")),
					CanadaItems.moose_chestplate = new ArmorBuff(ArmorMaterials.moose, EquipmentSlotType.CHEST, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("moose_chestplate")),
					CanadaItems.moose_leggings = new ArmorBuff(ArmorMaterials.moose, EquipmentSlotType.LEGS, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("moose_leggings")),
					CanadaItems.moose_boots = new ArmorBuff(ArmorMaterials.moose, EquipmentSlotType.FEET, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("moose_boots")),

					CanadaItems.enhanced_moose_helmet = new ArmorBuff(ArmorMaterials.enhanced_moose, EquipmentSlotType.HEAD, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("enhanced_moose_helmet")),
					CanadaItems.enhanced_moose_chestplate = new ArmorBuff(ArmorMaterials.enhanced_moose, EquipmentSlotType.CHEST, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("enhanced_moose_chestplate")),
					CanadaItems.enhanced_moose_leggings = new ArmorBuff(ArmorMaterials.enhanced_moose, EquipmentSlotType.LEGS, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("enhanced_moose_leggings")),
					CanadaItems.enhanced_moose_boots = new ArmorBuff(ArmorMaterials.enhanced_moose, EquipmentSlotType.FEET, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("enhanced_moose_boots")),
					
					CanadaItems.canada_helmet = new ArmorItem(ArmorMaterials.canada, EquipmentSlotType.HEAD, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_helmet")),
					CanadaItems.canada_chestplate = new ArmorItem(ArmorMaterials.canada, EquipmentSlotType.CHEST, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_chestplate")),
					CanadaItems.canada_leggings = new ArmorItem(ArmorMaterials.canada, EquipmentSlotType.LEGS, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_leggings")),
					CanadaItems.canada_boots = new ArmorItem(ArmorMaterials.canada, EquipmentSlotType.FEET, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("canada_boots")),					
				
					CanadaItems.maple_helmet = new ArmorBuff(ArmorMaterials.maple, EquipmentSlotType.HEAD, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_helmet")),
					CanadaItems.maple_leaf_chestplate = new ArmorBuff(ArmorMaterials.maple_leaf, EquipmentSlotType.CHEST, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("maple_leaf_chestplate")),
					CanadaItems.silt_stone_leggings = new ArmorBuff(ArmorMaterials.silt, EquipmentSlotType.LEGS, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("silt_stone_leggings")),
					CanadaItems.berry_boots = new ArmorBuff(ArmorMaterials.berry, EquipmentSlotType.FEET, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("berry_boots")),
					
					CanadaItems.army_hat = new ArmyHat(ArmorMaterials.beaver, EquipmentSlotType.HEAD, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("army_hat")),
					CanadaItems.clerical_hat = new ClericalHat(ArmorMaterials.beaver, EquipmentSlotType.HEAD, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("clerical_hat")),
					CanadaItems.continental_hat = new ContinentalHat(ArmorMaterials.beaver, EquipmentSlotType.HEAD, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("continental_hat")),
					CanadaItems.navy_hat = new NavyHat(ArmorMaterials.beaver, EquipmentSlotType.HEAD, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("navy_hat")),
					CanadaItems.regent_hat = new RegentHat(ArmorMaterials.beaver, EquipmentSlotType.HEAD, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("regent_hat")),
					
					CanadaItems.bear_helmet = new ArmorBuff(ArmorMaterials.bear, EquipmentSlotType.HEAD, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("bear_helmet")),
					CanadaItems.bear_chestplate = new ArmorBuff(ArmorMaterials.bear, EquipmentSlotType.CHEST, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("bear_chestplate")),
					CanadaItems.bear_leggings = new ArmorBuff(ArmorMaterials.bear, EquipmentSlotType.LEGS, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("bear_leggings")),
					CanadaItems.bear_boots = new ArmorBuff(ArmorMaterials.bear, EquipmentSlotType.FEET, new Item.Properties().group(Main.CANADA)).setRegistryName(Main.location("bear_boots"))
					
					);
			
				CanadaEntities.registerEntitySpawnEggs(event);
			
				Main.LOGGER.info("Items Registered.");
			
		}
		
	}
	
}
