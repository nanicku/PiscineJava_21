package ex03;

public class UserIdsGenerator {
    private Integer lastId;

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
