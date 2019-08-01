package ca.avalonmc.avnelytra;

import ca.avalonmc.avnelytra.command.ElytraDisable;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class AvNElytra extends JavaPlugin implements Listener {
	
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
	
	@EventHandler
	public void onGliding(EntityToggleGlideEvent e){
		
		Player player = (Player)e.getEntity();
		
		if(e.isGliding()){
			
			player.sendMessage("§2§lYou Started Flying!");
			//e.setCancelled(true); to cancel Elytra entirely

		} else {
			
			player.sendMessage("§2§lYou Landed!");
			
		}
		
	}
	
}
