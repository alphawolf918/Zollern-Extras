package zollernextras.items.tools.sapphire;

import zollernextras.items.tools.ItemZEPickaxe;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.MainHelper;

public class SapphirePickaxe extends ItemZEPickaxe {
	
	public SapphirePickaxe() {
		super(ToolMaterials.SAPPHIRE);
		MainHelper.setNameAndTexture(this, "sapphirepickaxe");
		this.setHarvestLevel("pickaxe",
				ToolMaterials.SAPPHIRE.getHarvestLevel());
	}
	
}