package ca.avalonmc.avnelytras;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class AvNElytras extends JavaPlugin {
	
	Logger thisismylogger = getLogger();
	
	@Override
	public void onEnable () {
		
		thisismylogger.info("Plugin Enabled! Good morning :)");
		
	}
	
	@EventHandler
	public void onGliding(EntityToggleGlideEvent e){
		
		Player player = (Player)e.getEntity();
		
		if(player.isGliding()){
			
			player.sendMessage("Hey bish ur flyijing");
			
		} else {
			
			player.sendMessage("omg ur landed");
			
		}
		
	}
	
}
