package danial.canadacraft.main.init.world.features;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import danial.canadacraft.main.init.blocks.CanadaBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.HugeTreesFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class RedWoodTreeFeature extends HugeTreesFeature<NoFeatureConfig> {

	private static final BlockState TRUNK = CanadaBlocks.red_wood_log.getDefaultState();
	private static final BlockState LEAF = CanadaBlocks.red_wood_leaves.getDefaultState();
	private final boolean useBaseHeight;

	public RedWoodTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn, boolean doBlockNotifyOnPlace, boolean useBaseHeightIn) {
		
		super(configFactoryIn, doBlockNotifyOnPlace, 13, 15, TRUNK, LEAF);
		this.useBaseHeight = useBaseHeightIn;
		this.setSapling((net.minecraftforge.common.IPlantable) CanadaBlocks.red_wood_sapling);
	
	}

	public boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position, MutableBoundingBox p_208519_5_) {
		
		int i = this.getHeight(rand);
		
		if (!this.func_203427_a(worldIn, position, i)) {
			
			return false;
			
		} else {
			
			this.func_214596_a(worldIn, position.getX(), position.getZ(), position.getY() + i, 0, rand, p_208519_5_, changedBlocks);

			for (int j = 0; j < i; ++j) {
				
				if (isAirOrLeaves(worldIn, position.up(j))) {
					
					this.setLogState(changedBlocks, worldIn, position.up(j), this.trunk, p_208519_5_);
					
				}

				if (j < i - 1) {
					
					if (isAirOrLeaves(worldIn, position.add(1, j, 0))) {
						
						this.setLogState(changedBlocks, worldIn, position.add(1, j, 0), this.trunk, p_208519_5_);
					
					}

					if (isAirOrLeaves(worldIn, position.add(1, j, 1))) {
						
						this.setLogState(changedBlocks, worldIn, position.add(1, j, 1), this.trunk, p_208519_5_);
					
					}

					if (isAirOrLeaves(worldIn, position.add(0, j, 1))) {
						
						this.setLogState(changedBlocks, worldIn, position.add(0, j, 1), this.trunk, p_208519_5_);
					
					}
					
				}
				
			}

			return true;
			
		}
		
	}

	private void func_214596_a(IWorldGenerationReader p_214596_1_, int p_214596_2_, int p_214596_3_, int p_214596_4_, int p_214596_5_, Random p_214596_6_, MutableBoundingBox p_214596_7_, Set<BlockPos> p_214596_8_) {
		
		int i = p_214596_6_.nextInt(5) + (this.useBaseHeight ? this.baseHeight : 3);
		int j = 0;

		for (int k = p_214596_4_ - i; k <= p_214596_4_; ++k) {
			
			int l = p_214596_4_ - k;
			int i1 = p_214596_5_ + MathHelper.floor((float) l / (float) i * 3.5F);
			this.func_222839_a(p_214596_1_, new BlockPos(p_214596_2_, k, p_214596_3_), i1 + (l > 0 && i1 == j && (k & 1) == 0 ? 1 : 0), p_214596_7_, p_214596_8_);
			j = i1;
			
		}
		
	}
	
}