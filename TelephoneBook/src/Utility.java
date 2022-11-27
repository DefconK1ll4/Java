import java.util.Scanner;

public class Utility {
    static Scanner sc = new Scanner(System.in);

    public Utility() {
    }

    public Person getInfo(YellowPage yellowPage) {
        System.out.print("Enter Firstname: ");
        String firstname = sc.nextLine();
        System.out.print("\nEnter Lastname: ");
        String lastname = sc.nextLine();
        if (isThere(yellowPage, firstname, lastname)) {
            System.out.print("Enter Firstname: ");
            firstname = sc.nextLine();
            System.out.print("\nEnter Lastname: ");
            lastname = sc.nextLine();
        }
        System.out.print("\nEnter Age: ");
        String age = sc.nextLine();
        System.out.print("\nEnter Address: ");
        String address = sc.nextLine();
        System.out.print("\nEnter Country code: ");
        String areaCode = sc.nextLine();
        System.out.print("\nEnter Country: ");
        String city = sc.nextLine();
        System.out.print("\nEnter Mobile: ");
        String mobile = sc.nextLine();
        System.out.print("\nEnter Home: ");
        String home = sc.nextLine();
        System.out.print("\nEnter work: ");
        String work = sc.nextLine();

        PhoneNumber phoneNumber = new PhoneNumber(mobile, home, work);
        return new Person(firstname, lastname, age, address, areaCode, city, phoneNumber);
    }
    public boolean isThere(YellowPage yellowPage, String firstname, String lastname) {
        if (isListAvailable(yellowPage)) {
                for (Person p : yellowPage.getContacts()) {
                    if (p.getFirstName().equalsIgnoreCase(firstname) && p.getLastName().equalsIgnoreCase(lastname)) {
                        System.out.println(p.getFirstName() + " " + p.getLastName() + " " + " already exists");
                        System.out.println("Would you like to try again? [y/n]");
                        String answer = sc.nextLine();
                        if (answer.equalsIgnoreCase("y")) {
                            return true;
                        }
                    }
                }
            }
        return false;
    }
    public boolean isListAvailable(YellowPage yp) { if(yp!=null&&yp.getContacts().size()>0) return true; else return false;}
}
