package zollernextras.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.blocks.BlockList;

public class WorldGenCrop extends WorldGenerator {
	
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] { Blocks.grass, Blocks.dirt, BlockList.betterGrass };
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
	
	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		if (!LocationIsValidSpawn(world, i, j, k)) {
			return false;
		}
		Block randBlock;
		int randInt = random.nextInt(10);
		if (randInt == 1) {
			randBlock = BlockList.strawberry;
		} else if (randInt == 2) {
			randBlock = BlockList.blueberry;
		} else if (randInt == 3) {
			randBlock = BlockList.blackberry;
		} else if (randInt == 4) {
			randBlock = BlockList.grape;
		} else if (randInt == 5) {
			randBlock = BlockList.radish;
		} else if (randInt == 6) {
			randBlock = BlockList.corn;
		} else if (randInt == 7) {
			randBlock = BlockList.radish;
		} else if (randInt == 8) {
			randBlock = BlockList.peas;
		} else if (randInt == 9) {
			randBlock = BlockList.corn;
		} else if (randInt == 10) {
			randBlock = BlockList.tomatoes;
		} else {
			randBlock = BlockList.aster;
		}
		world.setBlock(i, j, k, randBlock);
		return true;
	}
}