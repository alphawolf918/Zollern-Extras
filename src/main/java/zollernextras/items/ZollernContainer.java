package zollernextras.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ZollernContainer extends GenericItem {
	
	public static Item itemContainer = Items.glass_bottle;
	
	public ZollernContainer(String strTexture, Item containerItem) {
		super(strTexture);
		this.itemContainer = containerItem;
	}
	
	@Override
	public boolean hasContainerItem() {
		return true;
	}
	
	@Override
	public Item getContainerItem() {
		return this.itemContainer;
	}
	
}