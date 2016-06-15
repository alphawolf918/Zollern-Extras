package zollernextras.blocks;

public class ChocolateBricks extends GenericBlock {
	public ChocolateBricks() {
		super("chocolatebricks", 1.2F);
		this.setHardness(1.2F);
		this.setResistance(2.0F);
		this.setHarvestLevel("pickaxe", 1);
	}
}