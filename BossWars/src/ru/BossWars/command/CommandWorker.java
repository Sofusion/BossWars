/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.CommandSender
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 */
package ru.BossWars.command;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;

public class CommandWorker
implements CommandExecutor {
    public List<Command> cmds = new ArrayList<Command>();
    boolean allowForOps;
    String commandName;

    public CommandWorker(String name, boolean ops) {
        this.allowForOps = ops;
        this.commandName = name;
    }

    public boolean onCommand(CommandSender sen, org.bukkit.command.Command cmd, String label, String[] args) {
        if (cmd.getName().equals("boss")) {
            if (args.length == 0) {
                sen.sendMessage(BossWars.cmd.getString("Commands"));
                return true;
            }
            int i = 0;
            while (i < this.cmds.size()) {
                if (this.cmds.get(i).getNames().get(0).equals(args[0])) {
                    if (sen instanceof Player) {
                        Player p = (Player)sen;
                        if (((Player)sen).hasPermission(this.cmds.get(i).getPermission()) | p.isOp()) {
                            this.cmds.get(i).Execute(sen, cmd, args);
                            return true;
                        }
                        sen.sendMessage((Object)ChatColor.RED + "\u0423 \u0432\u0430\u0441 \u043d\u0435\u0442 \u043f\u0440\u0430\u0432!!!");
                        return true;
                    }
                    this.cmds.get(i).ExecuteConsole(sen, cmd, args);
                }
                if (this.cmds.get(i).getNames().get(1).equals(args[0])) {
                    if (sen instanceof Player) {
                        Player p = (Player)sen;
                        if (p.isOp() | ((Player)sen).hasPermission(this.cmds.get(i).getPermission())) {
                            this.cmds.get(i).Execute(sen, cmd, args);
                            return true;
                        }
                        sen.sendMessage((Object)ChatColor.RED + "\u0423 \u0432\u0430\u0441 \u043d\u0435\u0442 \u043f\u0440\u0430\u0432!!!");
                        return true;
                    }
                    this.cmds.get(i).ExecuteConsole(sen, cmd, args);
                }
                ++i;
            }
            sen.sendMessage((Object)ChatColor.RED + "\u041a\u043e\u043c\u0430\u043d\u0434\u0430 \u0432\u0432\u0435\u0434\u0435\u043d\u0430 \u043d\u0435\u0432\u0435\u0440\u043d\u043e");
            return false;
        }
        return false;
    }
}

