package zollernextras.items;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.lib.KeyHelper;
import zollernextras.lib.ZollernHelper;
import com.mojang.realmsclient.gui.ChatFormatting;

public class ZollernItemBase extends Item {
	
	protected String itemDetails;
	
	public ZollernItemBase(String itemName) {
		this.setTab();
		this.setRegistryName(itemName);
		this.setUnlocalizedName(itemName);
	}
	
	public Item setTab() {
		ZollernHelper.setTab(this);
		return this;
	}
	
	public Item setName(String strName) {
		ZollernHelper.setName(this, strName);
		return this;
	}
	
	/**
	 * Sets the text information to be displayed on the Item when the mouse is
	 * hovered over it.
	 * 
	 * @param info
	 *            The information to set.
	 * @return
	 */
	public Item setDetails(String info) {
		this.itemDetails = info;
		return this;
	}
	
	/**
	 * Gets the text information associated with this Item.
	 * 
	 * @return The information associated with this item.
	 */
	public String getDetails() {
		return this.itemDetails;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		if (this.getDetails() != "" && this.getDetails() != null) {
			if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
				list.add(ChatFormatting.ITALIC + this.getDetails());
			} else {
				list.add("Hold SHIFT for");
				list.add("more information.");
			}
		}
	}
}