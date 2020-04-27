import org.springframework.beans.factory.annotation.Autowired;

public class MakeDessert implements Make{
    private Dessert dessert;
    public MakeDessert(){}

    @Autowired
    public void setDessert(Dessert dessert){
        this.dessert = dessert;
    }
    public Dessert getDesssert(){return this.dessert;}
}
