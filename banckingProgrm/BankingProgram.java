import  java.util.Scanner;
public class BankingProgram {
    static double balance=0;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        boolean isRunning=true;
        int choice;
        do{
        System.out.println("******************");
        System.out.println("BANKING PROGRAM");
        System.out.println("******************");
        System.out.println("1.  Show Balance");
        System.out.println("2.  Deposit");
        System.out.println("3.  Withdraw");
        System.out.println("4.  Exit");
        System.out.println("******************");

        System.out.print("Enter your choice (1-4): ");
        choice =scanner.nextInt();
        switch (choice){
            case 1 ->
                showBalance();
            case 2 ->{

                System.out.print("Enter the amount of deposit: ");
                double amount=scanner.nextDouble();
                if(amount<0){
                    System.out.println("Amount can't be negative");break;}
                deposit(amount);
                showBalance();
            }
            case 3 ->{
                System.out.print("Enter the amount of withdraw: ");
                double amount=scanner.nextDouble();
                if(amount>balance){
                    System.out.println("The amount of withdraw can't be more than balance");break;
                }
                if(amount<0){
                    System.out.println("The amount of withdraw can't be negative");break;
                }
                withdraw(amount);
                showBalance();
            }
            case 4 ->
                isRunning=false;
            default -> System.out.println("Invalid input");
        }}while(isRunning);

        System.out.println("THank you have nice day!");
        scanner.close();
    }

    static void showBalance(){
        System.out.printf("Your balanace is $%.2f\n",balance);
    }
    static void deposit(double amount){
        balance+=amount;
    }
    static void withdraw(double amount){
        balance-=amount;
    }
}