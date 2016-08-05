package ru.BossWars.command;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.BossWars.main.BossWars;

public class CommandWorker implements CommandExecutor{
	public List<ru.BossWars.command.Command> cmds = new ArrayList<>(); 
	boolean allowForOps;
	String commandName;
	
	public CommandWorker(String name, boolean ops) {
		allowForOps = ops;
		commandName = name;
	}
	
	@Override
	public boolean onCommand(CommandSender sen, org.bukkit.command.Command cmd, String label, String[] args) {
		if(cmd.getName().equals("boss")){
			if(args.length == 0){
				sen.sendMessage(BossWars.cmd.getString("Commands"));
				return true;
			}else
			{
				for(int i=0;i<cmds.size();i++){
					if(cmds.get(i).getNames().get(0).equals(args[0])){
						if(sen instanceof Player){
							Player p = (Player) sen;
							if(((Player) sen).hasPermission(cmds.get(i).getPermission()) | p.isOp()){
								cmds.get(i).Execute(sen, cmd, args);
								return true;
							}else sen.sendMessage(ChatColor.RED + "У вас нет прав!!!");
						return true;
						}else cmds.get(i).ExecuteConsole(sen, cmd, args);
					}
					if(cmds.get(i).getNames().get(1).equals(args[0])){
						if(sen instanceof Player){
							Player p = (Player) sen;
							if( p.isOp() | ((Player)sen).hasPermission(cmds.get(i).getPermission())){
								cmds.get(i).Execute(sen, cmd, args);
								return true;
								}else sen.sendMessage(ChatColor.RED + "У вас нет прав!!!");
						return true;
						}else cmds.get(i).ExecuteConsole(sen, cmd, args);
					}
				}
				sen.sendMessage(ChatColor.RED + "Команда введена неверно");
				return false;
			}
		}
		return false;
	}
	
}
