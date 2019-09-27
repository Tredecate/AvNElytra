package ca.avalonmc.avnelytra;

import ca.avalonmc.avnelytra.commands.ElytraToggle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class AvNElytra extends JavaPlugin {
	
	private static FileConfiguration config;
	public static Logger log;
	
	public static Boolean globalelytratoggle = true;
	
	
	@Override
	public void onEnable () {  //ON PLUGIN ENABLE
		
		registerComponents();
		
		log.info("===========================");
		log.info("AvNElytra: Plugin Enabled! ");
		log.info("===========================");
		
	}
	
	
	@Override
	public void onDisable () {  //ON PLUGIN DISABLE
		
		this.saveConfig();
		
		log.info("===========================");
		log.info("AvNElytra: Plugin Disabled!");
		log.info("===========================");
		
	}
	
	
	public void registerComponents () {
		
		// Create config file
		saveDefaultConfig();
		
		// Get config
		config = this.getConfig();
		
		// Register event handler
		getServer().getPluginManager().registerEvents(new EventListener(), this);
		
		// Register commands
		getCommand("elytratoggle").setExecutor(new ElytraToggle());
		
		// Instantiate logger
		log = getLogger();
		
	}
	
	
	public FileConfiguration getCurrentConfig () {
		
		return config;
		
	}
	
	
	public void saveCurrentConfig () {
		
		getCurrentConfig().set("ElytraDisabled", globalelytratoggle);
		
	}
	
}