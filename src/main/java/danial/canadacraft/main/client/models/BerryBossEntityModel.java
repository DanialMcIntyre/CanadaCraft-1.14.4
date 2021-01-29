package danial.canadacraft.main.client.models;

import com.mojang.blaze3d.platform.GlStateManager;

import danial.canadacraft.main.init.entities.BerryBossEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class BerryBossEntityModel extends EntityModel<BerryBossEntity> {
	
    public RendererModel rightarm;
    public RendererModel rightleg;
    public RendererModel head;
    public RendererModel body;
    public RendererModel leftarm;
    public RendererModel leftleg;

    public BerryBossEntityModel() {
    	
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.rightarm = new RendererModel(this, 40, 16);
        this.rightarm.setRotationPoint(-9.3F, -3.0F, 0.0F);
        this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F);
        this.setRotateAngle(rightarm, -1.3962634015954636F, -0.10000736613927509F, 0.10000736613927509F);
        this.rightleg = new RendererModel(this, 0, 16);
        this.rightleg.setRotationPoint(-3.3F, 12.0F, 0.1F);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 1.0F);
        this.leftleg = new RendererModel(this, 0, 16);
        this.leftleg.mirror = true;
        this.leftleg.setRotationPoint(3.3F, 12.0F, 0.1F);
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 1.0F);
        this.leftarm = new RendererModel(this, 40, 16);
        this.leftarm.mirror = true;
        this.leftarm.setRotationPoint(9.4F, -3.0F, 0.0F);
        this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 1.0F);
        this.setRotateAngle(leftarm, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
        this.body = new RendererModel(this, 16, 16);
        this.body.setRotationPoint(0.0F, -3.4F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 3.0F);
        this.head = new RendererModel(this, 0, 0);
        this.head.setRotationPoint(0.0F, -11.4F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 5.0F);
        
    }

    @Override
    public void render(BerryBossEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
        this.rightarm.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translated(this.rightleg.offsetX, this.rightleg.offsetY, this.rightleg.offsetZ);
        GlStateManager.translated(this.rightleg.rotationPointX * f5, this.rightleg.rotationPointY * f5, this.rightleg.rotationPointZ * f5);
        GlStateManager.scaled(1.2D, 1.0D, 1.4D);
        GlStateManager.translated(-this.rightleg.offsetX, -this.rightleg.offsetY, -this.rightleg.offsetZ);
        GlStateManager.translated(-this.rightleg.rotationPointX * f5, -this.rightleg.rotationPointY * f5, -this.rightleg.rotationPointZ * f5);
        this.rightleg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translated(this.leftleg.offsetX, this.leftleg.offsetY, this.leftleg.offsetZ);
        GlStateManager.translated(this.leftleg.rotationPointX * f5, this.leftleg.rotationPointY * f5, this.leftleg.rotationPointZ * f5);
        GlStateManager.scaled(1.2D, 1.0D, 1.4D);
        GlStateManager.translated(-this.leftleg.offsetX, -this.leftleg.offsetY, -this.leftleg.offsetZ);
        GlStateManager.translated(-this.leftleg.rotationPointX * f5, -this.leftleg.rotationPointY * f5, -this.leftleg.rotationPointZ * f5);
        this.leftleg.render(f5);
        GlStateManager.popMatrix();
        this.leftarm.render(f5);
        this.body.render(f5);
        this.head.render(f5);
        
    }

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
    	
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
        
    }
    
    @Override
    public void setRotationAngles(BerryBossEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
    	
    	this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    	this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    }
    
}
