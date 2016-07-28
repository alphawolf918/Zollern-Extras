package zollernextras.dimension.upsidedown;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenMinable;
import zollernextras.blocks.BlockList;

public class WorldGenUpsideDownMinable extends WorldGenMinable {
	
	public WorldGenUpsideDownMinable(Block par1, int par2) {
		super(par1, par2, BlockList.upsideDownStone);
	}
	
	public WorldGenUpsideDownMinable(Block par1, int par2, int par3) {
		super(par1, par2);
	}
}