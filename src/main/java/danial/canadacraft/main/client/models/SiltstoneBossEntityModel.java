package danial.canadacraft.main.client.models;

import danial.canadacraft.main.init.entities.SiltstoneBossEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class SiltstoneBossEntityModel extends EntityModel<SiltstoneBossEntity> {
		
    public RendererModel body;
    public RendererModel leftbackleg;
    public RendererModel leftfrontleg;
    public RendererModel rightfrontleg;
    public RendererModel head;
    public RendererModel rightbackleg;

    public SiltstoneBossEntityModel() {
    	
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.rightfrontleg = new RendererModel(this, 0, 16);
        this.rightfrontleg.setRotationPoint(-3.0F, 17.0F, -4.0F);
        this.rightfrontleg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 1.0F);
        this.head = new RendererModel(this, 0, 0);
        this.head.setRotationPoint(0.0F, -4.9F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 5.0F);
        this.leftbackleg = new RendererModel(this, 0, 16);
        this.leftbackleg.setRotationPoint(3.0F, 17.0F, 4.0F);
        this.leftbackleg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 1.0F);
        this.body = new RendererModel(this, 16, 16);
        this.body.setRotationPoint(0.0F, 2.1F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 2.0F);
        this.leftfrontleg = new RendererModel(this, 0, 16);
        this.leftfrontleg.setRotationPoint(3.0F, 17.0F, -4.0F);
        this.leftfrontleg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 1.0F);
        this.rightbackleg = new RendererModel(this, 0, 16);
        this.rightbackleg.setRotationPoint(-3.0F, 17.0F, 4.0F);
        this.rightbackleg.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 1.0F);
    
    }

    @Override
    public void render(SiltstoneBossEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
        this.rightfrontleg.render(f5);
        this.head.render(f5);
        this.leftbackleg.render(f5);
        this.body.render(f5);
        this.leftfrontleg.render(f5);
        this.rightbackleg.render(f5);
        
    }

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
    	
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
        
    }
    
    public void setRotationAngles(SiltstoneBossEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
     
    	this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.rightbackleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftbackleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightfrontleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftfrontleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
   
    }
    
}
