package thinkinjava.polymorphic.demo2;

public class Music2 {
    public static void tune2(Wind2 i) {
        i.play(Note2.middleC);
    }

    public static void tune2(Stringed2 i) {
        i.play(Note2.middleC);
    }

    public static void tune2(Brass2 i) {
        i.play(Note2.middleC);
    }


    public static void main(String[] args) {
        Wind2 flute = new Wind2();
        Stringed2 violin = new Stringed2();
        Brass2 frenchHorn = new Brass2();

        tune2(flute);
        tune2(violin);
        tune2(frenchHorn);
    }
}
