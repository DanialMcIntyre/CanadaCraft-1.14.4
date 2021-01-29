package danial.canadacraft.main;

import javax.annotation.Nullable;

import danial.canadacraft.main.init.world.dimensions.CanadaModDimension;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.minecart.ContainerMinecartEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SRespawnPacket;
import net.minecraft.network.play.server.SServerDifficultyPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.hooks.BasicEventHooks;
import net.minecraftforge.fml.network.NetworkHooks;

public interface DimensionTeleportFix {

	DimensionType type = CanadaModDimension.getDimensionType();

	@Nullable
	default Entity changeCanadaDimension(DimensionType destinationIn, Entity entityIn) {
		if (!ForgeHooks.onTravelToDimension(entityIn, destinationIn))
			return null;
		if (!entityIn.world.isRemote && entityIn.isAlive()) {
			entityIn.world.getProfiler().startSection("changeCanadaDimension");
			MinecraftServer minecraftserver = entityIn.getServer();
			DimensionType dimensiontype = entityIn.dimension;
			ServerWorld serverworld = minecraftserver.getWorld(dimensiontype);
			ServerWorld serverworld1 = minecraftserver.getWorld(destinationIn);
			entityIn.dimension = destinationIn;
			entityIn.detach();
			entityIn.world.getProfiler().startSection("reposition");
			Vec3d vec3d = entityIn.getMotion();

			double movementFactor = serverworld.getDimension().getMovementFactor()
					/ serverworld1.getDimension().getMovementFactor();
			double d0 = entityIn.posX * movementFactor;
			double d1 = entityIn.posZ * movementFactor;
			double d3 = Math.min(-2.9999872E7D, serverworld1.getWorldBorder().minX() + 16.0D);
			double d4 = Math.min(-2.9999872E7D, serverworld1.getWorldBorder().minZ() + 16.0D);
			double d5 = Math.min(2.9999872E7D, serverworld1.getWorldBorder().maxX() - 16.0D);
			double d6 = Math.min(2.9999872E7D, serverworld1.getWorldBorder().maxZ() - 16.0D);
			d0 = MathHelper.clamp(d0, d3, d5);
			d1 = MathHelper.clamp(d1, d4, d6);

			entityIn.world.getProfiler().endStartSection("reloading");
			Entity entity = entityIn.getType().create(serverworld1);
			if (entity != null) {
				entity.copyDataFromOld(entityIn);
				entity.setMotion(vec3d);
				serverworld1.func_217460_e(entity);
			}
			entityIn.remove(false);
			entityIn.world.getProfiler().endSection();
			serverworld.resetUpdateEntityTick();
			serverworld1.resetUpdateEntityTick();
			entityIn.world.getProfiler().endSection();
			return entity;
		} else {
			return null;
		}
	}

	@Nullable
	default Entity changeCanadaDimensionServerPlayer(DimensionType destinationIn, ServerPlayerEntity entityIn) {
		if (!ForgeHooks.onTravelToDimension(entityIn, destinationIn))
			return null;
		entityIn.isInvulnerableDimensionChange();
		DimensionType dimensiontype = entityIn.dimension;
		ServerWorld serverworld = entityIn.server.getWorld(dimensiontype);
		entityIn.dimension = destinationIn;
		ServerWorld serverworld1 = entityIn.server.getWorld(destinationIn);
		WorldInfo worldinfo = entityIn.world.getWorldInfo();
		NetworkHooks.sendDimensionDataPacket(entityIn.connection.netManager, entityIn);
		entityIn.connection.sendPacket(
				new SRespawnPacket(destinationIn, worldinfo.getGenerator(), entityIn.interactionManager.getGameType()));
		entityIn.connection
				.sendPacket(new SServerDifficultyPacket(worldinfo.getDifficulty(), worldinfo.isDifficultyLocked()));
		PlayerList playerlist = entityIn.server.getPlayerList();
		playerlist.updatePermissionLevel(entityIn);
		serverworld.removeEntity(entityIn, true);
		entityIn.revive();
		double d0 = entityIn.posX;
		double d1 = entityIn.posY;
		double d2 = entityIn.posZ;
		float f = entityIn.rotationPitch;
		float f1 = entityIn.rotationYaw;
		serverworld.getProfiler().startSection("moving");
		double moveFactor = serverworld.getDimension().getMovementFactor()
				/ serverworld1.getDimension().getMovementFactor();
		d0 *= moveFactor;
		d2 *= moveFactor;
		if ((dimensiontype == DimensionType.OVERWORLD || dimensiontype == DimensionType.THE_NETHER)
				&& destinationIn == type) {
			BlockPos blockpos = new BlockPos(entityIn.posX, 50, entityIn.posZ);
			d0 = (double) blockpos.getX();
			d1 = (double) blockpos.getY();
			d2 = (double) blockpos.getZ();
			f1 = 90.0F;
			f = 0.0F;
		}
		entityIn.setLocationAndAngles(d0, d1, d2, f1, f);
		serverworld.getProfiler().endSection();
		serverworld.getProfiler().startSection("placing");
		double d7 = Math.min(-2.9999872E7D, serverworld1.getWorldBorder().minX() + 16.0D);
		double d4 = Math.min(-2.9999872E7D, serverworld1.getWorldBorder().minZ() + 16.0D);
		double d5 = Math.min(2.9999872E7D, serverworld1.getWorldBorder().maxX() - 16.0D);
		double d6 = Math.min(2.9999872E7D, serverworld1.getWorldBorder().maxZ() - 16.0D);
		d0 = MathHelper.clamp(d0, d7, d5);
		d2 = MathHelper.clamp(d2, d4, d6);
		entityIn.setLocationAndAngles(d0, d1, d2, f1, f);

		serverworld.getProfiler().endSection();
		entityIn.setWorld(serverworld1);
		serverworld1.func_217447_b(entityIn);
		entityIn.connection.setPlayerLocation(entityIn.posX, entityIn.posY, entityIn.posZ, f1, f);
		entityIn.connection.sendPacket(new SPlayerAbilitiesPacket(entityIn.abilities));
		playerlist.sendWorldInfo(entityIn, serverworld1);
		playerlist.sendInventory(entityIn);
		for (EffectInstance effectinstance : entityIn.getActivePotionEffects()) {
			entityIn.connection.sendPacket(new SPlayEntityEffectPacket(entityIn.getEntityId(), effectinstance));
		}
		entityIn.connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
		BasicEventHooks.firePlayerChangedDimensionEvent(entityIn, dimensiontype, destinationIn);
		return entityIn;
	}

	default Entity teleportToCanadaDimension(DimensionType destinationIn, Entity entityIn) {
		if (entityIn instanceof ServerPlayerEntity) {
			return this.changeCanadaDimensionServerPlayer(destinationIn, (ServerPlayerEntity) entityIn);
		} else if (entityIn instanceof ContainerMinecartEntity) {
			((ContainerMinecartEntity) entityIn).dropContentsWhenDead(false);
			return this.changeCanadaDimension(destinationIn, entityIn);
		} else if (entityIn instanceof ItemEntity) {
			return this.changeCanadaDimension(destinationIn, entityIn);
		} else if (entityIn instanceof AbstractVillagerEntity) {
			((AbstractVillagerEntity) entityIn).setCustomer((PlayerEntity) null);
			return this.changeCanadaDimension(destinationIn, entityIn);
		} else if (entityIn instanceof EnderPearlEntity) {
			return this.changeCanadaDimension(destinationIn, entityIn);
		} else {
			return this.changeCanadaDimension(destinationIn, entityIn);
		}

	}

}