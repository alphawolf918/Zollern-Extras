package zollernextras.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.ZollernHelper;

public class ZollernSword extends ItemSword {
	
	public ZollernSword(ToolMaterial material, String strTexture) {
		super(material);
		ZollernHelper.setName(this, strTexture);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZollernTabs.zTab;
	}
	
}