public class SmallTruck extends Truck {
    private int weight;
    private String name;
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }
    public SmallTruck(int weight) {
        this.weight = weight;
        this.name = "SmallTruck";
    }
    @Override
    public int getWeight() { return this.weight; }
}
