package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class CaveMarble extends Block {
	public CaveMarble(String strName) {
		super(Material.iron);
		this.setCreativeTab(ModTabs.zTab);
		this.setBlockName("zollernextras_" + strName);
		this.setLightLevel(0.8F);
		this.setHardness(3.6F);
		this.setResistance(9.9F);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockTextureName(Reference.MODID + ":" + strName);
		this.setHarvestLevel("pickaxe", 2);
	}
}