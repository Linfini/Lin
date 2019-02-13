package other.proxytest;

public class HelloWorldProxy {
    private HelloWorld helloWorld;

    public HelloWorldProxy() {
    }

    public HelloWorldProxy(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void sayHello() {
        System.out.println("proxy begin...");
        System.out.println("hello java");
        System.out.println("proxy end...");
    }
}
