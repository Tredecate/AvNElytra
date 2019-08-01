package ca.avalonmc.avnelytras;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class AvNElytras extends JavaPlugin implements Listener {
	
	Logger thisismylogger = getLogger();
	
	@Override
	public void onEnable () {
		
		getServer().getPluginManager().registerEvents(this, this);
		thisismylogger.info("Plugin Enabled! Good morning :)");
		System.out.println("Print test");
		
	}
	
	@EventHandler
	public void onGliding(EntityToggleGlideEvent e){
		
		Player player = (Player)e.getEntity();
		
		if(e.isGliding()){
			
			player.sendMessage("Hey bish ur flyijing");
			
		} else {
			
			player.sendMessage("omg ur landed");
			
		}
		
	}
	
}
