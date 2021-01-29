package danial.canadacraft.main.init.world.trees;

import java.util.Random;

import javax.annotation.Nullable;

import danial.canadacraft.main.init.world.features.RedWoodTreeFeature;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class RedWoodTree extends Tree {

	@Nullable
	protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {

		return new RedWoodTreeFeature(NoFeatureConfig::deserialize, true, false);

	}

}
