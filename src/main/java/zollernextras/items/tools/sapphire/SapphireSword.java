package zollernextras.items.tools.sapphire;

import zollernextras.items.tools.ItemZESword;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.MainHelper;

public class SapphireSword extends ItemZESword {
	
	public SapphireSword() {
		super(ToolMaterials.SAPPHIRE);
		MainHelper.setNameAndTexture(this, "sapphiresword");
	}
	
}