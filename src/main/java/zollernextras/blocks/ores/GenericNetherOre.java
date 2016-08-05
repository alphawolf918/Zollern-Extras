package zollernextras.blocks.ores;

public class GenericNetherOre extends GenericBlockOre {
	
	public GenericNetherOre(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setFortune(.08D);
		this.setMaxDropIncrease(6);
	}
	
}