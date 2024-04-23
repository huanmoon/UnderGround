package net.achievevoid.underground.items.materials;

import net.achievevoid.underground.enums.Rarity;
import net.achievevoid.underground.items.Item;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class CobbleStone extends Item {
    public CobbleStone() {
        super(Material.COBBLESTONE, "Cobblestone", Rarity.DUSTY, "cobblestone", ChatColor.GREEN + "a broken stone, which is very common in underground");
    }
}
