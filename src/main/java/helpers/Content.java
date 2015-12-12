package helpers;

/**
 * Created by oscar_sgc on 11/24/15.
 */
public class Content {
    private double value;
    private int belongingRange;

    public Content(double value, int belongingRange) {
        this.value = value;
        this.belongingRange = belongingRange;
    }

    public Content() {
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getBelongingRange() {
        return belongingRange;
    }

    public void setBelongingRange(int belongingRange) {
        this.belongingRange = belongingRange;
    }
}
