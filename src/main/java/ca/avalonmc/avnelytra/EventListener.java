package ca.avalonmc.avnelytra;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

import static ca.avalonmc.avnelytra.AvNElytra.*;


public class EventListener implements Listener {
	
	private AvNElytra plugin;
	private HashMap<UUID, Integer> glidingPlayers = new HashMap<UUID, Integer>();
	
	
	EventListener (AvNElytra plugin) {
		
		this.plugin = plugin;
		
	}
	
	@EventHandler
	public void onGliding (EntityToggleGlideEvent e) {
		
		Player player = (Player)e.getEntity();
		
		if (elytraDisabled && e.isGliding()) {
			
			player.sendMessage("§cYou are not allowed to fly!");
			e.setCancelled(true);
			
			return;
			
		}
		
		if (maxSpeed != 0 && e.isGliding()) {
			
			glidingPlayers.put(player.getUniqueId(), Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				
				public void run () {
					
					Vector v = player.getVelocity();
					
					if (v.length() > maxSpeed) {
						
						player.setVelocity(v.multiply(1 / (v.length() / maxSpeed)));
						
					}
					
				}
				
			}, 0L, 1L));
			
		}
		else if (maxSpeed != 0) {
			
			Bukkit.getScheduler().cancelTask(glidingPlayers.get(player.getUniqueId()));
			
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