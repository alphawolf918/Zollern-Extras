package zollernextras.blocks;

import net.minecraft.block.Block;
import zollernextras.items.ZollernItems;

public class ZollernBlocks {
	
	public static final Block superChargedCoalBlock = new ZollernBlockBase(
			"superchargedcoalblock", 1.0F);
	public static final Block superChargedCoalOre = ((ZollernGemOre) new ZollernGemOre(
			"superchargedcoalore", 1.5F)
			.setItemDropped(ZollernItems.superChargedCoal)).setMinMaxDropped(1,
			4);
	public static final Block netherSuperChargedCoalOre = ((new ZollernGemOre(
			"nethersuperchargedcoalore", 1.8F))
			.setItemDropped(ZollernItems.superChargedCoal));
	
}