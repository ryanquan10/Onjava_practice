package functional;



import org.junit.Test;

import java.util.*;

class Employee{
    int id;
    String name;
    int age;
    double salary;

    public Employee(String 张三, int i, double v, functional.entity.Employee.Status free) {
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {

    }
//    @Override
//    public String toString(){
//        return name;
//    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}



public class Question1 {
    List<Employee> emps = Arrays.asList(
            new Employee(1, "haha", 3, 3.3),
            new Employee(2, "haha1", 2, 3.3),
            new Employee(3, "aha", 55, 3.3),
            new Employee(4, "hahad", 11, 3.3)
            );
     @Test
    public void test6(){
        Collections.sort(emps,(e1,e2)->{
            if(e1.age==e2.age){
                return e1.name.compareTo(e2.name);
            }else{
                return Integer.compare(e1.age,e2.age);
            }
        });

        for(Employee emp:emps){
            System.out.println(emp);

        }
    }

    //用于处理字符串的方法
    public String test7(String str,MyFunction mf){
    return mf.getValue(str);
    }

    @Test
    public void test8(){
       String str =  test7(" haha ",(x)->x.trim());
        System.out.println(str);
    }

    public void test9(long l1,long l2,MyFunction2 my){
        my.plus(l1,l2);
    }
    @Test
    public void test10(){
//         test9(11,22,(a,b)->{
//             System.out.println(a+b);
//             System.out.println(a*b);
//         });


        test9(11,22,(a,b) -> a + b );
//        test9(11,22l,(a,b) -> a * b ); //关乎返回值 public long plus(long p1,long p2);
    }


}
