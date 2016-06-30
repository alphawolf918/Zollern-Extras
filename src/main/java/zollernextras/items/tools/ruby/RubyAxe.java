package zollernextras.items.tools.ruby;

import zollernextras.items.tools.ItemZEAxe;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.MainHelper;

public class RubyAxe extends ItemZEAxe {
	
	public RubyAxe() {
		super(ToolMaterials.RUBY);
		MainHelper.setNameAndTexture(this, "rubyaxe");
		this.setHarvestLevel("axe", ToolMaterials.RUBY.getHarvestLevel());
	}
	
}