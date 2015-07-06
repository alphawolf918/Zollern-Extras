package zollernextras.blocks.sirens;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import zollernextras.lib.M;
import zollernextras.lib.enums.State;

public class SirenBlockBase extends Block {
	
	public static State state = State.OFF;
	public String texture = "";
	public String sound = "";
	
	public SirenBlockBase(State state) {
		super(Material.iron);
		this.state = State.OFF;
		if (this.state == State.ON) {
			this.setLightLevel(1.0F);
		} else {
			this.setLightLevel(0.0F);
		}
		M.setTab(this);
		this.setHardness(2F);
		this.setResistance(10);
		this.setStepSound(soundTypeMetal);
		this.setTickRandomly(true);
	}
	
	public void setSirenBlockSound(String par1) {
		this.sound = par1;
	}
	
	public String getSirenBlockSound() {
		return this.sound;
	}
}