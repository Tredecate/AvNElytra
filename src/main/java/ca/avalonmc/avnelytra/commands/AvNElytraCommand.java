package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;

import static ca.avalonmc.avnelytra.AvNElytra.messagePrefix;


public abstract class AvNElytraCommand implements CommandExecutor {
	
	protected ArrayList<String> labels;
	protected ArrayList<String> arguments;
	protected String usage;
	
	
	public AvNElytraCommand (ArrayList<String> labels, String usage, String... arguments) {
		
		this.labels = labels;
		this.usage = usage;
		this.arguments = new ArrayList<String>(Arrays.asList(arguments));
		
	}
	
	
	public ArrayList<String> getLabels () {
		
		return labels;
		
	}
	
	
	public String getUsage () {
		
		return usage;
		
	}
	
	
	public ArrayList<String> getArguments () {
		
		return arguments;
		
	}
	
	
	protected void printHelp (CommandSender sender) {
		
		sender.sendMessage(messagePrefix + "Incorrect use. Please refer to §d/avnelytra ?§7.");
		
	}
	
}
