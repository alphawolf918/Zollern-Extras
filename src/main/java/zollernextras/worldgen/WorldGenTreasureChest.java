package zollernextras.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.lib.Treasures;

public class WorldGenTreasureChest extends WorldGenerator {
	
	int randInt = new Random().nextInt(10);
	
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] { Blocks.sand, Blocks.clay, Blocks.dirt,
				Blocks.grass, Blocks.gravel, Blocks.water, Blocks.gravel };
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
			if (blockIDAbove != Blocks.water && blockIDAbove != Blocks.air) {
				return false;
			}
			if (blockID == x) {
				return true;
			}
		}
		return false;
	}
	
	public WorldGenTreasureChest() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		// check that each corner is one of the valid spawn blocks
		if (!LocationIsValidSpawn(world, i, j, k)) {
			return false;
		}
		int randDist = rand.nextInt(10);
		int chestX = i + 0;
		int chestY = j - 2;
		int chestZ = k + 0;
		int chestRand = rand.nextInt(2);
		boolean isBigChest = chestRand == 1 ? true : false;
		String chestString = chestX + " " + chestY + " " + chestZ;
		
		world.setBlock(chestX, chestY, chestZ, Blocks.chest);
		if (randInt == 5) {
			Treasures.spawnChest(world, rand, chestX, chestY, chestZ,
					isBigChest, Treasures.pickChestType());
		}
		return true;
	}
}