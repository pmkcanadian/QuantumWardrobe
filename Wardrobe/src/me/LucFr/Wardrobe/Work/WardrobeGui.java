package me.LucFr.Wardrobe.Work;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.LucFr.Wardrobe.Main;

public class WardrobeGui {
	
	public static String version = Bukkit.getServer().getVersion();
	
	// Wardrobe Page 1
	@SuppressWarnings("deprecation")
	public void WardrobePage1(Player p) {
		String Page1 = ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.GUI_Tile.Page_1"));
		Inventory inv = Bukkit.createInventory(p, 54, Page1);
		ItemStack item = new ItemStack(Material.DIRT);
		ItemMeta meta = item.getItemMeta();
		// Create Base Item
		if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
			String Mat = "STAINED_GLASS_PANE";
			item.setType(Material.valueOf(Mat));
			item.setDurability((short) 15);
		}
		if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
			String Mat = "BLACK_STAINED_GLASS_PANE";
			item.setType(Material.valueOf(Mat));
		}
		// Back ground item
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		for (int i = 45; i <= 53; i++) {
			inv.setItem(i, item);
		}
		List<String> lore = new ArrayList<String>();
		lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Locked_Slot.Lore"));
		for (int i = 0; i < lore.size(); i++) {
			lore.set(i, ChatColor.translateAlternateColorCodes('&', lore.get(i)));
		}
		for (int i = 0; i <= 8; i++) {
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				String Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 15);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				String Mat = "BLACK_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
			meta.setDisplayName(ChatColor.GRAY + "Slot " + (i+1) + " " + ChatColor.RED + "Locked");
			if (i >= 2 && i <= 4) {
				lore.set(lore.size()-1, ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.Locked_Slot.Rank_Requires_Prefix.Slots_5")));
				item.setItemMeta(meta);
			}
			if (i >= 5 && i <= 8) {
				lore.set(lore.size()-1, ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.Locked_Slot.Rank_Requires_Prefix.Slots_9")));
				item.setItemMeta(meta);
			}
			inv.setItem(i, item);
			inv.setItem(i+9, item);
			inv.setItem(i+18, item);
			inv.setItem(i+27, item);
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				String Mat = "INK_SACK";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 1);
			}
			if (version.contains("1.13")) {
				String Mat = "ROSE_RED";
				item.setType(Material.valueOf(Mat)); 
			}
			if (version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				String Mat = "RED_DYE";
				item.setType(Material.valueOf(Mat)); 
			}
			inv.setItem(i+36, item);
		}
		CheckPlayerSlot(p, inv, 1);
		return;
	}
	
	// Wardrobe Page 2
	@SuppressWarnings("deprecation")
	public void WardrobePage2(Player p) {
		String Page2 = ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.GUI_Tile.Page_2"));
		Inventory inv = Bukkit.createInventory(p, 54, Page2);
		ItemStack item = new ItemStack(Material.DIRT);
		ItemMeta meta = item.getItemMeta();
		// Create Base Item
		if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
			String Mat = "STAINED_GLASS_PANE";
			item.setType(Material.valueOf(Mat));
			item.setDurability((short) 15);
		}
		if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
			String Mat = "BLACK_STAINED_GLASS_PANE";
			item.setType(Material.valueOf(Mat));
		}
		// Back ground item
		meta.setDisplayName(" ");
		item.setItemMeta(meta);
		for (int i = 45; i <= 53; i++) {
			inv.setItem(i, item);
		}
		List<String> lore = new ArrayList<String>();
		lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Locked_Slot.Lore"));
		for (int i = 0; i < lore.size(); i++) {
			lore.set(i, ChatColor.translateAlternateColorCodes('&', lore.get(i)));
		}
		for (int i = 0; i <= 8; i++) {
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				String Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 15);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				String Mat = "BLACK_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
			meta.setDisplayName(ChatColor.GRAY + "Slot " + (i+1) + " " + ChatColor.RED + "Locked");
			if (i >= 0 && i <= 3) {
				lore.add(ChatColor.RED + "Requires " + ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.Locked_Slot.Rank_Requires_Prefix.Slots_13")));
				item.setItemMeta(meta);
			}
			if (i >= 4 && i <= 8) {
				lore.add(ChatColor.RED + "Requires " + ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.Locked_Slot.Rank_Requires_Prefix.Slots_18")));
				item.setItemMeta(meta);
			}
			inv.setItem(i, item);
			inv.setItem(i+9, item);
			inv.setItem(i+18, item);
			inv.setItem(i+27, item);
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				String Mat = "INK_SACK";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 1);
			}
			if (version.contains("1.13")) {
				String Mat = "ROSE_RED";
				item.setType(Material.valueOf(Mat)); 
			}
			if (version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				String Mat = "RED_DYE";
				item.setType(Material.valueOf(Mat)); 
			}
			inv.setItem(i+36, item);
		}
		// Set available Slot
		CheckPlayerSlot(p, inv, 2);
		return;
	}
	
	@SuppressWarnings("deprecation")
	public static void Bar(Inventory inv, int Page) {
		boolean Check = Main.ConfigData.getConfig().getBoolean("Wardrobe_Work.Go_Back.Enable");
		ItemStack Arrow = new ItemStack(Material.ARROW);
		ItemMeta ArrowMeta = Arrow.getItemMeta();
		if (Check) {
			ArrowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.Go_Back.Name")));
			List<String> lore = new ArrayList<String>();
			lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Go_Back.Lore"));
			for (int i = 0; i < lore.size(); i++) {
				lore.set(i, ChatColor.translateAlternateColorCodes('&',lore.get(i)));
			}
			ArrowMeta.setLore(lore);
			Arrow.setItemMeta(ArrowMeta);
			inv.setItem(48, Arrow);
		} else {
			ItemStack item = new ItemStack(Material.DIRT);
			ItemMeta meta = item.getItemMeta();
			// Create Base Item
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				String Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 15);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				String Mat = "BLACK_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
			// Back ground item
			meta.setDisplayName(" ");
			item.setItemMeta(meta);
			inv.setItem(48, item);
		}
		// Close button
		ItemStack CloseBut = new ItemStack(Material.BARRIER);
		ItemMeta CloseButMeta = CloseBut.getItemMeta();
		CloseButMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Close_Button.Name")));
		List<String> CloseButLore = new ArrayList<String>();
		CloseButLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Close_Button.Lore"));
		for (int i = 0; i < CloseButLore.size(); i++) {
			CloseButLore.set(i, ChatColor.translateAlternateColorCodes('&', CloseButLore.get(i)));
		}
		CloseButMeta.setLore(CloseButLore);
		CloseBut.setItemMeta(CloseButMeta);
		inv.setItem(49, CloseBut);
		if (Page == 1) {
			// Next button
			ItemStack Next = new ItemStack(Material.ARROW);
			ItemMeta NextMeta = Next.getItemMeta();
			NextMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Next_Page_Button.Name")));
			List<String> NextLore = new ArrayList<String>();
			NextLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Next_Page_Button.Lore"));
			for (int i = 0; i < NextLore.size(); i++) {
				NextLore.set(i, ChatColor.translateAlternateColorCodes('&', NextLore.get(i)));
			}
			NextMeta.setLore(NextLore);
			Next.setItemMeta(NextMeta);
			inv.setItem(53, Next);
		} else if (Page == 2) {
			// Previous button
			ItemStack Back = new ItemStack(Material.ARROW);
			ItemMeta BackMeta = Back.getItemMeta();
			BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Previous_Page_Button.Name")));
			List<String> BackLore = new ArrayList<String>();
			BackLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Previous_Page_Button.Lore"));
			for (int i = 0; i < BackLore.size(); i++) {
				BackLore.set(i, ChatColor.translateAlternateColorCodes('&', BackLore.get(i)));
			}
			BackMeta.setLore(BackLore);
			Back.setItemMeta(BackMeta);
			inv.setItem(45, Back);
		}
	}
	
	// Check Player rank now and pass
	@SuppressWarnings("deprecation")
	public void CheckPlayerSlot(Player p, Inventory inv, int Page) {
		if (Page == 2) {
			String MVPS = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_18");
			String ADMIN = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Admin");
			if (p.hasPermission(MVPS) || p.hasPermission(ADMIN)) {
				if (Main.WardrobePage2.containsKey(p.getUniqueId().toString())) 
					inv.setContents(Main.WardrobePage2.get(p.getUniqueId().toString()));
				String Check2 = Main.PlayerOldPermission.getConfig().getString("Player." + p.getUniqueId() + ".Old_Permission");
				if (Check2 == null || Check2.equalsIgnoreCase("group.default") || Check2.equalsIgnoreCase("group.vip") || Check2.equalsIgnoreCase("group.vip+")) {
					SetAvailableSlot(p,inv, 0, 8, -1, -1, Page);
				}
				else if (Check2 == "Nothing") {
					SetAvailableSlot(p,inv, 0, 8, -1, -1, Page);
					Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp+");
					Main.PlayerOldPermission.saveConfig();
					WardrobePage1(p);
					return;
				}
				else if (Check2.equalsIgnoreCase("group.mvp")) {
					for (int i = 0; i <= 8; i++) {
						ItemStack Check = inv.getItem(i);
						String CheckItem = "";
						if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
							CheckItem = Check.getData().toString();
						}
						if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
							CheckItem = Check.getType().toString();
						}
						if (CheckItem == "BLACK_STAINED_GLASS_PANE" || CheckItem.contains("STAINED_GLASS_PANE(15)")) {
							SetAvailableSlot(p,inv, i, 8, -1, -1, Page);
							Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp+");
							Main.PlayerOldPermission.saveConfig();
							return;
						}
					}
					SetAvailableSlot(p,inv, 4, 8, -1, -1, Page);
				}
				else if (Check2.equalsIgnoreCase("group.mvp+")) {
					for (int i = 0; i <= 8; i++) {
						ItemStack Check = inv.getItem(i);
						String CheckItem = "";
						if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
							CheckItem = Check.getData().toString();
						}
						if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
							CheckItem = Check.getType().toString();
						}
						if (CheckItem == "BLACK_STAINED_GLASS_PANE" || CheckItem.contains("STAINED_GLASS_PANE(15)")) {
							SetAvailableSlot(p,inv, i, 8, -1, -1, Page);
							Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp+");
							Main.PlayerOldPermission.saveConfig();
							return;
						}
					}
					SetAvailableSlot(p,inv, -1, -1, -1, -1, Page);
				}
				Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp+");
				Main.PlayerOldPermission.saveConfig();
				return;
			}
			String MVP = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_13");
			if (p.hasPermission(MVP)) {
				if (Main.WardrobePage2.containsKey(p.getUniqueId().toString())) 
					inv.setContents(Main.WardrobePage2.get(p.getUniqueId().toString()));
				String Check2 = Main.PlayerOldPermission.getConfig().getString("Player." + p.getUniqueId() + ".Old_Permission");
				if (Check2 == null || Check2.equalsIgnoreCase("group.default") || Check2.equalsIgnoreCase("group.vip") || Check2.equalsIgnoreCase("group.vip+")) {
					SetAvailableSlot(p,inv, 0, 3, 4, 8, Page);
				}
				else if (Check2 == "Nothing") {
					SetAvailableSlot(p,inv, 0, 3, -1, -1, Page);
					Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp+");
					Main.PlayerOldPermission.saveConfig();
					WardrobePage1(p);
					return;
				}
				else if (Check2.equalsIgnoreCase("group.mvp") || Check2.equalsIgnoreCase("group.mvp+")) {
					for (int i = 0; i <= 4; i++) {
						ItemStack Check = inv.getItem(i);
						String CheckItem = "";
						if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
							CheckItem = Check.getData().toString();
						}
						if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
							CheckItem = Check.getType().toString();
						}
						if (CheckItem == "BLACK_STAINED_GLASS_PANE" || CheckItem.contains("STAINED_GLASS_PANE(15)")) {
							SetAvailableSlot(p,inv, i, 3, 5, 8, Page);
							Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp");
							Main.PlayerOldPermission.saveConfig();
							return;
						}
					}
					SetAvailableSlot(p,inv, -1, -1, 4, 8, Page);
				}
				Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp");
				Main.PlayerOldPermission.saveConfig();
				return;
			}
			SetAvailableSlot(p,inv, -1, -1, 0, 8, Page);
			return;
		}
		if (Page == 1) {
			String MVPS = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_18");
			String ADMIN = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Admin");
			if (p.hasPermission(MVPS) || p.hasPermission(ADMIN)) {
				if (Main.WardrobePage1.containsKey(p.getUniqueId().toString())) 
					inv.setContents(Main.WardrobePage1.get(p.getUniqueId().toString()));
				String Check2 = Main.PlayerOldPermission.getConfig().getString("Player." + p.getUniqueId() + ".Old_Permission");
				if (Check2 == "Nothing") {
					SetAvailableSlot(p,inv, 0, 8, -1, -1, Page);
					Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "Nothing");
					Main.PlayerOldPermission.saveConfig();
					Main.WardrobePage1.put(p.getUniqueId().toString(), inv.getContents());
					Main.saveInv1();
					WardrobePage2(p);
					return;
				}
				for (int i = 0; i <= 8; i++) {
					ItemStack Check = inv.getItem(i);
					if (Check2 == null) {
						SetAvailableSlot(p,inv, 0, 8, -1, -1, Page);
						Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp+");
						Main.PlayerOldPermission.saveConfig();
						return;
					}
					String CheckItem = "";
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						CheckItem = Check.getData().toString();
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						CheckItem = Check.getType().toString();
					}
					if (CheckItem == "BLACK_STAINED_GLASS_PANE" || CheckItem.contains("STAINED_GLASS_PANE(15)") || Check == null) {
						SetAvailableSlot(p,inv, i, 8, -1, -1, Page);
						Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp+");
						Main.PlayerOldPermission.saveConfig();
						return;
					}
				}
				SetAvailableSlot(p,inv, -1, -1, -1, -1, Page);
				Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp+");
				Main.PlayerOldPermission.saveConfig();
				return;
			}
			String MVP = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_13");
			if (p.hasPermission(MVP)) {
				if (Main.WardrobePage1.containsKey(p.getUniqueId().toString())) 
					inv.setContents(Main.WardrobePage1.get(p.getUniqueId().toString()));
				String Check2 = Main.PlayerOldPermission.getConfig().getString("Player." + p.getUniqueId() + ".Old_Permission");
				if (Check2 == "Nothing") {
					SetAvailableSlot(p,inv, 0, 8, -1, -1, Page);
					Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "Nothing");
					Main.PlayerOldPermission.saveConfig();
					Main.WardrobePage1.put(p.getUniqueId().toString(), inv.getContents());
					WardrobePage2(p);
					Main.saveInv1();
					return;
				}
				for (int i = 0; i <= 8; i++) {
					ItemStack Check = inv.getItem(i);
					if (Check2 == null) {
						SetAvailableSlot(p,inv, 0, 8, -1, -1, Page);
						Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp+");
						Main.PlayerOldPermission.saveConfig();
						return;
					}
					String CheckItem = "";
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						CheckItem = Check.getData().toString();
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						CheckItem = Check.getType().toString();
					}
					if (CheckItem == "BLACK_STAINED_GLASS_PANE" || CheckItem.contains("STAINED_GLASS_PANE(15)") || Check == null) {
						SetAvailableSlot(p,inv, i, 8, -1, -1, Page);
						Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp");
						Main.PlayerOldPermission.saveConfig();
						return;
					}
				}
				SetAvailableSlot(p,inv, -1, -1, -1, -1, Page);
				Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.mvp");
				Main.PlayerOldPermission.saveConfig();
				return;
			}
			String VIPS = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_9");
			if (p.hasPermission(VIPS)) {
				String Check2 = Main.PlayerOldPermission.getConfig().getString("Player." + p.getUniqueId() + ".Old_Permission");
				if (Check2 == null) {
					SetAvailableSlot(p,inv, 0, 8, -1, -1, Page);
					Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.vip+");
					Main.PlayerOldPermission.saveConfig();
					return;
				}
				else if (Check2 == "Nothing") {
					SetAvailableSlot(p,inv, 0, 8, -1, -1, Page);
					Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.vip+");
					Main.PlayerOldPermission.saveConfig();
					return;
				}
				if (Main.WardrobePage1.containsKey(p.getUniqueId().toString())) 
					inv.setContents(Main.WardrobePage1.get(p.getUniqueId().toString()));
				if (Check2.equalsIgnoreCase("group.default")) {
					SetAvailableSlot(p,inv, 2, 8, -1, -1, Page);
				}
				else if (Check2.equalsIgnoreCase("group.vip")) {
					SetAvailableSlot(p,inv, 5, 8, -1, -1, Page);
				}
				else if (Check2.equalsIgnoreCase("group.vip+") || Check2.equalsIgnoreCase("group.mvp")|| Check2.equalsIgnoreCase("group.mvp+")) {
					SetAvailableSlot(p,inv, -1, -1, -1, -1, Page);
				}
				Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.vip+");
				Main.PlayerOldPermission.saveConfig();
				return;
			}
			String VIP = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_5");
			if (p.hasPermission(VIP)) {
				String Check2 = Main.PlayerOldPermission.getConfig().getString("Player." + p.getUniqueId() + ".Old_Permission");
				if (Check2 == null) {
					SetAvailableSlot(p,inv, 0, 4, 5, 8, Page);
					Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.vip");
					Main.PlayerOldPermission.saveConfig();
					return;
				}
				else if (Check2 == "Nothing") {
					SetAvailableSlot(p,inv, 0, 4, 5, 8, Page);
					Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.vip");
					Main.PlayerOldPermission.saveConfig();
					return;
				}
				if (Main.WardrobePage1.containsKey(p.getUniqueId().toString())) 
					inv.setContents(Main.WardrobePage1.get(p.getUniqueId().toString()));
				if (Check2.equalsIgnoreCase("group.default")) {
					SetAvailableSlot(p,inv, 2, 4, 5, 8, Page);
				}
				else if (Check2.equalsIgnoreCase("group.vip") || Check2.equalsIgnoreCase("group.vip+") || Check2.equalsIgnoreCase("group.mvp")|| Check2.equalsIgnoreCase("group.mvp+")) {
					SetAvailableSlot(p,inv, -1, -1, 5, 8, Page);
				}
				Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.vip");
				Main.PlayerOldPermission.saveConfig();
				return;
			}
			String DEFAULT = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_2");
			if (p.hasPermission(DEFAULT) || !p.hasPermission(DEFAULT)) {
				String Check2 = Main.PlayerOldPermission.getConfig().getString("Player." + p.getUniqueId() + ".Old_Permission");
				if (Check2 == null) {
					SetAvailableSlot(p,inv, 0, 1, 2, 8, Page);
					Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.default");
					Main.PlayerOldPermission.saveConfig();
					return;
				}
				else if (Check2 == "Nothing") {
					SetAvailableSlot(p,inv, 0, 1, 2, 8, Page);
					Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.default");
					Main.PlayerOldPermission.saveConfig();
					return;
				}
				else if (Check2.equalsIgnoreCase("group.default") || Check2.equalsIgnoreCase("group.vip")|| Check2.equalsIgnoreCase("group.vip+") || Check2.equalsIgnoreCase("group.mvp")|| Check2.equalsIgnoreCase("group.mvp+")) {
					if (Main.WardrobePage1.containsKey(p.getUniqueId().toString())) 
						inv.setContents(Main.WardrobePage1.get(p.getUniqueId().toString()));
					SetAvailableSlot(p,inv, -1, -1, 2, 8, Page);
				}
				Main.PlayerOldPermission.getConfig().set("Player." + p.getUniqueId().toString() + ".Old_Permission", "group.default");
				Main.PlayerOldPermission.saveConfig();
				return;
			}
		}
	}
	
	// Set the available slot for player
	@SuppressWarnings("deprecation")
	public void SetAvailableSlot(Player p, Inventory inv, int Start, int End, int StartLock, int EndLock, int Page) {
		if (Start != -1 && End != -1) {
			ItemStack item = new ItemStack(Material.DIRT);
			ItemMeta meta = item.getItemMeta();
			// Create Base Item
			String version = Bukkit.getServer().getVersion();
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				String Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 15);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				String Mat = "BLACK_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
			List<String> lore = new ArrayList<String>();
			String Mat = "";
			// Create Available Slot
			for (int i = Start; i <= End; i++) {
				if (i == 0) {
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						Mat = "STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
						item.setDurability((short) 14);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						Mat = "RED_STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
					}
					
				}
				if (i == 1) {
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						Mat = "STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
						item.setDurability((short) 1);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						Mat = "ORANGE_STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
					}
				}
				if (i == 2) {
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						Mat = "STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
						item.setDurability((short) 4);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						Mat = "YELLOW_STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
					}
				}
				if (i == 3) {
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						Mat = "STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
						item.setDurability((short) 5);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						Mat = "LIME_STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
					}
				}
				if (i == 4) {
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						Mat = "STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
						item.setDurability((short) 13);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						Mat = "GREEN_STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
					}
				}
				if (i == 5) {
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						Mat = "STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
						item.setDurability((short) 3);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						Mat = "LIGHT_BLUE_STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
					}
				}
				if (i == 6) {
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						Mat = "STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
						item.setDurability((short) 11);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						Mat = "BLUE_STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
					}
				}
				if (i == 7) {
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						Mat = "STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
						item.setDurability((short) 2);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						Mat = "MAGENTA_STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
					}
				}
				if (i == 8) {
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						Mat = "STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
						item.setDurability((short) 14);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						Mat = "PURPLE_STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
					}
				}
				//helmet background
				if (Page == 1) {
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Helmet.Name") .replace("%slot%", (Integer.toString(i+1) ))));
				}
				if (Page == 2) {
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Helmet.Name") .replace("%slot%", (Integer.toString(i+10) ))));
				}
				lore.clear();
				lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Helmet.Lore"));
				for (int x = 0; x < lore.size(); x++) {
					lore.set(x, ChatColor.translateAlternateColorCodes('&', lore.get(x)));
				}
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(i, item);
				//chestplate background
				if (Page == 1) {
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Chestplate.Name") .replace("%slot%", (Integer.toString(i+1) ))));
				}
				if (Page == 2) {
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Chestplate.Name") .replace("%slot%", (Integer.toString(i+10) ))));
				}
				lore.clear();
				lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Chestplate.Lore"));
				for (int x = 0; x < lore.size(); x++) {
					lore.set(x, ChatColor.translateAlternateColorCodes('&', lore.get(x)));
				}
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(i+9, item);
				//leggings background
				if (Page == 1) {
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Leggings.Name") .replace("%slot%", (Integer.toString(i+1) ))));
				}
				if (Page == 2) {
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Leggings.Name") .replace("%slot%", (Integer.toString(i+10) ))));
				}
				lore.clear();
				lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Leggings.Lore"));
				for (int x = 0; x < lore.size(); x++) {
					lore.set(x, ChatColor.translateAlternateColorCodes('&', lore.get(x)));
				}
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(i+18, item);
				//boots background
				if (Page == 1) {
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Boots.Name") .replace("%slot%", (Integer.toString(i+1) ))));
				}
				if (Page == 2) {
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Boots.Name") .replace("%slot%", (Integer.toString(i+10) ))));
				}
				lore.clear();
				lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Boots.Lore"));
				for (int x = 0; x < lore.size(); x++) {
					lore.set(x, ChatColor.translateAlternateColorCodes('&', lore.get(x)));
				}
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(i+27, item);
			}
			// Create Available Button Slot
			for (int i = Start; i <= End; i++) {
				if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
					Mat = "INK_SACK";
					item.setType(Material.valueOf(Mat));
					item.setDurability((short) 8);
				}
				if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
					Mat = "GRAY_DYE";
					item.setType(Material.valueOf(Mat));
				}
				if (Page == 1) {
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Empty_Button.Name") .replace("%slot%", (Integer.toString(i+1) ))));
				}
				if (Page == 2) {
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Empty_Button.Name") .replace("%slot%", (Integer.toString(i+10) ))));
				}
				lore.clear();
				lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Empty_Button.Lore"));
				for (int x = 0; x < lore.size(); x++) {
					lore.set(x, ChatColor.translateAlternateColorCodes('&', lore.get(x)));
				}
				meta.setLore(lore);
				item.setItemMeta(meta);
				inv.setItem(i+36, item);
			}
		}
		SetLockedSlot(p, inv, StartLock, EndLock, Page);
	}
	@SuppressWarnings("deprecation")
	public void SetLockedSlot(Player p, Inventory inv ,int StartLock, int EndLock, int Page) {
		String version = Bukkit.getServer().getVersion();
		if (StartLock != -1 && EndLock != -1) {
			ItemStack item = new ItemStack(Material.DIRT);
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				String Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 15);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				String Mat = "BLACK_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
			ItemMeta meta = item.getItemMeta();
			List<String> lore = new ArrayList<String>();
			lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Locked_Slot.Lore"));
			for (int i = 0; i < lore.size(); i++) {
				lore.set(i, ChatColor.translateAlternateColorCodes('&', lore.get(i)));
			}
			lore.add(" ");
			for (int i = StartLock; i <= EndLock; i++) {
				if (Page == 1) {
					// Requirement 
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						String Mat = "STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
						item.setDurability((short) 15);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						String Mat = "BLACK_STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
					}
					if (i >= 2 && i <= 4) {
						lore.set(lore.size()-1, ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.Locked_Slot.Rank_Requires_Prefix.Slots_5")));
					}
					if (i >= 5 && i <= 8) {
						lore.set(lore.size()-1, ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.Locked_Slot.Rank_Requires_Prefix.Slots_9")));
					}
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Locked_Slot.Name") .replace("%slot%", (Integer.toString(i+1) ))));
					meta.setLore(lore);
					item.setItemMeta(meta);
					
				}
				if (Page == 2) {
					// Requirement 
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						String Mat = "STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
						item.setDurability((short) 15);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						String Mat = "BLACK_STAINED_GLASS_PANE";
						item.setType(Material.valueOf(Mat));
					}
					if (i >= 0 && i <= 3) {
						lore.set(lore.size()-1, ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.Locked_Slot.Rank_Requires_Prefix.Slots_13")));
					}
					if (i >= 4 && i <= 8) {
						lore.set(lore.size()-1, ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.Locked_Slot.Rank_Requires_Prefix.Slots_18")));
					}
					meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Locked_Slot.Name") .replace("%slot%", (Integer.toString(i+10) ))));
					meta.setLore(lore);
					item.setItemMeta(meta);
				}
				//helmet
				inv.setItem(i, item);
				//chestplate
				inv.setItem(i+9, item);
				//leggings
				inv.setItem(i+18, item);
				//boots
				inv.setItem(i+27, item);
				//button
				if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
					String Mat = "INK_SACK";
					item.setType(Material.valueOf(Mat));
					item.setDurability((short) 1);
				}
				if (version.contains("1.13")) {
					String Mat = "ROSE_RED";
					item.setType(Material.valueOf(Mat)); 
				}
				if (version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
					String Mat = "RED_DYE";
					item.setType(Material.valueOf(Mat)); 
				}
				inv.setItem(i+36, item);
			}
		}
		// open the final gui for player
		Bar(inv, Page);
		p.openInventory(inv);
	}
	
	// Set inv slot if that have no armor
	@SuppressWarnings("deprecation")
	public static void setItem(Inventory inv, int Slot, int NumericalOrder) {
		String version = Bukkit.getServer().getVersion();
		ItemStack item = new ItemStack(Material.DIRT);
		ItemMeta meta = item.getItemMeta();
		String Mat = "";
		if (Slot == 0 || Slot == 9 || Slot == 18 || Slot == 27) {
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 14);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				Mat = "RED_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
		}
		if (Slot == 1 || Slot == 10 || Slot == 19 || Slot == 28) {
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 1);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				Mat = "ORANGE_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
		}
		if (Slot == 2 || Slot == 11 || Slot == 20 || Slot == 29) {
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 4);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				Mat = "YELLOW_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
		}
		if (Slot == 3 || Slot == 12 || Slot == 21 || Slot == 30) {
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 5);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				Mat = "LIME_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
		}
		if (Slot == 4 || Slot == 13 || Slot == 22 || Slot == 31) {
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 13);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				Mat = "GREEN_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
		}
		if (Slot == 5 || Slot == 14 || Slot == 23 || Slot == 32) {
			Mat = "LIGHT_BLUE_STAINED_GLASS_PANE";
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 4);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				Mat = "LIGHT_BLUE_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
		}
		if (Slot == 6 || Slot == 15 || Slot == 24 || Slot == 33) {
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 11);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				Mat = "BLUE_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
		}
		if (Slot == 7 || Slot == 16 || Slot == 25 || Slot == 34) {
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 2);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				Mat = "MAGENTA_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
		}
		if (Slot == 8 || Slot == 17 || Slot == 26 || Slot == 35) {
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 10);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				Mat = "PURPLE_STAINED_GLASS_PANE";
				item.setType(Material.valueOf(Mat));
			}
		}
		List<String> lore = new ArrayList<String>();
		if (Slot <= 8) {
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Helmet.Name") .replace("%slot%", (Integer.toString(NumericalOrder) ))));
			lore.clear();
			lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Helmet.Lore"));
			for (int x = 0; x < lore.size(); x++) {
				lore.set(x, ChatColor.translateAlternateColorCodes('&', lore.get(x)));
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(Slot, item);
		}
		if (Slot >= 9 && Slot <= 17) {
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Chestplate.Name") .replace("%slot%", (Integer.toString(NumericalOrder) ))));
			lore.clear();
			lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Chestplate.Lore"));
			for (int x = 0; x < lore.size(); x++) {
				lore.set(x, ChatColor.translateAlternateColorCodes('&', lore.get(x)));
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(Slot, item);
		}
		if (Slot >= 18 && Slot < 26) {
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Leggings.Name") .replace("%slot%", (Integer.toString(NumericalOrder) ))));
			lore.clear();
			lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Leggings.Lore"));
			for (int x = 0; x < lore.size(); x++) {
				lore.set(x, ChatColor.translateAlternateColorCodes('&', lore.get(x)));
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(Slot, item);
		}
		if (Slot >= 27 && Slot <= 35) {
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Boots.Name") .replace("%slot%", (Integer.toString(NumericalOrder) ))));
			lore.clear();
			lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Boots.Lore"));
			for (int x = 0; x < lore.size(); x++) {
				lore.set(x, ChatColor.translateAlternateColorCodes('&', lore.get(x)));
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(Slot, item);
		}
	}
	
	// Check that have no armor then return the ready button
	@SuppressWarnings("deprecation")
	public static void CheckSlot(int Slot,int Slot3, Inventory inv) {
		String version = Bukkit.getServer().getVersion();
		int Slot2 = Slot;
		int Slot4 = 0;
		if (Slot2 >= 0 && Slot2 <= 8) {
			Slot4 = Slot2;
			Slot2 += 36; 
		}
		if (Slot2 >= 9 && Slot2 <= 17) {
			Slot4 = Slot2 - 9;
			Slot2 += 27;
		}
		if (Slot2 >= 18 && Slot2 <= 26) {
			Slot4 = Slot2 - 18;
			Slot2 += 18; 
		}
		if (Slot2 >= 27 && Slot2 <= 35) {
			Slot4 = Slot2 - 27;
			Slot2 += 9; 
		}
		if (Slot2 >= 36 && Slot2 <= 44) {
			Slot4 = Slot2 - 36;
		}
		ItemStack Helmet = inv.getItem(Slot4);
		String HelmetSlot = Helmet.getType().toString();
		ItemStack Chestplate = inv.getItem((Slot4 + 9));
		String ChestplateSlot = Chestplate.getType().toString();
		ItemStack Leggings = inv.getItem((Slot4 + 18));
		String LeggingsSlot = Leggings.getType().toString();
		ItemStack Boots = inv.getItem((Slot4 + 27));
		String BootsSlot = Boots.getType().toString();
		
		if (HelmetSlot.endsWith("_GLASS_PANE") && ChestplateSlot.endsWith("GLASS_PANE") && LeggingsSlot.endsWith("GLASS_PANE") && BootsSlot.endsWith("GLASS_PANE")) {
			ItemStack item = new ItemStack(Material.DIRT);
			ItemMeta meta = item.getItemMeta();
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				String Mat = "INK_SACK";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 8);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				String Mat = "GRAY_DYE";
				item.setType(Material.valueOf(Mat));
			}
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Empty_Button.Name") .replace("%slot%", (Integer.toString(Slot3) ))));
			List<String> lore = new ArrayList<String>();
			lore.clear();
			lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Empty_Button.Lore"));
			for (int x = 0; x < lore.size(); x++) {
				lore.set(x, ChatColor.translateAlternateColorCodes('&', lore.get(x)));
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(Slot2, item);
		} else {
			ItemStack item = new ItemStack(Material.DIRT);
			ItemMeta meta = item.getItemMeta();
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				String Mat = "INK_SACK";
				item.setType(Material.valueOf(Mat));
				item.setDurability((short) 9);
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				String Mat = "PINK_DYE";
				item.setType(Material.valueOf(Mat));
			}
			meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(Slot3) ))));
			List<String> lore = new ArrayList<String>();
			lore.clear();
			lore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Ready_Button.Lore"));
			for (int x = 0; x < lore.size(); x++) {
				lore.set(x, ChatColor.translateAlternateColorCodes('&', lore.get(x)));
			}
			meta.setLore(lore);
			item.setItemMeta(meta);
			inv.setItem(Slot2, item);
		}
	}
	
	// Check player wardrobe equipped slot
	@SuppressWarnings("deprecation")
	public static int CheckEquippedSlot(Player p, Inventory inv) {
		String version = Bukkit.getServer().getVersion();
		for (int i = 36; i <= 44; i++) {
			if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
				ItemStack CheckSlot = inv.getItem(i);
				String Check = CheckSlot.getData().toString();
				if (Check.contains("LIME DYE(10)")) {
					return i;
				}
				
			}
			if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
				ItemStack CheckSlot = inv.getItem(i);
				String Check = CheckSlot.getType().toString();
				if (Check == "LIME_DYE") {
					return i;
				}
			}
		}
		return -1;
	}
	
	//Check player inventory space
	public static boolean GivePlayerEquippedArmor(Player p) {
		String version = Bukkit.getServer().getVersion();
		int ArmorCount = 0;
		int FreeSpace = 0;
		int NoSpace = 0;
		// Set the items in player armor slot
		ItemStack HelmetSlot = p.getInventory().getHelmet();
		ItemStack ChestplateSlot = p.getInventory().getChestplate();
		ItemStack LeggingsSlot = p.getInventory().getLeggings();
		ItemStack BootsSlot = p.getInventory().getBoots();
		// Check armor amount
		if (HelmetSlot != null) {
			ArmorCount++;
		}
		if (ChestplateSlot != null) {
			ArmorCount++;
		}
		if (LeggingsSlot != null) {
			ArmorCount++;
		}
		if (BootsSlot != null) {
			ArmorCount++;
		}
		if (ArmorCount == 1)
			NoSpace = 4;
		if (ArmorCount == 2)
			NoSpace = 3;
		if (ArmorCount == 3)
			NoSpace = 2;
		if (ArmorCount == 4)
			NoSpace = 1;
		for (ItemStack i : p.getInventory()) {
			if (i == null) {
				FreeSpace++;
			}
			if (FreeSpace - NoSpace >= ArmorCount) {
				// Give player that armor
				if (HelmetSlot != null) 
					p.getInventory().addItem(HelmetSlot);
				if (ChestplateSlot != null) 
					p.getInventory().addItem(ChestplateSlot);
				if (LeggingsSlot != null) 
					p.getInventory().addItem(LeggingsSlot);
				if (BootsSlot != null) 
					p.getInventory().addItem(BootsSlot);
				// Clear player armor slot
				ItemStack Clear = new ItemStack(Material.AIR);
				p.getInventory().setHelmet(Clear);
				p.getInventory().setChestplate(Clear);
				p.getInventory().setLeggings(Clear);
				p.getInventory().setBoots(Clear);
				return true;
			}
		}
		Location loc = p.getLocation();
		p.sendMessage(ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.No_Space")));
		String sound = "";
		if (version.contains("1.8")) {
			sound = "VILLAGER_NO";
			
		}
		if (version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12") || version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
			sound = "ENTITY_VILLAGER_NO";
		}
		p.playSound(loc, Sound.valueOf(sound), 1.0f, 1.0f);
		return false;
	}
	
	// Clear player armor
	public static void ClearPlayerArmor(Player p) {
		ItemStack Clear = new ItemStack(Material.AIR);
		p.getInventory().setHelmet(Clear);
		p.getInventory().setChestplate(Clear);
		p.getInventory().setLeggings(Clear);
		p.getInventory().setBoots(Clear);
	}
}
