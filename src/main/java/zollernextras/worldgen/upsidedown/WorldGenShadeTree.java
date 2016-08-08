package zollernextras.worldgen.upsidedown;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.lib.Treasures;
import zollernextras.lib.ZEChestGenHooks;
import zollernextras.lib.ZollernHelper;
import zollernextras.mobs.entities.EntityKrull;

public class WorldGenShadeTree extends WorldGenerator {
	
	protected Block[] GetValidSpawnBlockList() {
		return new Block[] { ZollernBlocks.upsideDownDirt };
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
	public boolean generate(World world, Random rand, int x, int y, int z) {
		
		if (!LocationIsValidSpawn(world, x, y, z)) {
			ZollernHelper.debugLog("Location was not valid spawn.");
			return false;
		}
		
		if (world.getBlock(x, y - 1, z) == Blocks.air) {
			ZollernHelper.debugLog("The block below was air.");
			return false;
		}
		
		if (world.getBlock(x, y + 0, z) != Blocks.air) {
			ZollernHelper.debugLog("The block above was NOT air.");
			return false;
		}
		
		if (rand.nextInt(600) <= 20) {
			if (!world.isRemote) {
				EntityKrull krull = new EntityKrull(world);
				krull.setLocationAndAngles(x + 0, y + 1, z + 14, 0, 0);
				world.spawnEntityInWorld(krull);
			}
		}
		
		world.setBlock(x + 0, y + 5, z + 0, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 0, y + 5, z + 1, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 0, y + 5, z + 2, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 0, y + 5, z + 3, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 0, y + 5, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 0, y + 5, z + 5, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 0, y + 5, z + 6, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 1, y + 5, z + 0, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 1, y + 5, z + 1, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 1, y + 5, z + 2, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 1, y + 5, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 1, y + 5, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 1, y + 5, z + 5, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 1, y + 5, z + 6, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 1, y + 6, z + 1, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 1, y + 6, z + 2, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 1, y + 6, z + 3, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 1, y + 6, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 1, y + 6, z + 5, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 0, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 1, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 2, z + 2, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 2, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 2, z + 4, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 3, z + 1, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 3, z + 2, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 3, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 3, z + 4, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 3, z + 5, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 4, z + 1, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 4, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 4, z + 5, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 5, z + 0, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 5, z + 1, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 5, z + 2, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 5, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 5, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 5, z + 5, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 5, z + 6, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 6, z + 1, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 6, z + 2, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 6, z + 3, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 6, z + 4, ZollernBlocks.shadeLog);
		world.setBlock(x + 2, y + 6, z + 5, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 7, z + 2, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 7, z + 3, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 2, y + 7, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 3, y + 0, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 1, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 2, z + 2, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 2, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 2, z + 4, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 3, z + 1, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 3, z + 2, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 3, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 3, z + 4, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 3, z + 5, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 4, z + 1, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 4, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 4, z + 5, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 5, z + 0, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 3, y + 5, z + 1, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 5, z + 2, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 5, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 5, z + 4, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 5, z + 5, ZollernBlocks.shadeLog);
		world.setBlock(x + 3, y + 5, z + 6, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 3, y + 6, z + 1, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 3, y + 6, z + 2, ZollernBlocks.shadeLeaves);
		if (rand.nextInt(100) <= 70) {
			int chestX = x + 3;
			int chestY = y + 6;
			int chestZ = z + 3;
			int chestRand = rand.nextInt(2);
			boolean isBigChest = false;
			String chestString = chestX + " " + chestY + " " + chestZ;
			Treasures.spawnChest(world, rand, chestX, chestY, chestZ,
					isBigChest, ZEChestGenHooks.SHADE_TREE);
		}
		world.setBlock(x + 3, y + 6, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 3, y + 6, z + 5, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 3, y + 7, z + 2, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 3, y + 7, z + 3, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 3, y + 7, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 3, y + 8, z + 3, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 0, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 1, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 2, z + 2, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 2, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 2, z + 4, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 3, z + 1, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 3, z + 2, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 3, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 3, z + 4, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 3, z + 5, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 4, z + 1, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 4, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 4, z + 5, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 5, z + 0, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 5, z + 1, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 5, z + 2, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 5, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 5, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 5, z + 5, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 5, z + 6, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 6, z + 1, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 6, z + 2, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 6, z + 3, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 6, z + 4, ZollernBlocks.shadeLog);
		world.setBlock(x + 4, y + 6, z + 5, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 7, z + 2, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 7, z + 3, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 4, y + 7, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 5, y + 5, z + 0, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 5, y + 5, z + 1, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 5, y + 5, z + 2, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 5, y + 5, z + 3, ZollernBlocks.shadeLog);
		world.setBlock(x + 5, y + 5, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 5, y + 5, z + 5, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 5, y + 5, z + 6, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 5, y + 6, z + 1, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 5, y + 6, z + 2, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 5, y + 6, z + 3, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 5, y + 6, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 5, y + 6, z + 5, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 6, y + 5, z + 0, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 6, y + 5, z + 1, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 6, y + 5, z + 2, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 6, y + 5, z + 3, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 6, y + 5, z + 4, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 6, y + 5, z + 5, ZollernBlocks.shadeLeaves);
		world.setBlock(x + 6, y + 5, z + 6, ZollernBlocks.shadeLeaves);
		
		return true;
	}
}