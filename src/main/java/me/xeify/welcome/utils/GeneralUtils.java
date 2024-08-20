 /* @author Xeify (Discord: Xeify)
  * 3/21/2022
  * me.xeify.welcome.commands
  */

package me.xeify.welcome.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Utility class for all of my plugins :)
 */
public class GeneralUtils {

    public static void logMessage(String message) {
        Bukkit.getConsoleSender().sendMessage(CC.translate(message));
    }

    public static void bcMsg(final String input) {
        Bukkit.broadcastMessage(tr(input));
    }

    public static void msg(final CommandSender target, final String message) {
        target.sendMessage(tr(message));
    }

    public static void msg(final CommandSender target, final List<String> message) {
        tr(message).forEach(target::sendMessage);
    }


    public static String tr(final String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static List<String> tr(final List<String> coll) {
        return coll.stream().map(str -> tr(str)).collect(Collectors.toList());
    }
    }

