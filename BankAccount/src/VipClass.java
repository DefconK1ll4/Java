public class VipClass {
    /*
    new class VipCustomer
name, credit limit, email address
1st constructor empty should call the constructor with 3 parameters with default values
2nd constructor should pass on the 2 values it recieves and add a default value for the 3rd
3rd constructor should save all fields
create getters only for this using code geneeration
     */
    private String name;
    private double creditLimit;
    private String emailAddress;

    public VipClass() {
        this("Default name", 100.0, "vipclass@vipclass.com");
    }
    public VipClass(String name, double creditLimit) {
        this(name, creditLimit, "unknown");

    }
    public VipClass(String name, double creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return this.name;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }
}
