package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class RedshroomStem extends Block {
	public RedshroomStem() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		ZollernHelper.setName(this, "redshroomstem");
		ZollernHelper.setTexture(this, "redstem");
		this.setHardness(1.0F);
		this.setResistance(0F);
		this.setHarvestLevel("pickaxe", 0);
	}
}