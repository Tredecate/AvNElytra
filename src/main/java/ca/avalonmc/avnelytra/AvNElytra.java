package ca.avalonmc.avnelytra;

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
		
	}
	
	@EventHandler
	public void onGliding(EntityToggleGlideEvent e){
		
		Player player = (Player)e.getEntity();
		
		if(e.isGliding()){
			
			player.sendMessage("§2§lYou Started Flying!");
			player.setGliding(false);

		} else {
			
			player.sendMessage("§2§lYou Landed!");
			
		}
		
	}
	
}
