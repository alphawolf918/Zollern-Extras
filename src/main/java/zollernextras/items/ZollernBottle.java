package zollernextras.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ZollernBottle extends ModItem {
	
	public ZollernBottle(String strTexture) {
		super(strTexture);
	}
	
	@Override
	public boolean getShareTag() {
		return true;
	}
	
	@Override
	public boolean hasContainerItem() {
		return true;
	}
	
	@Override
	public Item getContainerItem() {
		return Items.glass_bottle;
	}
}