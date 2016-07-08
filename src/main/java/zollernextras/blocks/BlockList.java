package zollernextras.blocks;

import java.util.HashMap;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import zollernextras.blocks.crops.BlockEnderReeds;
import zollernextras.blocks.crops.CropBlackberry;
import zollernextras.blocks.crops.CropBlueberry;
import zollernextras.blocks.crops.CropCorn;
import zollernextras.blocks.crops.CropCucumber;
import zollernextras.blocks.crops.CropGarlic;
import zollernextras.blocks.crops.CropGrape;
import zollernextras.blocks.crops.CropOnion;
import zollernextras.blocks.crops.CropPeas;
import zollernextras.blocks.crops.CropRadish;
import zollernextras.blocks.crops.CropStrawberry;
import zollernextras.blocks.crops.CropTomato;
import zollernextras.blocks.fluids.BlockFChocolate;
import zollernextras.blocks.fluids.BlockFFueltonium;
import zollernextras.blocks.fluids.FluidChocolate;
import zollernextras.blocks.fluids.FluidFueltonium;
import zollernextras.blocks.food.BlockPizza;
import zollernextras.blocks.ingotstacks.AmaranthIngotStack;
import zollernextras.blocks.ingotstacks.FueltoniumIngotStack;
import zollernextras.blocks.ingotstacks.GoldIngotStack;
import zollernextras.blocks.ingotstacks.IronIngotStack;
import zollernextras.blocks.ingotstacks.LapisIngotStack;
import zollernextras.blocks.ingotstacks.ShinestoneIngotStack;
import zollernextras.blocks.ingotstacks.ShiniumIngotStack;
import zollernextras.blocks.ingotstacks.ZincIngotStack;
import zollernextras.blocks.ingotstacks.ZollerniumIngotStack;
import zollernextras.blocks.ores.AmaranthOre;
import zollernextras.blocks.ores.EnderShardOre;
import zollernextras.blocks.ores.FueltoniumOre;
import zollernextras.blocks.ores.GemOre;
import zollernextras.blocks.ores.PrismarineOre;
import zollernextras.blocks.ores.SuperChargedCoalOre;
import zollernextras.blocks.ores.ZincOre;
import zollernextras.blocks.ores.ZollerniumOre;
import zollernextras.blocks.ores.ender.EnderAmaranthOre;
import zollernextras.blocks.ores.ender.EnderFueltoniumOre;
import zollernextras.blocks.ores.ender.EnderSpcOre;
import zollernextras.blocks.ores.ender.EnderZincOre;
import zollernextras.blocks.ores.nether.NetherAmaranthOre;
import zollernextras.blocks.ores.nether.NetherEnderShardOre;
import zollernextras.blocks.ores.nether.NetherFueltoniumOre;
import zollernextras.blocks.ores.nether.NetherSPCOre;
import zollernextras.blocks.ores.nether.NetherZincOre;
import zollernextras.blocks.sirens.DiamondSiren;
import zollernextras.blocks.sirens.EmeraldSiren;
import zollernextras.blocks.sirens.GoldSiren;
import zollernextras.blocks.sirens.IronSiren;
import zollernextras.blocks.tiles.TEAmaranthBlockIngot;
import zollernextras.blocks.tiles.TEFueltoniumBlockIngot;
import zollernextras.blocks.tiles.TEGoldBlockIngot;
import zollernextras.blocks.tiles.TEIronBlockIngot;
import zollernextras.blocks.tiles.TELapisBlockIngot;
import zollernextras.blocks.tiles.TEShinestoneBlockIngot;
import zollernextras.blocks.tiles.TEShiniumBlockIngot;
import zollernextras.blocks.tiles.TEZincBlockIngot;
import zollernextras.blocks.tiles.TEZollerniumBlockIngot;
import zollernextras.blocks.trees.ZollernPlanks;
import zollernextras.blocks.trees.banana.BananaLeaves;
import zollernextras.blocks.trees.banana.BananaLog;
import zollernextras.blocks.trees.banana.BananaSapling;
import zollernextras.blocks.trees.cherry.CherryLeaves;
import zollernextras.blocks.trees.cherry.CherryLog;
import zollernextras.blocks.trees.cherry.CherrySapling;
import zollernextras.blocks.trees.ender.EnderBerryLeaves;
import zollernextras.blocks.trees.ender.EnderBerryLog;
import zollernextras.blocks.trees.ender.EnderBerrySapling;
import zollernextras.blocks.trees.grapefruit.GrapefruitLeaves;
import zollernextras.blocks.trees.grapefruit.GrapefruitLog;
import zollernextras.blocks.trees.grapefruit.GrapefruitSapling;
import zollernextras.blocks.trees.guava.GuavaLeaves;
import zollernextras.blocks.trees.guava.GuavaLog;
import zollernextras.blocks.trees.guava.GuavaSapling;
import zollernextras.blocks.trees.lemon.LemonLeaves;
import zollernextras.blocks.trees.lemon.LemonLog;
import zollernextras.blocks.trees.lemon.LemonSapling;
import zollernextras.blocks.trees.lime.LimeLeaves;
import zollernextras.blocks.trees.lime.LimeLog;
import zollernextras.blocks.trees.lime.LimeSapling;
import zollernextras.blocks.trees.limon.LimonLeaves;
import zollernextras.blocks.trees.limon.LimonLog;
import zollernextras.blocks.trees.limon.LimonSapling;
import zollernextras.blocks.trees.orange.OrangeLeaves;
import zollernextras.blocks.trees.orange.OrangeLog;
import zollernextras.blocks.trees.orange.OrangeSapling;
import zollernextras.items.ItemList;
import zollernextras.lib.MainHelper;
import zollernextras.lib.ModInfo;
import zollernextras.lib.enums.State;
import zollernextras.util.RegistryUtil;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockList {
	
	public static int totalBlocks = 0;
	
	public static Block betterGlass = new BetterGlass();
	public static Block spcOre = new SuperChargedCoalOre();
	public static Block shinestone = new Shinestone();
	public static Block fueltonium = new FueltoniumOre();
	public static Block barrier = new BarrierBlock();
	public static Block icySand = new IcySand();
	public static Block icyStone = new IcySandstone();
	public static Block enderShardOre = new EnderShardOre();
	public static Block amaranthOre = new AmaranthOre();
	public static Block slimeBlock = new SlimeBlock();
	public static Block redShroomBlock = new RedshroomBlock();
	public static Block redShroomStem = new RedshroomStem();
	public static Block redRock = new RedRock();
	public static Block redRockCobble = new RedRockCobble();
	public static Block redRockBrick = new RedRockBricks();
	public static Block betterGrass = new BetterGrass();
	public static Block swampClay = new SwampClay();
	public static Block canyonRock = new CanyonRock();
	public static Block badStone = new BadStone();
	public static Block amaranthBlock = new AmaranthBlock();
	public static Block spcBlock = new SPCBlock();
	public static Block fueltoniumBlock = new FueltoniumBlock();
	public static Block zincOre = new ZincOre();
	public static Block zincBlock = new ZincBlock();
	public static Block zollerniumBlock = new ZollerniumBlock();
	public static Block seaLamp = new SeaLamp();
	public static Block ironSiren = new IronSiren(State.OFF);
	public static Block ironSirenON = new IronSiren(State.ON);
	public static Block goldSiren = new GoldSiren(State.OFF);
	public static Block goldSirenON = new GoldSiren(State.ON);
	public static Block diamondSiren = new DiamondSiren(State.OFF);
	public static Block diamondSirenON = new DiamondSiren(State.ON);
	public static Block emeraldSiren = new EmeraldSiren(State.OFF);
	public static Block emeraldSirenON = new EmeraldSiren(State.ON);
	public static Block shinestoneCrystal = new ShinestoneCrystal();
	public static Block shinestoneBricks = new ShinestoneBricks();
	public static Block fuelNetherOre = new NetherFueltoniumOre();
	public static Block spcNetherOre = new NetherSPCOre();
	public static Block amaranthNetherOre = new NetherAmaranthOre();
	public static Block zincNetherOre = new NetherZincOre();
	public static Block enderShardNetherOre = new NetherEnderShardOre();
	
	public static Block amberOre = new GemOre("amberore", ItemList.amber);
	public static Block azuriteOre = new GemOre("azuriteore", ItemList.azurite);
	public static Block aquamarineOre = new GemOre("aquaore",
			ItemList.aquamarine);
	public static Block garnetOre = new GemOre("garnetore", ItemList.garnet);
	public static Block topazOre = new GemOre("topazore", ItemList.topaz);
	public static Block opalOre = new GemOre("opalore", ItemList.opal);
	public static Block enderiteOre = new GemOre("enderiteore",
			ItemList.enderite);
	public static Block witheriteOre = new GemOre("witheriteore",
			ItemList.witherite);
	public static Block rubyOre = new GemOre("rubyore", ItemList.ruby);
	public static Block sapphireOre = new GemOre("sapphireore",
			ItemList.sapphire);
	public static Block enderDiamondOre = new GemOre("enderdiamondore",
			ItemList.enderDiamond);
	
	public static Block caveMarbleWhite = new CaveMarble("marble");
	public static Block caveMarbleBlack = new CaveMarble("blackmarble");
	public static Block brimStone = new Brimstone();
	public static Block netherDirt = new NetherDirt();
	
	public static Block enderAmaranthOre = new EnderAmaranthOre();
	public static Block enderFnOre = new EnderFueltoniumOre();
	public static Block enderSpcOre = new EnderSpcOre();
	public static Block enderZincOre = new EnderZincOre();
	
	public static Block garnet = new GemBlock("garnet");
	public static Block fireGarnet = new GemBlock("firegarnet");
	public static Block aqua = new GemBlock("aqua");
	public static Block icyAqua = new GemBlock("icyaqua");
	public static Block amber = new GemBlock("amber");
	public static Block staticAmber = new GemBlock("staticamber");
	public static Block enderite = new GemBlock("enderite");
	public static Block opal = new GemBlock("opal");
	public static Block enderOpal = new GemBlock("enderopal");
	public static Block topaz = new GemBlock("topaz");
	public static Block azurite = new GemBlock("azurite");
	public static Block shiniumBlock = new GemBlock("shinium");
	public static Block witheriteBlock = new GemBlock("witheriteblock");
	public static Block netheridiumBlock = new GemBlock("netheridiumblock");
	public static Block rubyBlock = new GemBlock("rubyblock");
	public static Block sapphireBlock = new GemBlock("sapphireblock");
	
	public static Block babyEnderDragonEgg = new BabyDragonEgg();
	
	public static Block blueberry = new CropBlueberry();
	public static Block blackberry = new CropBlackberry();
	public static Block grape = new CropGrape();
	public static Block strawberry = new CropStrawberry();
	public static Block radish = new CropRadish();
	public static Block garlic = new CropGarlic();
	public static Block onion = new CropOnion();
	public static Block corn = new CropCorn();
	public static Block peas = new CropPeas();
	public static Block tomatoes = new CropTomato();
	public static Block cucumbers = new CropCucumber();
	
	public static Block cosmos = new FlowerBlock("cosmos");
	public static Block aster = new FlowerBlock("aster");
	public static Block lilac = new FlowerBlock("lilac");
	public static Block crocosmia = new FlowerBlock("orangeflower");
	public static Block heartFlower = new HeartFlower();
	
	public static Block ironBlockIngot = new IronIngotStack("iron");
	public static Block goldBlockIngot = new GoldIngotStack("gold");
	public static Block fueltoniumBlockIngot = new FueltoniumIngotStack(
			"fueltonium");
	public static Block amaranthBlockIngot = new AmaranthIngotStack("amaranth");
	public static Block zollerniumBlockIngot = new ZollerniumIngotStack(
			"zollernium");
	public static Block zincBlockIngot = new ZincIngotStack("zinc");
	public static Block lapisBlockIngot = new LapisIngotStack("lapis");
	public static Block shineStoneBlockIngot = new ShinestoneIngotStack(
			"shinestone");
	public static Block shiniumBlockIngot = new ShiniumIngotStack("shinium");
	
	public static Block candyCubeBlue = new CandyCube("blue");
	public static Block candyCubeBrown = new CandyCube("brown");
	public static Block candyCubeCyan = new CandyCube("cyan");
	public static Block candyCubeGreen = new CandyCube("green");
	public static Block candyCubePink = new CandyCube("pink");
	public static Block candyCubePurple = new CandyCube("purple");
	public static Block candyCubeRed = new CandyCube("red");
	public static Block candyCubeYellow = new CandyCube("yellow");
	public static Block candyCubeOrange = new CandyCube("orange");
	public static Block candyCubeWhite = new CandyCube("white");
	public static Block candyCubeBlack = new CandyCube("black");
	public static Block candyCubeGray = new CandyCube("gray");
	
	public static Block sugarCube = new SugarCube();
	
	public static Block andesite = new Andesite();
	public static Block polishedAndesite = new PolishedAndesite();
	public static Block diorite = new Diorite();
	public static Block polishedDiorite = new PolishedDiorite();
	public static Block granite = new Granite();
	public static Block polishedGranite = new PolishedGranite();
	
	public static Block prismarine = new Prismarine();
	public static Block darkPrismarine = new DarkPrismarine();
	public static Block prismarineBricks = new PrismarineBricks();
	public static Block prismarineOre = new PrismarineOre();
	
	public static Block polishedCrystal = new PolishedCrystal();
	
	public static Block seaLantern = new SeaLantern();
	
	public static Block cookieBlock = new CookieBlock();
	public static Block chocolateBlock = new ChocolateBlock();
	public static Block brownieBlock = new BrownieBlock();
	public static Block iceCreamSandwichBlock = new IceCreamSandwichBlock();
	public static Block chocolateBricks = new ChocolateBricks();
	
	// Trees (Banana)
	public static Block bananaLog = new BananaLog();
	public static Block bananaPlanks = new ZollernPlanks("bpalmplanks");
	public static Block bananaLeaves = new BananaLeaves();
	public static Block bananaSapling = new BananaSapling();
	
	// Trees (Orange)
	public static Block orangeLog = new OrangeLog();
	public static Block orangePlanks = new ZollernPlanks("orangeplanks");
	public static Block orangeLeaves = new OrangeLeaves();
	public static Block orangeSapling = new OrangeSapling();
	
	// Trees (Guava)
	public static Block guavaLog = new GuavaLog();
	public static Block guavaPlanks = new ZollernPlanks("guavaplanks");
	public static Block guavaLeaves = new GuavaLeaves();
	public static Block guavaSapling = new GuavaSapling();
	
	// Trees (Lemon)
	public static Block lemonLog = new LemonLog();
	public static Block lemonPlanks = new ZollernPlanks("lemonplanks");
	public static Block lemonLeaves = new LemonLeaves();
	public static Block lemonSapling = new LemonSapling();
	
	// Trees (Lime)
	public static Block limeLog = new LimeLog();
	public static Block limePlanks = new ZollernPlanks("limeplanks");
	public static Block limeLeaves = new LimeLeaves();
	public static Block limeSapling = new LimeSapling();
	
	// Trees (Limon)
	public static Block limonLog = new LimonLog();
	public static Block limonPlanks = new ZollernPlanks("limonplanks");
	public static Block limonLeaves = new LimonLeaves();
	public static Block limonSapling = new LimonSapling();
	
	// Trees (Cherry)
	public static Block cherryLog = new CherryLog();
	public static Block cherryPlanks = new ZollernPlanks("cherryplanks");
	public static Block cherryLeaves = new CherryLeaves();
	public static Block cherrySapling = new CherrySapling();
	
	// Trees (Grapefruit)
	public static Block grapefruitLog = new GrapefruitLog();
	public static Block grapefruitPlanks = new ZollernPlanks("grapefruitplanks");
	public static Block grapefruitLeaves = new GrapefruitLeaves();
	public static Block grapefruitSapling = new GrapefruitSapling();
	
	// Trees (Ender)
	public static Block enderBerryLog = new EnderBerryLog();
	public static Block enderBerryPlanks = new ZollernPlanks("enderberryplanks");
	public static Block enderBerryLeaves = new EnderBerryLeaves();
	public static Block enderBerrySapling = new EnderBerrySapling();
	
	public static Block shinetorch = new Shinetorch();
	public static Block enderPearlBlock = new BlockEnderPearl();
	public static Block netherizedObsidian = new NetherizedObsidian();
	
	// Colored Bricks
	public static Block bricksBlack = new ColoredBricks("black");
	public static Block bricksLime = new ColoredBricks("lime");
	public static Block bricksBrown = new ColoredBricks("brown");
	public static Block bricksLightBlue = new ColoredBricks("lightblue");
	public static Block bricksLightGray = new ColoredBricks("lightgray");
	public static Block bricksGray = new ColoredBricks("gray");
	public static Block bricksMagenta = new ColoredBricks("magenta");
	public static Block bricksOrange = new ColoredBricks("orange");
	public static Block bricksWhite = new ColoredBricks("white");
	public static Block bricksPink = new ColoredBricks("pink");
	public static Block bricksCyan = new ColoredBricks("cyan");
	public static Block bricksRed = new ColoredBricks("red");
	public static Block bricksBlue = new ColoredBricks("blue");
	public static Block bricksYellow = new ColoredBricks("yellow");
	public static Block bricksGreen = new ColoredBricks("green");
	public static Block bricksPurple = new ColoredBricks("purple");
	public static Block bricksMud = new ColoredBricks("mud");
	
	public static Block zollerniumOre = new ZollerniumOre();
	public static Block enderReeds = new BlockEnderReeds();
	public static Block enderDirt = new EnderDirt();
	public static Block magmaBlock = new BlockMagma();
	public static Block boneBlock = new GenericBlock("boneblock", 1.6F);
	public static Block endStoneBricks = new GenericBlock("endstonebricks",
			1.4F);
	public static Block redNetherBricks = new GenericBlock("rednetherbricks",
			1.2F);
	public static Block netherWartBlock = new GenericBlock("netherwartblock",
			0.8F);
	public static Block redObsidian = new RedObsidian();
	public static Block blockPizza = new BlockPizza();
	public static Block purpurBlock = new GenericBlock("purpurblock", 1.2F);
	public static Block purpurPillar = new PurpurPillar();
	public static Block enderGlowstone = new GenericBlock("enderglowstone",
			0.6F).setLightLevel(1.0F).setStepSound(Block.soundTypeGlass);
	public static Block enderDiamondBlock = new GenericBlock(
			"enderdiamondblock", 1.2F).setLightLevel(0.6F);
	
	public static FluidChocolate fluidChocolate = new FluidChocolate(
			ModInfo.MODID + "_chocolate");
	public static final Block blockChocolate = new BlockFChocolate(
			fluidChocolate);
	
	public static FluidFueltonium fluidFuel = new FluidFueltonium(
			"Molten Fueltonium");
	public static Block blockFuel = new BlockFFueltonium(fluidFuel);
	
	public static HashMap<String, Class<? extends TileEntity>> TERegistry;
	
	public static void init() {
		addBlock(betterGlass, "Stylish Glass");
		addBlock(amaranthOre, "Amaranth Ore");
		addBlock(spcOre, "Super Charged Coal Ore");
		addBlock(enderShardOre, "Ender Shard Ore");
		addBlock(fueltonium, "Fueltonium Ore");
		addBlock(amberOre, "Amber Ore");
		addBlock(azuriteOre, "Azurite Ore");
		addBlock(aquamarineOre, "Aquamarine Ore");
		addBlock(garnetOre, "Garnet Ore");
		addBlock(topazOre, "Topaz Ore");
		addBlock(opalOre, "Opal Ore");
		addBlock(enderiteOre, "Enderite Ore");
		addBlock(witheriteOre, "Witherite Ore");
		addBlock(rubyOre, "Ruby Ore");
		addBlock(sapphireOre, "Sapphire Ore");
		addBlock(fuelNetherOre, "Nether Fueltonium Ore");
		addBlock(spcNetherOre, "Nether Super Charged Coal Ore");
		addBlock(amaranthNetherOre, "Nether Amaranth Ore");
		addBlock(zincNetherOre, "Nether Zinc Ore");
		addBlock(enderShardNetherOre, "Nether Ender Shard Ore");
		addBlock(enderAmaranthOre, "Ender Amaranth Ore");
		addBlock(enderFnOre, "Ender Fueltonium Ore");
		addBlock(enderSpcOre, "Ender Super Charged Coal Ore");
		addBlock(enderZincOre, "Ender Zinc Ore");
		addBlock(amaranthBlock, "Amaranth Block");
		addBlock(spcBlock, "Super Charged Coal Block");
		addBlock(fueltoniumBlock, "Fueltonium Block");
		addBlock(zincBlock, "Zinc Block");
		addBlock(zollerniumBlock, "Zollernium Block");
		addBlock(zincOre, "Zinc Ore");
		addBlock(shinestone, "Shinestone");
		addBlock(shinestoneCrystal, "Shinestone Crystal");
		addBlock(shinestoneBricks, "Shinestone Bricks");
		addBlock(barrier, "Barrier Block");
		addBlock(icySand, "Icy Sand");
		addBlock(icyStone, "Icy Sandstone");
		addBlock(slimeBlock, "Slime Block");
		addBlock(redShroomBlock, "Redshroom Block");
		addBlock(redShroomStem, "Redshroom Stem");
		addBlock(redRock, "Redrock");
		addBlock(redRockCobble, "Redrock Cobble");
		addBlock(redRockBrick, "Redrock Bricks");
		addBlock(betterGrass, "Better Grass");
		addBlock(swampClay, "Swamp Clay");
		addBlock(canyonRock, "Canyon Rock");
		addBlock(badStone, "Bad Stone");
		addBlock(seaLamp, "Sea Lamp");
		addBlock(ironSiren, "Iron Siren");
		addBlock(goldSiren, "Gold Siren");
		addBlock(diamondSiren, "Diamond Siren");
		addBlock(emeraldSiren, "Emerald Siren");
		addBlock(caveMarbleWhite, "Cave Marble");
		addBlock(caveMarbleBlack, "Black Cave Marble");
		addBlock(brimStone, "Brimstone");
		addBlock(netherDirt, "Nether Dirt");
		addBlock(garnet, "Block of Garnet");
		addBlock(fireGarnet, "Block of Fire Garnet");
		addBlock(aqua, "Block of Aquamarine");
		addBlock(icyAqua, "Block of Icy Aquarmarine");
		addBlock(amber, "Block of Amber");
		addBlock(staticAmber, "Block of Static Amber");
		addBlock(enderite, "Block of Enderite");
		addBlock(opal, "Block of Opal");
		addBlock(enderOpal, "Block of Ender Opal");
		addBlock(topaz, "Block of Topaz");
		addBlock(azurite, "Block of Azurite");
		addBlock(shiniumBlock, "Block of Shinium");
		addBlock(witheriteBlock, "Block of Witherite");
		addBlock(netheridiumBlock, "Block of Netheridium");
		addBlock(rubyBlock, "Ruby Block");
		addBlock(sapphireBlock, "Sapphire Block");
		addBlock(babyEnderDragonEgg, "Baby Ender Dragon Egg");
		addBlock(blueberry, "Blueberries");
		addBlock(blackberry, "Blackberries");
		addBlock(grape, "Grapes");
		addBlock(strawberry, "Strawberries");
		addBlock(radish, "Radishes");
		addBlock(corn, "Corn Stalks");
		addBlock(garlic, "Garlic Cloves");
		addBlock(onion, "Onions");
		addBlock(peas, "Peas");
		addBlock(tomatoes, "Tomato Crop");
		addBlock(cucumbers, "Cucumber Crop");
		addBlock(cosmos, "Cosmos");
		addBlock(aster, "Aster");
		addBlock(lilac, "Lilac");
		addBlock(crocosmia, "Crocosmia");
		addBlock(heartFlower, "Heart Flower");
		addBlock(candyCubeBlue, "Blue Candy Cube");
		addBlock(candyCubeBrown, "Brown Candy Cube");
		addBlock(candyCubeCyan, "Cyan Candy Cube");
		addBlock(candyCubeGreen, "Green Candy Cube");
		addBlock(candyCubePink, "Pink Candy Cube");
		addBlock(candyCubePurple, "Purple Candy Cube");
		addBlock(candyCubeRed, "Red Candy Cube");
		addBlock(candyCubeYellow, "Yellow Candy Cube");
		addBlock(candyCubeOrange, "Orange Candy Cube");
		addBlock(candyCubeWhite, "White Candy Cube");
		addBlock(candyCubeBlack, "Black Candy Cube");
		addBlock(candyCubeGray, "Gray Candy Cube");
		addBlock(sugarCube, "Sugar Cube");
		addBlock(andesite, "Andesite");
		addBlock(polishedAndesite, "Polished Andesite");
		addBlock(diorite, "Diorite");
		addBlock(polishedDiorite, "Polished Diorite");
		addBlock(granite, "Granite");
		addBlock(polishedGranite, "Polished Granite");
		addBlock(prismarine, "Prismarine");
		addBlock(darkPrismarine, "Dark Prismarine");
		addBlock(prismarineBricks, "Prismarine Bricks");
		addBlock(prismarineOre, "Prismarine Ore");
		addBlock(seaLantern, "Sea Lantern");
		addBlock(polishedCrystal, "Polished Crystal");
		addBlock(cookieBlock, "Cookie Block");
		addBlock(chocolateBlock, "Chocolate Block");
		addBlock(brownieBlock, "Brownie Block");
		addBlock(iceCreamSandwichBlock, "Ice Cream Sandwich Block");
		addBlock(chocolateBricks, "Chocolate Bricks");
		
		addBlock(shinetorch, "Shinetorch");
		addBlock(enderPearlBlock, "Ender Pearl Block");
		addBlock(netherizedObsidian, "Netherized Obsidian");
		
		addBlock(bricksBlack, "Black Bricks");
		addBlock(bricksLime, "Lime Green Bricks");
		addBlock(bricksBrown, "Brown Bricks");
		addBlock(bricksLightBlue, "Light Blue Bricks");
		addBlock(bricksLightGray, "Light Gray Bricks");
		addBlock(bricksGray, "Gray Bricks");
		addBlock(bricksMagenta, "Magenta Bricks");
		addBlock(bricksOrange, "Orange Bricks");
		addBlock(bricksWhite, "White Bricks");
		addBlock(bricksPink, "Pink Bricks");
		addBlock(bricksCyan, "Cyan Bricks");
		addBlock(bricksRed, "Red Bricks");
		addBlock(bricksBlue, "Blue Bricks");
		addBlock(bricksYellow, "Yellow Bricks");
		addBlock(bricksGreen, "Green Bricks");
		addBlock(bricksPurple, "Purple Bricks");
		addBlock(bricksMud, "Mud Bricks");
		
		addBlock(bananaSapling, "Banana Sapling");
		addBlock(bananaLog, "Banana Log");
		addBlock(bananaLeaves, "Banana Leaves");
		addBlock(bananaPlanks, "Banana Planks");
		
		addBlock(orangeSapling, "Orange Sapling");
		addBlock(orangeLog, "Orange Log");
		addBlock(orangeLeaves, "Orange Leaves");
		addBlock(orangePlanks, "Orange Planks");
		
		addBlock(guavaSapling, "Guava Sapling");
		addBlock(guavaLog, "Guava Log");
		addBlock(guavaLeaves, "Guava Leaves");
		addBlock(guavaPlanks, "Guava Planks");
		
		addBlock(lemonSapling, "Lemon Sapling");
		addBlock(lemonLog, "Lemon Log");
		addBlock(lemonPlanks, "Lemon Planks");
		addBlock(lemonLeaves, "Lemon Leaves");
		
		addBlock(limeSapling, "Lime Sapling");
		addBlock(limeLog, "Lime Log");
		addBlock(limePlanks, "Lime Planks");
		addBlock(limeLeaves, "Lime Leaves");
		
		addBlock(limonSapling, "Limon Sapling");
		addBlock(limonLog, "Limon Log");
		addBlock(limonPlanks, "Limon Planks");
		addBlock(limonLeaves, "Limon Leaves");
		
		addBlock(cherrySapling, "Cherry Sapling");
		addBlock(cherryLog, "Cherry Log");
		addBlock(cherryPlanks, "Cherry Planks");
		addBlock(cherryLeaves, "Cherry Leaves");
		
		addBlock(enderBerryLog, "Ender Berry Log");
		addBlock(enderBerryPlanks, "Ender Berry Planks");
		addBlock(enderBerryLeaves, "Ender Berry Leaves");
		addBlock(enderBerrySapling, "Ender Berry Sapling");
		
		addBlock(grapefruitSapling, "Grapefruit Sapling");
		addBlock(grapefruitLog, "Grapefruit Log");
		addBlock(grapefruitPlanks, "Grapefruit Planks");
		addBlock(grapefruitLeaves, "Grapefruit Leaves");
		
		addBlock(zollerniumOre, "Zollernium Ore");
		addBlock(enderReeds, "Ender Reeds");
		addBlock(enderDirt, "Ender Dirt");
		addBlock(magmaBlock, "Magma Block");
		addBlock(boneBlock, "Bone Rock");
		addBlock(endStoneBricks, "Endstone Bricks");
		addBlock(redNetherBricks, "Red Nether Bricks");
		addBlock(netherWartBlock, "Nether Wart Block");
		addBlock(redObsidian, "Crimson Obsidian");
		addBlock(blockPizza, "Pizza Block");
		addBlock(purpurBlock, "Purpur Block");
		addBlock(purpurPillar, "Purpur Pillar");
		addBlock(enderGlowstone, "Ender Glowstone");
		addBlock(enderDiamondOre, "Ender Diamond Ore");
		addBlock(enderDiamondBlock, "Ender Diamond Block");
		
		addBlock(blockChocolate, "Melted Chocolate");
		addBlock(blockFuel, "Molten Fueltonium");
		
		TERegistry = new HashMap<String, Class<? extends TileEntity>>();
		ironBlockIngot = addIngotTile(new IronIngotStack("iron"), "iron",
				TEIronBlockIngot.class);
		goldBlockIngot = addIngotTile(new GoldIngotStack("gold"), "gold",
				TEGoldBlockIngot.class);
		fueltoniumBlockIngot = addIngotTile(new FueltoniumIngotStack(
				"fueltonium"), "fueltonium", TEFueltoniumBlockIngot.class);
		amaranthBlockIngot = addIngotTile(new AmaranthIngotStack("amaranth"),
				"amaranth", TEAmaranthBlockIngot.class);
		zollerniumBlockIngot = addIngotTile(new ZollerniumIngotStack(
				"zollernium"), "zollernium", TEZollerniumBlockIngot.class);
		zincBlockIngot = addIngotTile(new ZincIngotStack("zinc"), "zinc",
				TEZincBlockIngot.class);
		lapisBlockIngot = addIngotTile(new LapisIngotStack("lapis"), "lapis",
				TELapisBlockIngot.class);
		shineStoneBlockIngot = addIngotTile(new ShinestoneIngotStack(
				"shinestone"), "shinestone", TEShinestoneBlockIngot.class);
		shiniumBlockIngot = addIngotTile(new ShiniumIngotStack("shinium"),
				"shinium", TEShiniumBlockIngot.class);
		MainHelper.Log("Blocks loaded, " + totalBlocks + " entries.");
	}
	
	public static void addBlock(Block block, String name) {
		GameRegistry.registerBlock(block, name);
		totalBlocks++;
	}
	
	public static Block addIngotTile(Block block, String strName,
			Class<? extends TileEntity> TEClass) {
		totalBlocks++;
		return RegistryUtil.fullRegister(block, ModInfo.MODID + "_ingotBlock_"
				+ strName, TEClass);
	}
	
	public static void addItem(Item item, String name) {
		GameRegistry.registerItem(item, name);
		ItemList.totalItems++;
	}
}