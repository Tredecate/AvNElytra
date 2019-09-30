package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

import static ca.avalonmc.avnelytra.AvNElytra.*;


public class RocketBoostToggle implements CommandExecutor {
	
	private ArrayList<String> labels;
	
	
	public RocketBoostToggle (ArrayList<String> labels) {
		
		this.labels = labels;
		
	}
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (labels.contains(label.toLowerCase())) {
			
			if (args.length < 1) {
				
				sender.sendMessage(errorPrefix + "Firework rocket boosting is currently §d" + (rocketBoostDisabled ? "disabled" : "enabled") + "§7.");
				return true;
				
			}
			
			if (on.contains(args[0].toLowerCase()) && rocketBoostDisabled) {
				
				sender.sendMessage(errorPrefix + "You §denabled §7firework rocket boosting.");
				log.info(sender.getName() + " enabled firework rocket boosting.");
				
				rocketBoostDisabled = false;
				return true; // Rocket boosting was off, now it's on
				
			}
			
			if (off.contains(args[0].toLowerCase()) && !rocketBoostDisabled) {
				
				sender.sendMessage(errorPrefix + "You §ddisabled §7firework rocket boosting.");
				log.info(sender.getName() + " disabled firework rocket boosting.");
				
				rocketBoostDisabled = true;
				return true; // Rocket boosting was on, now it's off
				
			}
			
			sender.sendMessage(errorPrefix + "Incorrect usage. Please refer to §d/avnelytra help§7.");
			return false;
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}