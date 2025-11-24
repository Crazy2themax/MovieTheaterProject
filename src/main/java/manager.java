public class manager extends User{
    private String managerName;

    @Override
    public String getRole() {
        return "Manager";
    }
}
