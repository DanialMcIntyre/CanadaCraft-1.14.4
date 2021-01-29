package danial.canadacraft.main.init.world.gen;

import danial.canadacraft.main.init.world.biomes.CanadaBiomes;
import danial.canadacraft.main.init.world.structures.CanadaStructures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class StructureGeneration {

	public static void setupStructureGeneration() {
		
		for (Biome biome : ForgeRegistries.BIOMES) {

			if (biome == CanadaBiomes.rocky_mountains) {
				
				biome.addStructure(CanadaStructures.ROCKYHOUSE.get(), IFeatureConfig.NO_FEATURE_CONFIG);
				
			}
			
			if (biome == CanadaBiomes.maple_forest || biome == CanadaBiomes.snowy_maple_forest) {
				
				biome.addStructure(CanadaStructures.MAPLEDUNGEON.get(), IFeatureConfig.NO_FEATURE_CONFIG);
				biome.addStructure(CanadaStructures.MAPLESHACK.get(), IFeatureConfig.NO_FEATURE_CONFIG);
				
			}
			
			if (biome == CanadaBiomes.prairie) {
				
				biome.addStructure(CanadaStructures.BOSSROOM.get(), IFeatureConfig.NO_FEATURE_CONFIG);
				
			}			
			
			if (biome == CanadaBiomes.deciduous_forest || biome == CanadaBiomes.snowy_deciduous_forest) {
				
				biome.addStructure(CanadaStructures.VILLAGERHUT.get(), IFeatureConfig.NO_FEATURE_CONFIG);
				
			}
			
			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(CanadaStructures.ROCKYHOUSE.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(CanadaStructures.BOSSROOM.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Biome.createDecoratedFeature(CanadaStructures.MAPLEDUNGEON.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(CanadaStructures.MAPLESHACK.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(CanadaStructures.VILLAGERHUT.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
				
		}
		
	}
	
}