package me.LucFr.Wardrobe.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LucFr.Wardrobe.Wardrobe;
import me.LucFr.Wardrobe.GUI.WardrobeGUI;
import net.md_5.bungee.api.ChatColor;

public class WardrobeCommand implements CommandExecutor{

	public Wardrobe plugin;
	
	public WardrobeCommand(Wardrobe plugin) {
		this.plugin = plugin;
		plugin.getCommand("wardrobe").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			
		}
		Player p = (Player) sender;
		if (args.length == 0) {
			WardrobeGUI.CreateWardrobePage1(p);
			return true;
		} else if (p.hasPermission(Wardrobe.ConfigData.getConfig().getString("Admin-Permission"))){
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("reload")) {
					Wardrobe.ConfigData.ReloadConfig();
					p.sendMessage(ChatColor.GREEN + "[Wardrobe] Success reloaded config!");
					return true;
				}
			}
		}
		return false;
	}
}
