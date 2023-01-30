import java.util.Scanner;

class application{
    int amountss;
    String transactions;
    String name;
    int pin;
    
    public application(String yourname, int pin) {
        this.name= yourname;
        this.pin= pin;
        
    }
    public void deposi(int amount) {
        if(amount>0) {
            amountss=amountss+amount;
            transactions="\nadded:"+amount+"\n";
        }
        System.out.println("\n you added the amount "+amount);
        System.out.println("current balance is "+amountss+" rupees");
    }
    public void withdraw(int amount) {
        if(amount<=amountss) {
            amountss=amountss-amount;
            transactions+="\n you withdraw "+amount+"\n";
            System.out.println(amount+" withdraw completed ");
        }
        else {
            System.out.println("insufficient balance to withdraw "+amount);
        }
        System.out.println("current balance "+amountss+" rupees");
    }
    public void transhistory() {
        if(transactions!=null) {
            System.out.println("history");
            System.out.println("***********");
            System.out.println(transactions);
        }
        else {
            System.out.println("no history");
            System.out.println("*******************");
        }
        }
    public void transfer(int amount, String name) {
        if(amount>0&&name!=null) {
            amountss=amountss-amount;
            System.out.println("Amount of "+amount+" rupees is transfered to "+name);
        }
        System.out.println("Your current balance is "+amountss+" rupees");
        transactions+="\ntransfered "+amount+" to "+name+"\n";
    }
    public void displaydetails() {
        int choice;
        Scanner pr = new Scanner(System.in);
        System.out.println("welcome to the ATM");
        System.out.println("you pin is "+pin);
        
        System.out.println("1. Balance");
        System.out.println("2. Deposit");
        System.out.println("3. withdraw");
        System.out.println("4. transaction history");
        System.out.println("5. transfer");
        System.out.println("6. quit");
        
        do {
            System.out.println("enter an option\n");
            choice= pr.nextInt();
            System.out.println("\n");
            
            switch (choice) {
            case 1:
                System.out.println("balance "+amountss);
                System.out.println("\n");
                break;
                
            case 2:
                System.out.println("enter amount to deposit ");
                System.out.println("\n");
                int amount = pr.nextInt();
                deposi(amount);
                System.out.println("\n");
                break;
                
            case 3:
                System.out.println("enter amount to withdraw "+"\n");
                int amt1 = pr.nextInt();
                withdraw(amt1);
                System.out.println("\n");
                break;
                
            case 4:
                System.out.println("\n");
                transhistory();
                System.out.println("\n");
                break;
                
            case 5:
                System.out.println("enter the transfer amount");
                System.out.println("\n");
                int amt2 = pr.nextInt();
                System.out.println("enter the receiver ID");
                String rename = pr.next();
                transfer(amt2,rename);
                System.out.println("\n");
                break;
                
            case 6:
                System.out.println("########");
                break;
                
            default:
                System.out.println("Thanks You");
                break;
                
            }
            
        }while(choice!=6);
        
        System.out.println("thanks");

        
        
    }
}
public class ATM {
    public static void main(String[] args) {
        while(true) {
            Scanner pr = new Scanner(System.in);
            System.out.println("Enter the User id :-");
            String uname = pr.nextLine();
            
            if(uname == " ") {
                System.out.println("error found");
            }else {
                System.out.println("Enter your 4 digit pin "+" :");
                int pin = pr.nextInt();
                int len = (int) (Math.log10(pin)+1);
                if(len==4) {
                    application app = new application(uname, pin);
                    app.displaydetails();
                }
                else {
                    System.out.println("error for pin is not valid");
                }
            }
        }
    }
}