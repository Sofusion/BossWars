package Boss;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Boss extends JavaPlugin implements Listener {
	int cr, i;
	int b, t, o;
	Player q;
	List<World> worlds = new ArrayList<>();
	Timer timer=new Timer();
	TimerTask mytimer = new myTask();
	private static Boss instance;
	FileConfiguration config = getConfig();
	List<Player> players = new ArrayList<>();
	Pos pos;
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
		
		
		pos = new Pos(config.getString("Locations.lobby.world"), 
				config.getDouble("Locations.lobby.x"), 
				config.getDouble("Locations.lobby.y"), 
				config.getDouble("Locations.lobby.z"));
			getLogger().info(pos.worldName + " " + pos.x + " " + pos.y + " " + pos.z);
			
			
	}
	public void onDisable(){
		players.clear();
	}
	
	public boolean chekSender (CommandSender sen){
		if(sen instanceof Player){return false;}return true;		
	}
	public boolean onCommand(CommandSender sen, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("bcreate")){
			if(chekSender(sen)){
				sen.sendMessage(ChatColor.RED + "Only players can use this command");
				return true;
			}if(!(args.length==1)) return false;
			@SuppressWarnings("unused")
			File arena = new File(args[0] + ".yml");
			cr = 1;
			sen.sendMessage("Происходит установка арены!");
		}
		
		if(cmd.getName().equalsIgnoreCase("breload")){
			reloadConfig();
			onDisable();
			onEnable();
			sen.sendMessage(ChatColor.GREEN + "Plugin BossWars was reloaded");
		}
		
		if(cmd.getName().equalsIgnoreCase("setlobby")){	
			if(chekSender(sen)){
				sen.sendMessage(ChatColor.RED + "Only players can use this command");
				return true;
			}if(args.length==0)return false;
			Player p = (Player) sen;
			Location loc = p.getLocation();
			locToConfig(args[0], loc);
			sen.sendMessage(ChatColor.GREEN + "Лобби установлено");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("enter")){
			if(chekSender(sen)){
				sen.sendMessage(ChatColor.RED + "Only players can use this command");
				return true;
			}
			Player p = (Player) sen;
			if(players.contains(p)){
				p.sendMessage(ChatColor.RED + "Вы уже в очереди!!!");
				return true;
			}
			players.add(p);
			p.sendMessage(ChatColor.GREEN + "Вы вошли в очередь");
			if(players.size() == 2){
				for(i=0; i<2; i++){
					p = players.get(i);
					World world = Bukkit.getWorld(pos.worldName);
					p.teleport(new Location(world, pos.x, pos.y, pos.z));
					p.setGameMode(GameMode.SURVIVAL);
					p.setExp(0);
				}
				toLobby();
			
			}
			if(players.size() > 2) {
				World world = Bukkit.getWorld(pos.worldName);
				p.teleport(new Location(world, pos.x, pos.y, pos.z));
				p.setGameMode(GameMode.SURVIVAL);
				p.setExp(0);
			}
		return true;
		}
		return true;
	}
	public void onPlayerQuit(PlayerQuitEvent e){
		if(players.contains(e.getPlayer()))players.remove(e.getPlayer());
	}
	
	public void toLobby(){
		i = 15;
			timer.schedule( mytimer,1000, 1000);
	}
	public class myTask extends TimerTask{
		public void run(){
			if(i<0)return;
			b = players.size();
			for(o=0;o<b;o++){
				q = players.get(o);
				q.setLevel(i);
				if(i<=3)q.playSound(q.getLocation(), Sound.LEVEL_UP, 1, 1);
				else q.playSound(q.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
				}
			i--;
		}
		}

	

	
}
