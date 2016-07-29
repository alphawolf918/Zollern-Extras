package zollernextras.blocks.ores;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import zollernextras.api.ores.IOre;
import zollernextras.lib.ZollernHelper;

public class GemOre extends Block implements IOre {
	
	protected Item dropItem;
	
	public GemOre(String name, Item itemToDrop) {
		super(Material.rock);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, name);
		ZollernHelper.setHardResist(this, 1.5F, 4.2F);
		this.dropItem = itemToDrop;
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypePiston);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return this.dropItem;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		if (p_149745_1_.nextInt(10) == 2) {
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
			j1 = MathHelper.getRandomIntegerInRange(rand, 8, 10);
			
			return j1;
		}
		return 0;
	}
	
	@Override
	public double getFortune() {
		return 0.04D;
	}
	
	@Override
	public int getMaxDropIncrease() {
		return 4;
	}
	
	@Override
	public ItemStack getDroppedItemStack() {
		return new ItemStack(this.dropItem);
	}
}