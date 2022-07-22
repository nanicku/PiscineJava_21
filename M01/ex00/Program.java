package ex00;

public class Program {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);

        User user1 = new User("John", 10000);
        user1.setIdentifier(1);
        System.out.printf("%s %d\n", user1.getName(), user1.getBalance());

        User user2 = new User("Mike", 100000);
        user2.setIdentifier(2);
        System.out.printf("%s %d\n", user2.getName(), user2.getBalance());

        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Transactions" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);

        Transaction transaction1 = Transaction.createTransaction(user1, user2, Transaction.Type.CREDIT, -500);
        user1.setBalance(user1.getBalance() - 500);
        user2.setBalance(user2.getBalance() + 500);
        System.out.println(transaction1);

        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);

        System.out.printf("%s %d\n", user1.getName(), user1.getBalance());
        System.out.printf("%s %d\n", user2.getName(), user2.getBalance());

        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);

        Transaction transaction2 = Transaction.createTransaction(user2, user1, Transaction.Type.DEBIT, 5000);
        user1.setBalance(user1.getBalance() - 5000);
        user2.setBalance(user2.getBalance() + 5000);
        System.out.println(transaction2);

        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);

        System.out.printf("%s %d\n", user1.getName(), user1.getBalance());
        System.out.printf("%s %d\n", user2.getName(), user2.getBalance());

        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);

        transaction1 = Transaction.createTransaction(user1, user2, Transaction.Type.DEBIT, -500);
        System.out.println(transaction1);
        transaction1 = Transaction.createTransaction(user1, user2, Transaction.Type.DEBIT, 500000);
        System.out.println(transaction1);
    }
}
