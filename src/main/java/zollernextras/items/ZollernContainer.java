package zollernextras.items;

import net.minecraft.item.Item;

public class ZollernContainer extends ModItem {
	
	public static Item containerItem;
	
	public ZollernContainer(String strTexture, Item containerItem) {
		super(strTexture);
		this.containerItem = containerItem;
	}
	
	@Override
	public boolean hasContainerItem() {
		return true;
	}
	
	@Override
	public Item getContainerItem() {
		return this.containerItem;
	}
	
}