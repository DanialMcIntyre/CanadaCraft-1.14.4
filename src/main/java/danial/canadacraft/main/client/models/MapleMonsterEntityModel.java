package danial.canadacraft.main.client.models;

import danial.canadacraft.main.init.entities.MapleMonsterEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.math.MathHelper;

public class MapleMonsterEntityModel extends EntityModel<MapleMonsterEntity> {
	
    public RendererModel body;
    public RendererModel frontrightleg;
    public RendererModel backrightleg;
    public RendererModel backleftleg;
    public RendererModel frontleftleg;
    public RendererModel head;

    public MapleMonsterEntityModel() {
    	
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.body = new RendererModel(this, 0, 0);
        this.body.setRotationPoint(-12.5F, -10.0F, -10.0F);
        this.body.addBox(0.0F, 0.0F, 0.0F, 25, 20, 25, 0.0F);
        this.frontrightleg = new RendererModel(this, 0, 0);
        this.frontrightleg.setRotationPoint(-11.0F, 10.0F, -8.0F);
        this.frontrightleg.addBox(0.0F, 0.0F, 0.0F, 5, 14, 5, 0.0F);
        this.backleftleg = new RendererModel(this, 95, 0);
        this.backleftleg.setRotationPoint(6.0F, 10.0F, 8.0F);
        this.backleftleg.addBox(0.0F, 0.0F, 0.0F, 5, 14, 5, 0.0F);
        this.head = new RendererModel(this, 92, 38);
        this.head.setRotationPoint(-3.5F, -15.0F, -2.4F);
        this.head.addBox(0.0F, 0.0F, 0.0F, 8, 5, 8, 0.0F);
        this.backrightleg = new RendererModel(this, 75, 0);
        this.backrightleg.setRotationPoint(-11.0F, 10.0F, 8.0F);
        this.backrightleg.addBox(0.0F, 0.0F, 0.0F, 5, 14, 5, 0.0F);
        this.frontleftleg = new RendererModel(this, 100, 19);
        this.frontleftleg.setRotationPoint(6.0F, 10.0F, -8.0F);
        this.frontleftleg.addBox(0.0F, 0.0F, 0.0F, 5, 14, 5, 0.0F);
        
    }

    @Override
    public void render(MapleMonsterEntity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
        this.body.render(f5);
        this.frontrightleg.render(f5);
        this.backleftleg.render(f5);
        this.head.render(f5);
        this.backrightleg.render(f5);
        this.frontleftleg.render(f5);
        
    }

    public void setRotateAngle(RendererModel modelRenderer, float x, float y, float z) {
    	
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
        
    }
    
    @Override
    public void setRotationAngles(MapleMonsterEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
    	
    	this.frontrightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    	this.frontleftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F * limbSwingAmount;
    	
    	this.backrightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.backleftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    }
    
}
