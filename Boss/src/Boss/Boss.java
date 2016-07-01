package Boss;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Boss extends JavaPlugin implements Listener {
	
	private static Boss instance;
	FileConfiguration config = getConfig();
	
	
	List<Player> players = new ArrayList<>();
	Pos pos;
	List<World> worlds = new ArrayList<>();
	Location locc;
	
	public static Boss instance(){
		return instance;
	}
	
	public class Pos {
	    public String worldName;
	    public double x, y, z;
	 
	    public Pos(String name, double x, double y, double z) {
	        worldName = name;
	        this.x = x;
	        this.y = y;
	        this.z = z;
	    }
	}
	
	public void locToConfig(String world, Location loc){
		pos = new Pos(world, loc.getX(), loc.getY(), loc.getZ());
		config.set("Locations.lobby.world", pos.worldName);
		config.set("Locations.lobby.x", pos.x);
		config.set("Locations.lobby.y", pos.y);
		config.set("Locations.lobby.z", pos.z);
		saveConfig();
	}
	
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents( new Commands(this), this);
		getCommand("bcreate").setExecutor(new Commands(this));
		getCommand("setlobby").setExecutor(new Commands(this));
		getCommand("breload").setExecutor(new Commands(this));
		getCommand("bpos1").setExecutor(new Commands(this));
		getCommand("bpos2").setExecutor(new Commands(this));
		
		pos = new Pos(config.getString("Locations.lobby.world"), 
				config.getDouble("Locations.lobby.x"), 
				config.getDouble("Locations.lobby.y"), 
				config.getDouble("Locations.lobby.z"));
			getLogger().info(pos.worldName + " " + pos.x + " " + pos.y + " " + pos.z);
			
			
	}
	public void onDisable(){
		players.clear();
	}
	
	
	

	
}
