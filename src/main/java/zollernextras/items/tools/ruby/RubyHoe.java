package zollernextras.items.tools.ruby;

import zollernextras.items.tools.ItemZEAxe;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.MainHelper;

public class RubyHoe extends ItemZEAxe {
	
	public RubyHoe() {
		super(ToolMaterials.RUBY);
		MainHelper.setNameAndTexture(this, "rubyhoe");
	}
	
}