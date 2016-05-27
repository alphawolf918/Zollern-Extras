package zollernextras.items.lostdesert;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import zollernextras.dimensions.Dimensions;
import zollernextras.items.ModItem;

public class ItemTransporter extends ModItem {
	public ItemTransporter(String par1) {
		super(par1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_,
			EntityPlayer p_77659_3_) {
		p_77659_3_.travelToDimension(Dimensions.dimId);
		return p_77659_1_;
	}
}