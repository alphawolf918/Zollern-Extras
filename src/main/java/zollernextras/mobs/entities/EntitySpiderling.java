package zollernextras.mobs.entities;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import zollernextras.blocks.ZollernBlocks;

public class EntitySpiderling extends EntityCaveSpider {
	
	public EntitySpiderling(World par1World) {
		super(par1World);
		this.setSize(this.width / 0.4f, this.height / 0.4f);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(20.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.320000011920929D);
	}
	
	@Override
	protected Entity findPlayerToAttack() {
		double searchRadius = 6.0D;
		return this.worldObj.getClosestVulnerablePlayerToEntity(this,
				searchRadius);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		Random rand = new Random();
		if (rand.nextInt(100) == 5) {
			this.worldObj.setBlock((int) this.posX, (int) this.posY,
					(int) this.posZ - 1, Blocks.web);
		}
		if (this.ticksExisted >= 2000) {
			if (rand.nextInt(1000) <= 5 && !this.isDead) {
				this.worldObj.setBlock((int) this.posX, (int) this.posY,
						(int) this.posZ, ZollernBlocks.spiderlingEgg);
				if (new Random().nextInt(100) <= 50) {
					this.killSpider();
				}
			}
		}
	}
	
	public void killSpider() {
		this.setDead();
		this.ticksExisted = 0;
	}
	
	@Override
	protected float getSoundPitch() {
		return 2.0F;
	}
	
	@Override
	protected float getSoundVolume() {
		return 2.15F;
	}
}