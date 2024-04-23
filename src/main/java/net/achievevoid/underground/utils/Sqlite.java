package net.achievevoid.underground.misc;

import net.achievevoid.underground.UnderGround;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.UUID;

public class Sqlite {
    public static final String PLAYER_STATS = "player_stats";
    private static final File databaseFile = new File(UnderGround.getPlugin().getDataFolder().getAbsoluteFile() + File.separator + "database.db");
    private static Connection connection;

    public static void init() throws ClassNotFoundException, SQLException, IOException {
        if(!databaseFile.exists()) {
            databaseFile.createNewFile();
        }
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFile.getAbsolutePath());

        String sql = "CREATE TABLE IF NOT EXISTS " + PLAYER_STATS + " (" +
                "uuid TEXT PRIMARY KEY, " +
                "exp INTEGER, " +
                "coins INTEGER" +
                ")";

        connection.createStatement().execute(sql);
        connection.close();
    }

    public static void addPlayer(Player player) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFile.getAbsolutePath());
        String sql = "INSERT INTO " + PLAYER_STATS + " (uuid, exp, coins) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, player.getUniqueId().toString());
        statement.setInt(2, 1);
        statement.setInt(3, 0);
        statement.execute();
        connection.close();
    }

    public static void setInteger(String table, String columnName, UUID uuid, int value) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFile.getAbsolutePath());
        String sql = "UPDATE " + table + " SET " + columnName + " = (?) WHERE uuid = (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, value);
        statement.setString(2, uuid.toString());
        statement.execute();
        connection.close();
    }

    public static Integer getInteger(String table, String columnName, UUID uuid) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFile.getAbsolutePath());
        String sql = "SELECT " + columnName + " FROM " + table + " WHERE uuid = (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, uuid.toString());
        ResultSet resultSet = statement.executeQuery();
        int result = resultSet.getInt(columnName);  //save the result into a valuable so that the return value won't be affected by connection.close()
        connection.close();
        return result;
    }

    public static boolean doesPlayerExist(Player player) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFile.getAbsolutePath());
        String sql = "SELECT * FROM " + PLAYER_STATS + " WHERE uuid = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, player.getUniqueId().toString());
        ResultSet resultSet = statement.executeQuery();
        connection.close();
        return resultSet.next();
    }

}
