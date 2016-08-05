package ru.BossWars.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class pos1 implements Command{

	@Override
	public List<String> getNames() {
		List<String> list = new ArrayList<>();
		list.add("pos1");
		list.add("pos1");
		return list;
	}

	@Override
	public String getPermission() {
		return "BossWars.create.pos";
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
		if(args.length !=1){
			sen.sendMessage(getHelp());
			return;
		}
		if(!(BossWars.aC == 1)){
			sen.sendMessage("“очки уже поставлены или арена еще не запущена");
			return;
		}
		Player p = (Player) sen;
		Bukkit.getServer().dispatchCommand(p, "/pos1");
		BossWars.aC =2;
	}

}
