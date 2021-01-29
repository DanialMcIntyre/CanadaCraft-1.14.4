package danial.canadacraft.main.init.tools.effects;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import danial.canadacraft.main.init.blocks.CanadaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BerryHoe extends SwordItem {

	public static final Map<Block, BlockState> HOE_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK,
			Blocks.FARMLAND.getDefaultState(), Blocks.GRASS_PATH, Blocks.FARMLAND.getDefaultState(), Blocks.DIRT,
			Blocks.FARMLAND.getDefaultState(), Blocks.COARSE_DIRT, Blocks.DIRT.getDefaultState()));

	public BerryHoe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {

		super(tier, attackDamageIn, attackSpeedIn, builder);

	}

	public boolean hitEntity(ItemStack item, LivingEntity target, LivingEntity attacker) {

		target.addPotionEffect(new EffectInstance(Effects.WITHER, 40, 2, true, true));

		return super.hitEntity(item, target, attacker);

	}

	public ActionResultType onItemUse(ItemUseContext context) {

		World world = context.getWorld();
		BlockPos blockpos = context.getPos();
		BlockState state = context.getWorld().getBlockState(blockpos);
		BlockPos newblockpos;

		int y = blockpos.getY();
		int x = blockpos.getX();
		int z = blockpos.getZ();

		int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);

		if (hook != 0)
			return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;

		if (context.getFace() != Direction.DOWN && world.isAirBlock(blockpos.up())) {

			BlockState blockstate = HOE_LOOKUP.get(world.getBlockState(blockpos).getBlock());

			if (blockstate != null) {

				PlayerEntity playerentity = context.getPlayer();
				world.playSound(playerentity, blockpos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

				if (!world.isRemote) {

					world.setBlockState(blockpos, blockstate, 11);

					if (playerentity != null) {

						context.getItem().damageItem(1, playerentity, (p_220043_1_) -> {

							p_220043_1_.sendBreakAnimation(context.getHand());

						});
					}
				}

				return ActionResultType.SUCCESS;

			} else if (state != Blocks.FARMLAND.getDefaultState() && state != CanadaBlocks.berry_mush.getDefaultState() && state != Blocks.GRASS.getDefaultState()) {
				
				PlayerEntity playerentity = context.getPlayer();

				if (!world.isRemote) {

					newblockpos = blockpos.add(x - x, y - y + 1, z - z);
					world.setBlockState(newblockpos, CanadaBlocks.berry_mush.getDefaultState());

					if (playerentity != null) {

						context.getItem().damageItem(1, playerentity, (p_220043_1_) -> {

							p_220043_1_.sendBreakAnimation(context.getHand());

						});
					}

					return ActionResultType.SUCCESS;

				}
				
			}

		}
		
		return ActionResultType.PASS;

	}

}
