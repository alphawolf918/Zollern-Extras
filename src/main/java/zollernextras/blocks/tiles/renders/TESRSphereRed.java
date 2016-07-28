package zollernextras.blocks.tiles.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import zollernextras.lib.ZollernModInfo;

public class TESRSphereRed extends TileEntitySpecialRenderer {
	
	ResourceLocation candy = new ResourceLocation(ZollernModInfo.MODID,
			"textures/blocks/candycube_white.png");
	IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(
			ZollernModInfo.MODID, "obj/ball.obj"));
	float scalex = 0.45F;
	float scaley = 0.30F;
	float scalez = 1.4F;
	float offset = 0.0F;
	float offseth = 0.00F;
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y,
			double z, float scale) {
		bindTexture(candy);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + offseth,
				(float) z + 0.5F);
		GL11.glScaled(scalex, scaley, scalez);
		
		model.renderAll();
		GL11.glPopMatrix();
	}
}