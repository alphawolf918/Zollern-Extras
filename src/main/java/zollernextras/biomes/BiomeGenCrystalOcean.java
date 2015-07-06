package zollernextras.biomes;

import net.minecraft.world.biome.BiomeGenOcean;

public class BiomeGenCrystalOcean extends BiomeGenOcean {
	public BiomeGenCrystalOcean(int par1) {
		super(par1);
		this.setBiomeName("Crystal Ocean");
		this.setColor(BiomeList.biomeColor);
		this.setHeight(height_DeepOceans);
		this.waterColorMultiplier = 0x00008b;
	}
}