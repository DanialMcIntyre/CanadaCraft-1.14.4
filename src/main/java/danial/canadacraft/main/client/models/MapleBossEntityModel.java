package danial.canadacraft.main.client.models;

import com.mojang.blaze3d.platform.GlStateManager;

import danial.canadacraft.main.init.entities.MapleBossEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class MapleBossEntityModel extends EntityModel<MapleBossEntity> {
	
    public RendererModel body;
    public RendererModel rightbackleg;
    public RendererModel head;
    public RendererModel leftbackleg;
    public RendererModel leftfrontleg;
    public RendererModel rightfrontleg;

    public MapleBossEntityModel() {
    	
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.leftbackleg = new RendererModel(this, 0, 16);
        this.leftbackleg.setRotationPoint(6.0F, 15.3F, 12.0F);
        this.leftbackleg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 1.8F);
        this.rightfrontleg = new RendererModel(this, 0, 16);
        this.rightfrontleg.setRotationPoint(-6.0F, 15.3F, -12.0F);
        this.rightfrontleg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 1.8F);
        this.head = new RendererModel(this, 0, 0);
        this.head.setRotationPoint(0.0F, -0.9F, -19.5F);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, 3.4F);
        this.body = new RendererModel(this, 28, 8);
        this.body.setRotationPoint(0.0F, -1.4F, 2.0F);
        this.body.addBox(-5.0F, -10.0F, -7.0F, 10, 16, 8, 8.0F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.leftfrontleg = new RendererModel(this, 0, 16);
        this.leftfrontleg.setRotationPoint(6.0F, 15.3F, -12.0F);
        this.leftfrontleg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 1.8F);
        this.rightbackleg = new RendererModel(this, 0, 16);
        this.rightbackleg.setRotationPoint(-6.0F, 15.3F, 12.0F);
        this.rightbackleg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 1.8F);
        
    }

    @Override
    public void render(MapleBossEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
        GlStateManager.pushMatrix();
        GlStateManager.translated(this.leftbackleg.offsetX, this.leftbackleg.offsetY, this.leftbackleg.offsetZ);
        GlStateManager.translated(this.leftbackleg.rotationPointX * f5, this.leftbackleg.rotationPointY * f5, this.leftbackleg.rotationPointZ * f5);
        GlStateManager.scaled(1.0D, 1.2D, 1.0D);
        GlStateManager.translated(-this.leftbackleg.offsetX, -this.leftbackleg.offsetY, -this.leftbackleg.offsetZ);
        GlStateManager.translated(-this.leftbackleg.rotationPointX * f5, -this.leftbackleg.rotationPointY * f5, -this.leftbackleg.rotationPointZ * f5);
        this.leftbackleg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translated(this.rightfrontleg.offsetX, this.rightfrontleg.offsetY, this.rightfrontleg.offsetZ);
        GlStateManager.translated(this.rightfrontleg.rotationPointX * f5, this.rightfrontleg.rotationPointY * f5, this.rightfrontleg.rotationPointZ * f5);
        GlStateManager.scaled(1.0D, 1.2D, 1.0D);
        GlStateManager.translated(-this.rightfrontleg.offsetX, -this.rightfrontleg.offsetY, -this.rightfrontleg.offsetZ);
        GlStateManager.translated(-this.rightfrontleg.rotationPointX * f5, -this.rightfrontleg.rotationPointY * f5, -this.rightfrontleg.rotationPointZ * f5);
        this.rightfrontleg.render(f5);
        GlStateManager.popMatrix();
        this.head.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translated(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
        GlStateManager.translated(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
        GlStateManager.scaled(1.0D, 1.0D, 1.2D);
        GlStateManager.translated(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
        GlStateManager.translated(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
        this.body.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translated(this.leftfrontleg.offsetX, this.leftfrontleg.offsetY, this.leftfrontleg.offsetZ);
        GlStateManager.translated(this.leftfrontleg.rotationPointX * f5, this.leftfrontleg.rotationPointY * f5, this.leftfrontleg.rotationPointZ * f5);
        GlStateManager.scaled(1.0D, 1.2D, 1.0D);
        GlStateManager.translated(-this.leftfrontleg.offsetX, -this.leftfrontleg.offsetY, -this.leftfrontleg.offsetZ);
        GlStateManager.translated(-this.leftfrontleg.rotationPointX * f5, -this.leftfrontleg.rotationPointY * f5, -this.leftfrontleg.rotationPointZ * f5);
        this.leftfrontleg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translated(this.rightbackleg.offsetX, this.rightbackleg.offsetY, this.rightbackleg.offsetZ);
        GlStateManager.translated(this.rightbackleg.rotationPointX * f5, this.rightbackleg.rotationPointY * f5, this.rightbackleg.rotationPointZ * f5);
        GlStateManager.scaled(1.0D, 1.2D, 1.0D);
        GlStateManager.translated(-this.rightbackleg.offsetX, -this.rightbackleg.offsetY, -this.rightbackleg.offsetZ);
        GlStateManager.translated(-this.rightbackleg.rotationPointX * f5, -this.rightbackleg.rotationPointY * f5, -this.rightbackleg.rotationPointZ * f5);
        this.rightbackleg.render(f5);
        GlStateManager.popMatrix();
        
    }

    public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z) {
    	
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
        
    }
    
    @Override
    public void setRotationAngles(MapleBossEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
    	
    	this.rightfrontleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    	this.leftfrontleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    	
    	this.rightbackleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.leftbackleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    }
    
}
