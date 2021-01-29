package danial.canadacraft.main.client.models;

import com.mojang.blaze3d.platform.GlStateManager;

import danial.canadacraft.main.init.entities.MooseEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class MooseEntityModel extends EntityModel<MooseEntity> {
	
    public RendererModel body;
    public RendererModel nose;
    public RendererModel leftantler;
    public RendererModel rightantler;
    public RendererModel leftantler2;
    public RendererModel rightantler2;
    public RendererModel rightantler3;
    public RendererModel leftantler3;
    public RendererModel leftfrontleg;
    public RendererModel rightfrontleg;
    public RendererModel leftbackleg;
    public RendererModel rightbackleg;
    
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public MooseEntityModel() {

    	this.textureWidth = 64;
        this.textureHeight = 32;
        this.leftantler = new RendererModel(this, 50, 0);
        this.leftantler.setRotationPoint(6.8F, -3.7F, -11.7F);
        this.leftantler.addBox(0.0F, 0.0F, -1.7F, 1, 7, 1, 0.4F);
        this.setRotateAngle(leftantler, 0.0F, 0.0F, 0.40980330836826856F);
        this.rightbackleg = new RendererModel(this, 29, 24);
        this.rightbackleg.setRotationPoint(-4.2F, 18.5F, 6.0F);
        this.rightbackleg.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.5F);
        this.nose = new RendererModel(this, 42, 19);
        this.nose.setRotationPoint(-2.0F, 11.3F, -16.1F);
        this.nose.addBox(0.0F, 0.0F, 0.0F, 4, 5, 7, 2.0F);
        this.setRotateAngle(nose, 0.31869712141416456F, 0.0F, 0.0F);
        this.rightantler3 = new RendererModel(this, 45, 0);
        this.rightantler3.setRotationPoint(-3.9F, -3.9F, -10.3F);
        this.rightantler3.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.4F);
        this.setRotateAngle(rightantler3, -0.40980330836826856F, 0.31869712141416456F, 0.0F);
        this.rightfrontleg = new RendererModel(this, 20, 24);
        this.rightfrontleg.setRotationPoint(-4.2F, 18.5F, -5.0F);
        this.rightfrontleg.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.5F);
        this.rightantler = new RendererModel(this, 35, 0);
        this.rightantler.setRotationPoint(-4.4F, 1.4F, -12.3F);
        this.rightantler.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.4F);
        this.setRotateAngle(rightantler, 0.0F, 0.0F, -0.18203784098300857F);
        this.leftantler2 = new RendererModel(this, 60, 0);
        this.leftantler2.setRotationPoint(4.3F, 3.9F, -14.0F);
        this.leftantler2.addBox(0.0F, 0.0F, 0.7F, 1, 5, 1, 0.4F);
        this.setRotateAngle(leftantler2, 0.40980330836826856F, -0.5918411493512771F, 0.36425021489121656F);
        this.rightantler2 = new RendererModel(this, 40, 0);
        this.rightantler2.setRotationPoint(-6.1F, -2.9F, -14.3F);
        this.rightantler2.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.4F);
        this.setRotateAngle(rightantler2, 1.2747884856566583F, 0.8651597102135892F, 0.8196066167365371F);
        this.leftantler3 = new RendererModel(this, 55, 0);
        this.leftantler3.setRotationPoint(2.4F, -2.0F, -12.5F);
        this.leftantler3.addBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.4F);
        this.setRotateAngle(leftantler3, -0.5009094953223726F, -1.1838568316277536F, 0.0F);
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(-5.0F, 6.5F, -5.5F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 10, 9, 14, 3.0F);
        this.leftfrontleg = new RendererModel(this, 0, 24);
        this.leftfrontleg.setRotationPoint(2.2F, 18.5F, -5.0F);
        this.leftfrontleg.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.5F);
        this.leftbackleg = new RendererModel(this, 10, 24);
        this.leftbackleg.setRotationPoint(2.2F, 18.5F, 6.0F);
        this.leftbackleg.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2, 0.5F);
        
    }

    @Override
    public void render(MooseEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
    	if(!this.isChild) {
    	
    		this.leftbackleg.render(f5);
    		this.rightbackleg.render(f5);
    		this.leftantler.render(f5);
    		this.rightantler2.render(f5);
    		this.rightantler3.render(f5);
    		this.rightfrontleg.render(f5);
    		this.nose.render(f5);
    		this.rightantler.render(f5);
    		this.leftantler2.render(f5);
    		this.leftfrontleg.render(f5);
    		this.body.render(f5);
    		this.leftantler3.render(f5);
        
    	} else {
    		
            GlStateManager.pushMatrix();
            GlStateManager.translated(0.0F, this.childYOffset * f5, this.childZOffset * f5);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scaled(0.5F, 0.5F, 0.5F);
            GlStateManager.translated(0.0F, 24.0F * f5, 0.0F);
        	this.body.render(f5);
            this.nose.render(f5);
            this.leftantler.render(f5);
            this.leftantler2.render(f5);
            this.leftantler3.render(f5);
            this.leftbackleg.render(f5);
            this.leftfrontleg.render(f5);
            this.rightantler.render(f5);
            this.rightantler2.render(f5);
            this.rightantler3.render(f5);
            this.rightbackleg.render(f5);
            this.rightfrontleg.render(f5);
            GlStateManager.popMatrix();
    		
    	}
       
    }

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
    	
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
        
    }
    
    @Override
    public void setRotationAngles(MooseEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
    	
    	this.rightfrontleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    	this.leftfrontleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    	
    	this.rightbackleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.leftbackleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    }
    
}
