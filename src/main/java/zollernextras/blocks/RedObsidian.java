package zollernextras.blocks;

public class RedObsidian extends GenericBlock {
	
	public RedObsidian() {
		super("redobsidian", 10.0F);
		this.setHardness(2.5F);
		this.setHarvestLevel("pickaxe", 3);
		this.setLightLevel(1.0F);
	}
	
}