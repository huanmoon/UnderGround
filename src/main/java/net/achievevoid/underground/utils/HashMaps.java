package net.achievevoid.underground.misc;

import net.achievevoid.underground.stats.Stat;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.NPC;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class HashMaps {
    public static HashMap<UUID, Action> npcs = new HashMap<>();
    public static HashMap<UUID, Integer> exp = new HashMap<>();
    public static HashMap<UUID, Integer> levels = new HashMap<>();
    public static HashMap<UUID, Integer> expNeeded = new HashMap<>();
    public static final HashMap<String, ItemStack> items = new HashMap<>();
    public static final HashMap<Material, Integer> hardness = new HashMap<>();
    public static HashMap<String, Stat> statCodes = new HashMap<>();
}
