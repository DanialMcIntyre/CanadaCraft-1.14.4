package danial.canadacraft.main.client.models;

import danial.canadacraft.main.init.entities.GypsumGolemEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;

public class GypsumGolemEntityModel extends EntityModel<GypsumGolemEntity> {
	
    public RendererModel field_78176_b0;
    public RendererModel field_78176_b1;
    public RendererModel field_78174_d;
    public RendererModel field_78177_c;
    public RendererModel field_78175_e;
    public RendererModel field_78178_a0;
    public RendererModel field_78178_a1;
    public RendererModel field_78173_f;

    public GypsumGolemEntityModel() {
    	
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.field_78176_b1 = new RendererModel(this, 0, 70);
        this.field_78176_b1.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.field_78176_b1.addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, 0.5F);
        this.field_78177_c = new RendererModel(this, 60, 21);
        this.field_78177_c.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.field_78177_c.addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F);
        this.field_78178_a1 = new RendererModel(this, 24, 0);
        this.field_78178_a1.setRotationPoint(0.0F, -7.0F, -2.0F);
        this.field_78178_a1.addBox(-1.0F, -5.0F, -7.5F, 2, 4, 2, 0.0F);
        this.field_78175_e = new RendererModel(this, 37, 0);
        this.field_78175_e.setRotationPoint(-4.0F, 11.0F, 0.0F);
        this.field_78175_e.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F);
        this.field_78174_d = new RendererModel(this, 60, 58);
        this.field_78174_d.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.field_78174_d.addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, 0.0F);
        this.field_78176_b0 = new RendererModel(this, 0, 40);
        this.field_78176_b0.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.field_78176_b0.addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, 0.0F);
        this.field_78178_a0 = new RendererModel(this, 0, 0);
        this.field_78178_a0.setRotationPoint(0.0F, -7.0F, -2.0F);
        this.field_78178_a0.addBox(-4.0F, -12.0F, -5.5F, 8, 10, 8, 0.0F);
        this.field_78173_f = new RendererModel(this, 60, 0);
        this.field_78173_f.mirror = true;
        this.field_78173_f.setRotationPoint(5.0F, 11.0F, 0.0F);
        this.field_78173_f.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, 0.0F);
        
    }

    @Override
    public void render(GypsumGolemEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
        this.field_78176_b1.render(f5);
        this.field_78177_c.render(f5);
        this.field_78178_a1.render(f5);
        this.field_78175_e.render(f5);
        this.field_78174_d.render(f5);
        this.field_78176_b0.render(f5);
        this.field_78178_a0.render(f5);
        this.field_78173_f.render(f5);
        
    }

    public void setRotateAngle(RendererModel RendererModel, float x, float y, float z) {
    	
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
        
    }
    
	@Override
	public void setRotationAngles(GypsumGolemEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		
		this.field_78178_a0.rotateAngleY = netHeadYaw * 0.017453292F;
		this.field_78178_a0.rotateAngleX = headPitch * 0.017453292F;
		this.field_78178_a1.rotateAngleY = netHeadYaw * 0.017453292F;
		this.field_78178_a1.rotateAngleX = headPitch * 0.017453292F;
		this.field_78175_e.rotateAngleX = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		this.field_78173_f.rotateAngleX = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
		this.field_78175_e.rotateAngleY = 0.0F;
		this.field_78173_f.rotateAngleY = 0.0F;
		
	}

	public void setLivingAnimations(GypsumGolemEntity entityIn, float p_78086_2_, float p_78086_3_, float partialTickTime) {
		
		GypsumGolemEntity entitygypsumgolem = (GypsumGolemEntity) entityIn;
		int i = entitygypsumgolem.getAttackTimer();

		if (i > 0) {
			
			this.field_78177_c.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float) i - partialTickTime, 10.0F);
			this.field_78174_d.rotateAngleX = -2.0F + 1.5F * this.triangleWave((float) i - partialTickTime, 10.0F);
			
		} else {
			
			this.field_78177_c.rotateAngleX = (-0.2F + 1.5F * this.triangleWave(p_78086_2_, 13.0F)) * p_78086_3_;
			this.field_78174_d.rotateAngleX = (-0.2F - 1.5F * this.triangleWave(p_78086_2_, 13.0F)) * p_78086_3_;
			
		}
		
	}

	private float triangleWave(float p_78172_1_, float p_78172_2_) {
		
		return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
		
	}
	
}
