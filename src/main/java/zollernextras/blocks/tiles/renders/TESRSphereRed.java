package zollernextras.blocks.tiles.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import zollernextras.lib.Reference;

public class TESRSphereRed extends TileEntitySpecialRenderer {
	
	ResourceLocation candy = new ResourceLocation(Reference.MODID,
			"textures/blocks/candycube_red.png");
	IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(
			Reference.MODID, "obj/ball.obj"));
	float scalex = 0.80F;
	float scaley = 0.20F;
	float scalez = 0.60F;
	float offset = 0.0F;
	float offseth = 0.0F;
	
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