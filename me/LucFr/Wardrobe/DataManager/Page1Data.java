package me.LucFr.Wardrobe.DataManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.LucFr.Wardrobe.Wardrobe;

public class Page1Data {
	private Wardrobe plugin;
	private FileConfiguration dataCarpentryRecipes = null;
	private File CarpentryRecipes = null;
	
	public Page1Data(Wardrobe plugin) {
		this.plugin = plugin;
		saveDefaultConfig();
	}
	
	public void ReloadConfig() {
		if (this.CarpentryRecipes == null)
			this.CarpentryRecipes = new File("plugins/Wardrobe/data/Page 1.yml");
		
		
		this.dataCarpentryRecipes = YamlConfiguration.loadConfiguration(this.CarpentryRecipes);
		
		InputStream defaultStream = this.plugin.getResource("data/Page 1.yml");
		if (defaultStream != null) {
			YamlConfiguration defaultCongfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
			this.dataCarpentryRecipes.setDefaults(defaultCongfig);
		}
	}
	
	public FileConfiguration getConfig() {
		if (this.dataCarpentryRecipes == null)
			ReloadConfig();
		
		return this.dataCarpentryRecipes;
	}
	
	public void saveConfig() {
		if (this.dataCarpentryRecipes == null || this.CarpentryRecipes == null) 
			return;
		
		try {
			this.getConfig().save(this.CarpentryRecipes);
		} catch (IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Could not save Data to " + this.CarpentryRecipes, e);
		}
	}
	
	public void saveDefaultConfig() {
		if (this.dataCarpentryRecipes == null)
			this.CarpentryRecipes = new File("plugins/Wardrobe/data/Page 1.yml");
		
		if (!this.CarpentryRecipes.exists()) {
			this.plugin.saveResource("data/Page 1.yml", false);
		}
	}
}
