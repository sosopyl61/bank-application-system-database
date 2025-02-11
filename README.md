# Bank Application System

A Java application for managing bank accounts and performing transactions using a PostgreSQL database.

## Task

### Functions of the Application:

- **Create Account**: A method for adding a new account with an initial balance.
- **View Balance**: A method for retrieving the current balance by account number.
- **Transfer Funds**: A method for transferring funds from one account to another. This method should be implemented as a transaction to ensure data integrity.

### Transactions:

Implement the fund transfer between two accounts as a transaction. If the transfer cannot be completed (e.g., insufficient funds), the transaction should be rolled back.

### Error Handling:

Handle possible exceptions such as insufficient funds for the transfer and ensure that the transaction is rolled back in case of an error.

### Testing:

Test account creation, balance viewing, and fund transfers.

### Additional Task:

Implement logging of operations in a separate `transactions` table, where information about each transfer will be stored: `transaction_id`, `from_account`, `to_account`, `amount`, `timestamp`.

## Database Structure

### Accounts table:

| Field           | Data Type         | Description                       |
|-----------------|-------------------|-----------------------------------|
| id              | SERIAL PRIMARY KEY| Unique identifier                 |
| account_number  | VARCHAR(100)        | Account number (unique)           |
| balance         | DECIMAL     | Account balance                   |

### Transactions table:

| Field           | Data Type         | Description                        |
|-----------------|-------------------|------------------------------------|
| transaction_id  | SERIAL PRIMARY KEY| Unique transaction identifier      |
| from_account    | VARCHAR(100)        | Sender's account number            |
| to_account      | VARCHAR(100)        | Receiver's account number          |
| amount          | DECIMAL    | Transfer amount                    |
| timestamp       | TIMESTAMP          | Date and time of the transaction   |
