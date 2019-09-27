package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static ca.avalonmc.avnelytra.AvNElytra.log;
import static ca.avalonmc.avnelytra.AvNElytra.tridentBoostDisabled;
import static org.bukkit.Bukkit.getServer;


public class TridentBoostToggle implements CommandExecutor {
	
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("tridentboosttoggle")) {
			
			if (!tridentBoostDisabled) {
				
				sender.sendMessage("§2You §nDISABLED§2 trident boosting in SERVER: " + getServer().getName());
				log.info(sender.getName() + " disabled trident boosting.");
				
				tridentBoostDisabled = true;
				
				return true; // Trident boosting was on, now it's off
				
			}
			
			sender.sendMessage("§2You §nENABLED§2 trident boosting in SERVER: " + getServer().getName());
			log.info(sender.getName() + " disabled trident boosting.");
			
			tridentBoostDisabled = false;
			
			return true; // Trident boosting was off, now it's on
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}