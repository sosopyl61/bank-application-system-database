package by.rymtsov.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Transaction {
    private long transaction_id;
    private String from_account;
    private String to_account;
    private BigDecimal amount;
    private Date date;

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getFrom_account() {
        return from_account;
    }

    public void setFrom_account(String from_account) {
        this.from_account = from_account;
    }

    public String getTo_account() {
        return to_account;
    }

    public void setTo_account(String to_account) {
        this.to_account = to_account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void BigDecimal(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", from_account='" + from_account + '\'' +
                ", to_account='" + to_account + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
