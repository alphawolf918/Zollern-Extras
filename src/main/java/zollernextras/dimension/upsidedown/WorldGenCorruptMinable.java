package zollernextras.dimension.upsidedown;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenMinable;
import zollernextras.blocks.ZollernBlocks;

public class WorldGenCorruptMinable extends WorldGenMinable {
	
	public WorldGenCorruptMinable(Block par1, int par2) {
		super(par1, par2, ZollernBlocks.corruptStone);
	}
	
	public WorldGenCorruptMinable(Block par1, int par2, int par3) {
		super(par1, par2);
	}
}