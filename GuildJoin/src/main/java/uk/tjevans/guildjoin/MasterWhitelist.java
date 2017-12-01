package uk.tjevans.guildjoin;

import java.util.Arrays;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

public class MasterWhitelist {

	private static GuildJoin guildjoin2;
	public static FileConfiguration masterwhitelist;
	
public MasterWhitelist(GuildJoin guildjoin2) {
		
		
		MasterWhitelist.guildjoin2 = guildjoin2;
		MasterWhitelist.masterwhitelist = guildjoin2.getConfig();
	}

public void addDefaultValues() {
	List<String> listOfStrings = Arrays.asList("tom396", "djtev");
	masterwhitelist.addDefault("whitelist", listOfStrings);
	masterwhitelist.options().copyDefaults(true);
	guildjoin2.saveConfig();
	
}


public static void addWhitelist(String name) {
	List<String> listOfStrings = masterwhitelist.getStringList("whitelist");
	listOfStrings.add(name);
	masterwhitelist.set("whitelist", listOfStrings);
	guildjoin2.saveConfig();
}
	
	public static List<String> getWhiteList(){
		List<String> listOfStrings = masterwhitelist.getStringList("whitelist");
		return listOfStrings;
	}

}
