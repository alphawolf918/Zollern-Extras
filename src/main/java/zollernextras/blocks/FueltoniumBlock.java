package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;

public class FueltoniumBlock extends Block {
	public FueltoniumBlock() {
		super(Material.rock);
		M.setTab(this);
		M.setNameAndTexture(this, "fueltoniumblock");
		this.setHardness(8.0F);
		this.setResistance(8.0F);
		this.setHarvestLevel("pickaxe", 2);
	}
}