package thinkinjava.polymorphic.demo2;

public class Wind2 extends Instrument2 {
    @Override
    public void play(Note2 n) {
        System.out.println("Wind2.play()");
    }
}
