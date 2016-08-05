package ru.BossWars.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.BossWars.command.Command;
import ru.BossWars.loadConfig.saveConfig;
import ru.BossWars.main.BossWars;
import ru.BossWars.tp.Pos;

public class setlobby implements Command{

	@Override
	public List<String> getNames() {
		List<String> list = new ArrayList<String>();
		list.add("setlobby");
		list.add("sl");
		return list;
	}

	@Override
	public String getPermission() {
		
		return "BossWars.setlobby";
	}

	@Override
	public String getHelp() {
		
		return BossWars.cmd.getString("Commands");
	}

	@Override
	public void Execute(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {
		if(!(sen instanceof Player)){
			sen.sendMessage(ChatColor.RED + "This command only for players");
			return;
		}
		if(args.length == 0 | args.length == 1){
			sen.sendMessage(getHelp());
			return;
		}
		Player p = (Player) sen;
		BossWars.pos = new Pos(args[1], p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
		saveConfig.saveConfigs();
		sen.sendMessage(ChatColor.GREEN + "Лобби установлено!");
		
			
	}

}
