package com.creeperboymcvn.advancedcs.scope;

import com.creeperboymcvn.advancedcs.util.OffhandItemSaver;
import com.creeperboymcvn.advancedcs.util.ScopePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    public PlayerQuitListener() {};

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (OffhandItemSaver.getItem(e.getPlayer())!=null) {
            Player p = e.getPlayer();
            p.getInventory().setItemInOffHand(OffhandItemSaver.getItem(p));
            OffhandItemSaver.unsaveOffhandItem(p);
            ScopePlayer.setScope(p, false);
        }
    }

}
