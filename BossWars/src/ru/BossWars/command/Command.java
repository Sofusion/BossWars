package ru.BossWars.command;

import java.util.List;

import org.bukkit.command.CommandSender;

public interface Command{
	List<String> getNames();
	String getPermission();
	String getHelp();
	void Execute (CommandSender sen, org.bukkit.command.Command cmd, String[] args);
	default void ExecuteConsole (CommandSender sen, org.bukkit.command.Command cmd, String[] args){
		Execute(sen, cmd, args);
	}

}
