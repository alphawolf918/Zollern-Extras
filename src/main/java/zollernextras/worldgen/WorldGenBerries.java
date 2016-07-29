package zollernextras.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.blocks.ZollernBlocks;

public class WorldGenBerries extends WorldGenerator {
	
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] { Blocks.dirt, Blocks.grass, Blocks.sand,
				Blocks.gravel, ZollernBlocks.swampClay, ZollernBlocks.betterGrass };
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
			} else if (blockID == Blocks.snow && blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}
	
	public WorldGenBerries() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		// check that each corner is one of the valid spawn blocks
		if (!LocationIsValidSpawn(world, i, j, k)) {
			return false;
		}
		
		world.setBlock(i + 1, j + 0, k + 1, Blocks.farmland);
		world.setBlock(i + 1, j + 0, k + 1, Blocks.farmland);
		world.setBlock(i + 1, j + 0, k + 2, Blocks.farmland);
		world.setBlock(i + 1, j + 0, k + 3, Blocks.farmland);
		world.setBlock(i + 1, j + 0, k + 4, Blocks.farmland);
		world.setBlock(i + 1, j + 0, k + 5, Blocks.farmland);
		world.setBlock(i + 1, j + 0, k + 6, Blocks.farmland);
		world.setBlock(i + 1, j + 0, k + 7, Blocks.farmland);
		world.setBlock(i + 1, j + 0, k + 8, Blocks.farmland);
		world.setBlock(i + 1, j + 0, k + 9, Blocks.farmland);
		world.setBlock(i + 1, j + 0, k + 10, Blocks.farmland);
		world.setBlock(i + 2, j + 0, k + 1, Blocks.farmland);
		world.setBlock(i + 2, j + 0, k + 10, Blocks.farmland);
		world.setBlock(i + 2, j + 0, k + 2, Blocks.water);
		world.setBlock(i + 2, j + 0, k + 3, Blocks.water);
		world.setBlock(i + 2, j + 0, k + 4, Blocks.water);
		world.setBlock(i + 2, j + 0, k + 5, Blocks.water);
		world.setBlock(i + 2, j + 0, k + 6, Blocks.water);
		world.setBlock(i + 2, j + 0, k + 7, Blocks.water);
		world.setBlock(i + 2, j + 0, k + 8, Blocks.water);
		world.setBlock(i + 2, j + 0, k + 9, Blocks.water);
		world.setBlock(i + 2, j + 0, k + 10, Blocks.farmland);
		world.setBlock(i + 3, j + 0, k + 1, Blocks.farmland);
		world.setBlock(i + 3, j + 0, k + 2, Blocks.farmland);
		world.setBlock(i + 3, j + 0, k + 3, Blocks.farmland);
		world.setBlock(i + 3, j + 0, k + 4, Blocks.farmland);
		world.setBlock(i + 3, j + 0, k + 5, Blocks.farmland);
		world.setBlock(i + 3, j + 0, k + 6, Blocks.farmland);
		world.setBlock(i + 3, j + 0, k + 7, Blocks.farmland);
		world.setBlock(i + 3, j + 0, k + 8, Blocks.farmland);
		world.setBlock(i + 3, j + 0, k + 9, Blocks.farmland);
		world.setBlock(i + 3, j + 0, k + 10, Blocks.farmland);
		
		world.setBlock(i + 1, j + 1, k + 1, ZollernBlocks.grape);
		world.setBlock(i + 1, j + 1, k + 2, ZollernBlocks.blueberry);
		world.setBlock(i + 1, j + 1, k + 3, ZollernBlocks.blueberry);
		world.setBlock(i + 1, j + 1, k + 4, ZollernBlocks.strawberry);
		world.setBlock(i + 1, j + 1, k + 5, ZollernBlocks.blueberry);
		world.setBlock(i + 1, j + 1, k + 6, ZollernBlocks.grape);
		world.setBlock(i + 1, j + 1, k + 7, ZollernBlocks.blackberry);
		world.setBlock(i + 1, j + 1, k + 8, ZollernBlocks.blueberry);
		world.setBlock(i + 1, j + 1, k + 9, ZollernBlocks.strawberry);
		world.setBlock(i + 1, j + 1, k + 10, ZollernBlocks.blueberry);
		world.setBlock(i + 2, j + 1, k + 1, ZollernBlocks.grape);
		world.setBlock(i + 2, j + 1, k + 10, ZollernBlocks.blackberry);
		world.setBlock(i + 3, j + 1, k + 1, ZollernBlocks.blackberry);
		world.setBlock(i + 3, j + 1, k + 2, ZollernBlocks.blackberry);
		world.setBlock(i + 3, j + 1, k + 3, ZollernBlocks.blackberry);
		world.setBlock(i + 3, j + 1, k + 4, ZollernBlocks.blackberry);
		world.setBlock(i + 3, j + 1, k + 5, ZollernBlocks.blackberry);
		world.setBlock(i + 3, j + 1, k + 6, ZollernBlocks.blackberry);
		world.setBlock(i + 3, j + 1, k + 7, ZollernBlocks.blackberry);
		world.setBlock(i + 3, j + 1, k + 8, ZollernBlocks.blackberry);
		world.setBlock(i + 3, j + 1, k + 9, ZollernBlocks.blackberry);
		world.setBlock(i + 3, j + 1, k + 10, ZollernBlocks.strawberry);
		
		world.setBlock(i + 1, j - 1, k + 1, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 2, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 3, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 4, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 5, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 6, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 7, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 8, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 9, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 10, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 1, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 2, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 3, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 4, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 5, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 6, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 7, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 8, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 9, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 10, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 1, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 2, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 3, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 4, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 5, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 6, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 7, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 8, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 9, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 10, Blocks.dirt);
		
		world.setBlock(i + 1, j - 1, k + 1, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 2, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 3, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 4, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 5, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 6, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 7, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 8, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 9, Blocks.dirt);
		world.setBlock(i + 1, j - 1, k + 10, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 1, Blocks.dirt);
		world.setBlock(i + 2, j - 1, k + 10, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 1, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 2, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 3, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 4, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 5, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 6, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 7, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 8, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 9, Blocks.dirt);
		world.setBlock(i + 3, j - 1, k + 10, Blocks.dirt);
		return true;
	}
}