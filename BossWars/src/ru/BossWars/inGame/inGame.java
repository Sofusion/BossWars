package ru.BossWars.inGame;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ru.BossWars.main.BossWars;
import ru.BossWars.tp.Pos;
import ru.BossWars.tp.toTp;

public class inGame implements Listener{
	
	static int i;
	static Timer t;
	static Timer s;
	static List<Player> pls;
	static List<Player> Red;
	static List<Player> Blue;
	static Pos sr;
	static Pos sb;
	static Pos mr;
	static Pos mb;
	static int b=0;
	static boolean boss1=false;
	static boolean boos2=false;
	static boolean boos3=false;
	public static TimerTask tms = new TimerTask() {
		
		@Override
		public void run() {
			
		}
	};
	static TimerTask tm = new TimerTask() {
		public void run() {
			Bukkit.getServer().getWorld(mr.worldName).setTime(6000);;
			int b = BossWars.players.size();
			for(int o=0;o<b;o++){
				Player p = BossWars.players.get(o);
				p.setLevel(i-1);
				if(i<=3)p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
				else p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1, 1);
				}i--;
				if(i==99|i==199|i==299|i==399|i==499|i==599|i==699|i==799){
					for(int o=0;o<pls.size();o++){
						pls.get(o).sendMessage("До начала спауна боссов "+((i+1)/100)+" минут.");
					}
					i=i-39;
				}
				if(i%3==0){
					World world = Bukkit.getServer().getWorld(mr.worldName);
					Location loc = new Location(world, mr.x, mr.y, mr.z);
					LivingEntity l = (LivingEntity) world.spawnEntity(loc, EntityType.ZOMBIE);
					l.setCustomName(ChatColor.RED+"Слабый враг");
					l.setCustomNameVisible(true);
					l.setCanPickupItems(false);
					l.setHealth(15);
					l.setMaxHealth(15);
					l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5000, 1));
				}
				if(i%3==0){
					World world = Bukkit.getServer().getWorld(mr.worldName);
					Location loc = new Location(world, mb.x, mb.y, mb.z);
					LivingEntity l = (LivingEntity) world.spawnEntity(loc, EntityType.ZOMBIE);
					l.setCustomName(ChatColor.BLUE+"Слабый враг");
					l.setCustomNameVisible(true);
					l.setCanPickupItems(false);
					l.setHealth(15);
					l.setMaxHealth(15);
					l.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5000, 1));
				}
				if(i%8==0){
					World world = Bukkit.getServer().getWorld(mr.worldName);
					Location loc = new Location(world, mb.x, mb.y, mb.z);
					LivingEntity l = (LivingEntity) world.spawnEntity(loc, EntityType.ZOMBIE);
					l.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SWORD));
					ItemStack ch = new ItemStack(Material.LEATHER_CHESTPLATE);
					ch.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					l.setCustomName(ChatColor.BLUE+"Враг");
					l.setCustomNameVisible(true);
					l.getEquipment().setChestplate(ch);
					l.getEquipment().setChestplateDropChance(0);
					l.getEquipment().setItemInHandDropChance(0);
					l.setCustomName(ChatColor.RED+"Red");
					l.setCustomNameVisible(true);
					l.setCanPickupItems(false);
					l.setHealth(25);
					l.setMaxHealth(25);
				}
				if(i%8==0){
					World world = Bukkit.getServer().getWorld(mr.worldName);
					Location loc = new Location(world, mr.x, mr.y, mr.z);
					LivingEntity l = (LivingEntity) world.spawnEntity(loc, EntityType.ZOMBIE);
					l.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SWORD));
					ItemStack ch = new ItemStack(Material.LEATHER_CHESTPLATE);
					ch.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					l.setCustomName(ChatColor.RED+"Враг");
					l.setCustomNameVisible(true);
					l.getEquipment().setChestplate(ch);
					l.getEquipment().setChestplateDropChance(0);
					l.getEquipment().setItemInHandDropChance(0);
					l.setCustomName(ChatColor.RED+"Red");
					l.setCustomNameVisible(true);
					l.setCanPickupItems(false);
					l.setHealth(25);
					l.setMaxHealth(25);
				}
				if(i%15==0){
					World world = Bukkit.getServer().getWorld(mr.worldName);
					Location loc = new Location(world, mr.x, mr.y, mr.z);
					ItemStack sword = new ItemStack(Material.WOOD_SWORD);
					ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
					ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
					ItemStack helmet  =new ItemStack(Material.LEATHER_HELMET);
					helmet.addEnchantment(Enchantment.DURABILITY, 5);
					leggins.addEnchantment(Enchantment.DURABILITY, 5);
					chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
					sword.addEnchantment(Enchantment.DURABILITY, 5);
					LivingEntity l = (LivingEntity) world.spawnEntity(loc, EntityType.ZOMBIE);
					l.setCustomName(ChatColor.RED+"Сильный враг");
					l.setCustomNameVisible(true);
					l.getEquipment().setItemInHand(sword);
					l.getEquipment().setChestplate(chestplate);
					l.getEquipment().setHelmet(helmet);
					l.getEquipment().setLeggings(leggins);
					l.getEquipment().setLeggingsDropChance(0);
					l.getEquipment().setHelmetDropChance(0);
					l.getEquipment().setChestplateDropChance(0);
					l.getEquipment().setItemInHandDropChance(0);
				}
				if(i%15==0){
					World world = Bukkit.getServer().getWorld(mr.worldName);
					Location loc = new Location(world, mb.x, mb.y, mb.z);
					ItemStack sword = new ItemStack(Material.WOOD_SWORD);
					ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
					ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
					ItemStack helmet  =new ItemStack(Material.LEATHER_HELMET);
					helmet.addEnchantment(Enchantment.DURABILITY, 5);
					leggins.addEnchantment(Enchantment.DURABILITY, 5);
					chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
					sword.addEnchantment(Enchantment.DURABILITY, 5);
					LivingEntity l = (LivingEntity) world.spawnEntity(loc, EntityType.ZOMBIE);
					l.setCustomName(ChatColor.BLUE+"Сильный враг");
					l.getEquipment().setItemInHand(sword);
					l.getEquipment().setChestplate(chestplate);
					l.getEquipment().setHelmet(helmet);
					l.getEquipment().setLeggings(leggins);
					l.getEquipment().setLeggingsDropChance(0);
					l.getEquipment().setHelmetDropChance(0);
					l.getEquipment().setChestplateDropChance(0);
					l.getEquipment().setItemInHandDropChance(0);
				}
				if(i%22==0){
					World world = Bukkit.getServer().getWorld(mr.worldName);
					Location loc = new Location(world, mb.x, mb.y, mb.z);
					ItemStack sword = new ItemStack(Material.IRON_SWORD);
					ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
					ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
					ItemStack helmet  =new ItemStack(Material.LEATHER_HELMET);
					ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
					helmet.addEnchantment(Enchantment.DURABILITY, 5);
					leggins.addEnchantment(Enchantment.DURABILITY, 5);
					chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
					sword.addEnchantment(Enchantment.DURABILITY, 5);
					LivingEntity l = (LivingEntity) world.spawnEntity(loc, EntityType.ZOMBIE);
					l.setCustomName(ChatColor.BLUE+"Сильнейший враг");
					l.getEquipment().setBoots(boots);
					l.getEquipment().setItemInHand(sword);
					l.getEquipment().setChestplate(chestplate);
					l.getEquipment().setHelmet(helmet);
					l.getEquipment().setLeggings(leggins);
					l.getEquipment().setBootsDropChance(0);
					l.getEquipment().setLeggingsDropChance(0);
					l.getEquipment().setHelmetDropChance(0);
					l.getEquipment().setChestplateDropChance(0);
					l.getEquipment().setItemInHandDropChance(0);
				}
				if(i%22==0){
					World world = Bukkit.getServer().getWorld(mr.worldName);
					Location loc = new Location(world, mr.x, mr.y, mr.z);
					ItemStack sword = new ItemStack(Material.IRON_SWORD);
					ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
					ItemStack leggins = new ItemStack(Material.LEATHER_LEGGINGS);
					ItemStack helmet  =new ItemStack(Material.LEATHER_HELMET);
					ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
					helmet.addEnchantment(Enchantment.DURABILITY, 5);
					leggins.addEnchantment(Enchantment.DURABILITY, 5);
					chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
					sword.addEnchantment(Enchantment.DURABILITY, 5);
					LivingEntity l = (LivingEntity) world.spawnEntity(loc, EntityType.ZOMBIE);
					l.setCustomName(ChatColor.RED+"Сильнейший враг");
					l.getEquipment().setBoots(boots);
					l.getEquipment().setItemInHand(sword);
					l.getEquipment().setChestplate(chestplate);
					l.getEquipment().setHelmet(helmet);
					l.getEquipment().setLeggings(leggins);
					l.getEquipment().setBootsDropChance(0);
					l.getEquipment().setLeggingsDropChance(0);
					l.getEquipment().setHelmetDropChance(0);
					l.getEquipment().setChestplateDropChance(0);
					l.getEquipment().setItemInHandDropChance(0);
				}
				if(i%15==0){
					World world = Bukkit.getServer().getWorld(mr.worldName);
					Location loc = new Location(world, mr.x, mr.y, mr.z);
					ItemStack bow = new ItemStack(Material.BOW);
					ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
					chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					chestplate.addEnchantment(Enchantment.DURABILITY, 5);
					bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
					bow.addEnchantment(Enchantment.DURABILITY, 5);
					LivingEntity l = (LivingEntity) world.spawnEntity(loc, EntityType.SKELETON);
					l.setCustomName(ChatColor.RED+"Стрелок");
					l.setCustomNameVisible(true);
					l.getEquipment().setItemInHand(bow);
					l.getEquipment().setChestplate(chestplate);
					l.getEquipment().setChestplateDropChance(0);
					l.getEquipment().setItemInHandDropChance(0);
				}
				if(i%15==0){
					World world = Bukkit.getServer().getWorld(mr.worldName);
					Location loc = new Location(world, mb.x, mb.y, mb.z);
					ItemStack bow = new ItemStack(Material.BOW);
					ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
					chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					chestplate.addEnchantment(Enchantment.DURABILITY, 5);
					bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
					bow.addEnchantment(Enchantment.DURABILITY, 5);
					LivingEntity l = (LivingEntity) world.spawnEntity(loc, EntityType.SKELETON);
					l.setCustomName(ChatColor.BLUE+"Стрелок");
					l.setCustomNameVisible(true);
					l.getEquipment().setItemInHand(bow);
					l.getEquipment().setChestplate(chestplate);
					l.getEquipment().setChestplateDropChance(0);
					l.getEquipment().setItemInHandDropChance(0);
				}
		}
	};
	public static void Game(List<Player> pl, List<Player> comRed, List<Player> comBlue, Pos spr, Pos spb, Pos sbr, Pos sbb, Pos smr, Pos smb){
		if(!(BossWars.inGame)){
			return;
		}
		sr=spr;
		sb=spb;
		pls=pl;
		mr=smr;
		mb=smb;
		Red=comRed;
		Blue=comBlue;
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory true");
		for(int i=0;i<1;i++){
			World world = Bukkit.getWorld(spr.worldName);
			Location loc1 = new Location(world, spr.x-2, spr.y-1, spr.z-2);
			Location loc2 = new Location(world, spr.x+2, spr.y+3, spr.z+2);
			for(double x= loc1.getX();x<loc2.getX();x++){
				for(double y=loc1.getY();y<loc2.getY();y++){
					for(double z=loc1.getZ();z<loc2.getZ();z++){
						loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.GLASS);
					}
				}
			}
			loc1 = new Location(world, spr.x-1,spr.y,spr.z-1);
			loc2 = new Location(world, spr.x+1, spr.y+2, spr.z+1);
			for(double x= loc1.getX();x<loc2.getX();x++){
				for(double y=loc1.getY();y<loc2.getY();y++){
					for(double z=loc1.getZ();z<loc2.getZ();z++){
						loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.AIR);
					}
				}
			}
		}
		for(int i=0;i<1;i++){
			World world = Bukkit.getWorld(spb.worldName);
			Location loc1 = new Location(world, spb.x-2, spb.y-1, spb.z-2);
			Location loc2 = new Location(world, spb.x+2, spb.y+3, spb.z+2);
			for(double x= loc1.getX();x<loc2.getX();x++){
				for(double y=loc1.getY();y<loc2.getY();y++){
					for(double z=loc1.getZ();z<loc2.getZ();z++){
						loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.GLASS);
					}
				}
			}
			loc1 = new Location(world, spb.x-1,spb.y,spb.z-1);
			loc2 = new Location(world, spb.x+1, spb.y+2, spb.z+1);
			for(double x= loc1.getX();x<loc2.getX();x++){
				for(double y=loc1.getY();y<loc2.getY();y++){
					for(double z=loc1.getZ();z<loc2.getZ();z++){
						loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.AIR);
					}
				}
			}
		}
		toTp.tp(spr, spb);
		i=5;
		t.schedule(tm, 1, 1000);
		for(int i=0;i<1;i++){
			World world = Bukkit.getWorld(spr.worldName);
			Location loc1 = new Location(world, spr.x-2, spr.y-1, spr.z-2);
			Location loc2 = new Location(world, spr.x+2, spr.y+3, spr.z+2);
			for(double x= loc1.getX();x<loc2.getX();x++){
				for(double y=loc1.getY();y<loc2.getY();y++){
					for(double z=loc1.getZ();z<loc2.getZ();z++){
						loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.AIR);
					}
				}
			}
		}
		for(int i=0;i<1;i++){
			World world = Bukkit.getWorld(spb.worldName);
			Location loc1 = new Location(world, spb.x-2, spb.y-1, spb.z-2);
			Location loc2 = new Location(world, spb.x+2, spb.y+3, spb.z+2);
			for(double x= loc1.getX();x<loc2.getX();x++){
				for(double y=loc1.getY();y<loc2.getY();y++){
					for(double z=loc1.getZ();z<loc2.getZ();z++){
						loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.AIR);
					}
				}
			}
		}
		for(i=0;i<pl.size();i++){
			pl.get(i).sendMessage("До начала спауна боссов 8 минут!");
		}
		i=800;
		t.schedule(tm, 1, 1000);
		comRed=Red;
		comBlue=Blue;
		pl=pls;
		for(i=0;i<pl.size();i++){
			pl.get(i).sendMessage("До начала спауна боссов пару секунд!");
		}
		for(int i=0;i<1;i++){
			World world = Bukkit.getServer().getWorld(sbr.worldName);
			Location loc = new Location(world, sbr.x, sbr.y, sbr.z);
			LivingEntity l = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
			ItemStack helmet = new ItemStack(Material.GOLD_HELMET);
			ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
			ItemStack leggins = new ItemStack(Material.GOLD_LEGGINGS);
			ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
			ItemStack sword = new ItemStack(Material.IRON_SWORD);
			helmet.addEnchantment(Enchantment.DURABILITY, 5);
			leggins.addEnchantment(Enchantment.DURABILITY, 5);
			boots.addEnchantment(Enchantment.DURABILITY, 5);
			chestplate.addEnchantment(Enchantment.DURABILITY, 5);
			sword.addEnchantment(Enchantment.DURABILITY, 5);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			leggins.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			helmet.addEnchantment(Enchantment.WATER_WORKER, 2);
			chestplate.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
			boots.addEnchantment(Enchantment.FIRE_ASPECT, 1);
			sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			l.getEquipment().setChestplate(chestplate);
			l.getEquipment().setHelmet(helmet);
			l.getEquipment().setBoots(boots);
			l.getEquipment().setItemInHand(sword);
			l.getEquipment().setLeggings(leggins);
			l.setMaxHealth(50);
			l.setHealth(50);
			l.setCustomName(ChatColor.RED+"Первый Босс");
			l.setCustomNameVisible(true);
			l.getEquipment().setBootsDropChance(100);
			l.getEquipment().setChestplateDropChance(100);
			l.getEquipment().setHelmetDropChance(100);
			l.getEquipment().setItemInHandDropChance(100);
			l.getEquipment().setLeggingsDropChance(100);
			for(int b=0;b<Blue.size();b++){
				Red.get(i).sendMessage("Первый Босс заспаунился");
			}
		}
		for(int i=0;i<1;i++){
			World world = Bukkit.getServer().getWorld(sbb.worldName);
			Location loc = new Location(world, sbb.x, sbb.y, sbb.z);
			LivingEntity l = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
			ItemStack helmet = new ItemStack(Material.GOLD_HELMET);
			ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
			ItemStack leggins = new ItemStack(Material.GOLD_LEGGINGS);
			ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
			ItemStack sword = new ItemStack(Material.IRON_SWORD);
			helmet.addEnchantment(Enchantment.DURABILITY, 5);
			leggins.addEnchantment(Enchantment.DURABILITY, 5);
			boots.addEnchantment(Enchantment.DURABILITY, 5);
			chestplate.addEnchantment(Enchantment.DURABILITY, 5);
			sword.addEnchantment(Enchantment.DURABILITY, 5);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			leggins.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			helmet.addEnchantment(Enchantment.WATER_WORKER, 2);
			chestplate.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
			boots.addEnchantment(Enchantment.FIRE_ASPECT, 1);
			sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			l.getEquipment().setChestplate(chestplate);
			l.getEquipment().setHelmet(helmet);
			l.getEquipment().setBoots(boots);
			l.getEquipment().setItemInHand(sword);
			l.getEquipment().setLeggings(leggins);
			l.setMaxHealth(50);
			l.setHealth(50);
			l.setCustomName(ChatColor.BLUE+"Первый Босс");
			l.setCustomNameVisible(true);
			l.getEquipment().setBootsDropChance(100);
			l.getEquipment().setChestplateDropChance(100);
			l.getEquipment().setHelmetDropChance(100);
			l.getEquipment().setItemInHandDropChance(100);
			l.getEquipment().setLeggingsDropChance(100);
			for(int b=0;b<Blue.size();b++){
				Blue.get(i).sendMessage("Первый Босс заспаунился");
			}
		}
	}
	public void onDeath(PlayerDeathEvent e){
		if(!(BossWars.inGame)){
			return;
		}
		for(int i=0;i<e.getDrops().size();i++){
			e.getDrops().get(i).setType(Material.AIR);
		}
		Player p = e.getEntity();
		if(pls.contains(p)){
			if(Red.contains(p)){
				World world = Bukkit.getServer().getWorld(sr.worldName);
				p.setHealth(20.0);
				p.teleport(new Location(world, sr.x, sr.y, sr.z));
				for(int i=0;i<36;i++){
					if(p.getInventory().getItem(i).getType()==Material.BRICK){
						p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i));
						p.getInventory().setItem(i, new ItemStack(Material.AIR));
					}
					if(p.getInventory().getItem(i).getType()==Material.IRON_INGOT){
						p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i));
						p.getInventory().setItem(i, new ItemStack(Material.AIR));
					}
					if(p.getInventory().getItem(i).getType()==Material.GOLD_INGOT){
						p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i));
						p.getInventory().setItem(i, new ItemStack(Material.AIR));
					}
					if(p.getInventory().getItem(i).getType()==Material.DIAMOND){
						p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i));
						p.getInventory().setItem(i, new ItemStack(Material.AIR));
					}
					if(p.getInventory().getItem(i).getType()==Material.EMERALD){
						p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i));
						p.getInventory().setItem(i, new ItemStack(Material.AIR));
					}
				}
			}
			if(Blue.contains(p)){
				World world = Bukkit.getServer().getWorld(sb.worldName);
				p.setHealth(20.0);
				p.teleport(new Location(world, sb.x, sb.y, sb.z));
				for(int i=0;i<36;i++){
					if(p.getInventory().getItem(i).getType()==Material.BRICK){
						p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i));
						p.getInventory().setItem(i, new ItemStack(Material.AIR));
					}
					if(p.getInventory().getItem(i).getType()==Material.IRON_INGOT){
						p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i));
						p.getInventory().setItem(i, new ItemStack(Material.AIR));
					}
					if(p.getInventory().getItem(i).getType()==Material.GOLD_INGOT){
						p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i));
						p.getInventory().setItem(i, new ItemStack(Material.AIR));
					}
					if(p.getInventory().getItem(i).getType()==Material.DIAMOND){
						p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i));
						p.getInventory().setItem(i, new ItemStack(Material.AIR));
					}
					if(p.getInventory().getItem(i).getType()==Material.EMERALD){
						p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i));
						p.getInventory().setItem(i, new ItemStack(Material.AIR));
					}
				}
			}
		}
	}
	public void onBossDeath(EntityDeathEvent e){
		LivingEntity l = e.getEntity();
		if(l.getCustomName()==ChatColor.BLUE+"Первый Босс"){
			for(int i=0;i<Blue.size();i++){
				Blue.get(i).sendMessage(ChatColor.GREEN+"Вы победили первого босса, поздравляем!!!\nУ вас есть 60 секунд, чтобы подготовиться к следущему.");
			}
			if(!boss1){
				for(int i=0;i<Red.size();i++){
					Red.get(i).sendMessage(ChatColor.RED+"Вас обогнали Синие в убийстве первого босса!");
				}
			}
			boss1=true;
			t.schedule(tm, 60000);
			for(int i=0;i<1;i++){
				World world = Bukkit.getServer().getWorld(sb.worldName);
				Location loc = new Location(world, sb.x, sb.y, sb.z);
				LivingEntity le = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
				ItemStack helmet = new ItemStack(Material.IRON_HELMET);
				ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemStack leggins = new ItemStack(Material.IRON_LEGGINGS);
				ItemStack boots = new ItemStack(Material.IRON_BOOTS);
				ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
				helmet.addEnchantment(Enchantment.DURABILITY, 5);
				leggins.addEnchantment(Enchantment.DURABILITY, 5);
				boots.addEnchantment(Enchantment.DURABILITY, 5);
				chestplate.addEnchantment(Enchantment.DURABILITY, 5);
				sword.addEnchantment(Enchantment.DURABILITY, 5);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				leggins.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				helmet.addEnchantment(Enchantment.WATER_WORKER, 2);
				chestplate.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
				boots.addEnchantment(Enchantment.FIRE_ASPECT, 1);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
				le.getEquipment().setChestplate(chestplate);
				le.getEquipment().setHelmet(helmet);
				le.getEquipment().setBoots(boots);
				le.getEquipment().setItemInHand(sword);
				le.getEquipment().setLeggings(leggins);
				le.setMaxHealth(80);
				le.setHealth(80);
				le.setCustomName(ChatColor.BLUE+"Второй Босс");
				le.setCustomNameVisible(true);
				le.getEquipment().setBootsDropChance(100);
				le.getEquipment().setChestplateDropChance(100);
				le.getEquipment().setHelmetDropChance(100);
				le.getEquipment().setItemInHandDropChance(100);
				le.getEquipment().setLeggingsDropChance(100);
				le.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1, 25000));
				for(int b=0;b<Blue.size();b++){
					Red.get(i).sendMessage("Второй Босс заспаунился");
				}
			}
		}
		if(l.getCustomName()==ChatColor.BLUE+"Второй Босс"){
			for(int i=0;i<Blue.size();i++){
				Blue.get(i).sendMessage(ChatColor.GREEN+"Вы победили второго босса, поздравляем!!!\nУ вас есть 60 секунд, чтобы подготовиться к следущему.");
			}
			if(!boss1){
				for(int i=0;i<Red.size();i++){
					Red.get(i).sendMessage(ChatColor.RED+"Вас обогнали Синие в убийстве второго босса!");
				}
			}
			boss1=true;
			t.schedule(tm, 60000);
			for(int i=0;i<1;i++){
				World world = Bukkit.getServer().getWorld(sb.worldName);
				Location loc = new Location(world, sb.x, sb.y, sb.z);
				LivingEntity le = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.WITHER);
				ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
				ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemStack leggins = new ItemStack(Material.DIAMOND_LEGGINGS);
				ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
				ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
				helmet.addEnchantment(Enchantment.DURABILITY, 5);
				leggins.addEnchantment(Enchantment.DURABILITY, 5);
				boots.addEnchantment(Enchantment.DURABILITY, 5);
				chestplate.addEnchantment(Enchantment.DURABILITY, 5);
				sword.addEnchantment(Enchantment.DURABILITY, 5);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				leggins.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				helmet.addEnchantment(Enchantment.WATER_WORKER, 2);
				chestplate.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
				boots.addEnchantment(Enchantment.FIRE_ASPECT, 1);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
				le.getEquipment().setChestplate(chestplate);
				le.getEquipment().setHelmet(helmet);
				le.getEquipment().setBoots(boots);
				le.getEquipment().setItemInHand(sword);
				le.getEquipment().setLeggings(leggins);
				le.setMaxHealth(80);
				le.setHealth(80);
				le.setCustomName(ChatColor.BLUE+"Сложнейший Босс");
				le.setCustomNameVisible(true);
				le.getEquipment().setBootsDropChance(100);
				le.getEquipment().setChestplateDropChance(100);
				le.getEquipment().setHelmetDropChance(100);
				le.getEquipment().setItemInHandDropChance(100);
				le.getEquipment().setLeggingsDropChance(100);
				le.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3, 25000));
				for(int b=0;b<Blue.size();b++){
					Red.get(i).sendMessage("Сложнейший Босс заспаунился");
				}
			}
		}
		if(l.getCustomName()==ChatColor.BLUE+"Сложнейший Босс"){
			if(!boos3){
				for(int b=0;b<Blue.size();b++){
					Blue.get(i).sendMessage("Вы победили!!!");
				}
				for(int b=0;b<Red.size();b++){
					Red.get(b).sendMessage(ChatColor.RED+"Вы проиграли.");
				}
				t.schedule(tms, 5000);
				for(int b=0;b<pls.size();b++){
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"spawn "+pls.get(i).getName());
				}BossWars.inGame=false;
			}
		}
		if(l.getCustomName()==ChatColor.RED+"Первый Босс"){
			for(int i=0;i<Red.size();i++){
				Red.get(i).sendMessage(ChatColor.GREEN+"Вы победили первого босса, поздравляем!!!\nУ вас есть 60 секунд, чтобы подготовиться к следущему.");
			}
			if(!boos2){
				for(int i=0;i<Blue.size();i++){
					Blue.get(i).sendMessage(ChatColor.RED+"Вас обогнали Красные в убийстве первого босса!");
				}
			}
			boos2=true;
			t.schedule(tm, 60000);
			for(int i=0;i<1;i++){
				World world = Bukkit.getServer().getWorld(sr.worldName);
				Location loc = new Location(world, sr.x, sr.y, sr.z);
				LivingEntity le = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
				ItemStack helmet = new ItemStack(Material.IRON_HELMET);
				ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemStack leggins = new ItemStack(Material.IRON_LEGGINGS);
				ItemStack boots = new ItemStack(Material.IRON_BOOTS);
				ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
				helmet.addEnchantment(Enchantment.DURABILITY, 5);
				leggins.addEnchantment(Enchantment.DURABILITY, 5);
				boots.addEnchantment(Enchantment.DURABILITY, 5);
				chestplate.addEnchantment(Enchantment.DURABILITY, 5);
				sword.addEnchantment(Enchantment.DURABILITY, 5);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				leggins.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				helmet.addEnchantment(Enchantment.WATER_WORKER, 2);
				chestplate.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
				boots.addEnchantment(Enchantment.FIRE_ASPECT, 1);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
				le.getEquipment().setChestplate(chestplate);
				le.getEquipment().setHelmet(helmet);
				le.getEquipment().setBoots(boots);
				le.getEquipment().setItemInHand(sword);
				le.getEquipment().setLeggings(leggins);
				le.setMaxHealth(80);
				le.setHealth(80);
				le.setCustomName(ChatColor.RED+"Первый Босс");
				le.setCustomNameVisible(true);
				le.getEquipment().setBootsDropChance(100);
				le.getEquipment().setChestplateDropChance(100);
				le.getEquipment().setHelmetDropChance(100);
				le.getEquipment().setItemInHandDropChance(100);
				le.getEquipment().setLeggingsDropChance(100);
				le.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1, 25000));
				for(int b=0;b<Blue.size();b++){
					Blue.get(i).sendMessage("Второй Босс заспаунился");
				}
			}
		}
		if(l.getCustomName()==ChatColor.RED+"Второй Босс"){
			for(int i=0;i<Blue.size();i++){
				Blue.get(i).sendMessage(ChatColor.GREEN+"Вы победили второго босса, поздравляем!!!\nУ вас есть 60 секунд, чтобы подготовиться к следущему.");
			}
			if(!boos2){
				for(int i=0;i<Red.size();i++){
					Red.get(i).sendMessage(ChatColor.RED+"Вас обогнали Красные в убийстве второго босса!");
				}
			}
			boos2=true;
			t.schedule(tm, 60000);
			for(int i=0;i<1;i++){
				World world = Bukkit.getServer().getWorld(sr.worldName);
				Location loc = new Location(world, sr.x, sr.y, sb.z);
				LivingEntity le = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.WITHER);
				ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
				ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemStack leggins = new ItemStack(Material.DIAMOND_LEGGINGS);
				ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
				helmet.addEnchantment(Enchantment.DURABILITY, 5);
				leggins.addEnchantment(Enchantment.DURABILITY, 5);
				boots.addEnchantment(Enchantment.DURABILITY, 5);
				chestplate.addEnchantment(Enchantment.DURABILITY, 5);
				helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				leggins.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				helmet.addEnchantment(Enchantment.WATER_WORKER, 2);
				chestplate.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
				boots.addEnchantment(Enchantment.FIRE_ASPECT, 1);
				le.getEquipment().setChestplate(chestplate);
				le.getEquipment().setHelmet(helmet);
				le.getEquipment().setBoots(boots);
				le.getEquipment().setLeggings(leggins);
				le.setMaxHealth(80);
				le.setHealth(80);
				le.setCustomName(ChatColor.RED+"Сложнейший Босс");
				le.setCustomNameVisible(true);
				le.getEquipment().setBootsDropChance(100);
				le.getEquipment().setChestplateDropChance(100);
				le.getEquipment().setHelmetDropChance(100);
				le.getEquipment().setItemInHandDropChance(100);
				le.getEquipment().setLeggingsDropChance(100);
				le.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3, 25000));
				for(int b=0;b<Red.size();b++){
					Red.get(i).sendMessage("Сложнейший Босс заспаунился");
				}
			}
		}
		if(l.getCustomName()==ChatColor.RED+"Сложнейший Босс"){
			if(!boos3){
				for(int b=0;b<Red.size();b++){
					Red.get(b).sendMessage(ChatColor.GREEN+"Вы победили!!!");
				}
				for(int b=0;b<Blue.size();b++){
					Blue.get(b).sendMessage(ChatColor.RED+"Вы проиграли.");
				}
				t.schedule(tms, 5000);
				for(int b=0;b<pls.size();b++){
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"spawn "+Red.get(b).getName());
				}BossWars.inGame=false;
			}
		}
	}	
}