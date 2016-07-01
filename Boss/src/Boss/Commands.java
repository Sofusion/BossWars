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
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Commands implements Listener, CommandExecutor {
	int cr, i;
	int b, t, o;
	Player q;
	List<World> worlds = new ArrayList<>();
	Timer timer=new Timer();
	TimerTask mytimer = new myTask();
	private Boss boss;
	public Commands(Boss boss) {
		this.boss = boss;
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
			boss.reloadConfig();
			boss.onDisable();
			boss.onEnable();
			sen.sendMessage(ChatColor.GREEN + "Plugin BossWars was reloaded");
		}
		
		if(cmd.getName().equalsIgnoreCase("setlobby")){	
			if(chekSender(sen)){
				sen.sendMessage(ChatColor.RED + "Only players can use this command");
				return true;
			}if(args.length==0)return false;
			Player p = (Player) sen;
			Location loc = p.getLocation();
			boss.locToConfig(args[0], loc);
			sen.sendMessage(ChatColor.GREEN + "Лобби установлено");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("enter")){
			if(chekSender(sen)){
				sen.sendMessage(ChatColor.RED + "Only players can use this command");
				return true;
			}
			Player p = (Player) sen;
			/*if(players.contains(p)){
				p.sendMessage(ChatColor.RED + "Вы уже в очереди!!!");
				return true;
			}*/
			boss.players.add(p);
			p.sendMessage(ChatColor.GREEN + "Вы вошли в очередь");
			if(boss.players.size() == 2){
				for(i=0; i<2; i++){
					p = boss.players.get(i);
					World world = Bukkit.getWorld(boss.pos.worldName);
					p.teleport(new Location(world, boss.pos.x, boss.pos.y, boss.pos.z));
					p.setGameMode(GameMode.SURVIVAL);
					p.setExp(0);
				}
				toLobby();
			
			}
			if(boss.players.size() > 2) {
				World world = Bukkit.getWorld(boss.pos.worldName);
				p.teleport(new Location(world, boss.pos.x, boss.pos.y, boss.pos.z));
				p.setGameMode(GameMode.SURVIVAL);
				p.setExp(0);
			}
		return true;
		}
		return true;
	}
	
	
	public void toLobby(){
		i = 15;
			timer.schedule( mytimer,1000, 1000);
	}
	public class myTask extends TimerTask{
		public void run(){
			if(i<0)return;
			b = boss.players.size();
			for(o=0;o<b;o++){
				q = boss.players.get(o);
				q.setLevel(i);
				if(i<=3)q.playSound(q.getLocation(), Sound.LEVEL_UP, 1, 1);
				else q.playSound(q.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
				}
			i--;
		}
		}

}
