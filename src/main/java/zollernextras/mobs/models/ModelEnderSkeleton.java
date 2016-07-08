package zollernextras.mobs.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelEnderSkeleton extends ModelZombie {
	
	/**
	 * Records whether the model should be rendered holding an item in the left
	 * hand, and if that item is a block.
	 */
	public static int heldItemLeft;
	
	/**
	 * Records whether the model should be rendered holding an item in the right
	 * hand, and if that item is a block.
	 */
	public int heldItemRight;
	public boolean isSneak;
	
	/** Records whether the model should be rendered aiming a bow. */
	public boolean aimedBow;
	
	public ModelEnderSkeleton() {
		this(0.0F);
	}
	
	public ModelEnderSkeleton(float par1) {
		super(par1, 0.0F, 64, 32);
		this.bipedRightArm = new ModelRenderer(this, 40, 16);
		this.bipedRightArm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, par1);
		this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.bipedLeftArm = new ModelRenderer(this, 40, 16);
		this.bipedLeftArm.mirror = true;
		this.bipedLeftArm.addBox(-1.0F, -2.0F, -1.0F, 2, 12, 2, par1);
		this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.bipedRightLeg = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, par1);
		this.bipedRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
		this.bipedLeftLeg.mirror = true;
		this.bipedLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, par1);
		this.bipedLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
	}
	
	/**
	 * Used for easily adding entity-dependent animations. The second and third
	 * float params here are the same second and third as in the
	 * setRotationAngles method.
	 */
	@Override
	public void setLivingAnimations(EntityLivingBase par1EntityLivingBase,
			float par2, float par3, float par4) {
		this.aimedBow = true;
		super.setLivingAnimations(par1EntityLivingBase, par2, par3, par4);
	}
	
	/**
	 * Sets the model's various rotation angles. For bipeds, par1 and par2 are
	 * used for animating the movement of arms and legs, where par1 represents
	 * the time(so that arms and legs swing back and forth) and par2 represents
	 * how "far" arms and legs can swing at most.
	 */
	@Override
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, Entity par7Entity) {
		if (this.heldItemRight != 0) {
			this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX
					* 0.5F - (float) Math.PI / 10F * this.heldItemRight;
		}
		float f6;
		float f7;
		
		if (this.aimedBow) {
			f6 = 0.0F;
			f7 = 0.0F;
			this.bipedRightArm.rotateAngleZ = 0.0F;
			this.bipedLeftArm.rotateAngleZ = 0.0F;
			this.bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F)
					+ this.bipedHead.rotateAngleY;
			this.bipedLeftArm.rotateAngleY = 0.1F - f6 * 0.6F
					+ this.bipedHead.rotateAngleY + 0.4F;
			this.bipedRightArm.rotateAngleX = -((float) Math.PI / 2F)
					+ this.bipedHead.rotateAngleX;
			this.bipedLeftArm.rotateAngleX = -((float) Math.PI / 2F)
					+ this.bipedHead.rotateAngleX;
			this.bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
			this.bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
			this.bipedRightArm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
			this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
			this.bipedRightArm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
			this.bipedLeftArm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
		}
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
	}
}