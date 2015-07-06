package zollernextras.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import zollernextras.mobs.entities.EntityJellyfish;
import zollernextras.mobs.models.ModelJellyfish;

public class RenderJellyfish extends RenderLiving {
	public ModelJellyfish model;
	float f6 = 0.2F;
	
	public RenderJellyfish(ModelJellyfish modelJellyfish, float par2) {
		super(modelJellyfish, par2);
		model = (ModelJellyfish) mainModel;
		if (this.shadowSize > 0) {
			this.shadowSize /= f6;
		}
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(
				"zollernextras:textures/entity/jellyfish.png");
	}
	
	public void renderTutorial(EntityJellyfish entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	protected void scaleJellyfish(EntityJellyfish par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleJellyfish((EntityJellyfish) par1EntityLivingBase, par2);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityJellyfish) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityJellyfish) par1Entity, par2, par4, par6, par8,
				par9);
	}
}