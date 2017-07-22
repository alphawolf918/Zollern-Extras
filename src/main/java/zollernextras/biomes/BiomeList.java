package zollernextras.biomes;

import net.minecraft.world.biome.Biome;
import zollernextras.config.ZEConfig;

public class BiomeList {
	
	public static int biomeColor = 1204859;
	
	public static Biome biomeMinersLand = new BiomeMinersLand(
			new Biome.BiomeProperties("Miner's Land"));
	
	public static void init() {
		Biome.registerBiome(ZEConfig.biomeMinersLandID, "miners_land",
				biomeMinersLand);
		
	}
	
}