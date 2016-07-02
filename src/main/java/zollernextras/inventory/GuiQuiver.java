package zollernextras.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import zollernextras.lib.ModInfo;

public class GuiQuiver extends GuiContainer {
	/**
	 * x and y size of the inventory window in pixels. Defined as float, passed
	 * as int These are used for drawing the player model.
	 */
	private float xSize_lo;
	private float ySize_lo;
	
	/**
	 * ResourceLocation takes 2 parameters: ModId, path to texture at the
	 * location: "src/minecraft/assets/modid/"
	 */
	private static final ResourceLocation iconLocation = new ResourceLocation(
			ModInfo.MODID + ":textures/gui/inventory_quiver.png");
	
	/** The inventory to render on screen */
	private final InventoryQuiver inventory;
	
	public GuiQuiver(EntityPlayer player, InventoryPlayer inv1,
			InventoryQuiver inv2) {
		super(new ContainerQuiver(player, inv1, inv2));
		this.inventory = inv2;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float f) {
		super.drawScreen(mouseX, mouseY, f);
		xSize_lo = mouseX;
		ySize_lo = mouseY;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		String s = inventory.hasCustomInventoryName() ? inventory
				.getInventoryName() : I18n.format(inventory.getInventoryName());
				fontRendererObj.drawString(s,
						xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 0, 4210752);
				fontRendererObj.drawString(I18n.format("container.inventory"), 26,
						ySize - 96 + 6, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mouseX,
			int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(iconLocation);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
		// utilize vanilla drawPlayerModel method:
		GuiInventory.func_147046_a(k + 51, l + 75, 30, k + 51 - xSize_lo, l
				+ 75 - 50 - ySize_lo, mc.thePlayer);
	}
}
