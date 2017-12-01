package uk.tjevans.guildjoin;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerConnectEvent implements Listener {
	
	private GuildJoin guildjoin;
	
	public PlayerConnectEvent(GuildJoin guildjoin) {
		this.guildjoin = guildjoin;
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		//String name = player.getName();
		UUID uuid = player.getUniqueId();
		String kick = "You are not on the whitelist for this server. Please contact an Administrator if you believe this is in error";
		List<String> listOfStrings = MasterWhitelist.getWhiteList();
		for (String s : listOfStrings){
					//UUID uid = UUID.fromString(s);
				if (player.getDisplayName().equalsIgnoreCase(s)){
					player.sendMessage("Welcome");
					
				}
				else {
					Bukkit.getLogger().info(uuid + " tried to join");
					player.kickPlayer(kick);
				}
		}
	}
}
