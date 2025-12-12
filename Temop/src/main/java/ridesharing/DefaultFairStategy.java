package ridesharing;

public class DefaultFairStategy implements FairStartegy {
    private float price;

    public DefaultFairStategy(float price) {
        this.price = price;
    }

    @Override
    public float calculate(float distance) {
        return distance*price;
    }
}
