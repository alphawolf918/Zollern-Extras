package zollernextras.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelHelleton extends ModelBase {
	
	public ModelRenderer bipedHead;
	public ModelRenderer bipedLeftArm;
	public ModelRenderer bipedRightLeg;
	public ModelRenderer bipedNeck;
	public ModelRenderer bipedBody;
	public ModelRenderer bipedRightArm;
	public ModelRenderer bipedLeftLeg;
	public ModelRenderer bipedSubNeck;
	
	public int heldItemLeft;
	public int heldItemRight;
	public boolean isSneak;
	public boolean aimedBow;
	
	public ModelHelleton() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.bipedNeck = new ModelRenderer(this, 0, 0);
		this.bipedNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedNeck.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 40, 16);
		this.bipedRightArm.mirror = true;
		this.bipedRightArm.setRotationPoint(5.3F, 2.0F, -0.0F);
		this.bipedRightArm.addBox(-1.0F, -2.0F, -1.0F, 3, 12, 2, 0.0F);
		this.setRotateAngle(bipedRightArm, -1.5707963267948966F,
				0.10000736613927509F, -0.10000736613927509F);
		this.bipedLeftArm = new ModelRenderer(this, 40, 16);
		this.bipedLeftArm.setRotationPoint(-6.0F, 2.0F, 0.0F);
		this.bipedLeftArm.addBox(-1.0F, -2.0F, -1.0F, 3, 12, 2, 0.0F);
		this.setRotateAngle(bipedLeftArm, -1.5707963267948966F,
				-0.10000736613927509F, 0.10000736613927509F);
		this.bipedBody = new ModelRenderer(this, 16, 16);
		this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
		this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
		this.bipedLeftLeg.setRotationPoint(-3.0F, 12.0F, 0.1F);
		this.bipedLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 3, 12, 2, 0.0F);
		this.bipedSubNeck = new ModelRenderer(this, 24, 0);
		this.bipedSubNeck.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedSubNeck.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, 0.0F);
		this.bipedRightLeg = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg.mirror = true;
		this.bipedRightLeg.setRotationPoint(3.0F, 12.0F, 0.1F);
		this.bipedRightLeg.addBox(-1.0F, 0.0F, -1.0F, 3, 12, 2, 0.0F);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		this.bipedNeck.render(f5);
		this.bipedRightArm.render(f5);
		this.bipedLeftArm.render(f5);
		GL11.glPushMatrix();
		GL11.glTranslatef(this.bipedBody.offsetX, this.bipedBody.offsetY,
				this.bipedBody.offsetZ);
		GL11.glTranslatef(this.bipedBody.rotationPointX * f5,
				this.bipedBody.rotationPointY * f5,
				this.bipedBody.rotationPointZ * f5);
		GL11.glScaled(1.1D, 1.0D, 1.0D);
		GL11.glTranslatef(-this.bipedBody.offsetX, -this.bipedBody.offsetY,
				-this.bipedBody.offsetZ);
		GL11.glTranslatef(-this.bipedBody.rotationPointX * f5,
				-this.bipedBody.rotationPointY * f5,
				-this.bipedBody.rotationPointZ * f5);
		this.bipedBody.render(f5);
		GL11.glPopMatrix();
		this.bipedLeftLeg.render(f5);
		this.bipedSubNeck.render(f5);
		this.bipedRightLeg.render(f5);
		this.bipedHead.render(f5);
	}
	
	@Override
	public void setLivingAnimations(EntityLivingBase p_78086_1_,
			float p_78086_2_, float p_78086_3_, float p_78086_4_) {
		this.aimedBow = true;
		super.setLivingAnimations(p_78086_1_, p_78086_2_, p_78086_3_,
				p_78086_4_);
	}
	
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float p_78087_1_, float p_78087_2_,
			float p_78087_3_, float p_78087_4_, float p_78087_5_,
			float p_78087_6_, Entity p_78087_7_) {
		this.bipedHead.rotateAngleY = p_78087_4_ / (180F / (float) Math.PI);
		this.bipedHead.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
		this.bipedNeck.rotateAngleY = this.bipedHead.rotateAngleY;
		this.bipedNeck.rotateAngleX = this.bipedHead.rotateAngleX;
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
			this.bipedNeck.rotationPointY = 1.0F;
		} else {
			this.bipedBody.rotateAngleX = 0.0F;
			this.bipedRightLeg.rotationPointZ = 0.1F;
			this.bipedLeftLeg.rotationPointZ = 0.1F;
			this.bipedRightLeg.rotationPointY = 12.0F;
			this.bipedLeftLeg.rotationPointY = 12.0F;
			this.bipedHead.rotationPointY = 0.0F;
			this.bipedNeck.rotationPointY = 0.0F;
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
