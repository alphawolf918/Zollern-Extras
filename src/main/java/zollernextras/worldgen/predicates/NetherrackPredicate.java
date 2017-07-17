package zollernextras.worldgen.predicates;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import com.google.common.base.Predicate;

public class NetherrackPredicate implements Predicate<IBlockState> {
	
	public NetherrackPredicate() {
		
	}
	
	@Override
	public boolean apply(IBlockState p_apply_1_) {
		if (p_apply_1_ != null && p_apply_1_.getBlock() == Blocks.NETHERRACK) {
			return true;
		}
		return false;
	}
}