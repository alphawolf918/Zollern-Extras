package zollernextras.mobs.entities;

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
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import zollernextras.items.ItemList;

public class EntityShadowSkeleton extends EntitySkeleton {
	private final EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(
			this, 2.0D, 20, 60, 15.0F);
	private final EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(
			this, EntityPlayer.class, 2.2D, false);
	
	public EntityShadowSkeleton(World par1World) {
		super(par1World);
		this.setCanPickUpLoot(true);
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
		
		if (par1World != null && !par1World.isRemote) {
			this.setCombatTask();
		}
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.3D);
	}
	
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
					// nothing
				}
			}
		}
		super.onLivingUpdate();
	}
	
	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		int j;
		int k;
		
		if (this.getSkeletonType() == 1) {
			j = this.rand.nextInt(3 + par2) - 1;
			
			for (k = 0; k < j; ++k) {
				this.dropItem(Items.coal, 1);
			}
		} else {
			j = this.rand.nextInt(3 + par2);
			
			for (k = 0; k < j; ++k) {
				this.dropItem(Items.arrow, 1);
			}
		}
		
		j = this.rand.nextInt(3 + par2);
		
		for (k = 0; k < j; ++k) {
			this.dropItem(ItemList.shadowBone, 1);
		}
	}
	
	@Override
	protected void dropRareDrop(int par1) {
		if (this.getSkeletonType() == 1) {
			this.entityDropItem(new ItemStack(Items.skull, 1, 1), 0.0F);
		}
	}
	
	/**
	 * Makes entity wear random armor based on difficulty
	 */
	@Override
	protected void addRandomArmor() {
		super.addRandomArmor();
		this.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
	}
	
	/**
	 * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is
	 * armor. Params: Item, slot
	 */
	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack) {
		super.setCurrentItemOrArmor(par1, par2ItemStack);
		
		if (!this.worldObj.isRemote && par1 == 0) {
			this.setCombatTask();
		}
	}
	
	/**
	 * Returns the Y Offset of this entity.
	 */
	@Override
	public double getYOffset() {
		return super.getYOffset() - 0.4D;
	}
}