package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ca.avalonmc.avnelytra.AvNElytra.elytraDisabled;
import static ca.avalonmc.avnelytra.AvNElytra.log;
import static org.bukkit.Bukkit.getServer;


public class ElytraToggle implements CommandExecutor {
	
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("elytratoggle")) {
			
			if (!elytraDisabled) {
				
				sender.sendMessage("§2You §nDISABLED§2 Elytras in SERVER: " + getServer().getName());
				log.info(sender.getName() + " disabled elytra flight.");
				
				elytraDisabled = true;
				
				for (Player p : getServer().getOnlinePlayers()) {
					
					p.setGliding(false);
					
				}
				
				return true; // Elytra flight was on, now it's off
				
			}
			
			sender.sendMessage("§2You §nENABLED§2 Elytras in SERVER: " + getServer().getName());
			log.info(sender.getName() + " enabled elytra flight.");
			
			elytraDisabled = false;
			
			return true; // Elytra flight was off, now it's on
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}