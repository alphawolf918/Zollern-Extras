package zollernextras.blocks;

public class Diorite extends GenericBlock {
	public Diorite() {
		super("diorite", 0F);
		this.setHardness(1.0F);
		this.setResistance(10F);
		this.setHarvestLevel("pickaxe", 1);
	}
}