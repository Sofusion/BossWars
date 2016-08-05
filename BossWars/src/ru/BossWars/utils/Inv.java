package ru.BossWars.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Inv {
	public Inventory inv;
	public Player p;
	public Inv(Inventory inv, Player p){
		this.inv=inv;
		this.p = p;
	}
}
