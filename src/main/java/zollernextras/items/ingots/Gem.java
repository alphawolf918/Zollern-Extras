package zollernextras.items.ingots;

import zollernextras.items.GenericItem;
import zollernextras.lib.ZollernHelper;

/**
 * Right now there's really no reason to have this extra class, but I have it
 * separate from GenericItem just in case I decide to do something special with the
 * Gem items some day.
 * 
 * @author Zollern Wolf
 */
public class Gem extends GenericItem {
	
	public Gem(String name) {
		super(name);
		ZollernHelper.setTab(this);
		ZollernHelper.setNameAndTexture(this, name);
	}
}