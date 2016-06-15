package zollernextras.blocks;

public class Andesite extends GenericBlock {
	public Andesite() {
		super("andesite", 0F);
		this.setHardness(0.5F);
		this.setResistance(6F);
		this.setHarvestLevel("pickaxe", 1);
	}
}