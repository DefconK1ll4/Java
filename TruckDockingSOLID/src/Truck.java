import java.util.ArrayList;
import java.util.List;

public abstract class Truck {
    private int weight;
    private char dockingPlace;
    private String name;

    public Truck(){}


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getDockingPlace() {
        return dockingPlace;
    }

    public void setDockingPlace(char dockingPlace) {
        this.dockingPlace = dockingPlace;
    }
    public int getWeight() {
        return weight;
    }
}
