package net.curseforge.shinobicraft.procedures;

import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class ChainKunaiEntityProcedure extends ShinobicraftModElements.ModElement {
	public ChainKunaiEntityProcedure(ShinobicraftModElements instance) {
		super(instance, 318);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ChainKunaiEntity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				System.err.println("Failed to load dependency sourceentity for procedure ChainKunaiEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		entity.setMotion(((entity.getPosX()) - (sourceentity.getPosX())), ((entity.getPosY()) - (sourceentity.getPosY())),
				((entity.getPosZ()) - (sourceentity.getPosZ())));
	}
}
