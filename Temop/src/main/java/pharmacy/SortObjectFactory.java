package pharmacy;

public class SortObjectFactory {
    public static SortStrategy getObject(Sort sortBy){
        return switch (sortBy){
            case Sort.RATING->new RatingSortStrategy();
            case Sort.TIME-> new TimimgbasedStrategy();
            default -> null;
        };
    }
}
