
package net.curseforge.shinobicraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.curseforge.shinobicraft.item.BlankScrollItem;
import net.curseforge.shinobicraft.ShinobicraftModElements;

@ShinobicraftModElements.ModElement.Tag
public class NincraftTabItemGroup extends ShinobicraftModElements.ModElement {
	public NincraftTabItemGroup(ShinobicraftModElements instance) {
		super(instance, 86);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnincraft_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlankScrollItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
