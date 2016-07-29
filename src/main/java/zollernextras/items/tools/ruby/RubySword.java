package zollernextras.items.tools.ruby;

import zollernextras.items.tools.ItemZESword;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernHelper;

public class RubySword extends ItemZESword {
	
	public RubySword() {
		super(ToolMaterials.RUBY);
		ZollernHelper.setNameAndTexture(this, "rubysword");
	}
	
}