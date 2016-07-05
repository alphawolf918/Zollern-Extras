package zollernextras.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import zollernextras.blocks.BlockList;
import zollernextras.config.ZEConfig;
import zollernextras.items.ItemList;
import zollernextras.lib.modhelper.ThermalExpansionHelper;
import zollernextras.lib.recipes.InductionSmelterRecipes;
import zollernextras.lib.recipes.LiquidRecipes;
import zollernextras.lib.recipes.PulverizerRecipes;
import zollernextras.lib.recipes.ToolArmorRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init() {
		Crafting.init();
		MainHelper.Log("Crafting recipes successfully loaded.");
		Smelting.init();
		MainHelper.Log("Furnace recipes successfully loaded.");
		PulverizerRecipes.init();
		MainHelper.Log("Pulverizer recipes successfully loaded.");
		InductionSmelterRecipes.init();
		MainHelper.Log("Induction smelter recipes successfully loaded.");
		LiquidRecipes.init();
	}
	
	static class Crafting {
		static void init() {
			ToolArmorRecipes.init();
			
			// Cold Smoothstone
			ItemStack css = new ItemStack(BlockList.icyStone, 4);
			GameRegistry.addRecipe(css, new Object[] { "CC ", "CC ", "   ",
					'C', BlockList.icySand });
			
			// Popcorn Bowl
			GameRegistry.addRecipe(new ItemStack(ItemList.popcornBowl, 1),
					new Object[] { "PPP", "PBP", "PPP", 'P', ItemList.popcorn,
							'B', Items.bowl });
			
			// Red Rock
			ItemStack rrb = new ItemStack(BlockList.redRockBrick, 4);
			GameRegistry.addRecipe(rrb, new Object[] { "SS ", "SS ", "   ",
					'S', BlockList.redRock });
			
			// Silver
			GameRegistry.addRecipe(new ItemStack(ItemList.silverIngot, 1),
					new Object[] { "NNN", "NNN", "NNN", 'N',
							ItemList.silverNugget });
			
			if (ZEConfig.vanillaItemsAreCraftable) {
				// Name Tag
				GameRegistry.addRecipe(
						new ItemStack(Item.getItemById(421), 2),
						new Object[] { "  I", " S ", "S  ", 'S',
								ItemList.swampClayBall, 'I',
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
				GameRegistry.addRecipe(new ItemStack(BlockList.redNetherBricks,
						2), new Object[] { "NB ", "BN ", "   ", 'B',
						Items.netherbrick, 'N', Items.nether_wart });
			}
			
			// Ender Shards to Ender Pearl
			GameRegistry.addRecipe(new ItemStack(Item.getItemById(368), 1),
					new Object[] { "RRR", "R R", "RRR", 'R',
							ItemList.enderShard });
			
			// Ender Pearl to Ender Shards
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.enderShard,
					8), new Object[] { Item.getItemById(368) });
			
			// Amaranth
			fullBlockCraft(BlockList.amaranthBlock, ItemList.amaranthIngot);
			
			// Fueltonium
			fullBlockCraft(BlockList.fueltoniumBlock, ItemList.ingotFueltonium);
			
			// Torches
			GameRegistry.addRecipe(new ItemStack(Block.getBlockById(50), 8),
					new Object[] { "G  ", "S  ", 'G', ItemList.spcItem, 'S',
							Items.stick });
			GameRegistry.addRecipe(new ItemStack(Block.getBlockById(50), 8),
					new Object[] { " G ", " S ", 'G', ItemList.spcItem, 'S',
							Items.stick });
			
			// Zinc Ingot (to block)
			fullBlockCraft(BlockList.zincBlock, ItemList.zincIngot);
			
			// Zollernium Ingot (to block)
			fullBlockCraft(BlockList.zollerniumBlock, ItemList.zollerniumIngot);
			
			// Sirens
			GameRegistry.addRecipe(
					new ItemStack(BlockList.ironSiren, 1),
					new Object[] { "OIO", "IRI", "OIO", 'O',
							Block.getBlockById(49), 'I', Item.getItemById(265),
							'R', Item.getItemById(331) });
			GameRegistry.addRecipe(
					new ItemStack(BlockList.goldSiren, 1),
					new Object[] { "OIO", "IRI", "OIO", 'O',
							Block.getBlockById(49), 'I', Item.getItemById(266),
							'R', Item.getItemById(331) });
			GameRegistry.addRecipe(
					new ItemStack(BlockList.diamondSiren, 1),
					new Object[] { "OIO", "IRI", "OIO", 'O',
							Block.getBlockById(49), 'I', Item.getItemById(264),
							'R', Item.getItemById(331) });
			GameRegistry.addRecipe(
					new ItemStack(BlockList.emeraldSiren, 1),
					new Object[] { "OIO", "IRI", "OIO", 'O',
							Block.getBlockById(49), 'I', Item.getItemById(388),
							'R', Item.getItemById(331) });
			
			// Black Cave Marble Block
			GameRegistry.addRecipe(
					new ItemStack(BlockList.caveMarbleBlack, 8),
					new Object[] { "III", "IMI", "III", 'I',
							new ItemStack(Item.getItemById(351), 1, 0), 'M',
							BlockList.caveMarbleWhite });
			
			// Blaze Rod
			GameRegistry
					.addRecipe(new ItemStack(Items.blaze_rod, 1), new Object[] {
							" B ", "BSB", " B ", 'B', Items.blaze_powder, 'S',
							ItemList.blackMarbleStick });
			
			// Healing Heart
			GameRegistry.addRecipe(new ItemStack(ItemList.heart), new Object[] {
					"AZA", "AOA", "ARA", 'A', ItemList.amaranthIngot, 'O',
					ItemList.zollerniumIngot, 'R', Item.getItemById(331) });
			
			// Health Upgrade
			GameRegistry.addRecipe(new ItemStack(ItemList.heartForce),
					new Object[] { "ZSZ", "ZHZ", "ZZZ", 'Z',
							ItemList.zincIngot, 'S', ItemList.zollerniumIngot,
							'H', ItemList.heart });
			
			// Sea Lamps
			GameRegistry.addRecipe(new ItemStack(BlockList.seaLamp),
					new Object[] { "L L", " S ", "L L", 'L',
							ItemList.lapisIngot, 'S', BlockList.shinestone });
			
			// SPC Block
			fullBlockCraft(BlockList.spcBlock, ItemList.spcItem);
			
			// Shinium Ingot
			fullBlockCraft(BlockList.shiniumBlock, ItemList.shiniumIngot);
			
			// Firey Garnet (Gem Form)
			GameRegistry.addRecipe(new ItemStack(ItemList.fireGarnet, 1),
					new Object[] { "BLB", "RGR", "BLB", 'B',
							Items.blaze_powder, 'G', BlockList.garnet, 'R',
							Items.redstone, 'L', Items.blaze_rod });
			
			// Icy Aqua (Gem Form)
			GameRegistry.addRecipe(new ItemStack(ItemList.icyAqua, 1),
					new Object[] { "SDS", "ZAZ", "AAA", 'S',
							ItemList.shiniumIngot, 'Z', ItemList.shinedust,
							'A', BlockList.aqua, 'D', Items.diamond });
			
			// Static Amber (Gem Form)
			GameRegistry.addRecipe(new ItemStack(ItemList.staticAmber, 1),
					new Object[] { "GTG", "UAU", "ZTZ", 'G', Items.gold_ingot,
							'T', ItemList.topaz, 'A', BlockList.amber, 'Z',
							ItemList.zincIngot, 'U', ItemList.azurite });
			
			// Ender Opal (Gem Form)
			GameRegistry.addRecipe(new ItemStack(ItemList.enderOpal, 1),
					new Object[] { "FPF", "EOE", "EME", 'F', Items.ender_eye,
							'P', Items.ender_pearl, 'E', ItemList.enderite,
							'O', BlockList.opal, 'M', Items.emerald });
			
			// Netheridium (Gem Form)
			GameRegistry
					.addRecipe(new ItemStack(ItemList.netheridium, 1),
							new Object[] { "BSB", "LXL", "VAV", 'B',
									ItemList.shadowEssence, 'S',
									ItemList.spcItem, 'V', ItemList.garnet,
									'X', BlockList.witheriteBlock, 'V',
									Items.blaze_powder, 'A',
									ItemList.shadowBone });
			
			// Shinium
			GameRegistry.addRecipe(new ItemStack(ItemList.shiniumIngot, 1),
					new Object[] { "DLD", "DSD", "DLD", 'D', Items.diamond,
							'S', ItemList.shinestoneIngot, 'L',
							ItemList.lapisIngot });
			
			// Crimson Obsidian
			GameRegistry.addRecipe(new ItemStack(BlockList.redObsidian, 2),
					new Object[] { "BN ", "NB ", "   ", 'B',
				BlockList.netherWartBlock, 'N', Blocks.obsidian });
			
			// Netherized Obsidian
			GameRegistry.addRecipe(new ItemStack(BlockList.netherizedObsidian,
					1), new Object[] { "WNW", "NON", "SNS", 'N',
					BlockList.netheridiumBlock, 'W', BlockList.witheriteBlock,
					'O', BlockList.redObsidian, 'S', ItemList.shadowEssence });
			
			// Garnet
			fullBlockCraft(BlockList.garnet, ItemList.garnet);
			
			// Aquamarine
			fullBlockCraft(BlockList.aqua, ItemList.aquamarine);
			
			// Amber
			fullBlockCraft(BlockList.amber, ItemList.amber);
			
			// Opal
			fullBlockCraft(BlockList.opal, ItemList.opal);
			
			// Topaz
			fullBlockCraft(BlockList.topaz, ItemList.topaz);
			
			// Enderite
			fullBlockCraft(BlockList.enderite, ItemList.enderite);
			
			// Witherite
			fullBlockCraft(BlockList.witheriteBlock, ItemList.witherite);
			
			// Ruby
			fullBlockCraft(BlockList.rubyBlock, ItemList.ruby);
			
			// Sapphire
			fullBlockCraft(BlockList.sapphireBlock, ItemList.sapphire);
			
			// Fire Garnet
			fullBlockCraft(BlockList.fireGarnet, ItemList.fireGarnet);
			
			// Icy Aqua
			fullBlockCraft(BlockList.icyAqua, ItemList.icyAqua);
			
			// Static Amber
			fullBlockCraft(BlockList.staticAmber, ItemList.staticAmber);
			
			// Ender Opal
			fullBlockCraft(BlockList.enderOpal, ItemList.enderOpal);
			
			// Netheridium
			fullBlockCraft(BlockList.netheridiumBlock, ItemList.netheridium);
			
			// Ender Pearl Block
			fullBlockCraft(BlockList.enderPearlBlock, Items.ender_pearl);
			
			// Sugar
			fullBlockCraft(BlockList.sugarCube, Items.sugar);
			
			// Nether Wart Block
			fullBlockCraft(BlockList.netherWartBlock, Items.nether_wart);
			
			// Polished Andesite
			addOWBricks(BlockList.andesite, BlockList.polishedAndesite);
			
			// Polished Diorite
			addOWBricks(BlockList.diorite, BlockList.polishedDiorite);
			
			// Polished Granite
			addOWBricks(BlockList.granite, BlockList.polishedGranite);
			
			// Endstone Bricks
			addOWBricks(Blocks.end_stone, BlockList.endStoneBricks);
			
			// Obsidian
			GameRegistry.addRecipe(new ItemStack(Blocks.obsidian, 1),
					new Object[] { "OOO", "O O", "OOO", 'O',
							ItemList.obsidianIngot });
			GameRegistry.addShapelessRecipe(new ItemStack(
					ItemList.obsidianIngot, 8),
					new Object[] { Blocks.obsidian });
			
			// White Cave Marble Stick
			GameRegistry.addRecipe(new ItemStack(ItemList.marbleStick, 2),
					new Object[] { "B  ", "B  ", "   ", 'B',
							BlockList.caveMarbleWhite });
			
			// Black Cave Marble Stick
			GameRegistry.addRecipe(new ItemStack(ItemList.blackMarbleStick, 2),
					new Object[] { "B  ", "B  ", "   ", 'B',
							BlockList.caveMarbleBlack });
			
			// The End Portal Stone Thingy
			GameRegistry.addRecipe(new ItemStack(Blocks.end_portal_frame, 1),
					new Object[] { "EOE", "RNR", "TAT", 'E',
							BlockList.enderPearlBlock, 'O', BlockList.opal,
							'R', Items.ender_eye, 'N',
							BlockList.netherizedObsidian, 'T',
							Blocks.glowstone, 'A', BlockList.staticAmber });
			
			// Lapis Stick
			GameRegistry.addRecipe(new ItemStack(ItemList.lapisStick, 1),
					new Object[] { " L ", " L ", "   ", 'L',
							ItemList.lapisIngot });
			
			// Power Stick
			GameRegistry.addRecipe(new ItemStack(ItemList.powerStick, 1),
					new Object[] { "LBL", "ASA", "ABA", 'L',
							ItemList.lapisIngot, 'B',
							BlockList.caveMarbleBlack, 'A',
							ItemList.amaranthIngot, 'S', ItemList.lapisStick });
			
			// Diablo
			GameRegistry.addRecipe(new ItemStack(ItemList.diabloSword, 1),
					new Object[] { " F ", " F ", "GPG", 'F',
							BlockList.fireGarnet, 'G', ItemList.garnet, 'P',
							ItemList.powerStick });
			
			// Glacies
			GameRegistry
					.addRecipe(new ItemStack(ItemList.iceSword, 1),
							new Object[] { " I ", " I ", "APA", 'I',
									BlockList.icyAqua, 'A',
									ItemList.aquamarine, 'P',
									ItemList.powerStick });
			
			// Thor
			GameRegistry.addRecipe(new ItemStack(ItemList.thorSword, 1),
					new Object[] { " S ", " S ", "APA", 'S',
							BlockList.staticAmber, 'A', ItemList.amber, 'P',
							ItemList.powerStick });
			
			// Ender
			GameRegistry.addRecipe(new ItemStack(ItemList.enderSword, 1),
					new Object[] { " E ", " E ", "OPM", 'E',
							BlockList.enderOpal, 'O', ItemList.opal, 'M',
							ItemList.enderite, 'P', ItemList.powerStick });
			
			// Mortem
			GameRegistry.addRecipe(new ItemStack(ItemList.witherSword, 1),
					new Object[] { " W ", " W ", "RAX", 'W',
							BlockList.netheridiumBlock, 'R',
							ItemList.witherite, 'A', ItemList.powerStick, 'X',
							ItemList.shadowEssence });
			
			// Baby Ender Dragon Egg
			GameRegistry.addRecipe(new ItemStack(BlockList.babyEnderDragonEgg,
					1), new Object[] { "A A", " B ", "A A", 'A',
					BlockList.azurite, 'B', Blocks.dragon_egg });
			
			// Ingot Stacks
			addIngotStack(Items.iron_ingot, BlockList.ironBlockIngot);
			addIngotStack(Items.gold_ingot, BlockList.goldBlockIngot);
			addIngotStack(ItemList.ingotFueltonium,
					BlockList.fueltoniumBlockIngot);
			addIngotStack(ItemList.amaranthIngot, BlockList.amaranthBlockIngot);
			addIngotStack(ItemList.zollerniumIngot,
					BlockList.zollerniumBlockIngot);
			addIngotStack(ItemList.zincIngot, BlockList.zincBlockIngot);
			addIngotStack(ItemList.lapisIngot, BlockList.lapisBlockIngot);
			addIngotStack(ItemList.shinestoneIngot,
					BlockList.shineStoneBlockIngot);
			addIngotStack(ItemList.shiniumIngot, BlockList.shiniumBlockIngot);
			
			// Colored Bricks
			addBricks(ItemList.bricksBlack, BlockList.bricksBlack);
			addBricks(ItemList.bricksBlue, BlockList.bricksBlue);
			addBricks(ItemList.bricksBrown, BlockList.bricksBrown);
			addBricks(ItemList.bricksCyan, BlockList.bricksCyan);
			addBricks(ItemList.bricksGray, BlockList.bricksGray);
			addBricks(ItemList.bricksGreen, BlockList.bricksGreen);
			addBricks(ItemList.bricksLightBlue, BlockList.bricksLightBlue);
			addBricks(ItemList.bricksLightGray, BlockList.bricksLightGray);
			addBricks(ItemList.bricksLime, BlockList.bricksLime);
			addBricks(ItemList.bricksMagenta, BlockList.bricksMagenta);
			addBricks(ItemList.bricksOrange, BlockList.bricksOrange);
			addBricks(ItemList.bricksPink, BlockList.bricksPink);
			addBricks(ItemList.bricksPurple, BlockList.bricksPurple);
			addBricks(ItemList.bricksRed, BlockList.bricksRed);
			addBricks(ItemList.bricksWhite, BlockList.bricksWhite);
			addBricks(ItemList.bricksYellow, BlockList.bricksYellow);
			
			// //Colored Bricks
			// // (Ingots)
			// Blue
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.bricksBlue,
					1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 4) // 4
			});
			// Red
			GameRegistry.addShapelessRecipe(
					new ItemStack(ItemList.bricksRed, 1), new Object[] {
						Items.brick, new ItemStack(Items.dye, 1, 1) // 1
					});
			// Green
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.bricksGreen,
					1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 2) // 2
			});
			// Purple
			GameRegistry.addShapelessRecipe(new ItemStack(
					ItemList.bricksPurple, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 5) // 5
			});
			// Cyan
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.bricksCyan,
					1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 6) // 6
			});
			// Pink
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.bricksPink,
					1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 9) // 9
			});
			// Yellow
			GameRegistry.addShapelessRecipe(new ItemStack(
					ItemList.bricksYellow, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 11) // 11
			});
			// Black
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.bricksBlack,
					1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 0) });
			// White
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.bricksWhite,
					1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 15) });
			// Lime
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.bricksLime,
					1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 10) });
			// Brown
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.bricksBrown,
					1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 3) });
			// Magenta
			GameRegistry.addShapelessRecipe(new ItemStack(
					ItemList.bricksMagenta, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 13) });
			// Light Blue
			GameRegistry.addShapelessRecipe(new ItemStack(
					ItemList.bricksLightBlue, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 12) });
			// Light Gray
			GameRegistry.addShapelessRecipe(new ItemStack(
					ItemList.bricksLightGray, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 7) });
			// Orange
			GameRegistry.addShapelessRecipe(new ItemStack(
					ItemList.bricksOrange, 1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 14) });
			// Gray
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.bricksGray,
					1), new Object[] { Items.brick,
				new ItemStack(Items.dye, 1, 8) });
			
			// Other Stuff
			addBricks(ItemList.shinedust, BlockList.shinestone);
			addBricks(ItemList.shinestoneIngot, BlockList.shinestoneCrystal);
			addBricks(BlockList.shinestoneCrystal, BlockList.shinestoneBricks,
					4);
			addBricks(ItemList.swampClayBall, BlockList.swampClay, 4);
			addBricks(Items.magma_cream, BlockList.magmaBlock);
			
			// Andesite
			GameRegistry.addShapelessRecipe(
					new ItemStack(BlockList.andesite, 2), new Object[] {
							BlockList.diorite, Blocks.cobblestone });
			
			// Granite
			GameRegistry.addShapelessRecipe(
					new ItemStack(BlockList.granite, 2), new Object[] {
							BlockList.diorite, Items.quartz });
			
			// Diorite
			GameRegistry.addRecipe(new ItemStack(BlockList.diorite, 2),
					new Object[] { "NC ", "NC ", "   ", 'N', Items.quartz, 'C',
							Blocks.cobblestone });
			
			// Prismarine
			addOWBricks(ItemList.prismarineShard, BlockList.prismarine);
			
			// Prismarine Bricks
			GameRegistry.addRecipe(
					new ItemStack(BlockList.prismarineBricks, 1),
					new Object[] { "PPP", "PPP", "PPP", 'P',
							ItemList.prismarineShard });
			
			// Dark Prismarine
			GameRegistry.addRecipe(new ItemStack(BlockList.darkPrismarine, 1),
					new Object[] { "PPP", "PIP", "PPP", 'P',
							ItemList.prismarineShard, 'I',
							new ItemStack(Items.dye, 1, 0) });
			
			// Sea Lantern
			GameRegistry.addRecipe(new ItemStack(BlockList.seaLantern, 1),
					new Object[] { "PCP", "CCC", "PCP", 'P',
							ItemList.prismarineShard, 'C',
							ItemList.prismarineCrystal });
			
			// Polished Crystal
			GameRegistry.addRecipe(new ItemStack(BlockList.polishedCrystal, 1),
					new Object[] { "PCP", "SZS", "ICI", 'P',
							ItemList.prismarineShard, 'C',
							ItemList.prismarineCrystal, 'S',
							ItemList.shinedust, 'Z',
							BlockList.shinestoneCrystal, 'I',
							ItemList.shinestoneIngot });
			
			// Raw Chocolate
			GameRegistry.addRecipe(new ItemStack(ItemList.rawChocolate, 3),
					new Object[] { "CCC", "CEC", "CCC", 'C',
							new ItemStack(Items.dye, 1, 3), 'E', Items.egg });
			GameRegistry.addRecipe(new ItemStack(ItemList.rawChocolate, 3),
					new Object[] { "CCC", "CEC", "CCC", 'C',
							new ItemStack(Items.dye, 1, 3), 'E',
							ItemList.duckEgg });
			
			// Brownie
			GameRegistry.addRecipe(new ItemStack(ItemList.brownie, 4),
					new Object[] { "CC ", "CC ", "   ", 'C',
							ItemList.rawChocolate });
			
			// Candy Apple
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.candyApple,
					1), new Object[] { Items.apple, ItemList.rawChocolate });
			
			// Cream Ball
			GameRegistry.addShapelessRecipe(
					new ItemStack(ItemList.creamBall, 3), new Object[] {
							Items.milk_bucket, Items.sugar });
			
			// Ice Cream
			GameRegistry.addShapelessRecipe(
					new ItemStack(ItemList.iceCream, 1), new Object[] {
							ItemList.creamBall, Items.bowl, Items.snowball });
			GameRegistry.addShapelessRecipe(
					new ItemStack(ItemList.iceCream, 1), new Object[] {
							ItemList.creamBall, Items.bowl, Blocks.ice });
			
			// Ice Cream Sandwich
			GameRegistry.addRecipe(new ItemStack(ItemList.iceCreamSandwich, 1),
					new Object[] { "B  ", "C  ", "B  ", 'B', ItemList.brownie,
							'C', ItemList.creamBall });
			GameRegistry.addRecipe(new ItemStack(ItemList.iceCreamSandwich, 1),
					new Object[] { " B ", " C ", " B ", 'B', ItemList.brownie,
							'C', ItemList.creamBall });
			GameRegistry.addRecipe(new ItemStack(ItemList.iceCreamSandwich, 1),
					new Object[] { "  B", "  C", "  B", 'B', ItemList.brownie,
							'C', ItemList.creamBall });
			
			// Cookie Block
			GameRegistry.addRecipe(new ItemStack(BlockList.cookieBlock, 1),
					new Object[] { "CCC", "CHC", "CCC", 'C', Items.cookie, 'H',
							BlockList.chocolateBlock });
			
			// ICSW Block
			fullBlockCraft(BlockList.iceCreamSandwichBlock,
					ItemList.iceCreamSandwich);
			
			// Brownie Block
			fullBlockCraft(BlockList.brownieBlock, ItemList.brownie);
			
			// Chocolate Bricks
			GameRegistry
					.addRecipe(new ItemStack(BlockList.chocolateBricks, 4),
							new Object[] { "H H", " B ", "H H", 'H',
									BlockList.chocolateBlock, 'B',
									Blocks.brick_block });
			
			// Chocolate Block
			fullBlockCraft(BlockList.chocolateBlock, ItemList.chocolateBar);
			
			// Bone Block
			fullBlockCraft(BlockList.boneBlock, Items.bone);
			
			// Azurite
			fullBlockCraft(BlockList.azurite, ItemList.azurite);
			
			// Corn Kernels
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.cornKernel,
					9), new Object[] { ItemList.corn });
			
			// Pea Seeds
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.pea, 4),
					new Object[] { ItemList.peaPod });
			
			// Tomato Seeds
			GameRegistry.addShapelessRecipe(new ItemStack(ItemList.tomatoSeeds,
					4), new Object[] { ItemList.tomato });
			
			// Cucumber Seeds
			GameRegistry.addShapelessRecipe(new ItemStack(
					ItemList.cucumberSeeds, 4),
					new Object[] { ItemList.cucumberSeeds });
			
			// Tomato
			addSeeds(ItemList.tomatoSeeds, ItemList.tomato);
			
			// Cucumber
			addSeeds(ItemList.cucumberSeeds, ItemList.cucumber);
			
			// Chocolate Strawberry
			GameRegistry.addShapelessRecipe(new ItemStack(
					ItemList.chocolateStrawberry, 1), new Object[] {
					ItemList.strawberry, ItemList.rawChocolate });
			
			// Limon Sapling
			GameRegistry.addShapelessRecipe(new ItemStack(
					BlockList.limonSapling, 1), new Object[] {
					BlockList.lemonSapling, BlockList.limeSapling });
			
			// Shine Torch
			GameRegistry.addRecipe(new ItemStack(BlockList.shinetorch, 4),
					new Object[] { "G  ", "S  ", 'G', ItemList.shinedust, 'S',
							Items.stick });
			GameRegistry.addRecipe(new ItemStack(BlockList.shinetorch, 4),
					new Object[] { " G ", " S ", 'G', ItemList.shinedust, 'S',
							Items.stick });
			
			// Nether Eye
			GameRegistry.addRecipe(new ItemStack(ItemList.netherEye, 1),
					new Object[] { "NBN", "WEW", "IOI", 'N',
							ItemList.netheridium, 'B', Items.blaze_powder, 'W',
							ItemList.witherite, 'E', Items.ender_eye, 'O',
							Blocks.obsidian });
			
			// Logs -> Planks
			addLogPlanks(BlockList.bananaLog, BlockList.bananaPlanks);
			addLogPlanks(BlockList.orangeLog, BlockList.orangePlanks);
			addLogPlanks(BlockList.guavaLog, BlockList.guavaPlanks);
			addLogPlanks(BlockList.lemonLog, BlockList.lemonPlanks);
			addLogPlanks(BlockList.limeLog, BlockList.limePlanks);
			addLogPlanks(BlockList.limonLog, BlockList.limonPlanks);
			addLogPlanks(BlockList.cherryLog, BlockList.cherryPlanks);
			addLogPlanks(BlockList.grapefruitLog, BlockList.grapefruitPlanks);
			
			// Quiver
			GameRegistry.addRecipe(new ItemStack(ItemList.quiver, 1),
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
	
	static class Smelting {
		static void init() {
			addSmelting(BlockList.spcOre, new ItemStack(ItemList.spcItem, 2),
					5F);
			addSmelting(BlockList.fueltonium, new ItemStack(
					ItemList.ingotFueltonium), 2F);
			addSmelting(ItemList.fuelonite, ItemList.ingotFueltonium, 2F);
			addSmelting(BlockList.amaranthOre, ItemList.amaranthIngot, 6F);
			addSmelting(ItemList.amaranthDust, ItemList.amaranthIngot, 4F);
			addSmelting(ItemList.zincDust, ItemList.zincIngot, 8F);
			addSmelting(ItemList.zollerniumDust, ItemList.zollerniumIngot, 4F);
			addSmelting(BlockList.zincOre, ItemList.zincIngot, 10F);
			addSmelting(BlockList.redRockCobble, BlockList.redRock, 1F);
			addSmelting(ItemList.flour, new ItemStack(Items.bread, 2), 0.5F);
			if (ZEConfig.rottenFleshCooksIntoLeather) {
				addSmelting(Items.rotten_flesh, Items.leather, 2F);
			}
			addSmelting(Block.getBlockById(13), BlockList.betterGlass, 1F);
			addSmelting(ItemList.shinedust, ItemList.shinestoneIngot, 3F);
			addSmelting(BlockList.amaranthNetherOre, new ItemStack(
					BlockList.amaranthOre, 2), 6F);
			addSmelting(BlockList.zincNetherOre, new ItemStack(
					BlockList.zincOre, 2), 6F);
			addSmelting(BlockList.spcNetherOre, new ItemStack(BlockList.spcOre,
					2), 6F);
			addSmelting(BlockList.fuelNetherOre, new ItemStack(
					BlockList.fueltonium, 4), 6F);
			addSmelting(BlockList.enderShardNetherOre, new ItemStack(
					BlockList.enderShardOre, 2), 6F);
			addSmelting(new ItemStack(Items.dye, 1, 4), new ItemStack(
					ItemList.lapisIngot, 1), 2F);
			addSmelting(new ItemStack(Items.egg, 1), new ItemStack(
					ItemList.boiledEgg, 1), 2F);
			addSmelting(new ItemStack(ItemList.duckEgg, 1), new ItemStack(
					ItemList.boiledEgg, 1), 2.5F);
			addSmelting(new ItemStack(ItemList.rawDuck, 1), new ItemStack(
					ItemList.cookedDuck, 1), 2F);
			addSmelting(new ItemStack(ItemList.rawShrimp, 1), new ItemStack(
					ItemList.cookedShrimp, 1), 2F);
			addSmelting(new ItemStack(ItemList.rawBacon, 1), new ItemStack(
					ItemList.cookedBacon, 1), 2F);
			addSmelting(new ItemStack(ItemList.rawLamb, 1), new ItemStack(
					ItemList.cookedLamb, 1), 2F);
			addSmelting(new ItemStack(Blocks.waterlily, 1), new ItemStack(
					ItemList.greenDye, 1), 1F);
			addSmelting(new ItemStack(ItemList.obsidianDust, 1), new ItemStack(
					ItemList.obsidianIngot, 1), 6F);
			addSmelting(new ItemStack(ItemList.rawChocolate, 1), new ItemStack(
					ItemList.chocolateBar, 1), 2F);
			addSmelting(new ItemStack(ItemList.cornKernel, 1), new ItemStack(
					ItemList.popcorn, 1), 1F);
			addSmelting(ItemList.swampClayBall, Items.brick, 0.2F);
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