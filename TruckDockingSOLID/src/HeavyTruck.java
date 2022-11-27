public class HeavyTruck extends Truck {
    private int weight;
    private String name;

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public HeavyTruck(int weight) {
        this.weight = weight;
        this.name = "HeavyTruck";
    }
}
