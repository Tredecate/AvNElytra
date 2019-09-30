package ca.avalonmc.avnelytra.commands;

import ca.avalonmc.avnelytra.AvNElytraCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

import static ca.avalonmc.avnelytra.AvNElytra.*;


public class TridentBoostToggle extends AvNElytraCommand {
	
	
	public TridentBoostToggle (ArrayList<String> labels) {
		
		super(labels);
		
	}
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (labels.contains(label.toLowerCase())) {
			
			if (args.length < 1) {
				
				sender.sendMessage(errorPrefix + "Trident boosting is currently §d" + (tridentBoostDisabled ? "disabled" : "enabled") + "§7.");
				return true;
				
			}
			
			if (on.contains(args[0].toLowerCase())) {
				
				sender.sendMessage(errorPrefix + (tridentBoostDisabled ? "You §denabled §7trident boosting." : "Trident boosting is already enabled."));
				log.info(sender.getName() + " enabled trident boosting.");
				
				tridentBoostDisabled = false;
				return true; // Trident boosting was off, now it's on
				
			}
			
			if (off.contains(args[0].toLowerCase())) {
				
				sender.sendMessage(errorPrefix + (!tridentBoostDisabled ? "You §ddisabled §7trident boosting." : "Trident boosting is already disabled."));
				log.info(sender.getName() + " disabled trident boosting.");
				
				tridentBoostDisabled = true;
				return true; // Trident boosting was on, now it's off
				
			}
			
			sender.sendMessage(errorPrefix + "Incorrect usage. Please refer to §d/avnelytra help§7.");
			return false;
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}