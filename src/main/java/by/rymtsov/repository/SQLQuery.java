package by.rymtsov.repository;

public interface SQLQuery {
    public String INSERT_ACCOUNT = "INSERT INTO accounts (account_number, balance) VALUES (?, ?)";
    public String GET_ACCOUNT = "SELECT * FROM accounts WHERE account_number = ?";
    public String UPDATE_ACCOUNT = "UPDATE accounts SET balance = ? WHERE account_number = ?";
    public String LOG_TRANSACTION = "INSERT INTO transactions (from_account, to_account, amount, timestamp) VALUES (?, ?, ?, now())";
}
