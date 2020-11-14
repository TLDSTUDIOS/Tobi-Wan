package net.curseforge.shinobicraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;
import java.util.HashMap;

@ShinobicraftModElements.ModElement.Tag
public class JutsuCompleteResetProcedure extends ShinobicraftModElements.ModElement {
	public JutsuCompleteResetProcedure(ShinobicraftModElements instance) {
		super(instance, 93);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure JutsuCompleteReset!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getBoolean("jutsucomplete")) == (true))) {
			entity.getPersistentData().putString("jkey1", "");
			entity.getPersistentData().putString("jkey2", "");
			entity.getPersistentData().putString("jkey3", "");
			entity.getPersistentData().putString("jkey4", "");
			entity.getPersistentData().putString("jkey5", "");
			entity.getPersistentData().putBoolean("jutsucomplete", (false));
			entity.getPersistentData().putBoolean("jutsustarted", (false));
			entity.getPersistentData().putDouble("jutsutimer", 0);
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
