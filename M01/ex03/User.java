package ex03;

public class User {
    private final Integer id;
    private String name;
    private Integer balance;
    private TransactionsList list;

    public User(String name, Integer balance) {
        this.name = name;
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
        id = UserIdsGenerator.getInstance().generateId();
    }

    public Integer getIdentifier() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    public void setTransactionsList(TransactionsList list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return name + " (" + id + ") balance = " + balance;
    }
}
