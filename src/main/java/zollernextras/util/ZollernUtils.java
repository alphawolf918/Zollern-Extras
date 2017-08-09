package zollernextras.util;

import java.util.List;
import java.util.Random;
import net.minecraft.world.biome.Biome;
import zollernextras.biomes.ZollernNetherBiome;
import zollernextras.dimensions.HellRegistry;

public class ZollernUtils {
	
	private static Random rand = new Random();
	
	public static Biome getRandomBiome() {
		List<ZollernNetherBiome> biomeList = HellRegistry.getNetherBiomeList();
		int randInt = rand.nextInt(biomeList.size());
		
		Biome biomeToReturn = HellRegistry.getNetherBiome(randInt);
		for (ZollernNetherBiome b : biomeList) {
			int bw = b.getBiomeWeight();
			int randGen = rand.nextInt(200);
			if (randGen <= bw) {
				return b;
			}
		}
		return HellRegistry.getNetherBiome(randInt);
	}
}