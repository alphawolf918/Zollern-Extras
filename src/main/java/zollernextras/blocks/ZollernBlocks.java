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
			"azuriteblock").setLightLevel(1.0F);
	public static final Block azuriteOre = ((ZollernBlockOre) new ZollernGemOre(
			"azuriteore", 3.2F).setLightLevel(0.6F))
			.setItemDropped(ZollernItems.azurite);
	
	// Ender Shard
	public static final Block enderPearlBlock = new ZollernBlockMetal(
			"enderpearlblock").setLightLevel(2.0F);
	public static final Block enderShardOre = new ZollernGemOre(
			"endershardore", 2.5F).setItemDropped(ZollernItems.enderShard);
	public static final Block netherEnderShardOre = ((ZollernBlockOre) new ZollernGemOre(
			"netherendershardore", 2.5F)
			.setItemDropped(ZollernItems.enderShard))
			.setBlockVariant(EnumBlockVariant.NETHER);
	
	// Amber
	public static final Block amberBlock = new ZollernBlockMetal("amberblock");
	public static final Block amberOre = new ZollernGemOre("amberore", 1.4F)
			.setItemDropped(ZollernItems.amber);
	
	// Aquamarine
	public static final Block aquamarineBlock = new ZollernBlockMetal(
			"aquamarineblock");
	public static final Block aquamarineOre = new ZollernGemOre(
			"aquamarineore", 1.5F).setItemDropped(ZollernItems.aquamarine);
	
	// Garnet
	public static final Block garnetBlock = new ZollernBlockMetal("garnetblock");
	public static final Block garnetOre = new ZollernGemOre("garnetore", 1.6F)
			.setItemDropped(ZollernItems.garnet);
	
	// Fueltonium
	public static final Block fueltoniumBlock = new ZollernBlockMetal(
			"fueltoniumblock");
	public static final Block fueltoniumOre = new ZollernGemOre(
			"fueltoniumore", 3.5F).setItemDropped(ZollernItems.fuelonite);
	public static final Block netherFueltoniumOre = ((ZollernBlockOre) new ZollernGemOre(
			"netherfueltoniumore", 3.5F).setItemDropped(ZollernItems.fuelonite))
			.setBlockVariant(EnumBlockVariant.NETHER);
	public static final Block enderFueltoniumOre = ((ZollernBlockOre) new ZollernGemOre(
			"enderfueltoniumore", 3.5F).setItemDropped(ZollernItems.fuelonite))
			.setBlockVariant(EnumBlockVariant.END);
	
	// Zinc
	public static final Block zincBlock = new ZollernBlockMetal("zincblock");
	public static final Block zincOre = new ZollernBlockOre("zincore", 3.2F);
	public static final Block netherZincOre = new ZollernBlockOre(
			"netherzincore", 3.2F).setBlockVariant(EnumBlockVariant.NETHER);
	public static final Block enderZincOre = new ZollernBlockOre(
			"enderzincore", 3.2F).setBlockVariant(EnumBlockVariant.END);
	
	// Topaz
	public static final Block topazBlock = new ZollernBlockMetal("topazblock");
	public static final Block topazOre = new ZollernGemOre("topazore", 1.2F)
			.setItemDropped(ZollernItems.topaz);
	
	// Ruby
	public static final Block rubyBlock = new ZollernBlockMetal("rubyblock");
	public static final Block rubyOre = new ZollernGemOre("rubyore", 1.2F)
			.setItemDropped(ZollernItems.ruby);
	
	// Sapphire
	public static final Block sapphireBlock = new ZollernBlockMetal(
			"sapphireblock");
	public static final Block sapphireOre = new ZollernGemOre("sapphireore",
			1.2F).setItemDropped(ZollernItems.sapphire);
	
	// Opal
	public static final Block opalBlock = new ZollernBlockMetal("opalblock");
	public static final Block opalOre = new ZollernGemOre("opalore", 1.2F)
			.setItemDropped(ZollernItems.opal);
	
	// Witherite
	public static final Block witheriteBlock = new ZollernBlockMetal(
			"witheriteblock");
	public static final Block witheriteOre = new ZollernGemOre("witheriteore",
			2.0F).setItemDropped(ZollernItems.witherite);
	
	// Zollernium
	public static final Block zollerniumBlock = new ZollernBlockMetal(
			"zollerniumblock");
	public static final Block zollerniumOre = new ZollernBlockOre(
			"zollerniumore", 5.0F);
	
	// Steel
	public static final Block steelBlock = new ZollernBlockMetal("steelblock");
	public static final Block steelOre = new ZollernBlockOre("steelore", 4.5F);
	public static final Block netherSteelOre = new ZollernBlockOre(
			"nethersteelore", 4.6F).setBlockVariant(EnumBlockVariant.NETHER);
	public static final Block enderSteelOre = new ZollernBlockOre(
			"endersteelore", 4.7F).setBlockVariant(EnumBlockVariant.END);
	
	// Enderite
	public static final Block enderiteBlock = new ZollernBlockMetal(
			"enderiteblock");
	public static final Block enderiteOre = new ZollernBlockOre("enderiteore",
			2.4F).setBlockVariant(EnumBlockVariant.END);
	
	// Etrium
	
	/*
	 * Upside-Down
	 */
	
	// Radium
	
}