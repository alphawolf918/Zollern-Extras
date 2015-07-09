package zollernextras.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiBiomeType extends Gui {
	
	private Minecraft mc;
	protected FontRenderer fontRendererObj;
	public EntityPlayer player;
	int i3;
	int j3;
	int k3;
	
	public GuiBiomeType(Minecraft mc) {
		super();
		this.mc = mc;
		this.fontRendererObj = mc.fontRenderer;
	}
	
	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}
		ScaledResolution scaledresolution = new ScaledResolution(this.mc,
				this.mc.displayWidth, this.mc.displayHeight);
		int k = scaledresolution.getScaledWidth();
		int l = scaledresolution.getScaledHeight();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.enableGUIStandardItemLighting();
		i3 = 14737632;
		int i4 = MathHelper
				.floor_double(this.mc.thePlayer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		EntityPlayer player = this.mc.thePlayer;
		j3 = MathHelper.floor_double(player.posX);
		k3 = MathHelper.floor_double(player.posY);
		int l3 = MathHelper.floor_double(player.posZ);
		if (this.mc.theWorld != null
				&& this.mc.theWorld.blockExists(j3, k3, l3)) {
			Chunk chunk = this.mc.theWorld.getChunkFromBlockCoords(j3, l3);
			int yPos = 8;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			String biomeName = chunk.getBiomeGenForWorldCoords(j3 & 15,
					l3 & 15, this.mc.theWorld.getWorldChunkManager()).biomeName;
			String s = "Biome: " + biomeName;
			fontRendererObj.drawString(s, 2, 96, i3);
			fontRendererObj.drawString(s, 26, yPos - 96 + 4, i3);
		}
	}
}