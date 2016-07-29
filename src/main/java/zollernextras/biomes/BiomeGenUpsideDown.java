package zollernextras.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.ZollernBlocks;

public class BiomeGenUpsideDown extends BiomeGenBase {
	
	public BiomeGenUpsideDown(int par1) {
		super(par1);
		waterColorMultiplier = 0x000;
		setColor(BiomeList.biomeColor);
		this.theBiomeDecorator.generateLakes = false;
		setDisableRain();
		setBiomeName("Upside-Down");
		temperature = 1F;
		setHeight(BiomeGenBase.height_HighPlateaus);
		topBlock = ZollernBlocks.upsideDownSurfaceRock;
		fillerBlock = ZollernBlocks.upsideDownRock;
	}
}