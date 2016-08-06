/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.Server
 *  org.bukkit.command.CommandExecutor
 *  org.bukkit.command.PluginCommand
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Listener
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.plugin.PluginManager
 *  org.bukkit.plugin.java.JavaPlugin
 */
package ru.BossWars.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import ru.BossWars.Events.Quit;
import ru.BossWars.command.CommandWorker;
import ru.BossWars.commands.create;
import ru.BossWars.commands.help;
import ru.BossWars.commands.join;
import ru.BossWars.commands.leave;
import ru.BossWars.commands.pos1;
import ru.BossWars.commands.pos2;
import ru.BossWars.commands.save;
import ru.BossWars.commands.setSpawnBosses;
import ru.BossWars.commands.setSpawnMobs;
import ru.BossWars.commands.setSpawnPlayers;
import ru.BossWars.commands.setlobby;
import ru.BossWars.inGame.inGame;
import ru.BossWars.loadConfig.loadConfig;
import ru.BossWars.tp.Pos;
import ru.BossWars.utils.GUI;
import ru.BossWars.utils.Inv;

public class BossWars
extends JavaPlugin
implements Listener {
    public static int aC = 0;
    public static Pos sp = null;
    public static Pos pos1 = null;
    public static Pos pos2 = null;
    public static Pos pos = new Pos("world", -141.0, 64.0, 180.0);
    public static String cmd1;
    public static String lr2;
    public static boolean lr1;
    public static boolean inGame;
    public static boolean trueBreak;
    public static List<String> arenas;
    public static List<String> spawn;
    public static List<String> spwn;
    public static List<Inv> pls;
    public static List<Player> players;
    public static List<Player> comRed;
    public static List<Player> comBlue;
    public static Plugin plugin;
    public static File spns;
    public static YamlConfiguration spn;
    public static File lbs;
    public static YamlConfiguration lb;
    public static File msgs;
    public static YamlConfiguration msg;
    public static File cmds;
    public static YamlConfiguration cmd;
    public static File lrs;
    public static YamlConfiguration lr;

    static {
        inGame = false;
        trueBreak = false;
        arenas = new ArrayList<String>();
        spawn = new ArrayList<String>();
        spwn = new ArrayList<String>();
        pls = new ArrayList<Inv>();
        players = new ArrayList<Player>();
        comRed = new ArrayList<Player>();
        comBlue = new ArrayList<Player>();
        spns = new File("plugins/BossWars/Spawns.yml");
        spn = YamlConfiguration.loadConfiguration((File)spns);
        lbs = new File("plugins/BossWars/Lobbies.yml");
        lb = YamlConfiguration.loadConfiguration((File)lbs);
        msgs = new File("plugins/BossWars/Messages.yml");
        msg = YamlConfiguration.loadConfiguration((File)msgs);
        cmds = new File("plugins/BossWars/Commands.yml");
        cmd = YamlConfiguration.loadConfiguration((File)cmds);
        lrs = new File("plugins/BossWars/Listeners.yml");
        lr = YamlConfiguration.loadConfiguration((File)lrs);
    }

    public void onEnable() {
        plugin = new BossWars();
        int i = 0;
        while (i < 6) {
            comRed.add(null);
            ++i;
        }
        i = 0;
        while (i < 6) {
            comBlue.add(null);
            ++i;
        }
        CommandWorker cw = new CommandWorker("boss", true);
        cw.cmds.add(new join());
        cw.cmds.add(new setlobby());
        cw.cmds.add(new create());
        cw.cmds.add(new pos1());
        cw.cmds.add(new pos2());
        cw.cmds.add(new setSpawnPlayers());
        cw.cmds.add(new setSpawnBosses());
        cw.cmds.add(new setSpawnMobs());
        cw.cmds.add(new save());
        cw.cmds.add(new help());
        cw.cmds.add(new leave());
        this.getCommand("boss").setExecutor((CommandExecutor)cw);
        this.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new inGame(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new Quit(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new GUI(), (Plugin)this);
        loadConfig.loadConfigs();
    }

    public void onDisable() {
        if (!pls.isEmpty()) {
            int i = 0;
            while (i < pls.size()) {
                int a = 0;
                while (a < 36) {
                    BossWars.pls.get((int)i).p.getInventory().setItem(a, BossWars.pls.get((int)a).inv.getItem(a));
                    ++a;
                }
                ++i;
            }
            pls.clear();
        }
    }
}

