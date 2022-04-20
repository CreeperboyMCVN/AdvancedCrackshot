package com.creeperboymcvn.advancedcs.util;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class ScopePlayer {
    private static Map<Player, Boolean> map = new HashMap<>();

    public static void setScope(Player p, boolean b) {
       map.put(p,b);
    }

    public static boolean getScope(Player p) {
        if (map.get(p)==null) {
            return false;
        }
        return map.get(p);
    }
}
