package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static ca.avalonmc.avnelytra.AvNElytra.*;


public class SpeedCap implements CommandExecutor {
	
	private String label;
	
	
	public SpeedCap (String label) {
		
		this.label = label;
		
	}
	
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase(this.label)) {
			
			if (args.length < 1) {
				
				if (maxSpeed > 0) {
					
					sender.sendMessage(errorPrefix + "The current elytra speed cap is: §d" + maxSpeed + "§7, with an approximate ratio of §d1:" + (75 / scaleFactor) + "§7km/h.");
					return true;
					
				}
				
				sender.sendMessage(errorPrefix + "The elytra speed cap is currently disabled.");
				return true;
				
			}
			
			if (Double.parseDouble(args[0]) > 0) {
				
				maxSpeed = Double.parseDouble(args[0]);
				
				sender.sendMessage(errorPrefix + "You set the elytra speed cap to: §d" + maxSpeed + "§7.");
				log.info(sender.getName() + " set the elytra speed cap to: " + maxSpeed + ".");
				
				return true;
				
			}
			
			maxSpeed = 0;
			
			sender.sendMessage(errorPrefix + "You disabled the elytra speed cap.");
			log.info(sender.getName() + " disabled the elytra speed cap.");
			
			return true;
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}