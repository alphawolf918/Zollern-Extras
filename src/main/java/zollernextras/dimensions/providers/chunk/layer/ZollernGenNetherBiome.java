package zollernextras.dimensions.providers.chunk.layer;

import java.util.Random;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.IntCache;
import zollernextras.util.ZollernUtils;

public class ZollernGenNetherBiome extends ZollernGenLayer {
	
	Biome mainBiome = null;
	
	public ZollernGenNetherBiome(long seed) {
		super(seed);
	}
	
	@Override
	public int[] getInts(int areaX, int areaZ, int areaWidth, int areaHeight) {
		int[] outputs = IntCache.getIntCache(areaWidth * areaHeight);
		
		for (int z = 0; z < areaHeight; z++) {
			for (int x = 0; x < areaWidth; x++) {
				initChunkSeed(x + areaX, z + areaZ);
				Biome currentBiome = (mainBiome == null) ? ZollernUtils
						.getRandomBiome() : mainBiome;
				Biome nextBiome = null;
				if (nextBiome == null) {
					Random rand = new Random();
					int randInt = rand.nextInt(200);
					if (randInt <= 5) {
						nextBiome = ZollernUtils.getRandomBiome();
					} else {
						nextBiome = currentBiome;
					}
					mainBiome = nextBiome;
				}
				currentBiome = (mainBiome == null) ? ZollernUtils
						.getRandomBiome() : mainBiome;
				outputs[x + z * areaWidth] = Biome.getIdForBiome(currentBiome);
			}
		}
		
		return outputs;
	}
	
}