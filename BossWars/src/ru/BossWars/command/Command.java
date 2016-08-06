package ru.BossWars.command;

import java.util.List;
import org.bukkit.command.CommandSender;

public interface Command {
    public List<String> getNames();

    public String getPermission();

    public String getHelp();

    public void Execute(CommandSender var1, org.bukkit.command.Command var2, String[] var3);

    default public void ExecuteConsole(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {
        this.Execute(sen, cmd, args);
    }
}

