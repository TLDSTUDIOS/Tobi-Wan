// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelfireballnotexture extends ModelBase {
	private final ModelRenderer group;

	public Modelfireballnotexture() {
		textureWidth = 32;
		textureHeight = 32;

		group = new ModelRenderer(this);
		group.setRotationPoint(-8.0F, 16.0F, -5.0F);
		group.cubeList.add(new ModelBox(group, 0, 0, -0.225F, -0.0139F, 2.8472F, 16, 16, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -0.225F, -0.0139F, 6.8472F, 16, 16, 0, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -2.225F, -2.0139F, -10.1528F, 21, 20, 13, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 8.0F, -2.0139F, 2.8472F, 10, 20, 0, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -2.0F, -2.0139F, 2.8472F, 9, 20, 0, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 18.775F, -2.0139F, -10.1528F, 0, 20, 13, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 1.775F, 1.9861F, 6.8472F, 12, 12, 2, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 2.775F, 3.2361F, 8.8472F, 10, 10, 2, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 3.775F, 4.2361F, 11.5972F, 8, 8, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 4.525F, 5.2361F, 15.5972F, 6, 6, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 6.075F, 5.9861F, 20.0972F, 3, 4, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -1.225F, -1.0139F, -14.1528F, 19, 18, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 0.775F, 0.9861F, -18.1528F, 15, 14, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -2.0F, 18.2361F, -10.1528F, 10, 0, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -2.0F, 18.2361F, -6.1528F, 10, 0, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -2.0F, 18.2361F, -2.1528F, 10, 0, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 8.775F, 18.2361F, -2.1528F, 10, 0, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 8.775F, 18.2361F, -6.1528F, 10, 0, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 8.775F, 18.2361F, -10.1528F, 10, 0, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		group.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}