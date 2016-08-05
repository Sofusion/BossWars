package ru.BossWars.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class setSpawnMobs implements Command{

	@Override
	public List<String> getNames() {
		List<String> list = new ArrayList<>();
		list.add("ssm");
		list.add("setspawnmob");
		return list;
	}

	@Override
	public String getPermission() {
		return "BossWars.create.setspawn";
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
		if(args.length !=2){
			sen.sendMessage(getHelp());
			return;
		}if(BossWars.aC!=4){
			sen.sendMessage(getHelp());
			return;
		}
		Player p=(Player)sen;
		if(BossWars.spwn.contains(args[1])){
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".mobs."+ args[1] +".world", "null");
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".mobs."+ args[1] +".x", p.getLocation().getX());
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".mobs."+ args[1] +".y", p.getLocation().getY());
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".mobs."+ args[1] +".z", p.getLocation().getZ());
			try {
				BossWars.spn.save(BossWars.spns);
			} catch (IOException e) {
				e.printStackTrace();
			}
			}else {
				sen.sendMessage("Ётой команды не существует");
				return;
		}
		BossWars.spwn.remove(args[1]);
		sen.sendMessage(ChatColor.GREEN + "“очка спауна мобов команды " + args[1]+" установлена");
		if(BossWars.spwn.isEmpty()){
			BossWars.aC=5;
			sen.sendMessage("“очки спауна мобов установлены");
		}
	}

}
