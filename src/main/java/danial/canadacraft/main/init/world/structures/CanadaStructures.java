package danial.canadacraft.main.init.world.structures;

import java.util.Locale;

import danial.canadacraft.main.Main;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Bus.MOD, modid = Main.MODID)
public class CanadaStructures {

	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<Feature<?>>(ForgeRegistries.FEATURES, Main.MODID);
	
	public static IStructurePieceType ROCKYHOUSE_PIECE = RockyHousePieces.Piece::new;
	public static IStructurePieceType MAPLEDUNGEON_PIECE = MapleDungeonPieces.Piece::new;
	public static IStructurePieceType BOSSROOM_PIECE = BossRoomPieces.Piece::new;
	public static IStructurePieceType MAPLESHACK_PIECE = MapleShackPieces.Piece::new;
	public static IStructurePieceType VILLAGERHUT_PIECE = VillagerHutPieces.Piece::new;

	public static final RegistryObject<RockyHouseStructure> ROCKYHOUSE = FEATURES.register("rockyhouse", () -> new RockyHouseStructure(NoFeatureConfig::deserialize));
	public static final RegistryObject<MapleDungeonStructure> MAPLEDUNGEON = FEATURES.register("mapledungeon", () -> new MapleDungeonStructure(NoFeatureConfig::deserialize));
	public static final RegistryObject<BossRoomStructure> BOSSROOM = FEATURES.register("bossroom", () -> new BossRoomStructure(NoFeatureConfig::deserialize));
	public static final RegistryObject<MapleShackStructure> MAPLESHACK = FEATURES.register("mapleshack", () -> new MapleShackStructure(NoFeatureConfig::deserialize));
	public static final RegistryObject<VillagerHutStructure> VILLAGERHUT = FEATURES.register("villagerhut", () -> new VillagerHutStructure(NoFeatureConfig::deserialize));

	@SubscribeEvent
	public static void registerStructurePieces(RegistryEvent.Register<Feature<?>> event) {
		
		Registry.register(Registry.STRUCTURE_PIECE, "ROCKYHOUSE_PIECE".toLowerCase(Locale.ROOT), ROCKYHOUSE_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "MAPLEDUNGEON_PIECE".toLowerCase(Locale.ROOT), MAPLEDUNGEON_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "BOSSROOM_PIECE".toLowerCase(Locale.ROOT), BOSSROOM_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "MAPLESHACK_PIECE".toLowerCase(Locale.ROOT), MAPLESHACK_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "VILLAGERHUT_PIECE".toLowerCase(Locale.ROOT), VILLAGERHUT_PIECE);
		
	}
	
}
