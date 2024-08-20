package me.xeify.welcome.utils;

import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CC
{
    public static String translate(final String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
