package typeinfo;

class Building{}
class House extends Building{}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> c = House.class;
        House h = c.cast(b);
    }
}
