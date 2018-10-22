package zollernextras.biomes.nether;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import zollernextras.dimensions.DimensionRegistry;

public class BiomeNetherMinersLand extends ZollernNetherBiome {
	
	public BiomeNetherMinersLand() {
		super(new Biome.BiomeProperties("Nether Miner's Land"), "nether_miners_land");
		this.setBlocks(Blocks.NETHERRACK);
		this.setBiomeWeight(8);
		DimensionRegistry.addNetherBiome(this, this.getBiomeWeight());
	}
	
}