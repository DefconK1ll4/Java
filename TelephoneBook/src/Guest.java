public class Guest extends User {

    public Guest(String userName, String pwd) {
        super(userName, pwd);
        setTypeOfAcc("Guest");
    }
}
