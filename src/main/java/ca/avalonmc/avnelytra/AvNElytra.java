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
	
	public static String messagePrefix = "§5[§dAvN Elytra§5]§7 ";
	public static ArrayList<String> off = new ArrayList<String>(Arrays.asList("off", "false", "disabled", "disable", "no", "n", "0"));
	public static ArrayList<String> on = new ArrayList<String>(Arrays.asList("on", "true", "enabled", "enable", "yes", "y", "1"));
	
	public static Boolean elytraDisabled;
	private static ArrayList<String> elytraAliases;
	
	public static Boolean rocketBoostDisabled;
	private static ArrayList<String> rocketBoostAliases;
	
	public static Boolean tridentBoostDisabled;
	private static ArrayList<String> tridentBoostAliases;
	
	public static double maxSpeed;
	public static double scaleFactor;
	private static ArrayList<String> speedCapAliases;
	
	
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
		getAliasesFromConfig();
		AvNElytraCommandExecutor executor = new AvNElytraCommandExecutor();
		getCommand("avnelytra").setExecutor(executor);
		
		executor.registerSubCommand(new ElytraToggle(elytraAliases));
		executor.registerSubCommand(new RocketBoostToggle(rocketBoostAliases));
		executor.registerSubCommand(new TridentBoostToggle(tridentBoostAliases));
		executor.registerSubCommand(new SpeedCap(speedCapAliases));
		
		// Instantiate logger
		log = getLogger();
		
	}
	
	
	private void instantiateVariables () {
		
		elytraDisabled = Boolean.valueOf(getConfigFromKey("Elytra.Disabled"));
		rocketBoostDisabled = Boolean.valueOf(getConfigFromKey("RocketBoost.Disabled"));
		tridentBoostDisabled = Boolean.valueOf(getConfigFromKey("TridentBoost.Disabled"));
		maxSpeed = Double.parseDouble(getConfigFromKey("SpeedLimit.MaxSpeed"));
		scaleFactor = 75 / Double.parseDouble(getConfigFromKey("SpeedLimit.Scale"));
		
	}
	
	
	private void getAliasesFromConfig () {
		
		elytraAliases = new ArrayList<>(config.getStringList("Elytra.Aliases"));
		rocketBoostAliases = new ArrayList<>(config.getStringList("RocketBoost.Aliases"));
		tridentBoostAliases = new ArrayList<>(config.getStringList("TridentBoost.Aliases"));
		speedCapAliases = new ArrayList<>(config.getStringList("SpeedLimit.Aliases"));
		
	}
	
	
	private void saveVariables () {
		
		config.set("Elytra.Disabled", elytraDisabled);
		config.set("RocketBoost.Disabled", rocketBoostDisabled);
		config.set("TridentBoost.Disabled", tridentBoostDisabled);
		config.set("SpeedLimit.MaxSpeed", maxSpeed);
		
	}
	
	
	private static String getConfigFromKey (String key) {
		
		return config.getString(key);
		
	}
	
	
	public static ArrayList<ArrayList<String>> getAliases () {
		
		return new ArrayList<ArrayList<String>>(Arrays.asList(elytraAliases, rocketBoostAliases, tridentBoostAliases, speedCapAliases));
		
	}
	
}