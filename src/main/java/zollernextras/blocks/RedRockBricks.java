package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class RedRockBricks extends Block {
	public RedRockBricks() {
		super(Material.rock);
		MainHelper.setTab(this);
		this.setHardness(0.5F);
		this.setResistance(10F);
		MainHelper.setNameAndTexture(this, "redrockbricks", "redrockbrick");
		this.setHarvestLevel("pickaxe", 1);
	}
}