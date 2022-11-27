import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String pwd;
    private String typeOfAcc;
    Menu menu = new Menu();

    public User(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    public void printList() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTypeOfAcc() {
        return typeOfAcc;
    }

    public void setTypeOfAcc(String typeOfAcc) {
        this.typeOfAcc = typeOfAcc;
    }
}
