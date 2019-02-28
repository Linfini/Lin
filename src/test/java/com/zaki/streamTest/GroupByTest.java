package com.zaki.streamTest;

import org.junit.Rule;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;

public class GroupByTest {
    private ArrayList<Person> persons = new ArrayList<Person>() {{
        add(new Person("张三", 1, 50));
        add(new Person("张三", 2, 51));
        add(new Person("张三", 4, 52));
        add(new Person("张三", 5, 53));
        add(new Person("李四", 1, 49));
    }};


    /**
     * 分组求和
     */
    @Test
    public void test1() {
        HashMap<String, SumWeight> collect = persons.stream().collect(HashMap::new, (res, person) -> {
            if (res.containsKey(person.getName())) {
                SumWeight sum = res.get(person.getName());
                sum.setTotalWeight(Optional.ofNullable(sum.getTotalWeight()).orElse(0) + person.getWeight());
            } else {
                SumWeight sumWeight = new SumWeight();
                sumWeight.setTotalWeight(person.getWeight());
                sumWeight.setName(person.getName());
                res.put(person.getName(), sumWeight);
            }
        }, HashMap::putAll);

        System.out.println(collect);
    }

    @Test
    public void test2() {
        HashMap<String, SumWeight> groupMap = persons.stream().collect(Collectors.groupingBy(Person::getName, HashMap::new,
                Collectors.reducing(new SumWeight(), person -> {
                    SumWeight sumWeight = new SumWeight();
                    sumWeight.setName(person.getName());
                    sumWeight.setTotalWeight(person.getWeight());
                    return sumWeight;
                }, (res, sumWeight) -> {
                    res.setName(sumWeight.getName());
                    res.setTotalWeight(Optional.ofNullable(res.getTotalWeight()).orElse(0) + sumWeight.getTotalWeight());
                    return res;
                })));
        System.out.println(groupMap);
    }

    @Mock
    Student student;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

}
