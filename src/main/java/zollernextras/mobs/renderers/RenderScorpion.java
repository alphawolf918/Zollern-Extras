package zollernextras.mobs.renderers;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollernextras.lib.ZollernModInfo;
import zollernextras.mobs.entities.EntityScorpion;
import zollernextras.mobs.models.ModelScorpion;

@SideOnly(Side.CLIENT)
public class RenderScorpion extends RenderLiving<EntityScorpion> {
	
	private static final ResourceLocation SCORPION_TEXTURES = new ResourceLocation(
			ZollernModInfo.modId + ":textures/entity/Scorpion.png");
	
	private static final float f6 = 0.5F;
	
	public RenderScorpion(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelScorpion(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityScorpion entitylivingbaseIn, float partialTickTime) {
		this.scaleScorpion(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleScorpion(EntityScorpion par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityScorpion entity) {
		return SCORPION_TEXTURES;
	}
}