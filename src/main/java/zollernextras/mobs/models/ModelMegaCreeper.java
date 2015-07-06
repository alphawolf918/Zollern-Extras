package zollernextras.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMegaCreeper extends ModelBase {
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer head3;
	ModelRenderer head2;
	ModelRenderer arm1;
	ModelRenderer arm2;
	
	public ModelMegaCreeper() {
		textureWidth = 64;
		textureHeight = 32;
		
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 6F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 22, 13);
		body.addBox(-4F, 0F, -2F, 8, 13, 6);
		body.setRotationPoint(0F, 5F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 16);
		leg3.addBox(-2F, 0F, -2F, 4, 6, 5);
		leg3.setRotationPoint(-2F, 18F, -4F);
		leg3.setTextureSize(64, 32);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 16);
		leg4.addBox(-2F, 0F, -2F, 4, 6, 5);
		leg4.setRotationPoint(2F, 18F, -4F);
		leg4.setTextureSize(64, 32);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		leg1 = new ModelRenderer(this, 0, 16);
		leg1.addBox(0F, 0F, -2F, 4, 6, 4);
		leg1.setRotationPoint(-4F, 18F, 4F);
		leg1.setTextureSize(64, 32);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 16);
		leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg2.setRotationPoint(2F, 18F, 4F);
		leg2.setTextureSize(64, 32);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		head3 = new ModelRenderer(this, 0, 0);
		head3.addBox(0F, 0F, 0F, 8, 8, 8);
		head3.setRotationPoint(4F, -2F, -4F);
		head3.setTextureSize(64, 32);
		head3.mirror = true;
		setRotation(head3, 0F, 0F, 0F);
		head2 = new ModelRenderer(this, 0, 0);
		head2.addBox(0F, 0F, 0F, 8, 8, 8);
		head2.setRotationPoint(-12F, -2F, -4F);
		head2.setTextureSize(64, 32);
		head2.mirror = true;
		setRotation(head2, 0F, 0F, 0F);
		arm1 = new ModelRenderer(this, 5, 5);
		arm1.addBox(0F, 0F, 0F, 3, 10, 3);
		arm1.setRotationPoint(-7F, 7F, 0F);
		arm1.setTextureSize(64, 32);
		arm1.mirror = true;
		setRotation(arm1, 0F, 0F, 0F);
		arm2 = new ModelRenderer(this, 5, 5);
		arm2.addBox(0F, 0F, 0F, 3, 10, 3);
		arm2.setRotationPoint(4F, 7F, 0F);
		arm2.setTextureSize(64, 32);
		arm2.mirror = true;
		setRotation(arm2, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		head.render(par7);
		body.render(par7);
		leg3.render(par7);
		leg4.render(par7);
		leg1.render(par7);
		leg2.render(par7);
		head3.render(par7);
		head2.render(par7);
		arm1.render(par7);
		arm2.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6, Entity par7Entity) {
		float f6 = MathHelper.sin(this.onGround * (float) Math.PI);
		float f7 = MathHelper.sin((1.0F - (1.0F - this.onGround)
				* (1.0F - this.onGround))
				* (float) Math.PI);
		this.arm2.rotateAngleZ = 0.0F;
		this.arm1.rotateAngleZ = 0.0F;
		this.arm2.rotateAngleY = -(0.1F - f6 * 0.6F);
		this.arm1.rotateAngleY = 0.1F - f6 * 0.6F;
		this.arm2.rotateAngleX = -((float) Math.PI / 2F);
		this.arm1.rotateAngleX = -((float) Math.PI / 2F);
		this.arm2.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
		this.arm1.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
		this.arm2.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
		this.arm1.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
		this.arm2.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
		this.arm1.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
		this.head.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.head2.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head2.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.head3.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head3.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F
				+ (float) Math.PI)
				* 1.4F * par2;
		this.leg3.rotateAngleX = MathHelper.cos(par1 * 0.6662F
				+ (float) Math.PI)
				* 1.4F * par2;
		this.leg4.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	}
	
}
