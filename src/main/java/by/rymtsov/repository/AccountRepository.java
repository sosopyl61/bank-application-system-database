package by.rymtsov.repository;

import by.rymtsov.log.CustomLogger;
import by.rymtsov.model.Account;
import by.rymtsov.database_config.DatabaseService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {
    private DatabaseService databaseService;

    public AccountRepository() {
        databaseService = new DatabaseService();
    }

    public void createAccount(String accountNumber, BigDecimal balance) {
        try (Connection connection = databaseService.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLQuery.INSERT_ACCOUNT);
            statement.setString(1, accountNumber);
            statement.setBigDecimal(2, balance);
            statement.executeUpdate();
        } catch (SQLException e) {
            CustomLogger.error(e.getMessage());
        }
    }

    public Account getAccountByNumber(String accountNumber) {
        try (Connection connection = databaseService.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLQuery.GET_ACCOUNT);
            statement.setString(1, accountNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Account(resultSet.getLong("id"),
                        resultSet.getString("account_number"),
                        resultSet.getBigDecimal("balance"));
            }
        } catch (SQLException e) {
            CustomLogger.error(e.getMessage());
        }
        return null;
    }

    public void updateBalance(String accountNumber, BigDecimal balance) {
        try (Connection connection = databaseService.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQLQuery.UPDATE_ACCOUNT);
            statement.setBigDecimal(1, balance);
            statement.setString(2, accountNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            CustomLogger.error(e.getMessage());
        }
    }
}
