package danial.canadacraft.main.client.models;

import danial.canadacraft.main.init.entities.CanadaBossEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class CanadaBossEntityModel extends EntityModel<CanadaBossEntity> {
	
    public RendererModel right_arm;
    public RendererModel right_leg;
    public RendererModel head;
    public RendererModel body;
    public RendererModel left_arm;
    public RendererModel left_leg;

    public CanadaBossEntityModel() {
    	
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.left_leg = new RendererModel(this, 16, 48);
        this.left_leg.setRotationPoint(1.899999976158142F, 12.0F, 0.0F);
        this.left_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.right_arm = new RendererModel(this, 40, 16);
        this.right_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.right_arm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.right_leg = new RendererModel(this, 0, 16);
        this.right_leg.setRotationPoint(-1.899999976158142F, 12.0F, 0.0F);
        this.right_leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.left_arm = new RendererModel(this, 32, 48);
        this.left_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.left_arm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.body = new RendererModel(this, 16, 16);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.head = new RendererModel(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void render(CanadaBossEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.left_leg.render(f5);
        this.right_arm.render(f5);
        this.right_leg.render(f5);
        this.left_arm.render(f5);
        this.body.render(f5);
        this.head.render(f5);
    }

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }
    
    public void setRotationAngles(CanadaBossEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {

        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);

        this.body.rotateAngleY = 0.0F;
        this.right_arm.rotationPointZ = 0.0F;
        this.right_arm.rotationPointX = -5.0F;
        this.left_arm.rotationPointZ = 0.0F;
        this.left_arm.rotationPointX = 5.0F;

        this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        
     }
    
}
