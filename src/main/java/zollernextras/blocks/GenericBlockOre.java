package zollernextras.blocks;

import net.minecraft.item.ItemStack;
import zollernextras.api.ores.IOre;

public class GenericBlockOre extends GenericBlock implements IOre {
	
	public GenericBlockOre(String strTexture, float resistHardness) {
		super(strTexture, resistHardness);
		this.setHarvestLevel("pickaxe", 4);
	}
	
	@Override
	public double getFortune() {
		return .02D;
	}
	
	@Override
	public int getMaxDropIncrease() {
		return 2;
	}
	
	@Override
	public ItemStack getDroppedItemStack() {
		return new ItemStack(this);
	}
	
}