package zollernextras.mobs.entities;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class EntityPigshroom extends EntityPig implements IShearable {
	public EntityPigshroom(World par1) {
		super(par1);
		this.setSize(this.width, this.height);
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.50D);
	}
	
	@Override
	public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt) {
	}
	
	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x,
			int y, int z) {
		return true;
	}
	
	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world,
			int x, int y, int z, int fortune) {
		setDead();
		EntityPig entitypig = new EntityPig(worldObj);
		entitypig.setLocationAndAngles(posX, posY, posZ, rotationYaw,
				rotationPitch);
		entitypig.setHealth(this.getHealth());
		entitypig.renderYawOffset = renderYawOffset;
		worldObj.spawnEntityInWorld(entitypig);
		worldObj.spawnParticle("largeexplode", posX, posY + height / 2.0F,
				posZ, 0.0D, 0.0D, 0.0D);
		
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		for (int jx = 0; jx < 5; jx++) {
			ret.add(new ItemStack(Block.getBlockById(40)));
		}
		return ret;
	}
}