import java.util.Scanner;

class Guesser{
    int Guessernum;

    // Number taken by guesser
    public int takeNumberGuesser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Guesser guess a number : ");
        Guessernum = scan.nextInt();
        return Guessernum;
    }
}
class Player{
    int Playernum;

    // numbers taken by players
    public int takeNumberPlayer(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Player guess a number : ");
        Playernum = scan.nextInt();
        return Playernum;
    }
}
class Umpire{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    // Collect number from guesser
    public void collectNumFromGuesser(){
        Guesser g = new Guesser();
        numFromGuesser = g.takeNumberGuesser();
    }

    // Collect number from all three player
    public void collectNumFromPlayer(){
        Player p1 = new Player();
        numFromPlayer1 = p1.takeNumberPlayer();

        Player p2 = new Player();
        numFromPlayer2 = p2.takeNumberPlayer();

        Player p3 = new Player();
        numFromPlayer3 = p3.takeNumberPlayer();
    }

    // Compare between the number of guesser and player
    public void compare(){
        System.out.println("Checking the numbers");
        System.out.println("And the player won are.....");
        
        if(numFromPlayer1 == numFromGuesser ){
            if(numFromPlayer2 == numFromGuesser && numFromPlayer3 == numFromGuesser){
                System.out.println("All Player won");
            }
            else if(numFromPlayer2==numFromGuesser){
                System.out.println("Only player 1 and 2 have won");
            }
            else if(numFromPlayer3==numFromGuesser){
                System.out.println("Only player 1 and 3 have won");
            }
            else{
                System.out.println("Only Player 1 has won");
            }
            
        }

        else if(numFromPlayer2 == numFromGuesser){
            if(numFromPlayer3 == numFromGuesser){
                System.out.println("Only Player 2 and 3 have won ");
            }
            else{
                System.out.println("Only player 2 has won");
            }
        }
        
        else if(numFromPlayer3 == numFromGuesser){
            System.out.println("Only Player 3 has won");
        }

        else{
            System.out.println("No Player has won the game");
        }
    }
}
public class GuessGameProject {
    public static void main(String[] args) {
        Umpire u = new Umpire();
        u.collectNumFromGuesser();
        u.collectNumFromPlayer();
        u.compare();
    }
}
