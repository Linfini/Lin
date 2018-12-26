package com.zaki.streamTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParallelStreamCompareTest {
    private static List<Integer> buildIntRange() {
        List<Integer> numbers = new ArrayList<>(5);
        for (int i = 0; i < 10000; i++)
            numbers.add(i);
        return Collections.unmodifiableList(numbers);
    }
    @Test
    public void ForLoopTest(){
        List<Integer> source = buildIntRange();
        long start = System.currentTimeMillis();
        for (int i = 0; i < source.size(); i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("传统方式 : " + (System.currentTimeMillis() - start) + "ms");
    }

    @Test
    public void ForEachTest(){
        List<Integer> source = buildIntRange();
        long start = System.currentTimeMillis();
        source.forEach(e->{
            try {
                Thread.sleep(1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println("foreach : " + (System.currentTimeMillis() - start) + "ms");
    }

    @Test
    public void StreamTest(){
        List<Integer> source = buildIntRange();
        long start = System.currentTimeMillis();
        source.stream().forEach(e->{
            try {
                Thread.sleep(1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println("stream : " + (System.currentTimeMillis() - start) + "ms");
    }

    @Test
    public void ParallelStream(){
        List<Integer> source = buildIntRange();
        long start = System.currentTimeMillis();
        source.parallelStream().forEach(e->{
            try {
                Thread.sleep(1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println("parallelStream : " + (System.currentTimeMillis() - start) + "ms");
    }
}
