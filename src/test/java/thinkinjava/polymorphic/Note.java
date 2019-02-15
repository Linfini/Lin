package thinkinjava.polymorphic;

public class Note {
    private int value;

    private Note(int val) {
        value = val;
    }

    public static final Note
            middleC = new Note(0),
            cSharp = new Note(1),
            cFlat = new Note(2);

}
