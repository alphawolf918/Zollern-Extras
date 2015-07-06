package zollernextras.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenCoalHills extends BiomeGenBase {
	public BiomeGenCoalHills(int par1) {
		super(par1);
		this.waterColorMultiplier = 0xaa0022;
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Coal Hills");
		this.temperature = 8F;
		this.setHeight(height_MidPlains);
		this.topBlock = Block.getBlockById(173);
		this.fillerBlock = Block.getBlockById(16);
	}
}