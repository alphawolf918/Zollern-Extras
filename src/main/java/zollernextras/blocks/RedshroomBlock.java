package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class RedshroomBlock extends Block {
	public RedshroomBlock() {
		super(Material.rock);
		this.setCreativeTab(ModTabs.zTab);
		this.setBlockName(Reference.MODID + "_redshroomblock");
		this.setBlockTextureName(Reference.MODID + ":" + "shroomblock");
		this.setHardness(1.2F);
		this.setResistance(0F);
	}
}