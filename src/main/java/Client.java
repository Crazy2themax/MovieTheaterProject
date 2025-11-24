public class Client extends User{
    String clientName;

    @Override
    public String getRole() {
        return "Client";
    }
}
