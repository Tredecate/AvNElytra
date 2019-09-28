package ca.avalonmc.avnelytra;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.HashMap;

import static ca.avalonmc.avnelytra.AvNElytra.errorPrefix;


public class AvNElytraCommandExecutor implements CommandExecutor {
	
	private HashMap<String, CommandExecutor> commands = new HashMap<>();
	
	
	public void registerSubCommand (String label, CommandExecutor command) {
		
		commands.put(label.toLowerCase(), command);
		
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
				
				sender.sendMessage(errorPrefix + "§d Invalid subcommand.");
				return false;
				
			}
			
			sender.sendMessage(errorPrefix + "§d Use §n/avnelytra help§r§d to list available commands.");
			return false;
			
		}
		
		sender.sendMessage(errorPrefix + "§d Insufficient permission.");
		return false;
		
	}
	
}
