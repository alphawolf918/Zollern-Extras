package zollernextras.api.biome;

import net.minecraft.world.biome.Biome;

public abstract class ZollernBiome extends Biome {
	
	protected TempCategory tempBiomeCtg = (TempCategory.MEDIUM);
	
	public ZollernBiome(BiomeProperties properties) {
		super(properties);
	}
	
	public Biome setTempCategory(TempCategory tc) {
		this.tempBiomeCtg = tc;
		return this;
	}
	
	@Override
	public TempCategory getTempCategory() {
		return this.tempBiomeCtg;
	}
	
}