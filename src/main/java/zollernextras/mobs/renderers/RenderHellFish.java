package zollernextras.mobs.renderers;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.lib.ZollernModInfo;
import zollernextras.mobs.entities.EntityHellFish;
import zollernextras.mobs.models.ModelHellFish;

@SideOnly(Side.CLIENT)
public class RenderHellFish extends RenderLiving<EntityHellFish> {
	
	private static final ResourceLocation HELLFISH_TEXTURES = new ResourceLocation(
			ZollernModInfo.modId + ":textures/entity/hellfish.png");
	
	public RenderHellFish(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelHellFish(), 0.3F);
	}
	
	@Override
	protected float getDeathMaxRotation(EntityHellFish entityLivingBaseIn) {
		return 180.0F;
	}
	
	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityHellFish entity) {
		return HELLFISH_TEXTURES;
	}
	
}