package zollernextras.mobs.renderers;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollernextras.lib.ZollernModInfo;
import zollernextras.mobs.entities.EntityHellDuck;
import zollernextras.mobs.models.ModelHellDuck;

@SideOnly(Side.CLIENT)
public class RenderHellDuck extends RenderLiving<EntityHellDuck> {
	
	private static final float f6 = 1.4F;
	
	private static final ResourceLocation HELLDUCK_TEXTURES = new ResourceLocation(
			ZollernModInfo.modId + ":textures/entity/hellduck.png");
	
	public RenderHellDuck(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelHellDuck(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityHellDuck entitylivingbaseIn,
			float partialTickTime) {
		this.scaleHellDuck(entitylivingbaseIn, partialTickTime);
	}
	
	@Override
	protected float getDeathMaxRotation(EntityHellDuck entityLivingBaseIn) {
		return 180.0F;
	}
	
	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityHellDuck entity) {
		return HELLDUCK_TEXTURES;
	}
	
	protected void scaleHellDuck(EntityHellDuck par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
}