package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

import static ca.avalonmc.avnelytra.AvNElytra.*;


public class SpeedCap implements CommandExecutor {
	
	private ArrayList<String> labels;
	
	
	public SpeedCap (ArrayList<String> labels) {
		
		this.labels = labels;
		
	}
	
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (labels.contains(label.toLowerCase())) {
			
			if (args.length < 1) {
				
				sender.sendMessage(errorPrefix + (
						maxSpeed > 0 ?
								"The current elytra speed cap is: §d" + maxSpeed + "§7, with an approximate ratio of §d1:" + (75 / scaleFactor) + "§7km/h." :
								"The elytra speed cap is currently disabled."
				));
				return true;
				
			}
			
			try { Double.parseDouble(args[0]); } catch (NumberFormatException e) {
				
				sender.sendMessage(errorPrefix + "Incorrect usage. Please refer to §d/avnelytra help§7.");
				return false;
				
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