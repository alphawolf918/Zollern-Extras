package zollernextras.dimensions.providers.chunk.layer;

import java.util.List;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.BiomeManager;
import zollernextras.dimensions.DimensionRegistry;

public abstract class ZollernGenUDLayer extends GenLayer {
	
	public ZollernGenUDLayer(long seed) {
		super(seed);
	}
	
	public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType type) {
		int biomeSize = type == WorldType.LARGE_BIOMES ? 6 : 4;
		biomeSize = getModdedBiomeSize(type, biomeSize);
		
		GenLayer genLayer = new ZollernGenUDBiome(1L);
		genLayer = new GenLayerZoom(2001L, genLayer);
		genLayer = new GenLayerZoom(2002L, genLayer);
		genLayer = new GenLayerZoom(1000L, genLayer);
		genLayer = new GenLayerZoom(1001L, genLayer);
		genLayer = new GenLayerZoom(1002L, genLayer);
		GenLayer genLayerVoronoiZoom = new GenLayerVoronoiZoom(10L, genLayer);
		
		genLayer.initWorldGenSeed(seed);
		genLayerVoronoiZoom.initWorldGenSeed(seed);
		
		return new GenLayer[] { genLayer, genLayerVoronoiZoom };
	}
	
	@Override
	public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
		int[] biomeIds = IntCache.getIntCache(areaWidth * areaHeight);
		
		for (int i = 0; i < areaHeight; ++i) {
			for (int j = 0; j < areaWidth; ++j) {
				initChunkSeed(j + areaX, i + areaY);
				biomeIds[j + i * areaWidth] = Biome
						.getIdForBiome(getWeightedBiomeEntry(DimensionRegistry
								.getUpsideDownBiomeEntries()).biome);
			}
		}
		
		return biomeIds;
	}
	
	private BiomeManager.BiomeEntry getWeightedBiomeEntry(List<BiomeManager.BiomeEntry> biomeEntries) {
		return WeightedRandom.getRandomItem(biomeEntries,
				nextInt(WeightedRandom.getTotalWeight(biomeEntries)));
	}
}