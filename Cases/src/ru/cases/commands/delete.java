package ru.cases.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.CommandSender;
import ru.cases.command.Command;
import ru.cases.main.Main;

public class delete implements Command{
	private Main plugin;
	public delete(Main plugin){
		this.plugin=plugin;
	}
	@Override
	public List<String> getNames() {
		List<String> list =new ArrayList<>();
		list.add("delete");
		list.add("del");
		list.add("remove");
		return list;
	}

	@Override
	public String getPermission() {
		return "cases.delete";
	}

	@Override
	public String getHelp() {
		return "/c delete/del/remove <name> - Удалить кейс под именем <name>";
	}

	@Override
	public void Execute(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {
		if(args.length<2){
			sen.sendMessage(getHelp());
			return;
		}
		List<String> list=plugin.getConfig().getStringList("Cases.names");
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals(args[1])){
				list.remove(args[1]);
				plugin.getConfig().set("Cases.names", list);
				plugin.saveConfig();
				plugin.saveDefaultConfig();
				return;
			}
		}
		sen.sendMessage("Такого кейса нет в базе данных");
	}
}
