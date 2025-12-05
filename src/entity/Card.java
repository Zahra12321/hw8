package entity;

public class Card {
    private String cardNumber;
    private String bankName;
    private Integer userId;
    private int balance;

    public Card() {
    }

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Card(String cardNumber, String bankName, Integer userId) {
        this(cardNumber);
        this.bankName = bankName;
        this.userId = userId;
    }

    public Card(String cardNumber, String bankName, Integer userId, int balance) {
        this(cardNumber, bankName, userId);
        this.balance = balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) throws IllegalArgumentException {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds in account: " + cardNumber);
        }
        balance -= amount;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", userId=" + userId +
                ", balance=" + balance +
                '}';
    }
}
