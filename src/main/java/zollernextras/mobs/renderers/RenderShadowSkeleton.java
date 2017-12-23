package zollernextras.mobs.renderers;

import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollernextras.lib.ZollernModInfo;
import zollernextras.mobs.entities.EntityShadowSkeleton;
import zollernextras.mobs.models.ModelShadowSkeleton;

@SideOnly(Side.CLIENT)
public class RenderShadowSkeleton extends RenderLiving<EntityShadowSkeleton> {
	
	private static final ResourceLocation SHADOW_SKELETON_TEXTURES = new ResourceLocation(
			ZollernModInfo.modId + ":textures/entity/shadowskeleton.png");
	
	private static final float f6 = 1.4F;
	
	public RenderShadowSkeleton(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelShadowSkeleton(), 0.5F);
		this.addLayer(new LayerHeldItem(this));
		this.addLayer(new LayerBipedArmor(this) {
			@Override
			protected void initArmor() {
				this.modelLeggings = new ModelSkeleton(0.5F, true);
				this.modelArmor = new ModelSkeleton(1.0F, true);
			}
		});
	}
	
	@Override
	protected void preRenderCallback(EntityShadowSkeleton entitylivingbaseIn,
			float partialTickTime) {
		this.scaleShadowSkeleton(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleShadowSkeleton(
			EntityShadowSkeleton par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.09375F, 0.1875F, 0.0F);
	}
	
	/**
	 * Gets an RGBA int color multiplier to apply.
	 */
	// @Override
	// protected int getColorMultiplier(EntityShadowSkeleton entitylivingbaseIn,
	// float lightBrightness, float partialTickTime) {
	// return 0x0000ff;
	// }
	
	@Override
	protected ResourceLocation getEntityTexture(EntityShadowSkeleton entity) {
		return SHADOW_SKELETON_TEXTURES;
	}
}