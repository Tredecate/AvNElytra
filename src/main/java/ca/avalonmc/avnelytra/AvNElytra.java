package ca.avalonmc.avnelytra;

import ca.avalonmc.avnelytra.commands.ElytraToggle;
import ca.avalonmc.avnelytra.commands.RocketBoostToggle;
import ca.avalonmc.avnelytra.commands.SpeedCap;
import ca.avalonmc.avnelytra.commands.TridentBoostToggle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;


public final class AvNElytra extends JavaPlugin {
	
	private static FileConfiguration config;
	public static Logger log;
	
	public static String errorPrefix = "§5[§dAvN Elytra§5]§7 ";
	public static ArrayList<String> off = new ArrayList<String>(Arrays.asList("off", "false", "disabled", "disable", "no"));
	public static ArrayList<String> on = new ArrayList<String>(Arrays.asList("on", "true", "enabled", "enable", "yes"));
	
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
		AvNElytraCommandExecutor executor = new AvNElytraCommandExecutor();
		
		getCommand("avnelytra").setExecutor(executor);
		executor.registerSubCommand("elytratoggle", new ElytraToggle());
		executor.registerSubCommand("rocketboosttoggle", new RocketBoostToggle());
		executor.registerSubCommand("tridentboosttoggle", new TridentBoostToggle());
		executor.registerSubCommand("speedcap", new SpeedCap("speedcap"));
		
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