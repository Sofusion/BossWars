package ru.BossWars.Events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import ru.BossWars.main.BossWars;

public class Quit implements Listener{
	
	public void onQuitPlayer(PlayerQuitEvent e){
		if(BossWars.players.contains(e.getPlayer())){
			BossWars.players.remove(e.getPlayer());
		}
		if(BossWars.comBlue.contains(e.getPlayer())){
			BossWars.comBlue.remove(e.getPlayer());
		}
		if(BossWars.comRed.contains(e.getPlayer())){
			BossWars.comRed.remove(e.getPlayer());
		}
	}
}
