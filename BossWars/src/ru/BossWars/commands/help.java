package ru.BossWars.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;

import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class help implements Command{

	@Override
	public List<String> getNames() {
		List<String> list = new ArrayList<>();
		list.add("help");
		list.add("h");
		return list;
	}

	@Override
	public String getPermission() {
		return "BossWars.help";
	}

	@Override
	public String getHelp() {
		return BossWars.cmd.getString("Commands");
	}

	@Override
	public void Execute(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {
		sen.sendMessage(getHelp());
	}
}
