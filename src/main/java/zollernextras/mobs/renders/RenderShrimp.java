package zollernextras.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import zollernextras.mobs.entities.EntityShrimp;
import zollernextras.mobs.models.ModelShrimp;

public class RenderShrimp extends RenderLiving {
	public ModelShrimp model;
	
	public RenderShrimp(ModelShrimp par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelShrimp) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("zollernextras:textures/entity/shrimp.png");
	}
	
	public void renderTutorial(EntityShrimp entity, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderTutorial((EntityShrimp) par1EntityLiving, par2, par4, par6, par8,
				par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderTutorial((EntityShrimp) par1Entity, par2, par4, par6, par8, par9);
	}
}