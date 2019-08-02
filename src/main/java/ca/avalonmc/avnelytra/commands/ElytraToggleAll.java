package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static ca.avalonmc.avnelytra.AvNElytra.globalelytratoggle;
import static ca.avalonmc.avnelytra.AvNElytra.log;
import static org.bukkit.Bukkit.getServer;


public class ElytraToggleAll implements CommandExecutor {
	
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("elytratoggleall")) {
			
			if (globalelytratoggle) {
				
				sender.sendMessage("§2You §nDISABLED§2 Elytras in SERVER: " + getServer().getName());
				log.info(sender.getName() + " disabled elytra flight.");
				
				return true; // Global elytra was on, now it's off
				
			}
			
			sender.sendMessage("§2You §nENABLED§2 Elytras in SERVER: " + getServer().getName());
			log.info(sender.getName() + " enabled elytra flight.");
			
			return true; // Global elytra was off, now it's on
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}