package zollernextras.blocks.tiles.renders;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import zollernextras.lib.ModInfo;

public class TESRZincIngotStack extends TileEntitySpecialRenderer {
	
	ResourceLocation zinc = new ResourceLocation(ModInfo.MODID,
			"textures/blocks/zincblock.png");
	IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(
			ModInfo.MODID, "obj/ingotstack.obj"));
	float scalex = 0.080F;
	float scaley = 0.20F;
	float scalez = 0.06F;
	float offset = 0.3F;
	float offseth = 0.07F;
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y,
			double z, float scale) {
		int meta = entity.getBlockMetadata();
		bindTexture(zinc);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + offseth,
				(float) z + 0.5F);
		if (meta >= 2)
			GL11.glTranslatef(0.0F, 0.0F, offset / 2);
		GL11.glScaled(scalex, scaley, scalez);
		
		model.renderAll();
		GL11.glPopMatrix();
		
		if (meta >= 2) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + offseth,
					(float) z + 0.5F);
			GL11.glTranslatef(0.0F, 0.0F, offset / -2);
			GL11.glScaled(scalex, scaley, scalez);
			model.renderAll();
			GL11.glPopMatrix();
		}
		
		if (meta >= 4) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + offseth,
					(float) z + 0.5F);
			GL11.glTranslatef((offset - 0.02F) / 2, 0.125F, 0.0F);
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glScaled(scalex, scaley, scalez);
			model.renderAll();
			GL11.glPopMatrix();
		}
		
		if (meta >= 6) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.5F, (float) y + offseth,
					(float) z + 0.5F);
			GL11.glTranslatef((offset - 0.02F) / -2, 0.125F, 0.0F);
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glScaled(scalex, scaley, scalez);
			model.renderAll();
			GL11.glPopMatrix();
		}
	}
}