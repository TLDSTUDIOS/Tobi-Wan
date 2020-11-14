
package net.curseforge.shinobicraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.curseforge.shinobicraft.itemgroup.NincraftTabItemGroup;
import net.curseforge.shinobicraft.ShinobicraftModElements;

@ShinobicraftModElements.ModElement.Tag
public class KusanagiItem extends ShinobicraftModElements.ModElement {
	@ObjectHolder("shinobicraft:kusanagi")
	public static final Item block = null;
	public KusanagiItem(ShinobicraftModElements instance) {
		super(instance, 304);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1532;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(NincraftTabItemGroup.tab)) {
		}.setRegistryName("kusanagi"));
	}
}
