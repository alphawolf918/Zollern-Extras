package zollernextras.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.config.ZEConfig;
import zollernextras.items.ZollernItems;

public class OreDict {
	
	static int totalEntries = 0;
	
	public static void init() {
		
		ZollernHelper.Log("Loading OreDictionary..");
		
		/** <Trees> **/
		
		// Logs
		registerOre("logWood", ZollernBlocks.bananaLog, ZollernBlocks.orangeLog,
				ZollernBlocks.guavaLog, ZollernBlocks.lemonLog, ZollernBlocks.limeLog,
				ZollernBlocks.limonLog, ZollernBlocks.cherryLog,
				ZollernBlocks.grapefruitLog, ZollernBlocks.enderBerryLog);
		
		// Leaves
		registerOre("treeLeaves", ZollernBlocks.bananaLeaves,
				ZollernBlocks.orangeLeaves, ZollernBlocks.guavaLeaves,
				ZollernBlocks.lemonLeaves, ZollernBlocks.limeLeaves,
				ZollernBlocks.limonLeaves, ZollernBlocks.cherryLeaves,
				ZollernBlocks.grapefruitLeaves, ZollernBlocks.enderBerryLeaves);
		
		// Saplings
		registerOre("treeSapling", ZollernBlocks.bananaSapling,
				ZollernBlocks.orangeSapling, ZollernBlocks.guavaSapling,
				ZollernBlocks.lemonSapling, ZollernBlocks.limeSapling,
				ZollernBlocks.limonSapling, ZollernBlocks.cherrySapling,
				ZollernBlocks.grapefruitSapling, ZollernBlocks.enderBerrySapling);
		
		// Planks
		registerOre("plankWood", ZollernBlocks.bananaPlanks,
				ZollernBlocks.orangePlanks, ZollernBlocks.guavaPlanks,
				ZollernBlocks.lemonPlanks, ZollernBlocks.limePlanks,
				ZollernBlocks.limonPlanks, ZollernBlocks.cherryPlanks,
				ZollernBlocks.grapefruitPlanks, ZollernBlocks.enderBerryPlanks);
		
		/** </Trees> **/
		
		// Ender Glow
		registerOre("blockEnderGlowstone", ZollernBlocks.enderGlowstone);
		registerOre("dustEnderGlowstone", ZollernBlocks.enderGlowstone);
		
		// Better Glass
		if (ZEConfig.betterGlassIsGlass) {
			registerOre("glass", ZollernBlocks.betterGlass);
			registerOre("blockGlass", ZollernBlocks.betterGlass);
			registerOre("blockGlassColorless", ZollernBlocks.betterGlass);
		}
		
		// Fueltonium
		if (ZEConfig.fueltoniumIsYellorite) {
			registerOre("ingotUranium", ZollernItems.ingotFueltonium);
			registerOre("dustUranium", ZollernItems.fuelonite);
		}
		registerOre("ingotFueltonium", ZollernItems.ingotFueltonium);
		registerOre("oreFueltonium", ZollernBlocks.fueltonium);
		registerOre("oreNetherFueltonium", ZollernBlocks.fuelNetherOre);
		registerOre("oreEnderFueltonium", ZollernBlocks.enderFnOre);
		registerOre("dustFueltonium", ZollernItems.fuelonite);
		registerOre("blockFueltonium", ZollernBlocks.fueltoniumBlock);
		
		// Shinium
		if (ZEConfig.shiniumIsPlatinum) {
			registerOre("ingotPlatinum", ZollernItems.shiniumIngot);
			registerOre("dustPlatinum", ZollernItems.shiniumDust);
			registerOre("blockPlatinum", ZollernBlocks.shiniumBlock);
		}
		registerOre("ingotShinium", ZollernItems.shiniumIngot);
		registerOre("dustShinium", ZollernItems.shiniumDust);
		registerOre("blockShinium", ZollernBlocks.shiniumBlock);
		
		// Zinc
		registerOre("ingotZinc", ZollernItems.zincIngot);
		registerOre("dustZinc", ZollernItems.zincDust);
		registerOre("oreZinc", ZollernBlocks.zincOre);
		registerOre("oreNetherZinc", ZollernBlocks.zincNetherOre);
		registerOre("oreEnderZinc", ZollernBlocks.enderZincOre);
		registerOre("blockZinc", ZollernBlocks.zincBlock);
		
		// Silver
		registerOre("ingotSilver", ZollernItems.silverIngot);
		registerOre("nuggetSilver", ZollernItems.silverNugget);
		
		// Amaranth
		registerOre("ingotAmaranth", ZollernItems.amaranthIngot);
		registerOre("dustAmaranth", ZollernItems.amaranthDust);
		registerOre("oreAmaranth", ZollernBlocks.amaranthOre);
		registerOre("oreNetherAmaranth", ZollernBlocks.amaranthNetherOre);
		registerOre("oreEnderAmaranth", ZollernBlocks.enderAmaranthOre);
		registerOre("blockAmaranth", ZollernBlocks.amaranthBlock);
		
		// Super Charged Coal
		registerOre("dustSuperChargedCoal", ZollernItems.spcItem);
		registerOre("oreSuperChargedCoal", ZollernBlocks.spcOre);
		registerOre("oreNetherSuperChargedCoal", ZollernBlocks.spcNetherOre);
		registerOre("oreEnderSuperChargedCoal", ZollernBlocks.enderSpcOre);
		registerOre("blockSuperChargedCoal", ZollernBlocks.spcBlock);
		
		// Zollernium
		registerOre("ingotZollernium", ZollernItems.zollerniumIngot);
		registerOre("dustZollernium", ZollernItems.zollerniumDust);
		registerOre("blockZollernium", ZollernBlocks.zollerniumBlock);
		registerOre("oreZollernium", ZollernBlocks.zollerniumOre);
		
		// Ender Diamond
		registerOre("gemEnderDiamond", ZollernItems.enderDiamond);
		registerOre("oreEnderDiamond", ZollernBlocks.enderDiamondOre);
		registerOre("blockEnderDiamond", ZollernBlocks.enderDiamondBlock);
		
		// Azurite
		registerOre("gemAzurite", ZollernItems.azurite);
		registerOre("oreAzurite", ZollernBlocks.azuriteOre);
		registerOre("blockAzurite", ZollernBlocks.azurite);
		
		// Amber
		registerOre("gemAmber", ZollernItems.amber);
		registerOre("oreAmber", ZollernBlocks.amberOre);
		registerOre("blockAmber", ZollernBlocks.amber);
		
		// Topaz
		registerOre("gemTopaz", ZollernItems.topaz);
		registerOre("oreTopaz", ZollernBlocks.topazOre);
		registerOre("blockTopaz", ZollernBlocks.topaz);
		
		// Aquamarine
		registerOre("gemAquamarine", ZollernItems.aquamarine);
		registerOre("oreAquamarine", ZollernBlocks.aquamarineOre);
		registerOre("blockAquamarine", ZollernBlocks.aqua);
		
		// Garnet
		registerOre("gemGarnet", ZollernItems.garnet);
		registerOre("oreGarnet", ZollernBlocks.garnetOre);
		registerOre("blockGarnet", ZollernBlocks.garnet);
		
		// Opal
		registerOre("gemOpal", ZollernItems.opal);
		registerOre("oreOpal", ZollernBlocks.opalOre);
		registerOre("blockOpal", ZollernBlocks.opal);
		
		// Enderite
		registerOre("ingotEnderite", ZollernItems.enderite);
		registerOre("oreEnderite", ZollernBlocks.enderiteOre);
		registerOre("blockEnderite", ZollernBlocks.enderite);
		
		// Witherite
		registerOre("oreWitherite", ZollernBlocks.witheriteOre);
		registerOre("gemWitherite", ZollernItems.witherite);
		registerOre("blockWitherite", ZollernBlocks.witheriteBlock);
		
		// Ruby
		registerOre("oreRuby", ZollernBlocks.rubyOre);
		registerOre("blockRuby", ZollernBlocks.rubyBlock);
		registerOre("gemRuby", ZollernItems.ruby);
		
		// Sapphire
		registerOre("oreSapphire", ZollernBlocks.sapphireOre);
		registerOre("blockSapphire", ZollernBlocks.sapphireBlock);
		registerOre("gemSapphire", ZollernItems.sapphire);
		
		// Lapis
		registerOre("ingotLapis", ZollernItems.lapisIngot);
		registerOre("dustLapis", new ItemStack(Items.dye, 1, 4).getItem());
		
		// Dye
		registerOre("dyeGreen", ZollernItems.greenDye);
		registerOre("dyePink", ZollernItems.enderReeds);
		
		// Obsidian
		registerOre("ingotObsidian", ZollernItems.obsidianIngot);
		registerOre("dustObsidian", ZollernItems.obsidianDust);
		
		// Stone Registry
		registerOre("blockStone", Blocks.stone, ZollernBlocks.andesite,
				ZollernBlocks.diorite, ZollernBlocks.granite);
		registerOre("blockAndesite", ZollernBlocks.andesite);
		registerOre("blockDiorite", ZollernBlocks.diorite);
		registerOre("blockGranite", ZollernBlocks.granite);
		
		// Grass Registry
		registerOre("blockGrass", ZollernBlocks.betterGrass);
		
		// Crop Registry
		registerOre("cropBlueberry", ZollernItems.blueberry);
		registerOre("cropBlackberry", ZollernItems.blackberry);
		registerOre("cropStrawberry", ZollernItems.strawberry);
		registerOre("cropGrape", ZollernItems.grape);
		registerOre("cropRadish", ZollernItems.radish);
		registerOre("cropGarlic", ZollernItems.garlic);
		registerOre("cropOnion", ZollernItems.onion);
		registerOre("cropCucumber", ZollernItems.cucumber);
		registerOre("cropCorn", ZollernItems.corn);
		registerOre("cropPeas", ZollernItems.peaPod);
		registerOre("cropTomato", ZollernItems.tomato);
		registerOre("cropBanana", ZollernItems.banana);
		registerOre("cropOrange", ZollernItems.orange);
		registerOre("cropGuava", ZollernItems.guava);
		registerOre("cropLemon", ZollernItems.lemon);
		registerOre("cropLime", ZollernItems.lime);
		registerOre("cropLimon", ZollernItems.limon);
		registerOre("cropCherry", ZollernItems.cherry);
		registerOre("cropGrapefruit", ZollernItems.grapefruit);
		
		// Chargium
		registerOre("dustChargium", ZollernItems.chargiumDust);
		registerOre("ingotChargium", ZollernItems.chargiumIngot);
		registerOre("blockChargium", ZollernBlocks.chargiumBlock);
		
		// Clay Registry
		registerOre("itemClay", ZollernItems.swampClayBall);
		registerOre("blockClay", ZollernBlocks.swampClay);
		
		// Fluid Registry
		registerOre("fluidChocolate", ZollernBlocks.blockChocolate);
		registerOre("fluidFueltonium", ZollernBlocks.blockFuel);
		
		// Bucket Registry
		registerOre("bucketChocolate", ZollernItems.chocolateBucket);
		registerOre("bucketFueltonium", ZollernItems.fuelBucket);
		
		ZollernHelper.Log("OreDictionary loaded: " + totalEntries + " entries.");
	}
	
	public static void registerOre(String strName, Item item) {
		OreDictionary.registerOre(strName, new ItemStack(item, 1));
		totalEntries++;
	}
	
	public static void registerOre(String strName, Block block) {
		OreDictionary.registerOre(strName, new ItemStack(block, 1));
		totalEntries++;
	}
	
	public static void registerOre(String strName, Block... blocks) {
		for (Block zollernBlock : blocks) {
			registerOre(strName, zollernBlock);
		}
	}
	
	public static void registerOre(String strName, Item... items) {
		for (Item zollernItem : items) {
			registerOre(strName, zollernItem);
		}
	}
}