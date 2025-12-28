package digitalwallet;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class User {
    private String id;
    private String name;
    private Wallet wallet;
    private LocalDateTime createdAt;
    private Double fixedDeposit;
    private CopyOnWriteArrayList<Log> transactions;
    private Integer fixedAmounttransactionLength;

    public User(Double fixedDeposit, String name) {
        this.fixedDeposit = fixedDeposit;
        this.name = name;
        this.transactions = new CopyOnWriteArrayList<>();
        this.createdAt = LocalDateTime.now();
    }
    public void addWallet(Wallet wallet){

        this.wallet = wallet;

    }
    public void debitMoney(Double amount){
        try {
            wallet.removeAmount(amount);
            if(wallet.getAmount() < fixedDeposit){
                fixedAmounttransactionLength = Integer.MAX_VALUE;
                fixedDeposit = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void creditMoeny(Double amount){
          wallet.addAmount(amount);
    }
    public Integer getAllTransactions(){
        return transactions.size();
    }

    public void addTransactions(Log log){
        transactions.add(log);
    }

    public List<Log> getTransactions() {
        return transactions.stream().toList();
    }
    public Double getBalance(){
        return wallet.getAmount();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFixedDeposit() {
        return fixedDeposit;
    }

    public void setFixedDeposit(Double fixedDeposit) {
        if(wallet.getAmount() < fixedDeposit){
            System.out.println(" this amount is not able to fixed deo=posit because suffiecient money is not in wallet");
            return;
        }
        fixedAmounttransactionLength = transactions.size();
        this.fixedDeposit = fixedDeposit;
    }

    public void setTransactions(CopyOnWriteArrayList<Log> transactions) {
        this.transactions = transactions;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getFixedAmounttransactionLength() {
        return fixedAmounttransactionLength;
    }

    public void setFixedAmounttransactionLength(Integer fixedAmounttransactionLength) {
        this.fixedAmounttransactionLength = fixedAmounttransactionLength;
    }
}
