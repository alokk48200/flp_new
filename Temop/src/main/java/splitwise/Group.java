package splitwise;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Group {
    String id;
    String name;
    ArrayList<User> people;
    ArrayList<Transaction>transactions;
    HashMap<User, Double>transactionMap ;


    Group(ArrayList<User> people, String name) {
        this.people = people;
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public void addUser(User user) throws Exception{
        if(people.contains(user)){
            throw new RuntimeException("this user  is  already exist");
        }
        people.add(user);
        System.out.println(user.name + "is successfully added to the group " +this.name);
    }

    public void removeUser(User user){
        if(people.contains(user)){
            people.remove(user);
            System.out.println("this user is removed successfully");
            return;
        }
        System.out.println("this group did not contain user");
    }

    public void split(SplitStrategy splitStrategy, List<User> users, List<Double>quantity, double amount, User user){
         HashMap<User, Double>hashMap =   splitStrategy.split(users,quantity,amount);
         for(Map.Entry<User, Double>entry : hashMap.entrySet()){
             entry.getKey().doTransaction(user, entry.getValue());
         }
         for(Map.Entry<User, Double> entry : hashMap.entrySet()){
             System.out.println(entry.getKey().name + " the money neeed to pay " + entry.getValue() +  "to ther user "+user.name);
         }

    }

    public void getTransaction(){
        for(Transaction transaction : transactions){
            System.out.println(transaction.toString());
        }
    }



}
