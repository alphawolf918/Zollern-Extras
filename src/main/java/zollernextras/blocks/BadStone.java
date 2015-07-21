package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class BadStone extends Block {
	public BadStone() {
		super(Material.rock);
		MainHelper.setTab(this);
		this.setHardness(1.6F);
		this.setResistance(5.0F);
		MainHelper.setNameAndTexture(this, "badstone");
	}
}