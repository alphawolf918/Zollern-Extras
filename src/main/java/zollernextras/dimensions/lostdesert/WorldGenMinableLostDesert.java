package zollernextras.dimensions.lostdesert;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenMinable;
import zollernextras.blocks.BlockList;

public class WorldGenMinableLostDesert extends WorldGenMinable {
	
	public WorldGenMinableLostDesert(Block par1, int par2) {
		super(par1, par2, BlockList.wonderStone);
	}
	
	public WorldGenMinableLostDesert(Block par1, int par2, int par3) {
		super(par1, par2);
	}
}