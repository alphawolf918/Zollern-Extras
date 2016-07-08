package zollernextras.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import zollernextras.mobs.entities.EntityEnderBug;
import zollernextras.mobs.models.ModelEnderBug;

public class RenderEnderBug extends RenderLiving {
	
	public ModelEnderBug model;
	
	public RenderEnderBug(ModelEnderBug modelEnderBug, float par2) {
		super(modelEnderBug, par2);
		model = (ModelEnderBug) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(
				"zollernextras:textures/entity/enderfish.png");
	}
	
	public void renderTutorial(EntityEnderBug entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	protected void scaleEnderBug(EntityEnderBug par1EntityEnderBug, float par2) {
		float f6 = 0.5F;// 0.9F + par1EntityEnderBug.getEnderBugSize();
		this.shadowSize *= f6;
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleEnderBug((EntityEnderBug) par1EntityLivingBase, par2);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityEnderBug) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityEnderBug) par1Entity, par2, par4, par6, par8,
				par9);
	}
}