package ca.avalonmc.avnelytra;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

import static ca.avalonmc.avnelytra.AvNElytra.*;


public class EventListener implements Listener {
	
	private AvNElytra plugin;
	private HashMap<UUID, Integer> glidingPlayers = new HashMap<UUID, Integer>();
	
	private boolean rocketDenyMessage = false;
	private boolean tridentDenyMessage = false;
	
	
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
					
					if (v.length() > maxSpeed / scaleFactor) {
						
						player.setVelocity(v.multiply(1 / (v.length() / (maxSpeed / scaleFactor))));
						
					}
					
					if (maxSpeed == 0) {
						
						player.setGliding(false);
						Bukkit.getScheduler().cancelTask(glidingPlayers.get(player.getUniqueId()));
						
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
		ItemStack chestplate;
		ItemStack interactItem;
		
		try {
			chestplate = Objects.requireNonNull(Objects.requireNonNull(player.getEquipment()).getChestplate());
		} catch (NullPointerException ex) {
			chestplate = new ItemStack(Material.AIR);
		}
		
		try {
			interactItem = Objects.requireNonNull(e.getItem());
		} catch (NullPointerException ex) {
			interactItem = new ItemStack(Material.AIR);
		}
		
		if (rocketBoostDisabled && player.isGliding() && e.hasItem() && interactItem.getType().equals(Material.FIREWORK_ROCKET)) {
			
			if (!rocketDenyMessage) {
				
				rocketDenyMessage = true;
				denyMessageCooldown("rocket");
				player.sendMessage("§cYou are not allowed to use firework boosts!");
				
			}
			
			e.setCancelled(true);
			
		}
		
		if (tridentBoostDisabled && !elytraDisabled && chestplate.getType().equals(Material.ELYTRA) && e.hasItem() && interactItem.getType().equals(Material.TRIDENT) && interactItem.containsEnchantment(Enchantment.RIPTIDE) && playerCanRiptide(player)) {
			
			if (!tridentDenyMessage) {
				
				tridentDenyMessage = true;
				denyMessageCooldown("trident");
				player.sendMessage("§cYou are not allowed to use trident launching with elytra on!");
				
			}
			
			e.setCancelled(true);
			
		}
		
	}
	
	
	private void denyMessageCooldown (String tridentOrRocket) {
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			
			@Override
			public void run () {
				
				if (tridentOrRocket.equalsIgnoreCase("trident")) {
					
					tridentDenyMessage = false;
					return;
					
				}
				
				rocketDenyMessage = false;
				
			}
			
		}, 30L);
		
	}
	
	
	private boolean playerCanRiptide (Player player) {
		
		Biome playerBiome = player.getWorld().getBiome(player.getLocation().getBlockX(), player.getLocation().getBlockZ());
		
		return (player.isSwimming() || player.getLocation().getBlock().getType().equals(Material.WATER)) || (player.getWorld().hasStorm() && !multiLowerCaseContains(playerBiome.toString(), "badlands", "plateau", "desert", "savanna", "end"));
		
	}
	
	
	private boolean multiLowerCaseContains (String containingString, String... strings) {
		
		boolean contains = false;
		
		for (String s : strings) {
			
			if (containingString.toLowerCase().contains(s.toLowerCase())) {
				
				contains = true;
				break;
				
			}
			
		}
		
		return contains;
		
	}

}