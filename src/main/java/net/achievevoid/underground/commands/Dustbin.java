package net.achievevoid.underground.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Dustbin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player)sender;
            Inventory inventory = Bukkit.createInventory(null, 54, "Dustbin");
            player.openInventory(inventory);
            return true;
        }
        else {
            return false;
        }
    }
}