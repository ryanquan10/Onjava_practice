package functional;

public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs nma = Dog::new;
        Make1Arg m1a = Dog::new;
        Make2Args m2a = Dog::new;

        Dog dn=nma.make();
        Dog d1=m1a.make("2b");
        System.out.println(d1.name);
        Dog d2=m2a.make("haha",1);
        System.out.println(d1.name+" "+d2.age);
    }


}

class Dog {
    String name;
    int age = -1; // For "unknown"
    Dog() { name = "stray"; }
    Dog(String nm) { name = nm; }
    Dog(String nm, int yrs) { name = nm; age = yrs; }
}
@FunctionalInterface
interface MakeNoArgs{
    Dog make();
}

@FunctionalInterface
interface Make1Arg{
    Dog make(String nm);
}
@FunctionalInterface
interface Make2Args{
    Dog make(String nm,int age);
}