/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.entity.Player
 */
package ru.BossWars.tp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import ru.BossWars.tp.Pos;

public class tp {
    public static void toLobby(Pos pos, Player p) {
        World world = Bukkit.getServer().getWorld(pos.worldName);
        p.teleport(new Location(world, pos.x, pos.y, pos.z));
    }
}

