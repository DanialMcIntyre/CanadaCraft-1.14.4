package danial.canadacraft.main.init.world.features;

import java.util.List;

import com.google.common.collect.Lists;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.init.blocks.CanadaBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BushConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.LakesConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.LakeChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class CanadaFeatures {

	public static List<Feature<?>> features = Lists.newArrayList();

	@SuppressWarnings("unchecked")
	public static final Feature<NoFeatureConfig> MAPLE_TREE = registerFeature("maple_tree", new MapleTreeFeature(NoFeatureConfig::deserialize, false, false));

	@SuppressWarnings("unchecked")
	public static final Feature<NoFeatureConfig> RED_WOOD_TREE = registerFeature("red_wood_tree", new RedWoodTreeFeature(NoFeatureConfig::deserialize, false, false));

	@SuppressWarnings("unchecked")
	public static final Feature<NoFeatureConfig> TREMBLING_ASPEN_TREE = registerFeature("trembling_aspen_tree", new TremblingAspenTreeFeature(NoFeatureConfig::deserialize, false));

	@SuppressWarnings("unchecked")
	public static final Feature<NoFeatureConfig> TRILLIUM_FLOWER = registerFeature("trillium_flower", new TrilliumFeature(NoFeatureConfig::deserialize));
	
	@SuppressWarnings("rawtypes")
	private static Feature registerFeature(String name, Feature feature) {

		feature.setRegistryName(Main.MODID, name);
		features.add(feature);
		return feature;

	}

	public static void addOres(Biome biomeIn) {

		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIAMOND_ORE.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(6, 0, 0, 256)));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.COAL_ORE.getDefaultState(), 17), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 256)));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.IRON_ORE.getDefaultState(), 20), Placement.COUNT_RANGE, new CountRangeConfig(20, 0, 0, 256)));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GOLD_ORE.getDefaultState(), 9), Placement.COUNT_RANGE, new CountRangeConfig(2, 0, 0, 256)));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.REDSTONE_ORE.getDefaultState(), 8), 	Placement.COUNT_RANGE, new CountRangeConfig(7, 0, 0, 256)));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.EMERALD_ORE.getDefaultState(), 1), Placement.COUNT_RANGE, new CountRangeConfig(1, 0, 0, 256)));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CanadaBlocks.silt_stone.getDefaultState(), 33), Placement.COUNT_RANGE, new CountRangeConfig(40, 0, 0, 256)));

	}
	
	public static void addGypsum(Biome biomeIn) {
		
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CanadaBlocks.gypsum_ore.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(8, 0, 0, 7)));
		
	}
	
	public static void addOil(Biome biomeIn) {
		
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CanadaBlocks.oil_ore.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(7, 0, 0, 255)));
		
	}

	public static void addCornGrass(Biome biomeIn) {

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(CanadaBlocks.corn_grass.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(2, 0.25F)));

	}

	public static void addThimbleBerries(Biome biomeIn) {

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(CanadaBlocks.thimble_berries.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(1, 0.125F)));

	}

	public static void addSalmonBerries(Biome biomeIn) {

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(CanadaBlocks.salmon_berries.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(1, 0.125F)));

	}

	public static void addHuckleBerries(Biome biomeIn) {

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(CanadaBlocks.huckle_berries.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(1, 0.125F)));

	}
	   
	public static void addMapleNectarPonds(Biome biomeIn) {
		
		biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(Feature.LAKE, new LakesConfig(CanadaBlocks.maple_fluid.getDefaultState()), Placement.WATER_LAKE, new LakeChanceConfig(25)));
		      
	}
	
	public static void addBerryMushPonds(Biome biomeIn) {
		
		biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(Feature.LAKE, new LakesConfig(CanadaBlocks.berry_fluid.getDefaultState()), Placement.WATER_LAKE, new LakeChanceConfig(25)));
		      
	}
	
	public static void addTrillium(Biome biomeIn) {
	
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(TRILLIUM_FLOWER, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(1)));

	}
	
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
			
			for (@SuppressWarnings("rawtypes")
			
			Feature features : CanadaFeatures.features) {
				
				event.getRegistry().register(features);
				
			}
			
		}
		
	}
	
	public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey)
	{
		entry.setRegistryName(new ResourceLocation(Main.MODID, registryKey));
		registry.register(entry);
		return entry;
	}
	
}
		
