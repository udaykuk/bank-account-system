# 🏦 Bank Account System

A RESTful banking API built with Spring Boot that supports account management, transactions, and fund transfers.

## 🛠️ Tech Stack
- Java 17
- Spring Boot 3.2
- Spring Data JPA
- H2 In-Memory Database
- Lombok
- Maven

## 🚀 How to Run
1. Clone the repo
2. Open in IntelliJ IDEA
3. Run `BankAccountSystemApplication.java`
4. API available at `http://localhost:8080`
5. H2 Console at `http://localhost:8080/h2-console`

## 📌 API Endpoints

### Accounts
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /Account | Create account |
| GET | /Account/{id} | Get account |
| PUT | /Account/{id} | Update account |
| DELETE | /Account/{id} | Delete account |

### Transactions
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /Account/{id}/deposit | Deposit money |
| POST | /Account/{id}/withdraw | Withdraw money |
| POST | /Account/transfer | Transfer between accounts |
| GET | /Account/{id}/transactions | Transaction history |

## ⚠️ Exception Handling
- `404` Account not found
- `400` Insufficient funds
- `500` Internal server error
