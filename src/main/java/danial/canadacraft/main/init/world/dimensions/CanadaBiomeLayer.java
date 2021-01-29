package danial.canadacraft.main.init.world.dimensions;

import java.util.ArrayList;

import com.google.common.collect.ImmutableList;

import danial.canadacraft.main.init.world.biomes.CanadaBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class CanadaBiomeLayer implements IC0Transformer {
	
	public static ImmutableList<BiomeManager.BiomeEntry> getBiomesToGeneration() {
		
		ArrayList<BiomeManager.BiomeEntry> list = new ArrayList<>();
		list.add(new BiomeManager.BiomeEntry(CanadaBiomes.deciduous_forest, 80));
		list.add(new BiomeManager.BiomeEntry(CanadaBiomes.maple_forest, 60));
		list.add(new BiomeManager.BiomeEntry(CanadaBiomes.red_wood_forest, 60));
		list.add(new BiomeManager.BiomeEntry(CanadaBiomes.rocky_mountains, 5));
		list.add(new BiomeManager.BiomeEntry(CanadaBiomes.snowy_deciduous_forest, 30));
		list.add(new BiomeManager.BiomeEntry(CanadaBiomes.snowy_maple_forest, 20));
		list.add(new BiomeManager.BiomeEntry(CanadaBiomes.snowy_red_wood_forest, 20));
		list.add(new BiomeManager.BiomeEntry(CanadaBiomes.prairie, 40));
		list.add(new BiomeManager.BiomeEntry(Biomes.OCEAN, 20));
		return ImmutableList.copyOf(list);
		
	}

	@SuppressWarnings("unchecked")
	private java.util.List<BiomeEntry>[] biomes = new java.util.ArrayList[BiomeType.values().length];
	private final CanadaGenSettings settings;

	public CanadaBiomeLayer(WorldType p_i48641_1_, CanadaGenSettings p_i48641_2_) {
		
		for (BiomeType type : BiomeType.values()) {
			
			ImmutableList<BiomeManager.BiomeEntry> biomesToAdd = getBiomesToGeneration();
			int idx = type.ordinal();

			if (biomes[idx] == null)
				biomes[idx] = new java.util.ArrayList<BiomeEntry>();

			if (biomesToAdd != null)
				biomes[idx].addAll(biomesToAdd);
			
		}

		if (p_i48641_1_ == WorldType.DEFAULT_1_1) {
			
			this.settings = null;
			
		} else {
			
			this.settings = p_i48641_2_;
			
		}
		
	}

	@SuppressWarnings("deprecation")
	public int apply(INoiseRandom context, int value) {
		
		if (this.settings != null && this.settings.getBiomeId() >= 0) {
			
			return this.settings.getBiomeId();
			
		} else {
			
			return Registry.BIOME.getId(getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType.DESERT, context).biome);
		
		}

	}

	protected BiomeEntry getWeightedBiomeEntry(BiomeType type, INoiseRandom context) {
		
		java.util.List<BiomeEntry> biomeList = biomes[type.ordinal()];
		int totalWeight = net.minecraft.util.WeightedRandom.getTotalWeight(biomeList);
		int weight = BiomeManager.isTypeListModded(type) ? context.random(totalWeight) : context.random(totalWeight / 10) * 10;
		return (BiomeEntry) net.minecraft.util.WeightedRandom.getRandomItem(biomeList, weight);
		
	}

}
