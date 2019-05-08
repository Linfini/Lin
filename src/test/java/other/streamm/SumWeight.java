package other.streamm;

public class SumWeight {
    private String name;
    private Integer currnetMonthWeight;
    private Integer lastMonthWeight;
    private Integer twoMonthAgoWeight;
    private Integer totalWeight;


    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrnetMonthWeight() {
        return currnetMonthWeight;
    }

    public void setCurrnetMonthWeight(Integer currnetMonthWeight) {
        this.currnetMonthWeight = currnetMonthWeight;
    }

    public Integer getLastMonthWeight() {
        return lastMonthWeight;
    }

    public void setLastMonthWeight(Integer lastMonthWeight) {
        this.lastMonthWeight = lastMonthWeight;
    }

    public Integer getTwoMonthAgoWeight() {
        return twoMonthAgoWeight;
    }

    public void setTwoMonthAgoWeight(Integer twoMonthAgoWeight) {
        this.twoMonthAgoWeight = twoMonthAgoWeight;
    }

    @Override
    public String toString() {
        return "SumWeight{" +
                "name='" + name + '\'' +
                ", currnetMonthWeight=" + currnetMonthWeight +
                ", lastMonthWeight=" + lastMonthWeight +
                ", twoMonthAgoWeight=" + twoMonthAgoWeight +
                ", totalWeight=" + totalWeight +
                '}';
    }
}
