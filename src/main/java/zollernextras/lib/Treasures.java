package zollernextras.lib;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import zollernextras.items.ItemList;

public final class Treasures {
	
	public static ArrayList<String> chestTypes = new ArrayList<String>();
	
	private static WeightedRandomChestContent item1 = new WeightedRandomChestContent(
			new ItemStack(ItemList.spcItem, 1), 1, 10, 2);
	private static WeightedRandomChestContent item2 = new WeightedRandomChestContent(
			new ItemStack(ItemList.fuelonite, 1), 1, 10, 2);
	private static WeightedRandomChestContent item3 = new WeightedRandomChestContent(
			new ItemStack(ItemList.amaranthIngot, 1), 1, 10, 2);
	private static WeightedRandomChestContent item4 = new WeightedRandomChestContent(
			new ItemStack(ItemList.heart, 1), 1, 1, 2);
	private static WeightedRandomChestContent item5 = new WeightedRandomChestContent(
			new ItemStack(Items.gold_ingot, 64), 50, 90, 2);
	
	public static final WeightedRandomChestContent[] CTChestContents = new WeightedRandomChestContent[] {
			new WeightedRandomChestContent(Items.iron_ingot, 2, 1, 5, 10),
			new WeightedRandomChestContent(Items.gold_ingot, 4, 1, 5, 10),
			new WeightedRandomChestContent(ItemList.amaranthIngot, 6, 1, 5, 10),
			new WeightedRandomChestContent(ItemList.ingotFueltonium, 8, 1, 5,
					10),
			new WeightedRandomChestContent(ItemList.spcItem, 20, 1, 5, 10),
			new WeightedRandomChestContent(ItemList.enderShard, 16, 1, 5, 10),
			new WeightedRandomChestContent(ItemList.shiniumIngot, 4, 1, 5, 10) };
	
	public static void init() {
		addChestTypes();
		addItems();
	}
	
	private static void addItems() {
		addChestItem(item1);
		addChestItem(item2);
		addChestItem(item3);
		addChestItem(item4);
		for (WeightedRandomChestContent chestContent : CTChestContents) {
			addChestItem(chestContent);
		}
	}
	
	private static void addChestItem(WeightedRandomChestContent item) {
		int i;
		for (i = 0; i < chestTypes.size(); i++) {
			ChestGenHooks.addItem(chestTypes.get(i), item);
		}
	}
	
	public static void addChest(int i, int j, int k, Random rand, World world,
			String chestType) {
		int chestX = i;
		int chestY = j;
		int chestZ = k;
		boolean isBigChest = rand.nextInt(4) == 1 ? true : false;
		spawnChest(world, rand, chestX, chestY, chestZ, isBigChest, chestType);
	}
	
	public static void spawnChest(World world, Random rand, int i, int j,
			int k, boolean isBigChest, String chestType) {
		world.setBlock(i, j, k, Blocks.chest);
		if (isBigChest) {
			world.setBlock(i + 1, j, k, Blocks.chest);
		}
		TileEntityChest tileentitychest = (TileEntityChest) world
				.getTileEntity(i, j, k);
		if (tileentitychest != null) {
			ChestGenHooks info = ChestGenHooks.getInfo(chestType);
			WeightedRandomChestContent.generateChestContents(rand,
					info.getItems(rand), tileentitychest, info.getCount(rand));
		}
	}
	
	public static void addChestTypes() {
		// chestTypes.add(ChestGenHooks.DUNGEON_CHEST);
		// chestTypes.add(ChestGenHooks.MINESHAFT_CORRIDOR);
		// chestTypes.add(ChestGenHooks.PYRAMID_DESERT_CHEST);
		// chestTypes.add(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		// chestTypes.add(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER);
		chestTypes.add(ChestGenHooks.STRONGHOLD_CORRIDOR);
		chestTypes.add(ChestGenHooks.STRONGHOLD_CROSSING);
		chestTypes.add(ChestGenHooks.STRONGHOLD_LIBRARY);
		// chestTypes.add(ChestGenHooks.VILLAGE_BLACKSMITH);
		chestTypes.add(ZEChestGenHooks.CRYSTAL_TOWER);
	}
	
	public static String pickChestType() {
		return chestTypes.get(new Random().nextInt(chestTypes.size()));
	}
}