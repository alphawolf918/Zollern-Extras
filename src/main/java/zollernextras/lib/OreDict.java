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
		}
		registerOre("ingotFueltonium", ItemList.ingotFueltonium);
		registerOre("oreFueltonium", BlockList.fueltonium);
		
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
		registerOre("blockZinc", BlockList.zincBlock);
		
		// Amaranth
		registerOre("ingotAmaranth", ItemList.amaranthIngot);
		registerOre("dustAmaranth", ItemList.amaranthDust);
		
		// Super Charged Coal
		registerOre("dustSuperCoal", ItemList.spcItem);
		registerOre("oreSuperChargedCoal", BlockList.spcOre);
		
		// Zollernium
		registerOre("ingotZollernium", ItemList.zollerniumIngot);
		registerOre("dustZollernium", ItemList.zollerniumDust);
		
		// Dye
		registerOre("dyeGreen", ItemList.greenDye);
		
		// Pulverized Obsidian
		registerOre("dustObsidian", ItemList.obsidianDust);
		registerOre("pulverizedObsidian", ItemList.obsidianDust);
		
		// Obsidian Ingot
		registerOre("ingotObsidian", ItemList.obsidianIngot);
		
		// Stone Registry
		registerOre("blockStone", Blocks.stone, BlockList.andesite,
				BlockList.diorite, BlockList.granite);
		registerOre("blockAndesite", BlockList.andesite);
		registerOre("blockDiorite", BlockList.diorite);
		registerOre("blockGranite", BlockList.granite);
		
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