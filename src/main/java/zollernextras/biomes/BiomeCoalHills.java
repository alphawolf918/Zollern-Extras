package zollernextras.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import zollernextras.api.biome.ZollernBiome;

public class BiomeCoalHills extends ZollernBiome {
	
	public BiomeCoalHills(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(8.2F);
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.05F);
		this.setWaterColor(0xaadd00);
		this.setNoRain(props);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setBlocks(Blocks.COAL_BLOCK, Blocks.COAL_ORE);
	}
	
}