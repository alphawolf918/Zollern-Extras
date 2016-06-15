package zollernextras.blocks;

public class PolishedAndesite extends GenericBlock {
	public PolishedAndesite() {
		super("polishedandesite", 2F);
		this.setHardness(0.6F);
		this.setResistance(6F);
		this.setHarvestLevel("pickaxe", 1);
	}
}