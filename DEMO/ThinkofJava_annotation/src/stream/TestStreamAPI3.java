package stream;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import functional.entity.Employee;
import org.junit.Test;
import testenum.Status;

import static java.util.stream.Collectors.groupingBy;

/**
 * 中止操作
 * https://fr.xvideos.com/video40296705/yuzuki_-_fille_asiatique_sexy_-_https_asiansister.com_
 */
public class TestStreamAPI3 {
    List<Employee> emps = Arrays.asList(

            new Employee(2, "haha1", 33, 300000.3, Employee.Status.BUSY),
            new Employee(3, "aha", 55, 111113.3,Employee.Status.BUSY),
            new Employee(1, "haha", 3, 30000.3,Employee.Status.VOCATION),
            new Employee(1, "haha", 3, 30000.3,Employee.Status.BUSY),
            new Employee(10, "haha", 3, 30300.3,Employee.Status.BUSY),
            new Employee(10, "haha", 3, 30300.3,Employee.Status.FREE),
            new Employee(10, "haha", 3, 30300.3,Employee.Status.FREE),
            new Employee(10, "haha", 3, 30300.3,Employee.Status.FREE),
            new Employee(10, "haha", 3, 30300.3,Employee.Status.FREE),
            new Employee(4, "hahad", 11, 3.3,Employee.Status.FREE)

    );

    @Test
    public void test1(){
//        boolean b = emps.stream().allMatch((e)->e.getStatus().equals(Employee.Status.BUSY));
//        System.out.println(b);
//
//        boolean b1 = emps.stream().anyMatch((e)->e.getStatus().equals(Employee.Status.BUSY));
//        System.out.println(b1);
//
//        boolean b2 = emps.stream().noneMatch((e)->e.getStatus().equals(Employee.Status.FREE));
//        System.out.println(b2);

        Optional <Employee> op = emps.stream()
                .sorted((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary())).findFirst();
        System.out.println(op.get());

        Optional<Employee> op1 = emps.parallelStream()
                .filter((e)->e.getStatus().equals(Employee.Status.FREE))
                .findAny();

        System.out.println(op1.get());
    }

    @Test
    public void test2(){
        Long count = emps.stream().count();
        System.out.println(count);

        Optional<Employee> op = emps.stream()
                .max((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary()));

        System.out.println(op.get());

        Optional<Double>op2 = emps.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(op2.get());


    }

    //归约
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Integer sum = list.stream()
                .reduce(0,(x,y)->x+y);
        System.out.println(sum);

        System.out.println("-------------工资计算");

        Optional<Double> optionalDouble = emps.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(optionalDouble.get());

    }

    //搜集
    @Test
    public void test4(){
        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet()); //collector

        set.forEach(System.out::println);
        System.out.println("-----------------------------------万一我需要收集一些特殊的值,一些其他集合");

        HashSet<String> hashSet = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(hashSet);
    }

    //
    @Test
    public void test5(){
        Long count = emps.stream()
                .collect(Collectors.counting());
        System.out.println(count);
        System.out.println("----------平均值");
        double d = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(d);

        emps.stream().collect(Collectors.maxBy((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary())));

        Map<Employee.Status,List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));

        System.out.println(map);
    }

    @Test
    public void test7(){
        Map<Employee.Status, Map<String, List<Employee>>> collect = emps.stream()
                .collect(groupingBy(Employee::getStatus,
                        groupingBy(e ->
                        {
                            if (e.getAge() <= 35) {
                                return "青年";
                            } else {
                                final String 不是青年 = "不是青年";
                                return 不是青年;
                            }
                        })));
    }

    @Test
    public void test8(){
        System.out.println("----------------tet8");
        Map<Boolean,List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy((e)->e.getSalary() >8000));

        System.out.println(map);

    }

    @Test
    public void test9(){
        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(dss.getMax());
        System.out.println(dss.getAverage());
        System.out.println(dss.getCount());

    }

    @Test
    public void test10(){
        String fuseStr = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));

        System.out.println(fuseStr);
    }


}
