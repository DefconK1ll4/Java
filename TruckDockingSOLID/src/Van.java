import java.util.List;

public class Van extends Truck {
    private int weight;
    private String name;

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Van(int weight) {
        this.weight = weight;
        this.name = "Van";
    }
}
