package com.zaki.nashronTest;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;

public class NashornTest {

    @Test
    public void test1() throws Exception{
        ScriptEngine engine=new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(new FileReader("script/script.js"));

        Invocable invocable = (Invocable) engine;
        Object result = invocable.invokeFunction("fun1", "Perter Parker");
        System.out.println(result);

        invocable.invokeFunction("fun2",LocalDateTime.now());
    }
}
