package com.creeperboymcvn.advancedcs.util;

import org.bukkit.entity.Player;

public class PluginUtil {
    public static void sendTitle(Player p, String title) {
        p.sendTitle(title, "", 0, 20, 5);
    }

    public static void sendSubtitle(Player p, String subtitle) {
        p.sendTitle("", subtitle, 0, 20, 5);
    }
}
