package danial.canadacraft.main.init.armor.armormodel;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;

public class NavyHatModel extends BipedModel<LivingEntity> {

	public RendererModel shape1;
	public RendererModel shape1_1;
	public RendererModel shape1_2;
	public RendererModel shape1_3;
	public RendererModel shape1_4;
	public RendererModel shape1_5;
	public RendererModel shape1_6;

	public NavyHatModel() {

		this.textureWidth = 64;
		this.textureHeight = 32;
		this.shape1_5 = new RendererModel(this, 39, 7);
		this.shape1_5.setRotationPoint(-2.5F, -12.0F, -2.5F);
		this.shape1_5.addBox(0.0F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
		this.shape1 = new RendererModel(this, 0, 0);
		this.shape1.setRotationPoint(-5.5F, -9.0F, -2.5F);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 11, 1, 5, 0.0F);
		this.shape1_4 = new RendererModel(this, 24, 6);
		this.shape1_4.setRotationPoint(-2.5F, -11.0F, -2.5F);
		this.shape1_4.addBox(0.0F, 0.0F, 0.0F, 5, 1, 5, 0.0F);
		this.shape1_3 = new RendererModel(this, 0, 6);
		this.shape1_3.setRotationPoint(-3.5F, -10.0F, -2.5F);
		this.shape1_3.addBox(0.0F, 0.0F, 0.0F, 7, 1, 5, 0.0F);
		this.shape1_6 = new RendererModel(this, 0, 12);
		this.shape1_6.setRotationPoint(-1.5F, -13.0F, -2.5F);
		this.shape1_6.addBox(0.0F, 0.0F, 0.0F, 3, 1, 5, 0.0F);
		this.shape1_2 = new RendererModel(this, 44, 0);
		this.shape1_2.setRotationPoint(5.0F, -10.0F, -2.4F);
		this.shape1_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
		this.shape1_1 = new RendererModel(this, 32, 0);
		this.shape1_1.setRotationPoint(-6.2F, -10.0F, -2.5F);
		this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);

	}

	@Override
	public void render(LivingEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		this.shape1_5.render(f5);
		this.shape1.render(f5);
		this.shape1_4.render(f5);
		this.shape1_3.render(f5);
		this.shape1_6.render(f5);
		this.shape1_2.render(f5);
		this.shape1_1.render(f5);

	}
	
}