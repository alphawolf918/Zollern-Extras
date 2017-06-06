package zollernextras.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * ModelShade - Either Mojang or a mod author Created using Tabula 4.1.1
 */
public class ModelShade extends ModelBase {
	
	public ModelRenderer bipedRightArm;
	public ModelRenderer bipedRightLeg;
	public ModelRenderer bipedLeftLeg;
	public ModelRenderer bipedLeftArm;
	public ModelRenderer bipedBody;
	public ModelRenderer bipedHead;
	public ModelRenderer neck;
	
	public ModelShade() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.neck = new ModelRenderer(this, 0, 19);
		this.neck.setRotationPoint(-1.0F, -4.0F, 0.0F);
		this.neck.addBox(0.0F, 0.0F, 0.0F, 3, 6, 3, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 33, 16);
		this.bipedRightArm.setRotationPoint(-7.0F, 2.0F, 0.0F);
		this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 5, 12, 4, 0.0F);
		this.setRotateAngle(bipedRightArm, -1.5707963267948966F, 0.0F,
				0.10000736613927509F);
		this.bipedRightLeg = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg.setRotationPoint(-3.0F, 12.0F, 1.1F);
		this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.bipedBody = new ModelRenderer(this, 16, 12);
		this.bipedBody.setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 10, 12, 6, 0.0F);
		this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
		this.bipedLeftLeg.setRotationPoint(3.0F, 12.0F, 1.1F);
		this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		this.bipedLeftArm = new ModelRenderer(this, 40, 16);
		this.bipedLeftArm.setRotationPoint(6.0F, 2.0F, -0.0F);
		this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 5, 12, 4, 0.0F);
		this.setRotateAngle(bipedLeftArm, -1.5707963267948966F, 0.0F,
				-0.10000736613927509F);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 9, 8, 0.0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		this.neck.render(f5);
		this.bipedRightArm.render(f5);
		this.bipedRightLeg.render(f5);
		this.bipedBody.render(f5);
		this.bipedLeftLeg.render(f5);
		this.bipedLeftArm.render(f5);
		this.bipedHead.render(f5);
	}
	
	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float p_78087_3_,
			float p_78087_4_, float p_78087_5_, float p_78087_6_,
			Entity p_78087_7_) {
		super.setRotationAngles(par1, par2, p_78087_3_, p_78087_4_, p_78087_5_,
				p_78087_6_, p_78087_7_);
		float f6 = MathHelper.sin(this.onGround * (float) Math.PI);
		float f7 = MathHelper.sin((1.0F - (1.0F - this.onGround)
				* (1.0F - this.onGround))
				* (float) Math.PI);
		this.bipedRightArm.rotateAngleZ = 0.0F;
		this.bipedLeftArm.rotateAngleZ = 0.0F;
		this.bipedRightArm.rotateAngleY = -(0.1F - f6 * 0.6F);
		this.bipedLeftArm.rotateAngleY = 0.1F - f6 * 0.6F;
		this.bipedRightArm.rotateAngleX = -((float) Math.PI / 2F);
		this.bipedLeftArm.rotateAngleX = -((float) Math.PI / 2F);
		this.bipedRightArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
		this.bipedLeftArm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
		this.bipedRightArm.rotateAngleZ += MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(p_78087_3_ * 0.067F) * 0.05F;
		this.bipedRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F
				* par2;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F
				+ (float) Math.PI)
				* 1.4F * par2;
		this.bipedRightLeg.rotateAngleY = 0.0F;
		this.bipedLeftLeg.rotateAngleY = 0.0F;
		if (this.isRiding) {
			this.bipedRightArm.rotateAngleX += -((float) Math.PI / 5F);
			this.bipedLeftArm.rotateAngleX += -((float) Math.PI / 5F);
			this.bipedRightLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			this.bipedLeftLeg.rotateAngleX = -((float) Math.PI * 2F / 5F);
			this.bipedRightLeg.rotateAngleY = ((float) Math.PI / 10F);
			this.bipedLeftLeg.rotateAngleY = -((float) Math.PI / 10F);
		}
		this.bipedBody.rotateAngleX = 0.5F;
		this.bipedRightArm.rotateAngleX += 0.4F;
		this.bipedLeftArm.rotateAngleX += 0.4F;
		this.bipedRightLeg.rotationPointZ = 4.0F;
		this.bipedLeftLeg.rotationPointZ = 4.0F;
		this.bipedRightLeg.rotationPointY = 9.0F;
		this.bipedLeftLeg.rotationPointY = 9.0F;
		this.bipedHead.rotationPointY = 1.0F;
		this.bipedBody.rotateAngleX = 0.0F;
		this.bipedRightLeg.rotationPointZ = 0.1F;
		this.bipedLeftLeg.rotationPointZ = 0.1F;
		this.bipedRightLeg.rotationPointY = 12.0F;
		this.bipedLeftLeg.rotationPointY = 12.0F;
		this.bipedHead.rotationPointY = 0.0F;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F
				* par2;
		this.bipedRightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F
				+ (float) Math.PI)
				* 1.4F * par2;
	}
}