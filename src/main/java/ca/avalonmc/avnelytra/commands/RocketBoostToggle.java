package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static ca.avalonmc.avnelytra.AvNElytra.log;
import static ca.avalonmc.avnelytra.AvNElytra.rocketBoostDisabled;
import static org.bukkit.Bukkit.getServer;


public class RocketBoostToggle implements CommandExecutor {
	
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("rocketboosttoggle")) {
			
			if (!rocketBoostDisabled) {
				
				sender.sendMessage("§2You §nDISABLED§2 rocket boosting in SERVER: " + getServer().getName());
				log.info(sender.getName() + " disabled rocket boosting.");
				
				rocketBoostDisabled = true;
				
				return true; // Rocket boosting was on, now it's off
				
			}
			
			sender.sendMessage("§2You §nENABLED§2 rocket boosting in SERVER: " + getServer().getName());
			log.info(sender.getName() + " disabled rocket boosting.");
			
			rocketBoostDisabled = false;
			
			return true; // Rocket boosting was off, now it's on
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}