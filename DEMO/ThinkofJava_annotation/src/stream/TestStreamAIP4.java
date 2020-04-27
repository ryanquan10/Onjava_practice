package stream;


import functional.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

/**
 * https://www.bilibili.com/video/av62117143?p=13
 */
public class TestStreamAIP4 {

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
    public void test(){
        Integer[] nums = new Integer[]{1,2,3,4,5};

        Arrays.stream(nums)
                .map((x)->x*x)
                .forEach(System.out::println);

    }
    /**
     * map 和 reduce 方法数一数刘忠友多少个Employee
     */
    @Test
    public void test1(){
        Optional<Integer> optional =  emps.stream().map(e->1).reduce(Integer::sum);
        System.out.println(optional.get());
    }
}
