/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Material
 *  org.bukkit.block.Block
 *  org.bukkit.entity.HumanEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.BlockPlaceEvent
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.event.inventory.InventoryInteractEvent
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.InventoryHolder
 *  org.bukkit.inventory.InventoryView
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 *  org.bukkit.inventory.meta.ItemMeta
 */
package ru.BossWars.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import ru.BossWars.main.BossWars;
import ru.BossWars.utils.ItemUtil;

public class GUI
implements Listener {
    public static void OpenGUI(Player p) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)null, (int)9, (String)"\u0412\u044b\u0431\u043e\u0440 \u043a\u043e\u043c\u0430\u043d\u0434\u044b");
        inv.setItem(3, ItemUtil.create(Material.WOOL, 1, (byte) 14, (Object)ChatColor.RED + "\u041a\u0440\u0430\u0441\u043d\u0430\u044f \u043a\u043e\u043c\u0430\u043d\u0434\u0430"));
        inv.setItem(5, ItemUtil.create(Material.WOOL, 1, (byte) 11, (Object)ChatColor.BLUE + "\u0421\u0438\u043d\u044f\u044f \u043a\u043e\u043c\u0430\u043d\u0434\u0430"));
        p.openInventory(inv);
    }

    @EventHandler
    public void onClick(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (BossWars.players.contains((Object)p) && e.getBlock().getType() == Material.WOOL) {
            e.setCancelled(true);
            GUI.OpenGUI(p);
        }
    }

    @EventHandler
    public void onClicks(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if (BossWars.players.contains((Object)p) && e.getCurrentItem().getItemMeta().getDisplayName() == "\u0412\u044b\u0431\u043e\u0440 \u043a\u043e\u043c\u0430\u043d\u0434\u044b") {
            e.setCancelled(true);
            GUI.OpenGUI(p);
        }
    }

    public void onClick(InventoryInteractEvent e) {
        Player p = (Player)e.getWhoClicked();
        if (BossWars.players.contains((Object)p) && p.getInventory().getItemInHand().getType() == Material.WOOL) {
            e.setCancelled(true);
            GUI.OpenGUI(p);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase("\u0412\u044b\u0431\u043e\u0440 \u043a\u043e\u043c\u0430\u043d\u0434\u044b")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u041a\u0440\u0430\u0441\u043d\u0430\u044f \u043a\u043e\u043c\u0430\u043d\u0434\u0430")) {
                if (BossWars.comRed.get(0) == null || BossWars.comRed.get(1) == null || BossWars.comRed.get(2) == null || BossWars.comRed.get(3) == null || BossWars.comRed.get(4) == null || BossWars.comRed.get(5) == null) {
                    if (BossWars.comRed.equals((Object)p)) {
                        return;
                    }
                    if (BossWars.comBlue.equals((Object)p)) {
                        BossWars.comBlue.remove((Object)p);
                        BossWars.comBlue.add(null);
                        BossWars.comRed.add(p);
                        BossWars.comRed.remove(null);
                        return;
                    }
                    BossWars.comRed.remove(null);
                    BossWars.comRed.add(p);
                }
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("\u0421\u0438\u043d\u044f\u044f \u043a\u043e\u043c\u0430\u043d\u0434\u0430")) {
                if (BossWars.comBlue.get(0) == null || BossWars.comBlue.get(1) == null || BossWars.comBlue.get(2) == null || BossWars.comBlue.get(3) == null || BossWars.comBlue.get(4) == null || BossWars.comBlue.get(5) == null) {
                    if (BossWars.comBlue.equals((Object)p)) {
                        return;
                    }
                    if (BossWars.comRed.equals((Object)p)) {
                        BossWars.comRed.remove((Object)p);
                        BossWars.comRed.add(null);
                        BossWars.comBlue.add(p);
                        BossWars.comBlue.remove(null);
                        return;
                    }
                    BossWars.comBlue.remove(null);
                    BossWars.comBlue.add(p);
                }
                return;
            }
        }
    }
}

