package danial.canadacraft.main.init.armor.armormodel;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.LivingEntity;

public class RegentHatModel extends BipedModel<LivingEntity> {
	
	public RendererModel shape1;
    public RendererModel shape1_1;

    public RegentHatModel() {
    	
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape1_1 = new RendererModel(this, 0, 11);
        this.shape1_1.setRotationPoint(-4.0F, -14.0F, -4.0F);
        this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 8, 5, 8, 0.0F);
        this.shape1 = new RendererModel(this, 0, 0);
        this.shape1.setRotationPoint(-5.0F, -9.0F, -5.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10, 0.0F);
        
    }

    @Override
    public void render(LivingEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
        this.shape1_1.render(f5);
        this.shape1.render(f5);
        
    }
}
