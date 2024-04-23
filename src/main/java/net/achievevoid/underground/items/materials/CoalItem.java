package net.achievevoid.underground.items.materials;

import net.achievevoid.underground.enums.Rarity;
import net.achievevoid.underground.items.Item;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class Coal extends Item {
    public Coal() {
        super(Material.COAL, "Coal", Rarity.DUSTY, "coal", ChatColor.GREEN + "sometimes it drops from cobblestones...");
    }
}