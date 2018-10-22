package zollernextras.biomes;

import net.minecraft.world.biome.Biome;
import zollernextras.api.biome.ZollernBiome;
import zollernextras.blocks.ZollernBlocks;

public class BiomeRedshroomField extends ZollernBiome {
	
	public BiomeRedshroomField(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(5.2F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setBlocks(ZollernBlocks.redshroomBlock, ZollernBlocks.redshroomStem);
	}
	
}