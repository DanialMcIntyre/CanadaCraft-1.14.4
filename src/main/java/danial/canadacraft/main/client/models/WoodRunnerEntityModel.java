package danial.canadacraft.main.client.models;

import com.mojang.blaze3d.platform.GlStateManager;

import danial.canadacraft.main.init.entities.WoodRunnerEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class WoodRunnerEntityModel extends EntityModel<WoodRunnerEntity> {
	
    public RendererModel head;
    public RendererModel rightarm;
    public RendererModel leftarm;
    public RendererModel bottomarm;
    public RendererModel leftleg;
    public RendererModel body;
    public RendererModel rightleg;
    public RendererModel nose;
    
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public WoodRunnerEntityModel() {
    	
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bottomarm = new RendererModel(this, 40, 38);
        this.bottomarm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.bottomarm.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(bottomarm, -0.75F, 0.0F, 0.0F);
        this.leftarm = new RendererModel(this, 44, 22);
        this.leftarm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.leftarm.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(leftarm, -0.75F, 0.0F, 0.0F);
        this.head = new RendererModel(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.setRotateAngle(head, 0.29452431201934814F, 0.0F, 0.0F);
        this.nose = new RendererModel(this, 24, 0);
        this.nose.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.nose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.rightarm = new RendererModel(this, 44, 22);
        this.rightarm.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.rightarm.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(rightarm, -0.75F, 0.0F, 0.0F);
        this.leftleg = new RendererModel(this, 0, 22);
        this.leftleg.mirror = true;
        this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.body = new RendererModel(this, 16, 20);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.rightleg = new RendererModel(this, 0, 22);
        this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.head.addChild(this.nose);
        
    }

    @Override
    public void render(WoodRunnerEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
    	if(!this.isChild) {
    	
    		this.bottomarm.render(f5);
    		this.leftarm.render(f5);
    		this.head.render(f5);
    		this.rightarm.render(f5);
    		this.leftleg.render(f5);
    		this.body.render(f5);
    		this.rightleg.render(f5);
        
    	} else {
    		
			GlStateManager.pushMatrix();
			GlStateManager.translated(0.0F, this.childYOffset * f5, this.childZOffset * f5);
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			GlStateManager.scaled(0.5F, 0.5F, 0.5F);
			GlStateManager.translated(0.0F, 24.0F * f5, 0.0F);
			this.bottomarm.render(f5);
			this.leftarm.render(f5);
			this.body.render(f5);
			this.head.render(f5);
			this.rightarm.render(f5);
			this.leftleg.render(f5);
			this.body.render(f5);
			this.rightleg.render(f5);
			GlStateManager.popMatrix();
    		
    	}
        
    }

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
    	
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
        
    }
    
    public void setRotationAngles(WoodRunnerEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
    	
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);

        this.head.rotateAngleZ = 0.0F;


        this.bottomarm.rotationPointY = 3.0F;
        this.bottomarm.rotationPointZ = -1.0F;
        this.bottomarm.rotateAngleX = -0.75F;
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;
        
     }
  
}
