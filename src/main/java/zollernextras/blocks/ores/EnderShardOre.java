package zollernextras.blocks.ores;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import zollernextras.creativetabs.ModTabs;
import zollernextras.items.ItemList;
import zollernextras.lib.Reference;

public class EnderShardOre extends Block {
	public EnderShardOre() {
		super(Material.rock);
		this.setCreativeTab(ModTabs.zTab);
		this.setBlockName(Reference.MODID + "_endershardore");
		this.setHardness(0.3F);
		this.setStepSound(this.soundTypeGlass);
		this.setBlockTextureName(Reference.MODID + ":" + "endershardore");
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypePiston);
		this.setHardness(6.0F);
		this.setResistance(9.2F);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ItemList.enderShard;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		if (p_149745_1_.nextInt(10) > 5) {
			return 2;
		} else {
			return 1;
		}
	}
	
	private Random rand = new Random();
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, 4, 8);
			
			return j1;
		}
		return 0;
	}
}