/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
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
import ru.BossWars.main.BossWars;

public class create
implements Command {
    @Override
    public List<String> getNames() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("c");
        list.add("create");
        return list;
    }

    @Override
    public String getPermission() {
        return "BossWars.create.create";
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
        if (BossWars.aC != 0) {
            sen.sendMessage((Object)ChatColor.RED + "\u0423\u0436\u0435 \u0438\u0434\u0435\u0442 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0430\u0440\u0435\u043d\u044b");
            return;
        }
        BossWars.arenas.add(args[1]);
        BossWars.aC = 1;
        sen.sendMessage((Object)ChatColor.GOLD + "\u041d\u0430\u0447\u0438\u043d\u0430\u0435\u0442\u0441\u044f \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0430\u0440\u0435\u043d\u044b!");
    }
}

