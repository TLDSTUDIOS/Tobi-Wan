
package net.curseforge.shinobicraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.curseforge.shinobicraft.itemgroup.NincraftTabItemGroup;
import net.curseforge.shinobicraft.ShinobicraftModElements;

@ShinobicraftModElements.ModElement.Tag
public class IronKatanaItem extends ShinobicraftModElements.ModElement {
	@ObjectHolder("shinobicraft:iron_katana")
	public static final Item block = null;
	public IronKatanaItem(ShinobicraftModElements instance) {
		super(instance, 303);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 300;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(NincraftTabItemGroup.tab)) {
		}.setRegistryName("iron_katana"));
	}
}
