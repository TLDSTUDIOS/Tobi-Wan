package net.curseforge.shinobicraft.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.curseforge.shinobicraft.item.EarthenFistItem;
import net.curseforge.shinobicraft.ShinobicraftModElements;

import java.util.Map;

@ShinobicraftModElements.ModElement.Tag
public class EarthenFistToolInInventoryTickProcedure extends ShinobicraftModElements.ModElement {
	public EarthenFistToolInInventoryTickProcedure(ShinobicraftModElements instance) {
		super(instance, 124);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EarthenFistToolInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(EarthenFistItem.block, (int) (1)).getItem()))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(EarthenFistItem.block, (int) (1));
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
			}
		}
	}
}
