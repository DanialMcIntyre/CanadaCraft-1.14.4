package danial.canadacraft.main.init.world.dimensions;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import danial.canadacraft.main.init.world.biomes.CanadaBiomes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.storage.WorldInfo;

public class CanadaBiomeProvider extends BiomeProvider {
	
	private final Layer genBiomes;
	private final Layer biomeFactoryLayer;
	
	private final Biome[] biomes = new Biome[] { CanadaBiomes.deciduous_forest, CanadaBiomes.maple_forest,
			CanadaBiomes.red_wood_forest, CanadaBiomes.rocky_mountains, CanadaBiomes.snowy_deciduous_forest,
			CanadaBiomes.snowy_maple_forest, CanadaBiomes.snowy_red_wood_forest, CanadaBiomes.prairie, Biomes.OCEAN};

	public CanadaBiomeProvider(CanadaBiomeProviderSettings settingsProvider) {
		
		WorldInfo worldinfo = settingsProvider.getWorldInfo();
		CanadaGenSettings overworldgensettings = settingsProvider.getGeneratorSettings();
		Layer[] alayer = CanadaLayerUtil.buildOverworldProcedure(worldinfo.getSeed(), new CanadaWorldType(), overworldgensettings);
		this.genBiomes = alayer[0];
		this.biomeFactoryLayer = alayer[1];
		
	}

	public Biome getBiome(int x, int y) {
		
		return this.biomeFactoryLayer.func_215738_a(x, y);
		
	}

	public Biome func_222366_b(int p_222366_1_, int p_222366_2_) {
		
		return this.genBiomes.func_215738_a(p_222366_1_, p_222366_2_);
		
	}

	public Biome[] getBiomes(int x, int z, int width, int length, boolean cacheFlag) {
		
		return this.biomeFactoryLayer.generateBiomes(x, z, width, length);
		
	}

	public Set<Biome> getBiomesInSquare(int centerX, int centerZ, int sideLength) {
		
		int i = centerX - sideLength >> 2;
		int j = centerZ - sideLength >> 2;
		int k = centerX + sideLength >> 2;
		int l = centerZ + sideLength >> 2;
		int i1 = k - i + 1;
		int j1 = l - j + 1;
		Set<Biome> set = Sets.newHashSet();
		Collections.addAll(set, this.genBiomes.generateBiomes(i, j, i1, j1));
		return set;
		
	}

	@Nullable
	public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
		
		int i = x - range >> 2;
		int j = z - range >> 2;
		int k = x + range >> 2;
		int l = z + range >> 2;
		int i1 = k - i + 1;
		int j1 = l - j + 1;
		Biome[] abiome = this.genBiomes.generateBiomes(i, j, i1, j1);
		BlockPos blockpos = null;
		int k1 = 0;

		for (int l1 = 0; l1 < i1 * j1; ++l1) {
			
			int i2 = i + l1 % i1 << 2;
			int j2 = j + l1 / i1 << 2;
			if (biomes.contains(abiome[l1])) {
				
				if (blockpos == null || random.nextInt(k1 + 1) == 0) {
					
					blockpos = new BlockPos(i2, 0, j2);
					
				}

				++k1;
				
			}
			
		}

		return blockpos;
		
	}

	public boolean hasStructure(Structure<?> structureIn) {
		
		return true;
		
	}

	public Set<BlockState> getSurfaceBlocks() {
		
		if (this.topBlocksCache.isEmpty()) {
			
			for (Biome biome : this.biomes) {
				
				this.topBlocksCache.add(biome.getSurfaceBuilderConfig().getTop());
				
			}
			
		}

		return this.topBlocksCache;
		
	}
	
}