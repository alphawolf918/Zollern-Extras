package zollernextras.blocks;

public class ChocolateBlock extends GenericBlock {
	public ChocolateBlock() {
		super("chocolateblock", 0.4F);
		this.setHardness(1.2F);
		this.setResistance(2.0F);
		this.setHarvestLevel("pickaxe", 1);
	}
}