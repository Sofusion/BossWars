package ru.cases.utils;

import java.util.List;

import org.bukkit.entity.Player;

import ru.cases.main.Main;

public class Key {
	private Main plugin;
	public Key(Main plugin){
		this.plugin=plugin;
	}
	String namePlayer;
	String nameCase;
	int amount;
	int chance;
	public Key(String NamePlayer, String NameCase, double amount){
		this.amount=(int)amount;
		this.namePlayer=NamePlayer;
		this.nameCase=NameCase;
		this.chance=rChance();
		}
	public Key(String NamePlayer, String NameCase, int Chance, int amount){
		this.amount=amount;
		this.namePlayer=NamePlayer;
		this.nameCase=NameCase;
		this.chance=Chance;
	}
	public Key(String NamePlayer, String NameCase){
		this.amount=1;
		this.namePlayer=NamePlayer;
		this.nameCase=NameCase;
		this.chance=rChance();
		}
	public Key(String NamePlayer, String NameCase, int Chance){
		this.amount=1;
		this.namePlayer=NamePlayer;
		this.nameCase=NameCase;
		this.chance=Chance;
		}
	public void addKey(){
		this.amount=plugin.getConfig().getInt(namePlayer+"."+nameCase, 0);
		this.amount++;
		}
	public void addKey(int amount){
		this.amount=plugin.getConfig().getInt(namePlayer+"."+nameCase, 0);
		this.amount=this.amount+amount;
		}
	public void setKey(int amount){
		this.amount=plugin.getConfig().getInt(namePlayer+"."+nameCase, 0);
		this.amount=amount;
		}
	public int getKeys(){
		this.amount=plugin.getConfig().getInt(namePlayer+"."+nameCase, 0);
		return amount;
	}
	public void delKey(){
		this.amount=plugin.getConfig().getInt(namePlayer+"."+nameCase, 0);
		amount--;
		}
	public boolean hasKey(){
		this.amount=plugin.getConfig().getInt(namePlayer+"."+nameCase, 0);
		if(amount>0)
		return true;
		return false;
	}
	public boolean hasKey(Player p, String NameCase){
		if(plugin.getConfig().getInt(p.getName()+"."+NameCase, 0)>0)
		return true;
		return false;
	}
	public boolean hasKey(String p, String NameCase){
		if(plugin.getConfig().getInt(p+"."+NameCase, 0)>0)
		return true;
		return false;
	}
	public String getPrise(List<String> Prises, List<Integer> Chances){
		for(int i=0;i<Prises.size();i++){
			if(chance<=Chances.get(i)){
				chance=-1;
				return Prises.get(i);
			}else{
				for(int o=0;o<Chances.size();o++){
					Chances.set(o, Chances.get(o)+Chances.get(i));
				}
			}
		}
		return "AIR";
	}
	public String getPrise(List<String> Prises, List<Integer> Chances, int chanc){
		for(int i=0;i<Prises.size();i++){
			if(chanc<=Chances.get(i)){
				chanc=-1;
				return Prises.get(i);
			}else{
				for(int o=0;o<Chances.size();o++){
					Chances.set(o, Chances.get(o)+Chances.get(i));
				}
			}
		}
		return "AIR";
	}
	public void setCase(String Name){
		List<String> list=plugin.getConfig().getStringList("Cases.names");
		for(int i=0;i<list.size();i++){
			if(list.get(i)==Name){
				plugin.getConfig().set(namePlayer+"."+nameCase, 0);
				this.nameCase=Name;
				plugin.getConfig().set(namePlayer+"."+nameCase, amount);
				return;
			}
		}
		
	}
	public void setChance(int Chance){
		if(Chance>=0&&Chance<101){
			this.chance=Chance;
		}
		plugin.getConfig().set(namePlayer+"."+nameCase+".chance", chance);
	}
	public void setPlayer(Player p){
		plugin.getConfig().set(namePlayer+"."+nameCase, 0);
		this.namePlayer=p.getName();
		plugin.getConfig().set(namePlayer+"."+nameCase, amount);
	}
	public void setPlayer(String p){
		plugin.getConfig().set(namePlayer+"."+nameCase, 0);
		this.namePlayer=p;
		plugin.getConfig().set(namePlayer+"."+nameCase, amount);
	}
	public int getChance(){
		return chance;
	}
	public int rChance(){
		return (int)Math.random()*101;
	}
}
