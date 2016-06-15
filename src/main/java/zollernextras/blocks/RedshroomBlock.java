package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class RedshroomBlock extends Block {
	public RedshroomBlock() {
		super(Material.rock);
		MainHelper.setTab(this);
		MainHelper.setName(this, "redshroomblock");
		MainHelper.setTexture(this, "shroomblock");
		this.setHardness(1.0F);
		this.setResistance(0F);
		this.setHarvestLevel("pickaxe", 0);
	}
}