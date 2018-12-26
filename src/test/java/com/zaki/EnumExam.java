package com.zaki;

import com.zaki.enumexam.Operation;
import com.zaki.enumexam.User;
import org.junit.Test;

import java.util.Arrays;

public class EnumExam {

    @Test
    public void testEnumValues(){
        System.out.println(User.valueOf("账号"));
    }

    @Test
    public void operateTest(){
        Operation operation=Operation.PLUS;
        System.out.println(operation.apply(1d,2d));
    }
}
