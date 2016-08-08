package zollernextras.worldgen.upsidedown;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.lib.ZollernHelper;

public class WorldGenSpiderEgg extends WorldGenerator {
	
	protected Block[] GetValidSpawnBlockList() {
		return new Block[] { ZollernBlocks.upsideDownStone,
				ZollernBlocks.upsideDownSurfaceRock,
				ZollernBlocks.upsideDownRock, ZollernBlocks.upsideDownDirt };
	}
	
	public boolean LocationIsValidSpawn(World world, int i, int j, int k) {
		int distanceToAir = 0;
		Block checkID = world.getBlock(i, j, k);
		
		while (checkID != Blocks.air) {
			distanceToAir++;
			checkID = world.getBlock(i, j + distanceToAir, k);
		}
		
		if (distanceToAir > 8) {
			return false;
		}
		j += distanceToAir - 1;
		
		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j + 1, k);
		Block blockIDBelow = world.getBlock(i, j - 1, k);
		for (Block x : GetValidSpawnBlockList()) {
			if (blockIDAbove != Blocks.air) {
				return false;
			}
			if (blockID == x) {
				return true;
			} else if (blockID != x && blockIDBelow == x) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		
		if (!LocationIsValidSpawn(world, x, y, z)) {
			ZollernHelper.Log("Location was not valid spawn.");
			return false;
		}
		
		if (world.getBlock(x, y - 1, z) == Blocks.air) {
			ZollernHelper.Log("The block below was air.");
			return false;
		}
		
		if (world.getBlock(x, y + 1, z) != Blocks.air) {
			ZollernHelper.Log("The block above was NOT air.");
			return false;
		}
		
		world.setBlock(x, y, z, ZollernBlocks.spiderlingEgg);
		
		world.setBlock(x + 1, y, z, Blocks.web);
		world.setBlock(x - 1, y, z, Blocks.web);
		
		world.setBlock(x + 1, y, z + 1, Blocks.web);
		world.setBlock(x - 1, y, z - 1, Blocks.web);
		
		world.setBlock(x, y, z + 1, Blocks.web);
		world.setBlock(x, y, z - 1, Blocks.web);
		
		world.setBlock(x - 1, y, z + 1, Blocks.web);
		world.setBlock(x + 1, y, z - 1, Blocks.web);
		
		return true;
	}
}