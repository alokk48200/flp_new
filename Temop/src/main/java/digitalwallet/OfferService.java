package digitalwallet;

import java.util.List;
import java.util.PriorityQueue;

public class OfferService {
     private static OfferService instance = null;
     private OfferService(){

     }
     public static OfferService getInstance(){
         if(instance == null){
             synchronized (OfferService.class){
                 if(instance == null){
                     instance =new OfferService();
                 }
             }
         }
         return instance;
     }

     public void equalAmountOfferCheck(User user1, User user2){
         if(user1.getBalance().equals(user2.getBalance())){
             System.out.println("both the users " +user1.getName() + " and " + user2.getName() + "amount applied");
             user1.creditMoeny(10.00);
             user2.creditMoeny(10.00);
             Log log1 = new Log(null, user1,10.00, TransactionEnum.OFFERCREDITED);
             Log log2 = new Log(null, user2, 10.00, TransactionEnum.OFFERCREDITED);
             user1.addTransactions(log1);
             user2.addTransactions(log2);

         }
     }
     public void offer2Strategy(List<User>users){
         PriorityQueue<User>priorityQueue = new PriorityQueue<>((user1, user2)->{
             if(user1.getAllTransactions() != user2.getAllTransactions()){
                 return user2.getAllTransactions() - user1.getAllTransactions();
             }else if(!user1.getBalance().equals(user2.getBalance())){
                 return Double.compare(user2.getBalance(),  user1.getBalance());
             }
             return user2.getCreatedAt().compareTo(user1.getCreatedAt());
         });
         for(User user : users){
             priorityQueue.add(user);
         }
         User user1 = null;
         User user2 = null;
         User user3 = null;
         if(priorityQueue.size() > 0 )user1 = priorityQueue.poll();
         if(priorityQueue.size() > 0 )user2 = priorityQueue.poll();
         if(priorityQueue.size() > 0 )user3 = priorityQueue.poll();
         if(user1 != null){
             user1.creditMoeny(10.00);
             Log log1 = new Log(null, user1,10.00, TransactionEnum.OFFERCREDITED);
             user1.addTransactions(log1);
             System.out.println(" the users " +user1.getName() + " offer2 applied get amount "+ "10. 00 ");

         }
         if(user2 != null){
             user2.creditMoeny(10.00);
             Log log2 = new Log(null, user2,10.00, TransactionEnum.OFFERCREDITED);
             user2.addTransactions(log2);
             System.out.println(" the users " +user2.getName() + " offer2 applied get amount "+ "5. 00 ");
         }

          if(user3 != null){
             user3.creditMoeny(10.00);
             Log log3 = new Log(null, user3,10.00, TransactionEnum.OFFERCREDITED);
             user3.addTransactions(log3);
              System.out.println(" the users " +user3.getName() + " offer2 applied get amount "+ "2. 00 ");
         }

     }

     public void checkFixedDepositOffer(User user){
         if(user.getAllTransactions() - user.getFixedAmounttransactionLength() >= 5){
             user.creditMoeny(10.00);
             Log log3 = new Log(null, user,10.00, TransactionEnum.OFFERCREDITED);
             user.addTransactions(log3);
             System.out.println(" the users " +user.getName() + " offer2 applied get amount "+ "2. 00 ");
         }
     }


}
