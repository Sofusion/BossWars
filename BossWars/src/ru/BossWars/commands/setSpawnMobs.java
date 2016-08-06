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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class setSpawnMobs
implements Command {
    @Override
    public List<String> getNames() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("ssm");
        list.add("setspawnmob");
        return list;
    }

    @Override
    public String getPermission() {
        return "BossWars.create.setspawn";
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
        if (args.length != 2) {
            sen.sendMessage(this.getHelp());
            return;
        }
        if (BossWars.aC != 4) {
            sen.sendMessage(this.getHelp());
            return;
        }
        Player p = (Player)sen;
        if (BossWars.spwn.contains(args[1])) {
            BossWars.spn.set(String.valueOf(BossWars.arenas.get(BossWars.arenas.size() - 1)) + ".mobs." + args[1] + ".world", (Object)"null");
            BossWars.spn.set(String.valueOf(BossWars.arenas.get(BossWars.arenas.size() - 1)) + ".mobs." + args[1] + ".x", (Object)p.getLocation().getX());
            BossWars.spn.set(String.valueOf(BossWars.arenas.get(BossWars.arenas.size() - 1)) + ".mobs." + args[1] + ".y", (Object)p.getLocation().getY());
            BossWars.spn.set(String.valueOf(BossWars.arenas.get(BossWars.arenas.size() - 1)) + ".mobs." + args[1] + ".z", (Object)p.getLocation().getZ());
            try {
                BossWars.spn.save(BossWars.spns);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            sen.sendMessage("\u042d\u0442\u043e\u0439 \u043a\u043e\u043c\u0430\u043d\u0434\u044b \u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442");
            return;
        }
        BossWars.spwn.remove(args[1]);
        sen.sendMessage((Object)ChatColor.GREEN + "\u0422\u043e\u0447\u043a\u0430 \u0441\u043f\u0430\u0443\u043d\u0430 \u043c\u043e\u0431\u043e\u0432 \u043a\u043e\u043c\u0430\u043d\u0434\u044b " + args[1] + " \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u0430");
        if (BossWars.spwn.isEmpty()) {
            BossWars.aC = 5;
            sen.sendMessage("\u0422\u043e\u0447\u043a\u0438 \u0441\u043f\u0430\u0443\u043d\u0430 \u043c\u043e\u0431\u043e\u0432 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u044b");
        }
    }
}

