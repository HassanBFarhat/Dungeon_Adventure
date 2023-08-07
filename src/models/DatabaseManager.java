package models;
import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class DatabaseManager {
    private static SQLiteDataSource ds = null;
    private final Logger logger;

    public DatabaseManager(Logger logger) {
        this.logger = logger;
        try {
            ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:dungeon_characters.sqlite");
        } catch (Exception e) {
            this.logger.log(Level.SEVERE, "Error connecting to the database", e);
            throw new RuntimeException(e);
        }
    }

    public ResultSet queryMonster(String monsterType) {
        String query = "SELECT * FROM monsters WHERE monster_name = ?";

        try (Connection conn = ds.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, monsterType);
            return stmt.executeQuery();

        } catch (final SQLException e) {
            logger.log(Level.SEVERE, "Error querying the database", e);
            throw new RuntimeException(e);
        }
    }
}

