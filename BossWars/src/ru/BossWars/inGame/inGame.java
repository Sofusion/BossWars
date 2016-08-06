/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.command.CommandSender
 *  org.bukkit.enchantments.Enchantment
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Item
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.EntityDeathEvent
 *  org.bukkit.event.entity.PlayerDeathEvent
 *  org.bukkit.inventory.EntityEquipment
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 */
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
import org.bukkit.command.CommandSender;
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

public class inGame
implements Listener {
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
    static int b;
    static boolean boss1;
    static boolean boos2;
    static boolean boos3;
    public static TimerTask tms;
    static TimerTask tm;

    static {
        b = 0;
        boss1 = false;
        boos2 = false;
        boos3 = false;
        tms = new TimerTask(){

            @Override
            public void run() {
            }
        };
        tm = new TimerTask(){

            @Override
            public void run() {
                ItemStack boots;
                LivingEntity l;
                ItemStack bow;
                ItemStack helmet;
                ItemStack ch;
                LivingEntity l2;
                Location loc;
                ItemStack leggins;
                LivingEntity l3;
                ItemStack sword;
                ItemStack chestplate;
                LivingEntity l4;
                Bukkit.getServer().getWorld(inGame.mr.worldName).setTime(6000);
                int b = BossWars.players.size();
                int o = 0;
                while (o < b) {
                    Player p = BossWars.players.get(o);
                    p.setLevel(inGame.i - 1);
                    if (inGame.i <= 3) {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                    } else {
                        p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 1.0f);
                    }
                    ++o;
                }
                if (--inGame.i == 99 | inGame.i == 199 | inGame.i == 299 | inGame.i == 399 | inGame.i == 499 | inGame.i == 599 | inGame.i == 699 | inGame.i == 799) {
                    o = 0;
                    while (o < inGame.pls.size()) {
                        inGame.pls.get(o).sendMessage("\u0414\u043e \u043d\u0430\u0447\u0430\u043b\u0430 \u0441\u043f\u0430\u0443\u043d\u0430 \u0431\u043e\u0441\u0441\u043e\u0432 " + (inGame.i + 1) / 100 + " \u043c\u0438\u043d\u0443\u0442.");
                        ++o;
                    }
                    inGame.i -= 39;
                }
                if (inGame.i % 3 == 0) {
                    World world = Bukkit.getServer().getWorld(inGame.mr.worldName);
                    loc = new Location(world, inGame.mr.x, inGame.mr.y, inGame.mr.z);
                    l4 = (LivingEntity)world.spawnEntity(loc, EntityType.ZOMBIE);
                    l4.setCustomName((Object)ChatColor.RED + "\u0421\u043b\u0430\u0431\u044b\u0439 \u0432\u0440\u0430\u0433");
                    l4.setCustomNameVisible(true);
                    l4.setCanPickupItems(false);
                    l4.setHealth(15.0);
                    l4.setMaxHealth(15.0);
                    l4.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5000, 1));
                }
                if (inGame.i % 3 == 0) {
                    World world = Bukkit.getServer().getWorld(inGame.mr.worldName);
                    loc = new Location(world, inGame.mb.x, inGame.mb.y, inGame.mb.z);
                    l4 = (LivingEntity)world.spawnEntity(loc, EntityType.ZOMBIE);
                    l4.setCustomName((Object)ChatColor.BLUE + "\u0421\u043b\u0430\u0431\u044b\u0439 \u0432\u0440\u0430\u0433");
                    l4.setCustomNameVisible(true);
                    l4.setCanPickupItems(false);
                    l4.setHealth(15.0);
                    l4.setMaxHealth(15.0);
                    l4.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5000, 1));
                }
                if (inGame.i % 8 == 0) {
                    World world = Bukkit.getServer().getWorld(inGame.mr.worldName);
                    loc = new Location(world, inGame.mb.x, inGame.mb.y, inGame.mb.z);
                    l4 = (LivingEntity)world.spawnEntity(loc, EntityType.ZOMBIE);
                    l4.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SWORD));
                    ch = new ItemStack(Material.LEATHER_CHESTPLATE);
                    ch.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    l4.setCustomName((Object)ChatColor.BLUE + "\u0412\u0440\u0430\u0433");
                    l4.setCustomNameVisible(true);
                    l4.getEquipment().setChestplate(ch);
                    l4.getEquipment().setChestplateDropChance(0.0f);
                    l4.getEquipment().setItemInHandDropChance(0.0f);
                    l4.setCustomName((Object)ChatColor.RED + "Red");
                    l4.setCustomNameVisible(true);
                    l4.setCanPickupItems(false);
                    l4.setHealth(25.0);
                    l4.setMaxHealth(25.0);
                }
                if (inGame.i % 8 == 0) {
                    World world = Bukkit.getServer().getWorld(inGame.mr.worldName);
                    loc = new Location(world, inGame.mr.x, inGame.mr.y, inGame.mr.z);
                    l4 = (LivingEntity)world.spawnEntity(loc, EntityType.ZOMBIE);
                    l4.getEquipment().setItemInHand(new ItemStack(Material.WOOD_SWORD));
                    ch = new ItemStack(Material.LEATHER_CHESTPLATE);
                    ch.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    l4.setCustomName((Object)ChatColor.RED + "\u0412\u0440\u0430\u0433");
                    l4.setCustomNameVisible(true);
                    l4.getEquipment().setChestplate(ch);
                    l4.getEquipment().setChestplateDropChance(0.0f);
                    l4.getEquipment().setItemInHandDropChance(0.0f);
                    l4.setCustomName((Object)ChatColor.RED + "Red");
                    l4.setCustomNameVisible(true);
                    l4.setCanPickupItems(false);
                    l4.setHealth(25.0);
                    l4.setMaxHealth(25.0);
                }
                if (inGame.i % 15 == 0) {
                    World world = Bukkit.getServer().getWorld(inGame.mr.worldName);
                    loc = new Location(world, inGame.mr.x, inGame.mr.y, inGame.mr.z);
                    sword = new ItemStack(Material.WOOD_SWORD);
                    chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                    leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                    helmet = new ItemStack(Material.LEATHER_HELMET);
                    helmet.addEnchantment(Enchantment.DURABILITY, 5);
                    leggins.addEnchantment(Enchantment.DURABILITY, 5);
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                    sword.addEnchantment(Enchantment.DURABILITY, 5);
                    l = (LivingEntity)world.spawnEntity(loc, EntityType.ZOMBIE);
                    l.setCustomName((Object)ChatColor.RED + "\u0421\u0438\u043b\u044c\u043d\u044b\u0439 \u0432\u0440\u0430\u0433");
                    l.setCustomNameVisible(true);
                    l.getEquipment().setItemInHand(sword);
                    l.getEquipment().setChestplate(chestplate);
                    l.getEquipment().setHelmet(helmet);
                    l.getEquipment().setLeggings(leggins);
                    l.getEquipment().setLeggingsDropChance(0.0f);
                    l.getEquipment().setHelmetDropChance(0.0f);
                    l.getEquipment().setChestplateDropChance(0.0f);
                    l.getEquipment().setItemInHandDropChance(0.0f);
                }
                if (inGame.i % 15 == 0) {
                    World world = Bukkit.getServer().getWorld(inGame.mr.worldName);
                    loc = new Location(world, inGame.mb.x, inGame.mb.y, inGame.mb.z);
                    sword = new ItemStack(Material.WOOD_SWORD);
                    chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                    leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                    helmet = new ItemStack(Material.LEATHER_HELMET);
                    helmet.addEnchantment(Enchantment.DURABILITY, 5);
                    leggins.addEnchantment(Enchantment.DURABILITY, 5);
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                    sword.addEnchantment(Enchantment.DURABILITY, 5);
                    l = (LivingEntity)world.spawnEntity(loc, EntityType.ZOMBIE);
                    l.setCustomName((Object)ChatColor.BLUE + "\u0421\u0438\u043b\u044c\u043d\u044b\u0439 \u0432\u0440\u0430\u0433");
                    l.getEquipment().setItemInHand(sword);
                    l.getEquipment().setChestplate(chestplate);
                    l.getEquipment().setHelmet(helmet);
                    l.getEquipment().setLeggings(leggins);
                    l.getEquipment().setLeggingsDropChance(0.0f);
                    l.getEquipment().setHelmetDropChance(0.0f);
                    l.getEquipment().setChestplateDropChance(0.0f);
                    l.getEquipment().setItemInHandDropChance(0.0f);
                }
                if (inGame.i % 22 == 0) {
                    World world = Bukkit.getServer().getWorld(inGame.mr.worldName);
                    loc = new Location(world, inGame.mb.x, inGame.mb.y, inGame.mb.z);
                    sword = new ItemStack(Material.IRON_SWORD);
                    chestplate = new ItemStack(Material.IRON_CHESTPLATE);
                    leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                    helmet = new ItemStack(Material.LEATHER_HELMET);
                    boots = new ItemStack(Material.LEATHER_BOOTS);
                    helmet.addEnchantment(Enchantment.DURABILITY, 5);
                    leggins.addEnchantment(Enchantment.DURABILITY, 5);
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                    sword.addEnchantment(Enchantment.DURABILITY, 5);
                    l2 = (LivingEntity)world.spawnEntity(loc, EntityType.ZOMBIE);
                    l2.setCustomName((Object)ChatColor.BLUE + "\u0421\u0438\u043b\u044c\u043d\u0435\u0439\u0448\u0438\u0439 \u0432\u0440\u0430\u0433");
                    l2.getEquipment().setBoots(boots);
                    l2.getEquipment().setItemInHand(sword);
                    l2.getEquipment().setChestplate(chestplate);
                    l2.getEquipment().setHelmet(helmet);
                    l2.getEquipment().setLeggings(leggins);
                    l2.getEquipment().setBootsDropChance(0.0f);
                    l2.getEquipment().setLeggingsDropChance(0.0f);
                    l2.getEquipment().setHelmetDropChance(0.0f);
                    l2.getEquipment().setChestplateDropChance(0.0f);
                    l2.getEquipment().setItemInHandDropChance(0.0f);
                }
                if (inGame.i % 22 == 0) {
                    World world = Bukkit.getServer().getWorld(inGame.mr.worldName);
                    loc = new Location(world, inGame.mr.x, inGame.mr.y, inGame.mr.z);
                    sword = new ItemStack(Material.IRON_SWORD);
                    chestplate = new ItemStack(Material.IRON_CHESTPLATE);
                    leggins = new ItemStack(Material.LEATHER_LEGGINGS);
                    helmet = new ItemStack(Material.LEATHER_HELMET);
                    boots = new ItemStack(Material.LEATHER_BOOTS);
                    helmet.addEnchantment(Enchantment.DURABILITY, 5);
                    leggins.addEnchantment(Enchantment.DURABILITY, 5);
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                    sword.addEnchantment(Enchantment.DURABILITY, 5);
                    l2 = (LivingEntity)world.spawnEntity(loc, EntityType.ZOMBIE);
                    l2.setCustomName((Object)ChatColor.RED + "\u0421\u0438\u043b\u044c\u043d\u0435\u0439\u0448\u0438\u0439 \u0432\u0440\u0430\u0433");
                    l2.getEquipment().setBoots(boots);
                    l2.getEquipment().setItemInHand(sword);
                    l2.getEquipment().setChestplate(chestplate);
                    l2.getEquipment().setHelmet(helmet);
                    l2.getEquipment().setLeggings(leggins);
                    l2.getEquipment().setBootsDropChance(0.0f);
                    l2.getEquipment().setLeggingsDropChance(0.0f);
                    l2.getEquipment().setHelmetDropChance(0.0f);
                    l2.getEquipment().setChestplateDropChance(0.0f);
                    l2.getEquipment().setItemInHandDropChance(0.0f);
                }
                if (inGame.i % 15 == 0) {
                    World world = Bukkit.getServer().getWorld(inGame.mr.worldName);
                    loc = new Location(world, inGame.mr.x, inGame.mr.y, inGame.mr.z);
                    bow = new ItemStack(Material.BOW);
                    chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    chestplate.addEnchantment(Enchantment.DURABILITY, 5);
                    bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
                    bow.addEnchantment(Enchantment.DURABILITY, 5);
                    l3 = (LivingEntity)world.spawnEntity(loc, EntityType.SKELETON);
                    l3.setCustomName((Object)ChatColor.RED + "\u0421\u0442\u0440\u0435\u043b\u043e\u043a");
                    l3.setCustomNameVisible(true);
                    l3.getEquipment().setItemInHand(bow);
                    l3.getEquipment().setChestplate(chestplate);
                    l3.getEquipment().setChestplateDropChance(0.0f);
                    l3.getEquipment().setItemInHandDropChance(0.0f);
                }
                if (inGame.i % 15 == 0) {
                    World world = Bukkit.getServer().getWorld(inGame.mr.worldName);
                    loc = new Location(world, inGame.mb.x, inGame.mb.y, inGame.mb.z);
                    bow = new ItemStack(Material.BOW);
                    chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    chestplate.addEnchantment(Enchantment.DURABILITY, 5);
                    bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
                    bow.addEnchantment(Enchantment.DURABILITY, 5);
                    l3 = (LivingEntity)world.spawnEntity(loc, EntityType.SKELETON);
                    l3.setCustomName((Object)ChatColor.BLUE + "\u0421\u0442\u0440\u0435\u043b\u043e\u043a");
                    l3.setCustomNameVisible(true);
                    l3.getEquipment().setItemInHand(bow);
                    l3.getEquipment().setChestplate(chestplate);
                    l3.getEquipment().setChestplateDropChance(0.0f);
                    l3.getEquipment().setItemInHandDropChance(0.0f);
                }
            }
        };
    }

    public static void Game(List<Player> pl, List<Player> comRed, List<Player> comBlue, Pos spr, Pos spb, Pos sbr, Pos sbb, Pos smr, Pos smb) {
        double x;
        Location loc;
        int b;
        Location loc2;
        ItemStack chestplate;
        double y;
        LivingEntity l;
        World world;
        Location loc1;
        double z;
        ItemStack boots;
        if (!BossWars.inGame) {
            return;
        }
        sr = spr;
        sb = spb;
        pls = pl;
        mr = smr;
        mb = smb;
        Red = comRed;
        Blue = comBlue;
        Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)"gamerule keepInventory true");
        int i = 0;
        while (i < 1) {
            world = Bukkit.getWorld((String)spr.worldName);
            loc1 = new Location(world, spr.x - 2.0, spr.y - 1.0, spr.z - 2.0);
            loc2 = new Location(world, spr.x + 2.0, spr.y + 3.0, spr.z + 2.0);
            x = loc1.getX();
            while (x < loc2.getX()) {
                y = loc1.getY();
                while (y < loc2.getY()) {
                    z = loc1.getZ();
                    while (z < loc2.getZ()) {
                        loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.GLASS);
                        z += 1.0;
                    }
                    y += 1.0;
                }
                x += 1.0;
            }
            loc1 = new Location(world, spr.x - 1.0, spr.y, spr.z - 1.0);
            loc2 = new Location(world, spr.x + 1.0, spr.y + 2.0, spr.z + 1.0);
            x = loc1.getX();
            while (x < loc2.getX()) {
                y = loc1.getY();
                while (y < loc2.getY()) {
                    z = loc1.getZ();
                    while (z < loc2.getZ()) {
                        loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.AIR);
                        z += 1.0;
                    }
                    y += 1.0;
                }
                x += 1.0;
            }
            ++i;
        }
        i = 0;
        while (i < 1) {
            world = Bukkit.getWorld((String)spb.worldName);
            loc1 = new Location(world, spb.x - 2.0, spb.y - 1.0, spb.z - 2.0);
            loc2 = new Location(world, spb.x + 2.0, spb.y + 3.0, spb.z + 2.0);
            x = loc1.getX();
            while (x < loc2.getX()) {
                y = loc1.getY();
                while (y < loc2.getY()) {
                    z = loc1.getZ();
                    while (z < loc2.getZ()) {
                        loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.GLASS);
                        z += 1.0;
                    }
                    y += 1.0;
                }
                x += 1.0;
            }
            loc1 = new Location(world, spb.x - 1.0, spb.y, spb.z - 1.0);
            loc2 = new Location(world, spb.x + 1.0, spb.y + 2.0, spb.z + 1.0);
            x = loc1.getX();
            while (x < loc2.getX()) {
                y = loc1.getY();
                while (y < loc2.getY()) {
                    z = loc1.getZ();
                    while (z < loc2.getZ()) {
                        loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.AIR);
                        z += 1.0;
                    }
                    y += 1.0;
                }
                x += 1.0;
            }
            ++i;
        }
        toTp.tp(spr, spb);
        inGame.i = 5;
        t.schedule(tm, 1, 1000);
        i = 0;
        while (i < 1) {
            world = Bukkit.getWorld((String)spr.worldName);
            loc1 = new Location(world, spr.x - 2.0, spr.y - 1.0, spr.z - 2.0);
            loc2 = new Location(world, spr.x + 2.0, spr.y + 3.0, spr.z + 2.0);
            x = loc1.getX();
            while (x < loc2.getX()) {
                y = loc1.getY();
                while (y < loc2.getY()) {
                    z = loc1.getZ();
                    while (z < loc2.getZ()) {
                        loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.AIR);
                        z += 1.0;
                    }
                    y += 1.0;
                }
                x += 1.0;
            }
            ++i;
        }
        i = 0;
        while (i < 1) {
            world = Bukkit.getWorld((String)spb.worldName);
            loc1 = new Location(world, spb.x - 2.0, spb.y - 1.0, spb.z - 2.0);
            loc2 = new Location(world, spb.x + 2.0, spb.y + 3.0, spb.z + 2.0);
            x = loc1.getX();
            while (x < loc2.getX()) {
                y = loc1.getY();
                while (y < loc2.getY()) {
                    z = loc1.getZ();
                    while (z < loc2.getZ()) {
                        loc2.getWorld().getBlockAt(new Location(loc1.getWorld(), x, y, z)).setType(Material.AIR);
                        z += 1.0;
                    }
                    y += 1.0;
                }
                x += 1.0;
            }
            ++i;
        }
        inGame.i = 0;
        while (inGame.i < pl.size()) {
            pl.get(inGame.i).sendMessage("\u0414\u043e \u043d\u0430\u0447\u0430\u043b\u0430 \u0441\u043f\u0430\u0443\u043d\u0430 \u0431\u043e\u0441\u0441\u043e\u0432 8 \u043c\u0438\u043d\u0443\u0442!");
            ++inGame.i;
        }
        inGame.i = 800;
        t.schedule(tm, 1, 1000);
        comRed = Red;
        comBlue = Blue;
        pl = pls;
        inGame.i = 0;
        while (inGame.i < pl.size()) {
            pl.get(inGame.i).sendMessage("\u0414\u043e \u043d\u0430\u0447\u0430\u043b\u0430 \u0441\u043f\u0430\u0443\u043d\u0430 \u0431\u043e\u0441\u0441\u043e\u0432 \u043f\u0430\u0440\u0443 \u0441\u0435\u043a\u0443\u043d\u0434!");
            ++inGame.i;
        }
        i = 0;
        while (i < 1) {
            world = Bukkit.getServer().getWorld(sbr.worldName);
            loc = new Location(world, sbr.x, sbr.y, sbr.z);
            l = (LivingEntity)loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            ItemStack helmet = new ItemStack(Material.GOLD_HELMET);
            chestplate = new ItemStack(Material.IRON_CHESTPLATE);
            ItemStack leggins = new ItemStack(Material.GOLD_LEGGINGS);
            boots = new ItemStack(Material.GOLD_BOOTS);
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
            l.setMaxHealth(50.0);
            l.setHealth(50.0);
            l.setCustomName((Object)ChatColor.RED + "\u041f\u0435\u0440\u0432\u044b\u0439 \u0411\u043e\u0441\u0441");
            l.setCustomNameVisible(true);
            l.getEquipment().setBootsDropChance(100.0f);
            l.getEquipment().setChestplateDropChance(100.0f);
            l.getEquipment().setHelmetDropChance(100.0f);
            l.getEquipment().setItemInHandDropChance(100.0f);
            l.getEquipment().setLeggingsDropChance(100.0f);
            b = 0;
            while (b < Blue.size()) {
                Red.get(i).sendMessage("\u041f\u0435\u0440\u0432\u044b\u0439 \u0411\u043e\u0441\u0441 \u0437\u0430\u0441\u043f\u0430\u0443\u043d\u0438\u043b\u0441\u044f");
                ++b;
            }
            ++i;
        }
        i = 0;
        while (i < 1) {
            world = Bukkit.getServer().getWorld(sbb.worldName);
            loc = new Location(world, sbb.x, sbb.y, sbb.z);
            l = (LivingEntity)loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            ItemStack helmet = new ItemStack(Material.GOLD_HELMET);
            chestplate = new ItemStack(Material.IRON_CHESTPLATE);
            ItemStack leggins = new ItemStack(Material.GOLD_LEGGINGS);
            boots = new ItemStack(Material.GOLD_BOOTS);
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
            l.setMaxHealth(50.0);
            l.setHealth(50.0);
            l.setCustomName((Object)ChatColor.BLUE + "\u041f\u0435\u0440\u0432\u044b\u0439 \u0411\u043e\u0441\u0441");
            l.setCustomNameVisible(true);
            l.getEquipment().setBootsDropChance(100.0f);
            l.getEquipment().setChestplateDropChance(100.0f);
            l.getEquipment().setHelmetDropChance(100.0f);
            l.getEquipment().setItemInHandDropChance(100.0f);
            l.getEquipment().setLeggingsDropChance(100.0f);
            b = 0;
            while (b < Blue.size()) {
                Blue.get(i).sendMessage("\u041f\u0435\u0440\u0432\u044b\u0439 \u0411\u043e\u0441\u0441 \u0437\u0430\u0441\u043f\u0430\u0443\u043d\u0438\u043b\u0441\u044f");
                ++b;
            }
            ++i;
        }
    }

    public void onDeath(PlayerDeathEvent e) {
        if (!BossWars.inGame) {
            return;
        }
        int i = 0;
        while (i < e.getDrops().size()) {
            ((ItemStack)e.getDrops().get(i)).setType(Material.AIR);
            ++i;
        }
        Player p = e.getEntity();
        if (pls.contains((Object)p)) {
            World world;
            int i2;
            if (Red.contains((Object)p)) {
                world = Bukkit.getServer().getWorld(inGame.sr.worldName);
                p.setHealth(20.0);
                p.teleport(new Location(world, inGame.sr.x, inGame.sr.y, inGame.sr.z));
                i2 = 0;
                while (i2 < 36) {
                    if (p.getInventory().getItem(i2).getType() == Material.BRICK) {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i2));
                        p.getInventory().setItem(i2, new ItemStack(Material.AIR));
                    }
                    if (p.getInventory().getItem(i2).getType() == Material.IRON_INGOT) {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i2));
                        p.getInventory().setItem(i2, new ItemStack(Material.AIR));
                    }
                    if (p.getInventory().getItem(i2).getType() == Material.GOLD_INGOT) {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i2));
                        p.getInventory().setItem(i2, new ItemStack(Material.AIR));
                    }
                    if (p.getInventory().getItem(i2).getType() == Material.DIAMOND) {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i2));
                        p.getInventory().setItem(i2, new ItemStack(Material.AIR));
                    }
                    if (p.getInventory().getItem(i2).getType() == Material.EMERALD) {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i2));
                        p.getInventory().setItem(i2, new ItemStack(Material.AIR));
                    }
                    ++i2;
                }
            }
            if (Blue.contains((Object)p)) {
                world = Bukkit.getServer().getWorld(inGame.sb.worldName);
                p.setHealth(20.0);
                p.teleport(new Location(world, inGame.sb.x, inGame.sb.y, inGame.sb.z));
                i2 = 0;
                while (i2 < 36) {
                    if (p.getInventory().getItem(i2).getType() == Material.BRICK) {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i2));
                        p.getInventory().setItem(i2, new ItemStack(Material.AIR));
                    }
                    if (p.getInventory().getItem(i2).getType() == Material.IRON_INGOT) {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i2));
                        p.getInventory().setItem(i2, new ItemStack(Material.AIR));
                    }
                    if (p.getInventory().getItem(i2).getType() == Material.GOLD_INGOT) {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i2));
                        p.getInventory().setItem(i2, new ItemStack(Material.AIR));
                    }
                    if (p.getInventory().getItem(i2).getType() == Material.DIAMOND) {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i2));
                        p.getInventory().setItem(i2, new ItemStack(Material.AIR));
                    }
                    if (p.getInventory().getItem(i2).getType() == Material.EMERALD) {
                        p.getLocation().getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getItem(i2));
                        p.getInventory().setItem(i2, new ItemStack(Material.AIR));
                    }
                    ++i2;
                }
            }
        }
    }

    public void onBossDeath(EntityDeathEvent e) {
        ItemStack sword;
        Location loc;
        int i;
        int b;
        ItemStack boots;
        LivingEntity le;
        World world;
        int b2;
        ItemStack chestplate;
        ItemStack leggins;
        ItemStack helmet;
        LivingEntity l = e.getEntity();
        if (l.getCustomName() == (Object)ChatColor.BLUE + "\u041f\u0435\u0440\u0432\u044b\u0439 \u0411\u043e\u0441\u0441") {
            i = 0;
            while (i < Blue.size()) {
                Blue.get(i).sendMessage((Object)ChatColor.GREEN + "\u0412\u044b \u043f\u043e\u0431\u0435\u0434\u0438\u043b\u0438 \u043f\u0435\u0440\u0432\u043e\u0433\u043e \u0431\u043e\u0441\u0441\u0430, \u043f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c!!!\n\u0423 \u0432\u0430\u0441 \u0435\u0441\u0442\u044c 60 \u0441\u0435\u043a\u0443\u043d\u0434, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c\u0441\u044f \u043a \u0441\u043b\u0435\u0434\u0443\u0449\u0435\u043c\u0443.");
                ++i;
            }
            if (!boss1) {
                i = 0;
                while (i < Red.size()) {
                    Red.get(i).sendMessage((Object)ChatColor.RED + "\u0412\u0430\u0441 \u043e\u0431\u043e\u0433\u043d\u0430\u043b\u0438 \u0421\u0438\u043d\u0438\u0435 \u0432 \u0443\u0431\u0438\u0439\u0441\u0442\u0432\u0435 \u043f\u0435\u0440\u0432\u043e\u0433\u043e \u0431\u043e\u0441\u0441\u0430!");
                    ++i;
                }
            }
            boss1 = true;
            t.schedule(tm, 60000);
            i = 0;
            while (i < 1) {
                world = Bukkit.getServer().getWorld(inGame.sb.worldName);
                loc = new Location(world, inGame.sb.x, inGame.sb.y, inGame.sb.z);
                le = (LivingEntity)loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                helmet = new ItemStack(Material.IRON_HELMET);
                chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                leggins = new ItemStack(Material.IRON_LEGGINGS);
                boots = new ItemStack(Material.IRON_BOOTS);
                sword = new ItemStack(Material.DIAMOND_SWORD);
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
                le.setMaxHealth(80.0);
                le.setHealth(80.0);
                le.setCustomName((Object)ChatColor.BLUE + "\u0412\u0442\u043e\u0440\u043e\u0439 \u0411\u043e\u0441\u0441");
                le.setCustomNameVisible(true);
                le.getEquipment().setBootsDropChance(100.0f);
                le.getEquipment().setChestplateDropChance(100.0f);
                le.getEquipment().setHelmetDropChance(100.0f);
                le.getEquipment().setItemInHandDropChance(100.0f);
                le.getEquipment().setLeggingsDropChance(100.0f);
                le.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1, 25000));
                b = 0;
                while (b < Blue.size()) {
                    Red.get(i).sendMessage("\u0412\u0442\u043e\u0440\u043e\u0439 \u0411\u043e\u0441\u0441 \u0437\u0430\u0441\u043f\u0430\u0443\u043d\u0438\u043b\u0441\u044f");
                    ++b;
                }
                ++i;
            }
        }
        if (l.getCustomName() == (Object)ChatColor.BLUE + "\u0412\u0442\u043e\u0440\u043e\u0439 \u0411\u043e\u0441\u0441") {
            i = 0;
            while (i < Blue.size()) {
                Blue.get(i).sendMessage((Object)ChatColor.GREEN + "\u0412\u044b \u043f\u043e\u0431\u0435\u0434\u0438\u043b\u0438 \u0432\u0442\u043e\u0440\u043e\u0433\u043e \u0431\u043e\u0441\u0441\u0430, \u043f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c!!!\n\u0423 \u0432\u0430\u0441 \u0435\u0441\u0442\u044c 60 \u0441\u0435\u043a\u0443\u043d\u0434, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c\u0441\u044f \u043a \u0441\u043b\u0435\u0434\u0443\u0449\u0435\u043c\u0443.");
                ++i;
            }
            if (!boss1) {
                i = 0;
                while (i < Red.size()) {
                    Red.get(i).sendMessage((Object)ChatColor.RED + "\u0412\u0430\u0441 \u043e\u0431\u043e\u0433\u043d\u0430\u043b\u0438 \u0421\u0438\u043d\u0438\u0435 \u0432 \u0443\u0431\u0438\u0439\u0441\u0442\u0432\u0435 \u0432\u0442\u043e\u0440\u043e\u0433\u043e \u0431\u043e\u0441\u0441\u0430!");
                    ++i;
                }
            }
            boss1 = true;
            t.schedule(tm, 60000);
            i = 0;
            while (i < 1) {
                world = Bukkit.getServer().getWorld(inGame.sb.worldName);
                loc = new Location(world, inGame.sb.x, inGame.sb.y, inGame.sb.z);
                le = (LivingEntity)loc.getWorld().spawnEntity(loc, EntityType.WITHER);
                helmet = new ItemStack(Material.DIAMOND_HELMET);
                chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                leggins = new ItemStack(Material.DIAMOND_LEGGINGS);
                boots = new ItemStack(Material.DIAMOND_BOOTS);
                sword = new ItemStack(Material.DIAMOND_SWORD);
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
                le.setMaxHealth(80.0);
                le.setHealth(80.0);
                le.setCustomName((Object)ChatColor.BLUE + "\u0421\u043b\u043e\u0436\u043d\u0435\u0439\u0448\u0438\u0439 \u0411\u043e\u0441\u0441");
                le.setCustomNameVisible(true);
                le.getEquipment().setBootsDropChance(100.0f);
                le.getEquipment().setChestplateDropChance(100.0f);
                le.getEquipment().setHelmetDropChance(100.0f);
                le.getEquipment().setItemInHandDropChance(100.0f);
                le.getEquipment().setLeggingsDropChance(100.0f);
                le.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3, 25000));
                b = 0;
                while (b < Blue.size()) {
                    Red.get(i).sendMessage("\u0421\u043b\u043e\u0436\u043d\u0435\u0439\u0448\u0438\u0439 \u0411\u043e\u0441\u0441 \u0437\u0430\u0441\u043f\u0430\u0443\u043d\u0438\u043b\u0441\u044f");
                    ++b;
                }
                ++i;
            }
        }
        if (l.getCustomName() == (Object)ChatColor.BLUE + "\u0421\u043b\u043e\u0436\u043d\u0435\u0439\u0448\u0438\u0439 \u0411\u043e\u0441\u0441" && !boos3) {
            b2 = 0;
            while (b2 < Blue.size()) {
                Blue.get(inGame.i).sendMessage("\u0412\u044b \u043f\u043e\u0431\u0435\u0434\u0438\u043b\u0438!!!");
                ++b2;
            }
            b2 = 0;
            while (b2 < Red.size()) {
                Red.get(b2).sendMessage((Object)ChatColor.RED + "\u0412\u044b \u043f\u0440\u043e\u0438\u0433\u0440\u0430\u043b\u0438.");
                ++b2;
            }
            t.schedule(tms, 5000);
            b2 = 0;
            while (b2 < pls.size()) {
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)("spawn " + pls.get(inGame.i).getName()));
                ++b2;
            }
            BossWars.inGame = false;
        }
        if (l.getCustomName() == (Object)ChatColor.RED + "\u041f\u0435\u0440\u0432\u044b\u0439 \u0411\u043e\u0441\u0441") {
            i = 0;
            while (i < Red.size()) {
                Red.get(i).sendMessage((Object)ChatColor.GREEN + "\u0412\u044b \u043f\u043e\u0431\u0435\u0434\u0438\u043b\u0438 \u043f\u0435\u0440\u0432\u043e\u0433\u043e \u0431\u043e\u0441\u0441\u0430, \u043f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c!!!\n\u0423 \u0432\u0430\u0441 \u0435\u0441\u0442\u044c 60 \u0441\u0435\u043a\u0443\u043d\u0434, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c\u0441\u044f \u043a \u0441\u043b\u0435\u0434\u0443\u0449\u0435\u043c\u0443.");
                ++i;
            }
            if (!boos2) {
                i = 0;
                while (i < Blue.size()) {
                    Blue.get(i).sendMessage((Object)ChatColor.RED + "\u0412\u0430\u0441 \u043e\u0431\u043e\u0433\u043d\u0430\u043b\u0438 \u041a\u0440\u0430\u0441\u043d\u044b\u0435 \u0432 \u0443\u0431\u0438\u0439\u0441\u0442\u0432\u0435 \u043f\u0435\u0440\u0432\u043e\u0433\u043e \u0431\u043e\u0441\u0441\u0430!");
                    ++i;
                }
            }
            boos2 = true;
            t.schedule(tm, 60000);
            i = 0;
            while (i < 1) {
                world = Bukkit.getServer().getWorld(inGame.sr.worldName);
                loc = new Location(world, inGame.sr.x, inGame.sr.y, inGame.sr.z);
                le = (LivingEntity)loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                helmet = new ItemStack(Material.IRON_HELMET);
                chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                leggins = new ItemStack(Material.IRON_LEGGINGS);
                boots = new ItemStack(Material.IRON_BOOTS);
                sword = new ItemStack(Material.DIAMOND_SWORD);
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
                le.setMaxHealth(80.0);
                le.setHealth(80.0);
                le.setCustomName((Object)ChatColor.RED + "\u041f\u0435\u0440\u0432\u044b\u0439 \u0411\u043e\u0441\u0441");
                le.setCustomNameVisible(true);
                le.getEquipment().setBootsDropChance(100.0f);
                le.getEquipment().setChestplateDropChance(100.0f);
                le.getEquipment().setHelmetDropChance(100.0f);
                le.getEquipment().setItemInHandDropChance(100.0f);
                le.getEquipment().setLeggingsDropChance(100.0f);
                le.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1, 25000));
                b = 0;
                while (b < Blue.size()) {
                    Blue.get(i).sendMessage("\u0412\u0442\u043e\u0440\u043e\u0439 \u0411\u043e\u0441\u0441 \u0437\u0430\u0441\u043f\u0430\u0443\u043d\u0438\u043b\u0441\u044f");
                    ++b;
                }
                ++i;
            }
        }
        if (l.getCustomName() == (Object)ChatColor.RED + "\u0412\u0442\u043e\u0440\u043e\u0439 \u0411\u043e\u0441\u0441") {
            i = 0;
            while (i < Blue.size()) {
                Blue.get(i).sendMessage((Object)ChatColor.GREEN + "\u0412\u044b \u043f\u043e\u0431\u0435\u0434\u0438\u043b\u0438 \u0432\u0442\u043e\u0440\u043e\u0433\u043e \u0431\u043e\u0441\u0441\u0430, \u043f\u043e\u0437\u0434\u0440\u0430\u0432\u043b\u044f\u0435\u043c!!!\n\u0423 \u0432\u0430\u0441 \u0435\u0441\u0442\u044c 60 \u0441\u0435\u043a\u0443\u043d\u0434, \u0447\u0442\u043e\u0431\u044b \u043f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c\u0441\u044f \u043a \u0441\u043b\u0435\u0434\u0443\u0449\u0435\u043c\u0443.");
                ++i;
            }
            if (!boos2) {
                i = 0;
                while (i < Red.size()) {
                    Red.get(i).sendMessage((Object)ChatColor.RED + "\u0412\u0430\u0441 \u043e\u0431\u043e\u0433\u043d\u0430\u043b\u0438 \u041a\u0440\u0430\u0441\u043d\u044b\u0435 \u0432 \u0443\u0431\u0438\u0439\u0441\u0442\u0432\u0435 \u0432\u0442\u043e\u0440\u043e\u0433\u043e \u0431\u043e\u0441\u0441\u0430!");
                    ++i;
                }
            }
            boos2 = true;
            t.schedule(tm, 60000);
            i = 0;
            while (i < 1) {
                world = Bukkit.getServer().getWorld(inGame.sr.worldName);
                loc = new Location(world, inGame.sr.x, inGame.sr.y, inGame.sb.z);
                le = (LivingEntity)loc.getWorld().spawnEntity(loc, EntityType.WITHER);
                helmet = new ItemStack(Material.DIAMOND_HELMET);
                chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                leggins = new ItemStack(Material.DIAMOND_LEGGINGS);
                boots = new ItemStack(Material.DIAMOND_BOOTS);
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
                le.setMaxHealth(80.0);
                le.setHealth(80.0);
                le.setCustomName((Object)ChatColor.RED + "\u0421\u043b\u043e\u0436\u043d\u0435\u0439\u0448\u0438\u0439 \u0411\u043e\u0441\u0441");
                le.setCustomNameVisible(true);
                le.getEquipment().setBootsDropChance(100.0f);
                le.getEquipment().setChestplateDropChance(100.0f);
                le.getEquipment().setHelmetDropChance(100.0f);
                le.getEquipment().setItemInHandDropChance(100.0f);
                le.getEquipment().setLeggingsDropChance(100.0f);
                le.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3, 25000));
                int b3 = 0;
                while (b3 < Red.size()) {
                    Red.get(i).sendMessage("\u0421\u043b\u043e\u0436\u043d\u0435\u0439\u0448\u0438\u0439 \u0411\u043e\u0441\u0441 \u0437\u0430\u0441\u043f\u0430\u0443\u043d\u0438\u043b\u0441\u044f");
                    ++b3;
                }
                ++i;
            }
        }
        if (l.getCustomName() == (Object)ChatColor.RED + "\u0421\u043b\u043e\u0436\u043d\u0435\u0439\u0448\u0438\u0439 \u0411\u043e\u0441\u0441" && !boos3) {
            b2 = 0;
            while (b2 < Red.size()) {
                Red.get(b2).sendMessage((Object)ChatColor.GREEN + "\u0412\u044b \u043f\u043e\u0431\u0435\u0434\u0438\u043b\u0438!!!");
                ++b2;
            }
            b2 = 0;
            while (b2 < Blue.size()) {
                Blue.get(b2).sendMessage((Object)ChatColor.RED + "\u0412\u044b \u043f\u0440\u043e\u0438\u0433\u0440\u0430\u043b\u0438.");
                ++b2;
            }
            t.schedule(tms, 5000);
            b2 = 0;
            while (b2 < pls.size()) {
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), (String)("spawn " + Red.get(b2).getName()));
                ++b2;
            }
            BossWars.inGame = false;
        }
    }

}

