 /* @author Xeify (Discord: Xeify)
  * 8/19/2024
  * me.xeify.welcome.commands
  */
 package me.xeify.welcome.commands;

 import me.xeify.welcome.Welcome;
 import me.xeify.welcome.utils.GeneralUtils;
 import org.bukkit.command.Command;
 import org.bukkit.command.CommandExecutor;
 import org.bukkit.command.CommandSender;
 import org.bukkit.entity.Player;

 import java.util.List;

 public class readGreeting implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
     List<String> message = Welcome.INSTANCE.getConfig().getStringList("welcome-message");
     GeneralUtils.msg(sender, message);
      return true;
  }
   }