package net.curseforge.shinobicraft.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.item.FireballsmallentityItem;
import net.curseforge.shinobicraft.item.FireballmediumentityItem;
import net.curseforge.shinobicraft.ShinobicraftModVariables;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Random;
import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class UseJutsuOnKeyReleasedProcedure extends ShinobicraftModElements.ModElement {
	public UseJutsuOnKeyReleasedProcedure(ShinobicraftModElements instance) {
		super(instance, 331);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure UseJutsuOnKeyReleased!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure UseJutsuOnKeyReleased!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getPersistentData().getString("currentjutsu"))).equals("fireball"))) {
			if (((entity.getPersistentData().getDouble("jc")) < 100)) {
				if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
					FireballsmallentityItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 1.5, (float) 4, (int) 2);
				}
				{
					double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) - 10);
					entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.currentchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((((entity.getPersistentData().getDouble("jc")) < 200) && ((entity.getPersistentData().getDouble("jc")) > 100))) {
				if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
					FireballmediumentityItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 1.2, (float) 6.7, (int) 3);
				}
				{
					double _setval = (double) (((entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ShinobicraftModVariables.PlayerVariables())).currentchakra) - 20);
					entity.getCapability(ShinobicraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.currentchakra = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			entity.getPersistentData().putString("currentjutsu", "");
			entity.getPersistentData().putBoolean("jcharge", (false));
		}
		if ((((((entity.getPersistentData().getString("currentjutsu"))).equals("vacuumpush"))
				|| (((entity.getPersistentData().getString("currentjutsu"))).equals("dragonflame")))
				|| (((entity.getPersistentData().getString("currentjutsu"))).equals("ragingwaves")))) {
			entity.getPersistentData().putString("currentjutsu", "");
			entity.getPersistentData().putBoolean("jcharge", (false));
		}
	}
}
