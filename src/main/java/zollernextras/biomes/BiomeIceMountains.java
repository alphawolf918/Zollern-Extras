package zollernextras.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import zollernextras.api.biome.ZollernBiome;

public class BiomeIceMountains extends ZollernBiome {
	
	public BiomeIceMountains(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(0.0F);
		this.setTempCategory(TempCategory.COLD);
		this.setBlocks(Blocks.ICE, Blocks.PACKED_ICE);
		this.setEnableSnow(true);
		this.setNoRain(props);
		this.setWaterColor(0x0099ff);
		this.theBiomeDecorator.generateLakes = false;
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