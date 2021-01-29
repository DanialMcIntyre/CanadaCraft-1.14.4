package danial.canadacraft.main.init.world.biomes;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.init.blocks.CanadaBlocks;
import danial.canadacraft.main.init.entities.CanadaEntities;
import danial.canadacraft.main.init.world.features.CanadaFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.LakesConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.LakeChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RockyMountains extends Biome {

	public RockyMountains() {

		super((new Biome.Builder()).surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.MOUNTAIN, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), CanadaBlocks.silt_stone.getDefaultState(), Blocks.CLAY.getDefaultState()))).precipitation(Biome.RainType.SNOW).category(Category.EXTREME_HILLS).depth(1.25F).temperature(0.20F).waterColor(0x02faee).waterFogColor(0x784f32).scale(0.75F).parent((String) null).downfall(1.0F));

		this.getRiver();
		DefaultBiomeFeatures.addGrass(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addFossils(this);
		DefaultBiomeFeatures.addSedimentDisks(this);
		DefaultBiomeFeatures.addFreezeTopLayer(this);
		
		CanadaFeatures.addOres(this);
		CanadaFeatures.addGypsum(this);
		CanadaFeatures.addOil(this);
		
		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(Feature.LAKE, new LakesConfig(Blocks.WATER.getDefaultState()), Placement.WATER_LAKE, new LakeChanceConfig(50)));
		this.addFeature(Decoration.SURFACE_STRUCTURES, createDecoratedFeature(CanadaFeatures.TREMBLING_ASPEN_TREE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(4, 4.05F, 4)));
		
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(CanadaEntities.MOOSE, 200, 2, 8));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(CanadaEntities.MINER, 120, 2, 5));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(CanadaEntities.SILTSTONE_GOLEM, 110, 1, 1));

		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));

		this.setRegistryName(Main.location("rocky_mountains"));
		
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(BlockPos pos) {

		return 0x20a822;

	}

}