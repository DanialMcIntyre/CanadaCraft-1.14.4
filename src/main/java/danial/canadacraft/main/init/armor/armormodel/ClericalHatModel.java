package danial.canadacraft.main.init.armor.armormodel;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;

public class ClericalHatModel extends BipedModel<LivingEntity> {

	public RendererModel shape17;
	public RendererModel shape17_1;
	public RendererModel shape17_2;
	public RendererModel shape20;

	public ClericalHatModel() {

		this.textureWidth = 64;
		this.textureHeight = 64;
		this.shape17 = new RendererModel(this, 0, 0);
		this.shape17.setRotationPoint(-5.5F, -8.4F, -7.5F);
		this.shape17.addBox(0.0F, 0.0F, 0.0F, 11, 2, 18, 0.0F);
		this.shape20 = new RendererModel(this, 40, 0);
		this.shape20.setRotationPoint(-1.5F, -13.7F, -3.8F);
		this.shape20.addBox(0.0F, 0.0F, 0.0F, 3, 2, 7, 0.0F);
		this.shape17_1 = new RendererModel(this, 0, 20);
		this.shape17_1.setRotationPoint(-5.5F, -9.5F, -5.0F);
		this.shape17_1.addBox(0.0F, 0.0F, 0.0F, 11, 1, 12, 0.2F);
		this.shape17_2 = new RendererModel(this, 0, 33);
		this.shape17_2.setRotationPoint(-5.0F, -11.7F, -4.3F);
		this.shape17_2.addBox(0.0F, 0.0F, 0.0F, 10, 2, 10, 0.1F);

	}

	@Override
	public void render(LivingEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		this.shape17.render(f5);
		this.shape20.render(f5);
		this.shape17_1.render(f5);
		this.shape17_2.render(f5);

	}

}
