package functional;



import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@FunctionalInterface
/**
 * https://www.zhihu.com/question/20125256
 */
public interface BlockOfCode {
    //aBlockOfCode = public void doSomeShit(String s){sout()}
   public void saySth(String string);
}

class test{
    List<Person> guiltyPersons = Arrays.asList(
            new Person("haha","xixi",25),
            new Person("haha","xixi",25),
            new Person("haha","xixi",25)
    );

    void test1(){
//        BlockOfCode bock = (s)-> System.out.println(s);
//        bock.saySth("I m bock");


    }


    //A
    public  void checkAndExecute(List<Person> personList,
                                       NameChecker nameChecker,
                                       Executor executor){
        for(Person p:personList){
            if(nameChecker.check(p)){
                executor.execute(p); //假装是执行功能
            }
        }
    }

    //B
    public  void checkAndExecute2(List<Person> personList,
                                        Predicate<Person> predicate,
                                        Consumer <Person> consumer){
        //forEach方法本例取代for
        personList.forEach(p->{if(predicate.test(p))
                                  consumer.accept(p);});
    };

    //C
    public  void checkAndExecute3(){
        guiltyPersons.stream().filter(p->p.getLastName().startsWith("Z")).
                forEach(p-> System.out.println(p.getFirstName()));
    }

    //D
    public void checkAndExecute4(){
        guiltyPersons.stream().filter(p->p.getLastName().startsWith("H")).
                forEach(System.out::print);
    }

    @Test
    void test2(){

        //跟进A地 的接口
        checkAndExecute(guiltyPersons,
                p->p.getLastName().startsWith("h"),
                p-> System.out.println(p.getFirstName()));
    }




}


class Person{
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}

@FunctionalInterface
interface NameChecker{
    boolean check(Person p);
}
//原生态的Lambda表达式....
@FunctionalInterface
interface Executor{
    void execute(Person p);
}