package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class SPCBlock extends Block {
	public SPCBlock() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "spcblock");
		this.setHardness(8.0F);
		this.setResistance(7.0F);
		this.setHarvestLevel("pickaxe", 2);
	}
}