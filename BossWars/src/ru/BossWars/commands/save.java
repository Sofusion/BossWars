/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandSender
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 */
package ru.BossWars.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class save
implements Command {
    @Override
    public List<String> getNames() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("save");
        return list;
    }

    @Override
    public String getPermission() {
        return "BossWars.create.save";
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
        if (BossWars.aC != 5) {
            sen.sendMessage(BossWars.cmd.getString("Commands"));
            return;
        }
        Player p = (Player)sen;
        Bukkit.getServer().dispatchCommand((CommandSender)p, "/copy");
        Bukkit.getServer().dispatchCommand((CommandSender)p, "/schem save schematic BossWars/" + BossWars.arenas.get(BossWars.arenas.size() - 1));
        BossWars.spn.set(String.valueOf(BossWars.arenas.get(BossWars.arenas.size() - 1)) + ".forSet.world", (Object)"");
        BossWars.spn.set(String.valueOf(BossWars.arenas.get(BossWars.arenas.size() - 1)) + ".forSet.x", (Object)p.getLocation().getX());
        BossWars.spn.set(String.valueOf(BossWars.arenas.get(BossWars.arenas.size() - 1)) + ".forSet.y", (Object)p.getLocation().getY());
        BossWars.spn.set(String.valueOf(BossWars.arenas.get(BossWars.arenas.size() - 1)) + ".forSet.z", (Object)p.getLocation().getZ());
        try {
            BossWars.spn.save(BossWars.spns);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        BossWars.aC = 0;
    }
}

