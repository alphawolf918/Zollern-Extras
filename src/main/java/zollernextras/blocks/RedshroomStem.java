package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.MainHelper;

public class RedshroomStem extends Block {
	public RedshroomStem() {
		super(Material.rock);
		MainHelper.setTab(this);
		MainHelper.setName(this, "redshroomstem");
		MainHelper.setTexture(this, "redstem");
		this.setHardness(1.0F);
		this.setResistance(0F);
		this.setHarvestLevel("pickaxe", 0);
	}
}