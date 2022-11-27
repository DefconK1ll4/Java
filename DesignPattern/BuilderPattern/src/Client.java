import java.time.LocalDate;

public class Client {

    public static void main(String[] args) {

    }


    public static User createUser() {
        User user = new User();
        user.setBirthday(LocalDate.of(1987,1,5));
        user.setFirstName();
    }
}
