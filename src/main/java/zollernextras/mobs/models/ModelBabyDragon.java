package zollernextras.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBabyDragon extends ModelBase {
	
	ModelRenderer wingbase2;
	ModelRenderer wingbase1;
	ModelRenderer neck1;
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer neck2;
	ModelRenderer nose;
	ModelRenderer tailbase1;
	ModelRenderer tailbase2;
	ModelRenderer tailbase3;
	ModelRenderer tailbase4;
	ModelRenderer tailfin1;
	ModelRenderer tailfin2;
	ModelRenderer wingbase21;
	ModelRenderer wingbase22;
	
	public ModelBabyDragon() {
		textureWidth = 178;
		textureHeight = 97;
		
		wingbase2 = new ModelRenderer(this, 4, 3);
		wingbase2.addBox(0F, 0F, 0F, 1, 2, 5);
		wingbase2.setRotationPoint(4.2F, 9F, 2F);
		wingbase2.setTextureSize(256, 256);
		wingbase2.mirror = true;
		setRotation(wingbase2, 0F, 0F, 0F);
		wingbase1 = new ModelRenderer(this, 4, 4);
		wingbase1.addBox(0F, 0F, 0F, 1, 2, 5);
		wingbase1.setRotationPoint(-4.866667F, 9F, 2F);
		wingbase1.setTextureSize(256, 256);
		wingbase1.mirror = true;
		setRotation(wingbase1, 0F, 0F, 0F);
		neck1 = new ModelRenderer(this, 10, 11);
		neck1.addBox(0F, 0F, 0F, 8, 8, 6);
		neck1.setRotationPoint(-3.866667F, -2F, -10F);
		neck1.setTextureSize(256, 256);
		neck1.mirror = true;
		setRotation(neck1, 0F, 0F, 0F);
		head = new ModelRenderer(this, 124, 40);
		head.addBox(-4F, -4F, -8F, 8, 8, 8);
		head.setRotationPoint(0F, -1F, -9F);
		head.setTextureSize(256, 256);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 28, 14);
		body.addBox(-5F, -10F, -7F, 10, 16, 8);
		body.setRotationPoint(0F, 11F, 3F);
		body.setTextureSize(256, 256);
		body.mirror = true;
		setRotation(body, 1.570796F, 0F, 0F);
		leg1 = new ModelRenderer(this, 0, 16);
		leg1.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg1.setRotationPoint(-3F, 18F, 7F);
		leg1.setTextureSize(256, 256);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 16);
		leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg2.setRotationPoint(3F, 18F, 7F);
		leg2.setTextureSize(256, 256);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 16);
		leg3.addBox(-2F, 18F, -2F, 4, 6, 4);
		leg3.setRotationPoint(-3F, 0F, -5F);
		leg3.setTextureSize(256, 256);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 16);
		leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg4.setRotationPoint(3F, 18F, -5F);
		leg4.setTextureSize(256, 256);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		neck2 = new ModelRenderer(this, 17, 0);
		neck2.addBox(0F, 0F, 0F, 8, 8, 6);
		neck2.setRotationPoint(-3.866667F, 2F, -7F);
		neck2.setTextureSize(256, 256);
		neck2.mirror = true;
		setRotation(neck2, 0F, 0F, 0F);
		nose = new ModelRenderer(this, 15, 0);
		nose.addBox(0F, 0F, 0F, 8, 4, 9);
		nose.setRotationPoint(-3.866667F, -1F, -23F);
		nose.setTextureSize(256, 256);
		nose.mirror = true;
		setRotation(nose, 0F, 0F, 0F);
		tailbase1 = new ModelRenderer(this, 28, 17);
		tailbase1.addBox(0F, 0F, 0F, 8, 14, 7);
		tailbase1.setRotationPoint(-3.866667F, 18F, 0F);
		tailbase1.setTextureSize(256, 256);
		tailbase1.mirror = true;
		setRotation(tailbase1, 1.570796F, 0F, 0F);
		tailbase2 = new ModelRenderer(this, 28, 17);
		tailbase2.addBox(0F, 0F, 0F, 6, 5, 7);
		tailbase2.setRotationPoint(-2.866667F, 16.66667F, 14F);
		tailbase2.setTextureSize(256, 256);
		tailbase2.mirror = true;
		setRotation(tailbase2, 1.570796F, 0F, 0F);
		tailbase3 = new ModelRenderer(this, 28, 17);
		tailbase3.addBox(0F, 0F, 0F, 6, 5, 7);
		tailbase3.setRotationPoint(-2.866667F, 15F, 17F);
		tailbase3.setTextureSize(256, 256);
		tailbase3.mirror = true;
		setRotation(tailbase3, 1.570796F, 0F, 0F);
		tailbase4 = new ModelRenderer(this, 28, 17);
		tailbase4.addBox(0F, 0F, 0F, 6, 5, 7);
		tailbase4.setRotationPoint(-2.866667F, 14F, 21F);
		tailbase4.setTextureSize(256, 256);
		tailbase4.mirror = true;
		setRotation(tailbase4, 1.570796F, 0F, 0F);
		tailfin1 = new ModelRenderer(this, 125, 89);
		tailfin1.addBox(0F, 0F, 1F, 2, 5, 8);
		tailfin1.setRotationPoint(-2.9F, 15F, 25F);
		tailfin1.setTextureSize(256, 256);
		tailfin1.mirror = true;
		setRotation(tailfin1, 1.850049F, -0.3141593F, 0F);
		tailfin2 = new ModelRenderer(this, 125, 89);
		tailfin2.addBox(0F, 0F, 0F, 2, 5, 8);
		tailfin2.setRotationPoint(0.9F, 14F, 25F);
		tailfin2.setTextureSize(256, 256);
		tailfin2.mirror = true;
		setRotation(tailfin2, 1.850049F, 0.3141593F, 0F);
		wingbase21 = new ModelRenderer(this, 4, 3);
		wingbase21.addBox(0F, 0F, 0F, 1, 2, 5);
		wingbase21.setRotationPoint(5.2F, 8F, 2F);
		wingbase21.setTextureSize(256, 256);
		wingbase21.mirror = true;
		setRotation(wingbase21, 0F, 0F, 0F);
		wingbase22 = new ModelRenderer(this, 4, 3);
		wingbase22.addBox(0F, 0F, 0F, 1, 2, 5);
		wingbase22.setRotationPoint(-5.9F, 8F, 2F);
		wingbase22.setTextureSize(256, 256);
		wingbase22.mirror = true;
		setRotation(wingbase22, 0F, 0F, 0F);
		// head.addChild(nose);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par7, par6, par7, par1Entity);
		wingbase2.render(par7);
		wingbase1.render(par7);
		neck1.render(par7);
		head.render(par7);
		body.render(par7);
		leg1.render(par7);
		leg2.render(par7);
		leg3.render(par7);
		leg4.render(par7);
		neck2.render(par7);
		nose.render(par7);
		tailbase1.render(par7);
		tailbase2.render(par7);
		tailbase3.render(par7);
		tailbase4.render(par7);
		tailfin1.render(par7);
		tailfin2.render(par7);
		wingbase21.render(par7);
		wingbase22.render(par7);
	}
	
	@Override
	public void setRotationAngles(float p_78087_1_, float p_78087_2_,
			float p_78087_3_, float p_78087_4_, float p_78087_5_,
			float p_78087_6_, Entity p_78087_7_) {
		float f6 = (180F / (float) Math.PI);
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		this.leg1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F
				* p_78087_2_;
		this.leg2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F
				+ (float) Math.PI)
				* 1.4F * p_78087_2_;
		this.leg3.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F
				+ (float) Math.PI)
				* 1.4F * p_78087_2_;
		this.leg4.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F
				* p_78087_2_;
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
