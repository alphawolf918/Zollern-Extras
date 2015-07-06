package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class SPCBlock extends Block {
	public SPCBlock() {
		super(Material.rock);
		M.setTab(this);
		M.setNameAndTexture(this, "spcblock");
		this.setHardness(8.0F);
		this.setResistance(7.0F);
		this.setHarvestLevel("pickaxe", 2);
	}
}