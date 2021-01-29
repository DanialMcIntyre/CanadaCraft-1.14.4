package danial.canadacraft.main.init.world.dimensions;

import java.util.function.LongFunction;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.layer.EdgeBiomeLayer;
import net.minecraft.world.gen.layer.ZoomLayer;

public class CanadaWorldType extends WorldType {
	
	public CanadaWorldType() {
		
		super("canada_type");
		
	}

	@Override
	public <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> getBiomeLayer(IAreaFactory<T> parentLayer, OverworldGenSettings chunkSettings, LongFunction<C> contextFactory) {
		
		parentLayer = (new CanadaBiomeLayer(getWorldType(), (CanadaGenSettings) chunkSettings)).apply(contextFactory.apply(200L), parentLayer);
		parentLayer = CanadaLayerUtil.repeat(1000L, ZoomLayer.NORMAL, parentLayer, 2, contextFactory);
		parentLayer = EdgeBiomeLayer.INSTANCE.apply(contextFactory.apply(1000L), parentLayer);
		return parentLayer;
		
	}
	
}
