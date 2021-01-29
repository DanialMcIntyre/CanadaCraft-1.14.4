package danial.canadacraft.main.init.world.features;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import danial.canadacraft.main.init.blocks.CanadaBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class TrilliumFeature extends FlowersFeature {

	public TrilliumFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i51426_1_) {

		super(p_i51426_1_);

	}

	public BlockState getRandomFlower(Random random, BlockPos pos) {

		return CanadaBlocks.trillium.getDefaultState();

	}

}
