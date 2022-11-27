import java.time.LocalDate;

public interface UserDTOBuilder {

    UserDTOBuilder withFirstName(String fname);

    UserDTOBuilder withLastName(String lname);

    UserDTOBuilder withBirthday(LocalDate date);

    UserDTOBuilder withAddress(Address address);

    //method to assemble final product
    UserDTO build();

    //optional method to fetch already build object
    UserDTO getUserDTO();
}