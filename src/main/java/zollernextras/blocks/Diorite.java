package zollernextras.blocks;

public class Diorite extends GenericBlock {
	public Diorite() {
		super("diorite", 0F);
		this.setHardness(0.4F);
		this.setResistance(10F);
		this.harvestLevel = 1;
	}
}