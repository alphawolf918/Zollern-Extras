package zollernextras.mobs.entities;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import zollernextras.events.ZollernSoundEvents;
import zollernextras.potions.ZollernPotions;

public class EntityKrull extends EntityMob implements IShadeEntity {
	
	public EntityKrull(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 0.5f, this.height * 0.5f);
		this.setCanPickUpLoot(true);
	}
	
	// This searches for Players around the entity's bounding box, and "infects"
	// any that it finds, causing those Players to infect other Players as well.
	// This code is more thoroughly explained in ZollernEventManager.java, under
	// zollernextras.events.
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		AxisAlignedBB boundingBox = this.getEntityBoundingBox();
		World worldObj = this.getEntityWorld();
		List<? extends Entity> playerList = worldObj.<Entity> getEntitiesWithinAABB(
				EntityPlayer.class, boundingBox.expandXyz(3.0D));
		Object[] players = playerList.toArray();
		for (Object o : players) {
			EntityPlayer currentPlayer = (EntityPlayer) o;
			if (!currentPlayer.isPotionActive(ZollernPotions.infected)) {
				currentPlayer.addPotionEffect(new PotionEffect(ZollernPotions.infected,
						ZollernPotions.infectionTime, 0));
			}
		}
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.14D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.2D);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZollernSoundEvents.ENTITY_KRULL_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound() {
		return ZollernSoundEvents.ENTITY_KRULL_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZollernSoundEvents.ENTITY_KRULL_DIE;
	}
	
	// When this being kills another, spawn another one, so it seems like the
	// killed entity is "transformed" into one.
	@Override
	public void onKillEntity(EntityLivingBase par1EntityLivingBase) {
		if (!this.world.isRemote) {
			EntityKrull krull = new EntityKrull(this.world);
			krull.setLocationAndAngles(par1EntityLivingBase.posX, par1EntityLivingBase.posY,
					par1EntityLivingBase.posZ, 0, 0);
			if (par1EntityLivingBase instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) par1EntityLivingBase;
				String playerName = player.getDisplayName().getFormattedText();
				krull.setCustomNameTag("Shadow " + playerName);
			}
			this.world.spawnEntity(krull);
		}
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}
	
	// This just cancels fall damage. It's an interdimensional being, so gravity
	// doesn't really apply to it.
	@Override
	public void fall(float par1, float par2) {
	}
	
}