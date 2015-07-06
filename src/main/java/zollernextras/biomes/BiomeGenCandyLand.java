package zollernextras.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.BlockList;

public class BiomeGenCandyLand extends BiomeGenBase {
	public BiomeGenCandyLand(int par1) {
		super(par1);
		waterColorMultiplier = 0xf4a460;
		setColor(BiomeList.biomeColor);
		setBiomeName("Candy Land");
		setEnableSnow();
		setHeight(height_LowPlains);
		theBiomeDecorator.generateLakes = false;
		heightVariation = 1.6F;
		topBlock = BlockList.candyCubePink;
		fillerBlock = BlockList.candyCubeWhite;
		explorationBiomesList.add(this);
		createMutation();
	}
}