import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        String []choices={"rock","paper","scissors"};
        String playerChoice;
        String computerChoice;
        String playAgain="yes";
        while(playAgain.equals("yes")){
        System.out.print("Enter your move (rock,paer,scissors): ");
        playerChoice=scanner.nextLine().toLowerCase();

        if(!playerChoice.equals("rock")&&!playerChoice.equals("scissors")&&!playerChoice.equals("paper")){
            System.out.println("Invalid choice!!");
        }
        computerChoice=choices[random.nextInt(3)];
        System.out.println("computer choice "+computerChoice);
        if (playerChoice.equals(computerChoice)){
            System.out.println("It's a tie!");
        } else if ((playerChoice.equals("rock")&&computerChoice.equals("scissors"))||
                (playerChoice.equals("paper")&&computerChoice.equals("rock"))||
                (playerChoice.equals("scissors")&&computerChoice.equals("paper"))) {
            System.out.println("You win!");
        }else {
            System.out.println("You loose!");
        }
        System.out.print("Play again (yes/no): ");
        playAgain=scanner.nextLine().toLowerCase();
        }
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
