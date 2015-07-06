package zollernextras.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenIceMountains extends BiomeGenBase {
	
	public BiomeGenIceMountains(int id) {
		super(id);
		this.waterColorMultiplier = 0x0099ff;
		this.color = BiomeList.biomeColor;
		this.temperature = 0F;
		this.rainfall = 0.5F;
		this.topBlock = Block.getBlockById(79);
		this.fillerBlock = Block.getBlockById(79);
		this.setHeight(height_HighPlateaus);
		this.setBiomeName("Ice Mountains");
		this.setEnableSnow();
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk = -999;
		this.theBiomeDecorator.sandPerChunk2 = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.theBiomeDecorator.flowersPerChunk = -999;
	}
}