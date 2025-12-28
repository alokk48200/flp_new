package digitalwallet;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DigitalWallet {
    private CopyOnWriteArrayList<User>users;
    private ConcurrentHashMap<String , User>userName;
    private OfferService offerService;

    public DigitalWallet(OfferService offerService) {
        this.users = new CopyOnWriteArrayList<>();
        this.offerService = offerService;
        this.userName = new ConcurrentHashMap<>();
    }

    public void registerUser(String name){

    }

    public void doPayment(String  name1, String name2, Double amount){
        User user1  = userName.get(name1);
        User user2  = userName.get(name2);
        user1.debitMoney(amount);
        user2.creditMoeny(amount);
        offerService.equalAmountOfferCheck(user1, user2);
        offerService.checkFixedDepositOffer(user1);
        offerService.checkFixedDepositOffer(user2);

    }
    public void addWallet(String name, Double amount){
        if(userName.containsKey(name)){
            User user = new User((double)0, name);
        }
          User user = userName.get(name);
         Wallet wallet = new Wallet(user,amount);
         user.addWallet(wallet);
    }
    public void showTransactions(){
        for( Map.Entry<String, User> entry : userName.entrySet()){
            for(Log log : entry.getValue().getTransactions()){
                System.out.println(log.toString());
            }
        }
    }
}
