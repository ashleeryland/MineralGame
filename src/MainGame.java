/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
import sun.font.TrueTypeFont;

import java.util.Scanner;
public class MainGame
{

    private static final int NEW_GAME = 1;
    private static final String USERS_NAME = getUserName();
    private static final int END_GAME = 2;

    public static void main(String[] args) {
        showWelcome();
        showMenu();
        int choice = userMenuChoice();
        if (choice == NEW_GAME) {
            startNewGame();
        }

        if (choice == END_GAME)
            System.out.println("Good Bye!");
    }

    private static String getUserName() {
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.nextLine();
        return name;
    }

    private static void startNewGame()
    {
        int numPlayers = getNumPlayers();
        STCardGame game = new STCardGame(numPlayers);
        game.selectDealer();
        game.dealRandCardsToPlayers();
    }

    private static int getNumPlayers()
    {
        int numPlayers;
        Scanner input = new Scanner(System.in);
        System.out.print("Number of Players: ");
        numPlayers = input.nextInt();

        while (numPlayers <2 || numPlayers >6) {
            System.out.println("Invalid number of players. Must be 2 to 6 players");
            numPlayers= input.nextInt();
        }

        return numPlayers;
    }


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
        System.out.println("  * Start a new game    = 1");
        System.out.println("  * Exit game           = 2");
    }

    private static void showWelcome()
    {
        System.out.println("Welcome " + USERS_NAME + " to Super Trump Mineral Card Game! Lets begin!");
    }
}
