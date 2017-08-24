package zollernextras.biomes.nether;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import zollernextras.dimensions.HellRegistry;

public class BiomeSoulDesert extends ZollernNetherBiome {
	
	public BiomeSoulDesert() {
		super(new Biome.BiomeProperties("Desert of Souls"), "soul_desert");
		this.setBlocks(Blocks.SOUL_SAND);
		this.setBiomeWeight(16);
		HellRegistry.addBiome(this, this.getBiomeWeight());
	}
}