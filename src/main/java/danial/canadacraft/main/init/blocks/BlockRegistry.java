package danial.canadacraft.main.init.blocks;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.init.blocks.boss.BerryBossBlock;
import danial.canadacraft.main.init.blocks.boss.CanadaBossBlock;
//import danial.canadacraft.main.init.blocks.boss.MapleBossEgg;
import danial.canadacraft.main.init.blocks.boss.MapleBossBlock;
import danial.canadacraft.main.init.blocks.boss.SiltstoneBossBlock;
import danial.canadacraft.main.init.blocks.crops.CornCrop;
import danial.canadacraft.main.init.blocks.crops.CornGrass;
import danial.canadacraft.main.init.blocks.crops.HuckleBerry;
import danial.canadacraft.main.init.blocks.crops.SalmonBerry;
import danial.canadacraft.main.init.blocks.crops.ThimbleBerry;
import danial.canadacraft.main.init.blocks.deco.CanadaCarpet;
import danial.canadacraft.main.init.blocks.deco.CanadaDoor;
import danial.canadacraft.main.init.blocks.deco.CanadaPressurePlate;
import danial.canadacraft.main.init.blocks.deco.CanadaStairs;
import danial.canadacraft.main.init.blocks.deco.CanadaStoneButton;
import danial.canadacraft.main.init.blocks.deco.CanadaTorch;
import danial.canadacraft.main.init.blocks.deco.CanadaTorchWall;
import danial.canadacraft.main.init.blocks.deco.CanadaTrapDoor;
import danial.canadacraft.main.init.blocks.deco.CanadaWall;
import danial.canadacraft.main.init.blocks.deco.CanadaWoodButton;
import danial.canadacraft.main.init.blocks.deco.CanadaWoodFence;
import danial.canadacraft.main.init.blocks.deco.CanadaWoodFenceGate;
import danial.canadacraft.main.init.blocks.deco.CanadaWoodStairs;
import danial.canadacraft.main.init.blocks.foods.CanadaCakeBlock;
import danial.canadacraft.main.init.blocks.foods.MeatBlock;
import danial.canadacraft.main.init.blocks.other.CanadaMush;
import danial.canadacraft.main.init.blocks.other.OilOre;
import danial.canadacraft.main.init.blocks.other.PortalBlock;
import danial.canadacraft.main.init.blocks.trees.mapletree.MapleLog;
import danial.canadacraft.main.init.blocks.trees.mapletree.MapleSapling;
import danial.canadacraft.main.init.blocks.trees.redwoodtree.RedWoodLog;
import danial.canadacraft.main.init.blocks.trees.redwoodtree.RedWoodSapling;
import danial.canadacraft.main.init.blocks.trees.tremblingaspen.TremblingAspenSapling;
import danial.canadacraft.main.init.blocks.trees.tremblingaspen.TremblingAspenWoodLog;
import danial.canadacraft.main.init.fluids.BerryFluidBlock;
import danial.canadacraft.main.init.fluids.CanadaFluids;
import danial.canadacraft.main.init.fluids.MapleFluidBlock;
import danial.canadacraft.main.init.fluids.OilFluidBlock;
import danial.canadacraft.main.init.world.trees.MapleTree;
import danial.canadacraft.main.init.world.trees.RedWoodTree;
import danial.canadacraft.main.init.world.trees.TremblingAspenTree;
import net.minecraft.block.Block;
import net.minecraft.block.DragonEggBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class BlockRegistry {
	
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public static class RegistryEvents {
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		
		event.getRegistry().registerAll(

				//Siltstone
				CanadaBlocks.silt_stone = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).lightValue(0).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(0)).setRegistryName(Main.location("silt_stone")),
				CanadaBlocks.silt_stone_stairs = new CanadaStairs(CanadaBlocks.silt_stone.getDefaultState(), Block.Properties.from(CanadaBlocks.silt_stone)).setRegistryName(Main.location("silt_stone_stairs")),
				CanadaBlocks.silt_stone_slab = new SlabBlock(Block.Properties.from(CanadaBlocks.silt_stone)).setRegistryName(Main.location("silt_stone_slab")),
				CanadaBlocks.silt_stone_pressure_plate = new CanadaPressurePlate(CanadaPressurePlate.Sensitivity.MOBS, Block.Properties.from(CanadaBlocks.silt_stone)).setRegistryName(Main.location("silt_stone_pressure_plate")),
				CanadaBlocks.silt_stone_button = new CanadaStoneButton(Block.Properties.from(CanadaBlocks.silt_stone)).setRegistryName(Main.location("silt_stone_button")),
				CanadaBlocks.silt_stone_wall = new CanadaWall(Block.Properties.from(CanadaBlocks.silt_stone)).setRegistryName(Main.location("silt_stone_wall")),
				CanadaBlocks.silt_stone_bricks = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(0)).setRegistryName(Main.location("silt_stone_bricks")),
				CanadaBlocks.silt_stone_bricks_stairs = new CanadaStairs(CanadaBlocks.silt_stone_bricks.getDefaultState(), Block.Properties.from(CanadaBlocks.silt_stone_bricks)).setRegistryName(Main.location("silt_stone_bricks_stairs")),
				CanadaBlocks.silt_stone_bricks_slab = new SlabBlock(Block.Properties.from(CanadaBlocks.silt_stone_bricks)).setRegistryName(Main.location("silt_stone_bricks_slab")),
				CanadaBlocks.silt_stone_bricks_wall = new CanadaWall(Block.Properties.from(CanadaBlocks.silt_stone_bricks)).setRegistryName(Main.location("silt_stone_bricks_wall")),
				CanadaBlocks.chiseled_silt_stone_bricks = new Block(Block.Properties.from(CanadaBlocks.silt_stone_bricks)).setRegistryName(Main.location("chiseled_silt_stone_bricks")),
				
				CanadaBlocks.silt_stone_torch = new CanadaTorch(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.0F).lightValue(14).sound(SoundType.WOOD)).setRegistryName(Main.location("silt_stone_torch")),
				CanadaBlocks.silt_stone_torch_wall = new CanadaTorchWall(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.0F).lightValue(14).sound(SoundType.WOOD)).setRegistryName(Main.location("silt_stone_torch_wall")),

				//Maple
				CanadaBlocks.maple_cobblestone = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).lightValue(0).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(0)).setRegistryName(Main.location("maple_cobblestone")),
				CanadaBlocks.maple_stone_bricks = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(0)).setRegistryName(Main.location("maple_stone_bricks")),
				CanadaBlocks.maple_stone_bricks_stairs = new CanadaStairs(CanadaBlocks.maple_stone_bricks.getDefaultState(), Block.Properties.from(CanadaBlocks.silt_stone)).setRegistryName(Main.location("maple_stone_bricks_stairs")),
				CanadaBlocks.maple_stone_bricks_slab = new SlabBlock(Block.Properties.from(CanadaBlocks.maple_stone_bricks)).setRegistryName(Main.location("maple_stone_bricks_slab")),
				CanadaBlocks.maple_stone_bricks_wall = new CanadaWall(Block.Properties.from(CanadaBlocks.maple_stone_bricks)).setRegistryName(Main.location("maple_stone_bricks_wall")),			
				
				//Maple Tree
				CanadaBlocks.maple_wood_log = new MapleLog(MaterialColor.ADOBE, Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 2.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE).harvestLevel(0)).setRegistryName(Main.location("maple_wood_log")),
				CanadaBlocks.maple_wood_log_empty = new RedWoodLog(MaterialColor.ADOBE, Block.Properties.from(CanadaBlocks.maple_wood_log)).setRegistryName(Main.location("maple_wood_log_empty")),
				CanadaBlocks.maple_wood_planks = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE).harvestLevel(0)).setRegistryName(Main.location("maple_wood_planks")),
				CanadaBlocks.maple_leaves = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F, 0.0F).sound(SoundType.PLANT).harvestTool(null).harvestLevel(0)).setRegistryName(Main.location("maple_leaves")),
				CanadaBlocks.maple_sapling = new MapleSapling(new MapleTree(),Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.PLANT).harvestTool(null).harvestLevel(0).doesNotBlockMovement().tickRandomly()).setRegistryName(Main.location("maple_sapling")),
				CanadaBlocks.maple_wood_slab = new SlabBlock(Block.Properties.from(CanadaBlocks.maple_wood_planks)).setRegistryName(Main.location("maple_wood_slab")),
				CanadaBlocks.maple_wood_stairs = new CanadaWoodStairs(CanadaBlocks.maple_wood_planks.getDefaultState(), Block.Properties.from(CanadaBlocks.maple_wood_planks)).setRegistryName(Main.location("maple_wood_stairs")),
				CanadaBlocks.maple_wood_fence = new CanadaWoodFence(Block.Properties.from(CanadaBlocks.maple_wood_planks)).setRegistryName(Main.location("maple_wood_fence")),
				CanadaBlocks.maple_wood_fence_gate = new CanadaWoodFenceGate(Block.Properties.from(CanadaBlocks.maple_wood_planks)).setRegistryName(Main.location("maple_wood_fence_gate")),
				CanadaBlocks.maple_wood_button = new CanadaWoodButton(Block.Properties.from(CanadaBlocks.maple_wood_planks)).setRegistryName(Main.location("maple_wood_button")),
				CanadaBlocks.maple_wood_pressure_plate = new CanadaPressurePlate(CanadaPressurePlate.Sensitivity.EVERYTHING, Block.Properties.from(CanadaBlocks.maple_wood_planks)).setRegistryName(Main.location("maple_wood_pressure_plate")),
				CanadaBlocks.maple_wood_door = new CanadaDoor(Block.Properties.from(CanadaBlocks.maple_wood_planks)).setRegistryName(Main.location("maple_wood_door")),
				CanadaBlocks.maple_wood_trap_door = new CanadaTrapDoor(Block.Properties.from(CanadaBlocks.maple_wood_planks)).setRegistryName(Main.location("maple_wood_trap_door")),
				
				//Red Wood Tree
				CanadaBlocks.red_wood_log = new RedWoodLog(MaterialColor.RED, Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE).harvestLevel(0)).setRegistryName(Main.location("red_wood_log")),
				CanadaBlocks.red_wood_planks = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE).harvestLevel(0)).setRegistryName(Main.location("red_wood_planks")),
				CanadaBlocks.red_wood_leaves = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F, 0F).sound(SoundType.PLANT).harvestTool(null).harvestLevel(0)).setRegistryName(Main.location("red_wood_leaves")),
				CanadaBlocks.red_wood_sapling = new RedWoodSapling(new RedWoodTree(), Block.Properties.create(Material.PLANTS).hardnessAndResistance(0F).sound(SoundType.PLANT).harvestTool(null).harvestLevel(0).doesNotBlockMovement().tickRandomly()).setRegistryName(Main.location("red_wood_sapling")),
				CanadaBlocks.red_wood_slab = new SlabBlock(Block.Properties.from(CanadaBlocks.red_wood_planks)).setRegistryName(Main.location("red_wood_slab")),
				CanadaBlocks.red_wood_stairs = new CanadaWoodStairs(CanadaBlocks.red_wood_planks.getDefaultState(), Block.Properties.from(CanadaBlocks.maple_wood_planks)).setRegistryName(Main.location("red_wood_stairs")),
				CanadaBlocks.red_wood_fence = new CanadaWoodFence(Block.Properties.from(CanadaBlocks.red_wood_planks)).setRegistryName(Main.location("red_wood_fence")),
				CanadaBlocks.red_wood_fence_gate = new CanadaWoodFenceGate(Block.Properties.from(CanadaBlocks.red_wood_planks)).setRegistryName(Main.location("red_wood_fence_gate")),
				CanadaBlocks.red_wood_button = new CanadaWoodButton(Block.Properties.from(CanadaBlocks.red_wood_planks)).setRegistryName(Main.location("red_wood_button")),
				CanadaBlocks.red_wood_pressure_plate = new CanadaPressurePlate(CanadaPressurePlate.Sensitivity.EVERYTHING, Block.Properties.from(CanadaBlocks.red_wood_planks)).setRegistryName(Main.location("red_wood_pressure_plate")),
				CanadaBlocks.red_wood_door = new CanadaDoor(Block.Properties.from(CanadaBlocks.red_wood_planks)).setRegistryName(Main.location("red_wood_door")),
				CanadaBlocks.red_wood_trap_door = new CanadaTrapDoor(Block.Properties.from(CanadaBlocks.red_wood_planks)).setRegistryName(Main.location("red_wood_trap_door")),
				
				//Trembling Aspen Tree
				CanadaBlocks.trembling_aspen_wood_log = new TremblingAspenWoodLog(MaterialColor.CLAY, Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD).harvestTool(ToolType.AXE).harvestLevel(0)).setRegistryName(Main.location("trembling_aspen_wood_log")),
				CanadaBlocks.trembling_aspen_wood_planks = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).harvestTool(ToolType.AXE).harvestLevel(0)).setRegistryName(Main.location("trembling_aspen_wood_planks")),
				CanadaBlocks.trembling_aspen_leaves = new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F, 0F).sound(SoundType.PLANT).harvestTool(null).harvestLevel(0)).setRegistryName(Main.location("trembling_aspen_leaves")),
				CanadaBlocks.trembling_aspen_sapling = new TremblingAspenSapling(new TremblingAspenTree(), Block.Properties.create(Material.PLANTS).hardnessAndResistance(0F).sound(SoundType.PLANT).harvestTool(null).harvestLevel(0).doesNotBlockMovement().tickRandomly()).setRegistryName(Main.location("trembling_aspen_sapling")),
				CanadaBlocks.trembling_aspen_wood_slab = new SlabBlock(Block.Properties.from(CanadaBlocks.trembling_aspen_wood_planks)).setRegistryName(Main.location("trembling_aspen_wood_slab")),
				CanadaBlocks.trembling_aspen_wood_stairs = new CanadaWoodStairs(CanadaBlocks.trembling_aspen_wood_planks.getDefaultState(), Block.Properties.from(CanadaBlocks.maple_wood_planks)).setRegistryName(Main.location("trembling_aspen_wood_stairs")),
				CanadaBlocks.trembling_aspen_wood_fence = new CanadaWoodFence(Block.Properties.from(CanadaBlocks.trembling_aspen_wood_planks)).setRegistryName(Main.location("trembling_aspen_wood_fence")),
				CanadaBlocks.trembling_aspen_wood_fence_gate = new CanadaWoodFenceGate(Block.Properties.from(CanadaBlocks.trembling_aspen_wood_planks)).setRegistryName(Main.location("trembling_aspen_wood_fence_gate")),
				CanadaBlocks.trembling_aspen_wood_button = new CanadaWoodButton(Block.Properties.from(CanadaBlocks.trembling_aspen_wood_planks)).setRegistryName(Main.location("trembling_aspen_wood_button")),
				CanadaBlocks.trembling_aspen_wood_pressure_plate = new CanadaPressurePlate(CanadaPressurePlate.Sensitivity.EVERYTHING, Block.Properties.from(CanadaBlocks.trembling_aspen_wood_planks)).setRegistryName(Main.location("trembling_aspen_wood_pressure_plate")),
				CanadaBlocks.trembling_aspen_wood_door = new CanadaDoor(Block.Properties.from(CanadaBlocks.trembling_aspen_wood_planks)).setRegistryName(Main.location("trembling_aspen_wood_door")),
				CanadaBlocks.trembling_aspen_wood_trap_door = new CanadaTrapDoor(Block.Properties.from(CanadaBlocks.trembling_aspen_wood_planks)).setRegistryName(Main.location("trembling_aspen_wood_trap_door")),
				
				//Food
				CanadaBlocks.corn_crop = new CornCrop(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.CROP)).setRegistryName(Main.location("corn_crop")),
				CanadaBlocks.corn_grass = new CornGrass(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CROP)).setRegistryName(Main.location("corn_grass")),	

				//Berries
				CanadaBlocks.huckle_berries = new HuckleBerry(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)).setRegistryName(Main.location("huckle_berries")),
				CanadaBlocks.thimble_berries = new ThimbleBerry(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)).setRegistryName(Main.location("thimble_berries")),
				CanadaBlocks.salmon_berries = new SalmonBerry(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)).setRegistryName(Main.location("salmon_berries")),
				
				//Flowers
				CanadaBlocks.trillium = new FlowerBlock(Effects.SATURATION, 2, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT)).setRegistryName(Main.location("trillium")),
				
				//Random
				CanadaBlocks.canada_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1)).setRegistryName(Main.location("canada_ore")),
				CanadaBlocks.gypsum_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).lightValue(0).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)).setRegistryName(Main.location("gypsum_ore")),
				CanadaBlocks.oil_ore = new OilOre(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)).setRegistryName(Main.location("oil_ore")),
				CanadaBlocks.gypsum_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)).setRegistryName(Main.location("gypsum_block")),
				CanadaBlocks.canada_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F, 4.0F).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)).setRegistryName(Main.location("canada_block")),
				CanadaBlocks.meat_block = new MeatBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.0F, 0.0F).sound(SoundType.SNOW).harvestTool(null).harvestLevel(0)).setRegistryName(Main.location("meat_block")),
				CanadaBlocks.maple_cake = new CanadaCakeBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F, 0.5F).sound(SoundType.SNOW)).setRegistryName(Main.location("maple_cake_block")),
				CanadaBlocks.berry_cake = new CanadaCakeBlock(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.5F, 0.5F).sound(SoundType.SNOW)).setRegistryName(Main.location("berry_cake_block")),
				
				//Carpets
				CanadaBlocks.beaver_carpet1 = new CanadaCarpet(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.1F).sound(SoundType.CLOTH)).setRegistryName(Main.location("beaver_carpet1")),
				CanadaBlocks.beaver_carpet2 = new CanadaCarpet(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.1F).sound(SoundType.CLOTH)).setRegistryName(Main.location("beaver_carpet2")),
				CanadaBlocks.beaver_carpet3 = new CanadaCarpet(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.1F).sound(SoundType.CLOTH)).setRegistryName(Main.location("beaver_carpet3")),
				CanadaBlocks.beaver_carpet4 = new CanadaCarpet(Block.Properties.create(Material.CARPET).hardnessAndResistance(0.1F).sound(SoundType.CLOTH)).setRegistryName(Main.location("beaver_carpet4")),

				//Fluids
				CanadaBlocks.maple_fluid = new MapleFluidBlock(() -> CanadaFluids.maple, Block.Properties.create(Material.WATER).noDrops().doesNotBlockMovement()).setRegistryName(Main.location("maple_fluid")),
				CanadaBlocks.berry_fluid = new BerryFluidBlock(() -> CanadaFluids.berry, Block.Properties.create(Material.WATER).noDrops().doesNotBlockMovement()).setRegistryName(Main.location("berry_fluid")),
				CanadaBlocks.oil_fluid = new OilFluidBlock(() -> CanadaFluids.oil, Block.Properties.create(Material.WATER).noDrops().doesNotBlockMovement()).setRegistryName(Main.location("oil_fluid")),
						
				CanadaBlocks.berry_mush = new CanadaMush(Block.Properties.create(Material.SNOW).hardnessAndResistance(0.1F).sound(SoundType.SNOW)).setRegistryName(Main.location("berry_mush")),
				
				//Boss
				CanadaBlocks.maple_boss_block = new MapleBossBlock(Block.Properties.create(Material.ANVIL).hardnessAndResistance(5.0F, 5.0F).sound(SoundType.ANVIL).harvestTool(ToolType.PICKAXE)).setRegistryName(Main.location("maple_boss_block")),
				CanadaBlocks.maple_boss_egg = new DragonEggBlock(Block.Properties.create(Material.DRAGON_EGG).hardnessAndResistance(3.0F, 9.0F).sound(SoundType.STONE)).setRegistryName(Main.location("maple_boss_egg")),
				CanadaBlocks.maple_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 5.0F).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(1)).setRegistryName(Main.location("maple_block")),
				
				CanadaBlocks.berry_boss_block = new BerryBossBlock(Block.Properties.create(Material.ANVIL).hardnessAndResistance(5.0F, 5.0F).sound(SoundType.ANVIL).harvestTool(ToolType.PICKAXE)).setRegistryName(Main.location("berry_boss_block")),
				CanadaBlocks.berry_boss_egg = new DragonEggBlock(Block.Properties.create(Material.DRAGON_EGG).hardnessAndResistance(3.0F, 9.0F).sound(SoundType.STONE)).setRegistryName(Main.location("berry_boss_egg")),
				CanadaBlocks.berry_block = new Block(Block.Properties.create(Material.SNOW).hardnessAndResistance(5.0F, 5.0F).sound(SoundType.SLIME).harvestTool(ToolType.PICKAXE).harvestLevel(1)).setRegistryName(Main.location("berry_block")),
				
				CanadaBlocks.silt_stone_boss_block = new SiltstoneBossBlock(Block.Properties.create(Material.ANVIL).hardnessAndResistance(5.0F, 5.0F).sound(SoundType.ANVIL).harvestTool(ToolType.PICKAXE)).setRegistryName(Main.location("silt_stone_boss_block")),
				CanadaBlocks.silt_stone_boss_egg = new DragonEggBlock(Block.Properties.create(Material.DRAGON_EGG).hardnessAndResistance(3.0F, 9.0F).sound(SoundType.STONE)).setRegistryName(Main.location("silt_stone_boss_egg")),
				CanadaBlocks.silt_stone_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0F, 5.0F).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(1)).setRegistryName(Main.location("silt_stone_block")),
						
				CanadaBlocks.canada_boss_block = new CanadaBossBlock(Block.Properties.create(Material.ANVIL).hardnessAndResistance(999.0F, 999.0F).sound(SoundType.ANVIL).harvestTool(ToolType.PICKAXE)).setRegistryName(Main.location("canada_boss_block")),				
				
				//Portal
				CanadaBlocks.portal_block = new PortalBlock(Block.Properties.create(Material.PORTAL).hardnessAndResistance(10.0F, 10.0F).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(1)).setRegistryName(Main.location("portal_block"))
				
				);
		
		Main.LOGGER.info("Blocks Registered.");
		
		}
	
	}

}
