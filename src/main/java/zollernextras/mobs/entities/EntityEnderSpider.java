package zollernextras.mobs.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityEnderSpider extends EntitySpider {
	
	private int teleportDelay;
	
	public EntityEnderSpider(World par1World) {
		super(par1World);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.30000001192092896D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(10.0D);
	}
	
	@Override
	public void onLivingUpdate() {
		if (this.isWet()) {
			this.attackEntityFrom(DamageSource.drown, 1.0F);
		}
		int k;
		for (k = 0; k < 2; ++k) {
			this.worldObj.spawnParticle("portal",
					this.posX + (this.rand.nextDouble() - 0.5D) * this.width,
					this.posY + this.rand.nextDouble() * this.height - 0.25D,
					this.posZ + (this.rand.nextDouble() - 0.5D) * this.width,
					(this.rand.nextDouble() - 0.5D) * 2.0D,
					-this.rand.nextDouble(),
					(this.rand.nextDouble() - 0.5D) * 2.0D);
			
			if (!this.worldObj.isRemote && this.isEntityAlive()) {
				if (this.entityToAttack != null) {
					if (this.entityToAttack instanceof EntityPlayer) {
						if (this.entityToAttack.getDistanceSqToEntity(this) < 16.0D) {
							this.teleportRandomly();
						}
						this.teleportDelay = 0;
					} else if (this.entityToAttack.getDistanceSqToEntity(this) > 256.0D
							&& this.teleportDelay++ >= 30
							&& this.teleportToEntity(this.entityToAttack)) {
						this.teleportDelay = 0;
					}
				} else {
					this.teleportDelay = 0;
				}
			}
		}
	}
	
	@Override
	protected Item getDropItem() {
		return Items.ender_pearl;
	}
	
	protected boolean teleportRandomly() {
		double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
		double d1 = this.posY + (this.rand.nextInt(64) - 32);
		double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
		return this.teleportTo(d0, d1, d2);
	}
	
	protected boolean teleportToEntity(Entity p_70816_1_) {
		Vec3 vec3 = Vec3.createVectorHelper(this.posX - p_70816_1_.posX,
				this.boundingBox.minY + this.height / 2.0F - p_70816_1_.posY
						+ p_70816_1_.getEyeHeight(), this.posZ
						- p_70816_1_.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D
				- vec3.xCoord * d0;
		double d2 = this.posY + (this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D
				- vec3.zCoord * d0;
		return this.teleportTo(d1, d2, d3);
	}
	
	protected boolean teleportTo(double p_70825_1_, double p_70825_3_,
			double p_70825_5_) {
		EnderTeleportEvent event = new EnderTeleportEvent(this, p_70825_1_,
				p_70825_3_, p_70825_5_, 0);
		if (MinecraftForge.EVENT_BUS.post(event)) {
			return false;
		}
		double d3 = this.posX;
		double d4 = this.posY;
		double d5 = this.posZ;
		this.posX = event.targetX;
		this.posY = event.targetY;
		this.posZ = event.targetZ;
		boolean flag = false;
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posY);
		int k = MathHelper.floor_double(this.posZ);
		
		if (this.worldObj.blockExists(i, j, k)) {
			boolean flag1 = false;
			
			while (!flag1 && j > 0) {
				Block block = this.worldObj.getBlock(i, j - 1, k);
				
				if (block.getMaterial().blocksMovement()) {
					flag1 = true;
				} else {
					--this.posY;
					--j;
				}
			}
			
			if (flag1) {
				this.setPosition(this.posX, this.posY, this.posZ);
				
				if (this.worldObj.getCollidingBoundingBoxes(this,
						this.boundingBox).isEmpty()
						&& !this.worldObj.isAnyLiquid(this.boundingBox)) {
					flag = true;
				}
			}
		}
		
		if (!flag) {
			this.setPosition(d3, d4, d5);
			return false;
		} else {
			short short1 = 128;
			
			for (int l = 0; l < short1; ++l) {
				double d6 = l / (short1 - 1.0D);
				float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				double d7 = d3 + (this.posX - d3) * d6
						+ (this.rand.nextDouble() - 0.5D) * this.width * 2.0D;
				double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble()
						* this.height;
				double d9 = d5 + (this.posZ - d5) * d6
						+ (this.rand.nextDouble() - 0.5D) * this.width * 2.0D;
				this.worldObj.spawnParticle("portal", d7, d8, d9, f, f1, f2);
			}
			
			this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal",
					1.0F, 1.0F);
			this.playSound("mob.endermen.portal", 1.0F, 1.0F);
			return true;
		}
	}
	
}