package com.mooo.GuildHub;

//Package name for our server "The GuildHub" ip:GuildHub.mooo.com
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
//Importing out logger library

public final class Teleport101 extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Teleport101 plugin;
	//this names our class "Teleport101"
	
	@Override
	public void onEnable () {
		getLogger().info ("Teleport 101 is Enabled!");
	} //The message sent to the console when plugin is enabled.
	
	@Override
	public void onDisable (){
		getLogger().info ("Teleport 101 is Disabled!");
	} //The message sent to the console when plugin is disabled.

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String [] args){
		//Tells java what to do when a player uses any of the commands listed below.
		Player player = (Player) sender;
		//named our variable "Player" Which is a player of course.
		
		if(commandLabel.equalsIgnoreCase("teleport101"))//Named our command.
		{
			if(args.length == 0)//If the player only types the command without a point to teleport to,
			{
				player.sendMessage(ChatColor.DARK_RED + "You're so retarted... /teleport101 [Username] [targetUsername]");
			} //The player will receive this message.
			
			else if(args.length == 1)//If the player types one name to teleport to,
			{
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				//Gets this name: /teleport101 "targetPlayer".
				Location targetPlayerLocation = targetPlayer.getLocation();
				//Gets that player's location.
				targetPlayer.teleport(targetPlayerLocation);
				//Teleports to targetPlayer's location. (In other words, teleporting yourself to your position).
			}
			else if (args.length == 2)//If the player types two names to deal with,
			{
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				//Gets this name: /teleport101 "targetPlayer" targetPlayer1.
				Player targetPlayer1 = player.getServer().getPlayer(args[1]);
				//Gets this name: /eleport101 targetPlayer "targetPlayer1".
				Location targetPlayer1Location = targetPlayer1.getLocation();
				//Gets the location of targetPlayer1
				targetPlayer.teleport(targetPlayer1Location);
				//teleports targetPlayer (you) to targetPlayer1 (other player).
			}
		}
		return false;//Otherwise, return false.
	}
} //done!
