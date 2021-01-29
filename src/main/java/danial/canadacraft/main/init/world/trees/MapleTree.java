package danial.canadacraft.main.init.world.trees;

import java.util.Random;

import javax.annotation.Nullable;

import danial.canadacraft.main.init.world.features.MapleTreeFeature;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class MapleTree extends Tree {

	@Nullable
	protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {

		return new MapleTreeFeature(NoFeatureConfig::deserialize, true, false);

	}

}
