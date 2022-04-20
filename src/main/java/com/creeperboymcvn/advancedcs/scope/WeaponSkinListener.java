package com.creeperboymcvn.advancedcs.scope;

import com.creeperboymcvn.advancedcs.util.OffhandItemSaver;
import com.creeperboymcvn.advancedcs.util.PluginProperties;
import com.creeperboymcvn.advancedcs.util.ScopePlayer;
import me.DeeCaaD.CrackShotPlus.API;
import me.DeeCaaD.CrackShotPlus.Events.WeaponSkinEvent;
import me.DeeCaaD.CrackShotPlus.Skin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class WeaponSkinListener implements Listener {

    public WeaponSkinListener() {}

    @EventHandler
    public void onSkin(WeaponSkinEvent event) {
        if (!PluginProperties.ADVANCED_SCOPE) {
            return;
        }
        if (event.getSkin().getSkinType().equals(Skin.SkinType.SCOPE)) {
            Skin skin = event.getSkin();
            Player player = event.getPlayer();
            OffhandItemSaver.saveOffhandItem(player, player.getInventory().getItemInOffHand());
            ItemStack offhandScope = new ItemStack(skin.getItemType());
            if (API.getVersion()>=1.132) {
                ItemMeta itemMeta = offhandScope.getItemMeta();
                assert itemMeta != null;
                if (skin.getCustomModelData() != 0 && API.getVersion() >= 1.14) {
                    itemMeta.setCustomModelData(skin.getCustomModelData());
                } else if (skin.getDurability() != 0) {
                    ((Damageable) itemMeta).setDamage(skin.getDurability());
                }
                offhandScope.setItemMeta(itemMeta);
            }
            if (skin.getDurability()!=0&&API.getVersion()<1.132){
                offhandScope.setDurability((short)skin.getDurability());
            }

            if (API.getVersion()>1.11) {
                ItemMeta itemMeta = offhandScope.getItemMeta();
                assert itemMeta != null;
                itemMeta.setUnbreakable(true);
                offhandScope.setItemMeta(itemMeta);
            }

            player.getInventory().setItemInOffHand(offhandScope);
            ScopePlayer.setScope(player, true);

        } else {
            if (OffhandItemSaver.getItem(event.getPlayer())!=null) {
                Player p = event.getPlayer();
                p.getInventory().setItemInOffHand(OffhandItemSaver.getItem(p));
                OffhandItemSaver.unsaveOffhandItem(p);
                ScopePlayer.setScope(p, false);
            }
        }
    }
}
