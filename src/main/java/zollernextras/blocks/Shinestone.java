package zollernextras.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import zollernextras.items.ItemList;
import zollernextras.lib.MainHelper;
import zollernextras.lib.ModInfo;

public class Shinestone extends Block {
	public Shinestone() {
		super(Material.glass);
		MainHelper.setTab(this);
		setBlockName(ModInfo.MODID + "_shinestone");
		setHardness(0.6F);
		setResistance(2.0F);
		setLightLevel(1.0F);
		setStepSound(soundTypeGlass);
		setBlockTextureName(ModInfo.MODID + ":" + "shinestone");
	}
	
	@Override
	public boolean canSilkHarvest() {
		return true;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ItemList.shinedust;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		int r = par1Random.nextInt(4);
		r = r == 0 ? 1 : r;
		return r;
	}
}