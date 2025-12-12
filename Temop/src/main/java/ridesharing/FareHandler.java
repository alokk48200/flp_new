package ridesharing;

public abstract class FareHandler {
    protected FareHandler next;
    public FareHandler setNext(FareHandler fareHandler){
        this.next = fareHandler;
        return next;
    }

    public abstract double apply(Ride ride, Double fare);
}
