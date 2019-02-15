package thinkinjava.polymorphic.demo2;

public class Note2 {
    private int value;

    private Note2(int val) {
        value = val;
    }

    public static final Note2
            middleC = new Note2(0),
            cSharp = new Note2(1),
            cFlat = new Note2(2);
}
