package ex03;

public class Program {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        User user1 = new User("Felix", 1000000);
        User user2 = new User("BangChan", 100000);
        User user3 = new User("IN", -1000);
        User user4 = new User("SengMin", 2000);
        User user5 = new User("V", 80000);

        TransactionsList list = new TransactionsLinkedList();
        user1.setTransactionsList(list);
        user2.setTransactionsList(list);
        user3.setTransactionsList(list);
        user4.setTransactionsList(list);
        user5.setTransactionsList(list);


        Transaction transaction1 = Transaction.createTransaction(user2, user1, Transaction.Type.CREDIT, -500);
        Transaction transaction2 = Transaction.createTransaction(user1, user2, Transaction.Type.DEBIT, 500);
        Transaction transaction3 = Transaction.createTransaction(user2, user3, Transaction.Type.CREDIT, -500);
        Transaction transaction4 = Transaction.createTransaction(user3, user2, Transaction.Type.DEBIT, 500);
        Transaction transaction5 = Transaction.createTransaction(user5, user3, Transaction.Type.CREDIT, -5000);
        Transaction transaction6 = Transaction.createTransaction(user4, user5, Transaction.Type.DEBIT, 5000);
        Transaction transaction7 = Transaction.createTransaction(user3, user2, Transaction.Type.DEBIT, 100);
        Transaction transaction8 = Transaction.createTransaction(user5, user3, Transaction.Type.CREDIT, -100);
        Transaction transaction9 = Transaction.createTransaction(user4, user5, Transaction.Type.DEBIT, 100);
        Transaction transaction10 = Transaction.createTransaction(user3, user2, Transaction.Type.DEBIT, 10);
        Transaction transaction11 = Transaction.createTransaction(user5, user3, Transaction.Type.CREDIT, -10);
        Transaction transaction12 = Transaction.createTransaction(user4, user5, Transaction.Type.DEBIT, 100);

        list.add(transaction1);
        list.add(transaction2);
        list.add(transaction3);
        list.add(transaction4);
        list.add(transaction5);
        list.add(transaction6);
        list.add(transaction7);
        list.add(transaction8);
        list.add(transaction9);
        list.add(transaction10);
        list.add(transaction11);
        list.add(transaction12);


        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Transactions" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "delete" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);
        System.out.println(list.remove(transaction2.getIdentifier().toString()));
        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "print list array" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);
        for (Transaction t : list.toArray()) {
            System.out.println(t);
        }
        System.out.println(ANSI_GREEN + "*********" + ANSI_RESET);
//        list.remove("13");
    }
}
