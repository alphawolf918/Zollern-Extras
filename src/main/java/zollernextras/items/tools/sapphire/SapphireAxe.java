package zollernextras.items.tools.sapphire;

import zollernextras.items.tools.ItemZEAxe;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.MainHelper;

public class SapphireAxe extends ItemZEAxe {
	
	public SapphireAxe() {
		super(ToolMaterials.RUBY);
		MainHelper.setNameAndTexture(this, "sapphireaxe");
		this.setHarvestLevel("axe", ToolMaterials.SAPPHIRE.getHarvestLevel());
	}
	
}