package other.gammar.serializable;


import org.junit.Test;

import java.io.*;

public class SeriblizableTest implements Serializable {

    String path = "d:/person.dat";

    @Test
    public void test1() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
        out.close();
    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Person person = (Person) in.readObject();
        in.close();
    }
}
