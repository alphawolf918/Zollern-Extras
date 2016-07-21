package zollernextras.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.oredict.OreDictionary;
import zollernextras.items.ItemList;

public class ZEChestGenHooks extends ChestGenHooks {
	
	public static final String ENDER_TOWER = "enderTower";
	public static final WeightedRandomChestContent[] CTChestContents = new WeightedRandomChestContent[] {
			new WeightedRandomChestContent(
					new ItemStack(ItemList.shiniumIngot), 5, 10, 15),
				new WeightedRandomChestContent(new ItemStack(
						ItemList.shinestoneIngot), 15, 20, 25),
						new WeightedRandomChestContent(new ItemStack(ItemList.enderShard),
								15, 20, 25),
			new WeightedRandomChestContent(
					new ItemStack(ItemList.amaranthIngot), 15, 20, 25),
										new WeightedRandomChestContent(new ItemStack(ItemList.enderite),
												15, 20, 25),
			new WeightedRandomChestContent(new ItemStack(Items.ender_pearl),
					15, 20, 25),
														new WeightedRandomChestContent(
																new ItemStack(ItemList.chargiumDust), 5, 10, 15),
			new WeightedRandomChestContent(
					new ItemStack(ItemList.enderDiamond), 5, 10, 15) };
	
	private static final HashMap<String, ZEChestGenHooks> chestInfo = new HashMap<String, ZEChestGenHooks>();
	
	private static boolean hasInit = false;
	
	static {
		init();
	}
	
	public static void init() {
		if (hasInit) {
			return;
		}
		
		hasInit = true;
		
		addInfo(ENDER_TOWER, CTChestContents, 8, 16);
		
		ItemStack book = new ItemStack(Items.enchanted_book, 1, 0);
		WeightedRandomChestContent tmp = new WeightedRandomChestContent(book,
				1, 1, 1);
		getInfo(ENDER_TOWER).addItem(tmp);
		
		getInfo(ENDER_TOWER)
				.addItem(
						new WeightedRandomChestContent(ItemList.spcItem, 4, 25,
								50, 30));
		
		for (WeightedRandomChestContent chestContent : CTChestContents) {
			ItemStack item = chestContent.theItemId;
			addDungeonLoot(new ZEChestGenHooks("enderTower"), item, 50, 40, 80);
		}
	}
	
	static void addDungeonLoot(ZEChestGenHooks dungeon, ItemStack item,
			int weight, int min, int max) {
		dungeon.addItem(new WeightedRandomChestContent(item, min, max, weight));
	}
	
	private static void addInfo(String category,
			WeightedRandomChestContent[] items, int min, int max) {
		chestInfo.put(category, new ZEChestGenHooks(category, items, min, max));
	}
	
	/**
	 * Retrieves, or creates the info class for the specified category.
	 *
	 * @param category
	 *            The category name
	 * @return A instance of ChestGenHooks for the specified category.
	 */
	public static ZEChestGenHooks getInfo(String category) {
		if (!chestInfo.containsKey(category)) {
			chestInfo.put(category, new ZEChestGenHooks(category));
		}
		return chestInfo.get(category);
	}
	
	/**
	 * Generates an array of items based on the input min/max count. If the
	 * stack can not hold the total amount, it will be split into stacks of size
	 * 1.
	 *
	 * @param rand
	 *            A random number generator
	 * @param source
	 *            Source item stack
	 * @param min
	 *            Minimum number of items
	 * @param max
	 *            Maximum number of items
	 * @return An array containing the generated item stacks
	 */
	public static ItemStack[] generateStacks(Random rand, ItemStack source,
			int min, int max) {
		int count = min + rand.nextInt(max - min + 1);
		
		ItemStack[] ret;
		if (source.getItem() == null) {
			ret = new ItemStack[0];
		} else if (count > source.getMaxStackSize()) {
			ret = new ItemStack[count];
			for (int x = 0; x < count; x++) {
				ret[x] = source.copy();
				ret[x].stackSize = 1;
			}
		} else {
			ret = new ItemStack[1];
			ret[0] = source.copy();
			ret[0].stackSize = count;
		}
		return ret;
	}
	
	// shortcut functions, See the non-static versions below
	public static WeightedRandomChestContent[] getItems(String category,
			Random rnd) {
		return getInfo(category).getItems(rnd);
	}
	
	public static int getCount(String category, Random rand) {
		return getInfo(category).getCount(rand);
	}
	
	public static void addItem(String category, WeightedRandomChestContent item) {
		getInfo(category).addItem(item);
	}
	
	public static void removeItem(String category, ItemStack item) {
		getInfo(category).removeItem(item);
	}
	
	public static ItemStack getOneItem(String category, Random rand) {
		return getInfo(category).getOneItem(rand);
	}
	
	private String category;
	private int countMin = 0;
	private int countMax = 0;
	
	ArrayList<WeightedRandomChestContent> contents = new ArrayList<WeightedRandomChestContent>();
	
	public ZEChestGenHooks(String category) {
		super(category);
		this.category = category;
	}
	
	public ZEChestGenHooks(String category, WeightedRandomChestContent[] items,
			int min, int max) {
		this(category);
		for (WeightedRandomChestContent item : items) {
			contents.add(item);
		}
		countMin = min;
		countMax = max;
	}
	
	/**
	 * Adds a new entry into the possible items to generate.
	 *
	 * @param item
	 *            The item to add.
	 */
	@Override
	public void addItem(WeightedRandomChestContent item) {
		contents.add(item);
	}
	
	/**
	 * Removes all items that match the input item stack, Only metadata and item
	 * ID are checked. If the input item has a metadata of -1, all metadatas
	 * will match.
	 *
	 * @param item
	 *            The item to check
	 */
	@Override
	public void removeItem(ItemStack item) {
		Iterator<WeightedRandomChestContent> itr = contents.iterator();
		while (itr.hasNext()) {
			WeightedRandomChestContent cont = itr.next();
			if (item.isItemEqual(cont.theItemId)
					|| item.getItemDamage() == OreDictionary.WILDCARD_VALUE
					&& item == cont.theItemId) {
				itr.remove();
			}
		}
	}
	
	/**
	 * Gets an array of all random objects that are associated with this
	 * category.
	 *
	 * @return The random objects
	 */
	@Override
	public WeightedRandomChestContent[] getItems(Random rnd) {
		ArrayList<WeightedRandomChestContent> ret = new ArrayList<WeightedRandomChestContent>();
		
		for (WeightedRandomChestContent orig : contents) {
			Item item = orig.theItemId.getItem();
			
			if (item != null) {
				WeightedRandomChestContent n = item.getChestGenBase(this, rnd,
						orig);
				if (n != null) {
					ret.add(n);
				}
			}
		}
		
		return ret.toArray(new WeightedRandomChestContent[ret.size()]);
	}
	
	/**
	 * Gets a random number between countMin and countMax.
	 *
	 * @param rand
	 *            A RNG
	 * @return A random number where countMin <= num <= countMax
	 */
	@Override
	public int getCount(Random rand) {
		return countMin < countMax ? countMin
				+ rand.nextInt(countMax - countMin) : countMin;
	}
	
	/**
	 * Returns a single ItemStack from the possible items in this registry,
	 * Useful if you just want a quick and dirty random Item.
	 *
	 * @param rand
	 *            A Random Number gen
	 * @return A single ItemStack, or null if it could not get one.
	 */
	@Override
	public ItemStack getOneItem(Random rand) {
		WeightedRandomChestContent[] items = getItems(rand);
		WeightedRandomChestContent item = (WeightedRandomChestContent) WeightedRandom
				.getRandomItem(rand, items);
		ItemStack[] stacks = ZEChestGenHooks.generateStacks(rand,
				item.theItemId, item.theMinimumChanceToGenerateItem,
				item.theMaximumChanceToGenerateItem);
		return stacks.length > 0 ? stacks[0] : null;
	}
	
	@Override
	public int getMin() {
		return countMin;
	}
	
	@Override
	public int getMax() {
		return countMax;
	}
	
	@Override
	public void setMin(int value) {
		countMin = value;
	}
	
	@Override
	public void setMax(int value) {
		countMax = value;
	}
}