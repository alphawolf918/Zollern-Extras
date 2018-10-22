package zollernextras.biomes;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import zollernextras.api.biome.ZollernBiome;

public class BiomeSlimeLands extends ZollernBiome {
	
	public BiomeSlimeLands(Biome.BiomeProperties props) {
		super(props);
		props.setTemperature(6.2F);
		props.setBaseHeight(1.0F);
		props.setHeightVariation(0.05F);
		this.clearAllSpawning();
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 15, 1, 3));
		this.setTempCategory(TempCategory.WARM);
		this.setBlocks(Blocks.SLIME_BLOCK);
	}
	
}