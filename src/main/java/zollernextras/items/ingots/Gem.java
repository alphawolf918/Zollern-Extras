package zollernextras.items.ingots;

import zollernextras.items.ModItem;
import zollernextras.lib.MainHelper;

/**
 * Right now there's really no reason to have this extra class, but I have it
 * separate from ModItem just in case I decide to do something special with the
 * Gem items some day.
 * 
 * @author Zollern Wolf
 */
public class Gem extends ModItem {
	
	public Gem(String name) {
		super(name);
		MainHelper.setTab(this);
		MainHelper.setNameAndTexture(this, name);
	}
}