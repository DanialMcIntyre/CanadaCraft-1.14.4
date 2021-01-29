package danial.canadacraft.main.client.models;

import com.mojang.blaze3d.platform.GlStateManager;

import danial.canadacraft.main.init.entities.BeaverEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class BeaverEntityModel extends EntityModel<BeaverEntity> {

	public RendererModel body;
	public RendererModel leg1;
	public RendererModel leg2;
	public RendererModel leg3;
	public RendererModel leg4;
	public RendererModel head;
	public RendererModel tooth;
	public RendererModel tooth2;
	public RendererModel tail;

	protected float childYOffset = 8.0F;
	protected float childZOffset = 4.0F;

	public BeaverEntityModel() {

		this.textureWidth = 64;
		this.textureHeight = 32;
		this.leg3 = new RendererModel(this, 12, 15);
		this.leg3.setRotationPoint(1.9F, 23.5F, -6.0F);
		this.leg3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.leg2 = new RendererModel(this, 6, 15);
		this.leg2.setRotationPoint(1.9F, 23.5F, 4.5F);
		this.leg2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.tooth = new RendererModel(this, 0, 20);
		this.tooth.setRotationPoint(0.3F, 20.4F, -6.3F);
		this.tooth.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.tail = new RendererModel(this, 35, 17);
		this.tail.setRotationPoint(-2.0F, 20.9F, 5.0F);
		this.tail.addBox(0.0F, 0.0F, 0.0F, 4, 1, 7, 0.0F);
		this.body = new RendererModel(this, 0, 0);
		this.body.setRotationPoint(-5.0F, 20.5F, -5.0F);
		this.body.addBox(0.0F, 0.0F, 0.0F, 10, 3, 10, 0.0F);
		this.tooth2 = new RendererModel(this, 5, 20);
		this.tooth2.setRotationPoint(-1.0F, 20.4F, -6.3F);
		this.tooth2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.leg1 = new RendererModel(this, 0, 15);
		this.leg1.setRotationPoint(-3.0F, 23.5F, 4.5F);
		this.leg1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.leg4 = new RendererModel(this, 18, 15);
		this.leg4.setRotationPoint(-3.0F, 23.5F, -6.0F);
		this.leg4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.head = new RendererModel(this, 1, 25);
		this.head.setRotationPoint(-3.2F, 17.7F, -6.0F);
		this.head.addBox(0.0F, 0.0F, 0.0F, 6, 3, 4, 0.0F);

	}

	@Override
	public void render(BeaverEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		if (!this.isChild) {

			this.leg3.render(f5);
			this.leg2.render(f5);
			GlStateManager.pushMatrix();
			GlStateManager.translated(this.tooth.offsetX, this.tooth.offsetY, this.tooth.offsetZ);
			GlStateManager.translated(this.tooth.rotationPointX * f5, this.tooth.rotationPointY * f5, this.tooth.rotationPointZ * f5);
			GlStateManager.scaled(0.5D, 1.0D, 0.2D);
			GlStateManager.translated(-this.tooth.offsetX, -this.tooth.offsetY, -this.tooth.offsetZ);
			GlStateManager.translated(-this.tooth.rotationPointX * f5, -this.tooth.rotationPointY * f5, -this.tooth.rotationPointZ * f5);
			this.tooth.render(f5);
			GlStateManager.popMatrix();
			this.tail.render(f5);
			this.body.render(f5);
			GlStateManager.pushMatrix();
			GlStateManager.translated(this.tooth2.offsetX, this.tooth2.offsetY, this.tooth2.offsetZ);
			GlStateManager.translated(this.tooth2.rotationPointX * f5, this.tooth2.rotationPointY * f5, this.tooth2.rotationPointZ * f5);
			GlStateManager.scaled(0.5D, 1.0D, 0.2D);
			GlStateManager.translated(-this.tooth2.offsetX, -this.tooth2.offsetY, -this.tooth2.offsetZ);
			GlStateManager.translated(-this.tooth2.rotationPointX * f5, -this.tooth2.rotationPointY * f5, -this.tooth2.rotationPointZ * f5);
			this.tooth2.render(f5);
			GlStateManager.popMatrix();
			this.leg1.render(f5);
			this.leg4.render(f5);
			this.head.render(f5);

		} else {

			GlStateManager.pushMatrix();
			GlStateManager.translated(0.0F, this.childYOffset * f5, this.childZOffset * f5);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.scaled(0.5F, 0.5F, 0.5F);
			GlStateManager.translated(0.0F, 24.0F * f5, 0.0F);
			this.head.render(f5);
			this.leg3.render(f5);
			this.body.render(f5);
			this.leg4.render(f5);
			this.leg2.render(f5);
			this.tooth.render(f5);
			this.tooth2.render(f5);
			this.tail.render(f5);
			GlStateManager.popMatrix();

		}

	}

	@Override
	public void setRotationAngles(BeaverEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {

		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;

		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.tail.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float) Math.PI) * 1.4F * limbSwingAmount;

	}

}
