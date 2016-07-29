package zollernextras.items.tools.ruby;

import zollernextras.items.tools.ItemZEAxe;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernHelper;

public class RubyHoe extends ItemZEAxe {
	
	public RubyHoe() {
		super(ToolMaterials.RUBY);
		ZollernHelper.setNameAndTexture(this, "rubyhoe");
	}
	
}