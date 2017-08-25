package zollernextras.mobs.renderers;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.lib.ZollernModInfo;
import zollernextras.mobs.entities.EntityDuck;
import zollernextras.mobs.models.ModelDuck;

@SideOnly(Side.CLIENT)
public class RenderDuck extends RenderLiving<EntityDuck> {
	
	private static final ResourceLocation DUCK_TEXTURES = new ResourceLocation(
			ZollernModInfo.modId + ":textures/entity/duck.png");
	
	public RenderDuck(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelDuck(), 0.3F);
	}
	
	@Override
	protected float getDeathMaxRotation(EntityDuck entityLivingBaseIn) {
		return 180.0F;
	}
	
	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityDuck entity) {
		return DUCK_TEXTURES;
	}
	
}