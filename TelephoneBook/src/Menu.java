import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    boolean flag = true;
    Authorize authorize = new Authorize();
    YellowPage yp = new YellowPage();
    public Menu(){}

    public void showMenu() {
        while(flag) {
            System.out.println("======================================================================");
            System.out.println("1. Create - att lägga till nya profiler i telefonboken");
            System.out.println("2. Read - söka efter profiler i telefonboken givet olika sökningar");
            if (authorize.isAdmin()) {
                System.out.println("3. Update - uppdatera en profils kontaktuppgifter");
                System.out.println("4. Delete - ta bort en profil");
            } else { System.out.println("3. Login"); }
            System.out.println("======================================================================");
            System.out.println();
            System.out.print("Enter task: ");
            String choice = sc.nextLine();
            task(choice);
        }
    }

    public void task(String choice) {
        if (choice.equalsIgnoreCase("quit")) {
            flag = false;
        } else if(choice.equals("1")) {
            System.out.println("==============");
            System.out.println("Create contact");
            System.out.println("==============");
            yp.addContact(yp);
        } else if(choice.equals("2")) {
            System.out.println("==============");
            System.out.print("Enter keyword: ");
            String keyword = sc.nextLine();
            System.out.println("==============");
            yp.findContact(yp, keyword);
        } else if(choice.equals("3")) {
            if(authorize.isAdmin()) {
                System.out.println("==============");
                System.out.println("Update contact");
                System.out.println("==============");
                yp.editContact(yp);
            } else {
                authorize.login();
            }
        } else if(choice.equals("4")) {
            if(authorize.isAdmin()) {
                System.out.println("==============");
                System.out.println("Remove contact");
                System.out.println("==============");
                yp.removeContact(yp);
            } else {
                System.err.println("No such task exist");
            }
        } else {
            System.err.println("No such task exist");
        }
    }
}