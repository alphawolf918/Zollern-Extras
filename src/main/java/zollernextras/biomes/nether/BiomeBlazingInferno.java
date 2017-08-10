package zollernextras.biomes.nether;

import net.minecraft.world.biome.Biome;
import zollernextras.biomes.ZollernNetherBiome;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.dimensions.HellRegistry;

public class BiomeBlazingInferno extends ZollernNetherBiome {
	
	public BiomeBlazingInferno() {
		super(new Biome.BiomeProperties("Blazing Inferno"), "blazing_inferno");
		this.setBlocks(ZollernBlocks.blazeRock);
		this.setBiomeWeight(42);
		HellRegistry.addBiome(this, this.getBiomeWeight());
	}
	
}