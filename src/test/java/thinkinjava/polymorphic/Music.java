package thinkinjava.polymorphic;

public class Music {
    public static void tune(Instrument i){
        i.play(Note.middleC);
    }
    public static void main(String[] args){
        Wind flute=new Wind();
        tune(flute);
    }
}
