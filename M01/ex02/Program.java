package ex02;

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Felix", 1000000);
        User user2 = new User("BangChan", 100000);
        User user3 = new User("IN", -1000);
        User user4 = new User("SengMin", 2000);
        User user5 = new User("V", 80000);

        UsersList strayKids = new UsersArrayList();
        strayKids.add(user1);
        strayKids.add(user2);
        strayKids.add(user3);
        strayKids.add(user4);
        strayKids.add(user5);


        for (int i = 0; i < strayKids.getCount(); i++) {
            System.out.println(strayKids.getByIndex(i));
        }

        System.out.println();

        System.out.println(user1);
        System.out.println("count UsersArr = " + strayKids.getCount());

        User user6 = new User("Roza", 100);
        System.out.println(strayKids.getById(5));
        System.out.println(strayKids.getByIndex(4));
        System.out.println(strayKids.getById(6));
        System.out.println(strayKids.getByIndex(5));
    }
}
