package by.rymtsov.database_config;

import by.rymtsov.log.CustomLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    final static String URL = "jdbc:postgresql://localhost:5432/bank_database";
    final static String DB_USER = "user32";
    final static String DB_PASSWORD = "qwerty";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            CustomLogger.error(e.getMessage());
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            CustomLogger.error(e.getMessage());
        }
        return null;
    }
}
