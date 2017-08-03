package zollernextras.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.ZollernHelper;

public class ZollernAxe extends ItemAxe {
	
	public ZollernAxe(ToolMaterial material, String strTexture, float speed) {
		super(material, material.getDamageVsEntity(), speed);
		ZollernHelper.setName(this, strTexture);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZollernTabs.zTab;
	}
}