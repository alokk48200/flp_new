package splitwise;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        User user1 =new User("Alok", (double) 0);
        User user2 =new User("ROhit", (double) 0);
        User user3 =new User("ramesh", (double) 0);
        User user4 =new User("rakul", (double) 0);


        Group group = new Group(new ArrayList<>(List.of(user1, user2, user3, user4)), "Flat");
        try{
            group.addUser(user1);
        }catch (Exception e){
            e.printStackTrace();
        }
        Transaction transaction1 = new Transaction(user1, 100.00, new ArrayList<>(List.of( user2, user3, user4)), new ArrayList<>(List.of((double)10, (double)20,30.00,40.00)));
        Transaction transaction2 = new Transaction.Builder().setName("new transaction").setPayee(user2).setAmount(500.00)
                .setParticipants( new ArrayList<>(List.of( user1, user3, user4)))
                .setQuanity(new ArrayList<>(List.of(10.00, 20.00,30.00,40.00)))
                .build();

        group.split(new EqualSplitStrategy(),  new ArrayList<>(List.of( user2, user3, user4)), new ArrayList<>(), (double) 100, user1);

       Application application =  Application.getInstance();
        group.people.stream().forEach((x) -> x.print());
    }
}
