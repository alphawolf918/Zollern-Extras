package zollernextras.mobs.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFish extends ModelBase {
	ModelRenderer Head;
	ModelRenderer Body;
	ModelRenderer Fin1;
	ModelRenderer Fin2;
	
	public ModelFish() {
		textureWidth = 64;
		textureHeight = 32;
		
		Head = new ModelRenderer(this, 0, 0);
		Head.addBox(0F, 0F, 0F, 2, 2, 2);
		Head.setRotationPoint(1F, 19F, -4F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(0F, 0F, 0F, 4, 3, 6);
		Body.setRotationPoint(0F, 18F, -2F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Fin1 = new ModelRenderer(this, 0, 0);
		Fin1.addBox(0F, 0F, 0F, 1, 2, 3);
		Fin1.setRotationPoint(3F, 18F, 0F);
		Fin1.setTextureSize(64, 32);
		Fin1.mirror = true;
		setRotation(Fin1, 0F, 1F, 0F);
		Fin2 = new ModelRenderer(this, 0, 0);
		Fin2.addBox(0F, 0F, 0F, 1, 2, 3);
		Fin2.setRotationPoint(0F, 18F, -1F);
		Fin2.setTextureSize(64, 32);
		Fin2.mirror = true;
		setRotation(Fin2, 0F, -1F, 0F);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4,
			float par5, float par6, float par7) {
		
		super.render(par1Entity, par2, par3, par4, par5, par6, par7);
		Head.render(par7);
		Body.render(par7);
		Fin1.render(par7);
		Fin2.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}