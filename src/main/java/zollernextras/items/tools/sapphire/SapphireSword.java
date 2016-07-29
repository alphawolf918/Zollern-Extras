package zollernextras.items.tools.sapphire;

import zollernextras.items.tools.ItemZESword;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernHelper;

public class SapphireSword extends ItemZESword {
	
	public SapphireSword() {
		super(ToolMaterials.SAPPHIRE);
		ZollernHelper.setNameAndTexture(this, "sapphiresword");
	}
	
}