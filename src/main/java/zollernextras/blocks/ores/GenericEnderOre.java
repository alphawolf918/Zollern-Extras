package zollernextras.blocks.ores;

public class GenericEnderOre extends GenericBlockOre {
	
	public GenericEnderOre(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setFortune(1.2D);
		this.setMaxDropIncrease(8);
	}
	
}