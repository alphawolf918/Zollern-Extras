package zollernextras.worldgen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenMinableNether extends WorldGenMinable {
	
	public WorldGenMinableNether(Block par1, int par2) {
		super(par1, par2, Blocks.netherrack);
	}
	
	public WorldGenMinableNether(Block par1, int par2, int par3) {
		super(par1, par2);
	}
}