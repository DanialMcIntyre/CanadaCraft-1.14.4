package danial.canadacraft.main.init.entities.villager;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;

import danial.canadacraft.main.init.entities.villager.WoodRunnerTrades.ItemsForLooniesTrade.LoonieForItemsTrade;
import danial.canadacraft.main.init.items.CanadaItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;

public class WoodRunnerTrades {

	public static final Int2ObjectMap<VillagerTrades.ITrade[]> WOOD_RUNNER = Util.make(() -> {

		VillagerTrades.ITrade[] PrimaryOffers = new VillagerTrades.ITrade[] {

				new LoonieForItemsTrade(CanadaItems.beaver_tail, 8, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.beaver_fur, 15, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.moose_fur, 9, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.moose_meat, 12, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.moose_antlers, 4, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.grizzly_bear_claw, 7, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.grizzly_bear_meat, 11, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.trillium, 1, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.canada_portal_dust, 19, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.berry_ball, 17, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.mining_orb, 4, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.oil_bucket, 1, 10000, 1, 0),
				
				new LoonieForItemsTrade(CanadaItems.choco_timbit, 8, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.maple_timbit, 8, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.jelly_timbit, 8, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.plain_timbit, 10, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.cooked_beaver_tail, 6, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.cooked_grizzly_bear_meat, 7, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.cooked_moose_meat, 8, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.pop_corn, 12, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.berry_salad, 12, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.pancakes_syrup, 12, 10000, 1, 0),
				new LoonieForItemsTrade(CanadaItems.poutine, 12, 10000, 1, 0)

		};

		VillagerTrades.ITrade[] SecondaryOffers = new VillagerTrades.ITrade[] {

				new ItemsForLooniesTrade(CanadaItems.canada_disc, 29, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.canada_gem, 11, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.gypsum_golem_entity_egg, 22, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.army_hat, 4, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.clerical_hat, 4, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.continental_hat, 4, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.navy_hat, 4, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.regent_hat, 4, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.bear_boots, 14, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.bear_chestplate, 16, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.bear_helmet, 14, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.bear_leggings, 15, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.maple_cake, 3, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.berry_cake, 3, 1, 1)

		};

		VillagerTrades.ITrade[] TertiaryOffers = new VillagerTrades.ITrade[] {

				new ItemsForLooniesTrade(CanadaItems.snowball_staff, 6, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.grizzly_bear_claw_spear, 5, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.grizzly_bear_claw_spear_bleed, 7, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.grizzly_bear_claw_spear_canada, 7, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.grizzly_bear_claw_spear_maple, 7, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.grizzly_bear_claw_spear_slow, 7, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.grizzly_bear_claw_spear_speed, 7, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.grizzly_bear_claw_spear_silt, 7, 1, 1),
				new ItemsForLooniesTrade(CanadaItems.gypsum_blade, 6, 1, 1)

		};

		VillagerTrades.ITrade[] RareOffers = new VillagerTrades.ITrade[] {

				new TradeWithEnchantment(CanadaItems.loonie, 13, CanadaItems.antler_sword, 100000, 1, Enchantments.SHARPNESS, 3, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 10, CanadaItems.antler_sword, 100000, 1, Enchantments.SHARPNESS, 2, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 7, CanadaItems.antler_sword, 100000, 1, Enchantments.SHARPNESS, 1, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 30, CanadaItems.canada_sword, 100000, 1, Enchantments.SHARPNESS, 3, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 25, CanadaItems.canada_sword, 100000, 1, Enchantments.SHARPNESS, 2, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 20, CanadaItems.canada_sword, 100000, 1, Enchantments.SHARPNESS, 1, 0),
				new TradeWithEnchantment(new ItemStack(CanadaItems.loonie, 18), new ItemStack(CanadaItems.enhanced_moose_boots), 100000, 1, Enchantments.UNBREAKING, 3, 0),
				new TradeWithEnchantment(new ItemStack(CanadaItems.loonie, 22), new ItemStack(CanadaItems.enhanced_moose_chestplate), 100000, 1, Enchantments.UNBREAKING, 3, 0),
				new TradeWithEnchantment(new ItemStack(CanadaItems.loonie, 20), new ItemStack(CanadaItems.enhanced_moose_leggings), 100000, 1, Enchantments.UNBREAKING, 3, 0),
				new TradeWithEnchantment(new ItemStack(CanadaItems.loonie, 18), new ItemStack(CanadaItems.enhanced_moose_helmet), 100000, 1, Enchantments.UNBREAKING, 3, 0)

		};

		VillagerTrades.ITrade[] MegaRareOffers = new VillagerTrades.ITrade[] {

				new TradeWithEnchantment(CanadaItems.loonie, 40, CanadaItems.canada_chestplate, 100000, 1, Enchantments.PROTECTION, 5, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 40, CanadaItems.canada_leggings, 100000, 1, Enchantments.PROTECTION, 5, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 40, CanadaItems.canada_helmet, 100000, 1, Enchantments.PROTECTION, 5, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 40, CanadaItems.canada_boots, 100000, 1, Enchantments.PROTECTION, 5, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 32, CanadaItems.canada_chestplate, 100000, 1, Enchantments.PROTECTION, 4, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 32, CanadaItems.canada_leggings, 100000, 1, Enchantments.PROTECTION, 4, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 32, CanadaItems.canada_helmet, 100000, 1, Enchantments.PROTECTION, 4, 0),
				new TradeWithEnchantment(CanadaItems.loonie, 32, CanadaItems.canada_boots, 100000, 1, Enchantments.PROTECTION, 4, 0)

		};

		return getAsIntMap(ImmutableMap.of(0, PrimaryOffers, 1, SecondaryOffers, 2, TertiaryOffers, 3, RareOffers, 4, MegaRareOffers));

	});

	private static Int2ObjectMap<VillagerTrades.ITrade[]> getAsIntMap(ImmutableMap<Integer, VillagerTrades.ITrade[]> map) {
		
		return new Int2ObjectOpenHashMap<>(map);
		
	}
	
	@Nullable
	public interface ITrade {
		
		MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_);
		
	}

	static class TradeWithEnchantment implements VillagerTrades.ITrade {
		
		private final ItemStack buyingStack;
		private ItemStack secondBuyingStack = ItemStack.EMPTY;
		private final ItemStack sellingStack;
		private final int maxUses;
		private final int experience;
		private final float priceMultiplier;

		public TradeWithEnchantment(Item buyingItem, int price, Item sellingItem, int maxUses, int experience, Enchantment enchantment, int level, float priceMultiplier) {
			
			this.buyingStack = new ItemStack(buyingItem, price);
			this.sellingStack = new ItemStack(sellingItem);
			this.maxUses = maxUses;
			this.experience = experience;
			this.priceMultiplier = priceMultiplier;
			
			if (this.sellingStack.getItem() == Items.ENCHANTED_BOOK) {
				
				EnchantmentHelper.setEnchantments(ImmutableMap.of(enchantment, level), this.sellingStack);
				
			} else {
				
				this.sellingStack.addEnchantment(enchantment, level);
				
			}
			
		}

		public TradeWithEnchantment(ItemStack buyingStack, ItemStack sellingStack, int maxUses, int experience, Enchantment enchantment, int level, float priceMultiplier) {
		
			this.buyingStack = buyingStack;
			this.sellingStack = sellingStack;
			this.maxUses = maxUses;
			this.experience = experience;
			this.priceMultiplier = priceMultiplier;
			
			if (this.sellingStack.getItem() == Items.ENCHANTED_BOOK) {
				
				EnchantmentHelper.setEnchantments(ImmutableMap.of(enchantment, level), this.sellingStack);
				
			} else {
				
				this.sellingStack.addEnchantment(enchantment, level);
				
			}
			
		}

		public TradeWithEnchantment(ItemStack buyingStack, ItemStack secondBuyingStack, ItemStack sellingStack, int maxUses, int experience, float priceMultiplier) {
		
			this.buyingStack = buyingStack;
			this.secondBuyingStack = secondBuyingStack;
			this.sellingStack = sellingStack;
			this.maxUses = maxUses;
			this.experience = experience;
			this.priceMultiplier = priceMultiplier;
			
		}

		public TradeWithEnchantment(ItemStack buyingStack, ItemStack sellingStack, int maxUses, int experience, float priceMultiplier) {
			
			this.buyingStack = buyingStack;
			this.sellingStack = sellingStack;
			this.maxUses = maxUses;
			this.experience = experience;
			this.priceMultiplier = priceMultiplier;
			
		}

		public TradeWithEnchantment(ItemStack buyingStack, ItemStack secondBuyingStack, ItemStack sellingStack,	int maxUses, int experience, float priceMultiplier, EnchantmentData... enchantments) {
		
			this.buyingStack = buyingStack;
			this.secondBuyingStack = secondBuyingStack;
			this.sellingStack = sellingStack;
			this.maxUses = maxUses;
			this.experience = experience;
			this.priceMultiplier = priceMultiplier;
			
			for (EnchantmentData data : enchantments) {
				
				this.sellingStack.addEnchantment(data.enchantment, data.enchantmentLevel);
				
			}
			
		}

		@Nullable
		@Override
		public MerchantOffer getOffer(Entity trader, Random rand) {

			this.buyingStack.setCount(
					MathHelper.clamp(Math.max(this.buyingStack.getCount() - 8, 1) + rand.nextInt(16) + 1, 1, 64));

			if (!this.secondBuyingStack.isEmpty()) {

				this.secondBuyingStack.setCount(MathHelper.clamp(Math.max(this.secondBuyingStack.getCount() - 8, 1) + rand.nextInt(16) + 1, 1, 64));

			}

			return new MerchantOffer(this.buyingStack, this.secondBuyingStack, this.sellingStack, this.maxUses, this.experience, this.priceMultiplier);

		}

	}

	static class ItemsForLooniesTrade implements net.minecraft.entity.merchant.villager.VillagerTrades.ITrade {
		
		private final ItemStack offerStack;
		private final int price;
		private final int offerStackCount;
		private final int maxUses;
		private final int experience;
		private final float priceMultiplier;

		public ItemsForLooniesTrade(Block block, int price, int offerStackCount, int maxUses, int experience) {
			
			this(new ItemStack(block), price, offerStackCount, maxUses, experience);
			
		}

		public ItemsForLooniesTrade(Item item, int price, int offerStackCount, int experience) {
			
			this(new ItemStack(item), price, offerStackCount, 12, experience);
			
		}

		public ItemsForLooniesTrade(Item item, int price, int offerStackCount, int maxUses, int experience, float priceMultiplier) {
			
			this(new ItemStack(item), price, offerStackCount, maxUses, experience);
			
		}

		public ItemsForLooniesTrade(ItemStack stack, int price, int offerStackCount, int maxUses, int experience) {
			
			this(stack, price, offerStackCount, maxUses, experience, 0.05F);
			
		}

		public ItemsForLooniesTrade(ItemStack stack, int price, int offerStackCount, int maxUses, int experience, float priceMultiplier) {
			
			this.offerStack = stack;
			this.price = price;
			this.offerStackCount = offerStackCount;
			this.maxUses = maxUses;
			this.experience = experience;
			this.priceMultiplier = priceMultiplier;
			
		}

		static class LoonieForItemsTrade implements VillagerTrades.ITrade {
			
			private final Item field_221183_a;
			private final int field_221184_b;
			private final int field_221185_c;
			private final int field_221186_d;
			private final float field_221187_e;

			public LoonieForItemsTrade(IItemProvider item, int cost, int stock, int xp, float field_221187_e) {
				
				this.field_221183_a = item.asItem();
				this.field_221184_b = cost;
				this.field_221185_c = stock;
				this.field_221186_d = xp;
				this.field_221187_e = 0.5F;
				
			}

			public MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_) {
				
				ItemStack itemstack = new ItemStack(this.field_221183_a, this.field_221184_b);
				return new MerchantOffer(itemstack, new ItemStack(CanadaItems.loonie), this.field_221185_c, this.field_221186_d, this.field_221187_e);
			
			}
			
		}

		@Override
		public MerchantOffer getOffer(Entity trader, Random rand) {
			
			return new MerchantOffer(new ItemStack(CanadaItems.loonie, this.price), new ItemStack(this.offerStack.getItem(), this.offerStackCount), this.maxUses, this.experience, this.priceMultiplier);
		
		}
		
	}

	static class Trade implements VillagerTrades.ITrade {
		
		private final ItemStack firstBuyStack;
		private final ItemStack secondBuyStack;
		private final ItemStack sellingStack;
		private final int maxUses;
		private final int experience;
		private final float priceMultiplier;

		public Trade(ItemStack firstBuyStack, ItemStack sellingStack, int maxUses, int experience, float priceMultiplier) {
			
			this.firstBuyStack = firstBuyStack;
			this.secondBuyStack = ItemStack.EMPTY;
			this.sellingStack = sellingStack;
			this.maxUses = maxUses;
			this.experience = experience;
			this.priceMultiplier = priceMultiplier;
			
		}

		public Trade(ItemStack firstBuyStack, ItemStack secondBuyStack, ItemStack sellingStack, int maxUses, int experience, float priceMultiplier) {
			
			this.firstBuyStack = firstBuyStack;
			this.secondBuyStack = secondBuyStack;
			this.sellingStack = sellingStack;
			this.maxUses = maxUses;
			this.experience = experience;
			this.priceMultiplier = priceMultiplier;
			
		}

		@Override
		public MerchantOffer getOffer(Entity trader, Random rand) {
			
			this.firstBuyStack.setCount( MathHelper.clamp(Math.max(this.firstBuyStack.getCount() - 4, 1) + rand.nextInt(8) + 1, 1, 64));
			
			if (!this.secondBuyStack.isEmpty()) {
				
				this.secondBuyStack.setCount(MathHelper.clamp(Math.max(this.secondBuyStack.getCount() - 4, 1) + rand.nextInt(8) + 1, 1, 64));
			
			}
			
			return new MerchantOffer(this.firstBuyStack, this.secondBuyStack, this.sellingStack, this.maxUses, this.experience, this.priceMultiplier);
	
		}
		
	}
	
}