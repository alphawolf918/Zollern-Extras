package zollernextras.items.tools.ruby;

import zollernextras.items.tools.ItemZEPickaxe;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.MainHelper;

public class RubyPickaxe extends ItemZEPickaxe {
	
	public RubyPickaxe() {
		super(ToolMaterials.RUBY);
		MainHelper.setNameAndTexture(this, "rubypickaxe");
		this.setHarvestLevel("pickaxe", ToolMaterials.RUBY.getHarvestLevel());
	}
	
}