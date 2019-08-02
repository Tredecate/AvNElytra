package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ca.avalonmc.avnelytra.AvNElytra.elytratoggle;


public class ElytraToggle implements CommandExecutor {
	
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("elytratoggle")) {
			
			if (!(sender instanceof Player)) {
				
				sender.sendMessage("You need to be a Player to do this command");
				return false;
				
			}
			
			Player player = (Player)sender;
			
			if (elytratoggle.contains(player.getName())) {
				
				player.sendMessage("§2You §nDISABLED§2 Elytras!");
				elytratoggle.remove(player.getName());
				
				return true;
				
			}
			
			player.sendMessage("§2You §nENABLED§2 Elytras!");
			elytratoggle.add(player.getName());
			
			return true;
			
		}
		
		return false;
		
	}
	
}