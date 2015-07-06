package zollernextras.items.dust;

import net.minecraft.item.Item;
import zollernextras.creativetabs.ModTabs;
import zollernextras.lib.Reference;

public class AmaranthDust extends Item {
	public AmaranthDust() {
		this.setCreativeTab(ModTabs.zTab);
		this.setUnlocalizedName(Reference.MODID + "_amaranthdust");
		this.setTextureName(Reference.MODID + ":" + "amaranthdust");
	}
}