/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.command.CommandSender
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitTask
 */
package ru.BossWars.tp;

import java.util.Timer;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.BossWars.inGame.inGame;
import ru.BossWars.main.BossWars;
import ru.BossWars.tp.Pos;
import ru.BossWars.tp.tp;

public class toTp {
    static Timer t;
    static Player p;
    static int i;
    static String arena;

    public static void toGame() {
        i = 16;
        Bukkit.getScheduler().runTaskTimer(BossWars.plugin, new Runnable(){

            @Override
            public void run() {
                int b = BossWars.players.size();
                int o = 0;
                while (o < b) {
                    toTp.p = BossWars.players.get(o);
                    toTp.p.setLevel(toTp.i - 1);
                    if (toTp.i <= 3) {
                        toTp.p.playSound(toTp.p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    } else {
                        toTp.p.playSound(toTp.p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 1.0f);
                    }
                    ++o;
                }
                if (--toTp.i == 0) {
                    toTp.arena = BossWars.arenas.get((int)(Math.random() * (double)BossWars.arenas.size()));
                    String world = "BWArena";
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"mw create BWArena");
                    toTp.t.schedule(inGame.tms, 100);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"mw load BWArena");
                    toTp.t.schedule(inGame.tms, 3000);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)("scload load BossWars/" + toTp.arena + " BWArena " + BossWars.spn.getDouble(new StringBuilder(String.valueOf(toTp.arena)).append(".forSet.x").toString()) + " " + BossWars.spn.getDouble(new StringBuilder(String.valueOf(toTp.arena)).append(".forSet.y").toString()) + " " + BossWars.spn.getDouble(new StringBuilder(String.valueOf(toTp.arena)).append(".forSet.z").toString())));
                    Pos spr = new Pos(world, BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".players.red.x"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".players.red.y"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".players.red.z"));
                    Pos sbr = new Pos(world, BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".bosses.red.x"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".bosses.red.y"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".bosses.red.z"));
                    Pos spb = new Pos(world, BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".players.blue.x"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".players.blue.y"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".players.blue.z"));
                    Pos sbb = new Pos(world, BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".bosses.blue.x"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".bosses.blue.y"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".bosses.blue.z"));
                    Pos smr = new Pos(world, BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".mobs.red.x"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".mobs.red.y"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".mobs.red.z"));
                    Pos smb = new Pos(world, BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".mobs.blue.x"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".mobs.blue.y"), BossWars.spn.getDouble(String.valueOf(toTp.arena) + ".mobs.blue.z"));
                    inGame.Game(BossWars.players, BossWars.comRed, BossWars.comBlue, spr, spb, sbr, sbb, smr, smb);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"mw unload BWArena");
                    toTp.t.schedule(inGame.tms, 3000);
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"mw delete BWArena");
                    toTp.t.schedule(inGame.tms, 100);
                    return;
                }
            }
        }, 1, 1000);
    }

    public static void tp(Pos spr, Pos spb) {
        int i = 0;
        while (i < BossWars.comRed.size()) {
            tp.toLobby(spr, BossWars.comRed.get(i));
            BossWars.comRed.get(i).sendMessage("\u0412\u044b\u0431\u0440\u0430\u043d\u0430 \u0430\u0440\u0435\u043d\u0430 " + arena);
            ++i;
        }
        i = 0;
        while (i < BossWars.comBlue.size()) {
            tp.toLobby(spb, BossWars.comBlue.get(i));
            BossWars.comBlue.get(i).sendMessage("\u0412\u044b\u0431\u0440\u0430\u043d\u0430 \u0430\u0440\u0435\u043d\u0430 " + arena);
            ++i;
        }
        BossWars.inGame = true;
    }

}

