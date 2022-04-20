package com.creeperboymcvn.advancedcs;

import com.creeperboymcvn.advancedcs.headshotdeath.HS$AttackListener;
import com.creeperboymcvn.advancedcs.headshotdeath.HS$DeathListener;
import com.creeperboymcvn.advancedcs.scope.PlayerOpenInventoryListener;
import com.creeperboymcvn.advancedcs.scope.PlayerQuitListener;
import com.creeperboymcvn.advancedcs.scope.WeaponSkinListener;
import com.creeperboymcvn.advancedcs.util.OffhandItemSaver;
import com.creeperboymcvn.advancedcs.util.ScopePlayer;
import com.creeperboymcvn.advancedcs.util.YamlStorage;
import com.creeperboymcvn.advancedcs.visualindicator.VI$AttackListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ACS extends JavaPlugin {

    public static ACS inst;
    public static YamlStorage message;

    @Override
    public void onEnable() {
        // Plugin startup logic
        inst = this;
        registerYamlStorage();
        saveDefaultConfig();
        registerListeners();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        clearPluginOffhandItems();
    }

    public void clearPluginOffhandItems() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (OffhandItemSaver.getItem(player)!=null) {
                player.getInventory().setItemInOffHand(OffhandItemSaver.getItem(player));
                OffhandItemSaver.unsaveOffhandItem(player);
                ScopePlayer.setScope(player, false);
            }
        }
    }

    public void registerListeners() {
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new WeaponSkinListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerOpenInventoryListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new VI$AttackListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new HS$AttackListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new HS$DeathListener(), this);
    }

    public void registerYamlStorage() {
        message = new YamlStorage(this, "message");
    }
}
