package zollernextras.worldgen.minable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenMinable;
import zollernextras.worldgen.predicates.NetherrackPredicate;

public class WorldGenNetherMinable extends WorldGenMinable {
	
	public WorldGenNetherMinable(IBlockState state, int blockCount) {
		super(state, blockCount, new NetherrackPredicate());
	}
}