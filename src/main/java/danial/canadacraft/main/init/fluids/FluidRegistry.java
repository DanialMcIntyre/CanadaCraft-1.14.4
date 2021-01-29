package danial.canadacraft.main.init.fluids;

import danial.canadacraft.main.Main;
import danial.canadacraft.main.init.fluids.BerryFluid.BerryFlowing;
import danial.canadacraft.main.init.fluids.BerryFluid.BerrySource;
import danial.canadacraft.main.init.fluids.MapleFluid.MapleFlowing;
import danial.canadacraft.main.init.fluids.MapleFluid.MapleSource;
import danial.canadacraft.main.init.fluids.OilFluid.OilFlowing;
import danial.canadacraft.main.init.fluids.OilFluid.OilSource;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class FluidRegistry {

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void registerFluids(final RegistryEvent.Register<Fluid> event) {

			event.getRegistry().registerAll(
					
					CanadaFluids.flowing_maple = (MapleFlowing) new MapleFluid.MapleFlowing().setRegistryName(Main.location("flowing_maple")),
					CanadaFluids.maple = (MapleSource) new MapleFluid.MapleSource().setRegistryName(Main.location("maple")),
					
					CanadaFluids.flowing_berry = (BerryFlowing) new BerryFluid.BerryFlowing().setRegistryName(Main.location("flowing_berry")),
					CanadaFluids.berry = (BerrySource) new BerryFluid.BerrySource().setRegistryName(Main.location("berry")),
					
					CanadaFluids.flowing_oil = (OilFlowing) new OilFluid.OilFlowing().setRegistryName(Main.location("flowing_oil")),
					CanadaFluids.oil = (OilSource) new OilFluid.OilSource().setRegistryName(Main.location("oil"))


			);

		}
		
	}
	
}
