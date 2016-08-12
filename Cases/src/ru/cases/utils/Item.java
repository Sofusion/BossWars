package ru.cases.utils;

import org.bukkit.inventory.ItemStack;

public class Item {
	ItemStack item;
	int n;
	public Item(ItemStack item, int n){
		this.item=item;
		this.n=n;
	}
	public ItemStack getItemStack(){
		return item;
	}
	public int getNumber(){
		return n;
	}
}
