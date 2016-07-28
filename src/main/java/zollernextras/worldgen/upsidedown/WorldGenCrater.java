package zollernextras.worldgen.upsidedown;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCrater extends WorldGenerator {
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		
		int randInt = new Random().nextInt(50);
		randInt = randInt <= 5 ? 10 : 0;
		
		j -= randInt;
		
		j = j <= 15 ? 15 : j;
		
		world.setBlock(i + 1, j + 10, k + 5, Blocks.air);
		world.setBlock(i + 1, j + 10, k + 6, Blocks.air);
		world.setBlock(i + 1, j + 10, k + 7, Blocks.air);
		
		world.setBlock(i + 1, j + 11, k + 4, Blocks.air);
		world.setBlock(i + 1, j + 11, k + 5, Blocks.air);
		world.setBlock(i + 1, j + 11, k + 6, Blocks.air);
		world.setBlock(i + 1, j + 11, k + 7, Blocks.air);
		world.setBlock(i + 1, j + 11, k + 8, Blocks.air);
		
		world.setBlock(i + 1, j + 12, k + 3, Blocks.air);
		world.setBlock(i + 1, j + 12, k + 4, Blocks.air);
		world.setBlock(i + 1, j + 12, k + 5, Blocks.air);
		world.setBlock(i + 1, j + 12, k + 6, Blocks.air);
		world.setBlock(i + 1, j + 12, k + 7, Blocks.air);
		world.setBlock(i + 1, j + 12, k + 8, Blocks.air);
		world.setBlock(i + 1, j + 12, k + 9, Blocks.air);
		
		world.setBlock(i + 2, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 2, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 2, j + 8, k + 6, Blocks.air);
		world.setBlock(i + 2, j + 8, k + 7, Blocks.air);
		world.setBlock(i + 2, j + 8, k + 8, Blocks.air);
		
		world.setBlock(i + 2, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 2, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 2, j + 9, k + 5, Blocks.air);
		world.setBlock(i + 2, j + 9, k + 6, Blocks.air);
		world.setBlock(i + 2, j + 9, k + 7, Blocks.air);
		world.setBlock(i + 2, j + 9, k + 8, Blocks.air);
		world.setBlock(i + 2, j + 9, k + 9, Blocks.air);
		
		world.setBlock(i + 2, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 2, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 2, j + 10, k + 4, Blocks.air);
		world.setBlock(i + 2, j + 10, k + 5, Blocks.air);
		world.setBlock(i + 2, j + 10, k + 6, Blocks.air);
		world.setBlock(i + 2, j + 10, k + 7, Blocks.air);
		world.setBlock(i + 2, j + 10, k + 8, Blocks.air);
		world.setBlock(i + 2, j + 10, k + 9, Blocks.air);
		world.setBlock(i + 2, j + 10, k + 10, Blocks.air);
		
		world.setBlock(i + 2, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 2, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 2, j + 11, k + 3, Blocks.air);
		world.setBlock(i + 2, j + 11, k + 4, Blocks.air);
		world.setBlock(i + 2, j + 11, k + 5, Blocks.air);
		world.setBlock(i + 2, j + 11, k + 6, Blocks.air);
		world.setBlock(i + 2, j + 11, k + 7, Blocks.air);
		world.setBlock(i + 2, j + 11, k + 8, Blocks.air);
		world.setBlock(i + 2, j + 11, k + 9, Blocks.air);
		world.setBlock(i + 2, j + 11, k + 10, Blocks.air);
		world.setBlock(i + 2, j + 11, k + 11, Blocks.air);
		
		world.setBlock(i + 2, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 2, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 2, j + 12, k + 3, Blocks.air);
		world.setBlock(i + 2, j + 12, k + 4, Blocks.air);
		world.setBlock(i + 2, j + 12, k + 5, Blocks.air);
		world.setBlock(i + 2, j + 12, k + 6, Blocks.air);
		world.setBlock(i + 2, j + 12, k + 7, Blocks.air);
		world.setBlock(i + 2, j + 12, k + 8, Blocks.air);
		world.setBlock(i + 2, j + 12, k + 9, Blocks.air);
		world.setBlock(i + 2, j + 12, k + 10, Blocks.air);
		world.setBlock(i + 2, j + 12, k + 11, Blocks.air);
		
		world.setBlock(i + 3, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 3, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 3, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 3, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 3, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 3, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 3, j + 7, k + 9, Blocks.air);
		
		world.setBlock(i + 3, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 3, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 3, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 3, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 3, j + 8, k + 6, Blocks.air);
		world.setBlock(i + 3, j + 8, k + 7, Blocks.air);
		world.setBlock(i + 3, j + 8, k + 8, Blocks.air);
		world.setBlock(i + 3, j + 8, k + 9, Blocks.air);
		world.setBlock(i + 3, j + 8, k + 10, Blocks.air);
		
		world.setBlock(i + 3, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 3, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 3, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 3, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 3, j + 9, k + 5, Blocks.air);
		world.setBlock(i + 3, j + 9, k + 6, Blocks.air);
		world.setBlock(i + 3, j + 9, k + 7, Blocks.air);
		world.setBlock(i + 3, j + 9, k + 8, Blocks.air);
		world.setBlock(i + 3, j + 9, k + 9, Blocks.air);
		world.setBlock(i + 3, j + 9, k + 10, Blocks.air);
		world.setBlock(i + 3, j + 9, k + 11, Blocks.air);
		
		world.setBlock(i + 3, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 4, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 5, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 6, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 7, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 8, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 9, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 10, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 11, Blocks.air);
		world.setBlock(i + 3, j + 10, k + 12, Blocks.air);
		
		world.setBlock(i + 3, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 3, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 3, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 3, j + 11, k + 3, Blocks.air);
		world.setBlock(i + 3, j + 11, k + 4, Blocks.air);
		world.setBlock(i + 3, j + 11, k + 5, Blocks.air);
		world.setBlock(i + 3, j + 11, k + 6, Blocks.air);
		world.setBlock(i + 3, j + 11, k + 7, Blocks.air);
		
		world.setBlock(i + 3, j + 11, k + 11, Blocks.air);
		world.setBlock(i + 3, j + 11, k + 12, Blocks.air);
		
		world.setBlock(i + 3, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 3, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 3, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 3, j + 12, k + 3, Blocks.air);
		world.setBlock(i + 3, j + 12, k + 4, Blocks.air);
		world.setBlock(i + 3, j + 12, k + 5, Blocks.air);
		world.setBlock(i + 3, j + 12, k + 6, Blocks.air);
		
		world.setBlock(i + 3, j + 12, k + 12, Blocks.air);
		
		world.setBlock(i + 4, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 4, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 4, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 4, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 4, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 4, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 4, j + 6, k + 9, Blocks.air);
		
		world.setBlock(i + 4, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 4, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 4, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 4, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 4, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 4, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 4, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 4, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 4, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 4, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 4, j + 7, k + 11, Blocks.air);
		
		world.setBlock(i + 4, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 6, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 7, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 8, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 9, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 10, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 4, j + 8, k + 12, Blocks.air);
		
		world.setBlock(i + 4, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 5, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 6, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 7, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 8, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 9, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 10, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 11, Blocks.air);
		world.setBlock(i + 4, j + 9, k + 12, Blocks.air);
		
		world.setBlock(i + 4, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 4, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 4, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 4, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 4, j + 10, k + 4, Blocks.air);
		world.setBlock(i + 4, j + 10, k + 5, Blocks.air);
		world.setBlock(i + 4, j + 10, k + 6, Blocks.air);
		
		world.setBlock(i + 4, j + 10, k + 12, Blocks.air);
		world.setBlock(i + 4, j + 10, k + 13, Blocks.air);
		
		world.setBlock(i + 4, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 4, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 4, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 4, j + 11, k + 3, Blocks.air);
		world.setBlock(i + 4, j + 11, k + 4, Blocks.air);
		world.setBlock(i + 4, j + 11, k + 5, Blocks.air);
		
		world.setBlock(i + 4, j + 11, k + 13, Blocks.air);
		
		world.setBlock(i + 4, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 4, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 4, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 4, j + 12, k + 3, Blocks.air);
		world.setBlock(i + 4, j + 12, k + 4, Blocks.air);
		world.setBlock(i + 4, j + 12, k + 5, Blocks.air);
		
		world.setBlock(i + 4, j + 12, k + 13, Blocks.air);
		
		world.setBlock(i + 5, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 5, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 5, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 5, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 5, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 5, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 5, j + 5, k + 9, Blocks.air);
		
		world.setBlock(i + 5, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 5, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 5, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 5, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 5, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 5, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 5, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 5, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 5, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 5, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 5, j + 6, k + 11, Blocks.air);
		
		world.setBlock(i + 5, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 5, j + 7, k + 12, Blocks.air);
		
		world.setBlock(i + 5, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 6, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 7, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 8, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 9, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 10, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 5, j + 8, k + 13, Blocks.air);
		
		world.setBlock(i + 5, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 5, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 5, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 5, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 5, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 5, j + 9, k + 5, Blocks.air);
		world.setBlock(i + 5, j + 9, k + 6, Blocks.air);
		
		world.setBlock(i + 5, j + 9, k + 12, Blocks.air);
		world.setBlock(i + 5, j + 9, k + 13, Blocks.air);
		
		world.setBlock(i + 5, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 5, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 5, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 5, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 5, j + 10, k + 4, Blocks.air);
		world.setBlock(i + 5, j + 10, k + 5, Blocks.air);
		
		world.setBlock(i + 5, j + 10, k + 13, Blocks.air);
		world.setBlock(i + 5, j + 10, k + 14, Blocks.air);
		
		world.setBlock(i + 5, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 5, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 5, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 5, j + 11, k + 3, Blocks.air);
		world.setBlock(i + 5, j + 11, k + 4, Blocks.air);
		
		world.setBlock(i + 5, j + 11, k + 14, Blocks.air);
		
		world.setBlock(i + 5, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 5, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 5, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 5, j + 12, k + 3, Blocks.air);
		world.setBlock(i + 5, j + 12, k + 4, Blocks.air);
		
		world.setBlock(i + 5, j + 12, k + 14, Blocks.air);
		
		world.setBlock(i + 6, j + 4, k + 4, Blocks.air);
		world.setBlock(i + 6, j + 4, k + 5, Blocks.air);
		world.setBlock(i + 6, j + 4, k + 6, Blocks.air);
		world.setBlock(i + 6, j + 4, k + 7, Blocks.air);
		world.setBlock(i + 6, j + 4, k + 8, Blocks.air);
		
		world.setBlock(i + 6, j + 5, k + 2, Blocks.air);
		world.setBlock(i + 6, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 6, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 6, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 6, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 6, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 6, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 6, j + 5, k + 9, Blocks.air);
		world.setBlock(i + 6, j + 5, k + 10, Blocks.air);
		
		world.setBlock(i + 6, j + 6, k + 0, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 11, Blocks.air);
		world.setBlock(i + 6, j + 6, k + 12, Blocks.air);
		
		world.setBlock(i + 6, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 12, Blocks.air);
		world.setBlock(i + 6, j + 7, k + 13, Blocks.air);
		
		world.setBlock(i + 6, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 6, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 6, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 6, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 6, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 6, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 6, j + 8, k + 6, Blocks.air);
		world.setBlock(i + 6, j + 8, k + 7, Blocks.air);
		
		world.setBlock(i + 6, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 6, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 6, j + 8, k + 13, Blocks.air);
		
		world.setBlock(i + 6, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 6, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 6, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 6, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 6, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 6, j + 9, k + 5, Blocks.air);
		
		generate2(world, rand, i, j, k);
		return true;
	}
	
	public boolean generate2(World world, Random rand, int i, int j, int k) {
		
		world.setBlock(i + 6, j + 9, k + 13, Blocks.air);
		world.setBlock(i + 6, j + 9, k + 14, Blocks.air);
		
		world.setBlock(i + 6, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 6, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 6, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 6, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 6, j + 10, k + 4, Blocks.air);
		
		world.setBlock(i + 6, j + 10, k + 14, Blocks.air);
		
		world.setBlock(i + 6, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 6, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 6, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 6, j + 11, k + 3, Blocks.air);
		world.setBlock(i + 6, j + 11, k + 4, Blocks.air);
		
		world.setBlock(i + 6, j + 11, k + 14, Blocks.air);
		world.setBlock(i + 6, j + 11, k + 15, Blocks.air);
		world.setBlock(i + 6, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 6, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 6, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 6, j + 12, k + 3, Blocks.air);
		
		world.setBlock(i + 6, j + 12, k + 15, Blocks.air);
		
		world.setBlock(i + 7, j + 4, k + 3, Blocks.air);
		world.setBlock(i + 7, j + 4, k + 4, Blocks.air);
		world.setBlock(i + 7, j + 4, k + 5, Blocks.air);
		world.setBlock(i + 7, j + 4, k + 6, Blocks.air);
		world.setBlock(i + 7, j + 4, k + 7, Blocks.air);
		world.setBlock(i + 7, j + 4, k + 8, Blocks.air);
		world.setBlock(i + 7, j + 4, k + 9, Blocks.air);
		
		world.setBlock(i + 7, j + 5, k + 1, Blocks.air);
		world.setBlock(i + 7, j + 5, k + 2, Blocks.air);
		world.setBlock(i + 7, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 7, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 7, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 7, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 7, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 7, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 7, j + 5, k + 9, Blocks.air);
		world.setBlock(i + 7, j + 5, k + 10, Blocks.air);
		world.setBlock(i + 7, j + 5, k + 11, Blocks.air);
		
		world.setBlock(i + 7, j + 6, k + 0, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 11, Blocks.air);
		world.setBlock(i + 7, j + 6, k + 12, Blocks.air);
		
		world.setBlock(i + 7, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 12, Blocks.air);
		world.setBlock(i + 7, j + 7, k + 13, Blocks.air);
		
		world.setBlock(i + 7, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 7, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 7, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 7, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 7, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 7, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 7, j + 8, k + 6, Blocks.air);
		
		world.setBlock(i + 7, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 7, j + 8, k + 13, Blocks.air);
		world.setBlock(i + 7, j + 8, k + 14, Blocks.air);
		
		world.setBlock(i + 7, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 7, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 7, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 7, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 7, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 7, j + 9, k + 5, Blocks.air);
		
		world.setBlock(i + 7, j + 9, k + 13, Blocks.air);
		world.setBlock(i + 7, j + 9, k + 14, Blocks.air);
		
		world.setBlock(i + 7, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 7, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 7, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 7, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 7, j + 10, k + 4, Blocks.air);
		
		world.setBlock(i + 7, j + 10, k + 14, Blocks.air);
		world.setBlock(i + 7, j + 10, k + 15, Blocks.air);
		world.setBlock(i + 7, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 7, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 7, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 7, j + 11, k + 3, Blocks.air);
		
		world.setBlock(i + 7, j + 11, k + 15, Blocks.air);
		world.setBlock(i + 7, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 7, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 7, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 7, j + 12, k + 3, Blocks.air);
		
		world.setBlock(i + 7, j + 12, k + 15, Blocks.air);
		
		world.setBlock(i + 8, j + 3, k + 5, Blocks.air);
		world.setBlock(i + 8, j + 3, k + 6, Blocks.air);
		world.setBlock(i + 8, j + 3, k + 7, Blocks.air);
		
		world.setBlock(i + 8, j + 4, k + 2, Blocks.air);
		world.setBlock(i + 8, j + 4, k + 3, Blocks.air);
		world.setBlock(i + 8, j + 4, k + 4, Blocks.air);
		world.setBlock(i + 8, j + 4, k + 5, Blocks.air);
		world.setBlock(i + 8, j + 4, k + 6, Blocks.air);
		world.setBlock(i + 8, j + 4, k + 7, Blocks.air);
		world.setBlock(i + 8, j + 4, k + 8, Blocks.air);
		world.setBlock(i + 8, j + 4, k + 9, Blocks.air);
		world.setBlock(i + 8, j + 4, k + 10, Blocks.air);
		
		world.setBlock(i + 8, j + 5, k + 0, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 1, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 2, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 9, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 10, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 11, Blocks.air);
		world.setBlock(i + 8, j + 5, k + 12, Blocks.air);
		
		world.setBlock(i + 8, j + 6, k + 0, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 11, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 12, Blocks.air);
		world.setBlock(i + 8, j + 6, k + 13, Blocks.air);
		
		world.setBlock(i + 8, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 12, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 13, Blocks.air);
		world.setBlock(i + 8, j + 7, k + 14, Blocks.air);
		
		world.setBlock(i + 8, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 8, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 8, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 8, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 8, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 8, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 8, j + 8, k + 6, Blocks.air);
		
		world.setBlock(i + 8, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 8, j + 8, k + 13, Blocks.air);
		world.setBlock(i + 8, j + 8, k + 14, Blocks.air);
		
		world.setBlock(i + 8, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 8, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 8, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 8, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 8, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 8, j + 9, k + 5, Blocks.air);
		
		world.setBlock(i + 8, j + 9, k + 13, Blocks.air);
		world.setBlock(i + 8, j + 9, k + 14, Blocks.air);
		world.setBlock(i + 8, j + 9, k + 15, Blocks.air);
		world.setBlock(i + 8, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 8, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 8, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 8, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 8, j + 10, k + 4, Blocks.air);
		
		world.setBlock(i + 8, j + 10, k + 14, Blocks.air);
		world.setBlock(i + 8, j + 10, k + 15, Blocks.air);
		world.setBlock(i + 8, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 8, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 8, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 8, j + 11, k + 3, Blocks.air);
		
		world.setBlock(i + 8, j + 11, k + 15, Blocks.air);
		world.setBlock(i + 8, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 8, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 8, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 8, j + 12, k + 3, Blocks.air);
		
		world.setBlock(i + 8, j + 12, k + 15, Blocks.air);
		
		world.setBlock(i + 9, j + 3, k + 4, Blocks.air);
		world.setBlock(i + 9, j + 3, k + 5, Blocks.air);
		world.setBlock(i + 9, j + 3, k + 6, Blocks.air);
		world.setBlock(i + 9, j + 3, k + 7, Blocks.air);
		world.setBlock(i + 9, j + 3, k + 8, Blocks.air);
		
		world.setBlock(i + 9, j + 4, k + 1, Blocks.air);
		world.setBlock(i + 9, j + 4, k + 2, Blocks.air);
		world.setBlock(i + 9, j + 4, k + 3, Blocks.air);
		world.setBlock(i + 9, j + 4, k + 4, Blocks.air);
		world.setBlock(i + 9, j + 4, k + 5, Blocks.air);
		world.setBlock(i + 9, j + 4, k + 6, Blocks.air);
		world.setBlock(i + 9, j + 4, k + 7, Blocks.air);
		world.setBlock(i + 9, j + 4, k + 8, Blocks.air);
		world.setBlock(i + 9, j + 4, k + 9, Blocks.air);
		world.setBlock(i + 9, j + 4, k + 10, Blocks.air);
		world.setBlock(i + 9, j + 4, k + 11, Blocks.air);
		
		world.setBlock(i + 9, j + 5, k + 0, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 1, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 2, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 9, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 10, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 11, Blocks.air);
		world.setBlock(i + 9, j + 5, k + 12, Blocks.air);
		
		world.setBlock(i + 9, j + 6, k + 0, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 11, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 12, Blocks.air);
		world.setBlock(i + 9, j + 6, k + 13, Blocks.air);
		
		world.setBlock(i + 9, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 12, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 13, Blocks.air);
		world.setBlock(i + 9, j + 7, k + 14, Blocks.air);
		
		world.setBlock(i + 9, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 9, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 9, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 9, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 9, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 9, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 9, j + 8, k + 6, Blocks.air);
		
		world.setBlock(i + 9, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 9, j + 8, k + 13, Blocks.air);
		world.setBlock(i + 9, j + 8, k + 14, Blocks.air);
		world.setBlock(i + 9, j + 8, k + 15, Blocks.air);
		world.setBlock(i + 9, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 9, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 9, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 9, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 9, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 9, j + 9, k + 5, Blocks.air);
		
		world.setBlock(i + 9, j + 9, k + 13, Blocks.air);
		world.setBlock(i + 9, j + 9, k + 14, Blocks.air);
		world.setBlock(i + 9, j + 9, k + 15, Blocks.air);
		world.setBlock(i + 9, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 9, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 9, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 9, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 9, j + 10, k + 4, Blocks.air);
		
		world.setBlock(i + 9, j + 10, k + 14, Blocks.air);
		world.setBlock(i + 9, j + 10, k + 15, Blocks.air);
		world.setBlock(i + 9, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 9, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 9, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 9, j + 11, k + 3, Blocks.air);
		
		world.setBlock(i + 9, j + 11, k + 15, Blocks.air);
		world.setBlock(i + 9, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 9, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 9, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 9, j + 12, k + 3, Blocks.air);
		
		world.setBlock(i + 9, j + 12, k + 15, Blocks.air);
		
		world.setBlock(i + 10, j + 3, k + 3, Blocks.air);
		world.setBlock(i + 10, j + 3, k + 4, Blocks.air);
		world.setBlock(i + 10, j + 3, k + 5, Blocks.air);
		world.setBlock(i + 10, j + 3, k + 6, Blocks.air);
		world.setBlock(i + 10, j + 3, k + 7, Blocks.air);
		world.setBlock(i + 10, j + 3, k + 8, Blocks.air);
		world.setBlock(i + 10, j + 3, k + 9, Blocks.air);
		
		world.setBlock(i + 10, j + 4, k + 1, Blocks.air);
		world.setBlock(i + 10, j + 4, k + 2, Blocks.air);
		world.setBlock(i + 10, j + 4, k + 3, Blocks.air);
		world.setBlock(i + 10, j + 4, k + 4, Blocks.air);
		world.setBlock(i + 10, j + 4, k + 5, Blocks.air);
		world.setBlock(i + 10, j + 4, k + 6, Blocks.air);
		world.setBlock(i + 10, j + 4, k + 7, Blocks.air);
		world.setBlock(i + 10, j + 4, k + 8, Blocks.air);
		world.setBlock(i + 10, j + 4, k + 9, Blocks.air);
		world.setBlock(i + 10, j + 4, k + 10, Blocks.air);
		world.setBlock(i + 10, j + 4, k + 11, Blocks.air);
		
		world.setBlock(i + 10, j + 5, k + 0, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 1, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 2, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 9, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 10, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 11, Blocks.air);
		world.setBlock(i + 10, j + 5, k + 12, Blocks.air);
		
		world.setBlock(i + 10, j + 6, k + 0, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 11, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 12, Blocks.air);
		world.setBlock(i + 10, j + 6, k + 13, Blocks.air);
		
		world.setBlock(i + 10, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 12, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 13, Blocks.air);
		world.setBlock(i + 10, j + 7, k + 14, Blocks.air);
		
		world.setBlock(i + 10, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 10, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 10, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 10, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 10, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 10, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 10, j + 8, k + 6, Blocks.air);
		world.setBlock(i + 10, j + 8, k + 7, Blocks.air);
		
		world.setBlock(i + 10, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 10, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 10, j + 8, k + 13, Blocks.air);
		world.setBlock(i + 10, j + 8, k + 14, Blocks.air);
		world.setBlock(i + 10, j + 8, k + 15, Blocks.air);
		world.setBlock(i + 10, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 10, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 10, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 10, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 10, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 10, j + 9, k + 5, Blocks.air);
		
		world.setBlock(i + 10, j + 9, k + 13, Blocks.air);
		world.setBlock(i + 10, j + 9, k + 14, Blocks.air);
		world.setBlock(i + 10, j + 9, k + 15, Blocks.air);
		world.setBlock(i + 10, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 10, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 10, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 10, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 10, j + 10, k + 4, Blocks.air);
		
		world.setBlock(i + 10, j + 10, k + 14, Blocks.air);
		world.setBlock(i + 10, j + 10, k + 15, Blocks.air);
		world.setBlock(i + 10, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 10, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 10, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 10, j + 11, k + 3, Blocks.air);
		
		world.setBlock(i + 10, j + 11, k + 14, Blocks.air);
		world.setBlock(i + 10, j + 11, k + 15, Blocks.air);
		world.setBlock(i + 10, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 10, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 10, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 10, j + 12, k + 3, Blocks.air);
		
		world.setBlock(i + 10, j + 12, k + 15, Blocks.air);
		
		world.setBlock(i + 11, j + 3, k + 3, Blocks.air);
		world.setBlock(i + 11, j + 3, k + 4, Blocks.air);
		world.setBlock(i + 11, j + 3, k + 5, Blocks.air);
		world.setBlock(i + 11, j + 3, k + 6, Blocks.air);
		world.setBlock(i + 11, j + 3, k + 7, Blocks.air);
		world.setBlock(i + 11, j + 3, k + 8, Blocks.air);
		world.setBlock(i + 11, j + 3, k + 9, Blocks.air);
		
		world.setBlock(i + 11, j + 4, k + 1, Blocks.air);
		world.setBlock(i + 11, j + 4, k + 2, Blocks.air);
		world.setBlock(i + 11, j + 4, k + 3, Blocks.air);
		world.setBlock(i + 11, j + 4, k + 4, Blocks.air);
		world.setBlock(i + 11, j + 4, k + 5, Blocks.air);
		world.setBlock(i + 11, j + 4, k + 6, Blocks.air);
		world.setBlock(i + 11, j + 4, k + 7, Blocks.air);
		world.setBlock(i + 11, j + 4, k + 8, Blocks.air);
		world.setBlock(i + 11, j + 4, k + 9, Blocks.air);
		world.setBlock(i + 11, j + 4, k + 10, Blocks.air);
		world.setBlock(i + 11, j + 4, k + 11, Blocks.air);
		
		world.setBlock(i + 11, j + 5, k + 0, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 1, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 2, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 9, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 10, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 11, Blocks.air);
		world.setBlock(i + 11, j + 5, k + 12, Blocks.air);
		
		world.setBlock(i + 11, j + 6, k + 0, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 11, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 12, Blocks.air);
		world.setBlock(i + 11, j + 6, k + 13, Blocks.air);
		
		world.setBlock(i + 11, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 12, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 13, Blocks.air);
		world.setBlock(i + 11, j + 7, k + 14, Blocks.air);
		
		world.setBlock(i + 11, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 11, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 11, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 11, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 11, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 11, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 11, j + 8, k + 6, Blocks.air);
		
		world.setBlock(i + 11, j + 8, k + 10, Blocks.air);
		world.setBlock(i + 11, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 11, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 11, j + 8, k + 13, Blocks.air);
		world.setBlock(i + 11, j + 8, k + 14, Blocks.air);
		world.setBlock(i + 11, j + 8, k + 15, Blocks.air);
		world.setBlock(i + 11, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 11, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 11, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 11, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 11, j + 9, k + 4, Blocks.air);
		
		world.setBlock(i + 11, j + 9, k + 12, Blocks.air);
		world.setBlock(i + 11, j + 9, k + 13, Blocks.air);
		world.setBlock(i + 11, j + 9, k + 14, Blocks.air);
		world.setBlock(i + 11, j + 9, k + 15, Blocks.air);
		world.setBlock(i + 11, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 11, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 11, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 11, j + 10, k + 3, Blocks.air);
		
		world.setBlock(i + 11, j + 10, k + 13, Blocks.air);
		world.setBlock(i + 11, j + 10, k + 14, Blocks.air);
		world.setBlock(i + 11, j + 10, k + 15, Blocks.air);
		world.setBlock(i + 11, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 11, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 11, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 11, j + 11, k + 3, Blocks.air);
		
		world.setBlock(i + 11, j + 11, k + 14, Blocks.air);
		world.setBlock(i + 11, j + 11, k + 15, Blocks.air);
		world.setBlock(i + 11, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 11, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 11, j + 12, k + 2, Blocks.air);
		
		world.setBlock(i + 11, j + 12, k + 14, Blocks.air);
		world.setBlock(i + 11, j + 12, k + 15, Blocks.air);
		
		world.setBlock(i + 12, j + 3, k + 3, Blocks.air);
		world.setBlock(i + 12, j + 3, k + 4, Blocks.air);
		world.setBlock(i + 12, j + 3, k + 5, Blocks.air);
		world.setBlock(i + 12, j + 3, k + 6, Blocks.air);
		world.setBlock(i + 12, j + 3, k + 7, Blocks.air);
		world.setBlock(i + 12, j + 3, k + 8, Blocks.air);
		world.setBlock(i + 12, j + 3, k + 9, Blocks.air);
		
		world.setBlock(i + 12, j + 4, k + 1, Blocks.air);
		world.setBlock(i + 12, j + 4, k + 2, Blocks.air);
		world.setBlock(i + 12, j + 4, k + 3, Blocks.air);
		world.setBlock(i + 12, j + 4, k + 4, Blocks.air);
		world.setBlock(i + 12, j + 4, k + 5, Blocks.air);
		world.setBlock(i + 12, j + 4, k + 6, Blocks.air);
		world.setBlock(i + 12, j + 4, k + 7, Blocks.air);
		world.setBlock(i + 12, j + 4, k + 8, Blocks.air);
		world.setBlock(i + 12, j + 4, k + 9, Blocks.air);
		world.setBlock(i + 12, j + 4, k + 10, Blocks.air);
		world.setBlock(i + 12, j + 4, k + 11, Blocks.air);
		
		world.setBlock(i + 12, j + 5, k + 0, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 1, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 2, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 9, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 10, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 11, Blocks.air);
		world.setBlock(i + 12, j + 5, k + 12, Blocks.air);
		
		world.setBlock(i + 12, j + 6, k + 0, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 11, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 12, Blocks.air);
		world.setBlock(i + 12, j + 6, k + 13, Blocks.air);
		
		world.setBlock(i + 12, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 12, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 13, Blocks.air);
		world.setBlock(i + 12, j + 7, k + 14, Blocks.air);
		
		world.setBlock(i + 12, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 12, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 12, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 12, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 12, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 12, j + 8, k + 5, Blocks.air);
		
		world.setBlock(i + 12, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 12, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 12, j + 8, k + 13, Blocks.air);
		world.setBlock(i + 12, j + 8, k + 14, Blocks.air);
		world.setBlock(i + 12, j + 8, k + 15, Blocks.air);
		world.setBlock(i + 12, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 12, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 12, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 12, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 12, j + 9, k + 4, Blocks.air);
		
		world.setBlock(i + 12, j + 9, k + 12, Blocks.air);
		world.setBlock(i + 12, j + 9, k + 13, Blocks.air);
		world.setBlock(i + 12, j + 9, k + 14, Blocks.air);
		world.setBlock(i + 12, j + 9, k + 15, Blocks.air);
		world.setBlock(i + 12, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 12, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 12, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 12, j + 10, k + 3, Blocks.air);
		
		world.setBlock(i + 12, j + 10, k + 13, Blocks.air);
		world.setBlock(i + 12, j + 10, k + 14, Blocks.air);
		world.setBlock(i + 12, j + 10, k + 15, Blocks.air);
		world.setBlock(i + 12, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 12, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 12, j + 11, k + 2, Blocks.air);
		
		world.setBlock(i + 12, j + 11, k + 14, Blocks.air);
		world.setBlock(i + 12, j + 11, k + 15, Blocks.air);
		world.setBlock(i + 12, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 12, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 12, j + 12, k + 2, Blocks.air);
		
		world.setBlock(i + 12, j + 12, k + 14, Blocks.air);
		world.setBlock(i + 12, j + 12, k + 15, Blocks.air);
		
		world.setBlock(i + 13, j + 3, k + 4, Blocks.air);
		world.setBlock(i + 13, j + 3, k + 5, Blocks.air);
		world.setBlock(i + 13, j + 3, k + 6, Blocks.air);
		world.setBlock(i + 13, j + 3, k + 7, Blocks.air);
		world.setBlock(i + 13, j + 3, k + 8, Blocks.air);
		
		world.setBlock(i + 13, j + 4, k + 1, Blocks.air);
		world.setBlock(i + 13, j + 4, k + 2, Blocks.air);
		world.setBlock(i + 13, j + 4, k + 3, Blocks.air);
		world.setBlock(i + 13, j + 4, k + 4, Blocks.air);
		world.setBlock(i + 13, j + 4, k + 5, Blocks.air);
		world.setBlock(i + 13, j + 4, k + 6, Blocks.air);
		world.setBlock(i + 13, j + 4, k + 7, Blocks.air);
		world.setBlock(i + 13, j + 4, k + 8, Blocks.air);
		world.setBlock(i + 13, j + 4, k + 9, Blocks.air);
		world.setBlock(i + 13, j + 4, k + 10, Blocks.air);
		world.setBlock(i + 13, j + 4, k + 11, Blocks.air);
		
		world.setBlock(i + 13, j + 5, k + 0, Blocks.air);
		world.setBlock(i + 13, j + 5, k + 1, Blocks.air);
		world.setBlock(i + 13, j + 5, k + 2, Blocks.air);
		world.setBlock(i + 13, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 13, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 13, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 13, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 13, j + 5, k + 7, Blocks.air);
		
		generate3(world, rand, i, j, k);
		return true;
	}
	
	public boolean generate3(World world, Random rand, int i, int j, int k) {
		world.setBlock(i + 13, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 13, j + 5, k + 9, Blocks.air);
		world.setBlock(i + 13, j + 5, k + 10, Blocks.air);
		world.setBlock(i + 13, j + 5, k + 11, Blocks.air);
		world.setBlock(i + 13, j + 5, k + 12, Blocks.air);
		
		world.setBlock(i + 13, j + 6, k + 0, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 11, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 12, Blocks.air);
		world.setBlock(i + 13, j + 6, k + 13, Blocks.air);
		
		world.setBlock(i + 13, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 12, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 13, Blocks.air);
		world.setBlock(i + 13, j + 7, k + 14, Blocks.air);
		
		world.setBlock(i + 13, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 13, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 13, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 13, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 13, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 13, j + 8, k + 5, Blocks.air);
		
		world.setBlock(i + 13, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 13, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 13, j + 8, k + 13, Blocks.air);
		world.setBlock(i + 13, j + 8, k + 14, Blocks.air);
		world.setBlock(i + 13, j + 8, k + 15, Blocks.air);
		world.setBlock(i + 13, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 13, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 13, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 13, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 13, j + 9, k + 4, Blocks.air);
		
		world.setBlock(i + 13, j + 9, k + 12, Blocks.air);
		world.setBlock(i + 13, j + 9, k + 13, Blocks.air);
		world.setBlock(i + 13, j + 9, k + 14, Blocks.air);
		world.setBlock(i + 13, j + 9, k + 15, Blocks.air);
		world.setBlock(i + 13, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 13, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 13, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 13, j + 10, k + 3, Blocks.air);
		
		world.setBlock(i + 13, j + 10, k + 13, Blocks.air);
		world.setBlock(i + 13, j + 10, k + 14, Blocks.air);
		world.setBlock(i + 13, j + 10, k + 15, Blocks.air);
		world.setBlock(i + 13, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 13, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 13, j + 11, k + 2, Blocks.air);
		
		world.setBlock(i + 13, j + 11, k + 14, Blocks.air);
		world.setBlock(i + 13, j + 11, k + 15, Blocks.air);
		world.setBlock(i + 13, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 13, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 13, j + 12, k + 2, Blocks.air);
		
		world.setBlock(i + 13, j + 12, k + 14, Blocks.air);
		world.setBlock(i + 13, j + 12, k + 15, Blocks.air);
		
		world.setBlock(i + 14, j + 3, k + 5, Blocks.air);
		world.setBlock(i + 14, j + 3, k + 6, Blocks.air);
		world.setBlock(i + 14, j + 3, k + 7, Blocks.air);
		
		world.setBlock(i + 14, j + 4, k + 2, Blocks.air);
		world.setBlock(i + 14, j + 4, k + 3, Blocks.air);
		world.setBlock(i + 14, j + 4, k + 4, Blocks.air);
		world.setBlock(i + 14, j + 4, k + 5, Blocks.air);
		world.setBlock(i + 14, j + 4, k + 6, Blocks.air);
		world.setBlock(i + 14, j + 4, k + 7, Blocks.air);
		world.setBlock(i + 14, j + 4, k + 8, Blocks.air);
		world.setBlock(i + 14, j + 4, k + 9, Blocks.air);
		world.setBlock(i + 14, j + 4, k + 10, Blocks.air);
		
		world.setBlock(i + 14, j + 5, k + 0, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 1, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 2, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 9, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 10, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 11, Blocks.air);
		world.setBlock(i + 14, j + 5, k + 12, Blocks.air);
		
		world.setBlock(i + 14, j + 6, k + 0, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 11, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 12, Blocks.air);
		world.setBlock(i + 14, j + 6, k + 13, Blocks.air);
		
		world.setBlock(i + 14, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 12, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 13, Blocks.air);
		world.setBlock(i + 14, j + 7, k + 14, Blocks.air);
		
		world.setBlock(i + 14, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 14, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 14, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 14, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 14, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 14, j + 8, k + 5, Blocks.air);
		
		world.setBlock(i + 14, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 14, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 14, j + 8, k + 13, Blocks.air);
		world.setBlock(i + 14, j + 8, k + 14, Blocks.air);
		
		world.setBlock(i + 14, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 14, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 14, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 14, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 14, j + 9, k + 4, Blocks.air);
		
		world.setBlock(i + 14, j + 9, k + 12, Blocks.air);
		world.setBlock(i + 14, j + 9, k + 13, Blocks.air);
		world.setBlock(i + 14, j + 9, k + 14, Blocks.air);
		world.setBlock(i + 14, j + 9, k + 15, Blocks.air);
		world.setBlock(i + 14, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 14, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 14, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 14, j + 10, k + 3, Blocks.air);
		
		world.setBlock(i + 14, j + 10, k + 13, Blocks.air);
		world.setBlock(i + 14, j + 10, k + 14, Blocks.air);
		world.setBlock(i + 14, j + 10, k + 15, Blocks.air);
		world.setBlock(i + 14, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 14, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 14, j + 11, k + 2, Blocks.air);
		
		world.setBlock(i + 14, j + 11, k + 14, Blocks.air);
		world.setBlock(i + 14, j + 11, k + 15, Blocks.air);
		world.setBlock(i + 14, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 14, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 14, j + 12, k + 2, Blocks.air);
		
		world.setBlock(i + 14, j + 12, k + 14, Blocks.air);
		world.setBlock(i + 14, j + 12, k + 15, Blocks.air);
		
		world.setBlock(i + 15, j + 4, k + 3, Blocks.air);
		world.setBlock(i + 15, j + 4, k + 4, Blocks.air);
		world.setBlock(i + 15, j + 4, k + 5, Blocks.air);
		world.setBlock(i + 15, j + 4, k + 6, Blocks.air);
		world.setBlock(i + 15, j + 4, k + 7, Blocks.air);
		world.setBlock(i + 15, j + 4, k + 8, Blocks.air);
		world.setBlock(i + 15, j + 4, k + 9, Blocks.air);
		
		world.setBlock(i + 15, j + 5, k + 1, Blocks.air);
		world.setBlock(i + 15, j + 5, k + 2, Blocks.air);
		world.setBlock(i + 15, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 15, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 15, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 15, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 15, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 15, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 15, j + 5, k + 9, Blocks.air);
		world.setBlock(i + 15, j + 5, k + 10, Blocks.air);
		world.setBlock(i + 15, j + 5, k + 11, Blocks.air);
		
		world.setBlock(i + 15, j + 6, k + 0, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 11, Blocks.air);
		world.setBlock(i + 15, j + 6, k + 12, Blocks.air);
		
		world.setBlock(i + 15, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 12, Blocks.air);
		world.setBlock(i + 15, j + 7, k + 13, Blocks.air);
		
		world.setBlock(i + 15, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 15, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 15, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 15, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 15, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 15, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 15, j + 8, k + 6, Blocks.air);
		
		world.setBlock(i + 15, j + 8, k + 10, Blocks.air);
		world.setBlock(i + 15, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 15, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 15, j + 8, k + 13, Blocks.air);
		world.setBlock(i + 15, j + 8, k + 14, Blocks.air);
		
		world.setBlock(i + 15, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 15, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 15, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 15, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 15, j + 9, k + 4, Blocks.air);
		
		world.setBlock(i + 15, j + 9, k + 12, Blocks.air);
		world.setBlock(i + 15, j + 9, k + 13, Blocks.air);
		world.setBlock(i + 15, j + 9, k + 14, Blocks.air);
		
		world.setBlock(i + 15, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 15, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 15, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 15, j + 10, k + 3, Blocks.air);
		
		world.setBlock(i + 15, j + 10, k + 13, Blocks.air);
		world.setBlock(i + 15, j + 10, k + 14, Blocks.air);
		world.setBlock(i + 15, j + 10, k + 15, Blocks.air);
		world.setBlock(i + 15, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 15, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 15, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 15, j + 11, k + 3, Blocks.air);
		
		world.setBlock(i + 15, j + 11, k + 13, Blocks.air);
		world.setBlock(i + 15, j + 11, k + 14, Blocks.air);
		world.setBlock(i + 15, j + 11, k + 15, Blocks.air);
		world.setBlock(i + 15, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 15, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 15, j + 12, k + 2, Blocks.air);
		
		world.setBlock(i + 15, j + 12, k + 14, Blocks.air);
		world.setBlock(i + 15, j + 12, k + 15, Blocks.air);
		
		world.setBlock(i + 16, j + 4, k + 4, Blocks.air);
		world.setBlock(i + 16, j + 4, k + 5, Blocks.air);
		world.setBlock(i + 16, j + 4, k + 6, Blocks.air);
		world.setBlock(i + 16, j + 4, k + 7, Blocks.air);
		world.setBlock(i + 16, j + 4, k + 8, Blocks.air);
		
		world.setBlock(i + 16, j + 5, k + 2, Blocks.air);
		world.setBlock(i + 16, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 16, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 16, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 16, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 16, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 16, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 16, j + 5, k + 9, Blocks.air);
		world.setBlock(i + 16, j + 5, k + 10, Blocks.air);
		
		world.setBlock(i + 16, j + 6, k + 0, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 11, Blocks.air);
		world.setBlock(i + 16, j + 6, k + 12, Blocks.air);
		
		world.setBlock(i + 16, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 12, Blocks.air);
		world.setBlock(i + 16, j + 7, k + 13, Blocks.air);
		
		world.setBlock(i + 16, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 6, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 7, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 8, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 9, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 10, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 16, j + 8, k + 13, Blocks.air);
		
		world.setBlock(i + 16, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 16, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 16, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 16, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 16, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 16, j + 9, k + 5, Blocks.air);
		
		world.setBlock(i + 16, j + 9, k + 11, Blocks.air);
		world.setBlock(i + 16, j + 9, k + 12, Blocks.air);
		world.setBlock(i + 16, j + 9, k + 13, Blocks.air);
		world.setBlock(i + 16, j + 9, k + 14, Blocks.air);
		
		world.setBlock(i + 16, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 16, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 16, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 16, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 16, j + 10, k + 4, Blocks.air);
		
		world.setBlock(i + 16, j + 10, k + 12, Blocks.air);
		world.setBlock(i + 16, j + 10, k + 13, Blocks.air);
		world.setBlock(i + 16, j + 10, k + 14, Blocks.air);
		
		world.setBlock(i + 16, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 16, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 16, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 16, j + 11, k + 3, Blocks.air);
		
		world.setBlock(i + 16, j + 11, k + 13, Blocks.air);
		world.setBlock(i + 16, j + 11, k + 14, Blocks.air);
		world.setBlock(i + 16, j + 11, k + 15, Blocks.air);
		world.setBlock(i + 16, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 16, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 16, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 16, j + 12, k + 3, Blocks.air);
		
		world.setBlock(i + 16, j + 12, k + 13, Blocks.air);
		world.setBlock(i + 16, j + 12, k + 14, Blocks.air);
		world.setBlock(i + 16, j + 12, k + 15, Blocks.air);
		
		world.setBlock(i + 17, j + 5, k + 3, Blocks.air);
		world.setBlock(i + 17, j + 5, k + 4, Blocks.air);
		world.setBlock(i + 17, j + 5, k + 5, Blocks.air);
		world.setBlock(i + 17, j + 5, k + 6, Blocks.air);
		world.setBlock(i + 17, j + 5, k + 7, Blocks.air);
		world.setBlock(i + 17, j + 5, k + 8, Blocks.air);
		world.setBlock(i + 17, j + 5, k + 9, Blocks.air);
		
		world.setBlock(i + 17, j + 6, k + 1, Blocks.air);
		world.setBlock(i + 17, j + 6, k + 2, Blocks.air);
		world.setBlock(i + 17, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 17, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 17, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 17, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 17, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 17, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 17, j + 6, k + 9, Blocks.air);
		world.setBlock(i + 17, j + 6, k + 10, Blocks.air);
		world.setBlock(i + 17, j + 6, k + 11, Blocks.air);
		
		world.setBlock(i + 17, j + 7, k + 0, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 11, Blocks.air);
		world.setBlock(i + 17, j + 7, k + 12, Blocks.air);
		
		world.setBlock(i + 17, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 6, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 7, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 8, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 9, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 10, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 12, Blocks.air);
		world.setBlock(i + 17, j + 8, k + 13, Blocks.air);
		
		world.setBlock(i + 17, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 5, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 6, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 7, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 8, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 9, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 10, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 11, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 12, Blocks.air);
		world.setBlock(i + 17, j + 9, k + 13, Blocks.air);
		
		world.setBlock(i + 17, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 17, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 17, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 17, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 17, j + 10, k + 4, Blocks.air);
		world.setBlock(i + 17, j + 10, k + 5, Blocks.air);
		
		world.setBlock(i + 17, j + 10, k + 11, Blocks.air);
		world.setBlock(i + 17, j + 10, k + 12, Blocks.air);
		world.setBlock(i + 17, j + 10, k + 13, Blocks.air);
		world.setBlock(i + 17, j + 10, k + 14, Blocks.air);
		
		world.setBlock(i + 17, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 17, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 17, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 17, j + 11, k + 3, Blocks.air);
		world.setBlock(i + 17, j + 11, k + 4, Blocks.air);
		
		world.setBlock(i + 17, j + 11, k + 12, Blocks.air);
		world.setBlock(i + 17, j + 11, k + 13, Blocks.air);
		world.setBlock(i + 17, j + 11, k + 14, Blocks.air);
		
		world.setBlock(i + 17, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 17, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 17, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 17, j + 12, k + 3, Blocks.air);
		world.setBlock(i + 17, j + 12, k + 4, Blocks.air);
		
		world.setBlock(i + 17, j + 12, k + 12, Blocks.air);
		world.setBlock(i + 17, j + 12, k + 13, Blocks.air);
		world.setBlock(i + 17, j + 12, k + 14, Blocks.air);
		
		world.setBlock(i + 18, j + 6, k + 3, Blocks.air);
		world.setBlock(i + 18, j + 6, k + 4, Blocks.air);
		world.setBlock(i + 18, j + 6, k + 5, Blocks.air);
		world.setBlock(i + 18, j + 6, k + 6, Blocks.air);
		world.setBlock(i + 18, j + 6, k + 7, Blocks.air);
		world.setBlock(i + 18, j + 6, k + 8, Blocks.air);
		world.setBlock(i + 18, j + 6, k + 9, Blocks.air);
		
		world.setBlock(i + 18, j + 7, k + 1, Blocks.air);
		world.setBlock(i + 18, j + 7, k + 2, Blocks.air);
		world.setBlock(i + 18, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 18, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 18, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 18, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 18, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 18, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 18, j + 7, k + 9, Blocks.air);
		world.setBlock(i + 18, j + 7, k + 10, Blocks.air);
		world.setBlock(i + 18, j + 7, k + 11, Blocks.air);
		
		world.setBlock(i + 18, j + 8, k + 0, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 1, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 6, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 7, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 8, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 9, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 10, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 11, Blocks.air);
		world.setBlock(i + 18, j + 8, k + 12, Blocks.air);
		
		world.setBlock(i + 18, j + 9, k + 0, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 5, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 6, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 7, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 8, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 9, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 10, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 11, Blocks.air);
		world.setBlock(i + 18, j + 9, k + 12, Blocks.air);
		
		world.setBlock(i + 18, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 4, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 5, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 6, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 7, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 8, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 9, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 10, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 11, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 12, Blocks.air);
		world.setBlock(i + 18, j + 10, k + 13, Blocks.air);
		
		world.setBlock(i + 18, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 18, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 18, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 18, j + 11, k + 3, Blocks.air);
		world.setBlock(i + 18, j + 11, k + 4, Blocks.air);
		world.setBlock(i + 18, j + 11, k + 5, Blocks.air);
		world.setBlock(i + 18, j + 11, k + 6, Blocks.air);
		
		world.setBlock(i + 18, j + 11, k + 10, Blocks.air);
		world.setBlock(i + 18, j + 11, k + 11, Blocks.air);
		world.setBlock(i + 18, j + 11, k + 12, Blocks.air);
		world.setBlock(i + 18, j + 11, k + 13, Blocks.air);
		
		world.setBlock(i + 18, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 18, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 18, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 18, j + 12, k + 3, Blocks.air);
		world.setBlock(i + 18, j + 12, k + 4, Blocks.air);
		world.setBlock(i + 18, j + 12, k + 5, Blocks.air);
		
		world.setBlock(i + 18, j + 12, k + 11, Blocks.air);
		world.setBlock(i + 18, j + 12, k + 12, Blocks.air);
		world.setBlock(i + 18, j + 12, k + 13, Blocks.air);
		
		world.setBlock(i + 19, j + 7, k + 3, Blocks.air);
		world.setBlock(i + 19, j + 7, k + 4, Blocks.air);
		world.setBlock(i + 19, j + 7, k + 5, Blocks.air);
		world.setBlock(i + 19, j + 7, k + 6, Blocks.air);
		world.setBlock(i + 19, j + 7, k + 7, Blocks.air);
		world.setBlock(i + 19, j + 7, k + 8, Blocks.air);
		world.setBlock(i + 19, j + 7, k + 9, Blocks.air);
		
		world.setBlock(i + 19, j + 8, k + 2, Blocks.air);
		world.setBlock(i + 19, j + 8, k + 3, Blocks.air);
		world.setBlock(i + 19, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 19, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 19, j + 8, k + 6, Blocks.air);
		world.setBlock(i + 19, j + 8, k + 7, Blocks.air);
		world.setBlock(i + 19, j + 8, k + 8, Blocks.air);
		world.setBlock(i + 19, j + 8, k + 9, Blocks.air);
		world.setBlock(i + 19, j + 8, k + 10, Blocks.air);
		
		world.setBlock(i + 19, j + 9, k + 1, Blocks.air);
		world.setBlock(i + 19, j + 9, k + 2, Blocks.air);
		world.setBlock(i + 19, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 19, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 19, j + 9, k + 5, Blocks.air);
		world.setBlock(i + 19, j + 9, k + 6, Blocks.air);
		world.setBlock(i + 19, j + 9, k + 7, Blocks.air);
		world.setBlock(i + 19, j + 9, k + 8, Blocks.air);
		world.setBlock(i + 19, j + 9, k + 9, Blocks.air);
		world.setBlock(i + 19, j + 9, k + 10, Blocks.air);
		world.setBlock(i + 19, j + 9, k + 11, Blocks.air);
		
		world.setBlock(i + 19, j + 10, k + 0, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 1, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 4, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 5, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 6, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 7, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 8, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 9, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 10, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 11, Blocks.air);
		world.setBlock(i + 19, j + 10, k + 12, Blocks.air);
		
		world.setBlock(i + 19, j + 11, k + 0, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 3, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 4, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 5, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 6, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 7, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 8, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 9, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 10, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 11, Blocks.air);
		world.setBlock(i + 19, j + 11, k + 12, Blocks.air);
		
		world.setBlock(i + 19, j + 12, k + 0, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 3, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 4, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 5, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 6, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 7, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 8, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 9, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 10, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 11, Blocks.air);
		world.setBlock(i + 19, j + 12, k + 12, Blocks.air);
		
		generate4(world, rand, i, j, k);
		return true;
	}
	
	public boolean generate4(World world, Random rand, int i, int j, int k) {
		
		world.setBlock(i + 20, j + 8, k + 4, Blocks.air);
		world.setBlock(i + 20, j + 8, k + 5, Blocks.air);
		world.setBlock(i + 20, j + 8, k + 6, Blocks.air);
		world.setBlock(i + 20, j + 8, k + 7, Blocks.air);
		world.setBlock(i + 20, j + 8, k + 8, Blocks.air);
		
		world.setBlock(i + 20, j + 9, k + 3, Blocks.air);
		world.setBlock(i + 20, j + 9, k + 4, Blocks.air);
		world.setBlock(i + 20, j + 9, k + 5, Blocks.air);
		world.setBlock(i + 20, j + 9, k + 6, Blocks.air);
		world.setBlock(i + 20, j + 9, k + 7, Blocks.air);
		world.setBlock(i + 20, j + 9, k + 8, Blocks.air);
		world.setBlock(i + 20, j + 9, k + 9, Blocks.air);
		
		world.setBlock(i + 20, j + 10, k + 2, Blocks.air);
		world.setBlock(i + 20, j + 10, k + 3, Blocks.air);
		world.setBlock(i + 20, j + 10, k + 4, Blocks.air);
		world.setBlock(i + 20, j + 10, k + 5, Blocks.air);
		world.setBlock(i + 20, j + 10, k + 6, Blocks.air);
		world.setBlock(i + 20, j + 10, k + 7, Blocks.air);
		world.setBlock(i + 20, j + 10, k + 8, Blocks.air);
		world.setBlock(i + 20, j + 10, k + 9, Blocks.air);
		world.setBlock(i + 20, j + 10, k + 10, Blocks.air);
		
		world.setBlock(i + 20, j + 11, k + 1, Blocks.air);
		world.setBlock(i + 20, j + 11, k + 2, Blocks.air);
		world.setBlock(i + 20, j + 11, k + 3, Blocks.air);
		world.setBlock(i + 20, j + 11, k + 4, Blocks.air);
		world.setBlock(i + 20, j + 11, k + 5, Blocks.air);
		world.setBlock(i + 20, j + 11, k + 6, Blocks.air);
		world.setBlock(i + 20, j + 11, k + 7, Blocks.air);
		world.setBlock(i + 20, j + 11, k + 8, Blocks.air);
		world.setBlock(i + 20, j + 11, k + 9, Blocks.air);
		world.setBlock(i + 20, j + 11, k + 10, Blocks.air);
		world.setBlock(i + 20, j + 11, k + 11, Blocks.air);
		
		world.setBlock(i + 20, j + 12, k + 1, Blocks.air);
		world.setBlock(i + 20, j + 12, k + 2, Blocks.air);
		world.setBlock(i + 20, j + 12, k + 3, Blocks.air);
		world.setBlock(i + 20, j + 12, k + 4, Blocks.air);
		world.setBlock(i + 20, j + 12, k + 5, Blocks.air);
		world.setBlock(i + 20, j + 12, k + 6, Blocks.air);
		world.setBlock(i + 20, j + 12, k + 7, Blocks.air);
		world.setBlock(i + 20, j + 12, k + 8, Blocks.air);
		world.setBlock(i + 20, j + 12, k + 9, Blocks.air);
		world.setBlock(i + 20, j + 12, k + 10, Blocks.air);
		world.setBlock(i + 20, j + 12, k + 11, Blocks.air);
		
		world.setBlock(i + 21, j + 10, k + 5, Blocks.air);
		world.setBlock(i + 21, j + 10, k + 6, Blocks.air);
		world.setBlock(i + 21, j + 10, k + 7, Blocks.air);
		
		world.setBlock(i + 21, j + 11, k + 4, Blocks.air);
		world.setBlock(i + 21, j + 11, k + 5, Blocks.air);
		world.setBlock(i + 21, j + 11, k + 6, Blocks.air);
		world.setBlock(i + 21, j + 11, k + 7, Blocks.air);
		world.setBlock(i + 21, j + 11, k + 8, Blocks.air);
		
		world.setBlock(i + 21, j + 12, k + 3, Blocks.air);
		world.setBlock(i + 21, j + 12, k + 4, Blocks.air);
		world.setBlock(i + 21, j + 12, k + 5, Blocks.air);
		world.setBlock(i + 21, j + 12, k + 6, Blocks.air);
		world.setBlock(i + 21, j + 12, k + 7, Blocks.air);
		world.setBlock(i + 21, j + 12, k + 8, Blocks.air);
		world.setBlock(i + 21, j + 12, k + 9, Blocks.air);
		
		return true;
	}
}