package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.lib.ModInfo;

public class SwampClay extends Block {
	public SwampClay() {
		super(Material.clay);
		this.setCreativeTab(ModTabs.zTab);
		this.setBlockName(ModInfo.MODID + "_swampclay");
		this.setHardness(1.5F);
		this.setResistance(0.1F);
		this.setBlockTextureName(ModInfo.MODID + ":" + "swampclay");
		this.setHarvestLevel("shovel", 0);
		this.setStepSound(this.soundTypeGravel);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ItemList.swampClayBall;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 4;
	}
}