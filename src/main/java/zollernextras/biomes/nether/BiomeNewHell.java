package zollernextras.biomes.nether;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import zollernextras.dimensions.HellRegistry;

public class BiomeNewHell extends ZollernNetherBiome {
	
	public BiomeNewHell() {
		super(new Biome.BiomeProperties("Hell"), "new_hell");
		this.setBlocks(Blocks.NETHERRACK);
		this.setBiomeWeight(86);
		HellRegistry.addBiome(this, this.getBiomeWeight());
	}
	
}