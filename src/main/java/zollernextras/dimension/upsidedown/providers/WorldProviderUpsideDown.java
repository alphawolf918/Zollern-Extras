package zollernextras.dimension.upsidedown.providers;

import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import zollernextras.biomes.BiomeList;
import zollernextras.dimension.DimensionLoader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderUpsideDown extends WorldProvider {
	
	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeList.upsideDown,
				0.0F);
		this.dimensionId = DimensionLoader.getDimID();
		this.hasNoSky = true;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean getWorldHasVoidParticles() {
		return false;
	}
	
	@Override
	public float getStarBrightness(float par1) {
		return 0.1F;
	}
	
	public int getSkyColorByTemp(float f) {
		return 0x000;
	}
	
	@Override
	public float calculateCelestialAngle(long p_76563_1_, float p_76563_3_) {
		return 0.4F;
	}
	
	@Override
	protected void generateLightBrightnessTable() {
		float f = 0.2F;
		
		for (int i = 0; i <= 15; ++i) {
			float f1 = 1.0F - i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F)
					* (1.0F - f) + f;
		}
	}
	
	@Override
	public String getWelcomeMessage() {
		return "Entering Upside-Down..";
	}
	
	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderUpsideDown(worldObj, worldObj.getSeed(), true);
	}
	
	@Override
	public String getDepartMessage() {
		return "Leaving Upside-Down..";
	}
	
	@Override
	public double getHorizon() {
		return 0.0D;
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public Vec3 getFogColor(float f, float f1) {
		float f3 = 0.0F;
		float f4 = 0.0F;
		float f5 = 0.0F;
		return Vec3.createVectorHelper(f3, f4, f5);
	}
	
	@Override
	public boolean isSkyColored() {
		return false;
	}
	
	@Override
	public double getMovementFactor() {
		if (this instanceof WorldProviderUpsideDown) {
			return 5.0;
		}
		return 1.0;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}
	
	@Override
	public String getDimensionName() {
		return "Upside-Down";
	}
	
	// @Override
	// @SideOnly(Side.CLIENT)
	// public IRenderHandler getSkyRenderer() {
	// return new SkyProviderUpsideDown(ZollernExtrasMod.proxy.getMinecraft());
	// }
	
	@Override
	public boolean canDoLightning(Chunk chunk) {
		return false;
	}
	
	@Override
	public void resetRainAndThunder() {
		worldObj.getWorldInfo().setRainTime(0);
		worldObj.getWorldInfo().setRaining(false);
		worldObj.getWorldInfo().setThunderTime(0);
		worldObj.getWorldInfo().setThundering(false);
	}
	
}