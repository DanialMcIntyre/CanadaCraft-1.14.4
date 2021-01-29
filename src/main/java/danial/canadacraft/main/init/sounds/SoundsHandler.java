package danial.canadacraft.main.init.sounds;

import java.util.List;

import com.google.common.collect.Lists;

import danial.canadacraft.main.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD)
@ObjectHolder(Main.MODID)
public class SoundsHandler {

	private static List<SoundEvent> sounds = Lists.newArrayList();

	public static final SoundEvent ENTITY_BEAVER_AMBIENT = registerSound("entity.beaver.ambient");
	public static final SoundEvent ENTITY_BEAVER_DEATH = registerSound("entity.beaver.death");
	public static final SoundEvent ENTITY_BEAVER_HURT = registerSound("entity.beaver.hurt");

	public static final SoundEvent ENTITY_MOOSE_AMBIENT = registerSound("entity.moose.ambient");
	public static final SoundEvent ENTITY_MOOSE_DEATH = registerSound("entity.moose.death");
	public static final SoundEvent ENTITY_MOOSE_HURT = registerSound("entity.moose.hurt");

	public static final SoundEvent ENTITY_MAPLE_MONSTER_AMBIENT = registerSound("entity.maple_monster.ambient");
	public static final SoundEvent ENTITY_MAPLE_MONSTER_DEATH = registerSound("entity.maple_monster.death");
	public static final SoundEvent ENTITY_MAPLE_MONSTER_HURT = registerSound("entity.maple_monster.hurt");
	
	public static final SoundEvent ENTITY_MAPLE_MONSTER_BOSS_AMBIENT = registerSound("entity.maple_monster_boss.ambient");
	public static final SoundEvent ENTITY_MAPLE_MONSTER_BOSS_DEATH = registerSound("entity.maple_monster_boss.death");
	public static final SoundEvent ENTITY_MAPLE_MONSTER_BOSS_HURT = registerSound("entity.maple_monster_boss.hurt");

	public static final SoundEvent ENTITY_MINER_AMBIENT = registerSound("entity.miner.ambient");
	public static final SoundEvent ENTITY_MINER_DEATH = registerSound("entity.miner.death");
	public static final SoundEvent ENTITY_MINER_HURT = registerSound("entity.miner.hurt");

	public static final SoundEvent ENTITY_GRIZZLY_BEAR_AMBIENT = registerSound("entity.grizzly_bear.ambient");
	public static final SoundEvent ENTITY_GRIZZLY_BEAR_DEATH = registerSound("entity.grizzly_bear.death");
	public static final SoundEvent ENTITY_GRIZZLY_BEAR_HURT = registerSound("entity.grizzly_bear.hurt");
	
	public static final SoundEvent ENTITY_SILT_STONE_GOLEM_AMBIENT = registerSound("entity.silt_stone_golem.ambient");
	public static final SoundEvent ENTITY_SILT_STONE_GOLEM_DEATH = registerSound("entity.silt_stone_golem.death");
	public static final SoundEvent ENTITY_SILT_STONE_GOLEM_HURT = registerSound("entity.silt_stone_golem.hurt");
	
	public static final SoundEvent CANADA_ANTHEM = registerSound("item.canada_disc.disc");
	
	public static SoundEvent registerSound(String name) {

		ResourceLocation location = new ResourceLocation(Main.MODID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;

	}

	@SubscribeEvent
	public static void registerSound(RegistryEvent.Register<SoundEvent> event) {

		for (SoundEvent sound : sounds) {

			event.getRegistry().register(sound);

		}
		
	}

}
