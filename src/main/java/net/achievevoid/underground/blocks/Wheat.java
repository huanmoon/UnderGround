package net.achievevoid.underground.block;

import net.achievevoid.antiblockdrop.events.PlayerGetItemEvent;
import net.achievevoid.underground.utils.HashMaps;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Wheat extends Block {
    public Wheat() {
        super(Material.CROPS, player -> {
            ItemStack wheat = HashMaps.items.get("wheat");
            List<ItemStack> tempList = new ArrayList<>();
            tempList.add(wheat);
            PlayerGetItemEvent playerGetItemEvent = new PlayerGetItemEvent(player, tempList);
            Bukkit.getPluginManager().callEvent(playerGetItemEvent);
            HashMaps.statCodes.get("exp").increase(player.getUniqueId(), 1);
        });

        HashMaps.harvestingPowerRequired.put(Material.CROPS, 1);
    }
}
