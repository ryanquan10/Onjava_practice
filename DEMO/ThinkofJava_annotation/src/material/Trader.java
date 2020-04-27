package material;

public class Trader{
    String firstName;
    String city;

    public Trader() {
    }

    public Trader(String firstName, String city) {
        this.firstName = firstName;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}