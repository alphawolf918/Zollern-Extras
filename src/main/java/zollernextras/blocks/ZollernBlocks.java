package zollernextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import zollernextras.blocks.upsidedown.UpsideDownStone;
import zollernextras.items.ZollernItems;
import zollernextras.lib.EnumBlockVariant;
import zollernextras.lib.EnumHarvestLevel;

public class ZollernBlocks {
	
	// Super Charged Coal
	public static final Block superChargedCoalBlock = new ZollernBlockBase(
			"superchargedcoalblock", 1.0F);
	public static final Block superChargedCoalOre = ((ZollernBlockBase) new ZollernGemOre(
			"superchargedcoalore", 1.5F, ZollernItems.superChargedCoal)
			.setMinMaxDropped(1, 4)).setBlockHarvestLevel("pickaxe",
			EnumHarvestLevel.AMARANTH.getHarvestLevel());
	public static final Block netherSuperChargedCoalOre = ((ZollernBlockOre) ((ZollernBlockOre) ((new ZollernGemOre(
			"nethersuperchargedcoalore", 1.8F, ZollernItems.superChargedCoal)
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.AMARANTH.getHarvestLevel()))))
			.setBlockVariant(EnumBlockVariant.NETHER)).setShouldExplode(true,
			24);
	public static final Block enderSuperChargedCoalOre = (((ZollernBlockOre) new ZollernGemOre(
			"endersuperchargedcoalore", 2.1F, ZollernItems.superChargedCoal)
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.AMARANTH.getHarvestLevel()))
			.setShouldGivePotionEffect(true, MobEffects.BLINDNESS));
	public static final Block upsideDownSuperChargedCoalOre = new ZollernGemOre(
			"ud_superchargedcoalore", 3.1F, ZollernItems.superChargedCoal)
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.AMARANTH.getHarvestLevel());
	
	// Amaranth
	public static final Block amaranthBlock = new ZollernBlockMetal(
			"amaranthblock");
	public static final Block amaranthOre = new ZollernBlockOre("amaranthore",
			1.9F).setBlockHarvestLevel("pickaxe",
			EnumHarvestLevel.DIAMOND.getHarvestLevel());
	public static final Block netherAmaranthOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"netheramaranthore", 1.9F).setBlockVariant(EnumBlockVariant.NETHER))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.DIAMOND.getHarvestLevel()))
			.setShouldExplode(true, 36);
	public static final Block enderAmaranthOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"enderamaranthore", 1.9F).setBlockVariant(EnumBlockVariant.END))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.DIAMOND.getHarvestLevel()))
			.setShouldGivePotionEffect(true, MobEffects.HUNGER);
	public static final Block upsideDownAmaranthOre = ((ZollernBlockBase) new ZollernBlockOre(
			"ud_amaranthore", 1.9F)
			.setBlockVariant(EnumBlockVariant.UPSIDE_DOWN))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.DIAMOND.getHarvestLevel());
	
	// Azurite
	public static final Block azuriteBlock = new ZollernBlockMetal(
			"azuriteblock").setLightLevel(1.0F);
	public static final Block azuriteOre = (((ZollernBlockBase) new ZollernGemOre(
			"azuriteore", 3.2F, ZollernItems.azurite).setLightLevel(0.6F))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.DIAMOND.getHarvestLevel()));
	
	// Ender Shard
	public static final Block enderPearlBlock = new ZollernBlockMetal(
			"enderpearlblock").setLightLevel(0.5F);
	public static final Block enderShardOre = new ZollernGemOre(
			"endershardore", 2.5F, ZollernItems.enderShard)
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel());
	public static final Block netherEnderShardOre = ((((ZollernBlockOre) ((ZollernBlockOre) new ZollernGemOre(
			"netherendershardore", 2.5F, ZollernItems.enderShard)
			.setBlockVariant(EnumBlockVariant.NETHER)).setBlockHarvestLevel(
			"pickaxe", EnumHarvestLevel.IRON.getHarvestLevel()))
			.setShouldExplode(true, 45)));
	
	// Amber
	public static final Block amberBlock = new ZollernBlockMetal("amberblock");
	public static final Block amberOre = new ZollernGemOre("amberore", 1.4F,
			ZollernItems.amber).setBlockHarvestLevel("pickaxe",
			EnumHarvestLevel.IRON.getHarvestLevel());
	
	// Aquamarine
	public static final Block aquamarineBlock = new ZollernBlockMetal(
			"aquamarineblock");
	public static final Block aquamarineOre = new ZollernGemOre(
			"aquamarineore", 1.5F, ZollernItems.aquamarine)
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel());
	
	// Garnet
	public static final Block garnetBlock = new ZollernBlockMetal("garnetblock");
	public static final Block garnetOre = new ZollernGemOre("garnetore", 1.6F,
			ZollernItems.garnet).setBlockHarvestLevel("pickaxe",
			EnumHarvestLevel.IRON.getHarvestLevel());
	
	// Fueltonium
	public static final Block fueltoniumBlock = new ZollernBlockMetal(
			"fueltoniumblock");
	public static final Block fueltoniumOre = new ZollernGemOre(
			"fueltoniumore", 3.5F, ZollernItems.fuelonite)
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.DIAMOND.getHarvestLevel());
	public static final Block netherFueltoniumOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernGemOre(
			"netherfueltoniumore", 3.5F, ZollernItems.fuelonite)
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.DIAMOND.getHarvestLevel()))
			.setShouldExplode(true, 15))
			.setBlockVariant(EnumBlockVariant.NETHER);
	public static final Block enderFueltoniumOre = (((ZollernBlockOre) new ZollernGemOre(
			"enderfueltoniumore", 3.5F, ZollernItems.fuelonite)
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.DIAMOND.getHarvestLevel()))
			.setShouldGivePotionEffect(true, MobEffects.INSTANT_DAMAGE));
	
	// Zinc
	public static final Block zincBlock = new ZollernBlockMetal("zincblock");
	public static final Block zincOre = new ZollernBlockOre("zincore", 3.2F)
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.AMARANTH.getHarvestLevel());
	public static final Block netherZincOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"netherzincore", 3.2F).setBlockVariant(EnumBlockVariant.NETHER))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.AMARANTH.getHarvestLevel()))
			.setShouldExplode(true, 26);
	public static final Block enderZincOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"enderzincore", 3.2F).setBlockVariant(EnumBlockVariant.END))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.AMARANTH.getHarvestLevel()))
			.setShouldGivePotionEffect(true, MobEffects.MINING_FATIGUE);
	
	// Topaz
	public static final Block topazBlock = new ZollernBlockMetal("topazblock");
	public static final Block topazOre = new ZollernGemOre("topazore", 1.2F,
			ZollernItems.topaz).setBlockHarvestLevel("pickaxe",
			EnumHarvestLevel.IRON.getHarvestLevel());
	
	// Ruby
	public static final Block rubyBlock = new ZollernBlockMetal("rubyblock");
	public static final Block rubyOre = new ZollernGemOre("rubyore", 1.2F,
			ZollernItems.ruby).setBlockHarvestLevel("pickaxe",
			EnumHarvestLevel.IRON.getHarvestLevel());
	
	// Sapphire
	public static final Block sapphireBlock = new ZollernBlockMetal(
			"sapphireblock").setBlockHarvestLevel("pickaxe",
			EnumHarvestLevel.IRON.getHarvestLevel());
	public static final Block sapphireOre = new ZollernGemOre("sapphireore",
			1.2F, ZollernItems.sapphire).setBlockHarvestLevel("pickaxe",
			EnumHarvestLevel.IRON.getHarvestLevel());
	
	// Opal
	public static final Block opalBlock = new ZollernBlockMetal("opalblock");
	public static final Block opalOre = new ZollernGemOre("opalore", 1.2F,
			ZollernItems.opal).setBlockHarvestLevel("pickaxe",
			EnumHarvestLevel.IRON.getHarvestLevel());
	
	// Witherite
	public static final Block witheriteBlock = new ZollernBlockMetal(
			"witheriteblock");
	public static final Block witheriteOre = new ZollernGemOre("witheriteore",
			2.0F, ZollernItems.witherite).setBlockHarvestLevel("pickaxe",
			EnumHarvestLevel.DIAMOND.getHarvestLevel());
	
	// Zollernium
	public static final Block zollerniumBlock = new ZollernBlockMetal(
			"zollerniumblock");
	public static final Block zollerniumOre = new ZollernBlockOre(
			"zollerniumore", 5.0F).setBlockHarvestLevel("pickaxe",
			EnumHarvestLevel.AMARANTH.getHarvestLevel());
	
	// Steel
	public static final Block steelBlock = new ZollernBlockMetal("steelblock");
	public static final Block steelOre = new ZollernBlockOre("steelore", 4.5F)
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel());
	public static final Block netherSteelOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"nethersteelore", 4.6F).setBlockVariant(EnumBlockVariant.NETHER))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel())).setShouldExplode(
			true, 40);
	public static final Block enderSteelOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"endersteelore", 4.7F).setBlockVariant(EnumBlockVariant.END))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel()))
			.setShouldGivePotionEffect(true, MobEffects.LEVITATION);
	
	// Enderite
	public static final Block enderiteBlock = new ZollernBlockMetal(
			"enderiteblock");
	public static final Block enderiteOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"enderiteore", 2.4F).setBlockVariant(EnumBlockVariant.END))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel()))
			.setShouldGivePotionEffect(true, MobEffects.POISON);
	
	// Ender Diamond
	public static final Block enderDiamondBlock = new ZollernBlockMetal(
			"enderdiamondblock");
	public static final Block enderDiamondOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernGemOre(
			"enderdiamondore", 3.6F, ZollernItems.enderDiamond)
			.setShouldGivePotionEffect(true, MobEffects.NAUSEA))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.AMARANTH.getHarvestLevel()))
			.setBlockVariant(EnumBlockVariant.END);
	
	// Iron
	public static final Block netherIronOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"netherironore", 3.2F).setBlockVariant(EnumBlockVariant.NETHER))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel())).setShouldExplode(
			true, 20);
	
	// Gold
	public static final Block netherGoldOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"nethergoldore", 3.4F).setBlockVariant(EnumBlockVariant.NETHER))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel())).setShouldExplode(
			true, 20);
	
	// Diamond
	public static final Block netherDiamondOre = ((ZollernGemOre) ((ZollernGemOre) new ZollernGemOre(
			"netherdiamondore", 3.6F, Items.DIAMOND)
			.setBlockVariant(EnumBlockVariant.NETHER)).setBlockHarvestLevel(
			"pickaxe", EnumHarvestLevel.IRON.getHarvestLevel()))
			.setShouldExplode(true, 20);
	
	// Emerald
	public static final Block netherEmeraldOre = ((ZollernGemOre) ((ZollernGemOre) new ZollernGemOre(
			"netheremeraldore", 3.8F, Items.EMERALD)
			.setBlockVariant(EnumBlockVariant.NETHER)).setBlockHarvestLevel(
			"pickaxe", EnumHarvestLevel.IRON.getHarvestLevel()))
			.setShouldExplode(true, 20);
	
	// Redstone
	public static final Block netherRedstoneOre = ((ZollernGemOre) ((ZollernGemOre) ((ZollernBlockOre) new ZollernGemOre(
			"netherredstoneore", 3.0F, Items.REDSTONE)
			.setBlockVariant(EnumBlockVariant.NETHER)).setBlockHarvestLevel(
			"pickaxe", EnumHarvestLevel.IRON.getHarvestLevel()))
			.setShouldExplode(true, 25)).setMinMaxDropped(4, 6);
	
	// Coal
	public static final Block netherCoalOre = ((ZollernGemOre) ((ZollernGemOre) new ZollernGemOre(
			"nethercoalore", 1.6F, Items.COAL)
			.setBlockVariant(EnumBlockVariant.NETHER)).setBlockHarvestLevel(
			"pickaxe", EnumHarvestLevel.IRON.getHarvestLevel()))
			.setShouldExplode(true, 15);
	
	// Lapis
	public static final Block netherLapisOre = ((ZollernGemOre) ((ZollernGemOre) new ZollernGemOre(
			"netherlapisore", 1.0F, new ItemStack(Items.DYE, 1,
					EnumDyeColor.BLUE.getDyeDamage()).getItem())
			.setBlockVariant(EnumBlockVariant.NETHER)).setBlockHarvestLevel(
			"pickaxe", EnumHarvestLevel.IRON.getHarvestLevel()))
			.setShouldExplode(true, 42);
	
	// Shinium
	public static final Block netherShiniumOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"nethershiniumore", 4.6F).setBlockVariant(EnumBlockVariant.NETHER))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.AMARANTH.getHarvestLevel()))
			.setShouldExplode(true, 15);
	
	// Copper
	public static final Block netherCopperOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"nethercopperore", 3.4F).setBlockVariant(EnumBlockVariant.NETHER))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel())).setShouldExplode(
			true, 20);
	
	// Lead
	public static final Block netherLeadOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"netherleadore", 3.4F).setBlockVariant(EnumBlockVariant.NETHER))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel())).setShouldExplode(
			true, 20);
	
	// Tin
	public static final Block netherTinOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"nethertinore", 3.4F).setBlockVariant(EnumBlockVariant.NETHER))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel())).setShouldExplode(
			true, 28);
	
	// Silver
	public static final Block netherSilverOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"nethersilverore", 3.4F).setBlockVariant(EnumBlockVariant.NETHER))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel())).setShouldExplode(
			true, 30);
	
	// Nickel
	public static final Block netherNickleOre = ((ZollernBlockOre) ((ZollernBlockOre) new ZollernBlockOre(
			"nethernickleore", 3.4F).setBlockVariant(EnumBlockVariant.NETHER))
			.setBlockHarvestLevel("pickaxe",
					EnumHarvestLevel.IRON.getHarvestLevel())).setShouldExplode(
			true, 22);
	
	// Chargium
	public static final Block chargiumBlock = new ZollernBlockMetal(
			"chargiumblock").setLightLevel(1.0F);
	
	// Shinium (Platinum)
	public static final Block shiniumBlock = new ZollernBlockMetal(
			"shiniumblock").setLightLevel(1.0F);
	
	// Netheridium
	public static final Block netheridiumBlock = new ZollernBlockMetal(
			"netheridiumblock");
	public static final Block netherizedObsidian = new ZollernBlockBase(
			"netherizedobsidian", 2.0F).setBlockHarvestLevel("pickaxe", 2);
	
	// Road Blocks
	// Asphalt
	public static final Block asphaltBlack = new ZollernBlockBase("asphalt",
			3.2F);
	public static final Block asphaltGray = new ZollernBlockBase(
			"asphalt_gray", 3.2F);
	public static final Block asphaltStripeLeft = new ZollernBlockBase(
			"asphalt_stripe_left", 3.2F);
	public static final Block asphaltStripeRight = new ZollernBlockBase(
			"asphalt_stripe_right", 3.2F);
	
	// Cave Blocks
	public static final Block shinestone = new BlockShinestone();
	public static final Block caveMarble = new ZollernBlockBase("marble", 1.4F)
			.setBlockHarvestLevel("pickaxe", 2).setLightLevel(0.6F);
	public static final Block blackCaveMarble = new ZollernBlockBase(
			"blackmarble", 1.4F).setBlockHarvestLevel("pickaxe", 3)
			.setLightLevel(0.5F);
	
	// Enderglow
	public static final Block enderGlow = new BlockEnderGlow();
	
	//
	/*
	 * Biome & General Blocks
	 */
	//
	public static final Block badStone = new ZollernBlockBase("badstone", 0.6F);
	public static final Block redshroomBlock = new ZollernBlockBase(
			"redshroomblock", 0.5F);
	public static final Block redshroomStem = new ZollernBlockBase(
			"redshroomstem", 0.4F);
	public static final Block coldSand = new ZollernSand("coldsand", 0.8F);
	public static final Block coldSandSmooth = new ZollernBlockBase(
			"coldsandsmooth", 1.2F);
	public static final Block canyonRock = new ZollernBlockBase("canyonrock",
			1.6F);
	public static final Block canyonRockBricks = new ZollernBlockBase(
			"canyonrockbricks", 1.2F);
	public static final Block swampClay = new BlockSwampClay();
	
	//
	// Nether Blocks
	//
	public static final Block blazeRock = ((ZollernBlockBase) new ZollernBlockBase(
			"blazerock", 2.5F).setShouldAlwaysBurn(true)).setIsHotBlock(true);
	public static final Block netherDirt = new ZollernDirt("netherdirt", 0.6F)
			.setShouldAlwaysBurn(true);
	public static final Block netherrack = new ZollernBlockBase("netherrack",
			1.5F).setShouldAlwaysBurn(true);
	public static final Block hellObsidian = new ZollernBlockBase(
			"redobsidian", 5.6F).setShouldAlwaysBurn(true);
	
	/*
	 * Upside-Down
	 */
	
	// World blocks
	public static final Block upsideDownSurfaceRock = new ZollernBlockBase(
			"ud_surfacerock", 1.6F);
	public static final Block upsideDownSubRock = new ZollernBlockBase(
			"ud_rock", 1.4F);
	public static final Block upsideDownCobble = new ZollernBlockBase(
			"ud_cobblestone", 1.2F);
	public static final Block upsideDownStone = new UpsideDownStone();
	public static final Block witherrack = new ZollernBlockBase("witherrack",
			1.6F);
	public static final Block upsideDownCobbleMossy = new ZollernBlockBase(
			"ud_cobble_mossy", 1.4F);
	public static final Block endrock = new ZollernBlockBase("endrock", 10.0F)
			.setBlockUnbreakable();
	
	// Upside-Down Ores
	// TODO
	
	// Upside-Down Corruption Layer
	// TODO
	
	// Radium
	// TODO
	
	// Etrium
	// TODO
	
	// Zucrite
	// TODO
	
	// Shine Torch
	public static final Block shineTorch = new ShineTorch();
	
	// Bricks
	public static final Block bricksMud = new ZollernBlockBase("bricks_mud",
			1.2F);
	
}