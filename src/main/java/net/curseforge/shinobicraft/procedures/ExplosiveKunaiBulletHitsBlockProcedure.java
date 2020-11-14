package net.curseforge.shinobicraft.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;

import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class ExplosiveKunaiBulletHitsBlockProcedure extends ShinobicraftModElements.ModElement {
	public ExplosiveKunaiBulletHitsBlockProcedure(ShinobicraftModElements instance) {
		super(instance, 321);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ExplosiveKunaiBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ExplosiveKunaiBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ExplosiveKunaiBulletHitsBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ExplosiveKunaiBulletHitsBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) x, (int) y, (int) z, (float) 2, Explosion.Mode.BREAK);
		}
	}
}
