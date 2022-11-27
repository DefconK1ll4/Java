import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private String areaCode;
    private String city;
    private PhoneNumber phoneNumber;

    public Person(){}

    public Person(String firstName, String lastName, String age,String address, String areaCode, String city, PhoneNumber phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.areaCode = areaCode;
        this.city = city;
        this.phoneNumber = phoneNumber;;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String  areaCode) {
        this.areaCode = areaCode;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public PhoneNumber setNum() {
        return phoneNumber;
    }
    @Override
    public String toString() {
        return "Firstname: " + getFirstName() +
                " Lastname: " + getLastName() +
                " Age: " + getAge() +
                " Address: " + getAddress() +
                " Area code: " + getAreaCode() +
                " City: " + getCity() +
                phoneNumber.toString();
    }
}
