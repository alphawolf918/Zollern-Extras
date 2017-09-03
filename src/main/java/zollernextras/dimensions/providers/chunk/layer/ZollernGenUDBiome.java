package zollernextras.dimensions.providers.chunk.layer;

import java.util.List;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;
import zollernextras.dimensions.DimensionRegistry;

public class ZollernGenUDBiome extends ZollernGenUDLayer {
	
	public ZollernGenUDBiome(long seed) {
		super(seed);
	}
	
	@Override
	public int[] getInts(int areaX, int areaZ, int areaWidth, int areaHeight) {
		int[] outputs = IntCache.getIntCache(areaWidth * areaHeight);
		
		for (int z = 0; z < areaHeight; z++) {
			for (int x = 0; x < areaWidth; x++) {
				initChunkSeed(x + areaX, z + areaZ);
				
				outputs[x + z * areaWidth] = Biome
						.getIdForBiome(getWeightedBiomeEntry(DimensionRegistry
								.getUpsideDownBiomeEntries()).biome);
			}
		}
		
		return outputs;
	}
	
	private BiomeManager.BiomeEntry getWeightedBiomeEntry(
			List<BiomeManager.BiomeEntry> biomeEntries) {
		return WeightedRandom.getRandomItem(biomeEntries,
				nextInt(WeightedRandom.getTotalWeight(biomeEntries)));
	}
}