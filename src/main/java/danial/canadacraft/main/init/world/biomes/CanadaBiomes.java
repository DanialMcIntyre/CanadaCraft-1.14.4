package danial.canadacraft.main.init.world.biomes;

import net.minecraft.world.biome.Biome;
//import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
//import net.minecraftforge.common.BiomeManager;
//import net.minecraftforge.common.BiomeManager.BiomeEntry;
//import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class CanadaBiomes {
	
	public static Biome deciduous_forest;
	public static Biome maple_forest;
	public static Biome rocky_mountains;
	public static Biome red_wood_forest;
	
	public static Biome snowy_maple_forest;
	public static Biome snowy_deciduous_forest;
	public static Biome snowy_red_wood_forest;
	
	public static Biome prairie;
	
	public static void registerBiomes() {
		
		registerBiome(deciduous_forest, Type.MOUNTAIN, Type.FOREST, Type.RIVER, Type.HILLS);
		registerBiome(maple_forest, Type.FOREST, Type.RIVER);
		registerBiome(rocky_mountains, Type.FOREST, Type.RIVER, Type.MOUNTAIN);
		registerBiome(red_wood_forest, Type.FOREST, Type.RIVER, Type.PLAINS);
		
		registerBiome(snowy_deciduous_forest, Type.FOREST, Type.RIVER, Type.MOUNTAIN, Type.COLD, Type.SNOWY);
		registerBiome(snowy_maple_forest, Type.FOREST, Type.RIVER, Type.COLD, Type.SNOWY);
		registerBiome(snowy_red_wood_forest, Type.FOREST, Type.RIVER, Type.PLAINS, Type.COLD, Type.SNOWY);
		
		registerBiome(prairie, Type.PLAINS, Type.DRY);

	}

	public static void registerBiome(Biome biome, Type... types) {

		/*BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(deciduous_forest, 3));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(maple_forest, 3));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(red_wood_forest, 3));
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(rocky_mountains, 1));
		BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(snowy_deciduous_forest, 2));
		BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(snowy_maple_forest, 2));
		BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(snowy_red_wood_forest, 2));
		*/
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		
		@SubscribeEvent
		public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
			
			event.getRegistry().registerAll(
					
					CanadaBiomes.deciduous_forest = new DeciduousForest(),
					CanadaBiomes.maple_forest = new MapleForest(),
					CanadaBiomes.rocky_mountains = new RockyMountains(),
					CanadaBiomes.red_wood_forest = new RedWoodForest(),
					
					CanadaBiomes.snowy_deciduous_forest = new SnowyDeciduousForest(),
					CanadaBiomes.snowy_maple_forest = new SnowyMapleForest(),
					CanadaBiomes.snowy_red_wood_forest = new SnowyRedWoodForest(),
					
					CanadaBiomes.prairie = new Prairie()
					
					);
			
			CanadaBiomes.registerBiomes();
			
		}
		
	}
	
}
