import java.util.List;
import java.util.Scanner;

public class OutputInput {

    public void listMenu() {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        DumpaMera dumpaMera = new DumpaMera();

    while(flag)

    {
        firstMenuOptions();
        int choice = input.nextInt();

        if (choice == 1) {
            listParkedTrucks(dumpaMera.getDockedTrucks());


        } else if (choice == 2) {
            choiceOfTrucks();

            int choiceOfTruck = input.nextInt();

            if (choiceOfTruck == 1) { // Van
                System.out.println("Enter weight: ");
                int weight = input.nextInt();
                Truck van = new Van(weight);
                dumpaMera.registerNewTruck(van); // Sending truck object to validation
                System.out.println("Lastbil registrerad för kaj: " + van.getDockingPlace());
                System.out.println();

            } else if (choiceOfTruck == 2) { // SmallTruck
                System.out.println("Enter weight: ");
                int weight = input.nextInt();
                Truck smallTruck = new SmallTruck(weight);
                dumpaMera.registerNewTruck(smallTruck); // Sending truck object to validation
                System.out.println("Lastbil registrerad för kaj: " + smallTruck.getDockingPlace());
                System.out.println();


            } else if (choiceOfTruck == 3) { // HeavyTruck
                System.out.println("Enter weight: ");
                int weight = input.nextInt();
                Truck heavyTruck = new HeavyTruck(weight);
                dumpaMera.registerNewTruck(heavyTruck); // Sending truck object to validation
                System.out.println("Lastbil registrerad för kaj: " + heavyTruck.getDockingPlace());
                System.out.println();

            } else {
                System.out.println("Invalid Choice");
            }
        } else if (choice == 3) { // Terminate menu
            flag = false;
        }
    }
}
public void firstMenuOptions() {
    System.out.println("– Avlastningsstationen dumpa mera –");
    System.out.println("1. Se parkerade lastbilar");
    System.out.println("2. Registrera ny avlastande lastbil");
    System.out.println("3. Avsluta");
}
public void choiceOfTrucks() {
    System.out.println("Typ av lastbil: ");
    System.out.println("1. Skåpbil");
    System.out.println("2. Lätt lastbil");
    System.out.println("3. Tung lastbil");
}

    // Trucks objet comes from validation
    public void listParkedTrucks(List<Truck> trucks) {
        // Loops thro all the objects sent from validation
        for (Truck t : trucks) {
            System.out.println(t.getDockingPlace() + " - " + t.getName() + " [" + t.getWeight() + "kg]");
        }
    }
}
