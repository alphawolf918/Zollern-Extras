package zollernextras.blocks.ores.ender;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import zollernextras.api.ores.IOre;
import zollernextras.lib.MainHelper;

public class EnderZincOre extends Block implements IOre {
	
	public EnderZincOre() {
		super(Material.rock);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, "enderzincore");
		MainHelper.setHardResist(this, 2.5F, 4.2F);
		this.setHarvestLevel("pickaxe", 4);
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
		return 0.09D;
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