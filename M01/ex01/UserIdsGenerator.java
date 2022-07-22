package ex01;

public class UserIdsGenerator {
    private static Integer lastId;

    private static UserIdsGenerator generator;

    private UserIdsGenerator() {
        lastId = new Integer(1);
    }

    public static UserIdsGenerator getInstance() {
        if (generator == null) {
            generator = new UserIdsGenerator();
        }
        return generator;
    }

    public Integer generateId() {
        return lastId++;
    }
}
