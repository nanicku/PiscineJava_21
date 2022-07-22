package ex02;

public class UsersArrayList implements UsersList {
    private User[] userArr;
    private static Integer count;

    private static Integer DEFAULT_SIZE = 10;

    public UsersArrayList() {
        userArr = new User[DEFAULT_SIZE];
        count = 0;
    }

    @Override
    public void add(User user) {
        if (userArr.length == count) {
            User[] newArr = new User[count + count/2];
            for (int i = 0; i < userArr.length; i++) {
                newArr[i] = userArr[i];
            }
            userArr = newArr;
        }
        if (userArr.length < count) {
            for (int i = 0; i < count; i++) {
                if (userArr[i] == null) {
                    userArr[i] = user;
                    count++;
                    break;
                }
            }
        }
        userArr[count] = user;
        count++;
    }

    @Override
    public User getById(Integer id) {
        for (int i = 0; i < count; i++) {
            if (id.equals(userArr[i].getIdentifier())) {
                return userArr[i];
            }
        }
        throw new UserNotFoundException("User not found! Wrong Id");
    }

    @Override
    public User getByIndex(Integer index) {
        if (index < 0 || index >= count) {
            throw new UserNotFoundException("User not found! Wrong Index");
        }
        return userArr[index];
    }

    @Override
    public Integer getCount() {
        return count;
    }
}
