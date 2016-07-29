package zollernextras.items.tools.ruby;

import zollernextras.items.tools.ItemZEPickaxe;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernHelper;

public class RubyPickaxe extends ItemZEPickaxe {
	
	public RubyPickaxe() {
		super(ToolMaterials.RUBY);
		ZollernHelper.setNameAndTexture(this, "rubypickaxe");
		this.setHarvestLevel("pickaxe", ToolMaterials.RUBY.getHarvestLevel());
	}
	
}