package ca.avalonmc.avnelytra.commands;

import ca.avalonmc.avnelytra.AvNElytraCommandExecutor;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;


public class Help extends AvNElytraCommand {
	
	
	public Help (ArrayList<String> labels, String usage, boolean showInHelp, String... args) {
		
		super(labels, usage, showInHelp, args);
		
	}
	
	
	@Override
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		ArrayList<AvNElytraCommand> commands = AvNElytraCommandExecutor.getCommands();
		ArrayList<String> helpMessage = new ArrayList<>();
		
		helpMessage.add("");
		helpMessage.add("§7------------------- §dAvN Elytra Help §7-------------------");
		helpMessage.add("");
		
		for (AvNElytraCommand comm : commands) {
			
			if (!comm.showInHelp) {
				
				continue;
				
			}
			
			String helpSubMessage = "";
			helpSubMessage = helpSubMessage.concat("§5" + StringUtils.capitalize(comm.getLabels().get(0)) + "§7:");
			
			for (String arg : comm.getArguments()) {
				
				helpSubMessage = helpSubMessage.concat(" §d" + arg.substring(0, 1) + "§7" + arg.substring(1, arg.length() - 1).toLowerCase() + "§d" + arg.substring(arg.length() - 1));
				
			}
			
			helpMessage.add(helpSubMessage);
			helpMessage.add("§7" + comm.getUsage());
			
		}
		
		sender.sendMessage(helpMessage.toArray(new String[0]));
		return true;
		
	}
	
}
