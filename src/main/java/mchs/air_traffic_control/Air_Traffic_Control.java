package mchs.air_traffic_control;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;

import java.util.ArrayList;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class Air_Traffic_Control extends JavaPlugin implements Listener {	
	int norunways = 0;
ArrayList<String> runways = new ArrayList<String>( );
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		
		
	loadConfiguration();
	      int norunways = this.getConfig().getInt("Number of Runways");
	    int i = 0;
	    
	    while(i < norunways){
	      runways.add("Empty");
	      i = i + 1;
	 	 this.getServer().getPluginManager().registerEvents(this,this);
		 getLogger().info("onEnable has been invoked!");
	    }
	 onCommand();
	}
	
	public void loadConfiguration(){
	     String path = "Number of Runways";
                 this.getConfig().addDefault(path, 3);
	    	     this.getConfig().options().copyDefaults(true);
	    	     this.saveConfig();
	}

	@Override
	   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	   	if (cmd.getName().equalsIgnoreCase("rws")) { // If the player typed /rl then do the following...
	   	 int i = 0;
	   		while(i < norunways){
	 			Bukkit.getServer().broadcastMessage(runways.get(i));
	   		i = i + 1;
    
	   		 }
	   		
	   		return true;}
	        	return false; 
	  }
	



	   }
