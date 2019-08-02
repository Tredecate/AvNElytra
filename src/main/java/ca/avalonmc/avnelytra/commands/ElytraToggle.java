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
			
			if (args.length > 0) { // COMMAND HAS A TARGET
				
				Player target = getServer().getPlayer(args[0]);
				
				if (target == null) {
					
					sender.sendMessage("The target needs to be a Player!");
					
					return false; // The target isn't a player
					
				}
				
				if (elytratoggle.contains(target.getName())) {
					
					sender.sendMessage("§2You §nDISABLED§2 Elytras for " + target.getName());
					target.sendMessage("§6§l" + sender.getName() + " §2§lclipped your wings!");
					elytratoggle.remove(target.getName());
					target.setGliding(false);
					
					return true; // The target could fly, now they can't
					
				}
				
				sender.sendMessage("§2You §nENABLED§2 Elytras for " + target.getName());
				target.sendMessage("§6§l" + sender.getName() + " §2§lhas healed your wings!");
				elytratoggle.add(target.getName());
				
				return true; // The target couldn't fly, now they can
				
			}
			
			// COMMAND DOESN'T HAVE A TARGET
			Player player = (Player)sender;
			
			if (elytratoggle.contains(player.getName())) {
				
				player.sendMessage("§2You §nDISABLED§2 your elytra!");
				elytratoggle.remove(player.getName());
				player.setGliding(false);
				
				return true; // The player could fly, now they can't
				
			}
			
			player.sendMessage("§2You §nENABLED§2 your elytra!");
			elytratoggle.add(player.getName());
			
			return true; // The player couldn't fly, now they can
			
		}
		
		return false; // COMMAND FAILED
		
	}
	
}