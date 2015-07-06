package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class BadStone extends Block {
	public BadStone() {
		super(Material.rock);
		M.setTab(this);
		this.setHardness(1.6F);
		this.setResistance(5.0F);
		M.setNameAndTexture(this, "badstone");
	}
}