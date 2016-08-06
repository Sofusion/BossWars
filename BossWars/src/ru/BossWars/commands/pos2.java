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

public class pos2
implements Command {
    @Override
    public List<String> getNames() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("pos2");
        list.add("pos2");
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
        if (!(sen instanceof Player)) {
            sen.sendMessage((Object)ChatColor.RED + "This command only for players");
            return;
        }
        if (args.length != 1) {
            sen.sendMessage(this.getHelp());
            return;
        }
        if (BossWars.aC != 2) {
            sen.sendMessage("\u0422\u043e\u0447\u043a\u0438 \u0443\u0436\u0435 \u043f\u043e\u0441\u0442\u0430\u0432\u043b\u0435\u043d\u044b \u0438\u043b\u0438 \u0430\u0440\u0435\u043d\u0430 \u0435\u0449\u0435 \u043d\u0435 \u0437\u0430\u043f\u0443\u0449\u0435\u043d\u0430");
            return;
        }
        Player p = (Player)sen;
        Bukkit.getServer().dispatchCommand((CommandSender)p, "/pos2");
        BossWars.aC = 3;
    }
}

