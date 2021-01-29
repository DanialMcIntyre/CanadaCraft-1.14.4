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
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RedWoodForest extends Biome {

	protected RedWoodForest() {

		super((new Biome.Builder()).surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.CLAY.getDefaultState()))).precipitation(RainType.RAIN).category(Category.FOREST).depth(0.1F).temperature(0.5F).waterColor(0x4287f5).waterFogColor(0x4287f5).scale(0.2F).parent((String) null).downfall(0.1F));

		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addFossils(this);
		DefaultBiomeFeatures.addGrass(this);
		DefaultBiomeFeatures.addLakes(this);
		DefaultBiomeFeatures.addOres(this);
		
		CanadaFeatures.addBerryMushPonds(this);
		CanadaFeatures.addHuckleBerries(this);
		CanadaFeatures.addThimbleBerries(this);
		CanadaFeatures.addSalmonBerries(this);
		CanadaFeatures.addGypsum(this);
		
		this.addFeature(Decoration.SURFACE_STRUCTURES, createDecoratedFeature(CanadaFeatures.RED_WOOD_TREE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(5, 5.05F, 5)));
		this.getRiver();
		
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.BEAVER, 450, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.MOOSE, 350, 4, 8));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.GRIZZLY_BEAR, 650, 2, 6));

		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(CanadaEntities.BERRY_BLOB_HUCKLE_ENTITY, 1, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(CanadaEntities.BERRY_BLOB_SALMON_ENTITY, 1, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(CanadaEntities.BERRY_BLOB_THIMBLE_ENTITY, 1, 1, 1));
		
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));

		this.setRegistryName(Main.location("red_wood_forest"));

	}

	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(BlockPos pos) {

		return 0x992f0c;

	}

}
