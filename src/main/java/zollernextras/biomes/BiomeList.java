package zollernextras.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import zollernextras.config.ZEConfig;

public class BiomeList {
	
	public static int biomeColor = 1204859;
	
	public static Biome biomeMinersLand = new BiomeMinersLand(
			new Biome.BiomeProperties("Miner's Land"));
	
	public static Biome biomeUpsideDown = new BiomeUpsideDown(
			new Biome.BiomeProperties("Upside-Down"));
	
	public static void init() {
		addBiome(biomeMinersLand, ZEConfig.biomeMinersLandID, "Miner's Land",
				ZEConfig.biomeMinersLandSpawnRate, BiomeType.WARM);
		addBiome(biomeUpsideDown, ZEConfig.biomeUpsideDownID, "Upside-Down", 0,
				BiomeType.ICY);
	}
	
	public static void addBiome(Biome biome, int biomeID, String biomeName,
			int biomeWeight, BiomeType biomeType) {
		Biome.registerBiome(biomeID, biomeName, biome);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, biomeWeight));
		if (biomeWeight > 0) {
			BiomeManager.addStrongholdBiome(biome);
			BiomeManager.addSpawnBiome(biome);
			BiomeManager.addVillageBiome(biome, true);
		}
	}
	
}