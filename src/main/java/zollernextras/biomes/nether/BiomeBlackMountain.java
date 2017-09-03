package zollernextras.biomes.nether;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import zollernextras.dimensions.DimensionRegistry;

public class BiomeBlackMountain extends ZollernNetherBiome {
	
	public BiomeBlackMountain() {
		super(new Biome.BiomeProperties("Black Mountains"), "black_mountains");
		this.setBlocks(Blocks.OBSIDIAN);
		this.setBiomeWeight(5);
		DimensionRegistry.addNetherBiome(this, this.getBiomeWeight());
	}
	
}