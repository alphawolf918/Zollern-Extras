package zollernextras.blocks;

import java.util.HashMap;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import zollernextras.blocks.fluids.BlockFChargium;
import zollernextras.blocks.fluids.BlockFChocolate;
import zollernextras.blocks.fluids.BlockFFueltonium;
import zollernextras.blocks.fluids.BlockFWhiteLava;
import zollernextras.blocks.fluids.FluidChargium;
import zollernextras.blocks.fluids.FluidChocolate;
import zollernextras.blocks.fluids.FluidFueltonium;
import zollernextras.blocks.fluids.FluidWhiteLava;
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
import zollernextras.blocks.ores.CorruptOre;
import zollernextras.blocks.ores.GemOre;
import zollernextras.blocks.ores.GenericBlockOre;
import zollernextras.blocks.ores.GenericEnderOre;
import zollernextras.blocks.ores.GenericNetherOre;
import zollernextras.blocks.ores.GenericUpsideDownOre;
import zollernextras.blocks.ores.ShadowGemOre;
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
import zollernextras.blocks.trees.peach.PeachLeaves;
import zollernextras.blocks.trees.peach.PeachLog;
import zollernextras.blocks.trees.peach.PeachSapling;
import zollernextras.blocks.trees.shade.ShadeLeaves;
import zollernextras.blocks.trees.shade.ShadeLog;
import zollernextras.blocks.trees.shade.ShadeSapling;
import zollernextras.blocks.upsidedown.Bloodstone;
import zollernextras.blocks.upsidedown.ShadowBossSpawner;
import zollernextras.blocks.upsidedown.SpiderlingEgg;
import zollernextras.blocks.upsidedown.UpsideDownStone;
import zollernextras.blocks.upsidedown.corrupt.CorruptBlock;
import zollernextras.blocks.upsidedown.corrupt.CorruptStone;
import zollernextras.items.ZollernItems;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernHelper;
import zollernextras.lib.ZollernModInfo;
import zollernextras.lib.enums.State;
import zollernextras.util.RegistryUtil;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZollernBlocks {
	
	public static int totalBlocks = 0;
	
	public static Block betterGlass = new BetterGlass();
	public static Block shinestone = new Shinestone();
	public static Block barrier = new BarrierBlock();
	public static Block icySand = new IcySand();
	public static Block icyStone = new IcySandstone();
	public static Block spcOre = new GemOre("superchargedcoalore",
			ZollernItems.spcItem);
	public static Block fueltonium = new GemOre("fueltoniumore",
			ZollernItems.fuelonite).setHardness(1.8F);
	public static Block enderShardOre = new GemOre("endershardore",
			ZollernItems.enderShard);
	public static Block amaranthOre = new GenericBlockOre("amaranthore", 1.4F)
			.setBlockHarvestLevel("pickaxe", 3);
	public static Block slimeBlock = new SlimeBlock();
	public static Block redShroomBlock = new GenericBlock("redshroomblock",
			0.6F);
	public static Block redShroomStem = new GenericBlock("redshroomstem", 0.8F);
	public static Block redRock = new RedRock();
	public static Block redRockCobble = new GenericBlock("redrockcobble", 0.4F);
	public static Block redRockBrick = new GenericBlock("redrockbricks", 1.0F)
			.setBlockHarvestLevel("pickaxe", 0);
	public static Block betterGrass = new BetterGrass();
	public static Block swampClay = new SwampClay();
	public static Block canyonRock = new GenericBlock("canyonrock", 1.1F)
			.setBlockHarvestLevel("pickaxe", 0);
	public static Block canyonRockBricks = new GenericBlock("canyonrockbricks",
			1.1F);
	public static Block badStone = new GenericBlock("badstone", 1.5F)
			.setBlockHarvestLevel("pickaxe", 1);
	public static Block amaranthBlock = new GenericBlock("amaranthblock", 1.0F)
			.setBlockHarvestLevel("pickaxe", 2);
	public static Block spcBlock = new GenericBlock("spcblock", 1.4F)
			.setBlockHarvestLevel("pickaxe", 2);
	public static Block fueltoniumBlock = new GenericBlock("fueltoniumblock",
			1.6F).setBlockHarvestLevel("pickaxe", 2);
	public static Block zincOre = new GenericBlockOre("zincore", 1.4F)
			.setBlockHarvestLevel("pickaxe", 4);
	public static Block zincBlock = new GenericBlock("zincblock", 1.6F)
			.setBlockHarvestLevel("pickaxe", 2);
	public static Block zollerniumBlock = new GenericBlock("zollerniumblock",
			1.8F).setBlockHarvestLevel("pickaxe", 2);
	public static Block seaLamp = new GenericBlock("sealamp", 0.5F)
			.setBlockHarvestLevel("pickaxe", 1).setLightLevel(1.0F);
	public static Block ironSiren = new IronSiren(State.OFF);
	public static Block ironSirenON = new IronSiren(State.ON);
	public static Block goldSiren = new GoldSiren(State.OFF);
	public static Block goldSirenON = new GoldSiren(State.ON);
	public static Block diamondSiren = new DiamondSiren(State.OFF);
	public static Block diamondSirenON = new DiamondSiren(State.ON);
	public static Block emeraldSiren = new EmeraldSiren(State.OFF);
	public static Block emeraldSirenON = new EmeraldSiren(State.ON);
	public static Block shinestoneCrystal = new GenericBlock(
			"shinestonecrystal", 1.2F).setBlockHarvestLevel("pickaxe", 2)
			.setLightLevel(1.0F);
	public static Block shinestoneBricks = new GenericBlock("crystalbricks",
			1.2F);
	
	public static Block fuelNetherOre = new GenericNetherOre(
			"netherfueltoniumore", 1.6F);
	public static Block spcNetherOre = new GenericNetherOre("netherspcore",
			1.4F);
	public static Block amaranthNetherOre = new GenericNetherOre(
			"netheramaranthore", 1.2F);
	public static Block zincNetherOre = new GenericNetherOre("netherzincore",
			1.4F);
	public static Block enderShardNetherOre = new GenericNetherOre(
			"netherendershardore", 1.1F);
	
	public static Block amberOre = new GemOre("amberore", ZollernItems.amber);
	public static Block azuriteOre = new GemOre("azuriteore",
			ZollernItems.azurite);
	public static Block aquamarineOre = new GemOre("aquaore",
			ZollernItems.aquamarine);
	public static Block garnetOre = new GemOre("garnetore", ZollernItems.garnet);
	public static Block topazOre = new GemOre("topazore", ZollernItems.topaz);
	public static Block opalOre = new GemOre("opalore", ZollernItems.opal);
	public static Block enderiteOre = new GemOre("enderiteore",
			ZollernItems.enderite);
	public static Block witheriteOre = new GemOre("witheriteore",
			ZollernItems.witherite);
	public static Block rubyOre = new GemOre("rubyore", ZollernItems.ruby);
	public static Block sapphireOre = new GemOre("sapphireore",
			ZollernItems.sapphire);
	public static Block enderDiamondOre = new GemOre("enderdiamondore",
			ZollernItems.enderDiamond);
	
	public static Block caveMarbleWhite = new GenericBlock("marble", 1.0F)
			.setBlockMaterial(Material.iron).setStepSound(Block.soundTypeMetal);
	public static Block caveMarbleBlack = new GenericBlock("blackmarble", 1.0F)
			.setBlockMaterial(Material.iron).setStepSound(Block.soundTypeMetal);
	public static Block brimStone = new Brimstone();
	public static Block netherDirt = ((GenericBlock) new GenericBlock(
			"netherdirt", 0.2F).setBlockHarvestLevel("shovel", 1))
			.setBlockMaterial(Material.grass).setStepSound(
					Block.soundTypeGravel);
	
	public static Block enderAmaranthOre = new GenericEnderOre(
			"amaranthenderore", 1.4F);
	public static Block enderFnOre = new GenericEnderOre("enderfnore", 1.8F);
	public static Block enderSpcOre = new GenericEnderOre("enderspcore", 1.6F);
	public static Block enderZincOre = new GenericEnderOre("enderzincore", 1.4F);
	
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
	public static Block azurite = new GemBlock("azurite").setLightLevel(1.0F);
	public static Block shiniumBlock = new GemBlock("shinium")
			.setLightLevel(1.0F);
	public static Block witheriteBlock = new GemBlock("witheriteblock");
	public static Block netheridiumBlock = new GemBlock("netheridiumblock");
	public static Block rubyBlock = new GemBlock("rubyblock");
	public static Block sapphireBlock = new GemBlock("sapphireblock");
	public static Block enderDiamondBlock = new GemBlock("enderdiamondblock")
			.setLightLevel(0.6F);
	
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
	
	public static Block andesite = new GenericBlock("andesite", 0.8F)
			.setBlockHarvestLevel("pickaxe", 1);
	public static Block polishedAndesite = new GenericBlock("polishedandesite",
			1.0F).setBlockHarvestLevel("pickaxe", 2);
	public static Block diorite = new GenericBlock("diorite", 1.0F)
			.setBlockHarvestLevel("pickaxe", 1);
	public static Block polishedDiorite = new GenericBlock("polisheddiorite",
			1.0F).setBlockHarvestLevel("pickaxe", 2);
	public static Block granite = new GenericBlock("granite", 1.0F)
			.setBlockHarvestLevel("pickaxe", 1);
	public static Block polishedGranite = new GenericBlock("polishedgranite",
			1.0F).setBlockHarvestLevel("pickaxe", 1);
	
	public static Block prismarine = new GenericBlock("prismarine", 1.0F)
			.setBlockHarvestLevel("pickaxe", 1);
	public static Block darkPrismarine = new GenericBlock("darkprismarine",
			1.0F).setBlockHarvestLevel("pickaxe", 1);
	public static Block prismarineBricks = new GenericBlock("prismarinebricks",
			0.6F);
	public static Block prismarineOre = new GemOre("prismarineore",
			ZollernItems.prismarineCrystal);
	
	public static Block polishedCrystal = new GenericBlock("polishedcrystal",
			1.2F).setBlockHarvestLevel("pickaxe", 1);
	
	public static Block seaLantern = new SeaLantern();
	
	public static Block cookieBlock = new CookieBlock();
	public static Block chocolateBlock = new GenericBlock("chocolateblock",
			1.2F);
	public static Block brownieBlock = new GenericBlock("brownieblock", 0.9F)
			.setBlockMaterial(Material.cloth)
			.setStepSound(Block.soundTypeCloth);
	public static Block iceCreamSandwichBlock = new IceCreamSandwichBlock();
	public static Block chocolateBricks = new GenericBlock("chocolatebricks",
			1.2F);
	
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
	
	// Trees (Peach)
	public static Block peachLog = new PeachLog();
	public static Block peachPlanks = new ZollernPlanks("peachplanks");
	public static Block peachLeaves = new PeachLeaves();
	public static Block peachSapling = new PeachSapling();
	
	// Trees (Ender)
	public static Block enderBerryLog = new EnderBerryLog();
	public static Block enderBerryPlanks = new ZollernPlanks("enderberryplanks");
	public static Block enderBerryLeaves = new EnderBerryLeaves();
	public static Block enderBerrySapling = new EnderBerrySapling();
	
	// Trees (Shade)
	public static Block shadeLog = new ShadeLog();
	public static Block shadePlanks = new ZollernPlanks("shadeplanks");
	public static Block shadeLeaves = new ShadeLeaves();
	public static Block shadeSapling = new ShadeSapling();
	
	public static Block shinetorch = new Shinetorch();
	public static Block enderPearlBlock = new BlockEnderPearl();
	public static Block netherizedObsidian = new GenericBlock(
			"netherizedobsidian", 2.0F).setBlockHarvestLevel("pickaxe", 2);
	
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
	
	public static Block zollerniumOre = new GenericBlockOre("zollerniumore",
			1.6F).setBlockHarvestLevel("pickaxe", 5);
	public static Block enderReeds = new BlockEnderReeds();
	public static Block enderDirt = ((GenericBlock) new GenericBlock(
			"enderdirt", 0.6F).setBlockMaterial(Material.grass).setStepSound(
			Block.soundTypeGravel)).setBlockHarvestLevel("shovel", 0);
	public static Block magmaBlock = new BlockMagma();
	public static Block boneBlock = new GenericBlock("boneblock", 1.6F);
	public static Block shadowBoneBlock = new GenericBlock("shadowboneblock",
			1.6F);
	public static Block endStoneBricks = new GenericBlock("endstonebricks",
			1.4F);
	public static Block redNetherBricks = new GenericBlock("rednetherbricks",
			1.2F);
	public static Block netherWartBlock = new GenericBlock("netherwartblock",
			0.8F);
	public static Block redObsidian = new GenericBlock("redobsidian", 10F)
			.setBlockHarvestLevel("pickaxe", 3).setLightLevel(1.0F);
	public static Block blockPizza = new BlockPizza();
	public static Block purpurBlock = new BlockPurpur();
	public static Block purpurPillar = new PurpurPillar();
	public static Block enderGlowstone = new GenericBlock("enderglowstone",
			0.6F).setLightLevel(1.0F).setStepSound(Block.soundTypeGlass);
	public static Block chargiumBlock = new GenericBlock("chargiumblock", 1.6F)
			.setLightLevel(1.0F).setStepSound(Block.soundTypeGlass);
	public static Block steelOre = new GenericBlockOre("steelore", 1.8f)
			.setBlockHarvestLevel("pickaxe",
					ToolMaterials.ZOLLERNIUM.getHarvestLevel());
	public static Block steelBlock = new GenericBlock("steelblock", 1.6f)
			.setBlockHarvestLevel("pickaxe", 2).setStepSound(
					Block.soundTypeMetal);
	
	// Upside-Down
	public static Block upsideDownSurfaceRock = new GenericBlock(
			"ud_surfacerock", 1.2F);
	public static Block upsideDownRock = new GenericBlock("ud_rock", 1.4F);
	public static Block upsideDownStone = new UpsideDownStone();
	public static Block upsideDownCobble = new GenericBlock("ud_cobblestone",
			0.8F);
	public static Block upsideDownCobbleMossy = new GenericBlock(
			"ud_cobble_mossy", 0.9F);
	public static Block upsideDownStoneBricks = new GenericBlock(
			"ud_stonebricks", 1.0F);
	public static Block upsideDownDirt = ((GenericBlock) ((GenericBlock) new GenericBlock(
			"ud_dirt", 0.5F).setStepSound(Block.soundTypeGravel))
			.setBlockHarvestLevel("shovel", 0))
			.setBlockMaterial(Material.grass);
	public static Block creepStone = new GenericBlock("creepstone", 1.2F);
	public static Block creepDirt = ((GenericBlock) ((GenericBlock) new GenericBlock(
			"creepdirt", 0.5F).setStepSound(Block.soundTypeGravel))
			.setBlockHarvestLevel("shovel", 0))
			.setBlockMaterial(Material.grass);
	public static Block bloodStone = new Bloodstone();
	public static Block shadowEssence = new GenericBlock("shadowessenceblock",
			1.6F);
	public static Block upsideDownIronOre = new GenericUpsideDownOre(
			"ud_ironore", 1.6F);
	public static Block upsideDownGoldOre = new GenericUpsideDownOre(
			"ud_goldore", 1.4F);
	public static Block upsideDownDiamondOre = new ShadowGemOre(
			"ud_diamondore", Items.diamond);
	public static Block upsideDownEmeraldOre = new ShadowGemOre(
			"ud_emeraldore", Items.emerald);
	public static Block upsideDownAmaranthOre = new GenericUpsideDownOre(
			"ud_amaranthore", 1.4F);
	public static Block upsideDownZincOre = new GenericUpsideDownOre(
			"ud_zincore", 1.4F);
	public static Block upsideDownRubyOre = new ShadowGemOre("ud_rubyore",
			ZollernItems.ruby);
	public static Block upsideDownSapphireOre = new ShadowGemOre(
			"ud_sapphireore", ZollernItems.sapphire);
	public static Block upsideDownSpcOre = new ShadowGemOre("ud_spcore",
			ZollernItems.spcItem);
	public static Block upsideDownFuelOre = new ShadowGemOre("ud_fuelore",
			ZollernItems.fuelonite);
	public static Block upsideDownLapisOre = new ShadowGemOre("ud_lapisore",
			new ItemStack(Items.dye, 1, 4).getItem());
	public static Block upsideDownRedstoneOre = new ShadowGemOre(
			"ud_redstoneore", Items.redstone);
	public static Block upsideDownEnderShardOre = new ShadowGemOre(
			"ud_endershardore", ZollernItems.enderShard);
	public static Block upsideDownRadianceOre = new ShadowGemOre(
			"ud_radianceore", ZollernItems.radiance);
	public static Block upsideDownGarnetOre = new ShadowGemOre("ud_garnetore",
			ZollernItems.garnet);
	public static Block upsideDownAquaOre = new ShadowGemOre("ud_aquaore",
			ZollernItems.aquamarine);
	public static Block upsideDownTopazOre = new ShadowGemOre("ud_topazore",
			ZollernItems.topaz);
	public static Block upsideDownAmberOre = new ShadowGemOre("ud_amberore",
			ZollernItems.amber);
	public static Block upsideDownOpalOre = new ShadowGemOre("ud_opalore",
			ZollernItems.opal);
	public static Block upsideDownCopperOre = new GenericUpsideDownOre(
			"ud_copperore", 1.6F);
	public static Block upsideDownTinOre = new GenericUpsideDownOre(
			"ud_tinore", 1.0F);
	public static Block upsideDownLeadOre = new GenericUpsideDownOre(
			"ud_leadore", 1.8F);
	public static Block upsideDownSilverOre = new GenericUpsideDownOre(
			"ud_silverore", 1.5F);
	public static Block upsideDownFerrousOre = new GenericUpsideDownOre(
			"ud_ferrousore", 1.4F);
	public static Block upsideDownShiniumOre = new GenericUpsideDownOre(
			"ud_shiniumore", 1.9F);
	public static Block radiantBlock = ((GenericBlock) new GenericBlock(
			"radiantblock", 1.5F).setLightLevel(1.0F)).setBlockHarvestLevel(
			"pickaxe", 2);
	public static Block spiderlingEgg = new SpiderlingEgg();
	public static Block shadowBossSpawner = new ShadowBossSpawner();
	
	public static Block diamondSkull = new BlockDiamondSkull();
	
	public static Block corruptCobblestone = new CorruptBlock("corruptcobble",
			0.6F);
	public static Block corruptStone = new CorruptStone();
	public static Block corruptStoneBricks = new CorruptBlock(
			"corruptstonebricks", 0.8F);
	public static Block corruptCreepStone = new CorruptBlock(
			"corruptcreepstone", 1.6F);
	public static Block corruptRock = new CorruptBlock("corruptrock", 1.8F);
	public static Block corruptChargiumOre = new CorruptOre(
			"corruptchargiumore", 1.9F);
	public static Block corruptEtriumOre = new CorruptOre("corruptetriumore",
			1.8F);
	public static Block endRock = new GenericBlock("endrock", 10.0F)
			.setBlockUnbreakable();
	
	public static FluidChocolate fluidChocolate = new FluidChocolate(
			ZollernModInfo.MODID + "_chocolate");
	public static Block blockChocolate = new BlockFChocolate(fluidChocolate);
	
	public static FluidFueltonium fluidFuel = new FluidFueltonium(
			"Molten Fueltonium");
	public static Block blockFuel = new BlockFFueltonium(fluidFuel);
	
	public static FluidChargium fluidChargium = new FluidChargium(
			"Conductive Chargium");
	public static Block blockChargium = new BlockFChargium(fluidChargium);
	
	public static FluidWhiteLava fluidWhiteLava = new FluidWhiteLava(
			"White Lava");
	public static Block blockWhiteLava = new BlockFWhiteLava(fluidWhiteLava);
	
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
		addBlock(canyonRockBricks, "Canyon Bricks");
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
		
		addBlock(grapefruitSapling, "Grapefruit Sapling");
		addBlock(grapefruitLog, "Grapefruit Log");
		addBlock(grapefruitPlanks, "Grapefruit Planks");
		addBlock(grapefruitLeaves, "Grapefruit Leaves");
		
		addBlock(peachSapling, "Peach Sapling");
		addBlock(peachLog, "Peach Log");
		addBlock(peachPlanks, "Peach Planks");
		addBlock(peachLeaves, "Peach Leaves");
		
		addBlock(enderBerryLog, "Ender Berry Log");
		addBlock(enderBerryPlanks, "Ender Berry Planks");
		addBlock(enderBerryLeaves, "Ender Berry Leaves");
		addBlock(enderBerrySapling, "Ender Berry Sapling");
		
		addBlock(shadeLog, "Shade Log");
		addBlock(shadePlanks, "Shade Planks");
		addBlock(shadeLeaves, "Shade Leaves");
		addBlock(shadeSapling, "Shade Sapling");
		
		addBlock(zollerniumOre, "Zollernium Ore");
		addBlock(enderReeds, "Ender Reeds");
		addBlock(enderDirt, "Ender Dirt");
		addBlock(magmaBlock, "Magma Block");
		addBlock(boneBlock, "Bone Rock");
		addBlock(shadowBoneBlock, "Shadow Bone Rock");
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
		addBlock(chargiumBlock, "Chargium Block");
		addBlock(steelOre, "Steel Ore");
		addBlock(steelBlock, "Steel Block");
		
		// Upside Down
		addBlock(upsideDownSurfaceRock, "Upside-Down SurfRock");
		addBlock(upsideDownRock, "Upside-Down Rock");
		addBlock(upsideDownStone, "Upside-Down Stone");
		addBlock(upsideDownCobble, "Upside-Down Cobblestone");
		addBlock(upsideDownCobbleMossy, "Upside-Down Mossy Cobblestone");
		addBlock(upsideDownStoneBricks, "Upside-Down Stone Bricks");
		addBlock(upsideDownDirt, "Upside-Down Dirt");
		addBlock(creepStone, "Creep Stone");
		addBlock(creepDirt, "Creep Dirt");
		addBlock(bloodStone, "Blood Stone");
		addBlock(shadowEssence, "Shadow Essence Block");
		addBlock(upsideDownIronOre, "Upside-Down Iron Ore");
		addBlock(upsideDownGoldOre, "Upside-Down Gold Ore");
		addBlock(upsideDownDiamondOre, "Upside-Down Diamond Ore");
		addBlock(upsideDownEmeraldOre, "Upside-Down Emerald Ore");
		addBlock(upsideDownAmaranthOre, "Upside-Down Amaranth Ore");
		addBlock(upsideDownZincOre, "Upside-Down Zinc Ore");
		addBlock(upsideDownRubyOre, "Upside-Down Ruby Ore");
		addBlock(upsideDownSapphireOre, "Upside-Down Sapphire Ore");
		addBlock(upsideDownSpcOre, "Upside-Down SPC Ore");
		addBlock(upsideDownFuelOre, "Upside-Down Fuel Ore");
		addBlock(upsideDownLapisOre, "Upside-Down Lapis Ore");
		addBlock(upsideDownRedstoneOre, "Upside-Down Redstone Ore");
		addBlock(upsideDownEnderShardOre, "Upside-Down Ender Shard Ore");
		addBlock(upsideDownRadianceOre, "Upside-Down Radiance Ore");
		addBlock(upsideDownGarnetOre, "Upside-Down Garnet Ore");
		addBlock(upsideDownAquaOre, "Upside-Down Aquamarine Ore");
		addBlock(upsideDownTopazOre, "Upside-Down Topaz Ore");
		addBlock(upsideDownAmberOre, "Upside-Down Amber Ore");
		addBlock(upsideDownOpalOre, "Upside-Down Opal Ore");
		addBlock(upsideDownCopperOre, "Upside-Down Copper Ore");
		addBlock(upsideDownTinOre, "Upside-Down Tin Ore");
		addBlock(upsideDownLeadOre, "Upside-Down Lead Ore");
		addBlock(upsideDownSilverOre, "Upside-Down Silver Ore");
		addBlock(upsideDownFerrousOre, "Upside-Down Ferrous Ore");
		addBlock(upsideDownShiniumOre, "Upside-Down Shinium Ore");
		addBlock(radiantBlock, "Radiant Block");
		addBlock(spiderlingEgg, "Spider Egg");
		addBlock(shadowBossSpawner, "Shadow Spawner");
		addBlock(diamondSkull, "Diamond Skull");
		addBlock(corruptCobblestone, "Corrupt Cobblestone");
		addBlock(corruptStone, "Corrupt Stone");
		addBlock(corruptStoneBricks, "Corrupt Stone Bricks");
		addBlock(corruptCreepStone, "Corrupt Creepstone");
		addBlock(corruptRock, "Corrupt Rock");
		addBlock(corruptChargiumOre, "Corrupt Chargium Ore");
		addBlock(corruptEtriumOre, "Corrupt Etrium Ore");
		addBlock(endRock, "Endrock");
		
		addBlock(blockChocolate, "Melted Chocolate");
		addBlock(blockFuel, "Molten Fueltonium");
		addBlock(blockChargium, "Conductive Chargium");
		addBlock(blockWhiteLava, "White Lava");
		
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
		ZollernHelper.Log("Blocks loaded, " + totalBlocks + " entries.");
	}
	
	public static void addBlock(Block block, String name) {
		GameRegistry.registerBlock(block, name);
		totalBlocks++;
	}
	
	public static Block addIngotTile(Block block, String strName,
			Class<? extends TileEntity> TEClass) {
		totalBlocks++;
		return RegistryUtil.fullRegister(block, ZollernModInfo.MODID
				+ "_ingotBlock_" + strName, TEClass);
	}
	
	public static void addItem(Item item, String name) {
		GameRegistry.registerItem(item, name);
		ZollernItems.totalItems++;
	}
}