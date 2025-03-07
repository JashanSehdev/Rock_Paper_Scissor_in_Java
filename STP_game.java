package Rock_Paper_Scissor_in_Java;
import java.util.*;

public class STP_game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int looses=0;
        int wins = 0;
        int ties = 0;
        while(true){
           int c_value = computer();
           int u_value = user(sc);

           String c_chooses  = (c_value == 0)?"Rock": (c_value == 1)?"Paper":"Scissor";
           String s_chooses  = (u_value == 0)?"Rock": (u_value == 1)?"Paper":"Scissor";

           if(u_value==(-1)){ // to handle invalid input
            break;
           }

           String str = computer_wins( c_value,u_value); // processing the games

           switch (str) { //anouncing the result
            case "user loose": System.out.println("**Your "+s_chooses +" Lost by Computer's "+ c_chooses + " | You Looss**" );
                                looses++;
                                break;
            case "tie": System.out.println("**Its a Tie of " + c_chooses+"**");
                        ties++;
                        break;

            case "user_win":System.out.println("**Hurray! Your "+s_chooses+" Win by Computer's " + c_chooses +" | You Win**");
                            wins++;
                            break;
           }
           System.out.println();
        }
        System.out.println("Total wins : "+wins);
        System.out.println("Total looses : "+looses);
        System.out.println("Total ties : "+ties);
        sc.close();
       
    }

    public static int computer(){
        int random = (int)(Math.random() * 3);
        return random;
    }

    public static int user(Scanner sc){
        System.out.println("-->> Enter 0 for Rock, 1 for Paper, 2 for Scissors: ");
        int user = sc.nextInt();

        if(user>2 || user < 0)return -1; // handling invalid input
        return user;
    }
    public static String computer_wins(int c, int u){ //c for computer choice and u for user choice
        if(u == (c+2)%3) return "user loose";
        else if(u == c) return "tie";
        else return "user_win";
    }
}
