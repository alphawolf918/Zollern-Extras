package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.MobEffects;
import zollernextras.items.ZollernItems;
import zollernextras.lib.EnumBlockVariant;

public class ZollernBlocks {
	
	// Super Charged Coal
	public static final Block superChargedCoalBlock = new ZollernBlockBase(
			"superchargedcoalblock", 1.0F);
	public static final Block superChargedCoalOre = new ZollernGemOre(
			"superchargedcoalore", 1.5F, ZollernItems.superChargedCoal)
			.setMinMaxDropped(1, 4);
	public static final Block netherSuperChargedCoalOre = ((ZollernBlockOre) ((new ZollernGemOre(
			"nethersuperchargedcoalore", 1.8F, ZollernItems.superChargedCoal)))
			.setBlockVariant(EnumBlockVariant.NETHER)).setShouldExplode(true);
	public static final Block enderSuperChargedCoalOre = (new ZollernGemOre(
			"endersuperchargedcoalore", 2.1F, ZollernItems.superChargedCoal)
			.setShouldGivePotionEffect(true, MobEffects.BLINDNESS));
	
	// Amaranth
	public static final Block amaranthBlock = new ZollernBlockMetal(
			"amaranthblock");
	public static final Block amaranthOre = new ZollernBlockOre("amaranthore",
			1.9F);
	public static final Block netherAmaranthOre = ((ZollernBlockOre) new ZollernBlockOre(
			"netheramaranthore", 1.9F).setBlockVariant(EnumBlockVariant.NETHER))
			.setShouldExplode(true);
	public static final Block enderAmaranthOre = ((ZollernBlockOre) new ZollernBlockOre(
			"enderamaranthore", 1.9F).setBlockVariant(EnumBlockVariant.END))
			.setShouldGivePotionEffect(true, MobEffects.HUNGER);
	
	// Azurite
	public static final Block azuriteBlock = new ZollernBlockMetal(
			"azuriteblock").setLightLevel(1.0F);
	public static final Block azuriteOre = (new ZollernGemOre("azuriteore",
			3.2F, ZollernItems.azurite).setLightLevel(0.6F));
	
	// Ender Shard
	public static final Block enderPearlBlock = new ZollernBlockMetal(
			"enderpearlblock").setLightLevel(2.0F);
	public static final Block enderShardOre = new ZollernGemOre(
			"endershardore", 2.5F, ZollernItems.enderShard);
	public static final Block netherEnderShardOre = (((ZollernBlockOre) new ZollernGemOre(
			"netherendershardore", 2.5F, ZollernItems.enderShard)
			.setBlockVariant(EnumBlockVariant.NETHER)).setShouldExplode(true));
	
	// Amber
	public static final Block amberBlock = new ZollernBlockMetal("amberblock");
	public static final Block amberOre = new ZollernGemOre("amberore", 1.4F,
			ZollernItems.amber);
	
	// Aquamarine
	public static final Block aquamarineBlock = new ZollernBlockMetal(
			"aquamarineblock");
	public static final Block aquamarineOre = new ZollernGemOre(
			"aquamarineore", 1.5F, ZollernItems.aquamarine);
	
	// Garnet
	public static final Block garnetBlock = new ZollernBlockMetal("garnetblock");
	public static final Block garnetOre = new ZollernGemOre("garnetore", 1.6F,
			ZollernItems.garnet);
	
	// Fueltonium
	public static final Block fueltoniumBlock = new ZollernBlockMetal(
			"fueltoniumblock");
	public static final Block fueltoniumOre = new ZollernGemOre(
			"fueltoniumore", 3.5F, ZollernItems.fuelonite);
	public static final Block netherFueltoniumOre = ((ZollernBlockOre) new ZollernGemOre(
			"netherfueltoniumore", 3.5F, ZollernItems.fuelonite)
			.setShouldExplode(true)).setBlockVariant(EnumBlockVariant.NETHER);
	public static final Block enderFueltoniumOre = (new ZollernGemOre(
			"enderfueltoniumore", 3.5F, ZollernItems.fuelonite)
			.setShouldGivePotionEffect(true, MobEffects.INSTANT_DAMAGE));
	
	// Zinc
	public static final Block zincBlock = new ZollernBlockMetal("zincblock");
	public static final Block zincOre = new ZollernBlockOre("zincore", 3.2F);
	public static final Block netherZincOre = ((ZollernBlockOre) new ZollernBlockOre(
			"netherzincore", 3.2F).setBlockVariant(EnumBlockVariant.NETHER))
			.setShouldExplode(true);
	public static final Block enderZincOre = ((ZollernBlockOre) new ZollernBlockOre(
			"enderzincore", 3.2F).setBlockVariant(EnumBlockVariant.END))
			.setShouldGivePotionEffect(true, MobEffects.MINING_FATIGUE);
	
	// Topaz
	public static final Block topazBlock = new ZollernBlockMetal("topazblock");
	public static final Block topazOre = new ZollernGemOre("topazore", 1.2F,
			ZollernItems.topaz);
	
	// Ruby
	public static final Block rubyBlock = new ZollernBlockMetal("rubyblock");
	public static final Block rubyOre = new ZollernGemOre("rubyore", 1.2F,
			ZollernItems.ruby);
	
	// Sapphire
	public static final Block sapphireBlock = new ZollernBlockMetal(
			"sapphireblock");
	public static final Block sapphireOre = new ZollernGemOre("sapphireore",
			1.2F, ZollernItems.sapphire);
	
	// Opal
	public static final Block opalBlock = new ZollernBlockMetal("opalblock");
	public static final Block opalOre = new ZollernGemOre("opalore", 1.2F,
			ZollernItems.opal);
	
	// Witherite
	public static final Block witheriteBlock = new ZollernBlockMetal(
			"witheriteblock");
	public static final Block witheriteOre = new ZollernGemOre("witheriteore",
			2.0F, ZollernItems.witherite);
	
	// Zollernium
	public static final Block zollerniumBlock = new ZollernBlockMetal(
			"zollerniumblock");
	public static final Block zollerniumOre = new ZollernBlockOre(
			"zollerniumore", 5.0F);
	
	// Steel
	public static final Block steelBlock = new ZollernBlockMetal("steelblock");
	public static final Block steelOre = new ZollernBlockOre("steelore", 4.5F);
	public static final Block netherSteelOre = ((ZollernBlockOre) new ZollernBlockOre(
			"nethersteelore", 4.6F).setBlockVariant(EnumBlockVariant.NETHER))
			.setShouldExplode(true);
	public static final Block enderSteelOre = ((ZollernBlockOre) new ZollernBlockOre(
			"endersteelore", 4.7F).setBlockVariant(EnumBlockVariant.END))
			.setShouldGivePotionEffect(true, MobEffects.LEVITATION);
	
	// Enderite
	public static final Block enderiteBlock = new ZollernBlockMetal(
			"enderiteblock");
	public static final Block enderiteOre = ((ZollernBlockOre) new ZollernBlockOre(
			"enderiteore", 2.4F).setBlockVariant(EnumBlockVariant.END))
			.setShouldGivePotionEffect(true, MobEffects.POISON);
	
	// Ender Diamond
	public static final Block enderDiamondBlock = new ZollernBlockMetal(
			"enderdiamondblock");
	public static final Block enderDiamondOre = ((ZollernBlockOre) new ZollernGemOre(
			"enderdiamondore", 3.6F, ZollernItems.enderDiamond)
			.setShouldGivePotionEffect(true, MobEffects.NAUSEA))
			.setBlockVariant(EnumBlockVariant.END);
	
	/*
	 * Biome & General Blocks
	 */
	
	public static final Block badStone = new ZollernBlockBase("badstone", 0.6F);
	public static final Block redshroomBlock = new ZollernBlockBase(
			"redshroomblock", 0.5F);
	public static final Block redshroomStem = new ZollernBlockBase(
			"redshroomstem", 0.4F);
	
	/*
	 * Upside-Down
	 */
	
	// World blocks
	public static final Block upsideDownSurfaceRock = new ZollernBlockBase(
			"ud_surfacerock", 1.6F);
	public static final Block upsideDownSubRock = new ZollernBlockBase(
			"ud_rock", 1.4F);
	
	// Radium
	
	// Etrium
	
	// Zucrite
	
}