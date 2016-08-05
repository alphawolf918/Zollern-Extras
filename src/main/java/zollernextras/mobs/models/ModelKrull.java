package zollernextras.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelKrull extends ModelBase {
	
	public int heldItemLeft;
	public int heldItemRight;
	public boolean isSneak;
	public boolean aimedBow;
	
	public static ModelRenderer bipedHead;
	public static ModelRenderer bipedBody;
	public static ModelRenderer bipedRightArm;
	public static ModelRenderer bipedLeftArm;
	public static ModelRenderer bipedRightLeg;
	public static ModelRenderer bipedLeftLeg;
	
	public ModelKrull() {
		textureWidth = 64;
		textureHeight = 64;
		bipedHead = new ModelRenderer(this, 0, 0);
		bipedHead.addBox(-4F, -8F, -4F, 8, 9, 8);
		bipedHead.setRotationPoint(0F, -1F, 0F);
		bipedHead.setTextureSize(64, 64);
		bipedHead.mirror = true;
		setRotation(bipedHead, 0F, 0F, 0F);
		bipedBody = new ModelRenderer(this, 16, 16);
		bipedBody.addBox(-4F, 0F, -2F, 8, 12, 4);
		bipedBody.setRotationPoint(0F, 0F, 0F);
		bipedBody.setTextureSize(64, 64);
		bipedBody.mirror = true;
		setRotation(bipedBody, 0F, 0F, 0F);
		bipedRightArm = new ModelRenderer(this, 33, 16);
		bipedRightArm.addBox(-3F, -2F, -2F, 5, 12, 4);
		bipedRightArm.setRotationPoint(-6F, 2F, 0F);
		bipedRightArm.setTextureSize(64, 64);
		bipedRightArm.mirror = true;
		setRotation(bipedRightArm, -1.53589F, 0F, 0F);
		bipedLeftArm = new ModelRenderer(this, 40, 16);
		bipedLeftArm.addBox(-1F, -2F, -2F, 5, 12, 4);
		bipedLeftArm.setRotationPoint(5F, 2F, 0F);
		bipedLeftArm.setTextureSize(64, 64);
		bipedLeftArm.mirror = true;
		setRotation(bipedLeftArm, -1.53589F, 0F, 0F);
		bipedRightLeg = new ModelRenderer(this, 0, 16);
		bipedRightLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
		bipedRightLeg.setRotationPoint(-2F, 12F, 0F);
		bipedRightLeg.setTextureSize(64, 64);
		bipedRightLeg.mirror = true;
		setRotation(bipedRightLeg, 0F, 0F, 0F);
		bipedLeftLeg = new ModelRenderer(this, 0, 16);
		bipedLeftLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
		bipedLeftLeg.setRotationPoint(2F, 12F, 0F);
		bipedLeftLeg.setTextureSize(64, 64);
		bipedLeftLeg.mirror = true;
		setRotation(bipedLeftLeg, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		bipedHead.render(par7);
		bipedBody.render(par7);
		bipedHead.render(par7);
		bipedBody.render(par7);
		bipedRightArm.render(par7);
		bipedLeftArm.render(par7);
		bipedRightLeg.render(par7);
		bipedLeftLeg.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float p_78087_1_, float p_78087_2_,
			float p_78087_3_, float p_78087_4_, float p_78087_5_,
			float p_78087_6_, Entity p_78087_7_) {
		this.bipedHead.rotateAngleY = p_78087_4_ / (180F / (float) Math.PI);
		this.bipedHead.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.bipedRightArm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F
				+ (float) Math.PI)
				* 2.0F * p_78087_2_ * 0.5F;
		this.bipedLeftArm.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F)
				* 2.0F * p_78087_2_ * 0.5F;
		this.bipedRightArm.rotateAngleZ = 0.0F;
		this.bipedLeftArm.rotateAngleZ = 0.0F;
		this.bipedRightLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F)
				* 1.4F * p_78087_2_;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F
				+ (float) Math.PI)
				* 1.4F * p_78087_2_;
		this.bipedRightLeg.rotateAngleY = 0.0F;
		this.bipedLeftLeg.rotateAngleY = 0.0F;
		
		if (this.isRiding) {
			this.bipedRightArm.rotateAngleX += -((float) Math.PI / 5F);
			this.bipedLeftArm.rotateAngleX += -((float) Math.PI / 5F);
			this.bipedRightLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			this.bipedLeftLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			this.bipedRightLeg.rotateAngleY = (float) Math.PI / 10F;
			this.bipedLeftLeg.rotateAngleY = -((float) Math.PI / 10F);
		}
		
		if (this.heldItemLeft != 0) {
			this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX
					* 0.5F - (float) Math.PI / 10F * this.heldItemLeft;
		}
		
		if (this.heldItemRight != 0) {
			this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX
					* 0.5F - (float) Math.PI / 10F * this.heldItemRight;
		}
		
		this.bipedRightArm.rotateAngleY = 0.0F;
		this.bipedLeftArm.rotateAngleY = 0.0F;
		float f6;
		float f7;
		
		if (this.onGround > -9990.0F) {
			f6 = this.onGround;
			this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper
					.sqrt_float(f6) * (float) Math.PI * 2.0F) * 0.2F;
			this.bipedRightArm.rotationPointZ = MathHelper
					.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotationPointX = -MathHelper
					.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointZ = -MathHelper
					.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointX = MathHelper
					.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
			f6 = 1.0F - this.onGround;
			f6 *= f6;
			f6 *= f6;
			f6 = 1.0F - f6;
			f7 = MathHelper.sin(f6 * (float) Math.PI);
			float f8 = MathHelper.sin(this.onGround * (float) Math.PI)
					* -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
			this.bipedRightArm.rotateAngleX = (float) (this.bipedRightArm.rotateAngleX - (f7 * 1.2D + f8));
			this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
			this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.onGround
					* (float) Math.PI)
					* -0.4F;
		}
		
		if (this.isSneak) {
			this.bipedBody.rotateAngleX = 0.5F;
			this.bipedRightArm.rotateAngleX += 0.4F;
			this.bipedLeftArm.rotateAngleX += 0.4F;
			this.bipedRightLeg.rotationPointZ = 4.0F;
			this.bipedLeftLeg.rotationPointZ = 4.0F;
			this.bipedRightLeg.rotationPointY = 9.0F;
			this.bipedLeftLeg.rotationPointY = 9.0F;
			this.bipedHead.rotationPointY = 1.0F;
		} else {
			this.bipedBody.rotateAngleX = 0.0F;
			this.bipedRightLeg.rotationPointZ = 0.1F;
			this.bipedLeftLeg.rotationPointZ = 0.1F;
			this.bipedRightLeg.rotationPointY = 12.0F;
			this.bipedLeftLeg.rotationPointY = 12.0F;
			this.bipedHead.rotationPointY = 0.0F;
		}
		
		this.bipedRightArm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
		
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
			this.bipedRightArm.rotateAngleZ += MathHelper
					.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
			this.bipedLeftArm.rotateAngleZ -= MathHelper
					.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
			this.bipedRightArm.rotateAngleX += MathHelper
					.sin(p_78087_3_ * 0.067F) * 0.05F;
			this.bipedLeftArm.rotateAngleX -= MathHelper
					.sin(p_78087_3_ * 0.067F) * 0.05F;
		}
	}
	
}
