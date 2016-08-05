package zollernextras.lib.recipes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import zollernextras.blocks.ZollernBlocks;
import zollernextras.config.ZEConfig;
import zollernextras.items.ZollernItems;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.modhelper.ModHelperBase;
import zollernextras.lib.modhelper.ThermalExpansionHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManager {
	
	public static void init() {
		Crafting.init();
		ZollernHelper.Log("Crafting recipes successfully loaded.");
		Smelting.init();
		ZollernHelper.Log("Furnace recipes successfully loaded.");
		PulverizerRecipes.init();
		ZollernHelper.Log("Pulverizer recipes successfully loaded.");
		InductionSmelterRecipes.init();
		ZollernHelper.Log("Induction smelter recipes successfully loaded.");
		LiquidRecipes.init();
	}
	
	public static class Crafting {
		public static void init() {
			ToolArmorRecipes.init();
			
			// Canyon Bricks
			addOWBricks(ZollernBlocks.canyonRock,
					ZollernBlocks.canyonRockBricks);
			
			// Upside Down Stone Bricks
			addOWBricks(ZollernBlocks.upsideDownStone,
					ZollernBlocks.upsideDownStoneBricks);
			
			// Chargium Dust
			GameRegistry.addRecipe(new ItemStack(ZollernItems.chargiumDust, 8),
					new Object[] { "SS ", "ZZ ", "F  ", 'S',
							ZollernItems.shiniumDust, 'Z',
							ZollernItems.zollerniumDust, 'F',
							ZollernItems.chargiumBucket });
			
			// Chargium Block
			fullBlockCraft(ZollernBlocks.chargiumBlock,
					ZollernItems.chargiumIngot);
			
			// Power Stick (Ender Cane)
			GameRegistry.addRecipe(new ItemStack(ZollernItems.powerStick, 4),
					new Object[] { " E ", " E ", "   ", 'E',
				ZollernItems.enderReeds });
			GameRegistry.addRecipe(new ItemStack(ZollernItems.powerStick, 4),
					new Object[] { "   ", " E ", " E ", 'E',
				ZollernItems.enderReeds });
			
			// Mud Bricks
			addBricks(ZollernItems.bricksMud, ZollernBlocks.bricksMud);
			
			// Ender Glow
			addBricks(ZollernItems.enderGlowstoneDust,
					ZollernBlocks.enderGlowstone);
			
			// Ender Diamond Block
			fullBlockCraft(ZollernBlocks.enderDiamondBlock,
					ZollernItems.enderDiamond);
			
			// Purpur Pillar
			addOWBricks(ZollernBlocks.purpurBlock, ZollernBlocks.purpurPillar);
			
			// Tomato Paste
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.tomatoPaste, 1), new Object[] {
					ZollernItems.tomato, Items.glass_bottle });
			
			// Dough
			GameRegistry.addShapelessRecipe(
					new ItemStack(ZollernItems.dough, 2), new Object[] {
							ZollernItems.flour, Items.egg, Items.milk_bucket });
			
			// IMC w/ Zane Extras
			if (ModHelperBase.useZaneExtras) {
				// Pizza
				GameRegistry.addShapelessRecipe(new ItemStack(
						ZollernBlocks.blockPizza, 1), new Object[] {
					ZollernItems.tomatoPaste, ZollernItems.cookedDough,
					zaneextras.items.ItemList.cheese });
			}
			
			// Cold Smoothstone
			ItemStack css = new ItemStack(ZollernBlocks.icyStone, 4);
			GameRegistry.addRecipe(css, new Object[] { "CC ", "CC ", "   ",
					'C', ZollernBlocks.icySand });
			
			// Popcorn Bowl
			GameRegistry.addRecipe(new ItemStack(ZollernItems.popcornBowl, 1),
					new Object[] { "PPP", "PBP", "PPP", 'P',
							ZollernItems.popcorn, 'B', Items.bowl });
			
			// Red Rock
			ItemStack rrb = new ItemStack(ZollernBlocks.redRockBrick, 4);
			GameRegistry.addRecipe(rrb, new Object[] { "SS ", "SS ", "   ",
					'S', ZollernBlocks.redRock });
			
			// Silver
			GameRegistry.addRecipe(new ItemStack(ZollernItems.silverIngot, 1),
					new Object[] { "NNN", "NNN", "NNN", 'N',
							ZollernItems.silverNugget });
			
			if (ZEConfig.vanillaItemsAreCraftable) {
				// Name Tag
				GameRegistry.addRecipe(
						new ItemStack(Item.getItemById(421), 2),
						new Object[] { "  I", " S ", "S  ", 'S',
								ZollernItems.swampClayBall, 'I',
								Item.getItemById(265) });
				
				// Saddle
				GameRegistry.addRecipe(
						new ItemStack(Items.saddle, 1),
						new Object[] { "LLL", "L L", "I I", 'L',
								Item.getItemById(334), 'I',
								Item.getItemById(265) });
				
				// Turn Nether Quartz Block back into Nether Quartz Item
				GameRegistry.addShapelessRecipe(
						new ItemStack(Item.getItemById(406), 9),
						new Object[] { Block.getBlockById(155) });
				
				if (ZEConfig.horseArmorIsCraftable) {
					// Iron
					addHorseArmor(Items.iron_horse_armor, Blocks.iron_block);
					
					// Gold
					addHorseArmor(Items.golden_horse_armor, Blocks.gold_block);
					
					// Diamond
					addHorseArmor(Items.diamond_horse_armor,
							Blocks.diamond_block);
				}
				
				// Red Nether Bricks
				GameRegistry.addRecipe(new ItemStack(
						ZollernBlocks.redNetherBricks, 2), new Object[] {
						"NB ", "BN ", "   ", 'B', Items.netherbrick, 'N',
						Items.nether_wart });
			}
			
			// Ender Shards to Ender Pearl
			GameRegistry.addRecipe(new ItemStack(Item.getItemById(368), 1),
					new Object[] { "RRR", "R R", "RRR", 'R',
							ZollernItems.enderShard });
			
			// Ender Pearl to Ender Shards
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.enderShard, 8), new Object[] { Item
					.getItemById(368) });
			
			// Amaranth
			fullBlockCraft(ZollernBlocks.amaranthBlock,
					ZollernItems.amaranthIngot);
			
			// Fueltonium
			fullBlockCraft(ZollernBlocks.fueltoniumBlock,
					ZollernItems.ingotFueltonium);
			
			// Torches
			GameRegistry.addRecipe(new ItemStack(Block.getBlockById(50), 8),
					new Object[] { "G  ", "S  ", 'G', ZollernItems.spcItem,
							'S', Items.stick });
			GameRegistry.addRecipe(new ItemStack(Block.getBlockById(50), 8),
					new Object[] { " G ", " S ", 'G', ZollernItems.spcItem,
							'S', Items.stick });
			
			// Zinc Ingot (to block)
			fullBlockCraft(ZollernBlocks.zincBlock, ZollernItems.zincIngot);
			
			// Zollernium Ingot (to block)
			fullBlockCraft(ZollernBlocks.zollerniumBlock,
					ZollernItems.zollerniumIngot);
			
			// Sirens
			GameRegistry.addRecipe(
					new ItemStack(ZollernBlocks.ironSiren, 1),
					new Object[] { "OIO", "IRI", "OIO", 'O',
							Block.getBlockById(49), 'I', Item.getItemById(265),
							'R', Item.getItemById(331) });
			GameRegistry.addRecipe(
					new ItemStack(ZollernBlocks.goldSiren, 1),
					new Object[] { "OIO", "IRI", "OIO", 'O',
							Block.getBlockById(49), 'I', Item.getItemById(266),
							'R', Item.getItemById(331) });
			GameRegistry.addRecipe(
					new ItemStack(ZollernBlocks.diamondSiren, 1),
					new Object[] { "OIO", "IRI", "OIO", 'O',
							Block.getBlockById(49), 'I', Item.getItemById(264),
							'R', Item.getItemById(331) });
			GameRegistry.addRecipe(
					new ItemStack(ZollernBlocks.emeraldSiren, 1),
					new Object[] { "OIO", "IRI", "OIO", 'O',
							Block.getBlockById(49), 'I', Item.getItemById(388),
							'R', Item.getItemById(331) });
			
			// Black Cave Marble Block
			GameRegistry.addRecipe(new ItemStack(ZollernBlocks.caveMarbleBlack,
					8), new Object[] { "III", "IMI", "III", 'I',
					new ItemStack(Item.getItemById(351), 1, 0), 'M',
					ZollernBlocks.caveMarbleWhite });
			
			// Blaze Rod
			GameRegistry.addRecipe(new ItemStack(Items.blaze_rod, 1),
					new Object[] { " B ", "BSB", " B ", 'B',
							Items.blaze_powder, 'S',
							ZollernItems.blackMarbleStick });
			
			// Healing Heart
			GameRegistry.addRecipe(
					new ItemStack(ZollernItems.heart),
					new Object[] { "AZA", "AOA", "ARA", 'A',
							ZollernItems.amaranthIngot, 'O',
							ZollernItems.zollerniumIngot, 'R',
							Item.getItemById(331) });
			
			// Health Upgrade
			GameRegistry.addRecipe(new ItemStack(ZollernItems.heartForce),
					new Object[] { "ZSZ", "ZHZ", "ZZZ", 'Z',
							ZollernItems.zincIngot, 'S',
							ZollernItems.zollerniumIngot, 'H',
							ZollernItems.heart });
			
			// Sea Lamps
			GameRegistry.addRecipe(new ItemStack(ZollernBlocks.seaLamp),
					new Object[] { "L L", " S ", "L L", 'L',
							ZollernItems.lapisIngot, 'S',
							ZollernBlocks.shinestone });
			
			// SPC Block
			fullBlockCraft(ZollernBlocks.spcBlock, ZollernItems.spcItem);
			
			// Shinium Ingot
			fullBlockCraft(ZollernBlocks.shiniumBlock,
					ZollernItems.shiniumIngot);
			
			// Firey Garnet (Gem Form)
			GameRegistry.addRecipe(new ItemStack(ZollernItems.fireGarnet, 1),
					new Object[] { "BLB", "RGR", "BLB", 'B',
							Items.blaze_powder, 'G', ZollernBlocks.garnet, 'R',
							Items.redstone, 'L', Items.blaze_rod });
			
			// Icy Aqua (Gem Form)
			GameRegistry.addRecipe(new ItemStack(ZollernItems.icyAqua, 1),
					new Object[] { "SDS", "ZAZ", "AAA", 'S',
							ZollernItems.shiniumIngot, 'Z',
							ZollernItems.shinedust, 'A', ZollernBlocks.aqua,
							'D', Items.diamond });
			
			// Static Amber (Gem Form)
			GameRegistry.addRecipe(new ItemStack(ZollernItems.staticAmber, 1),
					new Object[] { "GTG", "UAU", "ZTZ", 'G', Items.gold_ingot,
							'T', ZollernItems.topaz, 'A', ZollernBlocks.amber,
							'Z', ZollernItems.zincIngot, 'U',
							ZollernItems.azurite });
			
			// Ender Opal (Gem Form)
			GameRegistry.addRecipe(new ItemStack(ZollernItems.enderOpal, 1),
					new Object[] { "FPF", "EOE", "EME", 'F', Items.ender_eye,
							'P', ZollernItems.enderDiamond, 'E',
							ZollernItems.enderite, 'O', ZollernBlocks.opal,
							'M', Items.emerald });
			
			// Netheridium (Gem Form)
			GameRegistry.addRecipe(new ItemStack(ZollernItems.netheridium, 1),
					new Object[] { "BSB", "LXL", "VAV", 'B',
							ZollernItems.shadowEssence, 'S',
							ZollernItems.spcItem, 'V', ZollernItems.garnet,
							'X', ZollernBlocks.witheriteBlock, 'V',
							Items.blaze_powder, 'A', ZollernItems.shadowBone });
			
			// Shinium
			GameRegistry.addRecipe(new ItemStack(ZollernItems.shiniumIngot, 1),
					new Object[] { "DLD", "DSD", "DLD", 'D', Items.diamond,
							'S', ZollernItems.shinestoneIngot, 'L',
							ZollernItems.lapisIngot });
			
			// Glowing Obsidian
			GameRegistry
					.addRecipe(new ItemStack(ZollernBlocks.redObsidian, 2),
							new Object[] { "BN ", "NB ", "   ", 'B',
									ZollernBlocks.netherWartBlock, 'N',
									Blocks.obsidian });
			
			// Netherized Obsidian
			GameRegistry.addRecipe(new ItemStack(
					ZollernBlocks.netherizedObsidian, 1),
					new Object[] { "WNW", "NON", "SNS", 'N',
							ZollernBlocks.netheridiumBlock, 'W',
							ZollernBlocks.witheriteBlock, 'O',
							ZollernBlocks.redObsidian, 'S',
							ZollernItems.shadowEssence });
			
			// Garnet
			fullBlockCraft(ZollernBlocks.garnet, ZollernItems.garnet);
			
			// Aquamarine
			fullBlockCraft(ZollernBlocks.aqua, ZollernItems.aquamarine);
			
			// Amber
			fullBlockCraft(ZollernBlocks.amber, ZollernItems.amber);
			
			// Opal
			fullBlockCraft(ZollernBlocks.opal, ZollernItems.opal);
			
			// Topaz
			fullBlockCraft(ZollernBlocks.topaz, ZollernItems.topaz);
			
			// Enderite
			fullBlockCraft(ZollernBlocks.enderite, ZollernItems.enderite);
			
			// Witherite
			fullBlockCraft(ZollernBlocks.witheriteBlock, ZollernItems.witherite);
			
			// Ruby
			fullBlockCraft(ZollernBlocks.rubyBlock, ZollernItems.ruby);
			
			// Sapphire
			fullBlockCraft(ZollernBlocks.sapphireBlock, ZollernItems.sapphire);
			
			// Fire Garnet
			fullBlockCraft(ZollernBlocks.fireGarnet, ZollernItems.fireGarnet);
			
			// Icy Aqua
			fullBlockCraft(ZollernBlocks.icyAqua, ZollernItems.icyAqua);
			
			// Static Amber
			fullBlockCraft(ZollernBlocks.staticAmber, ZollernItems.staticAmber);
			
			// Ender Opal
			fullBlockCraft(ZollernBlocks.enderOpal, ZollernItems.enderOpal);
			
			// Netheridium
			fullBlockCraft(ZollernBlocks.netheridiumBlock,
					ZollernItems.netheridium);
			
			// Ender Pearl Block
			fullBlockCraft(ZollernBlocks.enderPearlBlock, Items.ender_pearl);
			
			// Sugar
			fullBlockCraft(ZollernBlocks.sugarCube, Items.sugar);
			
			// Nether Wart Block
			fullBlockCraft(ZollernBlocks.netherWartBlock, Items.nether_wart);
			
			// Polished Andesite
			addOWBricks(ZollernBlocks.andesite, ZollernBlocks.polishedAndesite);
			
			// Polished Diorite
			addOWBricks(ZollernBlocks.diorite, ZollernBlocks.polishedDiorite);
			
			// Polished Granite
			addOWBricks(ZollernBlocks.granite, ZollernBlocks.polishedGranite);
			
			// Endstone Bricks
			addOWBricks(Blocks.end_stone, ZollernBlocks.endStoneBricks);
			
			// Obsidian
			GameRegistry.addRecipe(new ItemStack(Blocks.obsidian, 1),
					new Object[] { "OOO", "O O", "OOO", 'O',
							ZollernItems.obsidianIngot });
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.obsidianIngot, 8),
					new Object[] { Blocks.obsidian });
			
			// White Cave Marble Stick
			GameRegistry.addRecipe(new ItemStack(ZollernItems.marbleStick, 2),
					new Object[] { "B  ", "B  ", "   ", 'B',
							ZollernBlocks.caveMarbleWhite });
			
			// Black Cave Marble Stick
			GameRegistry.addRecipe(new ItemStack(ZollernItems.blackMarbleStick,
					2), new Object[] { "B  ", "B  ", "   ", 'B',
					ZollernBlocks.caveMarbleBlack });
			
			// The End Portal Stone Thingy
			GameRegistry.addRecipe(new ItemStack(Blocks.end_portal_frame, 1),
					new Object[] { "EOE", "RNR", "TAT", 'E',
							ZollernBlocks.enderPearlBlock, 'O',
							ZollernBlocks.opal, 'R', Items.ender_eye, 'N',
							ZollernBlocks.netherizedObsidian, 'T',
							Blocks.glowstone, 'A', ZollernBlocks.staticAmber });
			
			// Lapis Stick
			GameRegistry.addRecipe(new ItemStack(ZollernItems.lapisStick, 1),
					new Object[] { " L ", " L ", "   ", 'L',
							ZollernItems.lapisIngot });
			
			// Power Stick
			GameRegistry.addRecipe(new ItemStack(ZollernItems.powerStick, 1),
					new Object[] { "LBL", "ASA", "ABA", 'L',
							ZollernItems.lapisIngot, 'B',
							ZollernBlocks.caveMarbleBlack, 'A',
							ZollernItems.amaranthIngot, 'S',
							ZollernItems.lapisStick });
			
			// Diablo
			GameRegistry.addRecipe(new ItemStack(ZollernItems.diabloSword, 1),
					new Object[] { " F ", " F ", "GPG", 'F',
							ZollernBlocks.fireGarnet, 'G', ZollernItems.garnet,
							'P', ZollernItems.powerStick });
			
			// Glacies
			GameRegistry.addRecipe(new ItemStack(ZollernItems.iceSword, 1),
					new Object[] { " I ", " I ", "APA", 'I',
							ZollernBlocks.icyAqua, 'A',
							ZollernItems.aquamarine, 'P',
							ZollernItems.powerStick });
			
			// Thor
			GameRegistry.addRecipe(new ItemStack(ZollernItems.thorSword, 1),
					new Object[] { " S ", " S ", "APA", 'S',
							ZollernBlocks.staticAmber, 'A', ZollernItems.amber,
							'P', ZollernItems.powerStick });
			
			// Ender
			GameRegistry
					.addRecipe(new ItemStack(ZollernItems.enderSword, 1),
							new Object[] { " E ", " E ", "OPM", 'E',
									ZollernBlocks.enderOpal, 'O',
									ZollernBlocks.enderDiamondBlock, 'M',
									ZollernItems.enderite, 'P',
									ZollernItems.powerStick });
			
			// Mortem
			GameRegistry.addRecipe(new ItemStack(ZollernItems.witherSword, 1),
					new Object[] { " W ", " W ", "RAX", 'W',
							ZollernBlocks.netheridiumBlock, 'R',
							ZollernItems.witherite, 'A',
							ZollernItems.powerStick, 'X',
							ZollernItems.shadowEssence });
			
			// Baby Ender Dragon Egg
			GameRegistry.addRecipe(new ItemStack(
					ZollernBlocks.babyEnderDragonEgg, 1), new Object[] { "A A",
					" B ", "A A", 'A', ZollernBlocks.azurite, 'B',
					Blocks.dragon_egg });
			
			// Ingot Stacks
			addIngotStack(Items.iron_ingot, ZollernBlocks.ironBlockIngot);
			addIngotStack(Items.gold_ingot, ZollernBlocks.goldBlockIngot);
			addIngotStack(ZollernItems.ingotFueltonium,
					ZollernBlocks.fueltoniumBlockIngot);
			addIngotStack(ZollernItems.amaranthIngot,
					ZollernBlocks.amaranthBlockIngot);
			addIngotStack(ZollernItems.zollerniumIngot,
					ZollernBlocks.zollerniumBlockIngot);
			addIngotStack(ZollernItems.zincIngot, ZollernBlocks.zincBlockIngot);
			addIngotStack(ZollernItems.lapisIngot,
					ZollernBlocks.lapisBlockIngot);
			addIngotStack(ZollernItems.shinestoneIngot,
					ZollernBlocks.shineStoneBlockIngot);
			addIngotStack(ZollernItems.shiniumIngot,
					ZollernBlocks.shiniumBlockIngot);
			
			// Colored Bricks
			addBricks(ZollernItems.bricksBlack, ZollernBlocks.bricksBlack);
			addBricks(ZollernItems.bricksBlue, ZollernBlocks.bricksBlue);
			addBricks(ZollernItems.bricksBrown, ZollernBlocks.bricksBrown);
			addBricks(ZollernItems.bricksCyan, ZollernBlocks.bricksCyan);
			addBricks(ZollernItems.bricksGray, ZollernBlocks.bricksGray);
			addBricks(ZollernItems.bricksGreen, ZollernBlocks.bricksGreen);
			addBricks(ZollernItems.bricksLightBlue,
					ZollernBlocks.bricksLightBlue);
			addBricks(ZollernItems.bricksLightGray,
					ZollernBlocks.bricksLightGray);
			addBricks(ZollernItems.bricksLime, ZollernBlocks.bricksLime);
			addBricks(ZollernItems.bricksMagenta, ZollernBlocks.bricksMagenta);
			addBricks(ZollernItems.bricksOrange, ZollernBlocks.bricksOrange);
			addBricks(ZollernItems.bricksPink, ZollernBlocks.bricksPink);
			addBricks(ZollernItems.bricksPurple, ZollernBlocks.bricksPurple);
			addBricks(ZollernItems.bricksRed, ZollernBlocks.bricksRed);
			addBricks(ZollernItems.bricksWhite, ZollernBlocks.bricksWhite);
			addBricks(ZollernItems.bricksYellow, ZollernBlocks.bricksYellow);
			
			// //Colored Bricks
			// // (Ingots)
			// Blue
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksBlue, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 4) // 4
			});
			// Red
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksRed, 1), new Object[] { Items.brick,
					new ItemStack(Items.dye, 1, 1) // 1
					});
			// Green
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksGreen, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 2) // 2
			});
			// Purple
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksPurple, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 5) // 5
			});
			// Cyan
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksCyan, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 6) // 6
			});
			// Pink
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksPink, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 9) // 9
			});
			// Yellow
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksYellow, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 11) // 11
			});
			// Black
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksBlack, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 0) });
			// White
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksWhite, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 15) });
			// Lime
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksLime, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 10) });
			// Brown
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksBrown, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 3) });
			// Magenta
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksMagenta, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 13) });
			// Light Blue
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksLightBlue, 1), new Object[] {
					Items.brick, new ItemStack(Items.dye, 1, 12) });
			// Light Gray
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksLightGray, 1), new Object[] {
					Items.brick, new ItemStack(Items.dye, 1, 7) });
			// Orange
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksOrange, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 14) });
			// Gray
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.bricksGray, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 8) });
			
			// Other Stuff
			addBricks(ZollernItems.shinedust, ZollernBlocks.shinestone);
			addBricks(ZollernItems.shinestoneIngot,
					ZollernBlocks.shinestoneCrystal);
			addBricks(ZollernBlocks.shinestoneCrystal,
					ZollernBlocks.shinestoneBricks, 4);
			addBricks(ZollernItems.swampClayBall, ZollernBlocks.swampClay, 4);
			addBricks(Items.magma_cream, ZollernBlocks.magmaBlock);
			
			// Andesite
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernBlocks.andesite, 2), new Object[] {
					ZollernBlocks.diorite, Blocks.cobblestone });
			
			// Granite
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernBlocks.granite, 2), new Object[] {
					ZollernBlocks.diorite, Items.quartz });
			
			// Diorite
			GameRegistry.addRecipe(new ItemStack(ZollernBlocks.diorite, 2),
					new Object[] { "NC ", "NC ", "   ", 'N', Items.quartz, 'C',
							Blocks.cobblestone });
			
			// Prismarine
			addOWBricks(ZollernItems.prismarineShard, ZollernBlocks.prismarine);
			
			// Prismarine Bricks
			GameRegistry.addRecipe(new ItemStack(
					ZollernBlocks.prismarineBricks, 1), new Object[] { "PPP",
					"PPP", "PPP", 'P', ZollernItems.prismarineShard });
			
			// Dark Prismarine
			GameRegistry.addRecipe(new ItemStack(ZollernBlocks.darkPrismarine,
					1), new Object[] { "PPP", "PIP", "PPP", 'P',
					ZollernItems.prismarineShard, 'I',
					new ItemStack(Items.dye, 1, 0) });
			
			// Sea Lantern
			GameRegistry.addRecipe(new ItemStack(ZollernBlocks.seaLantern, 1),
					new Object[] { "PCP", "CCC", "PCP", 'P',
							ZollernItems.prismarineShard, 'C',
							ZollernItems.prismarineCrystal });
			
			// Polished Crystal
			GameRegistry.addRecipe(new ItemStack(ZollernBlocks.polishedCrystal,
					1), new Object[] { "PCP", "SZS", "ICI", 'P',
					ZollernItems.prismarineShard, 'C',
					ZollernItems.prismarineCrystal, 'S',
					ZollernItems.shinedust, 'Z',
					ZollernBlocks.shinestoneCrystal, 'I',
					ZollernItems.shinestoneIngot });
			
			// Raw Chocolate
			GameRegistry.addRecipe(new ItemStack(ZollernItems.rawChocolate, 3),
					new Object[] { "CCC", "CEC", "CCC", 'C',
							new ItemStack(Items.dye, 1, 3), 'E', Items.egg });
			GameRegistry.addRecipe(new ItemStack(ZollernItems.rawChocolate, 3),
					new Object[] { "CCC", "CEC", "CCC", 'C',
							new ItemStack(Items.dye, 1, 3), 'E',
							ZollernItems.duckEgg });
			
			// Brownie
			GameRegistry.addRecipe(new ItemStack(ZollernItems.brownie, 4),
					new Object[] { "CC ", "CC ", "   ", 'C',
							ZollernItems.rawChocolate });
			
			// Candy Apple
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.candyApple, 1), new Object[] { Items.apple,
					ZollernItems.rawChocolate });
			
			// Cream Ball
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.creamBall, 3), new Object[] {
					Items.milk_bucket, Items.sugar });
			
			// Ice Cream
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.iceCream, 1), new Object[] {
					ZollernItems.creamBall, Items.bowl, Items.snowball });
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.iceCream, 1), new Object[] {
					ZollernItems.creamBall, Items.bowl, Blocks.ice });
			
			// Ice Cream Sandwich
			GameRegistry.addRecipe(new ItemStack(ZollernItems.iceCreamSandwich,
					1), new Object[] { "B  ", "C  ", "B  ", 'B',
					ZollernItems.brownie, 'C', ZollernItems.creamBall });
			GameRegistry.addRecipe(new ItemStack(ZollernItems.iceCreamSandwich,
					1), new Object[] { " B ", " C ", " B ", 'B',
					ZollernItems.brownie, 'C', ZollernItems.creamBall });
			GameRegistry.addRecipe(new ItemStack(ZollernItems.iceCreamSandwich,
					1), new Object[] { "  B", "  C", "  B", 'B',
					ZollernItems.brownie, 'C', ZollernItems.creamBall });
			
			// Cookie Block
			GameRegistry.addRecipe(new ItemStack(ZollernBlocks.cookieBlock, 1),
					new Object[] { "CCC", "CHC", "CCC", 'C', Items.cookie, 'H',
							ZollernBlocks.chocolateBlock });
			
			// ICSW Block
			fullBlockCraft(ZollernBlocks.iceCreamSandwichBlock,
					ZollernItems.iceCreamSandwich);
			
			// Brownie Block
			fullBlockCraft(ZollernBlocks.brownieBlock, ZollernItems.brownie);
			
			// Chocolate Bricks
			GameRegistry.addRecipe(new ItemStack(ZollernBlocks.chocolateBricks,
					4), new Object[] { "H H", " B ", "H H", 'H',
					ZollernBlocks.chocolateBlock, 'B', Blocks.brick_block });
			
			// Chocolate Block
			fullBlockCraft(ZollernBlocks.chocolateBlock,
					ZollernItems.chocolateBar);
			
			// Bone Block
			fullBlockCraft(ZollernBlocks.boneBlock, Items.bone);
			
			// Azurite
			fullBlockCraft(ZollernBlocks.azurite, ZollernItems.azurite);
			
			// Corn Kernels
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.cornKernel, 9),
					new Object[] { ZollernItems.corn });
			
			// Pea Seeds
			GameRegistry.addShapelessRecipe(new ItemStack(ZollernItems.pea, 4),
					new Object[] { ZollernItems.peaPod });
			
			// Tomato Seeds
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.tomatoSeeds, 4),
					new Object[] { ZollernItems.tomato });
			
			// Cucumber Seeds
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.cucumberSeeds, 4),
					new Object[] { ZollernItems.cucumberSeeds });
			
			// Tomato
			// addSeeds(ZollernItems.tomatoSeeds, ZollernItems.tomato);
			
			// Cucumber
			// addSeeds(ZollernItems.cucumberSeeds, ZollernItems.cucumber);
			
			// Chocolate Strawberry
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernItems.chocolateStrawberry, 1), new Object[] {
					ZollernItems.strawberry, ZollernItems.rawChocolate });
			
			// Limon Sapling
			GameRegistry.addShapelessRecipe(new ItemStack(
					ZollernBlocks.limonSapling, 1), new Object[] {
					ZollernBlocks.lemonSapling, ZollernBlocks.limeSapling });
			
			// Shine Torch
			GameRegistry.addRecipe(new ItemStack(ZollernBlocks.shinetorch, 4),
					new Object[] { "G  ", "S  ", 'G', ZollernItems.shinedust,
							'S', Items.stick });
			GameRegistry.addRecipe(new ItemStack(ZollernBlocks.shinetorch, 4),
					new Object[] { " G ", " S ", 'G', ZollernItems.shinedust,
							'S', Items.stick });
			
			// Nether Eye
			GameRegistry.addRecipe(new ItemStack(ZollernItems.netherEye, 1),
					new Object[] { "NBN", "WEW", "IOI", 'N',
							ZollernItems.netheridium, 'B', Items.blaze_powder,
							'W', ZollernItems.witherite, 'E', Items.ender_eye,
							'O', Blocks.obsidian });
			
			// Logs -> Planks
			addLogPlanks(ZollernBlocks.bananaLog, ZollernBlocks.bananaPlanks);
			addLogPlanks(ZollernBlocks.orangeLog, ZollernBlocks.orangePlanks);
			addLogPlanks(ZollernBlocks.guavaLog, ZollernBlocks.guavaPlanks);
			addLogPlanks(ZollernBlocks.lemonLog, ZollernBlocks.lemonPlanks);
			addLogPlanks(ZollernBlocks.limeLog, ZollernBlocks.limePlanks);
			addLogPlanks(ZollernBlocks.limonLog, ZollernBlocks.limonPlanks);
			addLogPlanks(ZollernBlocks.cherryLog, ZollernBlocks.cherryPlanks);
			addLogPlanks(ZollernBlocks.grapefruitLog,
					ZollernBlocks.grapefruitPlanks);
			
			// Quiver
			GameRegistry.addRecipe(new ItemStack(ZollernItems.quiver, 1),
					new Object[] { " F ", " S ", " L ", 'F', Items.feather,
				'S', Items.string, 'L', Items.leather });
		}
		
		public static void addHorseArmor(Item horseArmor, Block armorMetal) {
			GameRegistry.addRecipe(new ItemStack(horseArmor, 1),
					new Object[] { "I I", " I ", "OOO", 'I', armorMetal, 'O',
							Blocks.obsidian });
		}
		
		public static void addSeeds(Item crop, Item seeds) {
			GameRegistry.addShapelessRecipe(new ItemStack(seeds, 2),
					new Object[] { crop });
		}
		
		private static void addOWBricks(Item itemInput, Block blockOutput) {
			GameRegistry.addRecipe(new ItemStack(blockOutput, 4), new Object[] {
					"CC ", "CC ", "   ", 'C', itemInput });
		}
		
		public static void addBricks(Item coloredBrick, Block coloredBlock) {
			GameRegistry.addRecipe(new ItemStack(coloredBlock, 1),
					new Object[] { "CC ", "CC ", "   ", 'C', coloredBrick });
			GameRegistry.addShapelessRecipe(new ItemStack(coloredBrick, 4),
					new Object[] { coloredBlock });
		}
		
		public static void addBricks(Block coloredBrick, Block coloredBlock) {
			GameRegistry.addRecipe(new ItemStack(coloredBlock, 1),
					new Object[] { "CC ", "CC ", "   ", 'C', coloredBrick });
			GameRegistry.addShapelessRecipe(new ItemStack(coloredBrick, 4),
					new Object[] { coloredBlock });
		}
		
		public static void addBricks(Item coloredBrick, Block coloredBlock,
				int numOutput) {
			GameRegistry.addRecipe(new ItemStack(coloredBlock, numOutput),
					new Object[] { "CC ", "CC ", "   ", 'C', coloredBrick });
			GameRegistry.addShapelessRecipe(new ItemStack(coloredBrick, 4),
					new Object[] { coloredBlock });
		}
		
		public static void addBricks(Block coloredBrick, Block coloredBlock,
				int numOutput) {
			GameRegistry.addRecipe(new ItemStack(coloredBlock, numOutput),
					new Object[] { "CC ", "CC ", "   ", 'C', coloredBrick });
			GameRegistry.addShapelessRecipe(new ItemStack(coloredBrick, 4),
					new Object[] { coloredBlock });
		}
		
		public static void addOWBricks(Block blockInput, Block blockOutput) {
			GameRegistry.addRecipe(new ItemStack(blockOutput, 4), new Object[] {
					"CC ", "CC ", "   ", 'C', blockInput });
		}
		
		public static void fullBlockCraft(Block block, Item item, int numItem) {
			GameRegistry.addRecipe(new ItemStack(block, 1), new Object[] {
					"SSS", "SSS", "SSS", 'S', item });
			GameRegistry.addShapelessRecipe(new ItemStack(item, numItem),
					new Object[] { block });
		}
		
		public static void fullBlockCraft(Block block, Item item) {
			fullBlockCraft(block, item, 9);
		}
		
		public static void addIngotStack(Item ingot, Block ingotStack) {
			GameRegistry.addRecipe(new ItemStack(ingotStack, 1), new Object[] {
					" I ", "I I", "III", 'I', ingot });
		}
		
		public static void addLogPlanks(Block log, Block planks) {
			GameRegistry.addShapelessRecipe(new ItemStack(planks, 4),
					new Object[] { log });
		}
	}
	
	public static class Smelting {
		static void init() {
			addSmelting(ZollernBlocks.spcOre, new ItemStack(
					ZollernItems.spcItem, 2), 5F);
			addSmelting(ZollernBlocks.fueltonium, new ItemStack(
					ZollernItems.ingotFueltonium), 2F);
			addSmelting(ZollernItems.fuelonite, ZollernItems.ingotFueltonium,
					2F);
			addSmelting(ZollernBlocks.amaranthOre, ZollernItems.amaranthIngot,
					6F);
			addSmelting(ZollernItems.amaranthDust, ZollernItems.amaranthIngot,
					4F);
			addSmelting(ZollernItems.zincDust, ZollernItems.zincIngot, 8F);
			addSmelting(ZollernItems.zollerniumDust,
					ZollernItems.zollerniumIngot, 4F);
			addSmelting(ZollernBlocks.zincOre, ZollernItems.zincIngot, 10F);
			addSmelting(ZollernBlocks.redRockCobble, ZollernBlocks.redRock, 1F);
			addSmelting(ZollernItems.flour, new ItemStack(Items.bread, 2), 0.5F);
			if (ZEConfig.rottenFleshCooksIntoLeather) {
				addSmelting(Items.rotten_flesh, Items.leather, 2F);
			}
			addSmelting(Block.getBlockById(13), ZollernBlocks.betterGlass, 1F);
			addSmelting(ZollernItems.shinedust, ZollernItems.shinestoneIngot,
					3F);
			addSmelting(ZollernBlocks.amaranthNetherOre, new ItemStack(
					ZollernBlocks.amaranthOre, 2), 6F);
			addSmelting(ZollernBlocks.zincNetherOre, new ItemStack(
					ZollernBlocks.zincOre, 2), 6F);
			addSmelting(ZollernBlocks.spcNetherOre, new ItemStack(
					ZollernBlocks.spcOre, 2), 6F);
			addSmelting(ZollernBlocks.fuelNetherOre, new ItemStack(
					ZollernBlocks.fueltonium, 4), 6F);
			addSmelting(ZollernBlocks.enderShardNetherOre, new ItemStack(
					ZollernBlocks.enderShardOre, 2), 6F);
			addSmelting(new ItemStack(Items.dye, 1, 4), new ItemStack(
					ZollernItems.lapisIngot, 1), 2F);
			addSmelting(new ItemStack(Items.egg, 1), new ItemStack(
					ZollernItems.boiledEgg, 1), 2F);
			addSmelting(new ItemStack(ZollernItems.duckEgg, 1), new ItemStack(
					ZollernItems.boiledEgg, 1), 2.5F);
			addSmelting(new ItemStack(ZollernItems.rawDuck, 1), new ItemStack(
					ZollernItems.cookedDuck, 1), 2F);
			addSmelting(new ItemStack(ZollernItems.rawShrimp, 1),
					new ItemStack(ZollernItems.cookedShrimp, 1), 2F);
			addSmelting(new ItemStack(ZollernItems.rawBacon, 1), new ItemStack(
					ZollernItems.cookedBacon, 1), 2F);
			addSmelting(new ItemStack(ZollernItems.rawLamb, 1), new ItemStack(
					ZollernItems.cookedLamb, 1), 2F);
			addSmelting(new ItemStack(Blocks.waterlily, 1), new ItemStack(
					ZollernItems.greenDye, 1), 1F);
			addSmelting(new ItemStack(ZollernItems.obsidianDust, 1),
					new ItemStack(ZollernItems.obsidianIngot, 1), 6F);
			addSmelting(new ItemStack(ZollernItems.rawChocolate, 1),
					new ItemStack(ZollernItems.chocolateBar, 1), 2F);
			addSmelting(new ItemStack(ZollernItems.cornKernel, 1),
					new ItemStack(ZollernItems.popcorn, 1), 1F);
			addSmelting(ZollernItems.swampClayBall, ZollernItems.bricksMud,
					0.2F);
			addSmelting(ZollernItems.dough, ZollernItems.cookedDough, 0.4F);
			
			// Upside-Down
			addSmelting(ZollernBlocks.upsideDownAmaranthOre, new ItemStack(
					ZollernBlocks.amaranthOre, 2), 1.0F);
			addSmelting(ZollernBlocks.upsideDownDiamondOre, new ItemStack(
					Blocks.diamond_ore, 2), 1.0F);
			addSmelting(ZollernBlocks.upsideDownEmeraldOre, new ItemStack(
					Blocks.emerald_ore, 2), 1.0F);
			addSmelting(ZollernBlocks.upsideDownGoldOre, new ItemStack(
					Blocks.gold_ore, 2), 1.0F);
			addSmelting(ZollernBlocks.upsideDownIronOre, new ItemStack(
					Blocks.iron_ore, 2), 1.0F);
			addSmelting(ZollernBlocks.upsideDownRubyOre, new ItemStack(
					ZollernBlocks.rubyOre, 2), 1.0F);
			addSmelting(ZollernBlocks.upsideDownSapphireOre, new ItemStack(
					ZollernBlocks.sapphireOre, 2), 1.0F);
			addSmelting(ZollernBlocks.upsideDownZincOre, new ItemStack(
					ZollernBlocks.zincOre, 2), 1.0F);
			addSmelting(ZollernBlocks.zollerniumOre, new ItemStack(
					ZollernItems.zollerniumIngot, 1), 0.5F);
			addSmelting(ZollernBlocks.upsideDownCobble,
					ZollernBlocks.upsideDownStone, 0.5F);
			
		}
		
		private static void addSmelting(ItemStack input, ItemStack output,
				float xp) {
			GameRegistry.addSmelting(input, output, xp);
			FurnaceRecipes.smelting().func_151394_a(input, output, xp);
			ThermalExpansionHelper.addFurnaceRecipe(500, input, output);
		}
		
		private static void addSmelting(Block input, Item output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
		
		public static void addSmelting(Item input, ItemStack output, float xp) {
			GameRegistry.addSmelting(input, output, xp);
			FurnaceRecipes.smelting().func_151394_a(new ItemStack(input, 1),
					output, xp);
			ThermalExpansionHelper.addFurnaceRecipe(500,
					new ItemStack(input, 1), output);
		}
		
		public static void addSmelting(Item input, Item output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
		
		public static void addSmelting(Block input, ItemStack output, float xp) {
			GameRegistry.addSmelting(input, output, xp);
			FurnaceRecipes.smelting().func_151393_a(input, output, xp);
			ThermalExpansionHelper.addFurnaceRecipe(500,
					new ItemStack(input, 1), output);
		}
		
		public static void addSmelting(Block input, Block output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
	}
}