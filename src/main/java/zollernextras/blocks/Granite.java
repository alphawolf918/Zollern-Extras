package zollernextras.blocks;

public class Granite extends GenericBlock {
	public Granite() {
		super("granite", 0F);
		this.setHardness(1.0F);
		this.setResistance(10F);
		this.harvestLevel = 1;
	}
}