package ru.BossWars.tp;

import java.util.Timer;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;


import ru.BossWars.inGame.inGame;
import ru.BossWars.main.BossWars;

public class toTp {
	static Timer t;
	static Player p;
	static int i;
	static String arena;
	public static  void toGame(){
		i = 16;
		Bukkit.getScheduler().runTaskTimer(BossWars.plugin, new Runnable() {
			  @Override
			  public void run() {
				  int b = BossWars.players.size();
					for(int o=0;o<b;o++){
						p = BossWars.players.get(o);
						p.setLevel(i-1);
						if(i<=3)p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
						else p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
						}i--;
						if(i==0){
						arena = BossWars.arenas.get((int) (Math.random()*BossWars.arenas.size()));
						String world = "BWArena";
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mw create BWArena");
						t.schedule(inGame.tms, 100);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mw load BWArena");
						t.schedule(inGame.tms, 3000);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "scload load BossWars/"+arena+" BWArena "+BossWars.spn.getDouble(arena+".forSet.x")+" "+BossWars.spn.getDouble(arena+".forSet.y")+" "+BossWars.spn.getDouble(arena+".forSet.z"));
						Pos spr = new Pos(world,BossWars.spn.getDouble(arena + ".players.red.x"), BossWars.spn.getDouble(arena + ".players.red.y"), BossWars.spn.getDouble(arena + ".players.red.z"));
						Pos sbr = new Pos(world,BossWars.spn.getDouble(arena + ".bosses.red.x"), BossWars.spn.getDouble(arena + ".bosses.red.y"), BossWars.spn.getDouble(arena + ".bosses.red.z"));
						Pos spb = new Pos(world,BossWars.spn.getDouble(arena + ".players.blue.x"), BossWars.spn.getDouble(arena + ".players.blue.y"), BossWars.spn.getDouble(arena + ".players.blue.z"));
						Pos sbb = new Pos(world,BossWars.spn.getDouble(arena + ".bosses.blue.x"), BossWars.spn.getDouble(arena + ".bosses.blue.y"), BossWars.spn.getDouble(arena + ".bosses.blue.z"));
						Pos smr = new Pos(world, BossWars.spn.getDouble(arena + ".mobs.red.x"), BossWars.spn.getDouble(arena + ".mobs.red.y"), BossWars.spn.getDouble(arena + ".mobs.red.z"));
						Pos smb = new Pos(world, BossWars.spn.getDouble(arena + ".mobs.blue.x"), BossWars.spn.getDouble(arena + ".mobs.blue.y"), BossWars.spn.getDouble(arena + ".mobs.blue.z"));
						inGame.Game(BossWars.players, BossWars.comRed, BossWars.comBlue, spr, spb, sbr, sbb, smr, smb);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mw unload BWArena");
						t.schedule(inGame.tms, 3000);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mw delete BWArena");
						t.schedule(inGame.tms, 100);
						return;
					}
			  }
			}, (long) 1, (long) 1000);
	}

		public static void tp(Pos spr, Pos spb) {
			for(int i = 0;i<BossWars.comRed.size();i++){
				tp.toLobby(spr, BossWars.comRed.get(i));
				BossWars.comRed.get(i).sendMessage("Выбрана арена "+arena);
			}
			for(int i = 0;i<BossWars.comBlue.size();i++){
				tp.toLobby(spb, BossWars.comBlue.get(i));
				BossWars.comBlue.get(i).sendMessage("Выбрана арена "+arena);
			}BossWars.inGame=true;
			
		}
	}

