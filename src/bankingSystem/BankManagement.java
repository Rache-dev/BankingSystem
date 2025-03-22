package bankingSystem;

import java.util.Scanner;

public class BankManagement {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        while (true){
                System.out.println("1.Register user");
                System.out.println("2.Authenticate user");
                System.out.println("3.Update user details");

                System.out.println("4.Deposit money");
                System.out.println("5.Withdraw money");
                System.out.println("6.Transfer funds");
                System.out.println("7.View transaction history");
                System.out.println("8.Delete user");
                System.out.println("9.Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1:
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        userManager.registerUser(username,email,password);
                        break;
                    case 2:
                        System.out.print("Enter username: ");
                        String authUsername = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String authPassword = scanner.nextLine();
                        User authenticatedUser = userManager.authenticateUser(authUsername, authPassword);
                        if (authenticatedUser != null){
                            System.out.println("Welcome, "+ authenticatedUser);
                        }
                        break;
                    case 3:
                        System.out.print("Enter username to update: ");
                        String updateUsername = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String updatedEmail = scanner.nextLine();
                        System.out.print("Enter new password: ");
                        String updatedPassword = scanner.nextLine();
                        userManager.updateUser(updateUsername,updatedPassword,updatedEmail);
                        break;
                    case 4:
                        System.out.print("Enter username: ");
                        String depositToUser = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String depositPassword = scanner.nextLine();
                        User user = userManager.authenticateUser(depositToUser, depositPassword);
                        if (depositToUser != null ){
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = scanner.nextDouble();
                            user.getAccount().deposit(depositAmount);
                            user.getAccount().calculateInterest();
                        } else {
                            System.out.println("User not found");
                        }
                        break;
                    case 5:
                        System.out.print("Enter username: ");
                        String withdrawFromUser = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String withdrawPassword = scanner.nextLine();
                        User withdrawUser = userManager.authenticateUser(withdrawFromUser, withdrawPassword);
                        if (withdrawFromUser != null){
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = scanner.nextDouble();
                            withdrawUser.getAccount().deposit(withdrawAmount);
                            withdrawUser.getAccount().calculateInterest();
                        } else {
                            System.out.println("User not found");
                        }
                        break;
                    case 6:
                        System.out.print("Enter sender username: ");
                        String senderUsername = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String senderPassword = scanner.nextLine();
                        User sender = userManager.authenticateUser(senderUsername, senderPassword);

                        System.out.print("Enter receiver username: ");
                        String receiverUsername = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String receiverPassword = scanner.nextLine();
                        User receiver = userManager.authenticateUser(receiverUsername, receiverPassword);
                        if(sender != null && receiver != null){
                            System.out.print("Enter amount to transfer: ");
                            double transferAmount = scanner.nextDouble();
                            sender.getAccount().transfer(transferAmount, receiver.getAccount());
                            sender.getAccount().calculateInterest();
                        }else {
                            System.out.println("User not found");
                        }
                        break;
                    case 7:
                        System.out.print("Enter username: ");
                        String userHistory = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String historyPassword = scanner.nextLine();
                        User userHistoryTransactions = userManager.authenticateUser(userHistory, historyPassword);
                        System.out.println("Transaction History for " + userHistory + ":");
                        for(Transaction transaction : userHistoryTransactions.getAccount().getTransactionList()){
                            System.out.println(transaction);
                        }
                        break;
                    case 8:
                        System.out.print("Enter username to delete: ");
                        String getUser = scanner.nextLine();
                        userManager.deleteUser(getUser);
                        System.out.println( "User deleted successfully");
                    case 9:
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again");
                }
            }

    }
}
