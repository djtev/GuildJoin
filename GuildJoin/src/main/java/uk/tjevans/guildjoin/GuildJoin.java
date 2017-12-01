package uk.tjevans.guildjoin;

import java.io.File;


import org.bukkit.plugin.PluginManager;
//import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GuildJoin extends JavaPlugin {

	private Config config;
	private MasterWhitelist masterwhitelist;
	File file = new File(this.getDataFolder(), "masterwhitelist.yml");
	File file2 = new File(this.getDataFolder(), "config.yml");
	public String Key;
	
	public GuildJoin (){
		this.config = new Config(this);
		this.masterwhitelist = new MasterWhitelist(this);
	}
	
	@Override
    public void onEnable() {
		if (file2.exists()){
		}
		else {
		config.addDefaultValues();
		masterwhitelist.addDefaultValues();
		}
		Key = config.getAPIKey();
		this.getCommand("masterwhitelist").setExecutor(new Commands());
		this.getCommand("api").setExecutor(new Commands());
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new PlayerConnectEvent(this), this);
		getLogger().info("Guild Join has been Enabled!");
//		PluginManager manager = getServer().getPluginManager();
		// TODO Insert logic to be performed when the plugin is enabled
    }
    
    @Override
    public void onDisable() {
    	getLogger().info("Guild Join has been Disbled!");
        // TODO Insert logic to be performed when the plugin is disabled
    }

    public String getKey(){
    	return Key;
    }
    
}
