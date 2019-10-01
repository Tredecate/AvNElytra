package ca.avalonmc.avnelytra;

import ca.avalonmc.avnelytra.commands.AvNElytraCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

import static ca.avalonmc.avnelytra.AvNElytra.messagePrefix;


public class AvNElytraCommandExecutor implements CommandExecutor {
	
	private static HashMap<String, AvNElytraCommand> commands = new HashMap<>();
	
	
	public void registerSubCommand (AvNElytraCommand command) {
		
		for (String label : command.getLabels()) {
			
			commands.put(label, command);
			
		}
		
	}
	
	
	public static ArrayList<AvNElytraCommand> getCommands () {
		
		LinkedHashSet<AvNElytraCommand> commandList = new LinkedHashSet<>(commands.values());
		return new ArrayList<AvNElytraCommand>(commandList);
		
	}
	
	
	@Override
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (sender.hasPermission("avnelytra.manage") || sender.isOp()) {
			
			if (args.length > 0) {
				
				CommandExecutor subCommand = commands.get(args[0].toLowerCase());
				
				if (subCommand != null) {
					
					String[] newArgs = new String[0];
					
					if (args.length > 1) {
						
						newArgs = Arrays.copyOfRange(args, 1, args.length);
						
					}
					
					return subCommand.onCommand(sender, command, args[0], newArgs);
					
				}
				
				sender.sendMessage(messagePrefix + "Invalid subcommand.");
				return false;
				
			}
			
			sender.sendMessage(messagePrefix + "Incorrect use. Please refer to §d/avnelytra ?§7.");
			return false;
			
		}
		
		sender.sendMessage(messagePrefix + "Insufficient permission.");
		return false;
		
	}
	
}
