package net.curseforge.shinobicraft.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class EarthspikeEntityCollidesInTheBlockProcedure extends ShinobicraftModElements.ModElement {
	public EarthspikeEntityCollidesInTheBlockProcedure(ShinobicraftModElements instance) {
		super(instance, 354);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EarthspikeEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.CACTUS, (float) 1);
		entity.setMotion(0, (entity.getMotion().getY()), 0);
	}
}
