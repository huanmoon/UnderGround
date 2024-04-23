package net.achievevoid.underground.utils;

import org.bukkit.entity.Player;

import java.sql.SQLException;

public class Leveling {
    public static void expIncrease(Player player, int amount) throws SQLException {
        int exp = HashMaps.exp.get(player.getUniqueId())+amount;
        HashMaps.exp.replace(player.getUniqueId(), exp);
        Leveling.calculateLevel(player);
        Sqlite.setInteger(Sqlite.PLAYER_STATS, "exp", player.getUniqueId(), exp);
    }

    public static void calculateLevel(Player player) {
        int exp = HashMaps.exp.get(player.getUniqueId());
        int level;
        int expNeeded;
        if(exp >= 1 && exp <= 500) {  //level 1~10
            level = exp/50+1;
            expNeeded = level*50;
        }
        else if(exp >= 501 && exp <= 20000) {  //level 11~20
            level = exp/1000+1;
            expNeeded = level*1000;
        }
        else {
            level = exp/5000+1;
            expNeeded = level*5000;
        }
        HashMaps.levels.put(player.getUniqueId(), level);
        HashMaps.expNeeded.put(player.getUniqueId(), expNeeded);
    }
}
