package danial.canadacraft.main.init.world.dimensions;

import danial.canadacraft.main.Main;
import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class CanadaDimensions {

	public static final CanadaModDimension LAYER_ONE = new CanadaModDimension(new ResourceLocation(Main.MODID, "canada_dimension"));

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void registerModDimensions(final RegistryEvent.Register<ModDimension> event) {

			event.getRegistry().registerAll(

					LAYER_ONE

			);

		}

	}

	public static void registerDimensions() {
		
		DimensionManager.registerDimension(new ResourceLocation(Main.MODID, "canada_dimension"), LAYER_ONE, new PacketBuffer(Unpooled.buffer(16)), true);
	
	}

}
