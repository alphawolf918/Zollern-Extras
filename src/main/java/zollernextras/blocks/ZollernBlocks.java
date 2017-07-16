package zollernextras.blocks;

import net.minecraft.block.Block;
import zollernextras.items.ZollernItems;
import zollernextras.lib.ZollernHelper;

public class ZollernBlocks {
	
	public static final Block superChargedCoalBlock = new ZollernBlockBase(
			"superchargedcoalblock", 1.0F);
	public static final Block superChargedCoalOre = ((ZollernBlockOre) new ZollernBlockOre(
			"superchargedcoalore", 1.5F)
			.setItemDropped(ZollernItems.superChargedCoal))
			.setAmountDropped(ZollernHelper.rngNumber(2, 4));
	
}