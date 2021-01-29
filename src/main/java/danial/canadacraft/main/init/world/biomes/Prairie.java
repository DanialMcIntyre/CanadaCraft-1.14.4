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
import net.minecraft.world.gen.feature.DoublePlantConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Prairie extends Biome {

	public Prairie() {

		super((new Biome.Builder()).surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.CLAY.getDefaultState()))).precipitation(RainType.RAIN).category(Category.PLAINS).depth(0.0F).temperature(0.5F).waterColor(0x2ca1d4).waterFogColor(0xa1ebed).scale(0.0F).parent((String) null).downfall(0.1F));

		this.getRiver();
		CanadaFeatures.addGypsum(this);
		
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addGrass(this);
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addOres(this);
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DOUBLE_PLANT, new DoublePlantConfig(Blocks.TALL_GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(64)));


		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.BEAVER, 425, 4, 10));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.MOOSE, 350, 4, 8));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(CanadaEntities.GRIZZLY_BEAR, 400, 2, 6));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));

		this.setRegistryName(Main.location("prairie"));

	}

	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(BlockPos pos) {

		return 0xd9d636;

	}

}