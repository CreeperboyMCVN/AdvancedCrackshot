package com.creeperboymcvn.advancedcs.util;

import org.bukkit.ChatColor;

public class StringUtils {
    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
