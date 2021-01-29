package danial.canadacraft.main.client.models;

import danial.canadacraft.main.init.entities.MinerEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class MinerEntityModel extends EntityModel<MinerEntity> {
	
    public RendererModel rightleg;
    public RendererModel leftleg;
    public RendererModel body;
    public RendererModel rightarm;
    public RendererModel leftarm;
    public RendererModel head;
    public RendererModel bottomhat;
    public RendererModel middlehat;
    public RendererModel tophat;

    public MinerEntityModel() {
    	
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.body = new RendererModel(this, 84, 0);
        this.body.setRotationPoint(-6.0F, -1.6F, -3.5F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 12, 14, 8, 1.5F);
        this.rightarm = new RendererModel(this, 38, 53);
        this.rightarm.setRotationPoint(-4.0F, 2.0F, -10.0F);
        this.rightarm.addBox(0.0F, 0.0F, 0.0F, 2, 2, 9, 0.5F);
        this.leftarm = new RendererModel(this, 13, 53);
        this.leftarm.setRotationPoint(2.5F, 2.0F, -10.0F);
        this.leftarm.addBox(0.0F, 0.0F, 0.0F, 2, 2, 9, 0.5F);
        this.middlehat = new RendererModel(this, 19, 13);
        this.middlehat.setRotationPoint(-4.0F, -14.6F, -3.0F);
        this.middlehat.addBox(0.0F, 0.0F, 0.0F, 8, 3, 7, 0.5F);
        this.bottomhat = new RendererModel(this, 0, 0);
        this.bottomhat.setRotationPoint(-5.0F, -10.6F, -4.5F);
        this.bottomhat.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10, 0.5F);
        this.leftleg = new RendererModel(this, 0, 51);
        this.leftleg.setRotationPoint(2.0F, 14.0F, -1.5F);
        this.leftleg.addBox(0.0F, 0.0F, 0.0F, 3, 10, 3, 0.5F);
        this.rightleg = new RendererModel(this, 0, 36);
        this.rightleg.setRotationPoint(-5.0F, 14.0F, -1.5F);
        this.rightleg.addBox(0.0F, 0.0F, 0.0F, 3, 10, 3, 0.5F);
        this.head = new RendererModel(this, 0, 22);
        this.head.setRotationPoint(-2.3F, -8.4F, -2.1F);
        this.head.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5, 1.0F);
        this.tophat = new RendererModel(this, 0, 0);
        this.tophat.setRotationPoint(-0.8F, -18.6F, -0.4F);
        this.tophat.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.5F);
        
    }

    @Override
    public void render(MinerEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
        this.body.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
        this.middlehat.render(f5);
        this.bottomhat.render(f5);
        this.leftleg.render(f5);
        this.rightleg.render(f5);
        this.head.render(f5);
        this.tophat.render(f5);
        
    }

    public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z) {
    	
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
        
    }
    
    @Override
    public void setRotationAngles(MinerEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
    	
    	this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    	this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    }
    
}
