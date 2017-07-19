package zollernextras.blocks;

import net.minecraft.block.Block;
import zollernextras.items.ZollernItems;
import zollernextras.lib.EnumBlockVariant;

public class ZollernBlocks {
	
	public static final Block superChargedCoalBlock = new ZollernBlockBase(
			"superchargedcoalblock", 1.0F);
	public static final Block superChargedCoalOre = ((ZollernGemOre) new ZollernGemOre(
			"superchargedcoalore", 1.5F)
			.setItemDropped(ZollernItems.superChargedCoal)).setMinMaxDropped(1,
			4);
	public static final Block netherSuperChargedCoalOre = ((ZollernBlockOre) (new ZollernGemOre(
			"nethersuperchargedcoalore", 1.8F))
			.setItemDropped(ZollernItems.superChargedCoal))
			.setBlockVariant(EnumBlockVariant.NETHER);
	public static final Block enderSuperChargedCoalOre = ((ZollernGemOre) new ZollernGemOre(
			"endersuperchargedcoalore", 2.1F)
			.setItemDropped(ZollernItems.superChargedCoal))
			.setBlockVariant(EnumBlockVariant.END);
	
}