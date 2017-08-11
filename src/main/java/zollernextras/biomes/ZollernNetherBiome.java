package zollernextras.biomes;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import zollernextras.api.biome.ZollernBiome;
import zollernextras.dimensions.providers.biome.BiomeDecoratorNether;
import zollernextras.lib.ZollernModInfo;

public class ZollernNetherBiome extends ZollernBiome {
	
	protected static int biomeWeight = 10;
	
	public ZollernNetherBiome(Biome.BiomeProperties props, String name) {
		super(props);
		this.clearAllSpawning();
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(
				EntityGhast.class, 50, 4, 4));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(
				EntityPigZombie.class, 100, 4, 4));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(
				EntityMagmaCube.class, 2, 4, 4));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(
				EntityEnderman.class, 1, 4, 4));
		this.setBlocks(Blocks.NETHERRACK);
		this.setTempCategory(TempCategory.WARM);
		this.setNoRain(props);
		this.setSkyColor(0x8b008b);
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