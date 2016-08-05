package ru.BossWars.tp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class tp {
	public static void toLobby(Pos pos, Player p){
		World world = Bukkit.getServer().getWorld(pos.worldName);
		p.teleport(new Location(world, pos.x, pos.y, pos.z));
	}
}
