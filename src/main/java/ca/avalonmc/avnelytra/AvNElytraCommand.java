package ca.avalonmc.avnelytra;

import org.bukkit.command.CommandExecutor;

import java.util.ArrayList;


public abstract class AvNElytraCommand implements CommandExecutor {
	
	protected ArrayList<String> labels;
	
	
	public AvNElytraCommand (ArrayList<String> labels) {
		
		this.labels = labels;
		
	}
	
	
	public ArrayList<String> getLabels () {
		
		return labels;
		
	}
	
}
