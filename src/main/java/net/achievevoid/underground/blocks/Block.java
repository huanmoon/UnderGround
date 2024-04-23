package net.achievevoid.underground.block;

import net.achievevoid.underground.utils.Action;
import net.achievevoid.underground.utils.HashMaps;
import org.bukkit.Material;

public class Block {
    public Block(Material material, Action action) {
        HashMaps.blockActions.put(material, action);
    }
}
