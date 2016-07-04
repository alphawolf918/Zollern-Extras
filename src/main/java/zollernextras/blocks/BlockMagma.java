package zollernextras.blocks;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMagma extends GenericBlock {
	
	public BlockMagma() {
		super("magmarock", 1.4F);
		this.setTickRandomly(true);
		this.setLightLevel(1.0F);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_,
			int p_149670_3_, int p_149670_4_, Entity entity) {
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase living = (EntityLivingBase) entity;
			living.attackEntityFrom(DamageSource.onFire, 2.0F);
			living.setFire(4);
		}
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_,
			int p_149668_2_, int p_149668_3_, int p_149668_4_) {
		float f = 0.0625F;
		return AxisAlignedBB.getBoundingBox(p_149668_2_ + f, p_149668_3_,
				p_149668_4_ + f, p_149668_2_ + 1 - f, p_149668_3_ + 1 - f,
				p_149668_4_ + 1 - f);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_,
			int p_149633_2_, int p_149633_3_, int p_149633_4_) {
		float f = 0.0625F;
		return AxisAlignedBB.getBoundingBox(p_149633_2_ + f, p_149633_3_,
				p_149633_4_ + f, p_149633_2_ + 1 - f, p_149633_3_ + 1,
				p_149633_4_ + 1 - f);
	}
	
}