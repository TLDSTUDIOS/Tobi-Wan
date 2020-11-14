package net.curseforge.shinobicraft.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.block.Blocks;

import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class FireballJutsuBulletHitsBlockProcedure extends ShinobicraftModElements.ModElement {
	public FireballJutsuBulletHitsBlockProcedure(ShinobicraftModElements instance) {
		super(instance, 110);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure FireballJutsuBulletHitsBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure FireballJutsuBulletHitsBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure FireballJutsuBulletHitsBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure FireballJutsuBulletHitsBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) x, (int) y, (int) z, (float) 1.5, Explosion.Mode.BREAK);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 30, 1, 1, 1, 1);
		}
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 2), (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 2), (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 2)), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 2)), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x - 2), (int) y, (int) (z - 2)), Blocks.FIRE.getDefaultState(), 3);
		world.setBlockState(new BlockPos((int) (x + 2), (int) y, (int) (z + 2)), Blocks.FIRE.getDefaultState(), 3);
	}
}
