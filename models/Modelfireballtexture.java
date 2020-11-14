// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelfireballtexture extends ModelBase {
	private final ModelRenderer group;

	public Modelfireballtexture() {
		textureWidth = 32;
		textureHeight = 32;

		group = new ModelRenderer(this);
		group.setRotationPoint(-7.0F, 16.0F, -5.0F);
		setRotationAngle(group, 1.5708F, 0.0F, 0.0F);
		group.cubeList.add(new ModelBox(group, 0, 0, -2.4783F, -3.7039F, 5.3103F, 17, 17, 6, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -4.4783F, -4.9539F, -7.6897F, 22, 17, 15, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -4.4783F, 12.2961F, -7.6897F, 22, 3, 15, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 5.7467F, -5.7039F, 7.4631F, 11, 21, 0, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -4.2533F, -5.7039F, 7.4631F, 10, 21, 0, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 17.7717F, -5.4539F, -7.6897F, 0, 15, 15, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 17.7717F, 9.2961F, -7.6897F, 0, 6, 15, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -0.4783F, -1.7039F, 9.3103F, 13, 13, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 0.5217F, -0.4539F, 11.3103F, 11, 11, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 1.5217F, 0.5461F, 14.0603F, 9, 9, 6, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 2.2717F, 1.5461F, 18.0603F, 7, 7, 6, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 3.8217F, 2.2961F, 22.5603F, 4, 5, 6, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -3.4783F, -4.7039F, -11.6897F, 20, 19, 6, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -1.4783F, -2.7039F, -15.6897F, 16, 15, 6, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -4.2533F, 15.5461F, -7.4397F, 10, 1, 1, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -4.2533F, 15.5461F, -5.6897F, 10, 1, 6, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -4.2533F, 15.5461F, 0.3103F, 10, 1, 6, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 6.5217F, 15.5461F, 0.3103F, 11, 1, 6, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 6.5217F, 15.5461F, -5.6897F, 11, 1, 6, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 6.0F, 14.5461F, -11.6897F, 10, 0, 3, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 6.0F, 12.5461F, -15.6897F, 8, 0, 4, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -3.0F, 14.5461F, -11.6897F, 9, 0, 3, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, 6.5217F, 15.5461F, -7.4397F, 11, 1, 1, 0.0F, false));
		group.cubeList.add(new ModelBox(group, 0, 0, -2.4783F, -3.7039F, 11.4631F, 17, 17, 0, 0.0F, false));
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