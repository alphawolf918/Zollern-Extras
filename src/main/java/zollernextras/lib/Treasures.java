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
			new ItemStack(ItemList.spcItem), 4, 5, 6);
	private static WeightedRandomChestContent item2 = new WeightedRandomChestContent(
			new ItemStack(ItemList.fuelonite), 1, 1, 2);
	private static WeightedRandomChestContent item3 = new WeightedRandomChestContent(
			new ItemStack(ItemList.amaranthIngot), 2, 4, 4);
	private static WeightedRandomChestContent item4 = new WeightedRandomChestContent(
			new ItemStack(ItemList.heart), 5, 10, 4);
	private static WeightedRandomChestContent item5 = new WeightedRandomChestContent(
			new ItemStack(Items.gold_ingot), 35, 62, 10);
	
	public static final WeightedRandomChestContent[] CTChestContents = new WeightedRandomChestContent[] {
		new WeightedRandomChestContent(
					new ItemStack(ItemList.shiniumIngot), 5, 10, 15),
				new WeightedRandomChestContent(new ItemStack(
						ItemList.shinestoneIngot), 15, 20, 25) };
	
	public static void init() {
		ZEChestGenHooks.init();
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
			ZEChestGenHooks info = ZEChestGenHooks.getInfo(chestType);
			WeightedRandomChestContent.generateChestContents(rand,
					info.getItems(rand), tileentitychest, info.getCount(rand));
		}
	}
	
	public static void spawnVanillaChest(World world, Random rand, int i,
			int j, int k, boolean isBigChest, String chestType) {
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
		chestTypes.add(ChestGenHooks.DUNGEON_CHEST);
		chestTypes.add(ChestGenHooks.MINESHAFT_CORRIDOR);
		chestTypes.add(ChestGenHooks.PYRAMID_DESERT_CHEST);
		chestTypes.add(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		chestTypes.add(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER);
		chestTypes.add(ChestGenHooks.STRONGHOLD_CORRIDOR);
		chestTypes.add(ChestGenHooks.STRONGHOLD_CROSSING);
		chestTypes.add(ChestGenHooks.STRONGHOLD_LIBRARY);
		chestTypes.add(ChestGenHooks.VILLAGE_BLACKSMITH);
		chestTypes.add(ZEChestGenHooks.ENDER_TOWER);
	}
	
	public static String pickChestType() {
		return chestTypes.get(new Random().nextInt(chestTypes.size()));
	}
}