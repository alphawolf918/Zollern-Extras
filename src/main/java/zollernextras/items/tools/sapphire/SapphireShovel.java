package zollernextras.items.tools.sapphire;

import zollernextras.items.tools.ItemZEShovel;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernHelper;

public class SapphireShovel extends ItemZEShovel {
	
	public SapphireShovel() {
		super(ToolMaterials.SAPPHIRE);
		ZollernHelper.setNameAndTexture(this, "sapphireshovel");
		this.setHarvestLevel("shovel", ToolMaterials.SAPPHIRE.getHarvestLevel());
	}
	
}