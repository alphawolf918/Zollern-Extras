package zollernextras.items.tools.ruby;

import zollernextras.items.tools.ItemZESword;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.MainHelper;

public class RubySword extends ItemZESword {
	
	public RubySword() {
		super(ToolMaterials.RUBY);
		MainHelper.setNameAndTexture(this, "rubysword");
	}
	
}