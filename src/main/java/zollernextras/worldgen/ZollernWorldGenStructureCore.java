package zollernextras.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class ZollernWorldGenStructureCore extends WorldGenerator {
	
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] {};
	}
	
	public boolean LocationIsValidSpawn(World world, int i, int j, int k) {
		int distanceToAir = 0;
		Block checkID = world.getBlock(i, j, k);
		
		while (checkID != Blocks.air) {
			distanceToAir++;
			checkID = world.getBlock(i, j + distanceToAir, k);
		}
		
		if (distanceToAir > 3) {
			return false;
		}
		j += distanceToAir - 1;
		
		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j + 1, k);
		Block blockIDBelow = world.getBlock(i, j - 1, k);
		for (Block x : GetValidSpawnBlocks()) {
			if (blockIDAbove != Blocks.air) {
				return false;
			}
			if (blockID == x) {
				return true;
			} else if (blockID == Blocks.stone && blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}
	
	public void setBlock(World world, int x, int y, int z, Block block,
			int metadata) {
		Block b1 = world.getBlock(x, y, z);
		
		if (b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z)) {
			world.setBlock(x, y, z, block, metadata, metadata);
		}
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		if (world.getBlock(i, j - 1, k) == Blocks.air) {
			return false;
		}
		return true;
	}
}