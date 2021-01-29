package danial.canadacraft.main.init.world.biomes;

import danial.canadacraft.main.Main;
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
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.LakeChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DeciduousForest extends Biome {

	public DeciduousForest() {

		super((new Biome.Builder()) .surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.CLAY.getDefaultState()))).precipitation(RainType.RAIN).category(Category.FOREST).depth(0.25F).temperature(0.3F).waterColor(0x63faff).waterFogColor(0xa1ebed).scale(0.9F).parent((String) null).downfall(0.1F));

		this.getRiver();
		this.addFeature(Decoration.SURFACE_STRUCTURES, createDecoratedFeature(CanadaFeatures.MAPLE_TREE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(2, 0.05F, 1)));
		this.addFeature(Decoration.SURFACE_STRUCTURES, createDecoratedFeature(CanadaFeatures.RED_WOOD_TREE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(1, 0.025F, 1)));
		this.addFeature(Decoration.SURFACE_STRUCTURES, createDecoratedFeature(CanadaFeatures.TREMBLING_ASPEN_TREE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(1, 0.1F, 1)));

		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(Feature.LAKE, new LakesConfig(Blocks.WATER.getDefaultState()), Placement.WATER_LAKE, new LakeChanceConfig(50)));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR, new MultipleRandomFeatureConfig(new Feature[] { Feature.JUNGLE_TREE, Feature.FANCY_TREE }, new IFeatureConfig[] { IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG }, new float[] { 0.2F, 0.1F }, Feature.DARK_OAK_TREE, IFeatureConfig.NO_FEATURE_CONFIG), Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(10, 0.1F, 1)));
		
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addFossils(this);
		DefaultBiomeFeatures.addForestTrees(this);
		DefaultBiomeFeatures.addBerryBushes(this);
		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addDoubleFlowers(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addExtraReedsPumpkinsCactus(this);
		DefaultBiomeFeatures.addJunglePlants(this);
		DefaultBiomeFeatures.addExtraDefaultFlowers(this);
		DefaultBiomeFeatures.addBirchTrees(this);
		DefaultBiomeFeatures.addHugeMushrooms(this);
		DefaultBiomeFeatures.addJungleGrass(this);
		DefaultBiomeFeatures.addTaigaConifers(this);
		DefaultBiomeFeatures.addSprings(this);
		
		CanadaFeatures.addCornGrass(this);
		CanadaFeatures.addTrillium(this);
		CanadaFeatures.addGypsum(this);

		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.BEAVER, 625, 2, 8));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.MOOSE, 625, 2, 8));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.GRIZZLY_BEAR, 625, 2, 6));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.WOOD_RUNNER, 450, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));

		this.setRegistryName(Main.location("deciduous_forest"));

	}

	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(BlockPos pos) {

		return 0x02bf0f;

	}

	@OnlyIn(Dist.CLIENT)
	public int getFoliageColor(BlockPos pos) {

		return 0x47cc00;

	}

}