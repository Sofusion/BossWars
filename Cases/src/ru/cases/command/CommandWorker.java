package ru.cases.command;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWorker implements CommandExecutor{
	public List<ru.cases.command.Command> cmds = new ArrayList<>(); 
	boolean allowForOps;
	String commandName;
	
	public CommandWorker(String name, boolean ops) {
		allowForOps = ops;
		commandName = name;
	}
	
	@Override
	public boolean onCommand(CommandSender sen, org.bukkit.command.Command cmd, String label, String[] args) {
		if(cmd.getName().equals("cases") || cmd.getName().equals("c")){
			if(args.length == 0){
				for(int i=0;i<cmds.size();i++){
					if(((Player)sen).hasPermission(cmds.get(i).getPermission()) || ((Player)sen).isOp()){
						sen.sendMessage(cmds.get(i).getHelp());
					}
				}return true;
			}else{
				for(int i=0;i<cmds.size();i++){
					if(cmds.get(i).getNames().get(0).contains(args[0])){
						if(sen instanceof Player){
							Player p = (Player) sen;
							if(((Player) sen).hasPermission(cmds.get(i).getPermission()) || p.isOp()){
								cmds.get(i).Execute(sen, cmd, args);
								return true;
							}else sen.sendMessage(ChatColor.RED + "У вас нет прав!!!");
						return true;
						}else sen.sendMessage("Only dor Players");
					}else if(cmds.get(i).getNames().get(1).contains(args[0])){
						if(sen instanceof Player){
							Player p = (Player) sen;
							if(p.isOp() || ((Player)sen).hasPermission(cmds.get(i).getPermission())){
								cmds.get(i).Execute(sen, cmd, args);
								return true;
								}else sen.sendMessage(ChatColor.RED + "У вас нет прав!!!");
						return true;
						}else sen.sendMessage("Only dor Players");
					}else if(cmds.get(i).getNames().get(2).contains(args[0])){
						if(sen instanceof Player){
							Player p = (Player) sen;
							if(p.isOp() || ((Player)sen).hasPermission(cmds.get(i).getPermission())){
								cmds.get(i).Execute(sen, cmd, args);
								return true;
								}else sen.sendMessage(ChatColor.RED + "У вас нет прав!!!");
						return true;
						}else sen.sendMessage("Only dor Players");
					}
				}
				sen.sendMessage(ChatColor.RED + "Команда введена неверно");
				return false;
			}
		}
		return false;
	}
}
