package zollernextras.mobs.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import zollernextras.events.ZollernSoundEvents;
import zollernextras.items.ZollernItems;

public class EntityDuck extends EntityAnimal {
	
	public float field_70886_e;
	public float field_70884_g;
	public float field_70888_h;
	public float field_70889_i = 1.0F;
	
	public float wingRotation;
	public float destPos;
	public float oFlapSpeed;
	public float oFlap;
	public float wingRotDelta = 1.0F;
	
	public int timeUntilNextEgg;
	public int timeUntilNextFeather;
	
	public boolean duckJockey;
	
	public EntityDuck(World par1World) {
		super(par1World);
		this.setSize(0.3F, 0.7F);
		this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
	}
	
	@Override
	public float getEyeHeight() {
		return this.height;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH)
				.setBaseValue(8.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
				.setBaseValue(0.45D);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.0D,
				Items.BEETROOT_SEEDS, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.setPathPriority(PathNodeType.WATER, 0.0F);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.oFlap = this.wingRotation;
		this.oFlapSpeed = this.destPos;
		this.destPos = (float) (this.destPos + (this.onGround ? -1 : 4) * 0.3D);
		this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);
		
		if (!this.onGround && this.wingRotDelta < 1.0F) {
			this.wingRotDelta = 1.0F;
		}
		
		this.wingRotDelta = (float) (this.wingRotDelta * 0.9D);
		
		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}
		
		this.wingRotation += this.wingRotDelta * 2.0F;
		
		if (!this.world.isRemote) {
			if (!this.isChild()) {
				if (!this.isDuckJockey() && --this.timeUntilNextEgg <= 0) {
					this.playSound(
							SoundEvents.ENTITY_CHICKEN_EGG,
							1.0F,
							(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
					this.dropItem(Items.EGG, 1);
					this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
				}
				if (--this.timeUntilNextFeather <= 0) {
					this.dropItem(ZollernItems.duckFeather, 1);
					this.timeUntilNextFeather = this.rand.nextInt(6000) + 6000;
				}
			}
		}
	}
	
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}
	
	@Override
	public EntityAgeable createChild(EntityAgeable par1EntityAgeable) {
		return this.spawnBabyAnimal(par1EntityAgeable);
	}
	
	@Override
	public void fall(float par1Damage, float par2Distance) {
	}
	
	public EntityDuck spawnBabyAnimal(EntityAgeable par1EntityAgeable) {
		return new EntityDuck(this.world);
	}
	
	public boolean isDuckJockey() {
		return this.duckJockey;
	}
	
	public void setDuckJockey(boolean jockey) {
		this.duckJockey = jockey;
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.duckJockey = compound.getBoolean("IsDuckJockey");
		
		if (compound.hasKey("EggLayTime")) {
			this.timeUntilNextEgg = compound.getInteger("EggLayTime");
		}
	}
	
	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setBoolean("IsDuckJockey", this.duckJockey);
		compound.setInteger("EggLayTime", this.timeUntilNextEgg);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZollernSoundEvents.ENTITY_DUCK_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		return ZollernSoundEvents.ENTITY_DUCK_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZollernSoundEvents.ENTITY_DUCK_DIE;
	}
	
	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
	}
	
	@Override
	public void updatePassenger(Entity passenger) {
		super.updatePassenger(passenger);
		float f = MathHelper.sin(this.renderYawOffset * 0.017453292F);
		float f1 = MathHelper.cos(this.renderYawOffset * 0.017453292F);
		float f2 = 0.1F;
		float f3 = 0.0F;
		passenger.setPosition(this.posX + 0.1F * f, this.posY + this.height
				* 0.5F + passenger.getYOffset() + 0.0D, this.posZ - 0.1F * f1);
		
		if (passenger instanceof EntityLivingBase) {
			((EntityLivingBase) passenger).renderYawOffset = this.renderYawOffset;
		}
	}
	
	@Override
	protected boolean canDespawn() {
		return this.isDuckJockey() && !this.isBeingRidden();
	}
}