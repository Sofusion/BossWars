/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandSender
 *  org.bukkit.configuration.file.YamlConfiguration
 */
package ru.BossWars.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.CommandSender;
import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class help
implements Command {
    @Override
    public List<String> getNames() {
        ArrayList<String> list = new ArrayList<String>();
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
        sen.sendMessage(this.getHelp());
    }
}

