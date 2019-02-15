package thinkinjava.polymorphic;

public class Music {
    //tune调整
    public static void tune(Instrument i) {
        i.play(Note.middleC);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute);//这里发生的向上转型
    }
}
