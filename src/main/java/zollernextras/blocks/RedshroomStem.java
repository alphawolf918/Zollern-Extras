package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ModInfo;

public class RedshroomStem extends Block {
	public RedshroomStem() {
		super(Material.rock);
		this.setCreativeTab(ModTabs.zTab);
		this.setBlockName(ModInfo.MODID + "_redshroomstem");
		this.setBlockTextureName(ModInfo.MODID + ":" + "redstem");
		this.setHardness(1.2F);
		this.setResistance(0F);
	}
}