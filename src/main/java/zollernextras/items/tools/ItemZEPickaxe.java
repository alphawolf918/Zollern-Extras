package zollernextras.items.tools;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import zollernextras.lib.KeyHelper;
import zollernextras.lib.ZollernHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemZEPickaxe extends ItemPickaxe {
	
	public ItemZEPickaxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		ZollernHelper.setTab(this);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			list.add("Harvest Level: " + this.getHarvestLevel(stack, "pickaxe"));
		} else {
			list.add("Hold SHIFT for");
			list.add("more information.");
		}
	}
	
}