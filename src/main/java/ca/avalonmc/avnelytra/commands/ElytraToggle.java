package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

import static ca.avalonmc.avnelytra.AvNElytra.*;
import static org.bukkit.Bukkit.getServer;


public class ElytraToggle implements CommandExecutor {
	
	private ArrayList<String> labels;
	
	
	public ElytraToggle (String... labels) {
		
		this.labels = new ArrayList<String>(Arrays.asList(labels));
		
	}
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (labels.contains(label.toLowerCase())) {
			
			if (args.length < 1) {
				
				sender.sendMessage(errorPrefix + "Elytra flight is currently §d" + (elytraDisabled ? "disabled" : "enabled") + "§7.");
				return true;
				
			}
			
			if (on.contains(args[0].toLowerCase()) && !elytraDisabled) {
				
				sender.sendMessage(errorPrefix + "You §denabled §7elytra flight.");
				log.info(sender.getName() + " enabled elytra flight.");
				
				elytraDisabled = false;
				return true; // Elytra flight was off, now it's on
				
			}
			
			if (off.contains(args[0].toLowerCase()) && !elytraDisabled) {
				
				sender.sendMessage(errorPrefix + "You §ddisabled §7elytra flight.");
				log.info(sender.getName() + " disabled elytra flight.");
				
				for (Player p : getServer().getOnlinePlayers()) {
					
					p.setGliding(false);
					
				}
				
				elytraDisabled = true;
				return true; // Elytra flight was on, now it's off
				
			}
			
			sender.sendMessage(errorPrefix + "Incorrect usage. Please refer to §d/avnelytra help§7.");
			return false;
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}