package zollernextras.dimensions.providers.chunk.layer;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerFuzzyZoom;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class ZollernGenLayer extends GenLayer {
	
	public ZollernGenLayer(long seed) {
		super(seed);
	}
	
	public static GenLayer[] initializeAllBiomeGenerators(long seed,
			WorldType type) {
		int biomeSize = type == WorldType.LARGE_BIOMES ? 16 : 14;
		biomeSize = getModdedBiomeSize(type, biomeSize);
		
		GenLayer genLayer = new ZollernGenNetherBiome(1L);
		genLayer = new GenLayerFuzzyZoom(1000L, genLayer);
		genLayer = GenLayerZoom.magnify(1000L, genLayer, biomeSize);
		genLayer = new GenLayerSmooth(1000L, genLayer);
		GenLayer genLayerVoronoiZoom = new GenLayerVoronoiZoom(10L, genLayer);
		
		genLayer.initWorldGenSeed(seed);
		genLayerVoronoiZoom.initWorldGenSeed(seed);
		
		return new GenLayer[] { genLayer, genLayerVoronoiZoom };
	}
	
	@Override
	public abstract int[] getInts(int areaX, int areaZ, int areaWidth,
			int areaHeight);
	
	@Override
	public int nextInt(int i) {
		return super.nextInt(i);
	}
	
}