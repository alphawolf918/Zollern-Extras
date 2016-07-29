package zollernextras.items.tools.sapphire;

import zollernextras.items.tools.ItemZEPickaxe;
import zollernextras.items.tools.ToolMaterials;
import zollernextras.lib.ZollernHelper;

public class SapphirePickaxe extends ItemZEPickaxe {
	
	public SapphirePickaxe() {
		super(ToolMaterials.SAPPHIRE);
		ZollernHelper.setNameAndTexture(this, "sapphirepickaxe");
		this.setHarvestLevel("pickaxe",
				ToolMaterials.SAPPHIRE.getHarvestLevel());
	}
	
}