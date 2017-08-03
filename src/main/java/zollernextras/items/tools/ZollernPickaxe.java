package zollernextras.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollernextras.creativetabs.ZollernTabs;
import zollernextras.lib.ZollernHelper;

public class ZollernPickaxe extends ItemPickaxe {
	
	public ZollernPickaxe(ToolMaterial material, String strTexture) {
		super(material);
		ZollernHelper.setName(this, strTexture);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZollernTabs.zTab;
	}
	
}