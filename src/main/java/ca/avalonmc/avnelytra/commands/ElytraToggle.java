package ca.avalonmc.avnelytra.commands;

import ca.avalonmc.avnelytra.AvNElytraCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static ca.avalonmc.avnelytra.AvNElytra.*;
import static org.bukkit.Bukkit.getServer;


public class ElytraToggle extends AvNElytraCommand {
	
	
	public ElytraToggle (ArrayList<String> labels) {
		
		super(labels);
		
	}
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (labels.contains(label.toLowerCase())) {
			
			if (args.length < 1) {
				
				sender.sendMessage(messagePrefix + "Elytra flight is currently §d" + (elytraDisabled ? "disabled" : "enabled") + "§7.");
				return true;
				
			}
			
			if (on.contains(args[0].toLowerCase())) {
				
				sender.sendMessage(messagePrefix + (elytraDisabled ? "You §denabled §7elytra flight." : "Elytra flight is already enabled."));
				log.info(sender.getName() + " enabled elytra flight.");
				
				elytraDisabled = false;
				return true; // Elytra flight was off, now it's on
				
			}
			
			if (off.contains(args[0].toLowerCase())) {
				
				sender.sendMessage(messagePrefix + (!elytraDisabled ? "You §ddisabled §7elytra flight." : "Elytra flight is already disabled."));
				log.info(sender.getName() + " disabled elytra flight.");
				
				for (Player p : getServer().getOnlinePlayers()) {
					
					p.setGliding(false);
					
				}
				
				elytraDisabled = true;
				return true; // Elytra flight was on, now it's off
				
			}
			
			printHelp(sender);
			return false;
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}