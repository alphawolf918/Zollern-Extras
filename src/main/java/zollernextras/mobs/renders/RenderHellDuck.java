package zollernextras.mobs.renders;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import zollernextras.mobs.entities.EntityHellDuck;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHellDuck extends RenderLiving {
	private static final ResourceLocation chickenTextures = new ResourceLocation(
			"zollernextras:textures/entity/hellduck.png");
	float f6 = 2.0F;
	
	public RenderHellDuck(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}
	
	protected void scaleHellDuck(EntityHellDuck par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase,
			float par2) {
		this.scaleHellDuck((EntityHellDuck) par1EntityLivingBase, par2);
	}
	
	public void renderDuck(EntityHellDuck par1EntityHellDuck, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRender(par1EntityHellDuck, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation getDuckTextures(EntityHellDuck par1EntityHellDuck) {
		return chickenTextures;
	}
	
	protected float getWingRotation(EntityHellDuck par1EntityHellDuck,
			float par2) {
		float f1 = par1EntityHellDuck.field_70888_h
				+ (par1EntityHellDuck.field_70886_e - par1EntityHellDuck.field_70888_h)
				* par2;
		float f2 = par1EntityHellDuck.field_70884_g
				+ (par1EntityHellDuck.destPos - par1EntityHellDuck.field_70884_g)
				* par2;
		return (MathHelper.sin(f1) + 1.0F) * f2;
	}
	
	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		this.renderDuck((EntityHellDuck) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}
	
	@Override
	protected float handleRotationFloat(EntityLivingBase par1EntityLivingBase,
			float par2) {
		return this
				.getWingRotation((EntityHellDuck) par1EntityLivingBase, par2);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return this.getDuckTextures((EntityHellDuck) par1Entity);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		this.renderDuck((EntityHellDuck) par1Entity, par2, par4, par6, par8,
				par9);
	}
}