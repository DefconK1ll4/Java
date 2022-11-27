public class Technician extends User {
    public Technician(String userName, String pwd) {
        super(userName, pwd);
        setTypeOfAcc("Technician");
    }
}
