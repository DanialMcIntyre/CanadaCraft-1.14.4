package danial.canadacraft.main.client.models;

import danial.canadacraft.main.init.entities.SiltstoneGolemEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class SiltstoneGolemEntityModel extends EntityModel<SiltstoneGolemEntity> {
	
    public RendererModel body;
    public RendererModel rightshoulder;
    public RendererModel leftshoulder;
    public RendererModel rightarmconnect;
    public RendererModel leftarmconnect;
    public RendererModel rightleg;
    public RendererModel leftleg;
    public RendererModel head;
    public RendererModel leftarm;
    public RendererModel leftconnect;
    public RendererModel leftarm_1;
    public RendererModel rightorb;
    public RendererModel leftconnect_1;
    public RendererModel leftorb;

    public SiltstoneGolemEntityModel() {
    	
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.rightarmconnect = new RendererModel(this, 0, 50);
        this.rightarmconnect.setRotationPoint(-37.0F, -6.5F, -8.0F);
        this.rightarmconnect.addBox(0.0F, 0.0F, 0.0F, 12, 13, 16, 0.0F);
        this.leftarm_1 = new RendererModel(this, 0, 0);
        this.leftarm_1.setRotationPoint(28.0F, 6.5F, -3.0F);
        this.leftarm_1.addBox(0.0F, 0.0F, 0.0F, 6, 18, 6, 0.0F);
        this.rightshoulder = new RendererModel(this, 93, 25);
        this.rightshoulder.setRotationPoint(-25.0F, -3.4F, -4.0F);
        this.rightshoulder.addBox(0.0F, 0.0F, 0.0F, 9, 6, 8, 0.0F);
        this.rightorb = new RendererModel(this, 63, 50);
        this.rightorb.setRotationPoint(-35.0F, -23.0F, -4.0F);
        this.rightorb.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        this.head = new RendererModel(this, 0, 25);
        this.head.setRotationPoint(-4.0F, -21.6F, -5.5F);
        this.head.addBox(0.0F, 0.0F, 0.0F, 8, 12, 11, 0.0F);
        this.leftarmconnect = new RendererModel(this, 0, 50);
        this.leftarmconnect.setRotationPoint(25.0F, -6.5F, -8.0F);
        this.leftarmconnect.addBox(0.0F, 0.0F, 0.0F, 12, 13, 16, 0.0F);
        this.leftconnect_1 = new RendererModel(this, 48, 0);
        this.leftconnect_1.setRotationPoint(29.5F, -15.3F, -1.5F);
        this.leftconnect_1.addBox(0.0F, 0.0F, 0.0F, 3, 9, 3, 0.0F);
        this.body = new RendererModel(this, 0, 85);
        this.body.setRotationPoint(-16.0F, -9.6F, -11.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 32, 20, 22, 0.0F);
        this.rightleg = new RendererModel(this, 76, 0);
        this.rightleg.setRotationPoint(-11.0F, 10.0F, -3.0F);
        this.rightleg.addBox(0.0F, 0.0F, 0.0F, 6, 14, 6, 0.0F);
        this.leftshoulder = new RendererModel(this, 57, 25);
        this.leftshoulder.setRotationPoint(16.0F, -3.4F, -4.0F);
        this.leftshoulder.addBox(0.0F, 0.0F, 0.0F, 9, 6, 8, 0.0F);
        this.leftarm = new RendererModel(this, 0, 0);
        this.leftarm.setRotationPoint(-34.0F, 6.5F, -3.0F);
        this.leftarm.addBox(0.0F, 0.0F, 0.0F, 6, 18, 6, 0.0F);
        this.leftconnect = new RendererModel(this, 29, 0);
        this.leftconnect.setRotationPoint(-32.5F, -15.3F, -1.5F);
        this.leftconnect.addBox(0.0F, 0.0F, 0.0F, 3, 9, 3, 0.0F);
        this.leftorb = new RendererModel(this, 63, 50);
        this.leftorb.setRotationPoint(27.0F, -23.0F, -4.0F);
        this.leftorb.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        this.leftleg = new RendererModel(this, 103, 0);
        this.leftleg.setRotationPoint(5.0F, 10.0F, -3.0F);
        this.leftleg.addBox(0.0F, 0.0F, 0.0F, 6, 14, 6, 0.0F);
        
    }

    @Override
    public void render(SiltstoneGolemEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
        this.rightarmconnect.render(f5);
        this.leftarm_1.render(f5);
        this.rightshoulder.render(f5);
        this.rightorb.render(f5);
        this.head.render(f5);
        this.leftarmconnect.render(f5);
        this.leftconnect_1.render(f5);
        this.body.render(f5);
        this.rightleg.render(f5);
        this.leftshoulder.render(f5);
        this.leftarm.render(f5);
        this.leftconnect.render(f5);
        this.leftorb.render(f5);
        this.leftleg.render(f5);
        
    }

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
    	
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
        
    }
    
    @Override
    public void setRotationAngles(SiltstoneGolemEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
    	
    	this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    	this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    }
    
}
