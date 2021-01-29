package danial.canadacraft.main.init.world.gen;

import danial.canadacraft.main.init.blocks.CanadaBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {

	public static void setupOreGeneration() {
		
		for (Biome biome : ForgeRegistries.BIOMES) {

			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CanadaBlocks.canada_ore.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(15, 0, 0, 128)));

		}
		
	}
	
}
