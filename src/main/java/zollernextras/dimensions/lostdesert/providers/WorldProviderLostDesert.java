package zollernextras.dimensions.lostdesert.providers;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import zollernextras.biomes.BiomeList;
import zollernextras.dimensions.Dimensions;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderLostDesert extends WorldProvider {
	
	private IRenderHandler skyRenderer = null;
	private IRenderHandler cloudRenderer = null;
	private IRenderHandler weatherRenderer = null;
	
	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeList.lostDesert,
				0.1F);
		this.dimensionId = Dimensions.dimId;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean getWorldHasVoidParticles() {
		return false;
	}
	
	@Override
	public float getStarBrightness(float par1) {
		return 8.0F;
	}
	
	public int getSkyColorByTemp(float f) {
		return 0xdb7561;
	}
	
	@Override
	public String getWelcomeMessage() {
		return "Entering desert..";
	}
	
	@Override
	// @SideOnly(Side.SERVER)
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderLostDesert(worldObj, worldObj.getSeed(), true);
	}
	
	@Override
	public String getDepartMessage() {
		return "Leaving desert..";
	}
	
	@Override
	public double getHorizon() {
		return 44.0D;
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}
	
	@Override
	public boolean canRespawnHere() {
		return true;
	}
	
	@Override
	public Vec3 getFogColor(float f, float f1) {
		float f2 = MathHelper.cos(1.4F) * 2.0F + 0.5F;
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		float f3 = 4.0F;
		float f4 = 2.0F;
		float f5 = 0.0F;
		f3 *= f2 * 0.94F + 0.09F;
		f4 *= f2 * 0.94F + 0.00F;
		f5 *= f2 * 0.91F + 0.09F;
		return Vec3.createVectorHelper(f3, f4, f5);
	}
	
	@Override
	public boolean isSkyColored() {
		return true;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	public String getDimensionName() {
		return "Lost Desert";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getSkyRenderer() {
		return this.skyRenderer;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void setSkyRenderer(IRenderHandler skyRenderer) {
		this.skyRenderer = skyRenderer;
	}
}