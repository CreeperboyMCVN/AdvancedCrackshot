package com.creeperboymcvn.advancedcs.headshotdeath;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HeadshotDataStorage {
    private static List<Player> playerList = new ArrayList<>();

    public static void savePlayer(Player p) {
        if (!playerList.contains(p)) {
            playerList.add(p);
        }
    }

    public static boolean isLastDamageHeadshot(Player p) {
        return playerList.contains(p);
    }

    public static void unsavePlayer(Player p) {
            playerList.remove(p);
    }
}
