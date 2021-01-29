package danial.canadacraft.main.init.world.structures;

import java.util.Random;
import java.util.function.Function;

import org.apache.logging.log4j.Level;

import com.mojang.datafixers.Dynamic;

import danial.canadacraft.main.Main;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MapleShackStructure extends Structure<NoFeatureConfig> {
	
	public MapleShackStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		
		super(config);
		
	}

	@Override
	protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> chunkGenerator, Random random, int x, int z, int spacingOffsetsX, int spacingOffsetsZ) {

		int maxDistance = 28;
		int minDistance = 18;

		int xTemp = x + maxDistance * spacingOffsetsX;
		int ztemp = z + maxDistance * spacingOffsetsZ;
		int xTemp2 = xTemp < 0 ? xTemp - maxDistance + 1 : xTemp;
		int zTemp2 = ztemp < 0 ? ztemp - maxDistance + 1 : ztemp;
		int validChunkX = xTemp2 / maxDistance;
		int validChunkZ = zTemp2 / maxDistance;

		((SharedSeedRandom) random).setLargeFeatureSeedWithSalt(chunkGenerator.getSeed(), validChunkX, validChunkZ, this.getSeedModifier());
		validChunkX = validChunkX * maxDistance;
		validChunkZ = validChunkZ * maxDistance;
		validChunkX = validChunkX + random.nextInt(maxDistance - minDistance);
		validChunkZ = validChunkZ + random.nextInt(maxDistance - minDistance);

		return new ChunkPos(validChunkX, validChunkZ);
		
	}

	@Override
	public String getStructureName() {
		
		return Main.MODID + ":mapleshack";
		
	}

	@Override
	public int getSize() {
		
		return 0;
		
	}

	@Override
	public Structure.IStartFactory getStartFactory() {
		
		return MapleShackStructure.Start::new;
		
	}

	protected int getSeedModifier() {
		
		return 23485824;
		
	}

	public boolean hasStartAt(ChunkGenerator<?> chunkGen, Random rand, int chunkPosX, int chunkPosZ) {

		ChunkPos chunkpos = this.getStartPositionForPosition(chunkGen, rand, chunkPosX, chunkPosZ, 0, 0);

		if (chunkPosX == chunkpos.x && chunkPosZ == chunkpos.z) {

			Biome biome = chunkGen.getBiomeProvider().getBiome(new BlockPos(chunkPosX * 16 + 9, 0, chunkPosZ * 16 + 9));

			if (chunkGen.hasStructure(biome, this)) {

				return true;

			}

		}

		return false;
		
	}

	public static class Start extends StructureStart {
		
		public Start(Structure<?> p_i50678_1_, int p_i50678_2_, int p_i50678_3_, Biome p_i50678_4_, MutableBoundingBox p_i50678_5_, int p_i50678_6_, long p_i50678_7_) {
			
			super(p_i50678_1_, p_i50678_2_, p_i50678_3_, p_i50678_4_, p_i50678_5_, p_i50678_6_, p_i50678_7_);
			
		}

		@Override
		public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {

			Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];

			int x = (chunkX << 4) + 7;
			int z = (chunkZ << 4) + 7;

			int surfaceY = generator.func_222531_c(x, z, Heightmap.Type.WORLD_SURFACE_WG);
			BlockPos blockpos = new BlockPos(x, surfaceY, z);

			MapleShackPieces.start(templateManagerIn, blockpos, rotation, this.components, this.rand);

			this.recalculateStructureSize();
			Main.LOGGER.log(Level.DEBUG, "Maple SHACK at " + (blockpos.getX()) + " " + blockpos.getY() + " " + (blockpos.getZ()));
		
		}

	}
	
}