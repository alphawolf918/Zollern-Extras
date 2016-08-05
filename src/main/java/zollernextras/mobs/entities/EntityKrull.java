package zollernextras.mobs.entities;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import zollernextras.potions.ZollernPotion;

public class EntityKrull extends EntityMob {
	
	public EntityKrull(World par1World) {
		super(par1World);
		this.setSize(this.width * 1.4f, this.height * 1.4f);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
				EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 10, true));
		this.setCanPickUpLoot(true);
	}
	
	// This searches for Players around the entity's bounding box, and "infects"
	// any that it finds, causing those Players to infect other Players as well.
	// This code is more thoroughly explained in Events.java, under
	// zollernextras.events.
	@Override
	public void onLivingUpdate() {
		List playerList = worldObj.getEntitiesWithinAABB(EntityPlayer.class,
				this.boundingBox.expand(3 + Math.floor(this.ticksExisted / 50),
						2, 3 + Math.floor(this.ticksExisted / 50)));
		Object[] players = playerList.toArray();
		for (Object o : players) {
			EntityPlayer currentPlayer = (EntityPlayer) o;
			if (!currentPlayer.isPotionActive(ZollernPotion.infected)) {
				currentPlayer.addPotionEffect(new PotionEffect(
						ZollernPotion.infected.id, ZollernPotion.infectionTime,
						0));
			}
		}
		super.onLivingUpdate();
	}
	
	// This just cancels fall damage. It's an interdimensional being, so gravity
	// doesn't really apply to it.
	@Override
	public void fall(float par1) {
	}
	
	// When this being kills another, spawn another one, so it seems like the
	// killed entity is "transformed" into one.
	@Override
	public void onKillEntity(EntityLivingBase par1EntityLivingBase) {
		if (!this.worldObj.isRemote) {
			EntityKrull krull = new EntityKrull(this.worldObj);
			krull.setLocationAndAngles(par1EntityLivingBase.posX,
					par1EntityLivingBase.posY, par1EntityLivingBase.posZ, 0, 0);
			if (par1EntityLivingBase instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) par1EntityLivingBase;
				String playerName = player.getCommandSenderName();
				krull.setCustomNameTag("Shadow " + playerName);
			}
			this.worldObj.spawnEntityInWorld(krull);
		}
	}
	
	@Override
	protected Entity findPlayerToAttack() {
		double searchRadius = 5.0D;
		EntityPlayer closestPlayer = this.worldObj
				.getClosestVulnerablePlayerToEntity(this, searchRadius);
		return closestPlayer;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
		.setBaseValue(55.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
		.setBaseValue(20);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
		.setBaseValue(0.24D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
		.setBaseValue(1.0D);
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
}