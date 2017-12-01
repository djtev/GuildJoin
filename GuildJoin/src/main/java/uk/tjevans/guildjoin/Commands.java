package uk.tjevans.guildjoin;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {
	
	private String opts = "Options.";

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("masterwhitelist")) { // If the player typed /basic then do the following...
			if (args.length == 1){
				if (args[0].equalsIgnoreCase("list")){
					//sender.sendMessage("You typed " + args[0]);
					sender.sendMessage("Master Whitelist is as follows");
					List<String> listOfStrings = MasterWhitelist.masterwhitelist.getStringList("whitelist");
					for (String s : listOfStrings){
						sender.sendMessage(s);	
					}
					
				}
				else {
					sender.sendMessage("You need more arguments!");
				}
			}
			else if (args.length == 2){
				if (args[0].equalsIgnoreCase("add")){
					String name = args[1].toString();
					sender.sendMessage("you entered " + args[1]);
					MasterWhitelist.addWhitelist(name);
				}
				else if (args[0].equalsIgnoreCase("reload")){
					MasterWhitelist.getWhiteList();
				}
				else {
					sender.sendMessage("yoloswag");
				}
			}
			return true;}
		else if (cmd.getName().equalsIgnoreCase("api")){
			String Key = Config.config.getString(opts + "Key").toString();
			
			sender.sendMessage(Key);
			return true;
		}
			return false;
	}
}