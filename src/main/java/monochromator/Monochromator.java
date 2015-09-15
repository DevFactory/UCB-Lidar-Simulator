package monochromator;

/**
 * Created by Oscar on 9/14/15.
 */
public class Monochromator {
    private int overlapFactor;

    public Monochromator() {
        this.overlapFactor = 1;
    }

    public Monochromator(int overlapFactor) {
        this.overlapFactor = overlapFactor;
    }

    public int getOverlapFactor() {
        return overlapFactor;
    }

    public void setOverlapFactor(int overlapFactor) {
        this.overlapFactor = overlapFactor;
    }
}
