package zollernextras.blocks.sirens;

import java.util.Random;
import net.minecraft.world.World;
import zollernextras.blocks.BlockList;
import zollernextras.lib.MainHelper;
import zollernextras.lib.ModInfo;
import zollernextras.lib.enums.State;

public class IronSiren extends SirenBlockBase {
	public static final String sirenInfo = "ironsiren";
	public static State state = State.OFF;
	
	public IronSiren(State state) {
		super(state);
		this.state = state;
		this.setSirenBlockSound(sirenInfo);
		MainHelper.setNameAndTexture(this, sirenInfo);
		this.setTickRandomly(true);
	}
	
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		this.stateCheck(par1World, par2, par3, par4);
	}
	
	public void stateCheck(World par1World, int par2, int par3, int par4) {
		if (!par1World.isRemote) {
			if (state == State.ON
					&& !par1World.isBlockIndirectlyGettingPowered(par2, par3,
							par4)) {
				par1World.scheduleBlockUpdate(par2, par3, par4, this, 0);
				par1World.setBlock(par2, par3, par4, BlockList.ironSiren);
			}
		} else if (this.state == State.OFF
				&& par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
			par1World.setBlock(par2, par3, par4, BlockList.ironSirenON);
		}
		if (this.state == State.OFF
				&& !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
			par1World.setBlock(par2, par3, par4, BlockList.ironSiren);
		}
	}
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		this.playAlarm(par1World, par2, par3, par4);
		this.stateCheck(par1World, par2, par3, par4);
	}
	
	public void playAlarm(World par1World, int par2, int par3, int par4) {
		if (state == State.ON
				&& par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
			par1World.playSoundEffect(par2 + 1.5D, par3 + 1.5D, par4 + 1.5D,
					ModInfo.MODID + ":" + "alarms." + sirenInfo, 2.5F,
					par1World.rand.nextFloat() * 0.1F + 0.9F);
		}
	}
}