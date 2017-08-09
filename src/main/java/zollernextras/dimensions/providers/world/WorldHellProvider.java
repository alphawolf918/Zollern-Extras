package zollernextras.dimensions.providers.world;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.dimensions.providers.biome.BiomeHellProvider;
import zollernextras.dimensions.providers.chunk.ChunkHellProvider;

public class WorldHellProvider extends WorldProviderHell {
	
	@Override
	public void init() {
		this.biomeProvider = new BiomeHellProvider(this.world);
		this.doesWaterVaporize = true;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkHellProvider(world);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int chunkX, int chunkZ) {
		return false;
	}
	
	@Override
	public DimensionType getDimensionType() {
		return DimensionType.NETHER;
	}
	
}