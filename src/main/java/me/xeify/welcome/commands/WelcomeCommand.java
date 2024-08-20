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
 import org.bukkit.configuration.file.FileConfiguration;

 import java.util.List;

 public class WelcomeCommand implements CommandExecutor {


  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
   if (sender.hasPermission("welcome.welcome")) {
    if (args.length < 2) {
     sender.sendMessage("&aUsage: &d/welcome <line number> <new message>");
     return true;
    }

    int lineNumber;
    try {
     lineNumber = Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
     sender.sendMessage("Invalid line number: " + args[0]);
     return true;
    }

    FileConfiguration config = Welcome.INSTANCE.getConfig();
    List<String> welcomeMessage = config.getStringList("welcome-message");

    if (welcomeMessage == null || welcomeMessage.isEmpty()) {
     sender.sendMessage("Error: The welcome message is not configured or is empty.");
     return true;
    }

    if (lineNumber < 1 || lineNumber > welcomeMessage.size()) {
     sender.sendMessage("Line number out of range. Valid lines: 1 to " + welcomeMessage.size());
     return true;
    }

    // Construct the new line message
    StringBuilder newMessage = new StringBuilder();
    for (int i = 1; i < args.length; i++) {
     newMessage.append(args[i]).append(" ");
    }

    // Trim and update the specific line in the config
    String trimmedMessage = newMessage.toString().trim();
    welcomeMessage.set(lineNumber - 1, trimmedMessage);
    config.set("welcome-message", welcomeMessage);
    Welcome.INSTANCE.saveConfig();

    sender.sendMessage("Line " + lineNumber + " updated to: " + trimmedMessage);
    return true;
   }
   else {
    GeneralUtils.msg(sender, "&cYou do not have permission!");
   }
      return false;
  }
 }