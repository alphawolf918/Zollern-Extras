package zollernextras.items.tools.sapphire;

import zollernextras.items.tools.ItemZEAxe;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernHelper;

public class SapphireHoe extends ItemZEAxe {
	
	public SapphireHoe() {
		super(ToolMaterials.SAPPHIRE);
		ZollernHelper.setNameAndTexture(this, "sapphirehoe");
	}
	
}