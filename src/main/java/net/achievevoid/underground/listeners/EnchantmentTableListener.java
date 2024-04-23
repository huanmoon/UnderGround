package net.achievevoid.underground.listeners;

import net.achievevoid.antiblockdrop.events.PlayerGetItemEvent;
import net.achievevoid.guiapi.menus.Menu;
import net.achievevoid.underground.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlayerInteractListener implements Listener {
    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getClickedBlock() != null) {
            Block block = event.getClickedBlock();
            if(block.getType() == Material.ENCHANTMENT_TABLE) {
                event.setCancelled(true);
                Player player = event.getPlayer();
                Inventory inventory = Bukkit.createInventory(null, 54, "Enchantment Table");
                Menu menu = new Menu(player, inventory);
                menu.setElement(4, 4, ChatColor.YELLOW + "" + ChatColor.BOLD + "ENCHANT!", Material.ENCHANTMENT_TABLE);
                ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE);
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(" ");
                itemStack.setItemMeta(itemMeta);
                menu.fill(itemStack);
                menu.setElement(4, 1, null);
                menu.display(player);
            }
        }
    }

    @EventHandler
    private void onPlayerCloseMenu(InventoryCloseEvent event) {
        if(event.getInventory().getName().equals("Enchantment Table") && event.getPlayer() instanceof Player) {
            Inventory inventory = event.getInventory();
            Player player = (Player)event.getPlayer();
            Menu menu = new Menu(player, inventory);
            if(menu.getElement(4, 1) != null) {
                List<ItemStack> items = new ArrayList<>();
                items.add(menu.getElement(4, 1));
                PlayerGetItemEvent playerGetItemEvent = new PlayerGetItemEvent(player, items);
                Bukkit.getPluginManager().callEvent(playerGetItemEvent);
            }
        }
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent event) {
        ItemStack itemStack = event.getCurrentItem();
        if(event.getWhoClicked() instanceof Player && event.getInventory() != null && event.getClickedInventory() != null && itemStack != null) {
            Player player = (Player)event.getWhoClicked();
            Inventory inventory = event.getClickedInventory();
            if(player.getInventory() == inventory) {
                ItemUtils.consume(player, itemStack);
                Menu menu = new Menu(player, event.getInventory());
                menu.setElement(4, 1, itemStack);
            }
            else {

            }
        }
    }
}
