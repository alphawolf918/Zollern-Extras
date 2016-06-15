package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockNetherrack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import zollernextras.lib.MainHelper;

public class Brimstone extends BlockNetherrack {
	public Brimstone() {
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "brimstone");
		this.setHardness(1.4F);
		this.setResistance(10.0F);
		this.setStepSound(Block.soundTypeStone);
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z,
			ForgeDirection side) {
		return true;
	}
}