package zollernextras.mobs.entities;

import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFish extends EntityWaterMob implements IAnimals {
	
	public float squidPitch;
	public float prevSquidPitch;
	public float squidYaw;
	public float prevSquidYaw;
	public float squidRotation;
	public float prevSquidRotation;
	public float tentacleAngle;
	public float prevTentacleAngle;
	private float randomMotionSpeed;
	private float rotationVelocity;
	private float field_70871_bB;
	private float randomMotionVecX;
	private float randomMotionVecY;
	private float randomMotionVecZ;
	protected Random rand = new Random();
	protected float minSize = 0.1F;
	protected float maxSize = 5.0F;
	public EntityAIAvoidEntity ea = new EntityAIAvoidEntity(this,
			EntityShark.class, 8.0F, 0.6D, 0.6D);
	public EntityAIPanic ea2 = new EntityAIPanic(this, 1.25D);
	protected float fishEq = this.rand.nextFloat();
	protected float fishSize = this.fishEq + this.minSize;
	protected float maxHealthLimit = 20F;
	
	public EntityFish(World par1World) {
		super(par1World);
		this.setSize(this.width, this.height);
		this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 2.0D));
		this.tasks.addTask(2, new EntityAIWatchClosest(this,
				EntityPlayer.class, 10.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.tasks.addTask(4, ea2);
		this.tasks.addTask(5, ea);
		this.setHealth(2F);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
		.setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
		.setBaseValue(2.0F);
	}
	
	@Override
	public boolean isInWater() {
		return this.worldObj.handleMaterialAcceleration(
				this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D),
				Material.water, this);
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}
	
	@Override
	protected Item getDropItem() {
		return Items.fish;
	}
	
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}
	
	// @Override
	// public void entityInit() {
	// super.entityInit();
	// this.dataWatcher.addObject(26, Float.valueOf(fishSize));
	// }
	//
	// @Override
	// public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
	// super.writeEntityToNBT(par1NBTTagCompound);
	// par1NBTTagCompound.setFloat("FishSize", this.getFishSize());
	// }
	//
	// @Override
	// public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
	// super.readEntityFromNBT(par1NBTTagCompound);
	// this.setFishSize(par1NBTTagCompound.getFloat("FishSize"));
	// }
	//
	// public void setFishSize(float par1) {
	// if (this.getFishSize() < maxSize) {
	// this.dataWatcher.updateObject(26, Float.valueOf(par1));
	// } else {
	// this.dataWatcher.updateObject(26, Float.valueOf(maxSize));
	// }
	// }
	//
	// public float getFishSize() {
	// return this.dataWatcher.getWatchableObjectFloat(26);
	// }
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.prevSquidPitch = this.squidPitch;
		this.prevSquidYaw = this.squidYaw;
		this.prevSquidRotation = this.squidRotation;
		this.prevTentacleAngle = this.tentacleAngle;
		this.squidRotation += this.rotationVelocity;
		
		if (this.squidRotation > (float) Math.PI * 2F) {
			this.squidRotation -= (float) Math.PI * 2F;
			
			if (this.rand.nextInt(10) == 0) {
				this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.4F;
			}
		}
		
		if (this.isInWater()) {
			float f;
			
			if (this.squidRotation < (float) Math.PI) {
				f = this.squidRotation / (float) Math.PI;
				this.tentacleAngle = MathHelper.sin(f * f * (float) Math.PI)
						* (float) Math.PI * 0.25F;
				
				if (f > 0.75D) {
					this.randomMotionSpeed = 1.4F;
					this.field_70871_bB = 1.4F;
				} else {
					this.field_70871_bB *= 0.8F;
				}
			} else {
				this.tentacleAngle = 0.0F;
				this.randomMotionSpeed *= 1.0F;
				this.field_70871_bB *= 1.0F;
			}
			
			f = MathHelper.sqrt_double(this.motionX * this.motionX
					+ this.motionZ * this.motionZ);
			this.renderYawOffset += (-((float) Math.atan2(this.motionX,
					this.motionZ)) * 180.0F / (float) Math.PI - this.renderYawOffset) * 0.1F;
			this.rotationYaw = this.renderYawOffset;
			this.squidYaw += (float) Math.PI * this.field_70871_bB * 1.5F;
			this.squidPitch += (-((float) Math.atan2(f, this.motionY)) * 180.0F
					/ (float) Math.PI - this.squidPitch) * 0.1F;
		} else {
			this.tentacleAngle = MathHelper.abs(MathHelper
					.sin(this.squidRotation)) * (float) Math.PI * 0.25F;
			
			if (!this.worldObj.isRemote) {
				this.motionX = 0.0D;
				this.motionY -= 0.08D;
				this.motionY *= 0.9800000190734863D;
				this.motionZ = 0.0D;
			}
			
			this.squidPitch = (float) (this.squidPitch + (-90.0F - this.squidPitch) * 0.02D);
		}
		// this.updateArmSwingProgress();
		float f = this.getBrightness(1.0F);
		
		if (f > 0.5F) {
			this.entityAge += 2;
		}
	}
}