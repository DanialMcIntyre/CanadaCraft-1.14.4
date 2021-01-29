package danial.canadacraft.main.client.models;

import com.mojang.blaze3d.platform.GlStateManager;

import danial.canadacraft.main.init.entities.GrizzlyBearEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class GrizzlyBearEntityModel extends EntityModel<GrizzlyBearEntity> {
	
    public RendererModel backbody;
    public RendererModel frontbody;
    public RendererModel leftbackleg;
    public RendererModel leftfrontleg;
    public RendererModel rightbackleg;
    public RendererModel rightfrontleg;
    public RendererModel head;
    public RendererModel nose;
    public RendererModel rightear;
    public RendererModel leftear;
    
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public GrizzlyBearEntityModel() {
    	
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.backbody = new RendererModel(this, 0, 19);
        this.backbody.setRotationPoint(-2.0F, 9.0F, 12.0F);
        this.backbody.addBox(-5.0F, -13.0F, -7.0F, 14, 14, 11, 0.0F);
        this.setRotateAngle(backbody, 1.5707963267948966F, 0.0F, 0.0F);
        this.rightbackleg = new RendererModel(this, 50, 22);
        this.rightbackleg.setRotationPoint(-4.5F, 14.0F, 6.0F);
        this.rightbackleg.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 8, 0.0F);
        this.leftear = new RendererModel(this, 26, 0);
        this.leftear.mirror = true;
        this.leftear.setRotationPoint(0.0F, 10.0F, -16.0F);
        this.leftear.addBox(2.5F, -4.0F, -1.0F, 2, 2, 1, 0.0F);
        this.head = new RendererModel(this, 0, 0);
        this.head.setRotationPoint(0.0F, 10.0F, -16.0F);
        this.head.addBox(-3.5F, -3.0F, -3.0F, 7, 7, 7, 0.0F);
        this.leftbackleg = new RendererModel(this, 50, 22);
        this.leftbackleg.setRotationPoint(4.5F, 14.0F, 6.0F);
        this.leftbackleg.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 8, 0.0F);
        this.frontbody = new RendererModel(this, 39, 0);
        this.frontbody.setRotationPoint(-2.0F, 9.0F, 12.0F);
        this.frontbody.addBox(-4.0F, -25.0F, -7.0F, 12, 12, 10, 0.0F);
        this.setRotateAngle(frontbody, 1.5707963267948966F, 0.0F, 0.0F);
        this.rightfrontleg = new RendererModel(this, 50, 40);
        this.rightfrontleg.setRotationPoint(-3.5F, 14.0F, -8.0F);
        this.rightfrontleg.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 6, 0.0F);
        this.nose = new RendererModel(this, 0, 44);
        this.nose.setRotationPoint(0.0F, 10.0F, -16.0F);
        this.nose.addBox(-2.5F, 1.0F, -6.0F, 5, 3, 3, 0.0F);
        this.rightear = new RendererModel(this, 26, 0);
        this.rightear.setRotationPoint(0.0F, 10.0F, -16.0F);
        this.rightear.addBox(-4.5F, -4.0F, -1.0F, 2, 2, 1, 0.0F);
        this.leftfrontleg = new RendererModel(this, 50, 40);
        this.leftfrontleg.setRotationPoint(3.5F, 14.0F, -8.0F);
        this.leftfrontleg.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 6, 0.0F);
        
    }

    @Override
    public void render(GrizzlyBearEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
    	if(!this.isChild) {
    	
    		this.backbody.render(f5);
    		this.rightbackleg.render(f5);
    		this.leftear.render(f5);
    		this.head.render(f5);
    		this.leftbackleg.render(f5);
    		this.frontbody.render(f5);
    		this.rightfrontleg.render(f5);
    		this.nose.render(f5);
    		this.rightear.render(f5);
    		this.leftfrontleg.render(f5);
        
    	} else {
    	
            GlStateManager.pushMatrix();
            GlStateManager.translated(0.0F, this.childYOffset * f5, this.childZOffset * f5);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scaled(0.5F, 0.5F, 0.5F);
            GlStateManager.translated(0.0F, 24.0F * f5, 0.0F);
            this.backbody.render(f5);
            this.rightbackleg.render(f5);
            this.leftear.render(f5);
            this.head.render(f5);
            this.leftbackleg.render(f5);
            this.frontbody.render(f5);
            this.rightfrontleg.render(f5);
            this.nose.render(f5);
            this.rightear.render(f5);
            this.leftfrontleg.render(f5);
            GlStateManager.popMatrix();

    	}
    	
    }

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
    	
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
        
    }
    
    @Override
    public void setRotationAngles(GrizzlyBearEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
    	
    	this.rightfrontleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    	this.leftfrontleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    	
    	this.rightbackleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.leftbackleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    }
    
}
