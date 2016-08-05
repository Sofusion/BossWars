package ru.BossWars.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class create implements Command{

	@Override
	public List<String> getNames() {
		List<String> list = new ArrayList<>();
		list.add("c");
		list.add("create");
		return list;
	}

	@Override
	public String getPermission() {
		return "BossWars.create.create";
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
		if(BossWars.aC != 0){
			sen.sendMessage(ChatColor.RED+"Уже идет установка арены");
			return;
		}
		BossWars.arenas.add(args[1]);
		BossWars.aC = 1;
		sen.sendMessage(ChatColor.GOLD+"Начинается установка арены!");
		
	}
	
}
