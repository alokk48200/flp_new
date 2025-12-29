package digitalwallet;

import java.util.Optional;
import java.util.UUID;

public class Wallet {
    private String id;
    private User owner;
    private Double amount;
    private Object lock = new Object();

    public Wallet(User owner, Double amount) {
        this.owner = owner;
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
    }

    public  void addAmount(Double amount){
        synchronized (lock) {
            this.amount += amount;
        }
    }

    public  void removeAmount(Double amount){
        synchronized (lock) {
            if(this.amount < amount ){
                throw new RuntimeException("amount is very less in account");
            }
            this.amount -= amount;
        }
    }

    public Double getAmount() {
        return amount;
    }


}
