/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
import sun.font.TrueTypeFont;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class MainGame
{

    private static final int NEW_GAME = 1;
    private static final String USERS_NAME = getUserName();
    private static final int END_GAME = 2;

    private static int numPlayers;
    private static ArrayList<STPlayer> players;
    private static int dealerID;

    public static void main(String[] args) {
        STDeck deck = new STDeck();

        showWelcome();
        showMenu();
        int choice = userMenuChoice();
        if (choice == NEW_GAME) {

            startNewGame(deck);

        }


        if (choice == END_GAME) {
            System.out.println("Good Bye!");
            System.exit(0);
        }

        boolean gameOver = false;

        while(!gameOver){

        }


    }

    private static String getUserName() {
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.nextLine();
        return name;
    }

    //method to start a new game
    private static void startNewGame(STDeck deck)
    {

        int numPlayers = getNumPlayers();
        for(int i=0; i < numPlayers; i++){
            STPlayer newPlayer = new STPlayer();

            for(int j = 0; j<8; j++){
                newPlayer.getsCard(deck);
            }

            players.add(newPlayer);
        }
        dealerID = selectDealer(numPlayers);

    }


    public static int selectDealer(int numPlayers)
    {
        Random rand = new Random();
        int randomNum = rand.nextInt(numPlayers) + 1;
        dealerID = randomNum;

        if (dealerID == 1)
            System.out.println("You are the dealer");
        else
            System.out.println("Dealer is player " + dealerID);

        return dealerID;
    }

    //user selects amount of players. Must be between 3 and 6
    private static int getNumPlayers()
    {
        int numPlayers;
        Scanner input = new Scanner(System.in);
        System.out.print("Number of Players: ");
        numPlayers = input.nextInt();

        while (numPlayers <3 || numPlayers >6) {
            System.out.println("Invalid number of players. Must be 3 to 6 players");
            numPlayers= input.nextInt();
        }
        return numPlayers;
    }

    //users menu choice. Currently can only select 1 or 2 to start of exit game
    private static int userMenuChoice()
    {
        int menuChoice;
        Scanner input = new Scanner(System.in);
        menuChoice = input.nextInt();

        while (menuChoice <1 || menuChoice >2) {
            System.out.println("Invalid Choice. Please select either 1 or 2");
            menuChoice = input.nextInt();
        }
        return menuChoice;

    }


    private static void showMenu()
    {
        System.out.println("Game Menu:");
        System.out.println("  1 = Start a new game");
        System.out.println("  2 = Exit game");
    }

    private static void showWelcome()
    {
        System.out.println("Welcome " + USERS_NAME + " to Super Trump Mineral Card Game! Lets begin!");
    }
}
