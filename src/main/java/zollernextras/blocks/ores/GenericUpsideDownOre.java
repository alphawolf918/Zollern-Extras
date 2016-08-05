package zollernextras.blocks.ores;

public class GenericUpsideDownOre extends GenericBlockOre {
	
	public GenericUpsideDownOre(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setFortune(1.6D);
		this.setMaxDropIncrease(10);
	}
	
}