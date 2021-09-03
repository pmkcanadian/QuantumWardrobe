package me.LucFr.Wardrobe;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.LucFr.Wardrobe.DataManager.Config;
import me.LucFr.Wardrobe.DataManager.Page1Data;
import me.LucFr.Wardrobe.DataManager.Page2Data;
import me.LucFr.Wardrobe.Listener.WardrobeListener;
import me.LucFr.Wardrobe.Command.WardrobeCommand;
import me.LucFr.Wardrobe.Command.WardrobeTabCompleter;

public class Wardrobe extends JavaPlugin{

	public static Plugin plugin;
	public static Config ConfigData;
	public static Page1Data Page_1;
	public static Page2Data Page_2;
	
	// Enable plugin
	@Override
	public void onEnable() {
		plugin = this;
	// Create config
		ConfigData = new Config(this);
		ConfigData.saveDefaultConfig();
		ConfigData.ReloadConfig();
	// Wardrobe data
		Page_1 = new Page1Data(this);
		Page_1.saveDefaultConfig();
		Page_2 = new Page2Data(this);
		Page_2.saveDefaultConfig();
	// Register Command and Tabcompleter
		new WardrobeCommand(this);
		this.getCommand("wardrobe").setTabCompleter(new WardrobeTabCompleter());
		new WardrobeListener(this);
	}
	public static Plugin getPlugin() {
	    return plugin;
	}
}
