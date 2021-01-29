package danial.canadacraft.main.init.entities;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class CanadaEntities {
	
	public static EntityType<?> BEAVER = EntityType.Builder.create(BeaverEntity::new, EntityClassification.CREATURE).size(0.7f, 0.4f).build(Main.MODID + ":beaver_entity").setRegistryName(Main.location("beaver_entity"));
	public static EntityType<?> MOOSE = EntityType.Builder.create(MooseEntity::new, EntityClassification.CREATURE).size(1.1F, 1.3F).build(Main.MODID + ":moose_entity").setRegistryName(Main.location("moose_entity"));
	public static EntityType<?> MAPLE_MONSTER = EntityType.Builder.create(MapleMonsterEntity::new, EntityClassification.MONSTER).size(1.3f, 2.1f).build(Main.MODID + ":maple_monster_entity").setRegistryName(Main.location("maple_monster_entity"));
	public static EntityType<?> MINER = EntityType.Builder.create(MinerEntity::new, EntityClassification.MONSTER).size(0.8F, 2.3F).build(Main.MODID + ":miner_entity").setRegistryName(Main.location("miner_entity"));
	public static EntityType<?> GRIZZLY_BEAR = EntityType.Builder.create(GrizzlyBearEntity::new, EntityClassification.CREATURE).size(1.4F, 1.4F).build(Main.MODID + ":grizzly_bear_entity").setRegistryName(Main.location("grizzly_bear_entity"));
	public static EntityType<?> SILTSTONE_GOLEM = EntityType.Builder.create(SiltstoneGolemEntity::new, EntityClassification.CREATURE).size(3f, 3f).build(Main.MODID + ":siltstone_golem_entity").setRegistryName(Main.location("siltstone_golem_entity"));
	public static EntityType<?> GYPSUM_GOLEM = EntityType.Builder.create(GypsumGolemEntity::new, EntityClassification.MISC).build(Main.MODID + ":gypsum_golem_entity").setRegistryName(Main.location("gypsum_golem_entity"));
	public static EntityType<?> MAPLE_BOSS = EntityType.Builder.create(MapleBossEntity::new, EntityClassification.MONSTER).size(1.9f, 2.1f).build(Main.MODID + ":maple_boss_entity").setRegistryName(Main.location("maple_boss_entity"));
	public static EntityType<?> WOOD_RUNNER = EntityType.Builder.create(WoodRunnerEntity::new, EntityClassification.MISC).size(0.6F, 1.95F).build(Main.MODID + ":wood_runner_entity").setRegistryName(Main.location("wood_runner_entity"));
	public static EntityType<?> BERRY_BLOB_HUCKLE_ENTITY = EntityType.Builder.create(BerryBlobHuckleEntity::new, EntityClassification.MONSTER).size(2.04F, 2.04F).build(Main.MODID + ":berry_blob_huckle_entity").setRegistryName(Main.location("berry_blob_huckle_entity"));
	public static EntityType<?> BERRY_BLOB_SALMON_ENTITY = EntityType.Builder.create(BerryBlobSalmonEntity::new, EntityClassification.MONSTER).size(2.04F, 2.04F).build(Main.MODID + ":berry_blob_salmon_entity").setRegistryName(Main.location("berry_blob_salmon_entity"));
	public static EntityType<?> BERRY_BLOB_THIMBLE_ENTITY = EntityType.Builder.create(BerryBlobThimbleEntity::new, EntityClassification.MONSTER).size(2.04F, 2.04F).build(Main.MODID + ":berry_blob_thimble_entity").setRegistryName(Main.location("berry_blob_thimble_entity"));
	public static EntityType<?> BERRY_BOSS_ENTITY = EntityType.Builder.create(BerryBossEntity::new, EntityClassification.MONSTER).size(1F, 3F).build(Main.MODID + ":berry_boss_entity").setRegistryName(Main.location("berry_boss_entity"));
	public static EntityType<?> SILTSTONE_BOSS_ENTITY = EntityType.Builder.create(SiltstoneBossEntity::new, EntityClassification.MONSTER).size(1F, 2.7F).build(Main.MODID + ":silt_stone_boss_entity").setRegistryName(Main.location("silt_stone_boss_entity"));
	public static EntityType<?> CANADA_BOSS_ENTITY = EntityType.Builder.create(CanadaBossEntity::new, EntityClassification.MONSTER).size(1F, 2.0F).build(Main.MODID + ":canada_boss_entity").setRegistryName(Main.location("canada_boss_entity"));

	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event) {

		event.getRegistry().registerAll(

				CanadaItems.beaver_entity_egg = registerEntitySpawnEgg(BEAVER, 0xba9a88, 0x423731, "beaver_entity_egg"),
				CanadaItems.moose_entity_egg = registerEntitySpawnEgg(MOOSE, 0xdbda8a, 0x382508, "moose_entity_egg"),
				CanadaItems.grizzly_bear_entity_egg = registerEntitySpawnEgg(GRIZZLY_BEAR, 0x826452, 0x30231a, "grizzly_bear_entity_egg"),
				CanadaItems.wood_runner_entity_egg = registerEntitySpawnEgg(WOOD_RUNNER, 0xDEB887, 0x690817, "wood_runner_entity_egg"),
				CanadaItems.gypsum_golem_entity_egg = registerEntitySpawnEgg(GYPSUM_GOLEM, 0xF4F599, 0xEEF087, "gypsum_golem_entity_egg"),
				CanadaItems.maple_monster_entity_egg = registerEntitySpawnEgg(MAPLE_MONSTER, 0xffc400, 0xff8800, "maple_monster_entity_egg"),
				CanadaItems.miner_entity_egg = registerEntitySpawnEgg(MINER, 0x0845ff, 0x694c31, "miner_entity_egg"),
				CanadaItems.silt_stone_golem_entity_egg = registerEntitySpawnEgg(SILTSTONE_GOLEM, 0x5E2C03, 0xde7600, "silt_stone_golem_entity_egg"),
				CanadaItems.berry_blob_huckle_entity_egg = registerEntitySpawnEgg(BERRY_BLOB_HUCKLE_ENTITY, 0x323aa8, 0x5f11d4, "berry_blob_huckle_entity_egg"),
				CanadaItems.berry_blob_salmon_entity_egg = registerEntitySpawnEgg(BERRY_BLOB_SALMON_ENTITY, 0xE98432, 0xA35B23, "berry_blob_salmon_entity_egg"),
				CanadaItems.berry_blob_thimble_entity_egg = registerEntitySpawnEgg(BERRY_BLOB_THIMBLE_ENTITY, 0x920005, 0x600004, "berry_blob_thimble_entity_egg")
								
		);

	}

	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) {

		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(Main.CANADA));
		item.setRegistryName(Main.location(name));
		return item;

	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {

			event.getRegistry().registerAll(

					CanadaEntities.BEAVER, 
					CanadaEntities.MOOSE, 
					CanadaEntities.MAPLE_MONSTER, 
					CanadaEntities.MINER,
					CanadaEntities.GRIZZLY_BEAR,
					CanadaEntities.SILTSTONE_GOLEM,
					CanadaEntities.GYPSUM_GOLEM,
					CanadaEntities.MAPLE_BOSS,
					CanadaEntities.WOOD_RUNNER,
					CanadaEntities.BERRY_BLOB_HUCKLE_ENTITY,
					CanadaEntities.BERRY_BLOB_SALMON_ENTITY,
					CanadaEntities.BERRY_BLOB_THIMBLE_ENTITY,
					CanadaEntities.BERRY_BOSS_ENTITY,
					CanadaEntities.SILTSTONE_BOSS_ENTITY,
					CanadaEntities.CANADA_BOSS_ENTITY
					
			);
		}
	}

}
