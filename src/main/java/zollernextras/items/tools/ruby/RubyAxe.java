package zollernextras.items.tools.ruby;

import zollernextras.items.tools.ItemZEAxe;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernHelper;

public class RubyAxe extends ItemZEAxe {
	
	public RubyAxe() {
		super(ToolMaterials.RUBY);
		ZollernHelper.setNameAndTexture(this, "rubyaxe");
		this.setHarvestLevel("axe", ToolMaterials.RUBY.getHarvestLevel());
	}
	
}