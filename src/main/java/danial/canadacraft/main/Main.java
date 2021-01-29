package danial.canadacraft.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import danial.canadacraft.main.client.renders.EntityRenderRegistry;
import danial.canadacraft.main.init.enchantments.CanadaEnchantments;
import danial.canadacraft.main.init.paintings.CanadaPaintings;
import danial.canadacraft.main.init.world.dimensions.CanadaDimensions;
import danial.canadacraft.main.init.world.gen.OreGeneration;
import danial.canadacraft.main.init.world.gen.StructureGeneration;
import danial.canadacraft.main.init.world.structures.CanadaStructures;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("canadacraft")
public class Main {

	public static Main instance;
	public static final String MODID = "canadacraft";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final ItemGroup CANADA = new CreativeTab();

	public Main() {

		instance = this;
		
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onServerStartup);

		MinecraftForge.EVENT_BUS.register(this);
		
		CanadaPaintings.PAINTING_TYPES.register(modEventBus);
		CanadaEnchantments.ENCHANTMENTS.register(modEventBus);
		CanadaStructures.FEATURES.register(modEventBus);
		CanadaDimensions.registerDimensions();

	}

	private void setup(final FMLCommonSetupEvent event) {

		OreGeneration.setupOreGeneration();
		StructureGeneration.setupStructureGeneration();
		LOGGER.info("Setup method registered.");

	}

	private void clientRegistries(final FMLClientSetupEvent event) {

		EntityRenderRegistry.registerEntityRenders();
		LOGGER.info("clientRegistries method registered.");

	}


	private void onServerStartup(FMLServerStartingEvent e) {
		
		LOGGER.info("Server Starting...");
		
	}

	public static ResourceLocation location(String name) {

		return new ResourceLocation(MODID, name);

	}

}
