package zollernextras.blocks;

public class Granite extends GenericBlock {
	public Granite() {
		super("granite", 0F);
		this.setHardness(0.4F);
		this.setResistance(10F);
		this.harvestLevel = 1;
	}
}