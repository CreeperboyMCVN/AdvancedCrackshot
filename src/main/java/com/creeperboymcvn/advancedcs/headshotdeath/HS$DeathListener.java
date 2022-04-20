package com.creeperboymcvn.advancedcs.headshotdeath;

import com.creeperboymcvn.advancedcs.ACS;
import com.creeperboymcvn.advancedcs.util.StringUtils;
import com.shampaggon.crackshot.CSUtility;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class HS$DeathListener implements Listener {
    public HS$DeathListener() {}

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDeath(PlayerDeathEvent event) {
        Player victim = event.getEntity();
        Player killer = victim.getKiller();
        if (killer == null) return;
        CSUtility csUtility = new CSUtility();
        String wptitle = csUtility.getWeaponTitle(killer.getInventory().getItemInMainHand());
        if (wptitle != null) {
            if (HeadshotDataStorage.isLastDamageHeadshot(killer)) {
                String deathmsg = ACS.inst.getConfig().getString("headshotdeathmsg.weapons."+wptitle);
                if (deathmsg == null) return;
                event.setDeathMessage(StringUtils.colorize(deathmsg
                        .replace("<killer>", killer.getName())
                        .replace("<victim>", victim.getName())
                        .replace("<distance>", String.valueOf(killer.getLocation().distance(victim.getLocation())))
                        .replace("<weapon>", wptitle)));
            }
        }
    }


}
