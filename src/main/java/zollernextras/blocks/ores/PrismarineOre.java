package zollernextras.blocks.ores;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import zollernextras.api.ores.IOre;
import zollernextras.items.ZollernItems;
import zollernextras.lib.ZollernHelper;

public class PrismarineOre extends Block implements IOre {
	
	public Item droppedItem = ZollernItems.prismarineCrystal;
	
	public PrismarineOre() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "prismarineore");
		ZollernHelper.setHardResist(this, 1.0F, 4.2F);
		this.setStepSound(soundTypePiston);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return this.droppedItem;
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
			j1 = MathHelper.getRandomIntegerInRange(rand, 8, 16);
			
			return j1;
		}
		return 0;
	}
	
	@Override
	public double getFortune() {
		return 0.05D;
	}
	
	@Override
	public int getMaxDropIncrease() {
		return 2;
	}
	
	@Override
	public ItemStack getDroppedItemStack() {
		return new ItemStack(this.droppedItem);
	}
}