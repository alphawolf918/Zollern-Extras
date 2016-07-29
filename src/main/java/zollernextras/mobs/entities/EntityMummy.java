package zollernextras.mobs.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
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
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import zollernextras.items.ZollernItems;
import zollernextras.lib.ZollernModInfo;

public class EntityMummy extends EntityZombie {
	
	protected static final IAttribute field_110186_bp = new RangedAttribute(
			"zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D);
	
	public EntityMummy(World par1World) {
		super(par1World);
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
		return ZollernModInfo.MODID + ":mummy.say";
	}
	
	@Override
	protected String getHurtSound() {
		return ZollernModInfo.MODID + ":mummy.hurt";
	}
	
	@Override
	protected String getDeathSound() {
		return ZollernModInfo.MODID + ":mummy.die";
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override
	protected void dropRareDrop(int par1) {
		switch (this.rand.nextInt(3)) {
		case 0:
			this.dropItem(Items.gold_ingot, 1);
			break;
		case 1:
			this.dropItem(Items.paper, 1);
			break;
		case 2:
			this.dropItem(Items.potato, 1);
		}
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
	protected Item getDropItem() {
		return Items.rotten_flesh;
	}
	
	@Override
	protected boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
		.setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
		.setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
		.setBaseValue(5.0D);
	}
	
	@Override
	public void onKillEntity(EntityLivingBase par1EntityLivingBase) {
		super.onKillEntity(par1EntityLivingBase);
		
		if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL
				&& par1EntityLivingBase instanceof EntityVillager) {
			EntityMummy entitymummy = new EntityMummy(this.worldObj);
			entitymummy.copyLocationAndAnglesFrom(par1EntityLivingBase);
			this.worldObj.removeEntity(par1EntityLivingBase);
			entitymummy.onSpawnWithEgg((IEntityLivingData) null);
			this.worldObj.spawnEntityInWorld(entitymummy);
			this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1016,
					(int) this.posX, (int) this.posY, (int) this.posZ, 0);
		}
	}
}