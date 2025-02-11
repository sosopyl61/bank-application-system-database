package by.rymtsov.model;

import java.math.BigDecimal;

public class Account {
    private long id;
    private String account_number;
    private BigDecimal balance;

    public Account(long id, String account_number, BigDecimal balance) {
        this.id = id;
        this.account_number = account_number;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void BigDecimal(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account_number='" + account_number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
