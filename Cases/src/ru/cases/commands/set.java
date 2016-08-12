package ru.cases.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ru.cases.command.Command;
import ru.cases.main.Main;

public class set implements Command{
	Main plugin;
	public set(Main pl){
		plugin=pl;
	}
	@Override
	public List<String> getNames() {
		List<String> list = new ArrayList<>();
		list.add("set");
		list.add("set");
		list.add("set");
		return list;
	}

	@Override
	public String getPermission() {
		return "cases.set";
	}

	@Override
	public String getHelp() {
		return "/c set/s <name> или /c set/s <name> - для установки Кейса под именем <name>";
	}

	@Override
	public void Execute(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {
		if(!(sen instanceof Player)){
			sen.sendMessage("Only for Players");
			return;
		}
		if(args.length<2){
			sen.sendMessage(getHelp());
			return;
		}
		if(Main.entered){
			sen.sendMessage("Кейс уже устанавливается");
			return;
		}
		List<String> list = plugin.getConfig().getStringList("Cases.names");
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals(args[1])){
				sen.sendMessage("Кейс уже установлен");
				return;
			}
		}
		Main.entered = true;
		Main.setter = (Player) sen;
		Main.nameOfCase = args[1];
		sen.sendMessage("Происходит установка кейса!");
	}

}
