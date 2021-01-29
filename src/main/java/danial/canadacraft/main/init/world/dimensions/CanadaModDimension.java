package danial.canadacraft.main.init.world.dimensions;

import java.util.function.BiFunction;

import danial.canadacraft.main.Main;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

public class CanadaModDimension extends ModDimension {

	public CanadaModDimension(final ResourceLocation registryName) {
		
		this.setRegistryName(registryName);
		
	}

	public static DimensionType getDimensionType() {
		
		return DimensionType.byName(new ResourceLocation(Main.MODID, "canada_dimension"));
		
	}

	@Override
	public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
		
		return CanadaDimension::new;
		
	}

}
