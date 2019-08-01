package ca.avalonmc.avnelytra.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ElytraDisable implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You need to be a Player to do this command");
            return false;

        }
        Player player = (Player) sender;
        player.sendMessage("§2You §uDISABLED§2 Elytras!");
        return true;
    }
}