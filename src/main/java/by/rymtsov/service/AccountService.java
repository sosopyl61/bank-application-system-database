package by.rymtsov.service;

import by.rymtsov.database_config.DatabaseService;
import by.rymtsov.log.CustomLogger;
import by.rymtsov.model.Account;
import by.rymtsov.repository.AccountRepository;
import by.rymtsov.repository.TransactionRepository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public void doTransaction(String fromAccount, String toAccount, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        if (fromAccount.equals(toAccount)) {
            throw new IllegalArgumentException("You cannot do transaction with the same accounts.");
        }

        try (Connection connection = DatabaseService.getConnection()) {
            connection.setAutoCommit(false);
            Account sendFromAccount = accountRepository.getAccountByNumber(fromAccount);
            Account sendToAccount = accountRepository.getAccountByNumber(toAccount);

            if (sendFromAccount == null || sendToAccount == null) {
                throw new IllegalArgumentException("Account not found.");
            }

            if (sendFromAccount.getBalance().compareTo(amount) < 0) {
                throw new IllegalArgumentException("Sender does not have enough money.");
            }

            accountRepository.updateBalance(fromAccount, sendFromAccount.getBalance().subtract(amount));
            accountRepository.updateBalance(toAccount, sendToAccount.getBalance().add(amount));

            transactionRepository.logTransaction(fromAccount, toAccount, amount);
            connection.commit();
        } catch (SQLException e) {
            CustomLogger.error(e.getMessage());
        }
    }
}
