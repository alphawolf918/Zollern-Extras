package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class RedshroomBlock extends Block {
	public RedshroomBlock() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		ZollernHelper.setName(this, "redshroomblock");
		ZollernHelper.setTexture(this, "shroomblock");
		this.setHardness(1.0F);
		this.setResistance(0F);
		this.setHarvestLevel("pickaxe", 0);
	}
}