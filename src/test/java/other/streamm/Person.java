package other.streamm;

public class Person {
    private String name;
    private Integer month;
    private Integer weight;

    public Person() {
    }

    public Person(String name, Integer month, Integer weight) {
        this.name = name;
        this.month = month;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
