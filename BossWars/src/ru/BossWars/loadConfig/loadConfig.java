/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 *  org.bukkit.configuration.ConfigurationSection
 *  org.bukkit.configuration.file.YamlConfiguration
 */
package ru.BossWars.loadConfig;

import java.io.IOException;
import org.bukkit.ChatColor;
import ru.BossWars.main.BossWars;

public class loadConfig {
    public static void loadConfigs() {
        if (BossWars.spns.exists() && BossWars.spns.equals("arenas.names")) {
            BossWars.arenas = BossWars.spn.getStringList("arenas.names");
        }
        if (BossWars.spns.exists()) {
            BossWars.arenas = BossWars.spn.getStringList("arenas.names");
        }
        if (!BossWars.lbs.exists()) {
            try {
                BossWars.lbs.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            BossWars.lb.set("Locations.lobby.world", "world");
            BossWars.lb.set("Locations.lobby.x", -150);
            BossWars.lb.set("Locations.lobby.y", 64);
            BossWars.lb.set("Locations.lobby.z", 180);
            try {
                BossWars.lb.save(BossWars.lbs);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            BossWars.pos.worldName = BossWars.lb.getString("BossWars.lobby.world");
            BossWars.pos.x = BossWars.lb.getDouble("Locations.lobby.x");
            BossWars.pos.y = BossWars.lb.getDouble("Locations.lobby.y");
            BossWars.pos.z = BossWars.lb.getDouble("Locations.lobby.z");
        } else {
            BossWars.pos.worldName = BossWars.lb.getString("Locations.lobby.world");
            BossWars.pos.x = BossWars.lb.getDouble("Locations.lobby.x");
            BossWars.pos.y = BossWars.lb.getDouble("Locations.lobby.y");
            BossWars.pos.z = BossWars.lb.getDouble("Locations.lobby.z");
        }
        if (!BossWars.msgs.exists() | !BossWars.msgs.equals("alreadyIn") | !BossWars.msgs.equals("enteredIn") | !BossWars.msgs.equals("settedLobby")) {
            try {
                BossWars.msgs.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            BossWars.msg.set("aalreadyIn", (Object)((Object)ChatColor.RED + "\u0412\u044b \u0443\u0436\u0435 \u0432 \u043e\u0447\u0435\u0440\u0435\u0434\u0438!!!"));
            BossWars.msg.set("enteredIn", (Object)((Object)ChatColor.GREEN + "\u0412\u044b \u0432\u043e\u0448\u043b\u0438 \u0432 \u043e\u0447\u0435\u0440\u0435\u0434\u044c"));
            BossWars.msg.set("settedLobby", (Object)((Object)ChatColor.GREEN + "\u041b\u043e\u0431\u0431\u0438 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u043e!"));
            try {
                BossWars.msg.save(BossWars.msgs);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!BossWars.cmds.exists() | !BossWars.cmds.equals("Commands")) {
            try {
                BossWars.cmds.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            BossWars.cmd.createSection("//\u041b\u0443\u0447\u0448\u0435 \u044d\u0442\u043e \u043d\u0435 \u0442\u0440\u043e\u0433\u0430\u0442\u044c, \u044d\u0442\u043e \u0432 \u0432\u0430\u0448\u0438\u0445 \u0436\u0435 \u0438\u043d\u0442\u0435\u0440\u0435\u0441\u0430\u0445");
            BossWars.cmd.set("Commands", (Object)((Object)ChatColor.AQUA + "/boss j/join - \u0412\u0445\u043e\u0434 \u0432 \u043e\u0447\u0435\u0440\u0435\u0434\u044c\n" + "/boss sl/setlobby [world] - \u0423\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u043b\u043e\u0431\u0431\u0438 \u043d\u0430 \u0442\u043e\u0442 \u0431\u043b\u043e\u043a, \u043d\u0430 \u043a\u043e\u0442\u043e\u0440\u043e\u043c \u0432\u044b \u0441\u0442\u043e\u0438\u0442\u0435\n" + "/boss c/create <name> - \u041d\u0430\u0447\u0430\u043b\u043e \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \u0430\u0440\u0435\u043d\u044b\n" + "/boss pos1 - \u0423\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u043f\u0435\u0440\u0432\u043e\u0439 \u0442\u043e\u0447\u043a\u0438(\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e \u0442\u043e\u043b\u044c\u043a\u043e \u043f\u043e\u0441\u043b\u0435 \u043a\u043e\u043c\u0430\u043d\u0434\u044b /boss c/create)\n" + "/boss pos2 - \u0423\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0432\u0442\u043e\u0440\u043e\u0439 \u0442\u043e\u0447\u043a\u0438(\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e \u0442\u043e\u043b\u044c\u043a\u043e \u043f\u043e\u0441\u043b\u0435 \u043a\u043e\u043c\u0430\u043d\u0434\u044b /boss c/create)\n" + "/boss ssp/setspawnplayers <nameCommand> - \u0423\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0442\u043e\u0447\u043a\u0438 \u0441\u043f\u0430\u0443\u043d\u0430 \u0438\u0433\u0440\u043e\u043a\u043e\u0432 \u043a\u043e\u043c\u0430\u043d\u0434\u044b <nameCommand>(\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e \u0442\u043e\u043b\u044c\u043a\u043e \u043f\u043e\u0441\u043b\u0435 \u043a\u043e\u043c\u0430\u043d\u0434 /boss pos1/2)\n" + "/boss ssb/setspanwbosses <nameCommand> - \u0423\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0442\u043e\u0447\u043a\u0438 \u0441\u043f\u0430\u0443\u043d\u0430 \u0431\u043e\u0441\u0441\u043e\u0432 \u043a\u043e\u043c\u0430\u043d\u0434\u044b <nameCommand>(\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e \u0442\u043e\u043b\u044c\u043a\u043e \u043f\u043e\u0441\u043b\u0435 \u043a\u043e\u043c\u0430\u043d\u0434\u044b /boss ssb)\n" + "/boss ssm/setspawnmobs - \u0423\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0430 \u0441\u043f\u0430\u0443\u043d\u0430 \u043c\u043e\u0431\u043e\u0432(\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e \u0442\u043e\u043b\u044c\u043a\u043e \u043f\u043e\u0441\u043b\u0435 \u043a\u043e\u043c\u0430\u043d\u0434\u044b /boss ssb))\n" + "/boss save - \u041a\u043e\u043d\u0435\u0446 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0438 \u0430\u0440\u0435\u043d\u044b(\u0414\u043e\u0441\u0442\u0443\u043f\u043d\u043e \u0442\u043e\u043b\u044c\u043a\u043e \u043f\u043e\u0441\u043b\u0435 \u043a\u043e\u043c\u0430\u043d\u0434\u044b /boss ssm)"));
            try {
                BossWars.cmd.save(BossWars.cmds);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!BossWars.lrs.exists() | !BossWars.lrs.equals("PlayerJoinMessage") | !BossWars.lrs.equals("PlayerJoinMessageon")) {
            try {
                BossWars.lrs.createNewFile();
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
            BossWars.lr.set("PlayerJoinMessageon", (Object)true);
            BossWars.lr.set("PlayerJoinMessage", (Object)((Object)ChatColor.GOLD + "\u041f\u0440\u044f\u043c\u043e \u0441\u0435\u0439\u0447\u0430\u0441 \u043c\u043e\u0436\u043d\u043e \u0437\u0430\u0439\u0442\u0438 \u0432 \u0438\u0433\u0440\u0443 BossWars, \u043f\u0440\u043e\u0441\u0442\u043e \u043d\u0430\u043f\u0438\u0441\u0430\u0432 /boss j"));
            try {
                BossWars.lr.save(BossWars.lrs);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        BossWars.cmd1 = BossWars.cmd.getString("Commands");
        BossWars.lr2 = BossWars.lr.getString("PlayerJoinMessage");
        BossWars.lr1 = BossWars.lr.getBoolean("PlayerJoinMessageon");
    }
}

