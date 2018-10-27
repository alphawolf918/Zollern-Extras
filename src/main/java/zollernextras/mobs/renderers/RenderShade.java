package zollernextras.mobs.renderers;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollernextras.lib.ZollernModInfo;
import zollernextras.mobs.entities.EntityShade;
import zollernextras.mobs.models.ModelShade;

@SideOnly(Side.CLIENT)
public class RenderShade extends RenderBiped<EntityShade> {
	
	private static final float f6 = 1.4F;
	
	private static final ResourceLocation SHADE_TEXTURES = new ResourceLocation(
			ZollernModInfo.modId + ":textures/entity/shade.png");
	
	public RenderShade(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelShade(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityShade entitylivingbaseIn, float partialTickTime) {
		this.scaleShade(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleShade(EntityShade par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityShade entity) {
		return SHADE_TEXTURES;
	}
}