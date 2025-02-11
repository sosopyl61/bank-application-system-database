package by.rymtsov.application;

import by.rymtsov.log.CustomLogger;
import by.rymtsov.repository.AccountRepository;
import by.rymtsov.repository.TransactionRepository;
import by.rymtsov.service.AccountService;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
        TransactionRepository transactionRepository = new TransactionRepository();
        AccountService accountService = new AccountService(accountRepository, transactionRepository);

        try {
            accountRepository.createAccount("47852759", new BigDecimal("100.00"));
            accountRepository.createAccount("13943918", new BigDecimal("150.00"));

            accountService.doTransaction("47852759", "13943918", new BigDecimal("100.00"));

            System.out.println("Account №47852759: " + accountRepository.getAccountByNumber("47852759").getBalance());
            System.out.println("Account №13943918: " + accountRepository.getAccountByNumber("13943918").getBalance());
        } catch (Exception e) {
            CustomLogger.error(e.getMessage());
        }
    }
}
