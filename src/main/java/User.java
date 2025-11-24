public abstract class User {
protected int Id;
protected String Name;
protected String Email;
protected String Password;

public User(int id, String name, String email, String password) {

}
public abstract String getRole();
}
