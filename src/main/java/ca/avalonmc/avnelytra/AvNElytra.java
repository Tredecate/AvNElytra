package ca.avalonmc.avnelytra;

import ca.avalonmc.avnelytra.commands.ElytraDisable;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class AvNElytra extends JavaPlugin {
	
	Logger thisismylogger = getLogger();
	
	@Override
	public void onEnable () {
		
		getServer().getPluginManager().registerEvents(this, this);
		thisismylogger.info("**************************");
		thisismylogger.info("AvNElytra: Plugin Enabled!");
		thisismylogger.info("**************************");

		registerCommands();
	}

	public void registerCommands() {
		getCommand("elytradisable").setExecutor(new ElytraDisable());

	}
	
}