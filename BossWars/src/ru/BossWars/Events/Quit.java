/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Listener
 *  org.bukkit.event.player.PlayerQuitEvent
 */
package ru.BossWars.Events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.BossWars.main.BossWars;

public class Quit
implements Listener {
    public void onQuitPlayer(PlayerQuitEvent e) {
        if (BossWars.players.contains((Object)e.getPlayer())) {
            BossWars.players.remove((Object)e.getPlayer());
        }
        if (BossWars.comBlue.contains((Object)e.getPlayer())) {
            BossWars.comBlue.remove((Object)e.getPlayer());
        }
        if (BossWars.comRed.contains((Object)e.getPlayer())) {
            BossWars.comRed.remove((Object)e.getPlayer());
        }
    }
}

