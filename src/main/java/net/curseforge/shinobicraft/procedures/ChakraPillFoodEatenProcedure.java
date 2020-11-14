package net.curseforge.shinobicraft.procedures;

import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class ChakraPillFoodEatenProcedure extends ShinobicraftModElements.ModElement {
	public ChakraPillFoodEatenProcedure(ShinobicraftModElements instance) {
		super(instance, 149);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ChakraPillFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) + 10);
			entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.currentchakra = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
