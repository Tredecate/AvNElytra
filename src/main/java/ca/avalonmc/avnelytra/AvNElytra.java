package ca.avalonmc.avnelytra;

import ca.avalonmc.avnelytra.commands.ElytraToggle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class AvNElytra extends JavaPlugin {
	
	public static Logger log;
	private static FileConfiguration config;
	
	public static Boolean elytraDisabled;
	public static Boolean rocketBoostDisabled;
	public static Boolean tridentBoostDisabled;
	
	
	@Override
	public void onEnable () {  //ON PLUGIN ENABLE
		
		registerComponents();
		instantiateVariables();
		
		log.info("===========================");
		log.info("AvNElytra: Plugin Enabled! ");
		log.info("===========================");
		
	}
	
	
	@Override
	public void onDisable () {  //ON PLUGIN DISABLE
		
		saveVariables();
		this.saveConfig();
		
		log.info("===========================");
		log.info("AvNElytra: Plugin Disabled!");
		log.info("===========================");
		
	}
	
	
	private void registerComponents () {
		
		// Create config file (if needed)
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
	
	
	private void instantiateVariables () {
		
		elytraDisabled = Boolean.valueOf(getConfigFromKey("ElytraDisabled"));
		rocketBoostDisabled = Boolean.valueOf((getConfigFromKey("Boosts.RocketBoostDisabled")));
		tridentBoostDisabled = Boolean.valueOf((getConfigFromKey("Boosts.TridentBoostDisabled")));
		
	}
	
	
	private void saveVariables () {
		
		config.set("ElytraDisabled", elytraDisabled);
		config.set("Boosts.RocketBoostDisabled", rocketBoostDisabled);
		config.set("Boosts.TridentBoostDisabled", tridentBoostDisabled);
		
	}
	
	
	public String getConfigFromKey (String key) {
		
		return config.getString(key);
		
	}
	
}