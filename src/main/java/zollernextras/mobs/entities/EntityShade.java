package zollernextras.mobs.entities;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import zaneextras.interfaces.ILightEntity;
import zollernextras.items.ZollernItems;
import zollernextras.lib.ZollernModInfo;
import zollernextras.lib.modhelper.ModHelperBase;

public class EntityShade extends EntityZombie implements IShadeEntity {
	
	public EntityShade(World par1World) {
		super(par1World);
		this.setCanPickUpLoot(true);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
				EntityPlayer.class, 2.0D, false));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this,
				EntityVillager.class, 2.0D, true));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks
				.addTask(5, new EntityAIMoveThroughVillage(this, 2.0D, false));
		this.tasks.addTask(6, new EntityAIWander(this, 2.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityVillager.class, 0, false));
		if (ModHelperBase.useZaneExtras && this.shouldAttackLightEntity()) {
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(
					this, ILightEntity.class, 10, false));
		}
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.31D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(10.0D);
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override
	public int getTotalArmorValue() {
		int i = super.getTotalArmorValue() + 2;
		
		if (i > 20) {
			i = 20;
		}
		
		return i;
	}
	
	@Override
	protected String getLivingSound() {
		return ZollernModInfo.MODID + ":shade.say";
	}
	
	@Override
	protected String getHurtSound() {
		return ZollernModInfo.MODID + ":shade.hurt";
	}
	
	@Override
	protected String getDeathSound() {
		return ZollernModInfo.MODID + ":shade.die";
	}
	
	@Override
	protected void addRandomArmor() {
		super.addRandomArmor();
		
		if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
			int i = this.rand.nextInt(3);
			
			if (i == 0) {
				this.setCurrentItemOrArmor(0, new ItemStack(
						ZollernItems.amaranthSword));
			} else {
				this.setCurrentItemOrArmor(0,
						new ItemStack(Items.diamond_sword));
			}
		}
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	public void setFire(int par1) {
		// nothing
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
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
	}
	
	@Override
	public boolean shouldAttackLightEntity() {
		return true;
	}
	
}