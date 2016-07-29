package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class BarrierBlock extends Block {
	public BarrierBlock() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "barrier", "barrierblock");
		this.setBlockUnbreakable();
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}