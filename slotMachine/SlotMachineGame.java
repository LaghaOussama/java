import java.util.Random;
import java.util.Scanner;

public class SlotMachineGame {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int balance=100;
        int bet;
        int payout;
        String [] row;
        String playAgain;

        System.out.println("*******************");
        System.out.println("   Slot Machine");
        System.out.println("*******************");
        System.out.println("Symbols: 🍒🍉🍋🔔⭐");
        System.out.println("*******************");

        while(balance>0){
            System.out.println("Current balanace: $"+balance);
            System.out.print("Place yout bet amount: ");
            bet= scanner.nextInt();
            scanner.nextLine();
            if (bet >balance){
                System.out.println("INSUFFICIENT FUNDS");
                continue;
            }else if(bet<=0){
                System.out.println("bet must be greater than 0");
                continue;
            }else {
                balance-=bet;
            }
            System.out.println("Spinning...");
            row=spinRow();
            printRow(row);
            payout=getPayout(row,bet);
            if(payout>0){
                System.out.println("You won $"+payout);
                balance+=payout;
            }else{
                System.out.println("Sorry you lost");
            }
            System.out.println("Plya again? (Y/N");
            playAgain=scanner.nextLine().toLowerCase();
            if(playAgain.equals("n")){
                break;
            }
        }
        System.out.println("Bye Bye Your final Balance £"+balance);
        scanner.close();
    }
    static String[] spinRow(){
        String[] symbols={"🍒","🍉","🍋","🔔","⭐"};
        String [] row =new String[3];
        Random random=new Random();

        for(int i=0;i<3;i++){
            row[i]=symbols[random.nextInt(symbols.length)];
        }
        return row;
    }
    static void printRow(String[] row){
        System.out.println(" "+ String.join(" | ",row));
    }
    static int getPayout(String[] row,int bet){
        if((row[0] .equals(row[1])) &&(row[0].equals( row[2]))){
        return switch(row[0]) {
            case "🍒" -> bet * 3;
            case "🍉" -> bet *4;
            case "🍋" -> bet * 5;
            case "🔔" -> bet * 10;
            case "⭐" ->bet * 20;
            default -> 0;
        };}
        else if((row[0] .equals(row[1]))){
            return switch(row[0]) {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" ->bet * 10;
                default -> 0;
            };}else if((row[1] .equals(row[2]))){
            return switch(row[1]) {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" ->bet * 10;
                default -> 0;
            };}
        return 0;
    }
}
