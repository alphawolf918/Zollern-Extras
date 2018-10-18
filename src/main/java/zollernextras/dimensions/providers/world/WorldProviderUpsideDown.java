package zollernextras.dimensions.providers.world;

import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.dimensions.DimensionRegistry;
import zollernextras.dimensions.providers.biome.BiomeUpsideDownProvider;
import zollernextras.dimensions.providers.chunk.ChunkProviderUpsideDown;

public class WorldProviderUpsideDown extends WorldProvider {
	
	@Override
	public void init() {
		this.biomeProvider = new BiomeUpsideDownProvider(this.world);
		this.doesWaterVaporize = true;
		this.hasNoSky = true;
		this.resetRainAndThunder();
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderUpsideDown(world);
	}
	
	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		return 0.5F;
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z) {
		return true;
	}
	
	@Override
	public WorldBorder createWorldBorder() {
		return new WorldBorder() {
			@Override
			public double getCenterX() {
				return super.getCenterX() / 8.0D;
			}
			
			@Override
			public double getCenterZ() {
				return super.getCenterZ() / 8.0D;
			}
		};
	}
	
	@Override
	public DimensionType getDimensionType() {
		return DimensionRegistry.UPSIDE_DOWN;
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
		float f = MathHelper.cos(p_76562_1_ * ((float) Math.PI * 2F)) * 2.0F + 0.5F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		float f1 = 0.0F;
		float f2 = 1.0F;
		float f3 = 0.0F;
		f1 = f1 * (f * 0.94F + 0.06F);
		f2 = f2 * (f * 0.94F + 0.06F);
		f3 = f3 * (f * 0.91F + 0.09F);
		return new Vec3d(f1, f2, f3);
	}
	
	// @Override
	// @SideOnly(Side.CLIENT)
	// public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
	// return new Vec3d(0.0D, 0.1D, 0.0D);
	// }
	
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
		return new BlockPos(0, 32, 0);
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 31;
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
	
	// @Override
	// public void onPlayerAdded(EntityPlayerMP player) {
	// World world = player.getEntityWorld();
	// MinecraftServer mcServer = world.getMinecraftServer();
	// ITextComponent strMessage = new TextComponentString(
	// player.getDisplayNameString() + " has entered the Upside-Down.");
	// PlayerList playerList = mcServer.getPlayerList();
	// playerList.sendMessage(strMessage);
	// }
}