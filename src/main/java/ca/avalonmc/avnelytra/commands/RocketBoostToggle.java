package ca.avalonmc.avnelytra.commands;

import ca.avalonmc.avnelytra.AvNElytraCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

import static ca.avalonmc.avnelytra.AvNElytra.*;


public class RocketBoostToggle extends AvNElytraCommand {
	
	
	public RocketBoostToggle (ArrayList<String> labels) {
		
		super(labels);
		
	}
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (labels.contains(label.toLowerCase())) {
			
			if (args.length < 1) {
				
				sender.sendMessage(messagePrefix + "Firework rocket boosting is currently §d" + (rocketBoostDisabled ? "disabled" : "enabled") + "§7.");
				return true;
				
			}
			
			if (on.contains(args[0].toLowerCase())) {
				
				sender.sendMessage(messagePrefix + (rocketBoostDisabled ? "You §denabled §7firework rocket boosting." : "Firework rocket boosting is already enabled."));
				log.info(sender.getName() + " enabled firework rocket boosting.");
				
				rocketBoostDisabled = false;
				return true; // Rocket boosting was off, now it's on
				
			}
			
			if (off.contains(args[0].toLowerCase())) {
				
				sender.sendMessage(messagePrefix + (!rocketBoostDisabled ? "You §ddisabled §7firework rocket boosting." : "Firework rocket boosting is already disabled."));
				log.info(sender.getName() + " disabled firework rocket boosting.");
				
				rocketBoostDisabled = true;
				return true; // Rocket boosting was on, now it's off
				
			}
			
			printHelp(sender);
			return false;
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}