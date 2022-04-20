package com.creeperboymcvn.advancedcs.headshotdeath;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class HS$AttackListener implements Listener {
    public HS$AttackListener() {}

    @EventHandler
    public void onAttack(WeaponDamageEntityEvent event) {
        if (event.isHeadshot()) {
            HeadshotDataStorage.savePlayer(event.getPlayer());
        }
    }
}
