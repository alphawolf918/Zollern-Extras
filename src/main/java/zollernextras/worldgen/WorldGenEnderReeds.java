package zollernextras.worldgen;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollernextras.blocks.BlockList;

public class WorldGenEnderReeds extends WorldGenerator {
	
	@Override
	public boolean generate(World p_76484_1_, Random p_76484_2_,
			int p_76484_3_, int p_76484_4_, int p_76484_5_) {
		for (int l = 0; l < 20; ++l) {
			int i1 = p_76484_3_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
			int j1 = p_76484_4_;
			int k1 = p_76484_5_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
			
			int l1 = 2 + p_76484_2_.nextInt(p_76484_2_.nextInt(3) + 1);
			
			for (int i2 = 0; i2 < l1; ++i2) {
				if (BlockList.enderReeds.canBlockStay(p_76484_1_, i1, j1 + i2,
						k1)) {
					p_76484_1_.setBlock(i1, j1 + i2, k1, BlockList.enderReeds,
							0, 2);
				}
			}
		}
		return true;
	}
}