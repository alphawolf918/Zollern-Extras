package zollernextras.biomes.upsidedown;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import zollernextras.api.biome.ZollernBiome;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.dimensions.providers.biome.BiomeDecoratorUpsideDown;
import zollernextras.lib.ZollernModInfo;

public class ZollernUpsideDownBiome extends ZollernBiome {
	
	protected static int biomeWeight = 10;
	
	public ZollernUpsideDownBiome(Biome.BiomeProperties props, String name) {
		super(props);
		this.clearAllSpawning();
		this.setBlocks(ZollernBlocks.upsideDownSurfaceRock,
				ZollernBlocks.upsideDownSubRock);
		this.setTempCategory(TempCategory.COLD);
		this.setNoRain(props);
		this.setSkyColor(0x008b00);
		this.setRegistryName(ZollernModInfo.modId + ":" + name);
		props.setTemperature(0.2F);
	}
	
	public Biome setBiomeWeight(int param1Weight) {
		this.biomeWeight = param1Weight;
		return this;
	}
	
	public static int getBiomeWeight() {
		return biomeWeight;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorUpsideDown();
	}
}