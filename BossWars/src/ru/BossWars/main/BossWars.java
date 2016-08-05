package ru.BossWars.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import ru.BossWars.Events.Quit;
import ru.BossWars.command.CommandWorker;
import ru.BossWars.commands.create;
import ru.BossWars.commands.help;
import ru.BossWars.commands.join;
import ru.BossWars.commands.leave;
import ru.BossWars.commands.save;
import ru.BossWars.commands.setSpawnBosses;
import ru.BossWars.commands.setSpawnMobs;
import ru.BossWars.commands.setSpawnPlayers;
import ru.BossWars.commands.setlobby;
import ru.BossWars.loadConfig.loadConfig;
import ru.BossWars.tp.Pos;
import ru.BossWars.utils.GUI;
import ru.BossWars.utils.Inv;

public class BossWars extends JavaPlugin implements Listener{
	public static int aC = 0;
	public static Pos sp = null;
	public static Pos pos1 = null;
	public static Pos pos2 = null;
	public static Pos pos = new Pos("world", -141, 64, 180);
	public static String cmd1;
	public static String lr2;
	public static boolean lr1;
	public static boolean inGame = false;
	public static boolean trueBreak = false;
	public static List<String> arenas = new ArrayList<>();
	public static List<String> spawn = new ArrayList<>();
	public static List<String> spwn = new ArrayList<>();
	public static List<Inv> pls = new ArrayList<>();
	public static List<Player> players = new ArrayList<>();
	public static List<Player> comRed = new ArrayList<>();
	public static List<Player> comBlue = new ArrayList<>();
	public static Plugin plugin;
	public static File spns = new File("plugins/BossWars/Spawns.yml");
	public static YamlConfiguration spn = YamlConfiguration.loadConfiguration(spns);
	public static File lbs = new File("plugins/BossWars/Lobbies.yml");
	public static YamlConfiguration lb = YamlConfiguration.loadConfiguration(lbs);
	public static File msgs = new File("plugins/BossWars/Messages.yml");
	public static YamlConfiguration msg = YamlConfiguration.loadConfiguration(msgs);
	public static File cmds = new File("plugins/BossWars/Commands.yml");
	public static YamlConfiguration cmd = YamlConfiguration.loadConfiguration(cmds);
	public static File lrs = new File("plugins/BossWars/Listeners.yml");
	public static YamlConfiguration lr = YamlConfiguration.loadConfiguration(lrs);
	
	
	public void onEnable( ){
		plugin = new BossWars();
		for(int i=0;i<6;i++){
			comRed.add(null);
		}
		for(int i=0;i<6;i++){
			comBlue.add(null);
		}
		CommandWorker cw = new CommandWorker("boss",true);
		cw.cmds.add(new join());
		cw.cmds.add(new setlobby());
		cw.cmds.add(new create());
		cw.cmds.add(new ru.BossWars.commands.pos1());
		cw.cmds.add(new ru.BossWars.commands.pos2());
		cw.cmds.add(new setSpawnPlayers());
		cw.cmds.add(new setSpawnBosses());
		cw.cmds.add(new setSpawnMobs());
		cw.cmds.add(new save());
		cw.cmds.add(new help());
		cw.cmds.add(new leave());
		getCommand("boss").setExecutor(cw);
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new ru.BossWars.inGame.inGame(), this);
		getServer().getPluginManager().registerEvents(new Quit(), this);
		getServer().getPluginManager().registerEvents(new GUI(), this);
		loadConfig.loadConfigs();
	}
	public void onDisable(){
		if(!pls.isEmpty()){
			for(int i=0;i<pls.size();i++){
				for(int a=0;a<36;a++){
					pls.get(i).p.getInventory().setItem(a, pls.get(a).inv.getItem(a));
				}
			}
		pls.clear();
		
	}
	
	}
}
