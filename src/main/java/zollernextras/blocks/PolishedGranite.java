package zollernextras.blocks;

public class PolishedGranite extends GenericBlock {
	public PolishedGranite() {
		super("polishedgranite", 2F);
		this.setHardness(0.6F);
		this.setResistance(6F);
		this.setHarvestLevel("pickaxe", 1);
	}
}