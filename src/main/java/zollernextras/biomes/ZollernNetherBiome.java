package zollernextras.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import zollernextras.api.biome.ZollernBiome;
import zollernextras.dimensions.providers.biome.BiomeDecoratorNether;
import zollernextras.lib.ZollernModInfo;

public class ZollernNetherBiome extends ZollernBiome {
	
	protected static int biomeWeight = 5;
	
	public ZollernNetherBiome(Biome.BiomeProperties props, String name) {
		super(props);
		this.clearAllNonMonsterSpawning();
		this.setBlocks(Blocks.NETHERRACK);
		this.setTempCategory(TempCategory.WARM);
		this.setNoRain(props);
		this.setSkyColor(0xff0000);
		this.setRegistryName(ZollernModInfo.modId + ":" + name);
		props.setTemperature(10.0F);
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
		return new BiomeDecoratorNether();
	}
}