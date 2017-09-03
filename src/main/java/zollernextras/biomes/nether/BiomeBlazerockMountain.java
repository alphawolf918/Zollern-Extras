package zollernextras.biomes.nether;

import net.minecraft.world.biome.Biome;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.dimensions.DimensionRegistry;

public class BiomeBlazerockMountain extends ZollernNetherBiome {
	
	public BiomeBlazerockMountain() {
		super(new Biome.BiomeProperties("Blazerock Mountain"),
				"blazerock_mountain");
		this.setBlocks(ZollernBlocks.blazeRock);
		this.setBiomeWeight(22);
		DimensionRegistry.addNetherBiome(this, this.getBiomeWeight());
	}
	
}