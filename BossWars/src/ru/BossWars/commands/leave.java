package ru.BossWars.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class leave implements Command{

	@Override
	public List<String> getNames() {
		List<String> list = new ArrayList<>();
		list.add("l");
		list.add("leave");
		return list;
	}

	@Override
	public String getPermission() {
		return "BossWars.join";
	}

	@Override
	public String getHelp() {
		return BossWars.cmd.getString("Commands");
	}

	@Override
	public void Execute(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {
		if(!(sen instanceof Player)){
			sen.sendMessage("Only players can use this command");
			return;
		}Player p = (Player) sen;
		if(BossWars.players.contains(p)){
			BossWars.players.remove(p);
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawn"+p.getName());
			if(BossWars.comRed.contains(p)){
				BossWars.comRed.remove(p);
			}else if(BossWars.comBlue.contains(p)){
				BossWars.comBlue.remove(p);
			}
			sen.sendMessage("Вы вышли из очереди");
			return;
		}else sen.sendMessage(ChatColor.RED+"Вы не в очереди!");
	}

}
