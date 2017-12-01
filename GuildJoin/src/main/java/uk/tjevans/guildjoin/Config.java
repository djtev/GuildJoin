package uk.tjevans.guildjoin;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

	private GuildJoin guildjoin;
	public static FileConfiguration config;
	private String opts = "Options.";
	private String API = "0c619a1b-0d51-4abe-a7c7-591c55a519e9";
	public String key;
	
	public Config(GuildJoin guildjoin) {
		
		
		this.guildjoin = guildjoin;
		Config.config = guildjoin.getConfig();
	}
	
	public void addDefaultValues() {
		config.addDefault(opts + "Key",API);
		config.options().copyDefaults(true);
		guildjoin.saveConfig();
		
	}
	
	public String getAPIKey(){
		key = config.getString(opts + "Key").toString();
		return key;
	}
	
}
