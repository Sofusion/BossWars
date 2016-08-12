package ru.cases.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUI {
	
	int amount;
	List<Item> items;
	Inventory inv;
	String name;
	public GUI(int amount, String Name){
		this.name=Name;
		this.amount=amount;
		items=new ArrayList<>();
		inv = Bukkit.createInventory(null, amount, name);
	}
	public GUI(int amount, List<Item> list, String Name){
		this.name=Name;
		this.amount=amount;
		items=list;
		inv = Bukkit.createInventory(null, amount, name);
	}
	public void OpenGUI(Player p){
		for(int i=0;i<items.size();i++){
			inv.setItem(items.get(i).getNumber(), items.get(i).getItemStack());
		}
		p.openInventory(inv);
	}
	public void addItem(ItemStack i){
		items.add(new Item(i, items.size()));
	}
	public void setItem(ItemStack i, int n){
		for(int o = 0;o<items.size();o++){
			if(items.get(o).getNumber()==n){
				items.remove(items.get(o));
			}
		}
		items.add(new Item(i, n));
	}
	public void addItems(List<ItemStack> list){
		for(int i=0;i<list.size();i++){
			items.add(new Item(list.get(i), items.size()));
		}
	}
	public Inventory getInvertory(){
		return inv;
	}
	public Item getItem(int n){
		for(int i=0;i<items.size();i++){
			if(items.get(i).getNumber()==n){
				return items.get(i);
			}
		}return null;
	}
	public List<Item> geItems(){
		return items;
	}
	public Integer getSize(){
		return amount;
	}
}
