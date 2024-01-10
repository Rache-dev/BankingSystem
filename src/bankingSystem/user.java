package bankingSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Transaction{
    private Date date;
    private double amount;
    private String type;
    public Transaction(double amount, String type){
        this.amount = amount;
        this.date = new Date();
        this.type = type;
    }
    public String showInfo(){
        return date.toString() +" : "+type+" : "+amount;
    }
}

class user {
    private String firstName;
    private String lastName;
    private String password;
    private double balance= 0;
    private ArrayList<Transaction> transactions;

    public user(String firstName,String lastName,String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount){
        balance += amount;
        transactions.add(new Transaction(amount,"Deposit"));
    }
    public void withdraw(double amount){
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction(amount,"withdraw"));
        } else {
            System.out.println("You don't have enough money to withdraw "+amount);
        }

    }

    public ArrayList<Transaction> getTransaction(){
        return transactions;
    }
    public double getBalance(){
        return balance;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //registering a new user
        System.out.print("Enter your first name: ");
        String firstName = in.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = in.nextLine();

        System.out.print("Enter your password: ");
        String password = in.nextLine();

        user user1 = new user(firstName,lastName,password);

        //making transactions
        System.out.print("Enter the amount of money you wish to deposit: ");
        double depositAmount = in.nextDouble();
        user1.deposit(depositAmount);

        System.out.print("Enter the amount of money you wish to withdraw: ");
        double withdrawAmount = in.nextDouble();
        user1.withdraw(withdrawAmount);


        //displaying transaction history
        ArrayList<Transaction> transactions = user1.getTransaction();
        System.out.println("Your transaction history: ");
        for (Transaction transaction: transactions){
            System.out.println(transaction.showInfo());
        }

        System.out.println("Current Balance: "+ user1.getBalance());
    }

}
