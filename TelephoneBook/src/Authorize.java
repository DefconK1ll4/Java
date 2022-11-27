import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authorize {
    Scanner sc = new Scanner(System.in);
    private List<User> users = new ArrayList<>();
    private String username = "admin";
    private String pwd = "admin";
    private boolean admin;

    public boolean isAdmin() {
        return this.admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public void login() {
        System.out.print("Enter username: ");
        boolean user = getUsername().equals(sc.nextLine());
        System.out.println("\nEnter password: ");
        boolean pwd = getPwd().equals(sc.nextLine());

        if(user && pwd) {
            setAdmin(true);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users.add(users);
    }
}
