package net.curseforge.shinobicraft.procedures;

import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class Cb3DisplayOverlayIngameProcedure extends ShinobicraftModElements.ModElement {
	public Cb3DisplayOverlayIngameProcedure(ShinobicraftModElements instance) {
		super(instance, 214);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Cb3DisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) >= (((entity
						.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).maxchakra) * 0.1));
	}
}
