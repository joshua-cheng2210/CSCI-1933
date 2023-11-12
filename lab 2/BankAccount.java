import java.util.Scanner;
public class BankAccount {

   private String name;
   private String password;
   private double balance;

   public void withdraw(String enteredPassword, double amount) {

       if (password.equals(enteredPassword) && balance >= amount) {
           balance = balance - amount;
       }
   }

   public void deposit(String enteredPassword, double amount) {

       if (password.equals(enteredPassword)) {
           balance = balance + amount;
       }
   }

   public BankAccount(String initName, String initPass, double initBalance) {
       name = initName;
       password = initPass;
       balance = initBalance;
   }
       public void setName (String newName){
           name = newName;
       }
       public String getName () {
           return name;
       }
       public void setPass (String newPass){
           this.password = newPass;
       }
       public String getPass () {
           return password;
       }
       public void setBalance (double newAmount){
           this.balance = newAmount;
       }
       public double getBalance () {
           return balance;
       }

   public double getBalance(String enteredPassword) {
       if (password.equals(enteredPassword)) {
           return balance;
       } else {
           return -1;
       }
   }

   public boolean setPassword(String oldPassword, String newPassword) {
       if (password.equals(oldPassword)) {
           password = newPassword;
           return true;
       } else {
           return false;
       }
   }

   public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("myAccount", "22102003", 1000);
        BankAccount otherAccount = new BankAccount("otherAccount", "abc", 1000);
        myAccount.transfer(otherAccount, "22102003", 500);
        // myAccount.getBalance("22102003");
        // otherAccount.getBalancee("abc");
        System.out.println("Your balance is: " + myAccount.getBalance("22102003"));
        System.out.println("Your balance is: " + otherAccount.getBalance("abc"));

        
        // myAccount.deposit("22102003", 1000);
        // System.out.println("Enter your password");
        // Scanner myScanner = new Scanner(System.in);
        // String input = myScanner.nextLine();
        // if (input.equals(myAccount.password))
        // {
        //     System.out.println("Your balance is: " + myAccount.getBalance());
        // } else {
        //     System.out.println("Your balance is: -1");
        // }
    }

    public void transfer(BankAccount other, String enteredPassword, double amount){
        if (enteredPassword.equals(this.password)){
            Scanner other_scanner = new Scanner(System.in);
            String other_input = other_scanner.nextLine();
            if (other_input.equals(other.password)){
                other.deposit(other_input, amount);
                this.withdraw(enteredPassword, amount);
            }
        }
    }
}
