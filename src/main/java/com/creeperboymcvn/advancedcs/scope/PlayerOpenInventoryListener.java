package com.creeperboymcvn.advancedcs.scope;

import com.creeperboymcvn.advancedcs.ACS;
import com.creeperboymcvn.advancedcs.util.OffhandItemSaver;
import com.creeperboymcvn.advancedcs.util.PluginProperties;
import com.creeperboymcvn.advancedcs.util.ScopePlayer;
import com.creeperboymcvn.advancedcs.util.StringUtils;
import me.DeeCaaD.CrackShotPlus.API;
import me.DeeCaaD.CrackShotPlus.CSPPlayer;
import me.DeeCaaD.CrackShotPlus.InventoryClick;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class PlayerOpenInventoryListener implements Listener {

    public PlayerOpenInventoryListener() {}

    @EventHandler
    public void onOpenInv(InventoryOpenEvent e) {
        e.getPlayer().getInventory().setItemInOffHand(OffhandItemSaver.getItem((Player) e.getPlayer()));
        OffhandItemSaver.unsaveOffhandItem((Player) e.getPlayer());
        CSPPlayer cspPlayer = API.getCSPPlayer((Player) e.getPlayer());
        cspPlayer.setZooming(false);

    }
}
