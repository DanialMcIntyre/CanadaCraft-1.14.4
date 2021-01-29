package danial.canadacraft.main.init.armor.armormodel;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;

public class ArmyHatModel extends BipedModel<LivingEntity> {

	public RendererModel shape17;
	public RendererModel shape17_1;
	public RendererModel shape17_2;
	public RendererModel shape20;
	public RendererModel shape20_1;

	public ArmyHatModel() {

		this.textureWidth = 64;
		this.textureHeight = 64;
		this.shape20 = new RendererModel(this, 0, 0);
		this.shape20.setRotationPoint(-0.5F, -18.1F, -0.6F);
		this.shape20.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
		this.shape17_1 = new RendererModel(this, 23, 0);
		this.shape17_1.setRotationPoint(-5.0F, -13.0F, -4.5F);
		this.shape17_1.addBox(0.0F, 0.0F, 0.0F, 10, 5, 9, -0.2F);
		this.shape20_1 = new RendererModel(this, 0, 0);
		this.shape20_1.setRotationPoint(1.5F, -17.4F, -0.6F);
		this.shape20_1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
		this.shape17 = new RendererModel(this, 0, 0);
		this.shape17.setRotationPoint(-4.5F, -8.4F, -3.5F);
		this.shape17.addBox(0.0F, 0.0F, 0.0F, 9, 1, 7, -0.2F);
		this.shape17_2 = new RendererModel(this, 0, 14);
		this.shape17_2.setRotationPoint(-5.5F, -15.6F, -5.0F);
		this.shape17_2.addBox(0.0F, 0.0F, 0.0F, 11, 3, 10, -0.2F);

	}

	@Override
	public void render(LivingEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		this.shape20.render(f5);
		this.shape17_1.render(f5);
		this.shape20_1.render(f5);
		this.shape17.render(f5);
		this.shape17_2.render(f5);

	}

}
