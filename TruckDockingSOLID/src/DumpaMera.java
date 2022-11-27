import java.util.ArrayList;
import java.util.List;

public class DumpaMera {
    Truck truck;
    public DumpaMera(){}
    private List<Truck> dockedTrucks = new ArrayList<>();
    private List<Character> booleanChars = new ArrayList<>(); // Characters from Lastkajer

    public List<Truck> getDockedTrucks() {
        return dockedTrucks;
    }

    public void setDockedTrucks(Truck trucks) {
        this.dockedTrucks.add(trucks);

    }
    public void registerNewTruck(Truck trucks) {
        if (trucks instanceof Van) {
            if(booleanChars.contains('A') && booleanChars.contains('B')) {
                System.out.println("Tyvärr är det fullt, hänvisa förare till stationen dumpa mest!");
            } else if(!booleanChars.contains('A')) {
                trucks.setDockingPlace('A');
                booleanChars.add('A');
                setDockedTrucks(trucks);
            } else if(!booleanChars.contains('B')) {
                trucks.setDockingPlace('B');
                booleanChars.add(('B'));
                setDockedTrucks(trucks);
            }

        } else if (trucks instanceof SmallTruck) {
            if(booleanChars.contains('C') && booleanChars.contains('D') && booleanChars.contains('A')) {
                System.out.println("Tyvärr är det fullt, hänvisa förare till stationen dumpa mest!");
            } else if(!booleanChars.contains('A') && (trucks.getWeight() < 5000)) {
                trucks.setDockingPlace('A');
                booleanChars.add('A');
                setDockedTrucks(trucks);
            }else if(!booleanChars.contains('C')) {
                trucks.setDockingPlace('C');
                booleanChars.add('C');
                setDockedTrucks(trucks);
            } else if(!booleanChars.contains('D')) {
                trucks.setDockingPlace('D');
                booleanChars.add('D');
                setDockedTrucks(trucks);
            }

        } else if (trucks instanceof HeavyTruck) {
            if(booleanChars.contains('C') && booleanChars.contains('E')) {
                System.out.println("Tyvärr är det fullt, hänvisa förare till stationen dumpa mest!");
            }else if(!booleanChars.contains('C') && trucks.getWeight() < 9000) {
                trucks.setDockingPlace('C');
                booleanChars.add('C');
                setDockedTrucks(trucks);
            }else if(!booleanChars.contains('E')) {
                trucks.setDockingPlace('E');
                booleanChars.add('E');
                setDockedTrucks(trucks);
            }
        }
    }
}
