package ca.avalonmc.avnelytra;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import static ca.avalonmc.avnelytra.AvNElytra.*;


public class EventListener implements Listener {
	
	
	@EventHandler
	public void onGliding (EntityToggleGlideEvent e) {
		
		Player player = (Player)e.getEntity();
		
		if (elytraDisabled && e.isGliding()) {
			
			player.sendMessage("§cYou are not allowed to fly!");
			e.setCancelled(true);
			
		}
		
	}
	
	
	@EventHandler
	public void onBoost (PlayerInteractEvent e) {
		
		Player player = e.getPlayer();
		
		if (rocketBoostDisabled && player.isGliding() && e.hasItem() && e.getItem().getType().equals(Material.FIREWORK_ROCKET)) {
			
			player.sendMessage("§cYou are not allowed to use firework boosts!");
			e.setCancelled(true);
			
		}
		
		if (tridentBoostDisabled && player.isGliding() && e.hasItem() && e.getItem().getType().equals(Material.TRIDENT)) {
			
			player.sendMessage("§cYou are not allowed to use riptide boosts!");
			e.setCancelled(true);
			
		}
		
	}

}