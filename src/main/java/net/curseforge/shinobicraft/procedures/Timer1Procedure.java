package net.curseforge.shinobicraft.procedures;

import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;
import java.util.HashMap;

@ShinobicraftModElements.ModElement.Tag
public class Timer1Procedure extends ShinobicraftModElements.ModElement {
	public Timer1Procedure(ShinobicraftModElements instance) {
		super(instance, 366);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Timer1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("jutsutimer", ((entity.getPersistentData().getDouble("jutsutimer")) + 1));
		if ((!(((entity.getPersistentData().getString("currentjutsu"))).equals("")))) {
			entity.getPersistentData().putDouble("ptimer", ((entity.getPersistentData().getDouble("ptimer")) + 1));
		}
		if ((((entity.getPersistentData().getDouble("ptimer")) >= 30) && ((entity.getPersistentData().getBoolean("jcharge")) == (false)))) {
			entity.getPersistentData().putDouble("ptimer", 0);
			entity.getPersistentData().putString("currentjutsu", "");
		}
		if (((entity.getPersistentData().getDouble("jutsutimer")) >= 9)) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				WindJutsuCompleteProcedure.executeProcedure($_dependencies);
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				WaterJutsuCompleteProcedure.executeProcedure($_dependencies);
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				EarthJutsuCompleteProcedure.executeProcedure($_dependencies);
			}
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				FireJutsuCompleteProcedure.executeProcedure($_dependencies);
			}
			{
				String _setval = (String) "";
				entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jutsukeys = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.getPersistentData().putDouble("jutsutimer", 0);
		}
	}
}
