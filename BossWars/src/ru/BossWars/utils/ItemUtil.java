/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 */
package ru.BossWars.utils;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {
    public static ItemStack create(Material mat, int amount, byte data, String displayName, String label, String label2, String label3, String label4) {
        ItemStack item = new ItemStack(mat, amount, (short)data);
        ItemMeta meta = item.getItemMeta();
        if (displayName != null) {
            meta.setDisplayName(displayName);
        }
        ArrayList<String> lore = new ArrayList<String>();
        if (label != null) {
            lore.add(label);
        }
        if (label2 != null) {
            lore.add(label2);
        }
        if (label3 != null) {
            lore.add(label3);
        }
        if (label4 != null) {
            lore.add(label4);
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack create(Material mat, String displayName) {
        return ItemUtil.create(mat, 1, (byte) 0, displayName, null, null, null, null);
    }

    public static ItemStack create(Material mat, int amount, byte data, String displayName) {
        return ItemUtil.create(mat, amount, data, displayName, null, null, null, null);
    }
}

