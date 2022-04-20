package com.creeperboymcvn.advancedcs.util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class OffhandItemSaver {
    private static Map<Player, ItemStack> map = new HashMap<>();

    public static void saveOffhandItem(Player p, ItemStack i) {
        map.put(p, i);
    }

    public static void unsaveOffhandItem(Player p) {
        map.put(p, null);
    }

    public static ItemStack getItem(Player p) {
        return map.get(p);
    }
}
