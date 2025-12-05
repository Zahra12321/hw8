package entity;

public class TransactionLog {
    private Integer id;
    private Card srcCard;
    private Card destCard;
    private int amount;
    private String status;

    public TransactionLog() {
        this.status = "WAITING";
    }

    public TransactionLog(Card srcCard, Card destCard, int amount) {
        this.srcCard = srcCard;
        this.destCard = destCard;
        this.amount = amount;
        this.status = "WAITING";
    }

    public TransactionLog(Card srcCard, Card destCard, int amount, String status) {
        this(srcCard, destCard, amount);
        this.status = "WAITING";
    }



    public void satnaTransaction() {
        if (srcCard.getBalance() >= amount) {
            srcCard.withdraw((int) (amount + (amount * 0.003)));
            destCard.deposit(amount);
            status = Status.DONE.toString();
        } else {
            status = Status.FAILED.toString();
        }
    }

    public void payaPersonalTransaction() {
        if (srcCard.getBalance() >= amount) {
            srcCard.withdraw((int) (amount + (amount * 0.001)));
            destCard.deposit(amount);
            status = Status.DONE.toString();
        } else {
            status = Status.FAILED.toString();
        }
    }

    public void cToCTransaction() {
        if (srcCard.getBalance() >= amount) {
            if (srcCard.getBankName().equals(destCard.getBankName())) {
                srcCard.withdraw(amount);
            } else if (amount <= 10000000) {
                srcCard.withdraw(amount + 720);
            } else if (amount <= 11000000) {
                srcCard.withdraw(amount + 1100);
            } else if (amount <= 12000000) {
                srcCard.withdraw(amount + 1200);
            } else if (amount <= 13000000) {
                srcCard.withdraw(amount + 1300);
            } else if (amount <= 14000000) {
                srcCard.withdraw(amount + 1400);
            } else {
                srcCard.withdraw(amount + 1500);
            }
            destCard.deposit(amount);
            status = Status.DONE.toString();
        } else {
            status = Status.FAILED.toString();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Card getSrcCard() {
        return srcCard;
    }

    public Card getDestCard() {
        return destCard;
    }

    public int getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "TransactionLog{" +
                "srcCardNum='" + srcCard.getCardNumber() + '\'' +
                ", destCardNum='" + destCard.getCardNumber() + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                '}' + "\n";
    }
}
