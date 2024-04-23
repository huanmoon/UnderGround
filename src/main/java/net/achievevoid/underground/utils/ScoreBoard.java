package net.achievevoid.underground.misc;

import net.achievevoid.underground.UnderGround;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreBoard {
    static int score = 15;
    static ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();

    public static Scoreboard setupScoreboard(Player player) {
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("test", "test2");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        tick(objective, player);

        return scoreboard;
    }

    private static void addLine(String content, Objective objective) {
        Score line = objective.getScore(content);
        line.setScore(score);
        score--;
    }

    private static void update(Objective objective, Player player) {
        for (String entry : objective.getScoreboard().getEntries()) {
            objective.getScoreboard().resetScores(entry);
        }
        score = 15;

        addLine("---------", objective);
        addLine(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Level: " + HashMaps.levels.get(player.getUniqueId()), objective);
        addLine(ChatColor.AQUA + "" + ChatColor.BOLD + "Exp: " + HashMaps.exp.get(player.getUniqueId()) + "/" + HashMaps.expNeeded.get(player.getUniqueId()), objective);
        addLine(ChatColor.YELLOW + "" + ChatColor.BOLD + "Coins: " + HashMaps.statCodes.get("coins").getMap().get(player.getUniqueId()), objective);
        addLine("--------", objective);
        addLine(ChatColor.GRAY + "play.undergroundminecraft.net", objective);
    }

    private static void tick(Objective objective, Player player) {
        String fullTitle = "UNDERGROUND";
        final String[] animatedTitle = {""};
        final int[] animationIndex = {0};

        Bukkit.getScheduler().runTaskTimer(UnderGround.getPlugin(), () -> {
            animatedTitle[0] += fullTitle.charAt(animationIndex[0]);
            objective.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + animatedTitle[0]);
            animationIndex[0]++;

            if (animationIndex[0] >= fullTitle.length()) {
                animationIndex[0] = 0;
                animatedTitle[0] = "";
            }

            update(objective, player);
        }, 0, 5);
    }
}