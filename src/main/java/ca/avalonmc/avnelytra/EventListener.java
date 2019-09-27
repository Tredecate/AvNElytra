package ca.avalonmc.avnelytra;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

import static ca.avalonmc.avnelytra.AvNElytra.globalelytratoggle;


public class EventListener implements Listener {
	
	
	@EventHandler
	public void onGliding (EntityToggleGlideEvent e) {
		
		Player player = (Player)e.getEntity();
		
		if (e.isGliding() && (!globalelytratoggle)) {
			
			player.sendMessage("§cYou are not allowed to fly!");
			e.setCancelled(true);
			
		}
		
	}

}