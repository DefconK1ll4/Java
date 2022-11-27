import java.util.*;

public class YellowPage {
    static Scanner sc = new Scanner(System.in);
    Utility utility = new Utility();
    private List<Person> contacts = new ArrayList<>();

    public List<Person> getContacts() {
        return contacts;
    }

    public void setContacts(Person contacts) {
        this.contacts.add(contacts);
    }

    public void editContact(YellowPage yp) {
        if(utility.isListAvailable(yp)) {
            System.out.println("Which contact do you wanna edit?");
            int indexOf;
            printList(yp);
            indexOf = sc.nextInt();
            Person l = getContacts().get(indexOf);
            sc.nextLine();
            System.out.println("Do you wanna change\n1. Firstname 2. Lastname 3. Age 4. Address or 5. Numbers");
            int editPart = sc.nextInt();
            sc.nextLine();
            System.out.println();
            if (editPart == 1) {
                System.out.print("Enter new name: ");
                l.setFirstName(sc.nextLine());
            } else if (editPart == 2) {
                System.out.println("Enter new lastname: ");
                l.setLastName(sc.nextLine());
            } else if (editPart == 3) {
                System.out.println("Enter new age: ");
                l.setAge(sc.nextLine());
            } else if (editPart == 4) {
                System.out.println("Enter new address: ");
                l.setAddress(sc.nextLine());
            } else if (editPart == 5) {
                System.out.println("Enter mobile : ");
                l.setNum().setMobileNumber(sc.nextLine());
                System.out.println("Enter home: ");
                l.setNum().setHomeNumber(sc.nextLine());
                System.out.println("Enter work: ");
                l.setNum().setWorkNumber(sc.nextLine());
            }
        } else {
            System.out.println();
            System.out.println("Something isn't working with the list..");
        }
    }
    public void printList(YellowPage yp) {
        if(utility.isListAvailable(yp)) {
            for (Person p : getContacts()) {
                System.out.println("ID: " + getContacts().indexOf(p) + " " + p.toString());
            }
        }
    }
    public void findContact(YellowPage yp, String name) {
        if(utility.isListAvailable(yp))
            for(Person p : getContacts()) {
                if(p.getFirstName().contains(name) ||
                        p.getLastName().contains(name) ||
                        p.getAddress().contains(name) ||
                        p.getAge().contains(name) ||
                        p.getCity().contains(name) ||
                        p.getAreaCode().contains(name) ||
                        p.setNum().getMobileNumber().contains(name) ||
                        p.setNum().getHomeNumber().contains(name) ||
                        p.setNum().getWorkNumber().contains(name)){
                    System.out.println("ID: " + getContacts().indexOf(p) + " " + p.toString());
                }
            }
    }
    public void addContact(YellowPage yp) {
        System.out.println("Enter förnamn,efternamn,ålder,adress, countrycode, country, telefonnummer");
        System.out.println("Exempel: John, Doe, 57, Exempelvägen 6, 18541, town, cell, home, work");
        Person person = utility.getInfo(yp);
        yp.setContacts(person);
        for(Person p : yp.getContacts()) {
            System.out.println("ID: " + yp.getContacts().indexOf(p) + " " + p.toString());
            System.out.println(yp.getContacts().size());
        }
    }
    public boolean removeContact(YellowPage yp) {
        System.out.print("Find the person: ");
        String name = sc.nextLine();
        findContact(yp, name);
        System.out.println();
        System.out.print("Enter the ID on the person you'd like to remove: ");
        int ID = sc.nextInt();
        sc.nextLine();
        for(Person p : getContacts()) {
            if(getContacts().indexOf(p) == ID) {
                System.out.println("Removing: " + p.getFirstName());
                getContacts().remove(p);
                return true;
            }
            System.out.println("Unable to remove: " + p.getFirstName());
        }
        return false;
    }
}
