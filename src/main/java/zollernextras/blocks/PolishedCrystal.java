package zollernextras.blocks;

public class PolishedCrystal extends GenericBlock {
	public PolishedCrystal() {
		super("polishedcrystal", 0.2F);
		this.setLightLevel(1.0F);
		this.setHardness(1.2F);
		this.setResistance(2.4F);
		this.setHarvestLevel("pickaxe", 1);
	}
}