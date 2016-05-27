package zollernextras.blocks.trees;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.ModInfo;

public class ZollernPlanks extends Block {
	
	public ZollernPlanks(String planksTexture) {
		super(Material.wood);
		this.setCreativeTab(ModTabs.zTab);
		this.setBlockName(ModInfo.MODID + "_" + planksTexture);
		this.setBlockTextureName(ModInfo.MODID + ":" + planksTexture);
		this.setHardness(2.0F);
		this.setResistance(4.0F);
		this.setStepSound(soundTypeWood);
	}
}