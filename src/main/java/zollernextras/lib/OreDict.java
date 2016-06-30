package zollernextras.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import zollernextras.blocks.BlockList;
import zollernextras.config.ZEConfig;
import zollernextras.items.ItemList;

public class OreDict {
	
	static int totalEntries = 0;
	
	public static void init() {
		
		MainHelper.Log("Loading OreDictionary..");
		
		/** <Trees> **/
		
		// Logs
		registerOre("logWood", BlockList.bananaLog, BlockList.orangeLog,
				BlockList.guavaLog, BlockList.lemonLog, BlockList.limeLog,
				BlockList.limonLog, BlockList.cherryLog,
				BlockList.grapefruitLog);
		
		// Leaves
		registerOre("treeLeaves", BlockList.bananaLeaves,
				BlockList.orangeLeaves, BlockList.guavaLeaves,
				BlockList.lemonLeaves, BlockList.limeLeaves,
				BlockList.limonLeaves, BlockList.cherryLeaves,
				BlockList.grapefruitLeaves);
		
		// Saplings
		registerOre("treeSapling", BlockList.bananaSapling,
				BlockList.orangeSapling, BlockList.guavaSapling,
				BlockList.lemonSapling, BlockList.limeSapling,
				BlockList.limonSapling, BlockList.cherrySapling,
				BlockList.grapefruitSapling);
		
		// Planks
		registerOre("plankWood", BlockList.bananaPlanks,
				BlockList.orangePlanks, BlockList.guavaPlanks,
				BlockList.lemonPlanks, BlockList.limePlanks,
				BlockList.limonPlanks, BlockList.cherryPlanks,
				BlockList.grapefruitPlanks);
		
		/** </Trees> **/
		
		// Better Glass
		if (ZEConfig.betterGlassIsGlass) {
			registerOre("glass", BlockList.betterGlass);
			registerOre("blockGlass", BlockList.betterGlass);
			registerOre("blockGlassColorless", BlockList.betterGlass);
		}
		
		// Fueltonium
		if (ZEConfig.fueltoniumIsYellorite) {
			registerOre("ingotUranium", ItemList.ingotFueltonium);
			registerOre("dustUranium", ItemList.fuelonite);
		}
		registerOre("ingotFueltonium", ItemList.ingotFueltonium);
		registerOre("oreFueltonium", BlockList.fueltonium);
		registerOre("oreNetherFueltonium", BlockList.fuelNetherOre);
		registerOre("dustFueltonium", ItemList.fuelonite);
		registerOre("blockFueltonium", BlockList.fueltoniumBlock);
		
		// Shinium
		if (ZEConfig.shiniumIsPlatinum) {
			registerOre("ingotPlatinum", ItemList.shiniumIngot);
			registerOre("dustPlatinum", ItemList.shiniumDust);
			registerOre("blockPlatinum", BlockList.shiniumBlock);
		}
		
		// Zinc
		registerOre("ingotZinc", ItemList.zincIngot);
		registerOre("dustZinc", ItemList.zincDust);
		registerOre("oreZinc", BlockList.zincOre);
		registerOre("oreNetherZinc", BlockList.zincNetherOre);
		registerOre("blockZinc", BlockList.zincBlock);
		
		// Silver
		registerOre("ingotSilver", ItemList.silverIngot);
		registerOre("nuggetSilver", ItemList.silverNugget);
		
		// Amaranth
		registerOre("ingotAmaranth", ItemList.amaranthIngot);
		registerOre("dustAmaranth", ItemList.amaranthDust);
		registerOre("oreAmaranth", BlockList.amaranthOre);
		registerOre("oreNetherAmaranth", BlockList.amaranthNetherOre);
		registerOre("blockAmaranth", BlockList.amaranthBlock);
		
		// Super Charged Coal
		registerOre("dustSuperChargedCoal", ItemList.spcItem);
		registerOre("oreSuperChargedCoal", BlockList.spcOre);
		registerOre("oreNetherSuperChargedCoal", BlockList.spcNetherOre);
		registerOre("blockSuperChargedCoal", BlockList.spcBlock);
		
		// Zollernium
		registerOre("ingotZollernium", ItemList.zollerniumIngot);
		registerOre("dustZollernium", ItemList.zollerniumDust);
		registerOre("blockZollernium", BlockList.zollerniumBlock);
		
		// Azurite
		registerOre("gemAzurite", ItemList.azurite);
		registerOre("oreAzurite", BlockList.azuriteOre);
		registerOre("blockAzurite", BlockList.azurite);
		
		// Amber
		registerOre("gemAmber", ItemList.amber);
		registerOre("oreAmber", BlockList.amberOre);
		registerOre("blockAmber", BlockList.amber);
		
		// Topaz
		registerOre("gemTopaz", ItemList.topaz);
		registerOre("oreTopaz", BlockList.topazOre);
		registerOre("blockTopaz", BlockList.topaz);
		
		// Aquamarine
		registerOre("gemAquamarine", ItemList.aquamarine);
		registerOre("oreAquamarine", BlockList.aquamarineOre);
		registerOre("blockAquamarine", BlockList.aqua);
		
		// Garnet
		registerOre("gemGarnet", ItemList.garnet);
		registerOre("oreGarnet", BlockList.garnetOre);
		registerOre("blockGarnet", BlockList.garnet);
		
		// Opal
		registerOre("gemOpal", ItemList.opal);
		registerOre("oreOpal", BlockList.opalOre);
		registerOre("blockOpal", BlockList.opal);
		
		// Enderite
		registerOre("ingotEnderite", ItemList.enderite);
		registerOre("oreEnderite", BlockList.enderiteOre);
		registerOre("blockEnderite", BlockList.enderite);
		
		// Witherite
		registerOre("oreWitherite", BlockList.witheriteOre);
		registerOre("gemWitherite", ItemList.witherite);
		registerOre("blockWitherite", BlockList.witheriteBlock);
		
		// Ruby
		registerOre("oreRuby", BlockList.rubyOre);
		registerOre("blockRuby", BlockList.rubyBlock);
		registerOre("gemRuby", ItemList.ruby);
		
		// Sapphire
		registerOre("oreSapphire", BlockList.sapphireOre);
		registerOre("blockSapphire", BlockList.sapphireBlock);
		registerOre("gemSapphire", ItemList.sapphire);
		
		// Dye
		registerOre("dyeGreen", ItemList.greenDye);
		
		// Obsidian
		registerOre("ingotObsidian", ItemList.obsidianIngot);
		registerOre("dustObsidian", ItemList.obsidianDust);
		
		// Stone Registry
		registerOre("blockStone", Blocks.stone, BlockList.andesite,
				BlockList.diorite, BlockList.granite);
		registerOre("blockAndesite", BlockList.andesite);
		registerOre("blockDiorite", BlockList.diorite);
		registerOre("blockGranite", BlockList.granite);
		
		// Grass Registry
		registerOre("blockGrass", BlockList.betterGrass);
		
		// Crop Registry
		registerOre("cropBlueberry", ItemList.blueberry);
		registerOre("cropBlackberry", ItemList.blackberry);
		registerOre("cropStrawberry", ItemList.strawberry);
		registerOre("cropGrape", ItemList.grape);
		registerOre("cropRadish", ItemList.radish);
		registerOre("cropGarlic", ItemList.garlic);
		registerOre("cropOnion", ItemList.onion);
		registerOre("cropCucumber", ItemList.cucumber);
		registerOre("cropCorn", ItemList.corn);
		registerOre("cropPeas", ItemList.peaPod);
		registerOre("cropTomato", ItemList.tomato);
		registerOre("cropBanana", ItemList.banana);
		registerOre("cropOrange", ItemList.orange);
		registerOre("cropGuava", ItemList.guava);
		registerOre("cropLemon", ItemList.lemon);
		registerOre("cropLime", ItemList.lime);
		registerOre("cropLimon", ItemList.limon);
		registerOre("cropCherry", ItemList.cherry);
		registerOre("cropGrapefruit", ItemList.grapefruit);
		
		// Clay Registry
		registerOre("itemClay", ItemList.swampClayBall);
		registerOre("blockClay", BlockList.swampClay);
		
		MainHelper.Log("OreDictionary loaded: " + totalEntries + " entries.");
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
		for (Block novaBlock : blocks) {
			registerOre(strName, novaBlock);
		}
	}
	
	public static void registerOre(String strName, Item... items) {
		for (Item novaItem : items) {
			registerOre(strName, novaItem);
		}
	}
}