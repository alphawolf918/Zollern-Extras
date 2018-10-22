package zollernextras.lib.recipes;

import net.minecraft.item.Item;
import zollernextras.api.recipe.RecipeHelper;
import zollernextras.items.ZollernItems;

public class ArmorRecipes {
	
	public static void init() {
		// Helmet
		addArmorSet(ZollernItems.amaranthHelm, ZollernItems.amaranthIngot, "helmet");
		addArmorSet(ZollernItems.zollerniumHelm, ZollernItems.zollerniumIngot, "helmet");
		addArmorSet(ZollernItems.azuriteHelm, ZollernItems.azurite, "helmet");
		addArmorSet(ZollernItems.radiantHelm, ZollernItems.radium, "helmet");
		
		// Chest
		addArmorSet(ZollernItems.amaranthChest, ZollernItems.amaranthIngot, "Chest");
		addArmorSet(ZollernItems.zollerniumChest, ZollernItems.zollerniumIngot, "Chest");
		addArmorSet(ZollernItems.azuriteChest, ZollernItems.azurite, "Chest");
		addArmorSet(ZollernItems.zollerniumLegs, ZollernItems.zollerniumIngot, "Chest");
		addArmorSet(ZollernItems.radiantChest, ZollernItems.radium, "Chest");
		
		// Legs
		addArmorSet(ZollernItems.amaranthLegs, ZollernItems.amaranthIngot, "Legs");
		addArmorSet(ZollernItems.zollerniumLegs, ZollernItems.zollerniumIngot, "Legs");
		addArmorSet(ZollernItems.azuriteLegs, ZollernItems.azurite, "Legs");
		addArmorSet(ZollernItems.radiantLegs, ZollernItems.radium, "Legs");
		
		// Feets
		addArmorSet(ZollernItems.amaranthBoots, ZollernItems.amaranthIngot, "boots");
		addArmorSet(ZollernItems.zollerniumBoots, ZollernItems.zollerniumIngot, "boots");
		addArmorSet(ZollernItems.azuriteBoots, ZollernItems.azurite, "boots");
		addArmorSet(ZollernItems.radiantBoots, ZollernItems.radium, "boots");
	}
	
	static void addArmorSet(Item par1Item, Item par2Item, String par3String) {
		RecipeHelper.addArmorSet(par1Item, par2Item, par3String);
	}
	
}