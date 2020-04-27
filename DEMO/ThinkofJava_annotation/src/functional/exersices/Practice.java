package functional.exersices;

import functional.entity.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {
    List<Employee> emps = Arrays.asList(
            new Employee(1, "haha", 3, 3.3,"haha", Employee.Status.BUSY),
            new Employee(2, "haha1", 2, 3.3,"haha", Employee.Status.BUSY),
            new Employee(3, "aha", 55, 3.3,"haha", Employee.Status.FREE),
            new Employee(4, "hahad", 11, 3.3,"haha", Employee.Status.FREE)
    );

    @Test
    public void test9() {
//emps  list        {name:name,age:age....}

        emps.stream().sorted((e1, e2) -> {
            //先按年龄排序再按名字牌
            if (e1.getAge() == e2.getAge()) {
                e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge() - e2.getAge();
            }
            return 0;
        }).forEach(System.out::println);
    }

    @Test
    public void test10() {
//emps  list        {name:name,age:age....}

//        Map<Double,Employee> map = emps.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
//                .collect(Collectors.mapping(Collectors.groupingBy(Employee::getSalary), emps.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))));
    }

    @Test
    public void test11(){
      emps.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));
    }

    @Test
    public void test12(){
        List<String> list = Arrays.asList("I", "love", "you", "too");
//        Collections.sort(list, new Comparator<String>(){// 接口名
//            @Override
//            public int compare(String s1, String s2){// 方法名
//                if(s1 == null)
//                    return -1;
//                if(s2 == null)
//                    return 1;
//                return s1.length()-s2.length();
//            }
//        });

    }

    @Test
    public void test13(){
        Map<String, List<String>> emp = emps.stream()
                .collect(Collectors.groupingBy(Employee::getDepartement,Collectors.mapping(Employee::getName, Collectors.toList())));
    }


















    @Test
    public void test14(){
        Map<String, List<String>> emp = emps.stream().collect(Collectors.groupingBy(Employee::getDepartement,Collectors.mapping(Employee::getName,Collectors.toList())));
    }

    @Test
    public void test15(){
        List<Person>  people = Arrays.asList(new Person(new City("a"),"aa"),new Person(new City("a"),"ab"));
        Map<City, Set<String>> lastNamesByCity =
                        people.stream()
                                .collect(Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getLastName, Collectors.toSet())));

        System.out.println(lastNamesByCity.keySet()+" "+lastNamesByCity.values());

       Map map = new HashMap();
       List list = new ArrayList();
       list.stream();


    }
    @Test
    public void test16(){
        Map<String,Double> map =emps.stream().collect(Collectors.groupingBy(Employee::getDepartement,Collectors.summingDouble(Employee::getSalary)));
    }

    @Test
    public void test17(){

    }





}
class Person{
    City city;
    String LastName;

    public Person() {
    }

    public Person(City city, String lastName) {
        this.city = city;
        LastName = lastName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}

class City{
    String name;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}