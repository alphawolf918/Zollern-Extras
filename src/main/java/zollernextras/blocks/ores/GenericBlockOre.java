package zollernextras.blocks.ores;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import zollernextras.api.ores.IOre;
import zollernextras.blocks.GenericBlock;

public class GenericBlockOre extends GenericBlock implements IOre {
	
	public double oreFortune = 0.4D;
	public int oreMaxDropIncrease = 4;
	
	public GenericBlockOre(String strTexture, float resistHardness) {
		super(strTexture, resistHardness);
		this.setHarvestLevel("pickaxe", 4);
	}
	
	@Override
	public double getFortune() {
		return this.oreFortune;
	}
	
	@Override
	public int getMaxDropIncrease() {
		return this.oreMaxDropIncrease;
	}
	
	public Block setFortune(double maxFortune) {
		this.oreFortune = maxFortune;
		return this;
	}
	
	public Block setMaxDropIncrease(int maxIncrease) {
		this.oreMaxDropIncrease = maxIncrease;
		return this;
	}
	
	@Override
	public ItemStack getDroppedItemStack() {
		return new ItemStack(this);
	}
	
}