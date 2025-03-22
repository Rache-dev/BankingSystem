package bankingSystem;

import java.time.LocalDateTime;

public class Transaction {
    private String action;
    private LocalDateTime timeStamp;
    private double amount;

    public Transaction(String action, double amount){
        this.action = action;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }

    @Override
    public String toString(){
        return "Your Transaction are "+action+ ":" +amount+": TIMESTAMP : " +timeStamp  ;
    }
}
