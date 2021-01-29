package danial.canadacraft.main.init.armor.armormodel;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;

public class ContinentalHatModel extends BipedModel<LivingEntity> {

	public RendererModel shape1;
	public RendererModel shape2;
	public RendererModel shape2_1;
	public RendererModel shape2_2;
	public RendererModel shape2_3;
	public RendererModel shape7;
	public RendererModel shape7_1;
	public RendererModel shape7_2;
	public RendererModel shape11;
	public RendererModel shape11_1;
	public RendererModel shape7_3;
	public RendererModel shape7_4;
	public RendererModel shape7_5;
	public RendererModel shape16;
	public RendererModel shape7_6;

	public ContinentalHatModel() {

		this.textureWidth = 64;
		this.textureHeight = 32;
		this.shape11_1 = new RendererModel(this, 48, 2);
		this.shape11_1.setRotationPoint(-4.5F, -10.0F, 1.0F);
		this.shape11_1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.shape1 = new RendererModel(this, 0, 0);
		this.shape1.setRotationPoint(-4.5F, -9.0F, -4.0F);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 9, 1, 6, 0.0F);
		this.shape7_4 = new RendererModel(this, 56, 2);
		this.shape7_4.setRotationPoint(-3.5F, -10.0F, -4.5F);
		this.shape7_4.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.shape7_5 = new RendererModel(this, 0, 4);
		this.shape7_5.setRotationPoint(-0.9F, -10.0F, -6.5F);
		this.shape7_5.addBox(-0.1F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.shape2_3 = new RendererModel(this, 50, 0);
		this.shape2_3.setRotationPoint(-2.0F, -9.0F, 2.0F);
		this.shape2_3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
		this.shape16 = new RendererModel(this, 24, 4);
		this.shape16.setRotationPoint(-2.1F, -10.0F, -5.5F);
		this.shape16.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.shape7_1 = new RendererModel(this, 29, 2);
		this.shape7_1.setRotationPoint(3.5F, -10.0F, -4.0F);
		this.shape7_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
		this.shape7_3 = new RendererModel(this, 0, 2);
		this.shape7_3.setRotationPoint(1.5F, -10.0F, -4.5F);
		this.shape7_3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.shape7_6 = new RendererModel(this, 28, 4);
		this.shape7_6.setRotationPoint(1.0F, -10.0F, -5.5F);
		this.shape7_6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.shape7 = new RendererModel(this, 24, 2);
		this.shape7.setRotationPoint(-2.0F, -10.0F, 2.0F);
		this.shape7.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
		this.shape2_2 = new RendererModel(this, 0, 0);
		this.shape2_2.setRotationPoint(-1.0F, -9.0F, -6.5F);
		this.shape2_2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.shape2_1 = new RendererModel(this, 40, 0);
		this.shape2_1.setRotationPoint(-2.0F, -9.0F, -5.5F);
		this.shape2_1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
		this.shape7_2 = new RendererModel(this, 41, 2);
		this.shape7_2.setRotationPoint(-4.5F, -10.0F, -4.0F);
		this.shape7_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 5, 0.0F);
		this.shape2 = new RendererModel(this, 24, 0);
		this.shape2.setRotationPoint(-3.5F, -9.0F, -4.5F);
		this.shape2.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.shape11 = new RendererModel(this, 36, 2);
		this.shape11.setRotationPoint(1.5F, -10.0F, 1.0F);
		this.shape11.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);

	}

	@Override
	public void render(LivingEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		this.shape11_1.render(f5);
		this.shape1.render(f5);
		this.shape7_4.render(f5);
		this.shape7_5.render(f5);
		this.shape2_3.render(f5);
		this.shape16.render(f5);
		this.shape7_1.render(f5);
		this.shape7_3.render(f5);
		this.shape7_6.render(f5);
		this.shape7.render(f5);
		this.shape2_2.render(f5);
		this.shape2_1.render(f5);
		this.shape7_2.render(f5);
		this.shape2.render(f5);
		this.shape11.render(f5);

	}

}