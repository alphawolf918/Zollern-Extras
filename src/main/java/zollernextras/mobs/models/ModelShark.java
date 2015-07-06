package zollernextras.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShark extends ModelBase {
	ModelRenderer Fin2;
	ModelRenderer Fin1;
	ModelRenderer Tail;
	ModelRenderer Body;
	ModelRenderer Head;
	ModelRenderer Fin3;
	ModelRenderer Fin4;
	ModelRenderer Fin5;
	ModelRenderer Fin6;
	
	public ModelShark() {
		textureWidth = 64;
		textureHeight = 32;
		
		Fin2 = new ModelRenderer(this, 23, 28);
		Fin2.addBox(0F, 0F, 0F, 7, 2, 2);
		Fin2.setRotationPoint(3F, 14F, 20F);
		Fin2.setTextureSize(64, 32);
		Fin2.mirror = true;
		setRotation(Fin2, 0F, 2F, 0F);
		Fin1 = new ModelRenderer(this, 8, 0);
		Fin1.addBox(0F, 0F, 0F, 7, 2, 2);
		Fin1.setRotationPoint(-1F, 15F, 14F);
		Fin1.setTextureSize(64, 32);
		Fin1.mirror = true;
		setRotation(Fin1, 0F, -2F, 0F);
		Tail = new ModelRenderer(this, 14, 14);
		Tail.addBox(0F, 0F, 0F, 6, 4, 7);
		Tail.setRotationPoint(-3F, 14F, 8F);
		Tail.setTextureSize(64, 32);
		Tail.mirror = true;
		setRotation(Tail, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 8, 11);
		Body.addBox(0F, 0F, 0F, 9, 7, 15);
		Body.setRotationPoint(-5F, 13F, -7F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 32, 0);
		Head.addBox(0F, 0F, 0F, 7, 4, 8);
		Head.setRotationPoint(-4F, 15F, -12F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Fin3 = new ModelRenderer(this, 0, 0);
		Fin3.addBox(0F, 0F, 0F, 3, 4, 12);
		Fin3.setRotationPoint(-2F, 10F, -6F);
		Fin3.setTextureSize(64, 32);
		Fin3.mirror = true;
		setRotation(Fin3, 0F, 0F, 0F);
		Fin4 = new ModelRenderer(this, 3, 0);
		Fin4.addBox(0F, 0F, 0F, 11, 1, 6);
		Fin4.setRotationPoint(4F, 15F, -4F);
		Fin4.setTextureSize(64, 32);
		Fin4.mirror = true;
		setRotation(Fin4, 0F, 0F, 0.5F);
		Fin5 = new ModelRenderer(this, 3, 0);
		Fin5.addBox(0F, 0F, 0F, 11, 1, 6);
		Fin5.setRotationPoint(-14F, 20F, -4F);
		Fin5.setTextureSize(64, 32);
		Fin5.mirror = true;
		setRotation(Fin5, 0F, 0F, -0.5F);
		Fin6 = new ModelRenderer(this, 0, 18);
		Fin6.addBox(0F, 0F, 0F, 1, 4, 10);
		Fin6.setRotationPoint(-1F, 10F, -3F);
		Fin6.setTextureSize(64, 32);
		Fin6.mirror = true;
		setRotation(Fin6, 0.6F, 0F, 0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		Fin2.render(par7);
		Fin1.render(par7);
		Tail.render(par7);
		Body.render(par7);
		Head.render(par7);
		Fin3.render(par7);
		Fin4.render(par7);
		Fin5.render(par7);
		Fin6.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}