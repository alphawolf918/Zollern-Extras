package zollernextras.mobs.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import zollernextras.items.ZollernItems;

public class EntityBabyDragon extends EntityTameable {
	
	private final EntityAIControlledByPlayer aiControlledByPlayer;
	
	public EntityBabyDragon(World par1World) {
		super(par1World);
		this.setSize(this.width * 2, this.height * 2);
		this.experienceValue = 180;
		this.scoreValue = 450;
		this.getNavigator().setAvoidsWater(false);
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1,
				this.aiControlledByPlayer = new EntityAIControlledByPlayer(
						this, 1.2F));
		this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.8F));
		this.tasks.addTask(4, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(5, new EntityAITempt(this, 1.2D, Items.ender_pearl,
				false));
		this.tasks.addTask(5, new EntityAITempt(this, 1.2D, ZollernItems.garnet,
				false));
		this.tasks.addTask(6, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		this.tasks.addTask(10, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks
				.addTask(11, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this,
				EntitySheep.class, 200, false));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this,
				EntityLiving.class, 0, false, true, IMob.mobSelector));
		this.setTamed(false);
		this.stepHeight = 2F;
	}
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		this.walkOnWater();
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.walkOnWater();
	}
	
	public void walkOnWater() {
		World world = this.worldObj;
		Block block = world.getBlock((int) this.posX, (int) (this.posY - 1),
				(int) this.posZ);
		if (block == Blocks.water) {
			this.worldObj.setBlock((int) this.posX, (int) (this.posY - 1),
					(int) this.posZ, Blocks.ice);
		}
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			Entity entity = p_70097_1_.getEntity();
			this.aiSit.setSitting(false);
			
			if (entity != null && !(entity instanceof EntityPlayer)
					&& !(entity instanceof EntityArrow)) {
				p_70097_2_ = (p_70097_2_ + 1.0F) / 2.0F;
			}
			
			return super.attackEntityFrom(p_70097_1_, p_70097_2_);
		}
	}
	
	@Override
	public boolean attackEntityAsMob(Entity p_70652_1_) {
		int i = this.isTamed() ? 8 : 4;
		return p_70652_1_
				.attackEntityFrom(DamageSource.causeMobDamage(this), i);
	}
	
	@Override
	public void setTamed(boolean p_70903_1_) {
		super.setTamed(p_70903_1_);
	}
	
	@Override
	protected void fall(float p_70069_1_) {
	}
	
	@Override
	public boolean allowLeashing() {
		return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(120.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.38D);
	}
	
	@Override
	public boolean canBeSteered() {
		ItemStack itemstack = ((EntityPlayer) this.riddenByEntity)
				.getHeldItem();
		return itemstack != null && itemstack.getItem() == Items.ender_pearl;
	}
	
	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_,
			int p_145780_3_, Block p_145780_4_) {
		this.playSound("mob.pig.step", 0.30F, 0.5F);
	}
	
	@Override
	public boolean interact(EntityPlayer p_70085_1_) {
		if (super.interact(p_70085_1_)) {
			return true;
		} else if (!this.worldObj.isRemote
				&& (this.riddenByEntity == null || this.riddenByEntity == p_70085_1_)) {
			p_70085_1_.mountEntity(this);
			return true;
		} else if (this.isTamed()) {
			ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();
			if (this.isTamed()) {
				if (itemstack != null) {
					if (itemstack.getItem() instanceof ItemFood) {
						ItemFood itemfood = (ItemFood) itemstack.getItem();
						if (itemfood.isWolfsFavoriteMeat()
								&& this.dataWatcher.getWatchableObjectFloat(18) < 20.0F) {
							if (!p_70085_1_.capabilities.isCreativeMode) {
								--itemstack.stackSize;
							}
							this.heal(itemfood.func_150905_g(itemstack));
							if (itemstack.stackSize <= 0) {
								p_70085_1_.inventory.setInventorySlotContents(
										p_70085_1_.inventory.currentItem,
										(ItemStack) null);
							}
							return true;
						}
					}
				}
				if (this.func_152114_e(p_70085_1_) && !this.worldObj.isRemote
						&& !this.isBreedingItem(itemstack)) {
					this.aiSit.setSitting(!this.isSitting());
					this.isJumping = false;
					this.setPathToEntity((PathEntity) null);
					this.setTarget((Entity) null);
					this.setAttackTarget((EntityLivingBase) null);
				}
			} else if (itemstack != null
					&& itemstack.getItem() == ZollernItems.garnet) {
				if (!p_70085_1_.capabilities.isCreativeMode) {
					--itemstack.stackSize;
				}
				if (itemstack.stackSize <= 0) {
					p_70085_1_.inventory.setInventorySlotContents(
							p_70085_1_.inventory.currentItem, (ItemStack) null);
				}
				if (!this.worldObj.isRemote) {
					if (this.rand.nextInt(3) == 0) {
						this.setTamed(true);
						this.setPathToEntity((PathEntity) null);
						this.setAttackTarget((EntityLivingBase) null);
						// this.aiSit.setSitting(true);
						this.setHealth(120.0F);
						this.func_152115_b(p_70085_1_.getUniqueID().toString());
						this.playTameEffect(true);
						this.worldObj.setEntityState(this, (byte) 7);
					} else {
						this.playTameEffect(false);
						this.worldObj.setEntityState(this, (byte) 6);
					}
				}
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	
	@Override
	public boolean isBreedingItem(ItemStack p_70877_1_) {
		return p_70877_1_ != null && p_70877_1_.getItem() == ZollernItems.garnet;
	}
	
	@Override
	protected float getSoundVolume() {
		return 1.5F;
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	public EntityBabyDragon createChild(EntityAgeable p_90011_1_) {
		return new EntityBabyDragon(this.worldObj);
	}
	
	public EntityAIControlledByPlayer getAIControlledByPlayer() {
		return this.aiControlledByPlayer;
	}
}