package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ModInfo;

public class CaveMarble extends Block {
	public CaveMarble(String strName) {
		super(Material.iron);
		this.setCreativeTab(ModTabs.zTab);
		this.setBlockName("zollernextras_" + strName);
		// this.setLightLevel(0.8F);
		this.setHardness(2.6F);
		this.setResistance(4.9F);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockTextureName(ModInfo.MODID + ":" + strName);
		this.setHarvestLevel("pickaxe", 2);
	}
}