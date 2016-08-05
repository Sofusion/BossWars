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
import ru.BossWars.command.Command;
import ru.BossWars.main.BossWars;
import ru.BossWars.tp.toTp;
import ru.BossWars.utils.Inv;
import ru.BossWars.utils.ItemUtil;

public class join implements Command{
	int i;
	@Override
	public List<String> getNames() {
		List<String> list = new ArrayList<String>();
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

	/* (non-Javadoc)
	 * @see ru.BossWars.command.Command#Execute(org.bukkit.command.CommandSender, org.bukkit.command.Command, java.lang.String[])
	 */
	public void Execute(CommandSender sen, org.bukkit.command.Command cmd, String[] args) {
		if(!BossWars.spns.exists()){
			sen.sendMessage(ChatColor.RED+"Нет арен или администратор удалил файл Spawns.yml");
			return;
		}
		if(BossWars.inGame){
			sen.sendMessage(ChatColor.RED+"Игра уже началась");
			return;
		}
		if(!(sen instanceof Player)){
			sen.sendMessage("Only players can use this command");
			return;
		}
		Player p = (Player) sen;
		if(BossWars.players.contains(p)){
			p.sendMessage(ChatColor.RED + "Вы уже в очереди");
			return;
		}
		BossWars.players.add(p);
		p.sendMessage(BossWars.msg.getString("enteredIn"));
		if(BossWars.players.size() == 2){
			for(i=0; i<2; i++){
				p = BossWars.players.get(i);
				World world = Bukkit.getServer().getWorld(BossWars.pos.worldName);
				p.teleport(new Location(world, BossWars.pos.x, BossWars.pos.y, BossWars.pos.z));
				BossWars.pls.add(new Inv(p.getInventory(), p));
				p.getInventory().clear();
				p.getInventory().setItem(0, ItemUtil.create(Material.WOOL, "Выбор команды"));
				p.setGameMode(GameMode.SURVIVAL);
				p.setExp(0);
				if(BossWars.comRed.size()>BossWars.comBlue.size()){
					BossWars.comBlue.add(p);
				}else BossWars.comRed.add(p);
			}
			toTp.toGame();
			return;
		}
		if(BossWars.players.size() > 2 & BossWars.players.size() <12) {
			World world = Bukkit.getServer().getWorld(BossWars.pos.worldName);
			p.teleport(new Location(world, BossWars.pos.x, BossWars.pos.y,BossWars.pos.z));
			BossWars.pls.add(new Inv(p.getInventory(), p));
			p.getInventory().clear();
			p.getInventory().setItem(0, ItemUtil.create(Material.WOOL, "Выбор команды"));
			p.setGameMode(GameMode.SURVIVAL);
			p.setExp(0);
			if(BossWars.comRed.size()>BossWars.comBlue.size()){
				BossWars.comBlue.add(p);
			}else BossWars.comRed.add(p);
		}
		if(BossWars.players.size()==1)return;
		if(!BossWars.inGame)return;
		sen.sendMessage(ChatColor.RED + "Все игры заняты, попробуйте позже");
	}
}
