package ca.avalonmc.avnelytra;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;


public class AvNElytraTabCompleter implements TabCompleter {
	
	private ArrayList<String> commands;
	private List<String> completions;
	
	
	@Override
	public List<String> onTabComplete (CommandSender sender, Command command, String alias, String[] args) {
		
		commands = new ArrayList<>();
		for (ArrayList<String> a : AvNElytra.getAliases()) { commands.add(a.get(0)); }
		
		if (args.length == 1 && args[0].length() < 1) {
			
			completions = commands;
			return completions;
			
		}
		
		if (args.length == 1) {
			
			getAliasCompletions(args[0]);
			return completions;
			
		}
		
		if (args.length == 2) {
			
			if (getCommandType(args[0]).equalsIgnoreCase("boolean")) {
				
				if (args[1].length() < 1) {
					
					completions = new ArrayList<>();
					completions.add(AvNElytra.on.get(0));
					completions.add(AvNElytra.off.get(0));
					return completions;
					
				}
				
				getBooleanCompletions(args[1]);
				return completions;
				
			}
			
			if (getCommandType(args[0]).equalsIgnoreCase("num")) {
				
				completions = new ArrayList<>();
				completions.add("0");
				completions.add("1");
				completions.add("2");
				return completions;
				
			}
			
		}
		
		return null;
		
	}
	
	
	private String getCommandType (String arg) {
		
		if (commands.get(0).toLowerCase().contains(arg.toLowerCase()) || commands.get(1).toLowerCase().contains(arg.toLowerCase()) || commands.get(2).toLowerCase().contains(arg.toLowerCase())) {
			
			return "boolean";
			
		}
		
		if (commands.get(3).toLowerCase().contains(arg.toLowerCase())) {
			
			return "num";
			
		}
		
		return "error";
		
	}
	
	
	private void getBooleanCompletions (String arg) {
		
		completions = new ArrayList<>();
		
		for (String option : AvNElytra.on) {
			
			if (option.toLowerCase().startsWith(arg.toLowerCase())) {
				
				completions.add(option);
				
			}
			
		}
		
		for (String option : AvNElytra.off) {
			
			if (option.toLowerCase().startsWith(arg.toLowerCase())) {
				
				completions.add(option);
				
			}
			
		}
		
	}
	
	
	private void getAliasCompletions (String arg) {
		
		completions = new ArrayList<>();
		
		for (ArrayList<String> list : AvNElytra.getAliases()) {
			
			for (String comm : list) {
				
				if (comm.toLowerCase().startsWith(arg.toLowerCase())) {
					
					completions.add(comm);
					
				}
				
			}
			
		}
		
	}
	
}
