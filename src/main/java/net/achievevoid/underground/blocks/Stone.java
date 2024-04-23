package net.achievevoid.underground.block;

import net.achievevoid.antiblockdrop.events.PlayerGetItemEvent;
import net.achievevoid.underground.utils.HashMaps;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Stone extends Block {
    public Stone() {
        super(Material.STONE, player -> {
            ItemStack stone = HashMaps.items.get("cobblestone");
            List<ItemStack> tempList = new ArrayList<>();
            tempList.add(stone);
            double rn = Math.random();
            if(rn <= 0.1) {
                tempList.add(HashMaps.items.get("coal"));
            }
            PlayerGetItemEvent playerGetItemEvent = new PlayerGetItemEvent(player, tempList);
            Bukkit.getPluginManager().callEvent(playerGetItemEvent);
            HashMaps.statCodes.get("exp").increase(player.getUniqueId(), 5);
        });

        HashMaps.hardness.put(Material.STONE, 1);
    }
}
