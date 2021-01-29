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

public class SnowyMapleForest extends Biome {

	public SnowyMapleForest() {

		super((new Biome.Builder()).surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.CLAY.getDefaultState()))).precipitation(RainType.SNOW).category(Category.ICY).depth(0.1F).temperature(0.0F).waterColor(0xfcb603).waterFogColor(0xa1ebed).scale(0.2F).parent((String) null).downfall(0.1F));

		this.getRiver();
		this.addFeature(Decoration.SURFACE_STRUCTURES, createDecoratedFeature(CanadaFeatures.MAPLE_TREE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(3, 3.05F, 3)));

		CanadaFeatures.addCornGrass(this);
		CanadaFeatures.addMapleNectarPonds(this);
		CanadaFeatures.addGypsum(this);
		
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addGrass(this);
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addFreezeTopLayer(this);

		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.BEAVER, 425, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.MOOSE, 350, 4, 8));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.GRIZZLY_BEAR, 350, 2, 6));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(CanadaEntities.MAPLE_MONSTER, 75, 1, 2));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));

		this.setRegistryName(Main.location("snowy_maple_forest"));

	}

	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(BlockPos pos) {

		return 0xd6610d;

	}

}