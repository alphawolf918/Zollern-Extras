package zollernextras.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenNetherOre extends WorldGenerator {
	
	private Block _minableBlockId;
	private int _numberOfBlocks;
	
	public WorldGenNetherOre(Block blockId, int numBlocks) {
		_minableBlockId = blockId;
		_numberOfBlocks = numBlocks;
	}
	
	@Override
	public boolean generate(World world, Random random, int chunkX, int y,
			int chunkZ) {
		float f = random.nextFloat() * (float) Math.PI;
		double d = chunkX + 8 + MathHelper.sin(f) * _numberOfBlocks / 8F;
		double d1 = chunkX + 8 - MathHelper.sin(f) * _numberOfBlocks / 8F;
		double d2 = chunkZ + 8 + MathHelper.cos(f) * _numberOfBlocks / 8F;
		double d3 = chunkZ + 8 - MathHelper.cos(f) * _numberOfBlocks / 8F;
		double d4 = y + random.nextInt(3) - 2;
		double d5 = y + random.nextInt(3) - 2;
		for (int blockNum = 0; blockNum <= _numberOfBlocks; blockNum++) {
			double d6 = d + (d1 - d) * blockNum / _numberOfBlocks;
			double d7 = d4 + (d5 - d4) * blockNum / _numberOfBlocks;
			double d8 = d2 + (d3 - d2) * blockNum / _numberOfBlocks;
			double d9 = random.nextDouble() * _numberOfBlocks / 16D;
			double d10 = (MathHelper
					.sin(blockNum * 3.141593F / _numberOfBlocks) + 1.0F)
					* d9
					+ 1.0D;
			double d11 = (MathHelper
					.sin(blockNum * 3.141593F / _numberOfBlocks) + 1.0F)
					* d9
					+ 1.0D;
			int xStart = MathHelper.floor_double(d6 - d10 / 2D);
			int yStart = MathHelper.floor_double(d7 - d11 / 2D);
			int zStart = MathHelper.floor_double(d8 - d10 / 2D);
			int xStop = MathHelper.floor_double(d6 + d10 / 2D);
			int yStop = MathHelper.floor_double(d7 + d11 / 2D);
			int zStop = MathHelper.floor_double(d8 + d10 / 2D);
			for (int blockX = xStart; blockX <= xStop; blockX++) {
				double d12 = (blockX + 0.5D - d6) / (d10 / 2D);
				if (d12 * d12 >= 1.0D) {
					continue;
				}
				for (int blockY = yStart; blockY <= yStop; blockY++) {
					double d13 = (blockY + 0.5D - d7) / (d11 / 2D);
					if (d12 * d12 + d13 * d13 >= 1.0D) {
						continue;
					}
					for (int blockZ = zStart; blockZ <= zStop; blockZ++) {
						double d14 = (blockZ + 0.5D - d8) / (d10 / 2D);
						if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D
								&& world.getBlock(blockX, blockY, blockZ) == Blocks.netherrack) {
							world.setBlock(blockX, blockY, blockZ,
									_minableBlockId);
						}
					}
				}
			}
		}
		return true;
	}
}