package ca.avalonmc.avnelytra;

import ca.avalonmc.avnelytra.commands.ElytraToggle;
import ca.avalonmc.avnelytra.commands.RocketBoostToggle;
import ca.avalonmc.avnelytra.commands.SpeedCap;
import ca.avalonmc.avnelytra.commands.TridentBoostToggle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class AvNElytra extends JavaPlugin {
	
	private static FileConfiguration config;
	
	public static Logger log;
	public static Boolean elytraDisabled;
	public static Boolean rocketBoostDisabled;
	public static Boolean tridentBoostDisabled;
	public static double maxSpeed;
	public static double scaleFactor;
	
	
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
		getServer().getPluginManager().registerEvents(new EventListener(this), this);
		
		// Register commands
		getCommand("elytratoggle").setExecutor(new ElytraToggle());
		getCommand("rocketboosttoggle").setExecutor(new RocketBoostToggle());
		getCommand("tridentboosttoggle").setExecutor(new TridentBoostToggle());
		getCommand("speedcap").setExecutor(new SpeedCap());
		
		// Instantiate logger
		log = getLogger();
		
	}
	
	
	private void instantiateVariables () {
		
		elytraDisabled = Boolean.valueOf(getConfigFromKey("Elytra.Disabled"));
		rocketBoostDisabled = Boolean.valueOf(getConfigFromKey("Boosts.RocketBoostDisabled"));
		tridentBoostDisabled = Boolean.valueOf(getConfigFromKey("Boosts.TridentBoostDisabled"));
		maxSpeed = Double.parseDouble(getConfigFromKey("Elytra.MaxSpeed"));
		scaleFactor = 75 / Double.parseDouble(getConfigFromKey("Elytra.SpeedScale"));
		
	}
	
	
	private void saveVariables () {
		
		config.set("Elytra.Disabled", elytraDisabled);
		config.set("Boosts.RocketBoostDisabled", rocketBoostDisabled);
		config.set("Boosts.TridentBoostDisabled", tridentBoostDisabled);
		config.set("Elytra.MaxSpeed", maxSpeed);
		
	}
	
	
	private static String getConfigFromKey (String key) {
		
		return config.getString(key);
		
	}
	
}