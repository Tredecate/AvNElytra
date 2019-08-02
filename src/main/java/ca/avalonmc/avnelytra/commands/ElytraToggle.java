package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ca.avalonmc.avnelytra.AvNElytra.elytratoggle;
import static org.bukkit.Bukkit.getServer;


public class ElytraToggle implements CommandExecutor {
	
	
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (label.equalsIgnoreCase("elytratoggle")) {
			
			if (args.length > 0) {
				
				Player target = getServer().getPlayer(args[0]);
				
				if (!(target instanceof Player)) {
					
					sender.sendMessage("The target needs to be a Player!");
					
					return false;
					
				}
				else {
					
					if (elytratoggle.contains(target.getName())) {
						
						sender.sendMessage("§2You §nDISABLED§2 Elytras for " + target.getName());
						target.sendMessage(sender.getName() + " §2§nclipped your wings!");
						elytratoggle.remove(target.getName());
						
						return true;
						
					}
					else {
						
						sender.sendMessage("§2You §nENABLED§2 Elytras for " + target.getName());
						target.sendMessage(sender.getName() + " §2§nhas healed your wings!");
						elytratoggle.add(target.getName());
						
						return true;
						
					}
					
				}
				
			}
			else {
				
				Player player = (Player)sender;
				
				if (elytratoggle.contains(player.getName())) {
					
					player.sendMessage("§2You §nDISABLED§2 Elytras!");
					elytratoggle.remove(player.getName());
					
					return true;
					
				}
				else {
					
					player.sendMessage("§2You §nENABLED§2 Elytras!");
					elytratoggle.add(player.getName());
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
}