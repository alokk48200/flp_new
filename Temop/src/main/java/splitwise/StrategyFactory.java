package splitwise;

public class StrategyFactory {
    public static SplitStrategy getSplitstrategy(String stategy){
        return switch (stategy){
            case "equal" -> new EqualSplitStrategy();
            case "exact"-> new ExactStaregy();
            default -> null;

        };
    }
}
