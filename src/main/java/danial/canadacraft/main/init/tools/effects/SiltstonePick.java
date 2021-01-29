package danial.canadacraft.main.init.tools.effects;

import java.util.List;

import danial.canadacraft.main.init.enchantments.SiltstoneBoostEnchantment;
import danial.canadacraft.main.init.enchantments.SiltstoneBoostEnchantment.SiltstoneBoostEquipped;
import danial.canadacraft.main.init.enchantments.SiltstonePowerEnchantment;
import danial.canadacraft.main.init.enchantments.SiltstonePowerEnchantment.SiltstonePowerEquipped;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class SiltstonePick extends PickaxeItem {

	public SiltstonePick(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {

		super(tier, attackDamageIn, attackSpeedIn, builder);

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {

		World world = context.getWorld();
		BlockPos blockpos = context.getPos();
		PlayerEntity player = context.getPlayer();
		BlockState detect;
		
		int x = blockpos.getX();
		int y = blockpos.getY();
		int z = blockpos.getZ();
		
		BlockPos newblockpos = blockpos;
		Direction direction = context.getPlayer().getAdjustedHorizontalFacing();

		if (!world.isRemote) {
			
			SiltstonePowerEquipped add = new SiltstonePowerEnchantment.SiltstonePowerEquipped();
			int power = add.getpower();

			for (int i = 1; i < 5 + power; i++) {

				detect = context.getWorld().getBlockState(newblockpos);

				if (detect == Blocks.STONE.getDefaultState() || detect == Blocks.COBBLESTONE.getDefaultState()) {

					world.setBlockState(newblockpos, Blocks.AIR.getDefaultState());
					spawnAsEntity(world, newblockpos, new ItemStack(Items.COBBLESTONE));

					if (direction == Direction.EAST) {

						newblockpos = blockpos.add(x - x + i, y - y, z - z);

					} else if (direction == Direction.NORTH) {

						newblockpos = blockpos.add(x - x, y - y, z - z - i);

					} else if (direction == Direction.WEST) {

						newblockpos = blockpos.add(x - x - i, y - y, z - z);

					} else if (direction == Direction.SOUTH) {

						newblockpos = blockpos.add(x - x, y - y, z - z + i);

					}
					
					if (player != null) {
						context.getItem().damageItem(1, player, (p_220040_1_) -> {
							p_220040_1_.sendBreakAnimation(context.getHand());
						});
						
					}

				}
				
			}

		}
		
		SiltstoneBoostEquipped mine = new SiltstoneBoostEnchantment.SiltstoneBoostEquipped();
		int cooldown = mine.getduration();
		
		world.playSound(player, blockpos, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
		player.getCooldownTracker().setCooldown(this, cooldown);

		return ActionResultType.SUCCESS;

	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

		tooltip.add(new StringTextComponent("\u00A77" + "Right click to mine four blocks in a row. Only effective on stone and cobblestone" + "\u00A77"));

	}

	public static void spawnAsEntity(World worldIn, BlockPos pos, ItemStack stack) {

		if (!worldIn.isRemote && !stack.isEmpty() && worldIn.getGameRules().getBoolean(GameRules.DO_TILE_DROPS) && !worldIn.restoringBlockSnapshots) {

			double d0 = (double) (worldIn.rand.nextFloat() * 0.5F) + 0.25D;
			double d1 = (double) (worldIn.rand.nextFloat() * 0.5F) + 0.25D;
			double d2 = (double) (worldIn.rand.nextFloat() * 0.5F) + 0.25D;
			ItemEntity itementity = new ItemEntity(worldIn, (double) pos.getX() + d0, (double) pos.getY() + d1, (double) pos.getZ() + d2, stack);
			itementity.setDefaultPickupDelay();
			worldIn.addEntity(itementity);

		}

	}

}
