package zollernextras.dimensions.providers.world;

import javax.annotation.Nullable;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.dimensions.providers.biome.BiomeUpsideDownProvider;
import zollernextras.dimensions.providers.chunk.ChunkProviderUpsideDown;

public class WorldProviderUpsideDown extends WorldProviderHell {
	
	@Override
	public void init() {
		this.biomeProvider = new BiomeUpsideDownProvider(this.world);
		this.doesWaterVaporize = true;
		this.hasNoSky = false;
		this.resetRainAndThunder();
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderUpsideDown(world);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int chunkX, int chunkZ) {
		return true;
	}
	
	@Override
	public DimensionType getDimensionType() {
		return DimensionType.NETHER;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		return new Vec3d(0.0D, 0.1D, 0.0D);
	}
	
	@Override
	protected void generateLightBrightnessTable() {
		float f = 0.1F;
		
		for (int i = 0; i <= 15; ++i) {
			float f1 = 1.0F - i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F)
					* 0.9F + 0.1F;
		}
	}
	
	@Override
	@Nullable
	public BlockPos getSpawnCoordinate() {
		return new BlockPos(0, 128, 0);
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 64;
	}
	
	@Override
	public String getWelcomeMessage() {
		return "Entering the Upside-Down...";
	}
	
	@Override
	public String getDepartMessage() {
		return "Leaving the Upside-Down...";
	}
	
	@Override
	public double getMovementFactor() {
		return 16.0D;
	}
	
	@Override
	public void onPlayerAdded(EntityPlayerMP player) {
		
	}
}