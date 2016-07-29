package zollernextras.items.tools.ruby;

import zollernextras.items.tools.ItemZEShovel;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernHelper;

public class RubyShovel extends ItemZEShovel {
	
	public RubyShovel() {
		super(ToolMaterials.RUBY);
		ZollernHelper.setNameAndTexture(this, "rubyshovel");
		this.setHarvestLevel("shovel", ToolMaterials.RUBY.getHarvestLevel());
	}
	
}