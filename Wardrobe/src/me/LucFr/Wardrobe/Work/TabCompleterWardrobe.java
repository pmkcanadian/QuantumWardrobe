package me.LucFr.Wardrobe.Work;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import me.LucFr.Wardrobe.Main;

public class TabCompleterWardrobe implements TabCompleter{

	List<String> arguments = new ArrayList<String>();
	
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			List<String> result = new ArrayList<String>();
			if (args.length == 1) {
				arguments.clear();
				arguments.add("reload");
				arguments.add("open");
				arguments.add("reset");
				for (String a : arguments) {
					if (a.toLowerCase().startsWith(args[0].toLowerCase()))
						result.add(a);
				}
				return result;
			}
			if (args[0].equalsIgnoreCase("open") || args[0].equalsIgnoreCase("reset")) {
				arguments.clear();
				for(Player player : Bukkit.getOnlinePlayers()) {
					String player1 = player.getName().toString();
					arguments.add(player1);
				}
				for (String a : arguments) {
					if (a.toLowerCase().startsWith(args[1]))
						result.add(a);
				}
				return result;
			}
		}
		Player p = (Player) sender;
		String ADMIN = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Admin");
		if (p.isOp() || p.hasPermission(ADMIN)) {
			List<String> result = new ArrayList<String>();
			if (args.length == 1) {
				arguments.clear();
				arguments.add("reload");
				arguments.add("open");
				arguments.add("reset");
				for (String a : arguments) {
					if (a.toLowerCase().startsWith(args[0].toLowerCase()))
						result.add(a);
				}
				return result;
			}
			if (args[0].equalsIgnoreCase("open") || args[0].equalsIgnoreCase("reset")) {
				arguments.clear();
				for(Player player : Bukkit.getOnlinePlayers()) {
					String player1 = player.getName().toString();
					arguments.add(player1);
				}
				for (String a : arguments) {
					if (a.toLowerCase().startsWith(args[1]))
						result.add(a);
				}
				return result;
			}
		} else return null;
		return null;
	}
}
