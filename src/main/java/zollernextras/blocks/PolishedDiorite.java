package zollernextras.blocks;

public class PolishedDiorite extends GenericBlock {
	public PolishedDiorite() {
		super("polisheddiorite", 2F);
		this.setHardness(0.6F);
		this.setResistance(6F);
		this.setHarvestLevel("pickaxe", 1);
	}
}