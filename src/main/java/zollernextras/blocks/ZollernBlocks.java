package zollernextras.blocks;

import net.minecraft.block.Block;
import zollernextras.items.ZollernItems;
import zollernextras.lib.EnumBlockVariant;

public class ZollernBlocks {
	
	// Super Charged Coal
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
	
	// Amaranth
	public static final Block amaranthBlock = new ZollernBlockMetal(
			"amaranthblock");
	public static final Block amaranthOre = new ZollernBlockOre("amaranthore",
			1.9F);
	public static final Block netherAmaranthOre = new ZollernBlockOre(
			"netheramaranthore", 1.9F).setBlockVariant(EnumBlockVariant.NETHER);
	public static final Block enderAmaranthOre = new ZollernBlockOre(
			"enderamaranthore", 1.9F).setBlockVariant(EnumBlockVariant.END);
	
	// Azurite
	public static final Block azuriteBlock = new ZollernBlockMetal(
			"azuriteblock").setLightLevel(5.0F);
	public static final Block azuriteOre = ((ZollernBlockOre) new ZollernGemOre(
			"azuriteore", 3.2F).setLightLevel(1.5F))
			.setItemDropped(ZollernItems.azurite);
	
	// Amber
	
	// Aquamarine
	
	// Zinc
	
	// Ruby
	
	// Emerald
	
	// Sapphire
	
	// Zollernium
	
}