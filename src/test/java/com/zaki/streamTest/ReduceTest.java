package com.zaki.streamTest;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

public class ReduceTest {


    @Test
    public void test1() {
        Optional<Integer> accResult = Stream.of(1, 2, 3, 4)
                .reduce((acc, item) -> {
                    System.out.println("acc : " + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : " + acc);
                    System.out.println("--------");
                    return acc;
                });
        System.out.println("accResult: " + accResult.get());
        System.out.println("--------");

    }

    @Test
    public void test2() {
        int accResult1 = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, item) -> {
                    System.out.println("acc : " + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : " + acc);
                    System.out.println("--------");
                    return acc;
                });
        System.out.println("accResult: " + accResult1);
    }

    @Test
    public void test3() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("张三", 1, 50));
        persons.add(new Person("张三", 2, 50));
        persons.add(new Person("张三", 4, 50));
        persons.add(new Person("张三", 5, 50));
        persons.add(new Person("李四", 1, 50));
        SumWeight sumWeight = new SumWeight();

        SumWeight reduce = persons.stream().filter(e -> "张三".equals(e.getName())).reduce(sumWeight, (sum, person) -> {
            sum.setName(person.getName());
            sum.setTotalWeight(Optional.ofNullable(sum.getTotalWeight()).orElse(0) + person.getWeight());
            if (1 == person.getMonth()) {
                sumWeight.setCurrnetMonthWeight(person.getWeight());
            }
            return sum;
        }, (sum1, sum2) -> {
            sum1.setTotalWeight(sum1.getTotalWeight() + sum2.getTotalWeight());
            return sum1;
        });
        System.out.println(reduce.toString());
    }

    @Test
    public void test4() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("张三", 1, 50));
        persons.add(new Person("张三", 2, 50));
        persons.add(new Person("张三", 4, 50));
        persons.add(new Person("张三", 5, 50));
        persons.add(new Person("李四", 1, 50));

        Map<String, SumWeight> nameAndWeightMap = new HashMap<>();
        Map<String, SumWeight> reduce=persons.stream().reduce(nameAndWeightMap, ReduceTest::apply, (result, temp)->{
            result.putAll(temp);
            return result;
        });
        System.out.println(reduce.toString());
    }

    private static Map<String, SumWeight> apply(Map<String, SumWeight> res, Person person) {
        if (res.containsKey(person.getName())) {
            SumWeight sum = res.get(person.getName());
            sum.setTotalWeight(Optional.ofNullable(sum.getTotalWeight()).orElse(0) + person.getWeight());
        }else {
            SumWeight sumWeight = new SumWeight();
            sumWeight.setTotalWeight(person.getWeight());
            sumWeight.setName(person.getName());
            res.put(person.getName(), sumWeight);
        }
        return res;
    }
}
