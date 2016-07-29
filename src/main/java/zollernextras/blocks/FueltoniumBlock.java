package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.ZollernHelper;

public class FueltoniumBlock extends Block {
	public FueltoniumBlock() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "fueltoniumblock");
		this.setHardness(1.8F);
		this.setResistance(8.0F);
		this.setHarvestLevel("pickaxe", 2);
	}
}