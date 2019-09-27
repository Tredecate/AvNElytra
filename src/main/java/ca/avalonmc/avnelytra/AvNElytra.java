package ca.avalonmc.avnelytra;

import ca.avalonmc.avnelytra.commands.ElytraToggle;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;


public final class AvNElytra extends JavaPlugin {
	
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
		
		log.info("===========================");
		log.info("AvNElytra: Plugin Disabled!");
		log.info("===========================");
		
	}
	
	
	public void registerComponents () {
		
		// Register event handler
		getServer().getPluginManager().registerEvents(new EventListener(), this);
		
		// Register commands
		getCommand("elytratoggle").setExecutor(new ElytraToggle());
		
		// Instantiate logger
		log = getLogger();
		
	}
	
}