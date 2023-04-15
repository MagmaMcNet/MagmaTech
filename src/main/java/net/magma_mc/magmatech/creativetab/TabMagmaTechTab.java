
package net.magma_mc.magmatech.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.magma_mc.magmatech.block.BlockCoalGeneratorMk1;
import net.magma_mc.magmatech.ElementsMagmaTechMod;

@ElementsMagmaTechMod.ModElement.Tag
public class TabMagmaTechTab extends ElementsMagmaTechMod.ModElement {
	public TabMagmaTechTab(ElementsMagmaTechMod instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabmagma_tech_tab") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(BlockCoalGeneratorMk1.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
