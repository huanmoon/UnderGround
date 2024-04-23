package net.achievevoid.underground.listeners;

import net.achievevoid.underground.utils.HashMaps;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.sql.SQLException;

public class EnchantmentTableListener implements Listener {
    @EventHandler
    private void onPlayerInteractEntity(PlayerInteractEntityEvent event) throws SQLException {
        Entity entity = event.getRightClicked();
        if(HashMaps.npcs.containsKey(entity.getUniqueId())) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            HashMaps.npcs.get(entity.getUniqueId()).excute(player);
        }
    }
}
