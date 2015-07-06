package zollernextras.mobs.renders;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import zollernextras.mobs.entities.EntityDuck;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDuck extends RenderLiving {
	private static final ResourceLocation chickenTextures = new ResourceLocation(
			"zollernextras:textures/entity/duck.png");
	
	public RenderDuck(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	public void renderDuck(EntityDuck par1EntityDuck, double par2, double par4,
			double par6, float par8, float par9) {
		super.doRender(par1EntityDuck, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation getDuckTextures(EntityDuck par1EntityDuck) {
		return chickenTextures;
	}
	
	protected float getWingRotation(EntityDuck par1EntityDuck, float par2) {
		float f1 = par1EntityDuck.field_70888_h
				+ (par1EntityDuck.field_70886_e - par1EntityDuck.field_70888_h)
				* par2;
		float f2 = par1EntityDuck.field_70884_g
				+ (par1EntityDuck.destPos - par1EntityDuck.field_70884_g)
				* par2;
		return (MathHelper.sin(f1) + 1.0F) * f2;
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		this.renderDuck((EntityDuck) par1EntityLiving, par2, par4, par6, par8,
				par9);
	}
	
	/**
	 * Defines what float the third param in setRotationAngles of ModelBase is
	 */
	@Override
	protected float handleRotationFloat(EntityLivingBase par1EntityLivingBase,
			float par2) {
		return this.getWingRotation((EntityDuck) par1EntityLivingBase, par2);
	}
	
	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getDuckTextures((EntityDuck) par1Entity);
	}
	
	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		this.renderDuck((EntityDuck) par1Entity, par2, par4, par6, par8, par9);
	}
}