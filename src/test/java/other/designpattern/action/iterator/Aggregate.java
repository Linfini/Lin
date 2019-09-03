package other.designpattern.action.iterator;

public interface Aggregate {
    void add(Object obj);
    void remove(Object obj);
    Iterator iterator();
}
