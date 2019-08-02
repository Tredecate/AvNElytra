package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static ca.avalonmc.avnelytra.AvNElytra.globalelytratoggle;
import static ca.avalonmc.avnelytra.AvNElytra.log;


public class ElytraToggleAll implements CommandExecutor {
	
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("elytratoggleall")) {
			
			if (globalelytratoggle) {
				
				sender.sendMessage("§2You §nDISABLED§2 Elytras!");
				log.info(sender.getName() + " disabled elytra flight.");
				
				return true;
				
			}
			else {
				
				sender.sendMessage("§2You §nENABLED§2 Elytras!");
				log.info(sender.getName() + " enabled elytra flight.");
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
}