package net.whispwriting.whispsTimTheEnchanterRedux.utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Enchanter {

    private ItemStack item;
    private int level = 10000;
    private Enchantment enchantment;

    public Enchanter(ItemStack item, int level){
        this.item = item;
        if (level > -1)
            this.level = level;

    }

    public ItemStack enchantAll(boolean unsafe){
        if (unsafe){
            for (Enchantment enchantment : Enchantment.values()){
                item.addUnsafeEnchantment(enchantment, level);
            }
            return item;
        }
        return item;
    }
}
