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

import ru.BossWars.main.BossWars;

public class GUI implements Listener{
	public static void OpenGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 9,"Выбор команды");
		
		inv.setItem(3, ItemUtil.create(Material.WOOL, 1, (byte) 14, ChatColor.RED+"Красная команда"));
		inv.setItem(5, ItemUtil.create(Material.WOOL, 1, (byte) 11, ChatColor.BLUE+"Синяя команда"));
		
		p.openInventory(inv);
	}
	@EventHandler
	public void onClick(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(BossWars.players.contains(p)){
			if(e.getBlock().getType()==Material.WOOL){
				e.setCancelled(true);
				OpenGUI(p);
			}
		}
	}
	@EventHandler
	public void onClicks(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(BossWars.players.contains(p)){
			if(e.getCurrentItem().getItemMeta().getDisplayName()=="Выбор команды"){
				e.setCancelled(true);
				OpenGUI(p);
			}
			
		}
	}
	public void onClick(InventoryInteractEvent e){
		Player p = (Player) e.getWhoClicked();
		if(BossWars.players.contains(p)){
			if(p.getInventory().getItemInHand().getType()==Material.WOOL){
				e.setCancelled(true);
				OpenGUI(p);
			}
		}
	}
	@EventHandler
	public void onClick(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase("Выбор команды")){
			e.setCancelled(true);
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Красная команда")){
				if(BossWars.comRed.get(0)==null|| BossWars.comRed.get(1)==null|| BossWars.comRed.get(2)==null|| BossWars.comRed.get(3)==null|| BossWars.comRed.get(4)==null|| BossWars.comRed.get(5)==null)
				{
				if(BossWars.comRed.equals(p))return;
				if(BossWars.comBlue.equals(p)){
					BossWars.comBlue.remove(p);
					BossWars.comBlue.add(null);
					BossWars.comRed.add(p);
					BossWars.comRed.remove(null);return;
				}
				BossWars.comRed.remove(null);
				BossWars.comRed.add(p);
				}
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Синяя команда")){
				if(BossWars.comBlue.get(0)==null|| BossWars.comBlue.get(1)==null|| BossWars.comBlue.get(2)==null|| BossWars.comBlue.get(3)==null|| BossWars.comBlue.get(4)==null|| BossWars.comBlue.get(5)==null)
				{
				if(BossWars.comBlue.equals(p))return;
				if(BossWars.comRed.equals(p)){
					BossWars.comRed.remove(p);
					BossWars.comRed.add(null);
					BossWars.comBlue.add(p);
					BossWars.comBlue.remove(null);return;
				}
				BossWars.comBlue.remove(null);
				BossWars.comBlue.add(p);
				}return;
			}
		}
	}
}
