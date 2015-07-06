package zollernextras.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import zollernextras.mobs.entities.EntityFish;
import zollernextras.mobs.models.ModelFish;

public class RenderFish extends RenderLiving {
	public ModelFish model;
	
	public RenderFish(ModelFish modelFish, float par2) {
		super(modelFish, par2);
		model = (ModelFish) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("zollernextras:textures/entity/shark.png");
	}
	
	public void renderTutorial(EntityFish entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	protected void scaleFish(EntityFish par1EntityFish, float par2) {
		float f6 = 0.5F;// 0.9F + par1EntityFish.getFishSize();
		this.shadowSize *= f6;
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleFish((EntityFish) par1EntityLivingBase, par2);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityFish) par1EntityLiving, par2, par4, par6, par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityFish) par1Entity, par2, par4, par6, par8, par9);
	}
}