package splitwise;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    String id;
    String name;
    ConcurrentHashMap<User, Double>moneyTransaction;
    double amount;

    public User(String name, double amount) {
        this.name = name;
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
        this.moneyTransaction = new ConcurrentHashMap<>();

    }
    public void doTransaction(User user, double amount){
        double val = moneyTransaction.getOrDefault(user, (double)0);
        moneyTransaction.put(user, val-amount);
    }
    public void print(){
        moneyTransaction.keySet().stream().forEach(
                (x)-> System.out.println(this.name +" has  amoutnt " + moneyTransaction.get(this) + " with user "+ x.name)
        );
    }

    public void notified(String message){
        System.out.println("this user notified" + message);
        return;
    }
}
