package me.LucFr.Wardrobe.Work;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.LucFr.Wardrobe.Main;

public class WardrobeListener implements Listener, CommandExecutor{
	
	public Main plugin;
	public static Inventory Wardrobe1;
	public static Inventory Wardrobe2;
	public boolean checkbut = false;
	public String version = Bukkit.getServer().getVersion();
	private String Page1 = ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.GUI_Tile.Page_1"));
	private String Page2 = ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Work.GUI_Tile.Page_2"));
	
	WardrobeGui Gui = new WardrobeGui();
	
	public WardrobeListener(Main plugin) {
		
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
		plugin.getCommand("wardrobe").setExecutor(this);
	}
	
	// Wardrobe Command
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			if (args.length == 0) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "No player set!");
				return false;
			}
			if (args[0].equalsIgnoreCase("reload")) {
				Main.ConfigData.ReloadConfig();
				Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] Success reload the config!");
				return true;
			}
			Player target = Bukkit.getPlayer(args[1]);
			
			if (args.length == 2) {
				if (args[0].equalsIgnoreCase("reset")) {
					if (target != null) {
						Main.PlayerOldPermission.getConfig().set("Player." + target.getUniqueId().toString() + ".Old_Permission", "Nothing");
						Main.PlayerOldPermission.saveConfig();
						String Check = Main.PlayerOldPermission.getConfig().getString("Player." + target.getUniqueId() + ".Old_Permission");
						if (Check == "Nothing") {
							Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Success reset " + target.getName().toString() + " wardrobe!");
							return true;
						} else {
							Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "There is an error while doing this!");
							return false;
						}
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "That player is not online!");
						return false;
					}
				}
				if (args[0].equalsIgnoreCase("open")) {
					if (target != null) { 
						String MVPS = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_18");
						String MVP = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_13");
						if (target.hasPermission(MVPS) || target.hasPermission(MVP)) {
							Gui.WardrobePage2(target);
							Gui.WardrobePage1(target);
						} else Gui.WardrobePage1(target);
						if (target.getOpenInventory().getTitle().equals(Page1) || target.getOpenInventory().getTitle().equals(Page2))
							Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Success open Wardrobe for " + target.getName());
						return true;		
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "That player is not online!");
						return false;
					}
				} else {
					Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Permission_Denied")));;
					return false;
				}
			}
			if (args.length > 2) {
				Bukkit.getConsoleSender().sendMessage("Unknown command. Type \"/help\" for help.");
				return false;
			}
			if (target != null) {
				String MVPS = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_18");
				String MVP = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_13");
				if (target.hasPermission(MVPS) || target.hasPermission(MVP)) {
					Gui.WardrobePage2(target);
					Gui.WardrobePage1(target);
				} else Gui.WardrobePage1(target);
				return true;
						
			}
			else {
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "That not a online player!");
				return false;
			}
		}
		String ADMIN = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Admin");
		Player p = (Player) sender;
		if (args.length == 1) {
			if (p.isOp() || p.hasPermission(ADMIN)) {
				if (args[0].equalsIgnoreCase("reload")) {
					Main.ConfigData.ReloadConfig();
					p.sendMessage(ChatColor.GREEN + "[Wardrobe] Success reload the config!");
					return true;
				}
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Permission_Denied")));
				return false;
			}
		}
		if (args.length == 2) {
			if (p.isOp() || p.hasPermission(ADMIN)) {
				if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) {
						Main.PlayerOldPermission.getConfig().set("Player." + target.getUniqueId().toString() + ".Old_Permission", "Nothing");
						Main.PlayerOldPermission.saveConfig();
						String Check = Main.PlayerOldPermission.getConfig().getString("Player." + target.getUniqueId() + ".Old_Permission");
						if (Check == "Nothing") {
							p.sendMessage(ChatColor.GREEN + "Success reset " + target.getName().toString() + " wardrobe!");
							return true;
						} else {
							p.sendMessage(ChatColor.RED + "There is an error while doing this!");
							return false;
						}
					} else {
						p.sendMessage(ChatColor.RED + "That player is not online!");
						return false;
					}
				}
				if (args[0].equalsIgnoreCase("open")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
						String MVPS = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_18");
						String MVP = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_13");
						if (target.hasPermission(MVPS) || target.hasPermission(MVP)) {
							Gui.WardrobePage2(target);
							Gui.WardrobePage1(target);
						} else Gui.WardrobePage1(target);
						if (target.getOpenInventory().getTitle().equals(Page1) || target.getOpenInventory().getTitle().equals(Page2))
							p.sendMessage(ChatColor.GREEN + "Success open Wardrobe for " + target.getName());
						return true;		
					} else {
						p.sendMessage(ChatColor.RED + "That player is not online!");
						return false;
					}
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Permission_Denied")));;
					return false;
				}
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Permission_Denied")));;
				return false;
			}
		}
		if (args.length > 2) {
			p.sendMessage("Unknown command. Type \"/help\" for help.");
			return false;
		}
		String MVPS = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_18");
		String MVP = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_13");
		if (p.hasPermission(MVPS) || p.hasPermission(MVP)) {
			String Check = Main.PlayerOldPermission.getConfig().getString("Player." + p.getUniqueId() + ".Old_Permission");
			if (Check == "Nothing") {
				Gui.WardrobePage1(p);
				return true;
			}
			Gui.WardrobePage2(p);
			Gui.WardrobePage1(p);
			return true;
		}
		Gui.WardrobePage1(p);
		return true;
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getView().getTitle().equals(Page1) || e.getView().getTitle().equals(Page2)) {
			Player p = (Player) e.getWhoClicked();
			Inventory inv = e.getClickedInventory();
			Inventory inv2 = e.getInventory();
			Location loc = p.getLocation();
			if (inv != null) {
				if (e.getSlot() >= 45 && e.getSlot() <= 53) {
					ItemStack ItemOnCursor = p.getItemOnCursor();
					// Back ground Cancel
					e.setCancelled(true);
					// Close button
					if (e.getSlot() == 49) {
						if (ItemOnCursor != null) {
							p.getInventory().addItem(ItemOnCursor);
							p.setItemOnCursor(null);
						}
						p.closeInventory();
					}
					// Go back button
					if (e.getSlot() == 48) {
						boolean Check = Main.ConfigData.getConfig().getBoolean("Wardrobe_Work.Go_Back.Enable");
						if (Check) {
							if (ItemOnCursor != null) {
								p.getInventory().addItem(ItemOnCursor);
								p.setItemOnCursor(null);
							}
							String Command = Main.ConfigData.getConfig().getString("Wardrobe_Work.Go_Back.Command");
							p.performCommand("/"+Command);
						}
					}
					// Change page button
					if (e.getView().getTitle().equals(Page1)) {
						if (e.getSlot() == 53) {
							if (ItemOnCursor != null) {
								p.getInventory().addItem(ItemOnCursor);
								p.setItemOnCursor(null);
							}
							Gui.WardrobePage2(p);
						}
					}
					if (e.getView().getTitle().equals(Page2)) {
						if (e.getSlot() == 45) {
							if (ItemOnCursor != null) {
								p.getInventory().addItem(ItemOnCursor);
								p.setItemOnCursor(null);
							}
							Gui.WardrobePage1(p);
						}
					}
				}
				String CheckItem = "";
				// Clicked Item and Player item on cursor
				ItemStack Check = null;
				ItemStack ItemClicked = e.getCurrentItem();
				String ClickedItem = "";
				ItemStack ItemOnCursor = p.getItemOnCursor();
				String CursorItem = ItemOnCursor.getType().toString();
				if(e.getClickedInventory().getType() == InventoryType.PLAYER) {
					e.setCancelled(false);
					if (ItemClicked == null) return;
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						ClickedItem = ItemClicked.getData().toString();
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						ClickedItem = ItemClicked.getType().toString();
					}
					if (e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT) {
						String CheckLore = Main.ConfigData.getConfig().getString("Wardrobe_Work.Helmet_Lore_Check");
						boolean CheckLoreBool = false;
						if (ItemClicked != null && ItemClicked.getItemMeta() != null && ItemClicked.getItemMeta().getLore() != null) {
							for (int i = 0; i < ItemClicked.getItemMeta().getLore().size(); i++) {
								if (ItemClicked.getItemMeta().getLore().get(i).endsWith(CheckLore) || ItemClicked.getItemMeta().getLore().get(i).startsWith(CheckLore)) {
									CheckLoreBool = true;
								}
							}
						}
						if (CheckLoreBool || ClickedItem.endsWith("PLAYER_HEAD") || ClickedItem.endsWith("_HELMET") || ClickedItem.endsWith("_HELMET(0)") || ClickedItem.endsWith("ELYTRA") || ClickedItem.endsWith("_CHESTPLATE") || ClickedItem.endsWith("_CHESTPLATE(0)") || ClickedItem.endsWith("_LEGGINGS") || ClickedItem.endsWith("_LEGGINGS(0)") || ClickedItem.endsWith("_BOOTS") || ClickedItem.endsWith("_BOOTS(0)")) {
							int Start = 0;
							int End = 0;
							int CheckButton = 0;
							if (CheckLoreBool || ClickedItem.endsWith("PLAYER_HEAD") ||  ClickedItem.endsWith("_HELMET") || ClickedItem.endsWith("_HELMET(0)")) {
								Start = 0;
								End = 8;
							}
							if (ClickedItem.endsWith("_CHESTPLATE") || ClickedItem.endsWith("ELYTRA") || ClickedItem.endsWith("ELYTRA(0)") || ClickedItem.endsWith("_CHESTPLATE(0)")) {
								Start = 9;
								End = 17;
							}
							if (ClickedItem.endsWith("_LEGGINGS") || ClickedItem.endsWith("_LEGGINGS(0)")) {
								Start = 18;
								End = 26;
							}
							if (ClickedItem.endsWith("_BOOTS") || ClickedItem.endsWith("_BOOTS(0)")) {
								Start = 27;
								End = 35;
							}
							for (int i = Start; i <= End; i++) {
								if (e.getView().getTitle().equals(Page1)) {
									Check = inv2.getItem(i);
								}
								if (e.getView().getTitle().equals(Page2)) {
									Check = inv2.getItem(i);
								}
								String CheckSlot = Check.getType().toString();
								String Check2 = "";
								if (i >= 0 && i <= 8) {
									CheckButton = i + 36;
								}
								if (i >= 9 && i <= 17) {
									CheckButton = i + 27;
								}
								if (i >= 18 && i <= 26) {
									CheckButton = i + 18;
								}
								if (i >= 27 && i <= 35) {
									CheckButton = i + 8;
								}
								String CheckButton1 = inv2.getItem(CheckButton).getType().toString();
								if (CheckButton1 == "LIME_DYE" || CheckButton1.contains("LIME_DYE(10)")) {
									if (i + 1 == 9 || i + 1 == 18 || i + 1 == 27 || i + 1 == 36) return;
								}
								if (CheckSlot.endsWith("STAINED_GLASS_PANE")) {
									if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
										Check2 = Check.getData().toString();
									}
									if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
										Check2 = Check.getType().toString();
									}
									if (Check2 != "BLACK_STAINED_GLASS_PANE" && !(Check2.contains("STAINED_GLASS_PANE(15)"))) {
										inv2.setItem(i, ItemClicked);
										inv.setItem(e.getSlot(), null);
										ItemStack Button = new ItemStack(Material.DIRT);
									    ItemMeta ButtonMeta = Button.getItemMeta();
									    if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
											String Mat = "INK_SACK";
											Button.setType(Material.valueOf(Mat));
											Button.setDurability((short) 9);
										}
										if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
											String Mat = "PINK_DYE";
											Button.setType(Material.valueOf(Mat));
										}
									    List<String> ButtonLore = new ArrayList<String>();
									    ButtonLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Ready_Button.Lore"));
										for (int x = 0; x < ButtonLore.size(); x++) {
											ButtonLore.set(x, ChatColor.translateAlternateColorCodes('&', ButtonLore.get(x)));
										}
										ButtonMeta.setLore(ButtonLore);
										if (e.getView().getTitle().equals(Page1)) {
											if (CheckLoreBool || ClickedItem.endsWith("_HELMET") || ClickedItem.endsWith("_HELMET(0)")) {
												ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(i+1) ))));
											}
											if (ClickedItem.endsWith("_CHESTPLATE") || ClickedItem.endsWith("ELYTRA") || ClickedItem.endsWith("_CHESTPLATE(0)")) {
												ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(i-8) ))));
											}
											if (ClickedItem.endsWith("_LEGGINGS") || ClickedItem.endsWith("_LEGGINGS(0)")) {
												ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(i-17) ))));
											}
											if (ClickedItem.endsWith("_BOOTS") || ClickedItem.endsWith("_BOOTS(0)")) {
												ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(i-26) ))));
											}
										}
										if (e.getView().getTitle().equals(Page2)) {
											if (CheckLoreBool || ClickedItem.endsWith("_HELMET") || ClickedItem.endsWith("_HELMET(0)")) {
												ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(i+10) ))));
											}
											if (ClickedItem.endsWith("_CHESTPLATE") || ClickedItem.endsWith("ELYTRA") || ClickedItem.endsWith("_CHESTPLATE(0)")) {
												ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(i+1) ))));
											}
											if (ClickedItem.endsWith("_LEGGINGS") || ClickedItem.endsWith("_LEGGINGS(0)")) {
												ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(i+-8) ))));
											}
											if (ClickedItem.endsWith("_BOOTS") || ClickedItem.endsWith("_BOOTS(0)")) {
												ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(i-17) ))));
											}
										}
										ButtonMeta.setLore(ButtonLore);
										Button.setItemMeta(ButtonMeta);
										if (CheckLoreBool || ClickedItem.endsWith("_HELMET") || ClickedItem.endsWith("_HELMET(0)")) {
											inv2.setItem((i + 9*4), Button);
										}
										if (ClickedItem.endsWith("_CHESTPLATE") || ClickedItem.endsWith("ELYTRA") || ClickedItem.endsWith("ELYTRA(0)") || ClickedItem.endsWith("_CHESTPLATE(0)")) {
											inv2.setItem((i + 9*3), Button);
										}
										if (ClickedItem.endsWith("_LEGGINGS") || ClickedItem.endsWith("_LEGGINGS(0)")) {
											inv2.setItem((i + 9*2), Button);
										}
										if (ClickedItem.endsWith("_BOOTS") || ClickedItem.endsWith("_BOOTS(0)")) {
											inv2.setItem((i + 9), Button);
										}
										p.updateInventory();
										return;
									}
								}
							}
						}
					}
				} else {
					String CheckLore = Main.ConfigData.getConfig().getString("Wardrobe_Work.Helmet_Lore_Check");
					boolean CheckLoreBool = false;
					if (ItemClicked != null && ItemClicked.getItemMeta() != null && ItemClicked.getItemMeta().getLore() != null) {
						for (int i = 0; i < ItemClicked.getItemMeta().getLore().size(); i++) {
							if (ItemClicked.getItemMeta().getLore().get(i).endsWith(CheckLore) || ItemClicked.getItemMeta().getLore().get(i).startsWith(CheckLore)) {
								CheckLoreBool = true;
							}
						}
					}
					boolean CheckLoreBool2 = false;
					if (ItemOnCursor != null && ItemOnCursor.getItemMeta() != null && ItemOnCursor.getItemMeta().getLore() != null) {
						for (int i = 0; i < ItemOnCursor.getItemMeta().getLore().size(); i++) {
							if (ItemOnCursor.getItemMeta().getLore().get(i).endsWith(CheckLore) || ItemOnCursor.getItemMeta().getLore().get(i).startsWith(CheckLore)) {
								CheckLoreBool2 = true;
							}
						}
					}
					e.setCancelled(true);
					if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						ClickedItem = ItemClicked.getData().toString();
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						ClickedItem = ItemClicked.getType().toString();
					}
					// Equip button
					ItemStack Button = new ItemStack(Material.DIRT);
				    ItemMeta ButtonMeta = Button.getItemMeta();
				    if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
						String Mat = "INK_SACK";
						Button.setType(Material.valueOf(Mat));
						Button.setDurability((short) 9);
					}
					if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
						String Mat = "PINK_DYE";
						Button.setType(Material.valueOf(Mat));
					}
				    List<String> ButtonLore = new ArrayList<String>();
				    ButtonLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Ready_Button.Lore"));
					for (int x = 0; x < ButtonLore.size(); x++) {
						ButtonLore.set(x, ChatColor.translateAlternateColorCodes('&', ButtonLore.get(x)));
					}
					ButtonMeta.setLore(ButtonLore);
					
					// Change gui if player drag a armor into armor slot
					if (e.getSlot() >= 0 && e.getSlot() <= 8) {
						e.setCancelled(true);
						ItemStack ChangeButton = inv.getItem(e.getSlot()+36);
						String PresentButton = "";
						if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
							PresentButton = ChangeButton.getData().toString();
							
						} else if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
							PresentButton = ChangeButton.getType().toString();
						}
						if (PresentButton == "LIME_DYE" ||  PresentButton.contains("LIME DYE(10)")) {
							p.sendMessage(ChatColor.RED + ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Modify_Armor_Denied")));
							String sound = "";
							if (version.contains("1.8")) {
								sound = "VILLAGER_NO";
							}
							if (version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12") || version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
								sound = "ENTITY_VILLAGER_NO";
							}
							p.playSound(loc, Sound.valueOf(sound), 1.0f, 1.0f);
							return;
						}
						if (CheckLoreBool2 || CursorItem.endsWith("_HELMET") || CursorItem.endsWith("_HELMET(0)")) {
							if (PresentButton == "LIME_DYE" ||  PresentButton.contains("LIME DYE(10)")) {
								p.sendMessage(ChatColor.RED + ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Modify_Armor_Denied")));
								String sound = "";
								if (version.contains("1.8")) {
									sound = "VILLAGER_NO";
								}
								if (version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12") || version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									sound = "ENTITY_VILLAGER_NO";
								}
								p.playSound(loc, Sound.valueOf(sound), 1.0f, 1.0f);
								return;
							}
							else if (CheckLoreBool || ClickedItem.endsWith("_HELMET") || ClickedItem.endsWith("_HELMET(0)")) {
								ItemStack SwapItem = ItemClicked;
								Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
									@Override
									public void run() {
										inv.setItem(e.getSlot(), ItemOnCursor);
										p.setItemOnCursor(SwapItem);
									}
								}, 1L);
							}
							else if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
									CheckItem = "STAINED_GLASS_PANE(15)";
								}
								if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									CheckItem = "BLACK_STAINED_GLASS_PANE";
								}
								if (!(ClickedItem.contains(CheckItem))) {
								inv.setItem(e.getSlot(), ItemOnCursor);
								p.setItemOnCursor(null);
								if (e.getView().getTitle().equals(Page1))
									ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()+1) ))));
								if (e.getView().getTitle().equals(Page2))
									ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()+10) ))));
								ButtonMeta.setLore(ButtonLore);
								Button.setItemMeta(ButtonMeta);
								inv.setItem(e.getSlot() + 9*4, Button);
							} else e.setCancelled(true);
						}
					}
					if (e.getSlot() >= 9 && e.getSlot() <= 17) {
						e.setCancelled(true);
						ItemStack ChangeButton = inv.getItem(e.getSlot()+27);
						String PresentButton = "";
						if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
							PresentButton = ChangeButton.getData().toString();
						}else if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
							PresentButton = ChangeButton.getType().toString();
						}
						if (PresentButton == "LIME_DYE" ||  PresentButton.contains("LIME DYE(10)")) {
							p.sendMessage(ChatColor.RED + ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Modify_Armor_Denied")));
							String sound = "";
							if (version.contains("1.8")) {
								sound = "VILLAGER_NO";
							}
							if (version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12") || version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
								sound = "ENTITY_VILLAGER_NO";
							}
							p.playSound(loc, Sound.valueOf(sound), 1.0f, 1.0f);
							return;
						}
						if (CursorItem.endsWith("_CHESTPLATE") || CursorItem.endsWith("_CHESTPLATE(0)") || CursorItem.endsWith("ELYTRA") || CursorItem.endsWith("ELYTRA(0)")) {
							if (PresentButton == "LIME_DYE" ||  PresentButton.contains("LIME DYE(10)")) {
								p.sendMessage(ChatColor.RED + ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Modify_Armor_Denied")));
								String sound = "";
								if (version.contains("1.8")) {
									sound = "VILLAGER_NO";
								}
								if (version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12") || version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									sound = "ENTITY_VILLAGER_NO";
								}
								p.playSound(loc, Sound.valueOf(sound), 1.0f, 1.0f);
								return;
							}
							else if (ClickedItem.endsWith("_CHESTPLATE") || ClickedItem.endsWith("_CHESTPLATE(0)") || ClickedItem.endsWith("ELYTRA") || ClickedItem.endsWith("ELYTRA(0)")) {
								ItemStack SwapItem = ItemClicked;
								Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
									@Override
									public void run() {
										inv.setItem(e.getSlot(), ItemOnCursor);
										p.setItemOnCursor(SwapItem);
									}
								}, 1L);
							}
							else if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
									CheckItem = "STAINED_GLASS_PANE(15)";
								}
								if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									CheckItem = "BLACK_STAINED_GLASS_PANE";
								}
								if (!(ClickedItem.contains(CheckItem))) {
								inv.setItem(e.getSlot(), ItemOnCursor);
								p.setItemOnCursor(null);
								if (e.getView().getTitle().equals(Page1))
									ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-8) ))));
								if (e.getView().getTitle().equals(Page2))
									ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()+1) ))));
								Button.setItemMeta(ButtonMeta);
								inv.setItem(e.getSlot() + 9*3, Button);
							} else e.setCancelled(true);
						}
					}
					if (e.getSlot() >= 18 && e.getSlot() <= 26) {
						e.setCancelled(true);
						ItemStack ChangeButton = inv.getItem(e.getSlot()+18);
						String PresentButton = "";
						if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
							PresentButton = ChangeButton.getData().toString();
						} else if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
							PresentButton = ChangeButton.getType().toString();
						}
						if (PresentButton == "LIME_DYE" ||  PresentButton.contains("LIME DYE(10)")) {
							p.sendMessage(ChatColor.RED + ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Modify_Armor_Denied")));
							String sound = "";
							if (version.contains("1.8")) {
								sound = "VILLAGER_NO";
								
							}
							if (version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12") || version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
								sound = "ENTITY_VILLAGER_NO";
							}
							p.playSound(loc, Sound.valueOf(sound), 1.0f, 1.0f);
							return;
						}
						if (CursorItem.endsWith("_LEGGINGS") || CursorItem.endsWith("_LEGGINGS(0)")) {
							if (PresentButton == "LIME_DYE" ||  PresentButton.contains("LIME DYE(10)")) {
								p.sendMessage(ChatColor.RED + ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Modify_Armor_Denied")));
								String sound = "";
								if (version.contains("1.8")) {
									sound = "VILLAGER_NO";
								}
								if (version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12") || version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									sound = "ENTITY_VILLAGER_NO";
								}
								p.playSound(loc, Sound.valueOf(sound), 1.0f, 1.0f);
								return;
							}
							else if (ClickedItem.endsWith("_LEGGINGS") || ClickedItem.endsWith("_LEGGINGS(0)")) {
								ItemStack SwapItem = ItemClicked;
								Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
									@Override
									public void run() {
										inv.setItem(e.getSlot(), ItemOnCursor);
										p.setItemOnCursor(SwapItem);
									}
								}, 1L);
							}
							else if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
								CheckItem = "STAINED_GLASS_PANE(15)";
								}
								if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									CheckItem = "BLACK_STAINED_GLASS_PANE";
								}
								if (!(ClickedItem.contains(CheckItem))) {
								inv.setItem(e.getSlot(), ItemOnCursor);
								p.setItemOnCursor(null);
								if (e.getView().getTitle().equals(Page1))
									ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-17) ))));
								if (e.getView().getTitle().equals(Page2))
									ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-8) ))));
								Button.setItemMeta(ButtonMeta);
								inv.setItem(e.getSlot() + 9*2, Button);
							} else e.setCancelled(true);
						}
					}
					if (e.getSlot() >= 27 && e.getSlot() <= 35) {
						e.setCancelled(true);
						ItemStack ChangeButton = inv.getItem(e.getSlot()+9);
						String PresentButton = "";
						if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
							PresentButton = ChangeButton.getData().toString();
						} else if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
							PresentButton = ChangeButton.getType().toString();
						}
						if (PresentButton == "LIME_DYE" ||  PresentButton.contains("LIME DYE(10)")) {
							p.sendMessage(ChatColor.RED + ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Modify_Armor_Denied")));
							String sound = "";
							if (version.contains("1.8")) {
								sound = "VILLAGER_NO";
							}
							if (version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12") || version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
								sound = "ENTITY_VILLAGER_NO";
							}
							p.playSound(loc, Sound.valueOf(sound), 1.0f, 1.0f);
							return;
						}
						if (CursorItem.endsWith("_BOOTS") || CursorItem.endsWith("_BOOTS(0)")) {
							if (PresentButton == "LIME_DYE" ||  PresentButton.contains("LIME DYE(10)")) {
								p.sendMessage(ChatColor.RED + ChatColor.translateAlternateColorCodes('&',Main.ConfigData.getConfig().getString("Wardrobe_Message.Modify_Armor_Denied")));
								String sound = "";
								if (version.contains("1.8")) {
									sound = "VILLAGER_NO";
								}
								if (version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12") || version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									sound = "ENTITY_VILLAGER_NO";
								}
								p.playSound(loc, Sound.valueOf(sound), 1.0f, 1.0f);
								return;
							}
							else if (ClickedItem.endsWith("_BOOTS") || ClickedItem.endsWith("_BOOTS(0)")) {
								ItemStack SwapItem = ItemClicked;
								Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
									@Override
									public void run() {
										inv.setItem(e.getSlot(), ItemOnCursor);
										p.setItemOnCursor(SwapItem);
									}
								}, 1L);
							}
							else if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
									CheckItem = "STAINED_GLASS_PANE(15)";
								}
								if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									CheckItem = "BLACK_STAINED_GLASS_PANE";
								}
								if (!(ClickedItem.contains(CheckItem))) {
								inv.setItem(e.getSlot(), ItemOnCursor);
								p.setItemOnCursor(null);
								if (e.getView().getTitle().equals(Page1))	
									ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-26) ))));
								if (e.getView().getTitle().equals(Page2))	
									ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-17) ))));
								Button.setItemMeta(ButtonMeta);
								inv.setItem(e.getSlot() + 9, Button);
							} else e.setCancelled(true);
						}
					}
					
					// Set Item on Player Cursor to clicked armor if clicked slot is armor
					if (e.getSlot() >=0 && e.getSlot() <= 35) {
						if (CheckLoreBool || ClickedItem.endsWith("_HELMET") || ClickedItem.endsWith("_HELMET(0)")) {
							if (CursorItem.contains("AIR") || ItemOnCursor == null) {
								ItemStack PresentButton = inv.getItem(e.getSlot()+36);
								String ButtonCheck = "";
								if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
									ButtonCheck = PresentButton.getData().toString();
								}
								if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									ButtonCheck = PresentButton.getType().toString();
								}
								if (ButtonCheck == "PINK_DYE" || ButtonCheck.contains("PINK DYE(9)")) {
									if (e.getClick() == ClickType.LEFT) {
										p.setItemOnCursor(ItemClicked);
										if (e.getView().getTitle().equals(Page1)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() + 1));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()+1, inv);
										}
										if (e.getView().getTitle().equals(Page2)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() + 10));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()+10, inv);
										}
									}
									if (e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT) {
										p.getInventory().addItem(ItemClicked);
										if (e.getView().getTitle().equals(Page1)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() + 1));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()+1, inv);
										}
										if (e.getView().getTitle().equals(Page2)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() + 10));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()+10, inv);
										}
									}
								}
							}
						}
						if (ClickedItem.endsWith("_CHESTPLATE") || ClickedItem.endsWith("ELYTRA") || ClickedItem.endsWith("ELYTRA(0)") || ClickedItem.endsWith("_CHESTPLATE(0)")) {
							if (CursorItem.contains("AIR") || ItemOnCursor == null) {
								ItemStack PresentButton = inv.getItem(e.getSlot()+27);
								String ButtonCheck = "";
								if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
									ButtonCheck = PresentButton.getData().toString();
								}
								if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									ButtonCheck = PresentButton.getType().toString();
								}
								if (ButtonCheck == "PINK_DYE" || ButtonCheck.contains("PINK DYE(9)")) {
									if (e.getClick() == ClickType.LEFT) {
										p.setItemOnCursor(ItemClicked);
										if (e.getView().getTitle().equals(Page1)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() + - 8));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-8, inv);
										}
										if (e.getView().getTitle().equals(Page2)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() + 1));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()+1, inv);
										}
									}
									if (e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT) {
										p.getInventory().addItem(ItemClicked);
										if (e.getView().getTitle().equals(Page1)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() + - 8));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-8, inv);
										}
										if (e.getView().getTitle().equals(Page2)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() + 1));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()+1, inv);
										}
									}
								}
							}
						}
						if (ClickedItem.endsWith("_LEGGINGS") || ClickedItem.endsWith("_LEGGINGS(0)")) {
							if (CursorItem.contains("AIR") || ItemOnCursor == null) {
								ItemStack PresentButton = inv.getItem(e.getSlot()+18);
								String ButtonCheck = "";
								if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
									ButtonCheck = PresentButton.getData().toString();
								
								}
								if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									ButtonCheck = PresentButton.getType().toString();
								}
								if (ButtonCheck == "PINK_DYE" || ButtonCheck.contains("PINK DYE(9)")) {
									if (e.getClick() == ClickType.LEFT) {
										p.setItemOnCursor(ItemClicked);
										if (e.getView().getTitle().equals(Page1)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() - 17));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-17, inv);
										}
										if (e.getView().getTitle().equals(Page2)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() -8));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-8, inv);
										}
									}
									if (e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT) {
										p.getInventory().addItem(ItemClicked);
										if (e.getView().getTitle().equals(Page1)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() - 17));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-17, inv);
										}
										if (e.getView().getTitle().equals(Page2)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() -8));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-8, inv);
										}
									}
								}
							}
						}
						if (ClickedItem.endsWith("_BOOTS") || ClickedItem.endsWith("_BOOTS(0)")) {
							if (CursorItem.contains("AIR") || ItemOnCursor == null) {
								ItemStack PresentButton = inv.getItem(e.getSlot()+9);
								String ButtonCheck = "";
								if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
									ButtonCheck = PresentButton.getData().toString();
								}
								if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
									ButtonCheck = PresentButton.getType().toString();
								}
								if (ButtonCheck == "PINK_DYE" || ButtonCheck.contains("PINK DYE(9)")) {
									if (e.getClick() == ClickType.LEFT) {
										p.setItemOnCursor(ItemClicked);
										if (e.getView().getTitle().equals(Page1)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() - 26));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-26, inv);
										}
										if (e.getView().getTitle().equals(Page2)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() - 17));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-17, inv);
										}
									}
									if (e.getClick() == ClickType.SHIFT_LEFT || e.getClick() == ClickType.SHIFT_RIGHT) {
										p.getInventory().addItem(ItemClicked);
										if (e.getView().getTitle().equals(Page1)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() - 26));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-26, inv);
										}
										if (e.getView().getTitle().equals(Page2)) {
											WardrobeGui.setItem(inv, e.getSlot(), (e.getSlot() - 17));
											WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-17, inv);
										}
									}
								}
							}
						}
						if (ItemOnCursor.getType() == null) e.setCancelled(true);
						else e.setCancelled(true);
					}
					// Change Button
					if (e.getSlot() >= 36 && e.getSlot() <= 44) {
						e.setCancelled(true);
						if (ClickedItem == "PINK_DYE" || ClickedItem.contains("PINK DYE(9)")) {
							String MVPS = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_18");
							String MVP = Main.ConfigData.getConfig().getString("Wardrobe_Work.Rank_Slots.Slots_13");
							if (p.hasPermission(MVPS) || p.hasPermission(MVP)) {
								if (WardrobeGui.CheckEquippedSlot(p, Wardrobe1) == -1 && WardrobeGui.CheckEquippedSlot(p, Wardrobe2) == -1) {
									// If player have enough space
									if (WardrobeGui.GivePlayerEquippedArmor(p)) {
										ItemStack ChangeButton = new ItemStack(Material.DIRT);
										ItemMeta ButtonChangeMeta = ChangeButton.getItemMeta();
										if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
											String Mat = "INK_SACK";
											ChangeButton.setType(Material.valueOf(Mat));
											ChangeButton.setDurability((short) 10);
										}
										if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
											String Mat = "LIME_DYE";
											ChangeButton.setType(Material.valueOf(Mat));
										}
										if (e.getView().getTitle().equals(Page1))
											ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Equipped_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-35) ))));
										if (e.getView().getTitle().equals(Page2))
											ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Equipped_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-26) ))));
										List<String> ButtonChangeLore = new ArrayList<String>();
										ButtonChangeLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Euipped_Button.Lore"));
										for (int x = 0; x < ButtonChangeLore.size(); x++) {
											ButtonChangeLore.set(x, ChatColor.translateAlternateColorCodes('&', ButtonChangeLore.get(x)));
										}
										ButtonChangeMeta.setLore(ButtonChangeLore);
										ChangeButton.setItemMeta(ButtonChangeMeta);
										inv.setItem(e.getSlot(), ChangeButton);
										p.updateInventory();
									} else return;
								} else if (WardrobeGui.CheckEquippedSlot(p, Wardrobe1) != -1 && WardrobeGui.CheckEquippedSlot(p, Wardrobe2) == -1) {
									// If player have euipped wardrobe slot
									WardrobeGui.ClearPlayerArmor(p);
									int Number = (WardrobeGui.CheckEquippedSlot(p, Wardrobe1) - 36);
									ItemStack ChangeButton = new ItemStack(Material.DIRT);
									ItemMeta ButtonChangeMeta = ChangeButton.getItemMeta();
									if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
										String Mat = "INK_SACK";
										ChangeButton.setType(Material.valueOf(Mat));
										ChangeButton.setDurability((short) 9);
									}
									if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
										String Mat = "PINK_DYE";
										ChangeButton.setType(Material.valueOf(Mat));
									}
								    ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-35) ))));
								    List<String> ButtonChangeLore = new ArrayList<String>();
								    ButtonChangeLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Ready_Button.Lore"));
									for (int x = 0; x < ButtonChangeLore.size(); x++) {
										ButtonChangeLore.set(x, ChatColor.translateAlternateColorCodes('&', ButtonChangeLore.get(x)));
									}
								    ButtonChangeMeta.setLore(ButtonChangeLore);
								    ChangeButton.setItemMeta(ButtonChangeMeta);
								    Wardrobe1.setItem(WardrobeGui.CheckEquippedSlot(p, Wardrobe1), ChangeButton);
								    WardrobeGui.CheckSlot(Number, Number+1, Wardrobe1);
								    Main.WardrobePage1.put(p.getUniqueId().toString(), Wardrobe1.getContents());
									Main.saveInv1();

									if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
										String Mat = "INK_SACK";
										ChangeButton.setType(Material.valueOf(Mat));
										ChangeButton.setDurability((short) 10);
									}
									if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
										String Mat = "LIME_DYE";
										ChangeButton.setType(Material.valueOf(Mat));
									}
									if (e.getView().getTitle().equals(Page1))
										ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Equipped_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-35) ))));
									if (e.getView().getTitle().equals(Page2))
										ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Equipped_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-26) ))));
									ButtonChangeLore.clear();
									ButtonChangeLore.clear();
									ButtonChangeLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Euipped_Button.Lore"));
									for (int x = 0; x < ButtonChangeLore.size(); x++) {
										ButtonChangeLore.set(x, ChatColor.translateAlternateColorCodes('&', ButtonChangeLore.get(x)));
									}
								    ButtonChangeMeta.setLore(ButtonChangeLore);
								    ChangeButton.setItemMeta(ButtonChangeMeta);
									inv.setItem(e.getSlot(), ChangeButton);
									p.updateInventory();
								} else if (WardrobeGui.CheckEquippedSlot(p, Wardrobe1) == -1 && WardrobeGui.CheckEquippedSlot(p, Wardrobe2) != -1) {
									// If player have euipped wardrobe slot
									WardrobeGui.ClearPlayerArmor(p);
									int Number = (WardrobeGui.CheckEquippedSlot(p, Wardrobe2) - 36);
									ItemStack ChangeButton = new ItemStack(Material.DIRT);
									ItemMeta ButtonChangeMeta = ChangeButton.getItemMeta();
									if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
										String Mat = "INK_SACK";
										ChangeButton.setType(Material.valueOf(Mat));
										ChangeButton.setDurability((short) 9);
									}
									if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
										String Mat = "PINK_DYE";
										ChangeButton.setType(Material.valueOf(Mat));
									}
								    ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Equipped_Button.Name") .replace("%slot%", (Integer.toString(WardrobeGui.CheckEquippedSlot(p, Wardrobe2) - 26) ))));
								    List<String> ButtonChangeLore = new ArrayList<String>();
								    ButtonChangeLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Ready_Button.Lore"));
									for (int x = 0; x < ButtonChangeLore.size(); x++) {
										ButtonChangeLore.set(x, ChatColor.translateAlternateColorCodes('&', ButtonChangeLore.get(x)));
									}
								    ButtonChangeMeta.setLore(ButtonChangeLore);
								    ChangeButton.setItemMeta(ButtonChangeMeta);
								    Wardrobe2.setItem(WardrobeGui.CheckEquippedSlot(p, Wardrobe2), ChangeButton);
								    WardrobeGui.CheckSlot(Number, Number+10, Wardrobe2);
								    Main.WardrobePage2.put(p.getUniqueId().toString(), Wardrobe2.getContents());
									Main.saveInv1();
									
									if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
										String Mat = "INK_SACK";
										ChangeButton.setType(Material.valueOf(Mat));
										ChangeButton.setDurability((short) 10);
									}
									if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
										String Mat = "LIME_DYE";
										ChangeButton.setType(Material.valueOf(Mat));
									}
									if (e.getView().getTitle().equals(Page1))
										ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Equipped_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-35) ))));
									if (e.getView().getTitle().equals(Page2))
										ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Equipped_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-26) ))));
									ButtonChangeLore.clear();
									ButtonChangeLore.clear();
									ButtonChangeLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Euipped_Button.Lore"));
									for (int x = 0; x < ButtonChangeLore.size(); x++) {
										ButtonChangeLore.set(x, ChatColor.translateAlternateColorCodes('&', ButtonChangeLore.get(x)));
									}
								    ButtonChangeMeta.setLore(ButtonChangeLore);
								    ChangeButton.setItemMeta(ButtonChangeMeta);
									inv.setItem(e.getSlot(), ChangeButton);
									p.updateInventory();
								}
							} else {
								if (WardrobeGui.CheckEquippedSlot(p, Wardrobe1) != -1) {
									WardrobeGui.ClearPlayerArmor(p);
									int Number = (WardrobeGui.CheckEquippedSlot(p, inv) - 36);
									ItemStack ChangeButton = new ItemStack(Material.DIRT);
									ItemMeta ButtonChangeMeta = ChangeButton.getItemMeta();
									if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
										String Mat = "INK_SACK";
										ChangeButton.setType(Material.valueOf(Mat));
										ChangeButton.setDurability((short) 9);
									}
									if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
										String Mat = "PINK_DYE";
										ChangeButton.setType(Material.valueOf(Mat));
									}
									List<String> ButtonChangeLore = new ArrayList<String>();
									if (Number >= 0) {
										if (e.getView().getTitle().equals(Page1))
											ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(WardrobeGui.CheckEquippedSlot(p, Wardrobe1) - 35) ))));
										if (e.getView().getTitle().equals(Page2))
											ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Ready_Button.Name") .replace("%slot%", (Integer.toString(WardrobeGui.CheckEquippedSlot(p, Wardrobe1) - 26) ))));
										ButtonChangeLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Ready_Button.Lore"));
										for (int x = 0; x < ButtonChangeLore.size(); x++) {
											ButtonChangeLore.set(x, ChatColor.translateAlternateColorCodes('&', ButtonChangeLore.get(x)));
										}
										ButtonChangeMeta.setLore(ButtonChangeLore);
										ChangeButton.setItemMeta(ButtonChangeMeta);
										inv.setItem(WardrobeGui.CheckEquippedSlot(p, inv), ChangeButton);
										WardrobeGui.CheckSlot(Number, Number+1, inv);
									}
								
									if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
										String Mat = "INK_SACK";
										ChangeButton.setType(Material.valueOf(Mat));
										ChangeButton.setDurability((short) 10);
									}
									if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
										String Mat = "LIME_DYE";
										ChangeButton.setType(Material.valueOf(Mat));
									}
									ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Equipped_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-35) ))));
									ButtonChangeLore.clear();
									ButtonChangeLore.clear();
									ButtonChangeLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Equipped_Button.Lore"));
									for (int x = 0; x < ButtonChangeLore.size(); x++) {
										ButtonChangeLore.set(x, ChatColor.translateAlternateColorCodes('&', ButtonChangeLore.get(x)));
									}
									ButtonChangeMeta.setLore(ButtonChangeLore);
									ChangeButton.setItemMeta(ButtonChangeMeta);
									inv.setItem(e.getSlot(), ChangeButton);
									p.updateInventory();
								}
								if (WardrobeGui.CheckEquippedSlot(p, Wardrobe1) == -1) {
									if (WardrobeGui.GivePlayerEquippedArmor(p)) {
										ItemStack ChangeButton = new ItemStack(Material.DIRT);
										ItemMeta ButtonChangeMeta = ChangeButton.getItemMeta();
										List<String> ButtonChangeLore = new ArrayList<String>();
										if (version.contains("1.8") || version.contains("1.9") || version.contains("1.10") || version.contains("1.11") || version.contains("1.12")) {
											String Mat = "INK_SACK";
											ChangeButton.setType(Material.valueOf(Mat));
											ChangeButton.setDurability((short) 10);
										}
										if (version.contains("1.13") || version.contains("1.14") || version.contains("1.15") || version.contains("1.16") || version.contains("1.17")) {
											String Mat = "LIME_DYE";
											ChangeButton.setType(Material.valueOf(Mat));
										}
										ButtonChangeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Main.ConfigData.getConfig().getString("Wardrobe_Work.Available_Slot.Equipped_Button.Name") .replace("%slot%", (Integer.toString(e.getSlot()-35) ))));
										ButtonChangeLore.clear();
										ButtonChangeLore.clear();
										ButtonChangeLore.addAll(Main.ConfigData.getConfig().getStringList("Wardrobe_Work.Available_Slot.Equipped_Button.Lore"));
										for (int x = 0; x < ButtonChangeLore.size(); x++) {
											ButtonChangeLore.set(x, ChatColor.translateAlternateColorCodes('&', ButtonChangeLore.get(x)));
										}
										ButtonChangeMeta.setLore(ButtonChangeLore);
										ChangeButton.setItemMeta(ButtonChangeMeta);
										inv.setItem(e.getSlot(), ChangeButton);
										p.updateInventory();
									} else return;
								}
							}
							// Set Player armor
							ItemStack Helmet = inv.getItem(e.getSlot()-36);
							ItemStack Chestplate = inv.getItem(e.getSlot()-27);
							ItemStack Leggings = inv.getItem(e.getSlot()-18);
							ItemStack Boots = inv.getItem(e.getSlot()-9);
							String HelmetSlot = Helmet.getType().toString();
							String ChestplateSlot = Chestplate.getType().toString();
							String LeggingsSlot = Leggings.getType().toString();
							String BootsSlot = Boots.getType().toString();
							// if wardrobe slot have armor then set that to player armor
							if (!(HelmetSlot.endsWith("STAINED_GLASS_PANE")))
								p.getInventory().setHelmet(Helmet);
							if (ChestplateSlot.endsWith("_CHESTPLATE") || ChestplateSlot.endsWith("ELYTRA"))
								p.getInventory().setChestplate(Chestplate);
							if (LeggingsSlot.endsWith("_LEGGINGS"))
								p.getInventory().setLeggings(Leggings);
							if (BootsSlot.endsWith("_BOOTS"))
								p.getInventory().setBoots(Boots);
						}
						if (ClickedItem == "LIME_DYE" || ClickedItem.contains("LIME DYE(10)")) {
							if (e.getView().getTitle().equals(Page1))
								WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-35, inv);
							if (e.getView().getTitle().equals(Page2))
								WardrobeGui.CheckSlot(e.getSlot(), e.getSlot()-26, inv);
							WardrobeGui.ClearPlayerArmor(p);
						}
					}
				}
			}
		} else return;
	}

	
	
	// Save player wardrobe to Storage
	@EventHandler
	public void onGuiClose(InventoryCloseEvent e) {
		if (e.getView().getTitle().equals(Page1)) {
			Main.WardrobePage1.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
			Main.saveInv1();
		}
		if (e.getView().getTitle().equals(Page2)) {
			Main.WardrobePage2.put(e.getPlayer().getUniqueId().toString(), e.getInventory().getContents());
			Main.saveInv2();
		}
	}
	// Save player inv to memory
	@EventHandler
	public void WardrobeOpen(InventoryOpenEvent e) {
		Player p = (Player) e.getPlayer();
		Inventory inv = e.getInventory();
		if (e.getView().getTitle().equals(Page1) || e.getView().getTitle().equals(Page2)) {
			int Number = WardrobeGui.CheckEquippedSlot(p, inv);
			ItemStack Helmet = p.getInventory().getHelmet();
			ItemStack Chestplate = p.getInventory().getChestplate();
			ItemStack Leggings = p.getInventory().getLeggings();
			ItemStack Boots = p.getInventory().getBoots();
			
			if (Number != -1) {
				if (Helmet != null) {
					inv.setItem(Number - 36, Helmet);
				} else {
					WardrobeGui.setItem(inv, (Number - 36), (Number - 36 + 1));
				}
				if (Chestplate != null) {
					inv.setItem(Number - 27, Chestplate);
				} else {
					WardrobeGui.setItem(inv, (Number - 27), (Number - 36 + 1));
				}
				if (Leggings != null) {
					inv.setItem(Number - 18, Leggings);
				} else {
					WardrobeGui.setItem(inv, (Number - 18), (Number - 36 + 1));
				}
				if (Boots != null) {
					inv.setItem(Number -  9, Boots);
				} else {
					WardrobeGui.setItem(inv, (Number - 9), (Number - 36 + 1));
				}
			}
		}
		if (e.getView().getTitle().equals(Page1)) {
			Wardrobe1 = e.getInventory();
		}
		if (e.getView().getTitle().equals(Page2)) {
			Wardrobe2 = e.getInventory();
		}
	}
}
