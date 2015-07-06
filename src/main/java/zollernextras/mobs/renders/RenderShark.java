package zollernextras.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import zollernextras.mobs.entities.EntityShark;
import zollernextras.mobs.models.ModelShark;

public class RenderShark extends RenderLiving {
	public ModelShark model;
	float f6 = 2.5F;
	
	public RenderShark(ModelShark modelShark, float par2) {
		super(modelShark, par2);
		model = (ModelShark) mainModel;
		if (this.shadowSize > 0) {
			this.shadowSize *= f6;
		}
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("zollernextras:textures/entity/shark.png");
	}
	
	public void renderTutorial(EntityShark entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	protected void scaleShark(EntityShark par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleShark((EntityShark) par1EntityLivingBase, par2);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityShark) par1EntityLiving, par2, par4, par6, par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityShark) par1Entity, par2, par4, par6, par8, par9);
	}
}