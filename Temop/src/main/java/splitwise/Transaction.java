package splitwise;

import java.util.ArrayList;

public class Transaction {
    private String id;
    private String name;
    private User payee;
    private Double amount;
    private ArrayList<User>users;
    private ArrayList<Double>quanity;

    public Transaction(User payee, Double amount, ArrayList<User> users, ArrayList<Double> quanity) {
        this.payee = payee;
        this.amount = amount;
        this.users = users;
        this.quanity = quanity;
    }

    public Transaction(Builder builder) {
        this.payee = builder.payee;
        this.amount = builder.amount;
        this.users = builder.users;
        this.quanity = builder.quanity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getPayee() {
        return payee;
    }

    public void setPayee(User payee) {
        this.payee = payee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Double> getQuanity() {
        return quanity;
    }

    public void setQuanity(ArrayList<Double> quanity) {
        this.quanity = quanity;
    }
    static class Builder {
        private String name;
        private User payee;
        private Double amount;
        private ArrayList<User>users;
        private ArrayList<Double>quanity;

        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setPayee(User user){
            this.payee = user;
            return this;
        }
        public Builder setAmount(Double amount){
            this.amount = amount;
            return this;
        }
        public Builder setParticipants(ArrayList<User> users){
            this.users = users;
            return this;
        }
        public Builder setQuanity(ArrayList<Double>quanity ){
            this.quanity = quanity;
            return this;
        }
        public Transaction build(){
            return new Transaction(this);
        }
    }
}
