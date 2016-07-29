package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class BadStone extends Block {
	public BadStone() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		this.setHardness(1.4F);
		this.setResistance(5.0F);
		ZollernHelper.setNameAndTexture(this, "badstone");
		this.setHarvestLevel("pickaxe", 1);
	}
}