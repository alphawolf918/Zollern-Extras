package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class BarrierBlock extends Block {
	public BarrierBlock() {
		super(Material.rock);
		M.setTab(this);
		M.setNameAndTexture(this, "barrier", "barrierblock");
		this.setBlockUnbreakable();
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}