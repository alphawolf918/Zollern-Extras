package zollernextras.mobs.renderers;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollernextras.lib.ZollernModInfo;
import zollernextras.mobs.entities.EntityKrull;
import zollernextras.mobs.models.ModelKrull;

@SideOnly(Side.CLIENT)
public class RenderKrull extends RenderBiped<EntityKrull> {
	
	private static final float f6 = 1.4F;
	
	private static final ResourceLocation KRULL_TEXTURES = new ResourceLocation(
			ZollernModInfo.modId + ":textures/entity/krull.png");
	
	public RenderKrull(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelKrull(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityKrull entitylivingbaseIn, float partialTickTime) {
		this.scaleKrull(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleKrull(EntityKrull par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityKrull entity) {
		return KRULL_TEXTURES;
	}
}