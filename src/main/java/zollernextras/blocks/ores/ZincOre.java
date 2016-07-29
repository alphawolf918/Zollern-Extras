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

public class ZincOre extends Block implements IOre {
	
	public ZincOre() {
		super(Material.rock);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, "zincore");
		ZollernHelper.setHardResist(this, 1.6F, 9.2F);
		this.setHarvestLevel("pickaxe", 4);
		this.setStepSound(soundTypePiston);
		this.setHardness(1.6F);
		this.setResistance(9.2F);
	}
	
	private Random rand = new Random();
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, 8, 11);
			
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
		return new ItemStack(this);
	}
}