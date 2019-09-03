package other.designpattern.create.factorymethod;

public class Factory implements IFactory {
    public IProduct createProduct() {
        return new Product1();
    }
}
