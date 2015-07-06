package zollernextras.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import zollernextras.mobs.entities.EntityBabyDragon;
import zollernextras.mobs.models.ModelBabyDragon;

public class RenderBabyDragon extends RenderLiving {
	public ModelBabyDragon model;
	float f6 = 1.8F;
	
	public RenderBabyDragon(ModelBabyDragon par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = (ModelBabyDragon) mainModel;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("zollernextras:textures/entity/dragon.png");
	}
	
	public void renderBabyDragon(EntityBabyDragon entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderBabyDragon((EntityBabyDragon) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderBabyDragon((EntityBabyDragon) par1Entity, par2, par4, par6, par8,
				par9);
	}
	
	protected void scaleBabyDragon(EntityBabyDragon par1EntityCaveSpider,
			float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleBabyDragon((EntityBabyDragon) par1EntityLivingBase, par2);
	}
}