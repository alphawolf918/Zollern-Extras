package zollernextras.biomes.nether;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import zollernextras.dimensions.HellRegistry;
import zollernextras.worldgen.WorldGenNetherWart;

public class BiomeSoulDesert extends ZollernNetherBiome {
	
	public BiomeSoulDesert() {
		super(new Biome.BiomeProperties("Desert of Souls"), "soul_desert");
		this.setBlocks(Blocks.SOUL_SAND);
		this.setBiomeWeight(16);
		HellRegistry.addBiome(this, this.getBiomeWeight());
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		super.decorate(worldIn, rand, pos);
		if (net.minecraftforge.event.terraingen.TerrainGen
				.decorate(
						worldIn,
						rand,
						pos,
						net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SHROOM))
			if (rand.nextInt(1000) <= 25) {
				int i = rand.nextInt(16) + 8;
				int j = rand.nextInt(16) + 8;
				BlockPos blockpos = worldIn.getHeight(pos.add(i, 0, j)).up();
				(new WorldGenNetherWart()).generate(worldIn, rand, blockpos);
			}
		
	}
}