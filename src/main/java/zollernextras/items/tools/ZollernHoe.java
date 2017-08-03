package zollernextras.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.ZollernHelper;

public class ZollernHoe extends ItemHoe {
	
	public ZollernHoe(ToolMaterial toolMaterial, String strTexture) {
		super(toolMaterial);
		ZollernHelper.setName(this, strTexture);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZollernTabs.zTab;
	}
	
}