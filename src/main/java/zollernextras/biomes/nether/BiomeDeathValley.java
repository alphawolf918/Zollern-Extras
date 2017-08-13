package zollernextras.biomes.nether;

import net.minecraft.world.biome.Biome;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.dimensions.HellRegistry;

public class BiomeDeathValley extends ZollernNetherBiome {
	
	public BiomeDeathValley() {
		super(new Biome.BiomeProperties("Death Valley"), "death_valley");
		this.setBlocks(ZollernBlocks.netherDirt);
		this.setBiomeWeight(21);
		HellRegistry.addBiome(this, this.getBiomeWeight());
	}
	
}