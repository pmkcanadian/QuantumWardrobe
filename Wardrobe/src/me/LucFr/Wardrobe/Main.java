package me.LucFr.Wardrobe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.LucFr.Wardrobe.DataManager.ConfigFile;
import me.LucFr.Wardrobe.DataManager.DataWardrobePage1;
import me.LucFr.Wardrobe.DataManager.DataWardrobePage2;
import me.LucFr.Wardrobe.DataManager.PlayerOldPermission;
import me.LucFr.Wardrobe.Work.TabCompleterWardrobe;
import me.LucFr.Wardrobe.Work.WardrobeListener;

public class Main extends JavaPlugin{
	
	public static ConfigFile ConfigData;
	public static DataWardrobePage1 Wardrobe_1;
	public static DataWardrobePage2 Wardrobe_2;
	public static PlayerOldPermission PlayerOldPermission;
	private static Plugin plugin;
	
	// HashMapStorage
	public static Map<String, ItemStack[]> WardrobePage1 = new HashMap<String, ItemStack[]>();
	public static Map<String, ItemStack[]> WardrobePage2 = new HashMap<String, ItemStack[]>();
	
	// Enable plugin
	@Override
	public void onEnable() {
		plugin = this;
		// Create config
		Main.ConfigData = new ConfigFile(this);
		Main.ConfigData.saveDefaultConfig();
		// Register Command
		new WardrobeListener(this);
		this.getCommand("wardrobe").setTabCompleter(new TabCompleterWardrobe());
		// Wardrobe data
		Main.Wardrobe_1 = new DataWardrobePage1(this);
		Main.Wardrobe_1.saveDefaultConfig();
		Main.Wardrobe_2 = new DataWardrobePage2(this);
		Main.Wardrobe_2.saveDefaultConfig();
		// Wardrobe Player old permission
		Main.PlayerOldPermission = new PlayerOldPermission(this);
		Main.PlayerOldPermission.saveDefaultConfig();
		// Restore Player wardrobe
		if (Main.Wardrobe_1.getConfig().contains("data")) 
			this.restoreInv1();
		if (Main.Wardrobe_2.getConfig().contains("data")) 
			this.restoreInv2();
	}
	// Save player Wardrobe on Disable
	@Override
	public void onDisable() {
		for(Player p : Bukkit.getOnlinePlayers()){
		    if (p.getOpenInventory().getTitle().contains("Wardrobe (1/2)") || p.getOpenInventory().getTitle().contains("Wardrobe (2/2)")) {
		    	p.closeInventory();
		    }
		}
		if (!WardrobePage1.isEmpty()) {
			Main.saveInv1();
		}
		if (!WardrobePage2.isEmpty()) {
			Main.saveInv2();
		}
	}
	// Save player inv
	public static void saveInv1() {
		for (Map.Entry<String, ItemStack[]> entry : WardrobePage1.entrySet()) {
			Main.Wardrobe_1.getConfig().set("data." + entry.getKey(), entry.getValue());
		}
		Main.Wardrobe_1.saveConfig();
	}
	public static void saveInv2() {
		for (Map.Entry<String, ItemStack[]> entry : WardrobePage2.entrySet()) {
			Main.Wardrobe_2.getConfig().set("data." + entry.getKey(), entry.getValue());
		}
		Main.Wardrobe_2.saveConfig();
	}
	// Restore Saved player Wardrobe
	public void restoreInv1() {
		Main.Wardrobe_1.getConfig().getConfigurationSection("data").getKeys(false).forEach(key ->{
			@SuppressWarnings("unchecked")
			ItemStack[] content = ((List<ItemStack>) Main.Wardrobe_1.getConfig().get("data." + key)).toArray(new ItemStack[0]);
			WardrobePage1.put(key, content);
		});
	}
	public void restoreInv2() {
		Main.Wardrobe_2.getConfig().getConfigurationSection("data").getKeys(false).forEach(key ->{
			@SuppressWarnings("unchecked")
			ItemStack[] content = ((List<ItemStack>) Main.Wardrobe_2.getConfig().get("data." + key)).toArray(new ItemStack[0]);
			WardrobePage2.put(key, content);
		});
	}
	// Save Config
	public static void ReloadConfig() {
		ConfigData.ReloadConfig();
	}
	public static Plugin getPlugin() {
	    return plugin;
	}
}
