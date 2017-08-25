package zollernextras.biomes.nether;

import net.minecraft.world.biome.Biome;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.dimensions.HellRegistry;

public class BiomeBlazerockMountain extends ZollernNetherBiome {
	
	public BiomeBlazerockMountain() {
		super(new Biome.BiomeProperties("Blazerock Mountain"),
				"blazerock_mountain");
		this.setBlocks(ZollernBlocks.blazeRock);
		this.setBiomeWeight(22);
		HellRegistry.addBiome(this, this.getBiomeWeight());
	}
	
}