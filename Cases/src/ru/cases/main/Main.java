package ru.cases.main;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import ru.cases.command.CommandWorker;
import ru.cases.commands.delete;
import ru.cases.commands.key;
import ru.cases.commands.set;
import ru.cases.commands.stats;
import ru.cases.listeners.Clicked;
import ru.cases.utils.Key;

public class Main extends JavaPlugin{
	public static boolean entered = false;
	public static Player setter = null;
	public static String nameOfCase = null;
	public static List<Inventory> invs = new ArrayList<>();
	public void onEnable(){
		if(!getConfig().isInt("ID_CASE")){
			getConfig().set("ID_CASE", 120);
		}
		saveConfig();
		saveDefaultConfig();
		Bukkit.getPluginManager().registerEvents(new Clicked(this), this);
		new Key(this);
		CommandWorker cw = new CommandWorker("cases", true);
		CommandWorker c = new CommandWorker("c", true);
		cw.cmds.add(new key(this));
		cw.cmds.add(new delete(this));
		cw.cmds.add(new stats(this));
		cw.cmds.add(new set(this));
		c.cmds.add(new key(this));
		c.cmds.add(new delete(this));
		c.cmds.add(new stats(this));
		c.cmds.add(new set(this));
		getCommand("cases").setExecutor(cw);;
		getCommand("c").setExecutor(c);
		getLogger().info("Plugin Cases's been Enabled!");
	}
	
	public void onDisable(){
		getLogger().info("Plugin Cases's been Disabled!");
	}
}
