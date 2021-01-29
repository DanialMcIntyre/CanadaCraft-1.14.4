package danial.canadacraft.main.init.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.Nullable;

import danial.canadacraft.main.init.entities.villager.TradeWithPlayerGoal;
import danial.canadacraft.main.init.entities.villager.WoodRunnerTrades;
import danial.canadacraft.main.init.items.CanadaItems;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.INPC;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.MoveTowardsRestrictionGoal;
import net.minecraft.entity.ai.goal.PrioritizedGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.Constants;

public class WoodRunnerEntity extends AnimalEntity implements INPC, IMerchant {

	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(CanadaItems.maple_gem, CanadaItems.berry_gem, CanadaItems.silt_stone_gem);

	protected static final int PRIMARY_TRADES = 0;
	protected static final int SECONDARY_TRADES = 1;
	protected static final int TERTIARY_TRADES = 2;
	protected static final int RARE_TRADES = 3;
	protected static final int MEGA_RARE_TRADES = 4;

	public static final DataParameter<Boolean> STUNNED = EntityDataManager.createKey(WoodRunnerEntity.class, DataSerializers.BOOLEAN);

	@Nullable
	private PlayerEntity customer;
	private Set<UUID> tradedCustomers = new HashSet<>();
	
	@Nullable
	private MerchantOffers offers;

	private int stunDelay;
	private int despawnDelay;

	protected WoodRunnerEntity(EntityType<? extends WoodRunnerEntity> type, World worldIn) {
		
		super(type, worldIn);
		
	}

	@Override
	protected void registerGoals() {
		
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(3, new TradeWithPlayerGoal(this));
		this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.4D));
		this.goalSelector.addGoal(8, new MoveTowardsRestrictionGoal(this, 0.4D));
		this.goalSelector.addGoal(9, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 4.0F, 1.0F));
		this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
		
	}

	@Override
	protected void registerAttributes() {

		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0d);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5d);

	}

	@Override
	protected void registerData() {
		
		super.registerData();
		this.dataManager.register(STUNNED, false);
		
	}

	@Override
	public void setCustomer(@Nullable PlayerEntity player) {
		
		this.customer = player;
		
	}

	@Nullable
	@Override
	public PlayerEntity getCustomer() {
		
		return this.customer;
		
	}

	public boolean hasCustomer() {
		
		return this.customer != null;
		
	}

	@Override
	public MerchantOffers getOffers() {
		
		if (this.offers == null) {
			
			this.offers = new MerchantOffers();
			this.populateTradeData();
			
		}
		
		return this.offers;
		
	}

	@Override
	public void onTrade(MerchantOffer offer) {
		
		offer.func_222219_j();
		
		if (this.customer != null) {
			
			this.tradedCustomers.add(this.customer.getUniqueID());
			
		}
		
	}

	protected void populateTradeData() {

		MerchantOffers offers = this.getOffers();
		this.addTrades(offers, WoodRunnerTrades.WOOD_RUNNER.get(PRIMARY_TRADES), Math.max(4, this.rand.nextInt(4) + 1));
		this.addTrades(offers, WoodRunnerTrades.WOOD_RUNNER.get(SECONDARY_TRADES), Math.max(2, this.rand.nextInt(3) + 1));
		this.addTrades(offers, WoodRunnerTrades.WOOD_RUNNER.get(TERTIARY_TRADES), 1);
		this.addTrades(offers, WoodRunnerTrades.WOOD_RUNNER.get(RARE_TRADES), Math.max(2, this.rand.nextInt(1) + 1));
		this.addTrades(offers, WoodRunnerTrades.WOOD_RUNNER.get(MEGA_RARE_TRADES), Math.max(1, this.rand.nextInt(1) + 0));

	}

	protected void addTrades(MerchantOffers offers, @Nullable VillagerTrades.ITrade[] trades, int max) {
		
		if (trades == null) return;
		List<Integer> randomIndexes = IntStream.range(0, trades.length).boxed().collect(Collectors.toList());
		Collections.shuffle(randomIndexes);
		randomIndexes = randomIndexes.subList(0, Math.min(trades.length, max));
		
		for (Integer index : randomIndexes) {
			
			VillagerTrades.ITrade trade = trades[index];
			MerchantOffer offer = trade.getOffer(this, this.rand);
			
			if (offer != null) {
				
				offers.add(offer);
				
			}
			
		}
		
	}

	@Override
	public void verifySellingItem(ItemStack stack) {

	}

	@Override
	public World getWorld() {
		
		return this.world;
		
	}

	@Override
	public int getXp() {
		
		return 0;
		
	}

	@Override
	public boolean func_213705_dZ() {
		
		return false;
		
	}

	@Override
	public SoundEvent func_213714_ea() {
		
		return SoundEvents.ENTITY_VILLAGER_YES;
		
	}

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		
		return false;
		
	}

	public boolean processInteract(PlayerEntity player, Hand hand) {

		ItemStack itemstack = player.getHeldItem(hand);
		boolean flag = itemstack.getItem() == Items.NAME_TAG;

		if (flag) {

			itemstack.interactWithEntity(player, this, hand);
			return true;

		} else if (itemstack.getItem() != Items.VILLAGER_SPAWN_EGG && itemstack.getItem() != CanadaItems.maple_gem && this.isAlive() && !this.hasCustomer() && !this.isChild()) {

			if (hand == Hand.MAIN_HAND) {

				player.addStat(Stats.TALKED_TO_VILLAGER);

			}

			if (this.getOffers().isEmpty()) {
				
				return super.processInteract(player, hand);
				
			} else {
				
				if (!this.world.isRemote) {
					
					this.setCustomer(player);
					this.func_213707_a(player, this.getDisplayName(), 1);
					
				}

				return true;
				
			}
			
		} else {
			
			return super.processInteract(player, hand);
			
		}
		
	}

	public boolean isPreviousCustomer(PlayerEntity player) {
		
		return this.tradedCustomers.contains(player.getUniqueID());
		
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		
		boolean attacked = super.attackEntityFrom(source, amount);
		
		if (attacked) {
			
			this.dataManager.set(STUNNED, true);
			this.goalSelector.getRunningGoals().forEach(PrioritizedGoal::resetTask);
			this.stunDelay = 20;
			
		}
		
		return attacked;
		
	}

	public int getStunDelay() {
		
		return this.stunDelay;
		
	}

	public void setDespawnDelay(int despawnDelay) {
		
		this.despawnDelay = despawnDelay;
		
	}

	public int getDespawnDelay() {
		
		return this.despawnDelay;
		
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		
		super.readAdditional(compound);
		
		if (compound.contains("Offers", 10)) {
			
			this.offers = new MerchantOffers(compound.getCompound("Offers"));
			
		}
		
		if (compound.contains("DespawnDelay", Constants.NBT.TAG_INT)) {
			
			this.despawnDelay = compound.getInt("DespawnDelay");
			
		}
		
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		
		super.writeAdditional(compound);
		compound.putInt("DespawnDelay", this.despawnDelay);
		
	}

	public ItemStack getFavouriteFood() {
		
		return null;
		
	}

	@OnlyIn(Dist.CLIENT)
	public void func_213703_a(@Nullable MerchantOffers p_213703_1_) {
		
	}

	public void func_213702_q(int p_213702_1_) {
		
	}

	protected SoundEvent getAmbientSound() {

		return SoundEvents.ENTITY_VILLAGER_AMBIENT;

	}

	protected SoundEvent getHurtSound(DamageSource source) {

		return SoundEvents.ENTITY_VILLAGER_HURT;

	}

	protected SoundEvent getDeathSound() {

		return SoundEvents.ENTITY_VILLAGER_DEATH;

	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {

		return (AgeableEntity) CanadaEntities.WOOD_RUNNER.create(this.world);

	}

	public boolean isBreedingItem(ItemStack stack) {

		return TEMPTATION_ITEMS.test(stack);

	}

}