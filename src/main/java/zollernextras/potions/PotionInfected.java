package zollernextras.potions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import zollernextras.ZollernExtrasMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PotionInfected extends ZollernPotion {
	
	public PotionInfected(int par1, boolean par2, int par3) {
		super("infected", par1, par2, par3);
	}
	
	@Override
	public void performEffect(EntityLivingBase p_76394_1_, int p_76394_2_) {
		if (p_76394_1_ instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) p_76394_1_;
			ZollernExtrasMod.proxy.doPotionEffect(player, this.id);
		}
	}
	
	@Override
	public int getLiquidColor() {
		return 0x000000;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasStatusIcon() {
		return false;
	}
	
}