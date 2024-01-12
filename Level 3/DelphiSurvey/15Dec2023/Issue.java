public class Issue {
    private int value;
    private String name;
    private double meanRank;

    public Issue(String name, int value, double meanRank) {
        this.name = name;
        this.value = value;
        this.meanRank = meanRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getMeanRank() {
        return meanRank;
    }

    public void setMeanRank(double meanRank) {
        this.meanRank = meanRank;
    }
}
