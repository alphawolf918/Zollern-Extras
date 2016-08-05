package zollernextras.items;

import net.minecraft.item.Item;
import zollernextras.lib.ZollernHelper;

public class GenericItem extends Item {
	
	public GenericItem(String strTexture) {
		this.setTab();
		this.setNameAndTexture(strTexture);
	}
	
	public Item setTab() {
		ZollernHelper.setTab(this);
		return this;
	}
	
	public Item setName(String strName) {
		ZollernHelper.setName(this, strName);
		return this;
	}
	
	public Item setTexture(String strTexture) {
		ZollernHelper.setTexture(this, strTexture);
		return this;
	}
	
	public Item setNameAndTexture(String strNameTexture) {
		ZollernHelper.setNameAndTexture(this, strNameTexture);
		return this;
	}
	
	public Item setNameAndTexture(String strName, String strTexture) {
		ZollernHelper.setNameAndTexture(this, strName, strTexture);
		return this;
	}
	
}