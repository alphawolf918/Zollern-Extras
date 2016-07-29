package zollernextras.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.ZollernBlocks;

public class BiomeGenBadLands extends BiomeGenBase {
	public BiomeGenBadLands(int par1) {
		super(par1);
		waterColorMultiplier = 0x000022;
		setColor(BiomeList.biomeColor);
		setDisableRain();
		setBiomeName("Bad Lands");
		temperature = 8F;
		setHeight(BiomeGenBase.height_LowHills);
		topBlock = ZollernBlocks.badStone;
		fillerBlock = ZollernBlocks.badStone;
	}
}