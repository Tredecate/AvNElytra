package ca.avalonmc.avnelytra;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;


public class EventListener implements Listener {
	
	@EventHandler
	public void onGliding (EntityToggleGlideEvent e) {

		Player player = (Player)e.getEntity();

		if (e.isGliding()) {
			
			player.sendMessage("§a[DEBUG] §2§lYou Started Flying!");
			//e.setCancelled(true); to cancel Elytra entirely
			
		}
		else {
			
			player.sendMessage("§a[DEBUG] §2§lYou Landed!");
			
		}
		
	}
	
}

