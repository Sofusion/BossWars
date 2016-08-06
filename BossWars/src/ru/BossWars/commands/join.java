/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.GameMode
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.World
 *  org.bukkit.command.Command
 *  org.bukkit.command.CommandSender
 *  org.bukkit.configuration.file.YamlConfiguration
 *  org.bukkit.entity.Player
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 */
package ru.BossWars.commands;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;
import ru.BossWars.tp.toTp;
import ru.BossWars.utils.Inv;
import ru.BossWars.utils.ItemUtil;

public class join
implements Command {
    int i;

    @Override
    public List<String> getNames() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("join");
        list.add("j");
        return list;
    }

    @Override
    public String getPermission() {
        return "BossWars.join";
    }

    @Override
    public String getHelp() {
        return BossWars.cmd.getString("Commands");
    }

    @Override
    public void Execute(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {
        if (!BossWars.spns.exists()) {
            sen.sendMessage((Object)ChatColor.RED + "\u041d\u0435\u0442 \u0430\u0440\u0435\u043d \u0438\u043b\u0438 \u0430\u0434\u043c\u0438\u043d\u0438\u0441\u0442\u0440\u0430\u0442\u043e\u0440 \u0443\u0434\u0430\u043b\u0438\u043b \u0444\u0430\u0439\u043b Spawns.yml");
            return;
        }
        if (BossWars.inGame) {
            sen.sendMessage((Object)ChatColor.RED + "\u0418\u0433\u0440\u0430 \u0443\u0436\u0435 \u043d\u0430\u0447\u0430\u043b\u0430\u0441\u044c");
            return;
        }
        if (!(sen instanceof Player)) {
            sen.sendMessage("Only players can use this command");
            return;
        }
        Player p = (Player)sen;
        if (BossWars.players.contains((Object)p)) {
            p.sendMessage((Object)ChatColor.RED + "\u0412\u044b \u0443\u0436\u0435 \u0432 \u043e\u0447\u0435\u0440\u0435\u0434\u0438");
            return;
        }
        BossWars.players.add(p);
        p.sendMessage(BossWars.msg.getString("enteredIn"));
        if (BossWars.players.size() == 2) {
            this.i = 0;
            while (this.i < 2) {
                p = BossWars.players.get(this.i);
                World world = Bukkit.getServer().getWorld(BossWars.pos.worldName);
                p.teleport(new Location(world, BossWars.pos.x, BossWars.pos.y, BossWars.pos.z));
                BossWars.pls.add(new Inv((Inventory)p.getInventory(), p));
                p.getInventory().clear();
                p.getInventory().setItem(0, ItemUtil.create(Material.WOOL, "\u0412\u044b\u0431\u043e\u0440 \u043a\u043e\u043c\u0430\u043d\u0434\u044b"));
                p.setGameMode(GameMode.SURVIVAL);
                p.setExp(0.0f);
                if (BossWars.comRed.size() > BossWars.comBlue.size()) {
                    BossWars.comBlue.add(p);
                } else {
                    BossWars.comRed.add(p);
                }
                ++this.i;
            }
            toTp.toGame();
            return;
        }
        if (BossWars.players.size() > 2 & BossWars.players.size() < 12) {
            World world = Bukkit.getServer().getWorld(BossWars.pos.worldName);
            p.teleport(new Location(world, BossWars.pos.x, BossWars.pos.y, BossWars.pos.z));
            BossWars.pls.add(new Inv((Inventory)p.getInventory(), p));
            p.getInventory().clear();
            p.getInventory().setItem(0, ItemUtil.create(Material.WOOL, "\u0412\u044b\u0431\u043e\u0440 \u043a\u043e\u043c\u0430\u043d\u0434\u044b"));
            p.setGameMode(GameMode.SURVIVAL);
            p.setExp(0.0f);
            if (BossWars.comRed.size() > BossWars.comBlue.size()) {
                BossWars.comBlue.add(p);
            } else {
                BossWars.comRed.add(p);
            }
        }
        if (BossWars.players.size() == 1) {
            return;
        }
        if (!BossWars.inGame) {
            return;
        }
        sen.sendMessage((Object)ChatColor.RED + "\u0412\u0441\u0435 \u0438\u0433\u0440\u044b \u0437\u0430\u043d\u044f\u0442\u044b, \u043f\u043e\u043f\u0440\u043e\u0431\u0443\u0439\u0442\u0435 \u043f\u043e\u0437\u0436\u0435");
    }
}

