package zollernextras.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class ZollernWorldGenMaster extends WorldGenerator {
	
	/**
	 * Should set a block at the world and tell you where it does a put.
	 * 
	 * @param world
	 *            Do I really have to explain this part?
	 * @param pos
	 *            The position to add to. Add it as 0, 0, 0 and then increment
	 *            as needed.
	 * @param block
	 *            Use the block, not the block state. Method handles this
	 *            internally.
	 */
	protected void setBlock(World world, BlockPos pos, Block block) {
		world.setBlockState(pos, block.getDefaultState());
	}
	
	/**
	 * Should set a block at the world and tell you where it does a put.
	 * 
	 * @param world
	 * @param pos
	 * @param blockState
	 */
	protected void setBlock(World world, BlockPos pos, IBlockState blockState) {
		world.setBlockState(pos, blockState);
	}
	
	/**
	 * Set a block using a more direct approach.
	 * 
	 * @param world
	 * @param pos
	 * @param x
	 * @param y
	 * @param z
	 * @param block
	 */
	protected void setBlock(World world, BlockPos pos, int x, int y, int z,
			Block block) {
		this.setBlock(world, pos.add(x, y, z), block);
	}
	
}