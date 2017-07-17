package zollernextras.worldgen.minable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenMinable;
import zollernextras.worldgen.predicates.EndstonePredicate;

public class WorldGenEnderMinable extends WorldGenMinable {
	
	public WorldGenEnderMinable(IBlockState state, int blockCount) {
		super(state, blockCount, new EndstonePredicate());
	}
}