package booking.beans;

public class Rating {

    private int typeRate;
    private int totalTypeRate;

    public Rating() {
    }

    public Rating(int typeRate, int totalTypeRate) {
        this.typeRate = typeRate;
        this.totalTypeRate = totalTypeRate;
    }

    public int getTypeRate() {
        return typeRate;
    }

    public void setTypeRate(int typeRate) {
        this.typeRate = typeRate;
    }

    public int getTotalTypeRate() {
        return totalTypeRate;
    }

    public void setTotalTypeRate(int totalTypeRate) {
        this.totalTypeRate = totalTypeRate;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "typeRate=" + typeRate +
                ", totalTypeRate=" + totalTypeRate +
                '}';
    }
}
