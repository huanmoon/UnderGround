package net.achievevoid.underground.items.materials;

import net.achievevoid.underground.enums.Rarity;
import net.achievevoid.underground.items.Item;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class Wheat extends Item {
    public Wheat() {
        super(Material.WHEAT, "Wheat", Rarity.DUSTY, "wheat", ChatColor.GREEN + "A stuff loves eating cows");
    }
}
