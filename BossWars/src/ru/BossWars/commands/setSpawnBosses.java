package ru.BossWars.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class setSpawnBosses implements Command{

	@Override
	public List<String> getNames() {
		List<String> list = new ArrayList<>();
		list.add("ssb");
		list.add("setspawnbosses");
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
		}if(BossWars.aC!=3){
			sen.sendMessage(BossWars.cmd.getString("Commands"));
			return;
		}
		Player p = (Player) sen;
		if(BossWars.spawn.contains(args[1])){
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".bosses."+ args[1] +".world", "");
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".bosses."+ args[1] +".x", p.getLocation().getX());
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".bosses."+ args[1] +".y", p.getLocation().getY());
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".bosses."+ args[1] +".z", p.getLocation().getZ());
		try {
			BossWars.spn.save(BossWars.spns);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}else {
			sen.sendMessage("Этой команды не существует");
			return;
		}
		BossWars.spawn.remove(args[1]);
		BossWars.spwn.add(args[1]);
		sen.sendMessage(ChatColor.GREEN + "Точка спауна боссов команды " + args[1] + " установлена");
		if(BossWars.spawn.isEmpty()){
			BossWars.aC = 4;
			sen.sendMessage(ChatColor.GREEN + "Расстановка точек спауна боссов закончена");
		}
	}

}
