import java.time.LocalDate;

public class Client {

    public static void main(String[] args) {
        User user = createUser();
        UserDTOBuilder builder = new UserWebDTOBuilder();
        //Client has to provide director with concrete builder
        UserDTO dto = directBuild(builder, user);
        System.out.println(dto);
    }
    // Method to serve the role of director in builder pattern.

    private static UserDTO directBuild(UserDTOBuilder builder, User user) {
        return builder.withFirstName(user.getFirstName()).withLastName(user.getLastName())
                .withAddress(user.getAddress())
                .withBirthday(user.getBirthday())
                .build();
    }


    public static User createUser() {
        User user = new User();
        user.setBirthday(LocalDate.of(1987,1,5));
        user.setFirstName("Bulan");
        user.setLastName("Finski");
        Address address = new Address();
        address.setHouseNumber("66");
        address.setStreet("Bulansväg");
        address.setCity("Helsinki");
        address.setState("Midgard");
        address.setZipcode("11111");
        user.setAddress(address);
        return user;
    }
}
