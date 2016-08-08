package zollernextras.dimension.upsidedown.providers;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlCapsChecker;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IRenderHandler;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;
import zollernextras.lib.ZollernModInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SkyProviderUpsideDown extends IRenderHandler {
	
	private static final ResourceLocation locationUpsideDownTexture = new ResourceLocation(
			ZollernModInfo.MODID, "textures/environment/upsidedown_sky.png");
	public List tileEntities = new ArrayList();
	private WorldClient theWorld;
	/** The RenderEngine instance used by RenderGlobal */
	private final TextureManager renderEngine;
	private List worldRenderersToUpdate = new ArrayList();
	private WorldRenderer[] sortedWorldRenderers;
	private WorldRenderer[] worldRenderers;
	private int renderChunksWide;
	private int renderChunksTall;
	private int renderChunksDeep;
	/** OpenGL render lists base */
	private int glRenderListBase;
	
	/** A reference to the Minecraft object. */
	private Minecraft mc;
	
	/** OpenGL occlusion query base */
	private IntBuffer glOcclusionQueryBase;
	
	/** Is occlusion testing enabled */
	private boolean occlusionEnabled;
	
	/** The star GL Call list */
	private int starGLCallList;
	/** OpenGL sky list */
	private int glSkyList;
	/** OpenGL sky list 2 */
	private int glSkyList2;
	
	private boolean displayListEntitiesDirty;
	private int displayListEntities;
	
	/** Occlusion query result */
	IntBuffer occlusionResult = GLAllocation.createDirectIntBuffer(64);
	
	public SkyProviderUpsideDown(Minecraft p_i1249_1_) {
		this.mc = p_i1249_1_;
		this.renderEngine = p_i1249_1_.getTextureManager();
		byte b0 = 34;
		byte b1 = 16;
		this.glRenderListBase = GLAllocation.generateDisplayLists(b0 * b0 * b1
				* 3);
		this.displayListEntitiesDirty = false;
		this.displayListEntities = GLAllocation.generateDisplayLists(1);
		this.occlusionEnabled = OpenGlCapsChecker.checkARBOcclusion();
		
		if (this.occlusionEnabled) {
			this.occlusionResult.clear();
			this.glOcclusionQueryBase = GLAllocation.createDirectIntBuffer(b0
					* b0 * b1);
			this.glOcclusionQueryBase.clear();
			this.glOcclusionQueryBase.position(0);
			this.glOcclusionQueryBase.limit(b0 * b0 * b1);
			ARBOcclusionQuery.glGenQueriesARB(this.glOcclusionQueryBase);
		}
		
		this.starGLCallList = GLAllocation.generateDisplayLists(3);
		GL11.glPushMatrix();
		GL11.glNewList(this.starGLCallList, GL11.GL_COMPILE);
		this.renderStars();
		GL11.glEndList();
		GL11.glPopMatrix();
		Tessellator tessellator = Tessellator.instance;
		this.glSkyList = this.starGLCallList + 1;
		GL11.glNewList(this.glSkyList, GL11.GL_COMPILE);
		byte b2 = 64;
		int i = 256 / b2 + 2;
		float f = 16.0F;
		int j;
		int k;
		
		for (j = -b2 * i; j <= b2 * i; j += b2) {
			for (k = -b2 * i; k <= b2 * i; k += b2) {
				tessellator.startDrawingQuads();
				tessellator.addVertex(j + 0, f, k + 0);
				tessellator.addVertex(j + b2, f, k + 0);
				tessellator.addVertex(j + b2, f, k + b2);
				tessellator.addVertex(j + 0, f, k + b2);
				tessellator.draw();
			}
		}
		
		GL11.glEndList();
		this.glSkyList2 = this.starGLCallList + 2;
		GL11.glNewList(this.glSkyList2, GL11.GL_COMPILE);
		f = -16.0F;
		tessellator.startDrawingQuads();
		
		for (j = -b2 * i; j <= b2 * i; j += b2) {
			for (k = -b2 * i; k <= b2 * i; k += b2) {
				tessellator.addVertex(j + b2, f, k + 0);
				tessellator.addVertex(j + 0, f, k + 0);
				tessellator.addVertex(j + 0, f, k + b2);
				tessellator.addVertex(j + b2, f, k + b2);
			}
		}
		
		tessellator.draw();
		GL11.glEndList();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void render(float partialTicks, WorldClient world, Minecraft mc) {
		this.renderSky(partialTicks);
	}
	
	public void renderStars() {
		
	}
	
	public void renderSky(float p_72714_1_) {
		IRenderHandler skyProvider = null;
		
		GL11.glDisable(GL11.GL_FOG);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		RenderHelper.disableStandardItemLighting();
		GL11.glDepthMask(false);
		this.renderEngine.bindTexture(locationUpsideDownTexture);
		Tessellator tessellator = Tessellator.instance;
		
		for (int i = 0; i < 6; ++i) {
			GL11.glPushMatrix();
			
			if (i == 1) {
				GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			}
			
			if (i == 2) {
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
			}
			
			if (i == 3) {
				GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
			}
			
			if (i == 4) {
				GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
			}
			
			if (i == 5) {
				GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
			}
			
			tessellator.startDrawingQuads();
			tessellator.setColorOpaque_I(2631720);
			tessellator.addVertexWithUV(-100.0D, -100.0D, -100.0D, 0.0D, 0.0D);
			tessellator.addVertexWithUV(-100.0D, -100.0D, 100.0D, 0.0D, 16.0D);
			tessellator.addVertexWithUV(100.0D, -100.0D, 100.0D, 16.0D, 16.0D);
			tessellator.addVertexWithUV(100.0D, -100.0D, -100.0D, 16.0D, 0.0D);
			tessellator.draw();
			GL11.glPopMatrix();
		}
		
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
	}
	
}