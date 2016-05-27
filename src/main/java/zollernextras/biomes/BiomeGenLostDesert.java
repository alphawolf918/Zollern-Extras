package zollernextras.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import zollernextras.blocks.BlockList;

public class BiomeGenLostDesert extends BiomeGenBase {
	public BiomeGenLostDesert(int par1) {
		super(par1);
		this.temperature = 7F;
		this.setBiomeName("Lost Desert");
		this.setColor(BiomeList.biomeColor);
		this.setHeight(height_HighPlateaus);
		this.heightVariation = 1.5F;
		this.setDisableRain();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.topBlock = BlockList.wonderSand;
		this.fillerBlock = BlockList.wonderStone;
	}
}