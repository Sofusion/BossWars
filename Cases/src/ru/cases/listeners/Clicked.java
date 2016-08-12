/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.configuration.file.FileConfiguration
 *  org.bukkit.entity.HumanEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.Listener
 *  org.bukkit.event.block.BlockBreakEvent
 *  org.bukkit.event.block.BlockPlaceEvent
 *  org.bukkit.event.inventory.InventoryClickEvent
 *  org.bukkit.event.inventory.InventoryCloseEvent
 *  org.bukkit.event.player.PlayerInteractEvent
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 *  org.bukkit.material.MaterialData
 */
package ru.cases.listeners;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import ru.cases.main.Main;
import ru.cases.utils.GUI;
import ru.cases.utils.ItemUtil;
import ru.cases.utils.Key;

public class Clicked implements Listener {
    private Main plugin;

    public Clicked(Main plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();
        String s = null;
        List<String> list = this.plugin.getConfig().getStringList("Cases.names");
        int i = 0;
        while (i < list.size()) {
            if (b.getLocation().getWorld().getName().equals(this.plugin.getConfig().getString("Cases." + (String)list.get(i) + ".location.world", null)) && b.getLocation().getX() == this.plugin.getConfig().getDouble("Cases." + (String)list.get(i) + ".location.x", 0.0) && b.getLocation().getY() == this.plugin.getConfig().getDouble("Cases." + (String)list.get(i) + ".location.y", 0.0) && b.getLocation().getZ() == this.plugin.getConfig().getDouble("Cases." + (String)list.get(i) + ".location.z", 0.0)) {
                s = list.get(i);
            }
            ++i;
        }
        if (s == null) {
            return;
        }
        e.setCancelled(true);
        if (this.plugin.getConfig().getInt(String.valueOf(p.getName()) + "." + s, 0) == 0) {
            if (b.getTypeId() != this.plugin.getConfig().getInt("ID_CASE", 120)) {
                return;
            }
            GUI gui = new GUI(27, s);
            List<String> pr = this.plugin.getConfig().getStringList("Cases." + s + ".prises");
            List<String> names =this.plugin.getConfig().getStringList("Cases." + s + ".prises.names");
            List<Integer> amounts = this.plugin.getConfig().getIntegerList("Cases." + s + ".prises.amounts");
            
            int i2 = 0;
            while (i2 < pr.size()) {
                gui.addItem(ItemUtil.create(Material.getMaterial(pr.get(i2)), (int)(amounts.get(i2)), (byte)0, names.get(i2)));
                ++i2;
            }
            gui.OpenGUI(e.getPlayer());
        }
        if (this.plugin.getConfig().getInt(String.valueOf(p.getName()) + "." + s, 0) > 0) {
            if (b.getType().getId() != this.plugin.getConfig().getInt("ID_CASE", 120)) {
                return;
            }
            GUI gui = new GUI(45, s);
            ItemStack green = new ItemStack(Material.WOOL, 1, (byte)5);
            ItemStack red = new ItemStack(Material.WOOL, 1, (byte)14);
            green.getItemMeta().setDisplayName("Открыть кейс!");
            red.getItemMeta().setDisplayName("Не открывать кейс");
            gui.setItem(red, 14);
            gui.setItem(red, 15);
            gui.setItem(red, 16);
            gui.setItem(red, 23);
            gui.setItem(red, 24);
            gui.setItem(red, 25);
            gui.setItem(red, 32);
            gui.setItem(red, 33);
            gui.setItem(red, 34);
            gui.setItem(green, 10);
            gui.setItem(green, 11);
            gui.setItem(green, 12);
            gui.setItem(green, 19);
            gui.setItem(green, 20);
            gui.setItem(green, 21);
            gui.setItem(green, 28);
            gui.setItem(green, 29);
            gui.setItem(green, 30);
            gui.OpenGUI(p);
            Main.invs.add(gui.getInvertory());
            this.plugin.getConfig().set(String.valueOf(p.getName()) + "." + s, (Object)(this.plugin.getConfig().getInt(String.valueOf(p.getName()) + "." + s) - 1));
        }
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (!Main.entered) {
            return;
        }
        if (Main.setter != e.getPlayer()) {
            return;
        }
        Player p = e.getPlayer();
        
        Block b = e.getBlockPlaced();
        if (b.getTypeId() != this.plugin.getConfig().getInt("ID_CASE", 120)) {
            return;
        }
        this.plugin.getConfig().set("Cases." + Main.nameOfCase + ".location.world", (Object)b.getLocation().getWorld().getName());
        this.plugin.getConfig().set("Cases." + Main.nameOfCase + ".location.x", (Object)b.getLocation().getX());
        this.plugin.getConfig().set("Cases." + Main.nameOfCase + ".location.y", (Object)b.getLocation().getY());
        this.plugin.getConfig().set("Cases." + Main.nameOfCase + ".location.z", (Object)b.getLocation().getZ());
        if(true){
        	List<String> lis = this.plugin.getConfig().getStringList("Cases.names");
        	if (this.plugin.getConfig().getStringList("Cases.names") == null) {
        		lis = new ArrayList<String>();
        	}
        	lis.add(Main.nameOfCase);
        	this.plugin.getConfig().set("Cases.names", lis);
        }
       
        List<String> list2 = new ArrayList<>();
        list2.add("DIRT");
        list2.add("DIRT");
        list2.add("DIRT");
        list2.add("DIRT");
        this.plugin.getConfig().set("Cases." + Main.nameOfCase + ".prises.ID", list2);
        
        if(true){
        	List<String> list = new ArrayList<>();
        	list.add("Земля");
        	list.add("Земля");
        	list.add("Земля");
        	list.add("Земля");
        	this.plugin.getConfig().set("Cases." + Main.nameOfCase + ".prises.names", list);
        }
        if(true){
        	List<Integer> list = new ArrayList<>();
        	list.add(1);
        	list.add(1);
        	list.add(1);
        	list.add(1);
        	this.plugin.getConfig().set("Cases." + Main.nameOfCase + ".prises.amounts", list);
        }
        List<Integer> l = new ArrayList<>();
        l.add(25);
        l.add(25);
        l.add(25);
        l.add(25);
        this.plugin.getConfig().set("Cases." + Main.nameOfCase + ".prises.chances", l);
        p.sendMessage("Кейс " + Main.nameOfCase + " установлен!");
        int i2 = 0;
        while (i2 < list2.size()) {
            p.sendMessage("\u041f\u0440\u0438\u0437 " + (i2 + 1) + ": \n id:" + (String)list2.get(i2) + ". \n \u0428\u0430\u043d\u0441: " + l.get(i2));
            ++i2;
        }
        this.plugin.saveConfig();
        this.plugin.saveDefaultConfig();
        Main.entered = false;
        Main.nameOfCase = null;
        Main.setter = null;
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Inventory inv = e.getInventory();
        int i = 0;
        while (i < Main.invs.size()) {
            if (inv == Main.invs.get(i)) {
                Main.invs.remove(i);
            }
            ++i;
        }
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        int i = 0;
        while (i < Main.invs.size()) {
            if (Main.invs.get(i).equals(inv)) {
                e.setCancelled(true);
                ItemStack item = inv.getItem(e.getSlot());
                if (item.getData().getData() == (byte)5) {
                	this.plugin.getConfig().set(String.valueOf(e.getWhoClicked().getName()) + "." + inv.getName(), (this.plugin.getConfig().getInt(String.valueOf(e.getWhoClicked().getName()) + "." + inv.getName()) - 1));
                    plugin.saveConfig();
                    plugin.saveDefaultConfig();
                	Main.invs.remove(inv);
                    List<String> items = this.plugin.getConfig().getStringList("Cases."+inv.getName() + ".prises.ID");
                    List<String> names = this.plugin.getConfig().getStringList("Cases."+inv.getName() + ".prises.names");
                    List<Integer> amounts = this.plugin.getConfig().getIntegerList("Cases."+inv.getName() + ".prises.amounts");
                    
                    ItemStack prise=Open((Player)e.getWhoClicked(), inv.getName(), items, names, amounts, this.plugin.getConfig().getIntegerList(String.valueOf("Cases."+inv.getName()) + ".chances"), new Key("", "").rChance());
                    ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.LEVEL_UP, 1, 1);
            		e.getWhoClicked().getInventory().addItem(prise);
                    e.getWhoClicked().closeInventory();
                    }
                if (item.getData().getData() == (byte)14) {
                	Main.invs.remove(inv);
                    ((Player)e.getWhoClicked()).closeInventory();
                }
            }
            ++i;
        }
    }

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        String s = null;
        List<String> list = this.plugin.getConfig().getStringList("Cases.names");
        int i = 0;
        while (i < list.size()) {
            if (b.getLocation().getWorld() == Bukkit.getServer().getWorld(this.plugin.getConfig().getString("Cases." + (String)list.get(i) + ".location.world", null)) && b.getLocation().getX() == this.plugin.getConfig().getDouble("Cases." + (String)list.get(i) + ".location.x", 0.0) && b.getLocation().getY() == this.plugin.getConfig().getDouble("Cases." + (String)list.get(i) + ".location.y", 0.0) && b.getLocation().getZ() == this.plugin.getConfig().getDouble("Cases." + (String)list.get(i) + ".location.z", 0.0)) {
                s = (String)list.get(i);
            }
            ++i;
        }
        if (s == null) {
            return;
        }
        if (this.plugin.getConfig().getInt(String.valueOf(p.getName()) + "." + s, 0) == 0) {
            if (b.getTypeId() != this.plugin.getConfig().getInt("ID_CASE", 120)) {
                return;
            }
            GUI gui = new GUI(27, s);
            List<String> pr = this.plugin.getConfig().getStringList("Cases." + s + ".prises.ID");
            List<String> names =this.plugin.getConfig().getStringList("Cases." + s + ".prises.names");
            List<Integer> amounts = this.plugin.getConfig().getIntegerList("Cases." + s + ".prises.amounts");
            
            int i2 = 0;
            while (i2 < pr.size()) {
                gui.addItem(ItemUtil.create(Material.getMaterial(pr.get(i2)), (int)(amounts.get(i2)), (byte)0, names.get(i2)));
                ++i2;
            }
            e.setCancelled(true);
            
            gui.OpenGUI(e.getPlayer());
            Main.invs.add(gui.getInvertory());
        }
        if (this.plugin.getConfig().getInt(String.valueOf(p.getName()) + "." + s, 0) > 0) {
            if (b.getTypeId() != this.plugin.getConfig().getInt("ID_CASE", 120)) {
                return;
            }
            GUI gui = new GUI(45, s);
            ItemStack green = new ItemStack(Material.WOOL, 1, (byte)5);
            ItemStack red = new ItemStack(Material.WOOL, 1, (byte)14);
            green.getItemMeta().setDisplayName("Открыть кейс!");
            red.getItemMeta().setDisplayName("Не открывать кейс");
            gui.setItem(red, 14);
            gui.setItem(red, 15);
            gui.setItem(red, 16);
            gui.setItem(red, 23);
            gui.setItem(red, 24);
            gui.setItem(red, 25);
            gui.setItem(red, 32);
            gui.setItem(red, 33);
            gui.setItem(red, 34);
            gui.setItem(green, 10);
            gui.setItem(green, 11);
            gui.setItem(green, 12);
            gui.setItem(green, 19);
            gui.setItem(green, 20);
            gui.setItem(green, 21);
            gui.setItem(green, 28);
            gui.setItem(green, 29);
            gui.setItem(green, 30);
            e.setCancelled(true);
            gui.OpenGUI(p);
            Main.invs.add(gui.getInvertory());
        }
    }
	public  ItemStack Open(Player p, String NameCase, List<String> prises, List<String> names, List<Integer> amounts, List<Integer> chances, int chance){
		
		GUI gui = new GUI(27, NameCase);
		gui.setItem(new ItemStack(Material.AIR), 11);
		gui.setItem(new ItemStack(Material.AIR), 12);
		gui.setItem(new ItemStack(Material.AIR), 13);
		gui.setItem(new ItemStack(Material.AIR), 14);
		gui.setItem(new ItemStack(Material.AIR), 15);
		gui.setItem(new ItemStack(Material.AIR), 16);
		for(int i=0;i<gui.getSize();i++){
			if(i>9&&i<17){
				
			}else if(i==4 || i == 22){ 
					gui.setItem(new ItemStack(Material.WOOD_SWORD), i);
				  }else gui.setItem(new ItemStack(Material.STAINED_GLASS_PANE, 1, ((byte)((int)(Math.random()*16)))), i);
		
		}
        int forPrise = (int)(Math.random()*(prises.size()));
        String s = prises.get(forPrise);
		ItemStack item = (ItemUtil.create(Material.getMaterial(s), (int)(amounts.get(forPrise)), (byte) 0, names.get(forPrise)));
		gui.OpenGUI(p);
		Main.invs.add(gui.getInvertory());
		for(int i=30; i<500;i=i+((int)(i/8))){
			if(i==325){
				CaseOpen(gui, item, p, i);
			}else CaseOpen(gui, prises, names, p, i);
		}
		return item;
	}
	public void CaseOpen(GUI gui, ItemStack prise, Player p, int count){
	    BukkitRunnable r = (BukkitRunnable) new BukkitRunnable(){
				public void run(){
	         p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
	       	 gui.setItem(gui.getItem(11).getItemStack(), 10);
		     gui.setItem(gui.getItem(12).getItemStack(), 11);
		     gui.setItem(gui.getItem(13).getItemStack(), 12);
		     gui.setItem(gui.getItem(14).getItemStack(), 13);
		     gui.setItem(gui.getItem(15).getItemStack(), 14);
	         gui.setItem(gui.getItem(16).getItemStack(), 15);
	      	 gui.setItem(prise, 16);
	      	Main.invs.remove(gui.getInvertory());
	      	 gui.OpenGUI(p);
	      	Main.invs.add(gui.getInvertory());
	         }
	   };
	   r.runTaskLater(plugin, count/10);
	   }

	public void CaseOpen(GUI gui, List<String> prises, List<String> names, Player p, int count){
	    BukkitRunnable r = (BukkitRunnable) new BukkitRunnable(){
				public void run(){
				 p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
	        	 int forPrise = (int)(Math.random()*(prises.size()));
	        	 String s = prises.get(forPrise);
				 ItemStack item = (ItemUtil.create(Material.getMaterial(s), 1, (byte) 0, names.get(forPrise)));
	        	 gui.setItem(gui.getItem(11).getItemStack(), 10);
		         gui.setItem(gui.getItem(12).getItemStack(), 11);
		         gui.setItem(gui.getItem(13).getItemStack(), 12);
		         gui.setItem(gui.getItem(14).getItemStack(), 13);
		         gui.setItem(gui.getItem(15).getItemStack(), 14);
		         gui.setItem(gui.getItem(16).getItemStack(), 15);
	        	 gui.setItem(item, 16);
	        	 Main.invs.remove(gui.getInvertory());
	        	 gui.OpenGUI(p);
	        	 Main.invs.add(gui.getInvertory());
	       }
	    	 };
	    	 r.runTaskLater(plugin, count/10);
	    	 
		}
}


