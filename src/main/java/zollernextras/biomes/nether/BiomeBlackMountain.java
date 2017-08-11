package zollernextras.biomes.nether;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import zollernextras.biomes.ZollernNetherBiome;
import zollernextras.dimensions.HellRegistry;

public class BiomeBlackMountain extends ZollernNetherBiome {
	
	public BiomeBlackMountain() {
		super(new Biome.BiomeProperties("Black Mountains"), "black_mountains");
		this.setBlocks(Blocks.OBSIDIAN);
		this.setBiomeWeight(5);
		HellRegistry.addBiome(this, this.getBiomeWeight());
	}
	
}