package zollernextras.blocks.ores;

public class CorruptOre extends GenericUpsideDownOre {
	
	public CorruptOre(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setFortune(2.0D);
		this.setMaxDropIncrease(20);
		this.setHarvestLevel("pickaxe", 5);
	}
}