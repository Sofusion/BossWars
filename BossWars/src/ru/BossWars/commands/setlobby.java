/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandSender
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 */
package ru.BossWars.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.BossWars.command.Command;
import ru.BossWars.loadConfig.saveConfig;
import ru.BossWars.main.BossWars;
import ru.BossWars.tp.Pos;

public class setlobby
implements Command {
    @Override
    public List<String> getNames() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("setlobby");
        list.add("sl");
        return list;
    }

    @Override
    public String getPermission() {
        return "BossWars.setlobby";
    }

    @Override
    public String getHelp() {
        return BossWars.cmd.getString("Commands");
    }

    @Override
    public void Execute(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {
        if (!(sen instanceof Player)) {
            sen.sendMessage((Object)ChatColor.RED + "This command only for players");
            return;
        }
        if (args.length == 0 | args.length == 1) {
            sen.sendMessage(this.getHelp());
            return;
        }
        Player p = (Player)sen;
        BossWars.pos = new Pos(args[1], p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
        saveConfig.saveConfigs();
        sen.sendMessage((Object)ChatColor.GREEN + "\u041b\u043e\u0431\u0431\u0438 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e!");
    }
}

