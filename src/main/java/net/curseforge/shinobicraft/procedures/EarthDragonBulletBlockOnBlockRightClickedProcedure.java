package net.curseforge.shinobicraft.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.item.EarthShardBkItem;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Random;
import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class EarthDragonBulletBlockOnBlockRightClickedProcedure extends ShinobicraftModElements.ModElement {
	public EarthDragonBulletBlockOnBlockRightClickedProcedure(ShinobicraftModElements instance) {
		super(instance, 135);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EarthDragonBulletBlockOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure EarthDragonBulletBlockOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
			EarthShardBkItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 1, (float) 2, (int) 1);
		}
	}
}
