package other.gammar.serializable;


import org.junit.Test;

import java.io.*;

public class SeriblizableTest implements Serializable {

    final Person person = new Person("张三", 12);
    String path = "d:/person.dat";

    @Test
    public void test1() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
        out.writeObject(person);
        out.close();
    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        Person person = (Person) in.readObject();
        in.close();
    }
}
