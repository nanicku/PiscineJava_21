package ex01;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Felix", 10000);
        User user2 = new User("BangChan", 1000);
        User user3 = new User("In", -100);

        System.out.println(user1.getIdentifier());
        System.out.println(user2.getIdentifier());
        System.out.println(user3.getIdentifier());
        System.out.println(user3.toString());

    }
}
