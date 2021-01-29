package danial.canadacraft.main.init.fluids;

import danial.canadacraft.main.Main;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;

public class CanadaFluids {
	
	public static MapleFluid.MapleSource maple = null;
	public static MapleFluid.MapleFlowing flowing_maple = null;
	
	public static BerryFluid.BerrySource berry = null;
	public static BerryFluid.BerryFlowing flowing_berry = null;
	
	public static OilFluid.OilSource oil = null;
	public static OilFluid.OilFlowing flowing_oil = null;
	
	public static class Tags {
		
		public static final Tag<Fluid> MAPLE = new FluidTags.Wrapper(Main.location("maple"));
		public static final Tag<Fluid> BERRY = new FluidTags.Wrapper(Main.location("berry"));
		public static final Tag<Fluid> OIL = new FluidTags.Wrapper(Main.location("oil"));
		
	}

}
