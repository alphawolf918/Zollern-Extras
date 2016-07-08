package zollernextras.mobs.entities;

import java.util.Calendar;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import zaneextras.items.ItemList;
import zaneextras.items.arrow.EntityEnderArrow;

public class EntityEnderSkeleton extends EntityMob implements IRangedAttackMob {
	
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this,
			1.0D, 20, 60, 15.0F);
	private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(
			this, EntityPlayer.class, 1.2D, false);
	
	public EntityEnderSkeleton(World p_i1741_1_) {
		super(p_i1741_1_);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
		this.addRandomArmor();
		
		if (p_i1741_1_ != null && !p_i1741_1_.isRemote) {
			this.setCombatTask();
			this.addRandomArmor();
		}
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
		.setBaseValue(0.45D);
	}
	
	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	@Override
	protected String getLivingSound() {
		return "mob.skeleton.say";
	}
	
	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	@Override
	protected String getHurtSound() {
		return "mob.skeleton.hurt";
	}
	
	/**
	 * Returns the sound this mob makes on death.
	 */
	@Override
	protected String getDeathSound() {
		return "mob.skeleton.death";
	}
	
	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_,
			int p_145780_3_, Block p_145780_4_) {
		this.playSound("mob.skeleton.step", 0.05F, 0.5F);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity p_70652_1_) {
		if (super.attackEntityAsMob(p_70652_1_)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Get this Entity's EnumCreatureAttribute
	 */
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override
	public void setFire(int par1) {
		
	}
	
	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate() {
		if (this.worldObj.isDaytime() && !this.worldObj.isRemote) {
			float f = this.getBrightness(1.0F);
			
			if (f > 0.5F
					&& this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F
					&& this.worldObj.canBlockSeeTheSky(
							MathHelper.floor_double(this.posX),
							MathHelper.floor_double(this.posY),
							MathHelper.floor_double(this.posZ))) {
				boolean flag = true;
				ItemStack itemstack = this.getEquipmentInSlot(4);
				
				if (itemstack != null) {
					if (itemstack.isItemStackDamageable()) {
						itemstack.setItemDamage(itemstack
								.getItemDamageForDisplay()
								+ this.rand.nextInt(2));
						
						if (itemstack.getItemDamageForDisplay() >= itemstack
								.getMaxDamage()) {
							this.renderBrokenItemStack(itemstack);
							this.setCurrentItemOrArmor(4, (ItemStack) null);
						}
					}
					
					flag = false;
				}
				
				if (flag) {
					this.setFire(8);
				}
			}
		}
		
		if (this.worldObj.isRemote) {
			this.setSize(0.72F, 2.34F);
		}
		
		super.onLivingUpdate();
	}
	
	/**
	 * Handles updating while being ridden by an entity
	 */
	@Override
	public void updateRidden() {
		super.updateRidden();
		
		if (this.ridingEntity instanceof EntityCreature) {
			EntityCreature entitycreature = (EntityCreature) this.ridingEntity;
			this.renderYawOffset = entitycreature.renderYawOffset;
		}
	}
	
	/**
	 * Called when the mob's health reaches 0.
	 */
	@Override
	public void onDeath(DamageSource p_70645_1_) {
		super.onDeath(p_70645_1_);
		
		if (p_70645_1_.getSourceOfDamage() instanceof EntityEnderArrow
				&& p_70645_1_.getEntity() instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) p_70645_1_.getEntity();
			double d0 = entityplayer.posX - this.posX;
			double d1 = entityplayer.posZ - this.posZ;
			
			if (d0 * d0 + d1 * d1 >= 2500.0D) {
				entityplayer.triggerAchievement(AchievementList.snipeSkeleton);
			}
		}
	}
	
	@Override
	protected Item getDropItem() {
		return ItemList.enderArrow;
	}
	
	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j;
		int k;
		
		j = this.rand.nextInt(3 + p_70628_2_);
		
		for (k = 0; k < j; ++k) {
			this.dropItem(ItemList.enderArrow, 1);
		}
		
		j = this.rand.nextInt(3 + p_70628_2_);
		
		for (k = 0; k < j; ++k) {
			this.dropItem(Items.bone, 1);
		}
	}
	
	@Override
	protected void dropRareDrop(int p_70600_1_) {
		this.entityDropItem(new ItemStack(ItemList.enderBow), 0.0F);
	}
	
	/**
	 * Makes entity wear random armor based on difficulty
	 */
	@Override
	protected void addRandomArmor() {
		super.addRandomArmor();
		this.setCurrentItemOrArmor(0, new ItemStack(ItemList.enderBow));
	}
	
	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_) {
		p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);
		
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * this.worldObj
				.func_147462_b(this.posX, this.posY, this.posZ));
		
		if (this.getEquipmentInSlot(4) == null) {
			Calendar calendar = this.worldObj.getCurrentDate();
			
			if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31
					&& this.rand.nextFloat() < 0.25F) {
				this.setCurrentItemOrArmor(
						4,
						new ItemStack(
								this.rand.nextFloat() < 0.1F ? Blocks.lit_pumpkin
										: Blocks.pumpkin));
				this.equipmentDropChances[4] = 0.0F;
			}
		}
		
		return p_110161_1_;
	}
	
	/**
	 * sets this entity's combat AI.
	 */
	public void setCombatTask() {
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack itemstack = this.getHeldItem();
		
		if (itemstack != null && itemstack.getItem() == ItemList.enderBow) {
			this.tasks.addTask(4, this.aiArrowAttack);
		} else {
			this.tasks.addTask(4, this.aiAttackOnCollide);
		}
	}
	
	/**
	 * Attack the specified entity using a ranged attack.
	 */
	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_,
			float p_82196_2_) {
		EntityEnderArrow entityarrow = new EntityEnderArrow(this.worldObj,
				this, p_82196_1_, 1.6F,
				14 - this.worldObj.difficultySetting.getDifficultyId() * 4);
		int i = EnchantmentHelper.getEnchantmentLevel(
				Enchantment.power.effectId, this.getHeldItem());
		int j = EnchantmentHelper.getEnchantmentLevel(
				Enchantment.punch.effectId, this.getHeldItem());
		entityarrow.setDamage(p_82196_2_ * 2.0F + this.rand.nextGaussian()
				* 0.25D + this.worldObj.difficultySetting.getDifficultyId()
				* 0.11F);
		
		if (i > 0) {
			entityarrow.setDamage(entityarrow.getDamage() + i * 0.5D + 0.5D);
		}
		
		if (j > 0) {
			entityarrow.setKnockbackStrength(j);
		}
		
		if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId,
				this.getHeldItem()) > 0) {
			entityarrow.setFire(100);
		}
		
		this.playSound("random.bow", 1.0F,
				1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(entityarrow);
	}
	
	@Override
	public boolean isValidLightLevel() {
		return true;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL
				&& this.isValidLightLevel() && super.getCanSpawnHere();
	}
	
	/**
	 * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is
	 * armor. Params: Item, slot
	 */
	@Override
	public void setCurrentItemOrArmor(int p_70062_1_, ItemStack p_70062_2_) {
		super.setCurrentItemOrArmor(p_70062_1_, p_70062_2_);
		
		if (!this.worldObj.isRemote && p_70062_1_ == 0) {
			this.setCombatTask();
		}
	}
	
	/**
	 * Returns the Y Offset of this entity.
	 */
	@Override
	public double getYOffset() {
		return super.getYOffset() - 0.5D;
	}
}