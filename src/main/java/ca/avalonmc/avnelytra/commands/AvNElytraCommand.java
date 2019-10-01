package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

import static ca.avalonmc.avnelytra.AvNElytra.messagePrefix;


public abstract class AvNElytraCommand implements CommandExecutor {
	
	protected ArrayList<String> labels;
	
	
	public AvNElytraCommand (ArrayList<String> labels) {
		
		this.labels = labels;
		
	}
	
	
	public ArrayList<String> getLabels () {
		
		return labels;
		
	}
	
	
	protected void printHelp (CommandSender sender) {
		
		sender.sendMessage(messagePrefix + "Incorrect use. Please refer to §d/avnelytra ?§7.");
		
	}
	
}
