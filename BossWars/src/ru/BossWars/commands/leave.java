/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandSender
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 */
package ru.BossWars.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class leave
implements Command {
    @Override
    public List<String> getNames() {
        ArrayList<String> list = new ArrayList<String>();
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
        if (!(sen instanceof Player)) {
            sen.sendMessage("Only players can use this command");
            return;
        }
        Player p = (Player)sen;
        if (BossWars.players.contains((Object)p)) {
            BossWars.players.remove((Object)p);
            Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "spawn" + p.getName());
            if (BossWars.comRed.contains((Object)p)) {
                BossWars.comRed.remove((Object)p);
            } else if (BossWars.comBlue.contains((Object)p)) {
                BossWars.comBlue.remove((Object)p);
            }
            sen.sendMessage("\u0412\u044b \u0432\u044b\u0448\u043b\u0438 \u0438\u0437 \u043e\u0447\u0435\u0440\u0435\u0434\u0438");
            return;
        }
        sen.sendMessage((Object)ChatColor.RED + "\u0412\u044b \u043d\u0435 \u0432 \u043e\u0447\u0435\u0440\u0435\u0434\u0438!");
    }
}

