package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class BarrierBlock extends Block {
	public BarrierBlock() {
		super(Material.rock);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "barrier", "barrierblock");
		this.setBlockUnbreakable();
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}