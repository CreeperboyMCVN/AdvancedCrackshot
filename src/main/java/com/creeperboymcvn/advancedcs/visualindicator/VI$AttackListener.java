package com.creeperboymcvn.advancedcs.visualindicator;

import com.creeperboymcvn.advancedcs.ACS;
import com.creeperboymcvn.advancedcs.util.PluginProperties;
import com.creeperboymcvn.advancedcs.util.PluginUtil;
import com.creeperboymcvn.advancedcs.util.StringUtils;
import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class VI$AttackListener implements Listener {
    public VI$AttackListener() {}

    @EventHandler
    public void onAttack(WeaponDamageEntityEvent event) {
        if (!PluginProperties.VISUAL_INDICATOR) {
            return;
        }
        String color = ACS.inst.getConfig().getString("visualIndicator.color");
        String headshot = ACS.inst.getConfig().getString("visualIndicator.headshot");
        String symbol = ACS.inst.getConfig().getString("visualIndicator.symbol");
        String backstab = ACS.inst.getConfig().getString("visualIndicator.backstab");
        String mode = ACS.inst.getConfig().getString("visualIndicator.mode");

        if (event.isHeadshot()) {
            if (mode.equalsIgnoreCase("title")) {
                PluginUtil.sendTitle(event.getPlayer(), StringUtils.colorize(headshot+symbol));
                return;
            } else {
                PluginUtil.sendSubtitle(event.getPlayer(), StringUtils.colorize(headshot+symbol));
                return;
            }
        }
        if (event.isBackstab()) {
            if (mode.equalsIgnoreCase("title")) {
                PluginUtil.sendTitle(event.getPlayer(), StringUtils.colorize(backstab+symbol));
                return;
            } else {
                PluginUtil.sendSubtitle(event.getPlayer(), StringUtils.colorize(backstab+symbol));
                return;
            }
        }
            if (mode.equalsIgnoreCase("title")) {
                PluginUtil.sendTitle(event.getPlayer(), StringUtils.colorize(color+symbol));
            } else {
                PluginUtil.sendSubtitle(event.getPlayer(), StringUtils.colorize(color+symbol));

        }

    }
}
