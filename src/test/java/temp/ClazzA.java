package temp;

public class ClazzA {

    private String a = getA();
    private String b;

    public ClazzA() {
        System.out.println("b:" + System.currentTimeMillis());
        b = "233";
    }

    String getA() {
        System.out.println("a:" + System.currentTimeMillis());
        return "111";
    }

    @Override
    public String toString() {
        return "ClazzA{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ClazzA clazzA = new ClazzA();
        System.out.println(clazzA.toString());
    }
}
