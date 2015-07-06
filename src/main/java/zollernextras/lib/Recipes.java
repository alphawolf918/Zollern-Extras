package zollernextras.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zollernextras.blocks.BlockList;
import zollernextras.config.ZEConfig;
import zollernextras.items.ItemList;
import zollernextras.lib.recipes.InductionSmelterRecipes;
import zollernextras.lib.recipes.PulverizerRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init() {
		Crafting.init();
		M.Log("Crafting recipes successfully loaded.");
		Smelting.init();
		M.Log("Furnace recipes successfully loaded.");
		PulverizerRecipes.init();
		M.Log("Pulverizer recipes successfully loaded.");
		InductionSmelterRecipes.init();
		M.Log("Induction smelter recipes successfully loaded.");
	}
	
	static class Crafting {
		static void init() {
			// Cold Smoothstone
			ItemStack css = new ItemStack(BlockList.icyStone, 4);
			GameRegistry.addRecipe(css, new Object[] { "CC ", "CC ", "   ",
					'C', BlockList.icySand });
			
			// <amaranth>
			// Pickaxe
			GameRegistry
					.addRecipe(
							new ItemStack(ItemList.amaranthPickaxe, 1),
							new Object[] { "RRR", " S ", " S ", 'R',
									ItemList.amaranthIngot, 'S',
									Item.getItemById(280) });
			// Shovel
			GameRegistry
					.addRecipe(
							new ItemStack(ItemList.amaranthShovel, 1),
							new Object[] { " R ", " S ", " S ", 'R',
									ItemList.amaranthIngot, 'S',
									Item.getItemById(280) });
			// Axe
			GameRegistry
					.addRecipe(
							new ItemStack(ItemList.amaranthAxe, 1),
							new Object[] { " RR", " SR", " S ", 'R',
									ItemList.amaranthIngot, 'S',
									Item.getItemById(280) });
			GameRegistry
					.addRecipe(
							new ItemStack(ItemList.amaranthAxe, 1),
							new Object[] { "RR ", "RS ", " S ", 'R',
									ItemList.amaranthIngot, 'S',
									Item.getItemById(280) });
			// Hoe
			GameRegistry
					.addRecipe(
							new ItemStack(ItemList.amaranthHoe, 1),
							new Object[] { "RR ", " S ", " S ", 'R',
									ItemList.amaranthIngot, 'S',
									Item.getItemById(280) });
			GameRegistry
					.addRecipe(
							new ItemStack(ItemList.amaranthHoe, 1),
							new Object[] { " RR", " S ", " S ", 'R',
									ItemList.amaranthIngot, 'S',
									Item.getItemById(280) });
			// Sword
			GameRegistry
					.addRecipe(
							new ItemStack(ItemList.amaranthSword, 1),
							new Object[] { " R ", " R ", " S ", 'R',
									ItemList.amaranthIngot, 'S',
									Item.getItemById(280) });
			
			// Helmet
			GameRegistry.addRecipe(new ItemStack(ItemList.amaranthHelmet),
					new Object[] { "ZZZ", "Z Z", "   ", 'Z',
							ItemList.amaranthIngot });
			
			// Chestplate
			GameRegistry.addRecipe(new ItemStack(ItemList.amaranthChestplate),
					new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z',
							ItemList.amaranthIngot });
			
			// Leggings
			GameRegistry.addRecipe(new ItemStack(ItemList.amaranthLeggings),
					new Object[] { "ZZZ", "Z Z", "Z Z", 'Z',
							ItemList.amaranthIngot });
			
			// Boots
			GameRegistry.addRecipe(new ItemStack(ItemList.amaranthBoots),
					new Object[] { "   ", "Z Z", "Z Z", 'Z',
							ItemList.amaranthIngot });
			GameRegistry.addRecipe(new ItemStack(ItemList.amaranthBoots),
					new Object[] { "Z Z", "Z Z", "   ", 'Z',
							ItemList.amaranthIngot });
			// </amaranth>
			
			// <zollernium>
			// Pickaxe
			GameRegistry.addRecipe(
					new ItemStack(ItemList.zollerniumPickaxe, 1), new Object[] {
							"RRR", " S ", " S ", 'R', ItemList.zollerniumIngot,
							'S', Item.getItemById(280) });
			// Shovel
			GameRegistry.addRecipe(
					new ItemStack(ItemList.zollerniumShovel, 1),
					new Object[] { " R ", " S ", " S ", 'R',
							ItemList.zollerniumIngot, 'S',
							Item.getItemById(280) });
			// Axe
			GameRegistry.addRecipe(
					new ItemStack(ItemList.zollerniumAxe, 1),
					new Object[] { " RR", " SR", " S ", 'R',
							ItemList.zollerniumIngot, 'S',
							Item.getItemById(280) });
			GameRegistry.addRecipe(
					new ItemStack(ItemList.zollerniumAxe, 1),
					new Object[] { "RR ", "RS ", " S ", 'R',
							ItemList.zollerniumIngot, 'S',
							Item.getItemById(280) });
			// Hoe
			GameRegistry.addRecipe(
					new ItemStack(ItemList.zollerniumHoe, 1),
					new Object[] { "RR ", " S ", " S ", 'R',
							ItemList.zollerniumIngot, 'S',
							Item.getItemById(280) });
			GameRegistry.addRecipe(
					new ItemStack(ItemList.zollerniumHoe, 1),
					new Object[] { " RR", " S ", " S ", 'R',
							ItemList.zollerniumIngot, 'S',
							Item.getItemById(280) });
			// Sword
			GameRegistry.addRecipe(
					new ItemStack(ItemList.zollerniumSword, 1),
					new Object[] { " R ", " R ", " S ", 'R',
							ItemList.zollerniumIngot, 'S',
							Item.getItemById(280) });
			
			// Helmet
			GameRegistry.addRecipe(new ItemStack(ItemList.zollerniumHelmet),
					new Object[] { "ZZZ", "Z Z", "   ", 'Z',
							ItemList.zollerniumIngot });
			
			// Chestplate
			GameRegistry.addRecipe(
					new ItemStack(ItemList.zollerniumChestplate),
					new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z',
							ItemList.zollerniumIngot });
			
			// Leggings
			GameRegistry.addRecipe(new ItemStack(ItemList.zollerniumLeggings),
					new Object[] { "ZZZ", "Z Z", "Z Z", 'Z',
							ItemList.zollerniumIngot });
			
			// Boots
			GameRegistry.addRecipe(new ItemStack(ItemList.zollerniumBoots),
					new Object[] { "   ", "Z Z", "Z Z", 'Z',
							ItemList.zollerniumIngot });
			GameRegistry.addRecipe(new ItemStack(ItemList.zollerniumBoots),
					new Object[] { "Z Z", "Z Z", "   ", 'Z',
							ItemList.zollerniumIngot });
			// </zollernium>
			
			// Red Rock
			ItemStack rrb = new ItemStack(BlockList.redRockBrick, 4);
			GameRegistry.addRecipe(rrb, new Object[] { "SS ", "SS ", "   ",
					'S', BlockList.redRock });
			
			if (ZEConfig.vanillaItemsAreCraftable) {
				// Name Tag
				GameRegistry.addRecipe(
						new ItemStack(Item.getItemById(421), 2),
						new Object[] { "  I", " S ", "S  ", 'S',
								ItemList.swampClayBall, 'I',
								Item.getItemById(265) });
				
				// Saddle
				GameRegistry.addRecipe(
						new ItemStack(Item.getItemById(329), 1),
						new Object[] { "LLL", "L L", "I I", 'L',
								Item.getItemById(334), 'I',
								Item.getItemById(265) });
				
				// Turn Nether Quartz Block back into Nether Quartz Item
				GameRegistry.addShapelessRecipe(
						new ItemStack(Item.getItemById(406), 9),
						new Object[] { Block.getBlockById(155) });
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
							Item.getItemById(280) });
			
			GameRegistry.addRecipe(new ItemStack(Block.getBlockById(50), 8),
					new Object[] { " G ", " S ", 'G', ItemList.spcItem, 'S',
							Item.getItemById(280) });
			
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
			
			GameRegistry.addRecipe(
					new ItemStack(BlockList.caveMarbleBlack, 8),
					new Object[] { "III", "IMI", "III", 'I',
							new ItemStack(Item.getItemById(351), 1, 0), 'M',
							BlockList.caveMarbleWhite });
			
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
			
			// Shinium
			GameRegistry.addRecipe(new ItemStack(ItemList.shiniumIngot, 1),
					new Object[] { "DLD", "DSD", "DLD", 'D', Items.diamond,
				'S', ItemList.shinestoneIngot, 'L',
				ItemList.lapisIngot });
			
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
			
			// Fire Garnet
			fullBlockCraft(BlockList.fireGarnet, ItemList.fireGarnet);
			
			// Icy Aqua
			fullBlockCraft(BlockList.icyAqua, ItemList.icyAqua);
			
			// Static Amber
			fullBlockCraft(BlockList.staticAmber, ItemList.staticAmber);
			
			// Ender Opal
			fullBlockCraft(BlockList.enderOpal, ItemList.enderOpal);
			
			// Sugar
			fullBlockCraft(BlockList.sugarCube, Items.sugar);
			
			// Polished Andesite
			addOWBricks(BlockList.andesite, BlockList.polishedAndesite);
			
			// Polished Diorite
			addOWBricks(BlockList.diorite, BlockList.polishedDiorite);
			
			// Polished Granite
			addOWBricks(BlockList.granite, BlockList.polishedGranite);
			
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
			
			GameRegistry.addRecipe(new ItemStack(BlockList.babyEnderDragonEgg,
					1), new Object[] { "A A", " B ", "A A", 'A',
					ItemList.azurite, 'B', Blocks.dragon_egg });
			
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
			
			// Other Stuff
			addBricks(ItemList.shinedust, BlockList.shinestone);
			addBricks(ItemList.shinestoneIngot, BlockList.shinestoneCrystal);
			addBricks(BlockList.shinestoneCrystal, BlockList.shinestoneBricks,
					4);
			addBricks(ItemList.swampClayBall, BlockList.swampClay, 4);
			
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
			addSmelting(new ItemStack(ItemList.chocolateBar, 1), new ItemStack(
					ItemList.chocolateBar, 1), 2F);
		}
		
		private static void addSmelting(ItemStack itemStack, ItemStack output,
				float xp) {
			GameRegistry.addSmelting(itemStack, output, xp);
		}
		
		private static void addSmelting(Block input, Item output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
		
		public static void addSmelting(Item input, ItemStack output, float xp) {
			GameRegistry.addSmelting(input, output, xp);
		}
		
		public static void addSmelting(Item input, Item output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
		
		public static void addSmelting(Block input, ItemStack output, float xp) {
			GameRegistry.addSmelting(input, output, xp);
		}
		
		public static void addSmelting(Block input, Block output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
	}
}