package net.curseforge.shinobicraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;
import java.util.HashMap;

@ShinobicraftModElements.ModElement.Tag
public class RemovefalldamageProcedure extends ShinobicraftModElements.ModElement {
	public RemovefalldamageProcedure(ShinobicraftModElements instance) {
		super(instance, 351);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Removefalldamage!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getBoolean("leapfall")) == (true))) {
			entity.fallDistance = (float) (0);
		}
		if ((((entity.getPersistentData().getBoolean("leapfall")) == (true)) && ((entity instanceof LivingEntity) ? (entity.onGround) : false))) {
			entity.getPersistentData().putBoolean("leapfall", (false));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
