package ru.BossWars.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class setSpawnPlayers implements Command{

	@Override
	public List<String> getNames() {
		List<String> list = new ArrayList<>();
		list.add("ssp");
		list.add("setspawnplayers");
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
		}if(BossWars.aC!=2 && BossWars.aC!=3){
			sen.sendMessage(getHelp());
			return;
		}
		Player p = (Player) sen;
		if(!(BossWars.spns.exists())){
			try {
				BossWars.spns.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		BossWars.spn.set("arenas.names", "");
		
		if(!(BossWars.spawn.equals(args[1]))){
			BossWars.spawn.add(args[1]);
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".players."+ args[1] +".world", "null");
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".players."+ args[1] +".x", p.getLocation().getX());
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".players."+ args[1] +".y", p.getLocation().getY());
			BossWars.spn.set(BossWars.arenas.get(BossWars.arenas.size()-1) + ".players."+ args[1] +".z", p.getLocation().getZ());
		}else {
			sen.sendMessage("Эта команда уже была добавлена");
			return;
		}
		try {
			BossWars.spn.save(BossWars.spns);
		} catch (IOException e) {
			e.printStackTrace();
		}if(BossWars.spawn.size() >= 2 & (BossWars.spawn.size() <=4)){
		BossWars.aC = 3;
		}if((BossWars.spawn.size() ==4)){
			BossWars.aC = 4;
		}
		sen.sendMessage(ChatColor.GREEN + "Точка спауна игроков установлена");
	}
}
