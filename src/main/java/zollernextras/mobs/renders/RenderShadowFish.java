package zollernextras.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import zollernextras.mobs.entities.EntityShadowFish;
import zollernextras.mobs.models.ModelShadowFish;

public class RenderShadowFish extends RenderLiving {
	
	public ModelShadowFish model;
	
	public RenderShadowFish(ModelShadowFish modelShadowFish, float par2) {
		super(modelShadowFish, par2);
		model = (ModelShadowFish) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(
				"zollernextras:textures/entity/shadowfish.png");
	}
	
	public void renderTutorial(EntityShadowFish entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	protected void scaleShadowFish(EntityShadowFish par1EntityShadowFish,
			float par2) {
		float f6 = 0.5F;
		this.shadowSize *= f6;
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleShadowFish((EntityShadowFish) par1EntityLivingBase, par2);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityShadowFish) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityShadowFish) par1Entity, par2, par4, par6, par8,
				par9);
	}
}