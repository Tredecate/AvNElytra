package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;

import static ca.avalonmc.avnelytra.AvNElytra.messagePrefix;


public abstract class AvNElytraCommand implements CommandExecutor {
	
	protected ArrayList<String> labels;
	protected ArrayList<String> arguments;
	
	
	public AvNElytraCommand (ArrayList<String> labels, String... arguments) {
		
		this.labels = labels;
		this.arguments.addAll(Arrays.asList(arguments));
		
	}
	
	
	public ArrayList<String> getLabels () {
		
		return labels;
		
	}
	
	
	public ArrayList<String> getArguments () {
		
		return arguments;
		
	}
	
	
	protected void printHelp (CommandSender sender) {
		
		sender.sendMessage(messagePrefix + "Incorrect use. Please refer to §d/avnelytra ?§7.");
		
	}
	
}
