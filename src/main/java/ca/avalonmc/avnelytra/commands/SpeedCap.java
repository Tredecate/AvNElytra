package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static ca.avalonmc.avnelytra.AvNElytra.log;
import static ca.avalonmc.avnelytra.AvNElytra.maxSpeed;


public class SpeedCap implements CommandExecutor {
	
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("speedcap")) {
			
			if (args.length < 1) {
				
				if (maxSpeed > 0) {
					
					sender.sendMessage("§2The current elytra speed cap is: " + maxSpeed);
					return true;
					
				}
				
				sender.sendMessage("§2The elytra speed cap is currently disabled.");
				return true;
				
			}
			
			if (Double.parseDouble(args[0]) > 0) {
				
				maxSpeed = Double.parseDouble(args[0]);
				
				sender.sendMessage("§2You set the elytra speed cap to: " + maxSpeed);
				log.info(sender.getName() + " set the elytra speed cap to: " + maxSpeed);
				
				return true;
				
			}
			
			maxSpeed = 0;
			
			sender.sendMessage("§2You disabled the elytra speed cap.");
			log.info(sender.getName() + " disabled the elytra speed cap.");
			
			return true;
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}