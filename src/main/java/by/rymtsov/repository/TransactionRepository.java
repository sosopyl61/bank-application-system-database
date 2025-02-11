package by.rymtsov.repository;

import by.rymtsov.log.CustomLogger;
import by.rymtsov.database_config.DatabaseService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionRepository {

    public void logTransaction(String fromAccount, String toAccount, BigDecimal amount) {
        try (Connection connection = DatabaseService.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLQuery.LOG_TRANSACTION);
            statement.setString(1, fromAccount);
            statement.setString(2, toAccount);
            statement.setBigDecimal(3, amount);
            statement.executeUpdate();
        } catch (SQLException e) {
            CustomLogger.error(e.getMessage());
        }
    }
}
