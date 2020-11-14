package net.curseforge.shinobicraft.procedures;

import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class BuyWindStyleProcedure extends ShinobicraftModElements.ModElement {
	public BuyWindStyleProcedure(ShinobicraftModElements instance) {
		super(instance, 314);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BuyWindStyle!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ShinobicraftModVariables.PlayerVariables())).sp) >= 10)
				&& (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).wind) == (false)))) {
			{
				double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ShinobicraftModVariables.PlayerVariables())).sp) - 10);
				entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.wind = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
