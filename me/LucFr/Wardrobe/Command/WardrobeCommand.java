package me.LucFr.Wardrobe.Command;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.LucFr.Wardrobe.Wardrobe;
import me.LucFr.Wardrobe.GUI.WardrobeGUI;
import me.LucFr.Wardrobe.Work.DataWork;
import net.md_5.bungee.api.ChatColor;

public class WardrobeCommand implements CommandExecutor{

	public Wardrobe plugin;
	
	public WardrobeCommand(Wardrobe plugin) {
		this.plugin = plugin;
		plugin.getCommand("wardrobe").setExecutor(this);
	}
	
	// wardrobe
	// wardrobe reload
	// wardrobe open
	// wardrobe open <player>
	// wardrobe reset <player> (page 1, page 2, all, Slot 1, 2,.., 18)
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			if (args.length == 0) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please choose a work to do!");
				return true;
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("reload")) {
					Wardrobe.ConfigData.ReloadConfig();
					Wardrobe.Page_1.ReloadConfig();
					Wardrobe.Page_2.ReloadConfig();
					Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] Success reloaded config!");
					return true;
				} else {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
						WardrobeGUI.CreateWardrobePage1(target);
						return true;
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
				}
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("open")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
						WardrobeGUI.CreateWardrobePage1(target);
						return true;
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
			// Suggestion command to /wardrobe reset command
				} else if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please choose a work to do!");
						return true;
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
			// Unknown command
				} else {
					Bukkit.getConsoleSender().sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else if (args.length == 3) {
				if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
					// Suggestion command to /wardrobe reset command
						if (args[2].equalsIgnoreCase("page") || args[2].equalsIgnoreCase("slot")) {
							Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please choose a number!");
							return false;
					// Reset all of player Wardrobe
						} else if (args[2].equalsIgnoreCase("all")) {
							if (DataWork.ResetAllPlayerWardrobe(target)) {
								Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
								return true;
							} else {
								Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
								return false;
							}
						} else {
							Bukkit.getConsoleSender().sendMessage("Unknown command. Type \"/help\" for help.");
							return false;
						}
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
				} else {
					Bukkit.getConsoleSender().sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else if (args.length == 4) {
				if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
					// Reset page of player Wardrobe
						if (args[2].equalsIgnoreCase("page")) {
							if (args[3].equalsIgnoreCase("1") || args[3].equalsIgnoreCase("2")) {
								if (DataWork.ResetPagePlayerWardrobe(target, args[3])) {
									Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + " " + args[3] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
									return true;
								} else {
									Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
									return false;
								}
							} else {
								Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Unknown page!");
								return false;
							}
					// Reset slot of player Wardrobe
						} else if (args[2].equalsIgnoreCase("slot")) {
							String Number = args[3];
							if (Integer.valueOf(Number) >= 1 && Integer.valueOf(Number) <= 18) {
								if (DataWork.ResetSlotPlayerWardrobe(target, Number)) {
									Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + " " + args[3] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
									return true;
								} else {
									Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
								}
							} else {
								Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Unknown slot!");
								return false;
							}
						} else {
							Bukkit.getConsoleSender().sendMessage("Unknown command. Type \"/help\" for help.");
							return false;
						}
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
				} else {
					Bukkit.getConsoleSender().sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			}
		}
	// Open command
		Player p = (Player) sender;
		if (args.length == 0) {
			WardrobeGUI.CreateWardrobePage1(p);
			return true;
		} else if (p.hasPermission(Wardrobe.ConfigData.getConfig().getString("Admin-Permission"))) {
			if (args.length == 1) {
			// Reload command
				if (args[0].equalsIgnoreCase("reload")) {
					Wardrobe.ConfigData.ReloadConfig();
					Wardrobe.Page_1.ReloadConfig();
					Wardrobe.Page_2.ReloadConfig();
					p.sendMessage(ChatColor.GREEN + "[Wardrobe] Success reloaded config!");
					p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2f, 6f);
					return true;
			// Open command
				} else if (args[0].equalsIgnoreCase("open")) {
					WardrobeGUI.CreateWardrobePage1(p);
					return true;
			// Suggestion command to /wardrobe reset command
				} else if (args[0].equalsIgnoreCase("reset")) {
					p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please enter a player name!");
					p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
					return true;
			// Unknown command
				} else {
					p.sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else if (args.length == 2) {
			// Open for player
				if (args[0].equalsIgnoreCase("open")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
						WardrobeGUI.CreateWardrobePage1(target);
						return true;
					} else {
						p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
						return false;
					}
			// Suggestion command to /wardrobe reset command
				} else if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
						p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please choose a work to do!");
						return true;
					} else {
						p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
						return false;
					}
			// Unknown command
				} else {
					p.sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else if (args.length == 3) {
				if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
					// Suggestion command to /wardrobe reset command
						if (args[2].equalsIgnoreCase("page") || args[2].equalsIgnoreCase("slot")) {
							p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please choose a number!");
							p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
							return false;
					// Reset all of player Wardrobe
						} else if (args[2].equalsIgnoreCase("all")) {
							if (DataWork.ResetAllPlayerWardrobe(target)) {
								p.sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
								p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2f, 6f);
								return true;
							} else {
								p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
								return false;
							}
						} else {
							p.sendMessage("Unknown command. Type \"/help\" for help.");
							return false;
						}
					} else {
						p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
						return false;
					}
				} else {
					p.sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else if (args.length == 4) {
				if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
					// Reset page of player Wardrobe
						if (args[2].equalsIgnoreCase("page")) {
							if (args[3].equalsIgnoreCase("1") || args[3].equalsIgnoreCase("2")) {
								if (DataWork.ResetPagePlayerWardrobe(target, args[3])) {
									p.sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + " " + args[3] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
									p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2f, 6f);
									return true;
								} else {
									p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
									return false;
								}
							} else {
								p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Unknown page!");
								p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
								return false;
							}
					// Reset slot of player Wardrobe
						} else if (args[2].equalsIgnoreCase("slot")) {
							String Number = args[3];
							if (Integer.valueOf(Number) >= 1 && Integer.valueOf(Number) <= 18) {
								if (DataWork.ResetSlotPlayerWardrobe(target, Number)) {
									p.sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + " " + args[3] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
									p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 2f, 6f);
									return true;
								} else {
									p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
								}
							} else {
								p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Unknown slot!");
								p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
								return false;
							}
						} else {
							p.sendMessage("Unknown command. Type \"/help\" for help.");
							return false;
						}
					} else {
						p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
						return false;
					}
				} else {
					p.sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else {
				p.sendMessage("Unknown command. Type \"/help\" for help.");
				return false;
			}
		} else if (args.length == 1) {
			if (args[0].equalsIgnoreCase("open")) {
				WardrobeGUI.CreateWardrobePage1(p);
				return true;
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Wardrobe_Message.Permission_Denied")));
				return false;
			}
		} else {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', Wardrobe.ConfigData.getConfig().getString("Wardrobe_Message.Permission_Denied")));
			return false;
		}
		return false;
	}
}
